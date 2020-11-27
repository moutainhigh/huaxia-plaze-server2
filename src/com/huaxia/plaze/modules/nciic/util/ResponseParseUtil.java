package com.huaxia.plaze.modules.nciic.util;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Node;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.huaxia.plaze.modules.nciic.domain.NciicInfo;

/**
 * 简项公安返回参数解析工具类
 */
public class ResponseParseUtil {
	
	private final static Logger logger = LoggerFactory.getLogger(ResponseParseUtil.class);


	public static boolean parsingArguments(String parameter) {
		String responseCode = "";
		if (StringUtils.isNotBlank(parameter)) {
			JSONObject jsonResponse = JSON.parseObject(parameter);
			if (jsonResponse.containsKey("RESPONSE") && jsonResponse.getString("RESPONSE") != null
					&& !"".equals(jsonResponse.getString("RESPONSE"))) {
				JSONObject jsonRes = JSON.parseObject(jsonResponse.getString("RESPONSE"));

				if (jsonRes.containsKey("BODY") && jsonRes.getString("BODY") != null
						&& !"".equals(jsonRes.getString("BODY"))) {
					JSONObject jsonBody = JSON.parseObject(jsonRes.getString("BODY"));
					if (jsonBody.containsKey("RESPONSE_CODE") && jsonBody.getString("RESPONSE_CODE") != null
							&& !"".equals(jsonBody.getString("RESPONSE_CODE"))) {
						responseCode = jsonBody.getString("RESPONSE_CODE");
					}
					if (jsonBody.containsKey("RESPONSE_DESC") && jsonBody.getString("RESPONSE_DESC") != null
							&& !"".equals(jsonBody.getString("RESPONSE_DESC"))) {
						responseCode = jsonBody.getString("RESPONSE_CODE");
					}
				}

			}
		}
		if ("000000".equals(responseCode)) {
			return true;
		}
		return false;
	}

	public static NciicInfo parsingResult(String parameter) throws Exception {
		NciicInfo nciicInfo= new NciicInfo();

		if (parameter != null) {
			String bodyStr = "";
			// 分解返回参数参数
			JSONObject jsonResponse = JSON.parseObject(parameter);
			if (jsonResponse.containsKey("RESPONSE") && jsonResponse.getString("RESPONSE") != null
					&& !"".equals(jsonResponse.getString("RESPONSE"))) {
				JSONObject jsonRes = JSON.parseObject(jsonResponse.getString("RESPONSE"));

				if (jsonRes.containsKey("HEAD") && jsonRes.getString("HEAD") != null
						&& !"".equals(jsonRes.getString("HEAD"))) {
					JSONObject jsonHead = JSON.parseObject(jsonRes.getString("HEAD"));
					if (jsonHead.containsKey("TRN_ID") && jsonHead.getString("TRN_ID") != null
							&& !"".equals(jsonHead.getString("TRN_ID"))) {
						nciicInfo.setTrnId(jsonHead.getString("TRN_ID"));
					}
				}

				if (jsonRes.containsKey("BODY")) {
					JSONObject jsonBody = JSON.parseObject(jsonRes.getString("BODY"));
					if (jsonBody.containsKey("RESPONSE_BODY") && jsonBody.getString("RESPONSE_BODY") != null
							&& !"".equals(jsonBody.getString("RESPONSE_BODY"))) {
						bodyStr = jsonBody.getString("RESPONSE_BODY");
						System.out.println("======================bodyStr=" + bodyStr + "=========================");
						nciicInfo.setBodyStr(bodyStr);
						nciicInfo =parse(bodyStr,nciicInfo);
						
					}
				}

			}
			return nciicInfo;

		}
		return null;
	}
	
