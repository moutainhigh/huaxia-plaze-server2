package com.huaxia.plaze.modules.bairong.webservice;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import javax.annotation.Resource;
import javax.jws.WebService;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.huaxia.opas.util.AppConfig;
import com.huaxia.plaze.common.MessageBuildUtil;
import com.huaxia.plaze.common.MessageParseUtil;
import com.huaxia.plaze.common.thread.MultiMessageWebService;
import com.huaxia.plaze.common.thread.MultiThreadHandler;
import com.huaxia.plaze.common.thread.TaskThread;
import com.huaxia.plaze.common.thread.handler.MultiParallelThreadHandler;
import com.huaxia.plaze.modules.bairong.adapter.ApplyLoanStrAdapter;
import com.huaxia.plaze.modules.bairong.domain.ApplyLoanStr;
import com.huaxia.plaze.modules.bairong.domain.ApplyLoanStrMsgResponse;
import com.huaxia.plaze.modules.bairong.domain.ApplyLoanStrTrnRequest;
import com.huaxia.plaze.modules.bairong.service.ApplyLoanStrService;
import com.huaxia.util.GuidUtil;

@Service
@WebService(serviceName = "WSB000700", endpointInterface = "com.huaxia.plaze.common.thread.MultiMessageWebService")
public class ApplyLoanStrMultiWebService implements MultiMessageWebService {
	
	protected final static Logger logger = LoggerFactory.getLogger(ApplyLoanStrMultiWebService.class);

	@Resource
	private ApplyLoanStrService applyLoanStrService;

	private static AppConfig appConfig = AppConfig.getInstance();

	@Override
	public List<String> invoke(List<String> jsonRequestList) throws InterruptedException, ExecutionException {
		//request入表
		List<String> tempList = new ArrayList<String>();
		for (String task : jsonRequestList) {
				// [1] 请求参数解析
				Map<String, String> requestArgs = MessageParseUtil.parseRequestMessage(task);

				// [3] 根据"查询模式"进行查询动作决策
				String queryMode = requestArgs.get("QUERY_MODE");
				// [2] 请求参数持久化
				saveRequestParams(requestArgs);
				// 重新组装发送的报文，添加用户名及密码。
				task = assembleRequestMessage(requestArgs);
				tempList.add(task);
		}
		jsonRequestList = tempList;
		MultiThreadHandler<String> handler = new MultiParallelThreadHandler();
		List<String> messages = handler.execute(jsonRequestList);
		new SaveData(messages).start();
		return messages;
	}
/**
 * 
 * @author liuwei 起个线程如响应表和解析入库,提高相应速度
 *
 */
class SaveData extends Thread{
	List<String> messages = null;
	public SaveData(List<String> messages){
		this.messages = messages;
	}
	@Override
	public void run(){
		for (String message : this.messages) {
			// 响应参数
			Map<String, String> responseArgs = new HashMap<String, String>();
			// 决策参数
			boolean decision = false;
			decision = StringUtils.isBlank(message);
			logger.info("百融批量多头借贷 决策路由 [ {} ]", new Object[] { (decision ? "无此数据" : "联机查询") });
			if (decision) {
			}  else {
				int result = 0;
				// 1.响应报文持久化
				responseArgs = MessageParseUtil.parseResponseMessage(message);
				result = saveResponseParams(responseArgs);
				if (result > 0) {
					logger.info("百融批量多头借贷响应报文持久化成功! 交易编号 [ {} ]",
							new Object[] { responseArgs.get("TRN_ID")});
				}

				// 2.响应数据持久化
				result = saveResponseData(responseArgs.get("RESPONSE_BODY"), responseArgs);
				if (result > 0) {
					logger.info("百融批量多头借贷应用数据持久化成功! 交易编号 [ {} ]",
							new Object[] { responseArgs.get("TRN_ID")});
				}
			}
		}
	}
}
	/**
	 * @Title: assembleBatchRequestMessage
	 * @Description: TODO
	 * @param requestArgs
	 * @return
	 * @author: LiuWei
	 * @Date: 2019年10月22日下午1:20:33
	 */
	private String assembleRequestMessage(Map<String, String> requestArgs) {
		// 联机批量请求
		if ("BATCH".equals(requestArgs.get("REQUEST_CHANNEL"))) {
			requestArgs.put("USERNAME", appConfig.getValue("bairong.dtjd.batch.userName"));
			requestArgs.put("PASSWORD", appConfig.getValue("bairong.dtjd.batch.password"));
			requestArgs.put("API_CODE", appConfig.getValue("bairong.dtjd.batch.apiCode"));
		} 
		// 联机单笔请求 + 联机渠道请求
		else {
			requestArgs.put("USERNAME", appConfig.getValue("bairong.dtjd.single.userName"));
			requestArgs.put("PASSWORD", appConfig.getValue("bairong.dtjd.single.password"));
			requestArgs.put("API_CODE", appConfig.getValue("bairong.dtjd.single.apiCode"));
		}
		return MessageBuildUtil.buildRequestMessage(requestArgs);
	}
	
