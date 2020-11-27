package com.huaxia.plaze.modules.pboc.adapter;

import java.io.UnsupportedEncodingException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.jws.WebService;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Node;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.huaxia.plaze.modules.pboc.service.BankService;
import com.huaxia.plaze.modules.pboc.service.BankTaskCallPlazeService;
import com.huaxia.plaze.modules.pboc.webservice.ReceiveSingleBank;
import com.huaxia.plaze.util.CommonUtil;
import com.huaxia.plaze.util.TaskParamUtil;
import com.huaxia.plaze.util.TaskStatusUtil;
import com.sun.org.apache.xml.internal.security.exceptions.Base64DecodingException;
import com.sun.org.apache.xml.internal.security.utils.Base64;

import net.sf.json.JSONObject;

@Service
@WebService(serviceName = "BankTaskReceiver", endpointInterface = "com.huaxia.plaze.modules.pboc.webservice.ReceiveSingleBank")
public class BankTaskReceiver implements ReceiveSingleBank {

	private final static Logger logger = LoggerFactory.getLogger(BankTaskReceiver.class);

	@Resource(name = "bankTaskCallPlazeService")
	private BankTaskCallPlazeService bankTaskCallPlazeService;

	@Resource(name = "bankService")
	private BankService bankService;

	@Override
	public String getResult(String json) {
		if (json == null || "".equals(json)) {
			if (logger.isWarnEnabled()) {
				logger.warn("bankFetResult 接收APS响应信息为空!!!");
			}
			return "failure";
		}
		if (logger.isInfoEnabled()) {
			logger.info("bankResponseJson:{}", json);
		}
		JSONObject responseObject = JSONObject.fromObject(json);
		if (responseObject.isNullObject() || responseObject.isEmpty()) {
			return "failure";
		}
		String BODY = responseObject.getString("body");
		String message = BODY.split("\r\n")[1];
		// --ceshi start
		Calendar calendar = Calendar.getInstance();
		int currHour = calendar.get(Calendar.HOUR_OF_DAY);
		int currMinute = calendar.get(Calendar.MINUTE);
		int currSecond = calendar.get(Calendar.SECOND);
		int currTimeSecondSum = (currHour * 3600) + (currMinute * 60) + currSecond;
		CommonUtil.downLoadMessageContent(message, TaskParamUtil.BANK_XML_PATH, currTimeSecondSum + "", null, ".xml",
				"人行信息");
		// -- ceshi end
		Document document = null;
		try {
			document = DocumentHelper.parseText(message);
		} catch (DocumentException e) {
			if (logger.isInfoEnabled()) {
				logger.info("bankDocumentException:{}", e);
			}
		}
		Node msgNode = document.selectSingleNode("/Document/Msg");
		if (msgNode == null) {
			return "failure";
		}
		// 查询结果代码
		Node resultCodeNode = msgNode.selectSingleNode("ResultCode");
		if (resultCodeNode != null) {
			String resultCode = resultCodeNode.getText();
			if (!"AAA000".equals(resultCode)) { // 处理失败
				if (logger.isInfoEnabled()) {
					logger.info("bankresultCodeError:{}", resultCode);
				}
				return "failure";
			}
		} else {
			return "failure";
		}
		// 信用报告内容 ReportMessage
		Node reportMessageNode = msgNode.selectSingleNode("ReportMessage");
		String reportMessage = "";
		if (reportMessageNode != null) {
			reportMessage = reportMessageNode.getText();
		} else {
			return "failure";
		}
		if ("".equals(reportMessage)) {
			return "failure";
		}
		String body = "";
		try {
			body = new String(Base64.decode(reportMessage), "UTF-8");
		} catch (UnsupportedEncodingException e2) {
			if (logger.isInfoEnabled()) {
				logger.info("bankBase64BodyException:{}", e2);
			}
		} catch (Base64DecodingException e2) {
			if (logger.isInfoEnabled()) {
				logger.info("bankBase64BodyException:{}", e2);
			}
		}
		if (body == null || "".equals(body)) {
			return "failure";
		}
		Document documentBody = null;
		try {
			documentBody = DocumentHelper.parseText(body);
		} catch (DocumentException e) {
			if (logger.isInfoEnabled()) {
				logger.info("bankDocumentBodyException:{}", e);
			}
		}
		Map<String, String> reqParam = getParamBank(documentBody);
		String uniqueRelid = "";// 每个身份证号码关联的唯一uuid值
		String identityNo = reqParam.get("idNo");// 身份证号
		String identityType = reqParam.get("idType");// 身份证类型
		String name = reqParam.get("name");// 姓名
		String source = "";
		String queryFlag = "0";
		String sourceId = "";
		List<Map<String, String>> taskMapList = bankTaskCallPlazeService.findBankParamList(identityNo, identityType,
				name, TaskStatusUtil.START);
		if (taskMapList != null && taskMapList.size() > 0) {
			for (Map<String, String> taskMap : taskMapList) {
				uniqueRelid = taskMap.get("UNIQUE_RELID");
				source = taskMap.get("SOURCE");
				queryFlag = taskMap.get("QUERY_FLAG");
				sourceId = taskMap.get("SOURCE_ID");
				boolean errorFlag = false;// 异常标志
				String oriUniqueRelid = bankService.findBankBodyOriginalUniqueRelid(uniqueRelid);// 报文表关联id是否存在
				if (oriUniqueRelid != null) { // 存在的话 不做入库操作
					if (logger.isInfoEnabled()) {
						logger.info(" oriUniqueRelidExist!! continue current circulation!! :{}", oriUniqueRelid);
					}
					continue;
				}
				try {
					bankService.saveBankControlLogic(uniqueRelid, sourceId, identityType, identityNo, name, queryFlag,
							source, body);
				} catch (Exception e) {
					if (logger.isInfoEnabled()) {
						logger.info("bankMessageError:" + identityNo + " uniqueRelid=" + uniqueRelid + " Exception:{}",
								e);
					}
					errorFlag = true;
				}
				String taskStatus = TaskStatusUtil.SUCCESS;
				if (errorFlag) { // 异常
					taskStatus = TaskStatusUtil.SAVE_ERROE;
				}
				try {
					bankTaskCallPlazeService.saveBankTaskPlazeHis(uniqueRelid);
					bankTaskCallPlazeService.updateBankTaskPlaze(uniqueRelid, taskStatus, TaskStatusUtil.START,
							TaskParamUtil.CURR_USER, null, null);
				} catch (Exception e) {
					if (logger.isInfoEnabled()) {
						logger.info("bankMessageUpdateError:" + identityNo + " uniqueRelid=" + uniqueRelid
								+ " Exception:{}", e);
					}
				}
			} // 循环结束
		}

		return "success";
	}

