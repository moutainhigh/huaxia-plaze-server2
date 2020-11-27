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
import com.huaxia.plaze.modules.nciic.domain.NciicXpInfo;

/**
 * 公安人像比对 响应报文解析工具类
 * 
 * @author User
 *
 */
public class PoliceResponseParseUtil {

	private static final Logger logger = LoggerFactory.getLogger(PoliceResponseParseUtil.class);

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
	 * 公安人像比对 解析响应报文
	 * 
	 * @param resultStr
	 * @return
	 */
	public static NciicXpInfo parseResult(String resultStr) {
		NciicXpInfo xpInfo = new NciicXpInfo();
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
						xpInfo.setTrnId(jsonHead.getString("TRN_ID"));
					}
				}

				if (jsonRes.containsKey("BODY")) {
					JSONObject jsonBody = JSON.parseObject(jsonRes.getString("BODY"));
					if (jsonBody.containsKey("RESPONSE_BODY") && jsonBody.getString("RESPONSE_BODY") != null
							&& !"".equals(jsonBody.getString("RESPONSE_BODY"))) {
						bodyStr = jsonBody.getString("RESPONSE_BODY");
						logger.info("人像比对响应的原始报文：" + bodyStr);
						xpInfo.setBodyStr(bodyStr);
						xpInfo = parse(bodyStr, xpInfo);

					}
				}

			}
			return xpInfo;
		} catch (Exception e) {
			logger.error("【公安人像比对】解析报文出错{}", e);
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
	private static NciicXpInfo parse(String bodyStr, NciicXpInfo xpInfo) {
		if (StringUtils.isBlank(bodyStr)) {
			return null;
		}
		Document document = null;

		try {
			document = DocumentHelper.parseText(bodyStr);
		} catch (DocumentException e) {
			logger.error("【人像比对】构建xml出错{}", e);
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
					// 错误描述
					Node errorMsgNode = responseRow.selectSingleNode("ErrorMsg");
					String errorMsg = errorMsgNode.getText();
					if (logger.isInfoEnabled()) {
						logger.info(" 人像比对错误信息 ,message:{}", "ErrorCode:" + errorCode + " ErrorMsg:" + errorMsg);
					}
					return null;
				}
			}

			Node ROW = document.selectSingleNode("/ROWS/ROW");
			if (ROW != null) {

				// 解析INPUT节点
				doInputWalk(ROW, xpInfo);

				// 解析OUTPUT节点
				doOutputWalkPoc(ROW, xpInfo);

				return xpInfo;
			}
		} catch (Exception e) {
			logger.error("【人像比对】解析原始报文时出错：", e.getMessage());
			e.printStackTrace();
		}
		return null;
	}

	private static void doOutputWalkPoc(Node ROW, NciicXpInfo police) {
		Node outputNode = ROW.selectSingleNode("OUTPUT");
		if (outputNode != null) {
			Node xNode = null;
			@SuppressWarnings("unchecked")
			List<Element> itemList = outputNode.selectNodes("ITEM");
			if (itemList != null && itemList.size() > 0) {
				int itemSize = itemList.size();
				if (itemSize >= 2) {

					Element item0 = itemList.get(0);
					if (item0 != null) {
						xNode = item0.selectSingleNode("result_gmsfhm");// 公民身份号码核查结果
						if (xNode != null) {
							police.setGmsfhmResult(xNode.getText());
						}
						xNode = item0.selectSingleNode("errormesage");
						if (xNode != null) {
							police.setErrorMessage(xNode.getText());
						}
					}

					Element item1 = itemList.get(1);
					if (item1 != null) {
						xNode = item1.selectSingleNode("result_xm");// 姓名比对结果
						if (xNode != null) {
							police.setXmResult(xNode.getText());
						}
						xNode = item1.selectSingleNode("errormesagecol");
						if (xNode != null) {
							police.setErrorMessageCol(xNode.getText());
						}
					}
				}

				if (itemSize >= 3) {
					Element item2 = itemList.get(2);
					if (item2 != null) {
						xNode = item2.selectSingleNode("xp");
						if (xNode != null) {
							police.setXp(xNode.getText());
						}
						xNode = item2.selectSingleNode("result_fx");// 系统分析结果
						if (xNode != null) {
							police.setResultFx(xNode.getText());
						}
						xNode = item2.selectSingleNode("result_fs");// 比对分数
						if (xNode != null) {
							police.setResultFs(xNode.getText());
						}
					}
				}

			}
			xNode = null;
		}
	}

	private static void doInputWalk(Node ROW, NciicXpInfo police) {
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
}