	public static NciicInfo parse(String message,NciicInfo police) throws Exception {
		if (message == null || "".equals(message)) {
			return null;
			//throw new IllegalArgumentException("简项公安报文为空");
		}

		if (logger.isDebugEnabled()) {
			logger.debug("[公安数据解析] 原始报文：{}", message);
		}

		message = message.replace("<ITEM>", "").replace("</ITEM>", "").replace("<RT>", "").replace("</RT>", "");

		if (logger.isDebugEnabled()) {
			logger.debug("[公安数据解析] 格式化报文：{}", message);
		}

		Document document = null;
		try {
			document = DocumentHelper.parseText(message);
		} catch (Exception e) {
			if (logger.isErrorEnabled()) {
				logger.error("[公安数据解析] 构建XML解析异常：{}", e.getMessage());
			}
			e.printStackTrace();
			return null;
		}

		Node ROW = document.selectSingleNode("/ROWS/ROW");
		if (ROW != null) {

			// 验证响应报文是否异常？
			// 错误代码
			Node errorCodeNode = ROW.selectSingleNode("ErrorCode");
			if (errorCodeNode != null) {
				police.setErrorCode(errorCodeNode.getText());

				// 错误描述
				Node errorMsgNode = ROW.selectSingleNode("ErrorMsg");
				police.setErrorMessage(errorMsgNode.getText());

				return police;
			}

			// 解析INPUT节点
			doInputWalk(ROW, police);

			// 解析OUTPUT节点
			doOutputWalk(ROW, police);

			return police;
		}

		return null;
	}
	
	private static void doOutputWalk(Node ROW, NciicInfo police) {
		Node outputNode = ROW.selectSingleNode("OUTPUT");
		if (outputNode != null) {
			Node xNode = null;

			// xNode = outputNode.selectSingleNode("gmsfhm");
			// if (xNode != null) {
			// police.setGmsfhm(xNode.getText());
			// }

			xNode = outputNode.selectSingleNode("result_gmsfhm");
			if (xNode != null) {
				police.setGmsfhmResult(xNode.getText());
			}

			// xNode = outputNode.selectSingleNode("xm");
			// if (xNode != null) {
			// police.setXm(xNode.getText());
			// }

			xNode = outputNode.selectSingleNode("result_xm");
			if (xNode != null) {
				police.setXmResult(xNode.getText());
			}

			xNode = outputNode.selectSingleNode("xp");
			if (xNode != null) {
				police.setXp(xNode.getText());
			}

			xNode = outputNode.selectSingleNode("errormesage");
			if (xNode != null) {
				police.setErrorMessage(xNode.getText());
			}

			xNode = outputNode.selectSingleNode("errormesagecol");
			if (xNode != null) {
				police.setErrorMessageCol(xNode.getText());
			}

			xNode = null;
		}
	}

	private static void doInputWalk(Node ROW, NciicInfo police) {
		Node inputNode = ROW.selectSingleNode("INPUT");
		if (inputNode != null) {
			Node xNode = null;

			xNode = inputNode.selectSingleNode("gmsfhm");
			if (xNode != null) {
				police.setGmsfhm(xNode.getText());
			}

			xNode = inputNode.selectSingleNode("xm");
			if (xNode != null) {
				police.setXm(xNode.getText());
			}

			xNode = null;
		}
	}
	public static void main(String[] args) {

		String returnStr = "{\"data\":{\"result\":\"一致\",\"resultCode\":0},\"isSuccess\":true,\"msgKey\":\"kQraOtn9j0jwxsSN\",\"responseCode\":\"E00000000\",\"responseDesc\":\"响应成功！\"}";
		if (StringUtils.isNotBlank(returnStr)) {
			// 连接字符串，实现数据库的查询和实现
			Map<String, Object> head = new HashMap<String, Object>();
			head.put("REQUEST_SYSTEM", "PLAZE");
			head.put("TRN_ID", "11111");

			Map<String, Object> body = new HashMap<String, Object>();
			body.put("RESPONSE_CODE", "E000000");
			body.put("RESPONSE_DESC", "响应成功");
			body.put("RESULT_DESC", String.valueOf(returnStr));

			Map<String, Object> response = new HashMap<String, Object>();
			response.put("HEAD", head);
			response.put("BODY", body);

			Map<String, Object> params = new HashMap<String, Object>();
			params.put("RESPONSE", response);

			JSONObject jsonStr = new JSONObject(params);
			System.out.println("===================返回参数=============================");
			System.out.println(JSON.toJSONString(jsonStr));
			// HarMoblResponse test=parsingResult(jsonStr.toString());
			// System.out.println(test);

		}
	}
}