	/**
	 * @Title:getParamBank
	 * @Description:获取人行请求参数
	 * @param documentBody
	 * @return
	 * @author: gaohui
	 * @Date:2018年12月18日下午3:00:28
	 */
	private Map<String, String> getParamBank(Document documentBody) {
		Map<String, String> reqParam = new HashMap<String, String>();
		//// 1.1.1.2本次查询请求信息段 PA01B [1..1]
		Node pa01bNode = documentBody.selectSingleNode("/Document/PRH/PA01/PA01B");
		if (pa01bNode != null) {
			// 1.1.1.2.1 被查询者姓名 PA01BQ01 [1..1]
			Node PA01BQ01 = pa01bNode.selectSingleNode("PA01BQ01");
			if (PA01BQ01 != null) {
				reqParam.put("name", PA01BQ01.getText());
			}
			// 1.1.1.2.2 被查询者证件类型 PA01BD01 [1..1]
			Node PA01BD01 = pa01bNode.selectSingleNode("PA01BD01");
			if (PA01BD01 != null) {
				reqParam.put("idType", PA01BD01.getText());
			}
			// 1.1.1.2.3被查询者证件号码 PA01BI01 [1..1]
			Node PA01BI01 = pa01bNode.selectSingleNode("PA01BI01");
			if (PA01BI01 != null) {
				reqParam.put("idNo", PA01BI01.getText());
			}
			return reqParam;
		} else {
			return null;
		}
	}

}