	private void saveRequestParams(Map<String, String> requestArgs) {
		ApplyLoanStrTrnRequest applyLoanStrRequest = new ApplyLoanStrTrnRequest();
		applyLoanStrRequest.setUuid(GuidUtil.getGuid());
		applyLoanStrRequest.setCrtTime(new Date());
		applyLoanStrRequest.setCrtUser(requestArgs.get("REQUEST_CHANNEL"));
		applyLoanStrRequest.setTrnId(requestArgs.get("TRN_ID"));
		applyLoanStrRequest.setRequestChannel(requestArgs.get("REQUEST_CHANNEL"));
		applyLoanStrRequest.setQueryMode(requestArgs.get("QUERY_MODE"));
		applyLoanStrRequest.setCertType(requestArgs.get("CERT_TYPE"));
		applyLoanStrRequest.setCertNo(requestArgs.get("CERT_NO"));
		applyLoanStrRequest.setName(requestArgs.get("NAME"));
		applyLoanStrRequest.setMobile(requestArgs.get("MOBILE"));
		applyLoanStrRequest.setCradAccount(requestArgs.get("CARD_ACCOUNT"));
		if (StringUtils.isNotBlank(requestArgs.get("SEQUENCE"))) {
			applyLoanStrRequest.setSequence(Long.parseLong(requestArgs.get("SEQUENCE")));
		}
		applyLoanStrService.saveRequest(applyLoanStrRequest);
	}
	
	private int saveResponseParams(Map<String, String> responseArgs) {
		ApplyLoanStrMsgResponse applyLoanStrResponse = new ApplyLoanStrMsgResponse();
		applyLoanStrResponse.setCrtUser(responseArgs.get("RESPONSE_CHANNEL"));
		applyLoanStrResponse.setTrnId(responseArgs.get("TRN_ID"));
		applyLoanStrResponse.setMessageBody(responseArgs.get("RESPONSE_BODY"));
		return applyLoanStrService.saveResponse(applyLoanStrResponse);
	}
	

	private int saveResponseData(String responseMessage, Map<String, String> responseArgs) {
		Map<String, Object> params = new HashMap<String, Object>();
		ApplyLoanStrTrnRequest request = applyLoanStrService.queryRequest(responseArgs.get("TRN_ID"));
		params.put("message", responseMessage);
		params.put("name", request.getName());
		params.put("crtNo", request.getCertNo());
		params.put("mobile", request.getMobile());
		params.put("crtUser", request.getCrtUser());
		params.put("trnId", request.getTrnId());
		params.put("cardAccount",request.getCradAccount());
		params.put("sequence", request.getSequence().toString());
		ApplyLoanStr applyLoanStr = ApplyLoanStrAdapter.parseApplyLoanStr(params);
		return applyLoanStrService.saveApplyLoanStr(applyLoanStr);
	}
}
