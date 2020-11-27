package com.huaxia.plaze.modules.nciic.util;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.Node;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.huaxia.plaze.modules.nciic.domain.NciicForeignerInfo;

/**
 * 外国人永久居留证 响应报文解析工具类
 * 
 * @author User
 *
 */
public class ForeignerResponseParseUtil {

	private static final Logger logger = LoggerFactory.getLogger(ForeignerResponseParseUtil.class);

	/**
	 * 判断响应成功或失败
	 * 
	 * @param parameter
	 * @return
	 */
	public static boolean checkResponseCode(String parameter) {
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

	/**
	 * 外国人永久居留证信息 解析响应报文
	 * 
	 * @param resultStr
	 * @return
	 */
	public static NciicForeignerInfo parseResult(String resultStr,String certType) {
		NciicForeignerInfo nciicForeignerInfo = new NciicForeignerInfo();
		// 原始报文
		String bodyStr = "";
		try {
			// 解析返回响应报文
			JSONObject jsonResponse = JSON.parseObject(resultStr);
			if (jsonResponse.containsKey("RESPONSE") && jsonResponse.getString("RESPONSE") != null
					&& !"".equals(jsonResponse.getString("RESPONSE"))) {
				JSONObject jsonRes = JSON.parseObject(jsonResponse.getString("RESPONSE"));

				if (jsonRes.containsKey("HEAD") && jsonRes.getString("HEAD") != null
						&& !"".equals(jsonRes.getString("HEAD"))) {
					JSONObject jsonHead = JSON.parseObject(jsonRes.getString("HEAD"));
					if (jsonHead.containsKey("TRN_ID") && jsonHead.getString("TRN_ID") != null
							&& !"".equals(jsonHead.getString("TRN_ID"))) {
						nciicForeignerInfo.setTrnId(jsonHead.getString("TRN_ID"));
					}
				}
				if (jsonRes.containsKey("BODY")) {
					JSONObject jsonBody = JSON.parseObject(jsonRes.getString("BODY"));
					if (jsonBody.containsKey("RESPONSE_BODY") && jsonBody.getString("RESPONSE_BODY") != null
							&& !"".equals(jsonBody.getString("RESPONSE_BODY"))) {
						bodyStr = jsonBody.getString("RESPONSE_BODY");
						logger.info("外国人永久居留证响应的原始报文：" + bodyStr);
						nciicForeignerInfo.setBodyStr(bodyStr);
						nciicForeignerInfo = parse(bodyStr, nciicForeignerInfo,certType);
					}
				}

			}
			return nciicForeignerInfo;
		} catch (Exception e) {
			logger.error("【外国人永久居留证】解析报文出错{}", e);
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 解析原始报文
	 * 
	 * @param bodyStr
	 * @param xpInfo
	 * @return
	 */
	private static NciicForeignerInfo parse(String bodyStr, NciicForeignerInfo nciicForeignerInfo,String certType) {
		if (StringUtils.isBlank(bodyStr)) {
			return null;
		}
		Document document = null;

		try {
			document = DocumentHelper.parseText(bodyStr);
		} catch (DocumentException e) {
			logger.error("【外国人永久居留证】构建xml出错{}", e);
			e.printStackTrace();
			return null;
		}
		try {
			Node responseRow = document.selectSingleNode("/RESPONSE/ROWS/ROW");
			if (responseRow != null) {
				// 验证响应报文是否异常？
				// 错误代码
				Node errorCodeNode = responseRow.selectSingleNode("ErrorCode");
				if (errorCodeNode != null) {
					String errorCode = errorCodeNode.getText();
					nciicForeignerInfo.setErrorCode(errorCode);
					// 错误描述
					Node errorMsgNode = responseRow.selectSingleNode("ErrorMsg");
					String errorMsg = errorMsgNode.getText();
					nciicForeignerInfo.setErrorMessage(errorMsg);
					if (logger.isInfoEnabled()) {
						logger.info(" 外国人永久居留证错误信息 ,message:{}", "ErrorCode:" + errorCode + " ErrorMsg:" + errorMsg);
					}
					return nciicForeignerInfo;
				}
			}

			Node ROW = document.selectSingleNode("/ROWS/ROW");
			if (ROW != null) {

				// 解析INPUT节点
				doInputWalk(ROW, nciicForeignerInfo);

				// 解析OUTPUT节点
				doOutputWalkPoc(ROW, nciicForeignerInfo);

				return nciicForeignerInfo;
			}
		} catch (Exception e) {
			logger.error("【外国人永久居留证】解析原始报文时出错：", e.getMessage());
			e.printStackTrace();
		}
		return null;
	}

	private static void doOutputWalkPoc(Node ROW, NciicForeignerInfo nciicForeignerInfo) {
		Node outputNode = ROW.selectSingleNode("OUTPUT");
		if (outputNode != null) {
			Node xNode = null;
			 xNode = outputNode.selectSingleNode("result_code");
			 if (xNode != null) {
					nciicForeignerInfo.setResultCode(xNode.getText());
			}
			@SuppressWarnings("unchecked")
			List<Element> itemList = outputNode.selectNodes("ITEM");
			if (itemList != null && itemList.size() > 0) {
				Element item0 = itemList.get(0);
				if (item0 != null) {
					xNode = item0.selectSingleNode("errormesage");
					if (xNode != null) {
						nciicForeignerInfo.setErrorMessage(xNode.getText());
					}
				}
				
				Element item1 = itemList.get(1);
				if (item1 != null) {
					xNode = item1.selectSingleNode("errormesagecol");
					if (xNode != null) {
						nciicForeignerInfo.setErrorMessageCol(xNode.getText());
					}
				}
			}
			xNode = null;
		}
	}

	private static void doInputWalk(Node ROW, NciicForeignerInfo nciicForeignerInfo) {
		Node inputNode = ROW.selectSingleNode("INPUT");
		if (inputNode != null) {
			Node xNode = null;
			xNode = inputNode.selectSingleNode("zjhm");
			if (xNode != null) {
				nciicForeignerInfo.setZjhm(xNode.getText());
			}
			xNode = inputNode.selectSingleNode("ywxm");
			if (xNode != null) {
				nciicForeignerInfo.setXm(xNode.getText());
			}
			xNode = inputNode.selectSingleNode("csrq");
			if (xNode != null) {
				nciicForeignerInfo.setCsrq(xNode.getText());
			}
			xNode = inputNode.selectSingleNode("zjyxqz");
			if (xNode != null) {
				nciicForeignerInfo.setZjyxqr(xNode.getText());
			}
			xNode = null;
		}
	}
}
