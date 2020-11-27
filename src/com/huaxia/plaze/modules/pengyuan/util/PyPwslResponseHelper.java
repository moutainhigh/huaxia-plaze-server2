package com.huaxia.plaze.modules.pengyuan.util;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.huaxia.plaze.modules.pengyuan.domain.PyPwslCrs;
import com.huaxia.plaze.modules.pengyuan.domain.PyPwslCrsCrt;
import com.huaxia.plaze.modules.pengyuan.domain.PyPwslCrsCrtCollection;
import com.huaxia.plaze.modules.pengyuan.domain.PyPwslCrsCrtPwls;
import com.huaxia.plaze.modules.pengyuan.domain.PyPwslCrsCrtPwlsItm;
import com.huaxia.plaze.modules.pengyuan.domain.PyPwslCrsCrtQcs;
import com.huaxia.plaze.modules.pengyuan.domain.PyPwslResponse;
import com.huaxia.plaze.modules.yilianzhong.util.ErrorCode;

public class PyPwslResponseHelper {

	private final static Logger logger = LoggerFactory.getLogger(PyPwslResponseHelper.class);

	private static Document doc;

	private static PyPwslCrs pyPwslCrs;

	private static PyPwslCrsCrt pyPwslCrsCrt;

	private static PyPwslCrsCrtPwls pyPwslCrsCrtPwls;

	private static PyPwslCrsCrtPwlsItm pyPwslCrsCrtPwlsItm;

	private static List<PyPwslCrsCrtQcs> pyPwslCrsCrtQcsList;

	private static PyPwslResponse pyPwslResponse;

	private static String trnId;

	private static String bodyStr;

	private PyPwslResponseHelper() {

	}

	public static String getQueryModel2Response(String messageBody, String trnId) {
		if (StringUtils.isNotBlank(messageBody)) {
			String bodyStr = "";
			// 连接字符串，实现数据库的查询和实现
			Map<String, Object> head = new HashMap<String, Object>();
			head.put("REQUEST_SYSTEM", "PLAZE");
			head.put("TRN_ID", trnId);

			Map<String, Object> body = new HashMap<String, Object>();
			body.put("RESPONSE_CODE", ErrorCode.OK.getCode());
			body.put("RESPONSE_DESC", ErrorCode.OK.getDescription());
			body.put("RESPONSE_BODY", String.valueOf(messageBody));

			Map<String, Object> response = new HashMap<String, Object>();
			response.put("HEAD", head);
			response.put("BODY", body);

			Map<String, Object> params = new HashMap<String, Object>();
			params.put("RESPONSE", response);

			JSONObject jsonStr = new JSONObject(params);
			return JSON.toJSONString(jsonStr);
		}
		return null;
	}

	public static PyPwslResponse getQueryModel1Response(String repString, String appId,String crtUser) {
		if (StringUtils.isNotBlank(repString)) {

			pyPwslResponse = new PyPwslResponse();
			try {
				JSONObject jsonResponse = JSON.parseObject(repString);
				if (jsonResponse.containsKey("RESPONSE") && jsonResponse.getString("RESPONSE") != null
						&& !"".equals(jsonResponse.getString("RESPONSE"))) {
					JSONObject jsonRes = JSON.parseObject(jsonResponse.getString("RESPONSE"));

					if (jsonRes.containsKey("HEAD") && jsonRes.getString("HEAD") != null
							&& !"".equals(jsonRes.getString("HEAD"))) {
						JSONObject jsonHead = JSON.parseObject(jsonRes.getString("HEAD"));
						if (jsonHead.containsKey("TRN_ID") && jsonHead.getString("TRN_ID") != null
								&& !"".equals(jsonHead.getString("TRN_ID"))) {
							trnId = jsonHead.getString("TRN_ID");
						} else {
							return null;
						}
					}

					if (jsonRes.containsKey("BODY") && jsonRes.getString("BODY") != null
							&& !"".equals(jsonRes.getString("BODY"))) {
						JSONObject jsonBody = JSON.parseObject(jsonRes.getString("BODY"));
						if (jsonBody.containsKey("RESPONSE_CODE") && jsonBody.getString("RESPONSE_CODE") != null
								&& !"".equals(jsonBody.getString("RESPONSE_CODE"))) {
							String responseCode = jsonBody.getString("RESPONSE_CODE");
							// 判断是否返回成功
							if ((ErrorCode.OK.getCode()).equals(responseCode)) {
								if (jsonBody.containsKey("RESPONSE_BODY") && jsonBody.getString("RESPONSE_BODY") != null
										&& !"".equals(jsonBody.getString("RESPONSE_BODY"))) {
									bodyStr = jsonBody.getString("RESPONSE_BODY");
									// 解析xml文档
									return readStringXml(bodyStr, appId,crtUser);
								}

							} else {
								// 请求dmz失败
								return null;
							}
						}
					}

				}
			} catch (Exception e) {
				logger.error("[区域数据-深圳-鹏元-个人高信分] 返回报文解析异常");
				e.printStackTrace();
				return null;
			}
		}
		return null;
	}

	/**
	 * 
	 * 解析xml字符串文档
	 * 
	 * @param xmlStr
	 * @return
	 */
	public static PyPwslResponse readStringXml(String xmlStr, String appId,String CRT_USER) {
		if (StringUtils.isNotBlank(xmlStr)) {
			try {
				// 将字符串转换为XML
				doc = DocumentHelper.parseText(xmlStr);
			} catch (DocumentException e) {
				logger.error("[区域数据-深圳-鹏元-个人高信分],返回报文解析异常,字符串转XML失败. xml={}", xmlStr);
				e.printStackTrace();
			}
			// 获取根节点
			Element cisReports = doc.getRootElement();
			if ("cisReports".equals(cisReports.getName())) {
				if (cisReports != null) {
					pyPwslResponse=new PyPwslResponse();
					pyPwslCrsCrtQcsList=new Vector<>();
					// 获取跟节点标签属性
					pyPwslCrs = new PyPwslCrs();
					pyPwslCrs.setTrnId(trnId);
					pyPwslCrs.setCrtUser(CRT_USER);
					pyPwslCrs.setBatchNo(cisReports.attribute("batNo").getValue());
					pyPwslCrs.setUnitName(cisReports.attribute("unitName").getValue());
					pyPwslCrs.setSubOrgan(cisReports.attribute("subOrgan").getValue());
					pyPwslCrs.setQueryUserId(cisReports.attribute("queryUserID").getValue());
					pyPwslCrs.setQueryCount(Integer.parseInt(cisReports.attribute("queryCount").getValue()));
					pyPwslCrs.setReceiveTime(cisReports.attribute("receiveTime").getValue());
					pyPwslCrs.setAppId(appId);
					pyPwslResponse.setPyPwslCrs(pyPwslCrs);
					// 获取根节点下子节点cisReport
					List<Element> cisReportList = cisReports.elements("cisReport");
					if (cisReportList != null && cisReportList.size() > 0) {
						List<PyPwslCrsCrtCollection> pyPwslCrsCrtCollectionList = new Vector<>();
						for (Element cisReportItem : cisReportList) {
							if (cisReportItem != null) {
								pyPwslCrsCrt = new PyPwslCrsCrt();
								pyPwslCrsCrt.setTrnId(trnId);
								pyPwslCrsCrt.setCrtUser(CRT_USER);
								pyPwslCrsCrt.setReportId(cisReportItem.attribute("reportID").getValue());
								pyPwslCrsCrt.setBuildEnTIme(cisReportItem.attribute("buildEndTime").getValue());
								pyPwslCrsCrt.setQueryReasonId(
										Integer.parseInt(cisReportItem.attribute("queryReasonID").getValue()));
								pyPwslCrsCrt.setSubReportTypes(cisReportItem.attribute("subReportTypes").getValue());
								pyPwslCrsCrt.setTreatResult(cisReportItem.attribute("treatResult").getValue());
								pyPwslCrsCrt.setSubReportTypesShortCaption(
										cisReportItem.attribute("subReportTypesShortCaption").getValue());
								
//								pyPwslCrsCrt.setRefId(cisReportItem.attribute("refID").getValue());
								pyPwslCrsCrt.setHasSystemError(cisReportItem.attribute("hasSystemError").getValue());
								pyPwslCrsCrt.setIsFrozen(cisReportItem.attribute("isFrozen").getValue());
								pyPwslCrsCrt.setAppId(appId);
								// 获取查询条件信息节点
								Element pyPwslCrsCrtQcsElement = cisReportItem.element("queryConditions");
								if(pyPwslCrsCrtQcsElement!=null){
									List<Element> pyPwslCrsCrtQcsElements=pyPwslCrsCrtQcsElement.elements("item");
									if(pyPwslCrsCrtQcsElements!=null &&pyPwslCrsCrtQcsElements.size()>0){
										for(Element qcsItem:pyPwslCrsCrtQcsElements){
											PyPwslCrsCrtQcs pyPwslCrsCrtQcs = new PyPwslCrsCrtQcs();
											pyPwslCrsCrtQcs.setTrnId(trnId);
											pyPwslCrsCrtQcs.setCrtUser(CRT_USER);
											pyPwslCrsCrtQcs.setName(qcsItem.elementText("name"));
											pyPwslCrsCrtQcs.setCaption(qcsItem.elementText("caption"));
											pyPwslCrsCrtQcs.setConditionValue(qcsItem.elementText("value"));
											pyPwslCrsCrtQcs.setAppId(appId);
											pyPwslCrsCrtQcsList.add(pyPwslCrsCrtQcs);
										}
									}
								}
								
								// 获取信息标签属性
								Element personWhiteListScore = cisReportItem.element("personWhiteListScore");
								if (personWhiteListScore != null) {
									pyPwslCrsCrtPwls = new PyPwslCrsCrtPwls();
									pyPwslCrsCrtPwls.setTrnId(trnId);
									pyPwslCrsCrtPwls.setCrtUser(CRT_USER);
									pyPwslCrsCrtPwls.setSubReportType(Integer
											.parseInt(personWhiteListScore.attribute("subReportType").getValue()));
									pyPwslCrsCrtPwls.setSubReportCost(Integer
											.parseInt(personWhiteListScore.attribute("subReportTypeCost").getValue()));
									pyPwslCrsCrtPwls.setTreatResult(
											Integer.parseInt(personWhiteListScore.attribute("treatResult").getValue()));
									if (personWhiteListScore.attribute("treatErrorCode") != null) {
										pyPwslCrsCrtPwls.setTreatErrorCode(
												personWhiteListScore.attribute("treatErrorCode").getValue());
									}
									pyPwslCrsCrtPwls
											.setErrorMessage(personWhiteListScore.attribute("errorMessage").getValue());
									pyPwslCrsCrtPwls.setAppId(appId);
									// 获取信息标签下的内容
									pyPwslCrsCrtPwlsItm = new PyPwslCrsCrtPwlsItm();
									pyPwslCrsCrtPwlsItm.setTrnId(trnId);
									pyPwslCrsCrtPwlsItm.setCrtUser(CRT_USER);
									pyPwslCrsCrtPwlsItm.setScore(personWhiteListScore.elementText("score"));
									pyPwslCrsCrtPwlsItm.setGrade(personWhiteListScore.elementText("grade"));
									pyPwslCrsCrtPwlsItm.setAdvice(personWhiteListScore.elementText("advice"));
									pyPwslCrsCrtPwlsItm.setLabel(personWhiteListScore.elementText("label"));
									pyPwslCrsCrtPwlsItm.setAppId(appId);
									if (StringUtils.isBlank(personWhiteListScore.elementText("score"))
											&& StringUtils.isBlank(personWhiteListScore.elementText("grade"))
											&& StringUtils.isBlank(personWhiteListScore.elementText("advice"))
											&& StringUtils.isBlank(personWhiteListScore.elementText("label"))) {
										pyPwslCrsCrtPwlsItm=null;
									}
									// 封装数据到总类中
									PyPwslCrsCrtCollection pyPwslCrsCrtCollection = new PyPwslCrsCrtCollection();
									pyPwslCrsCrtCollection.setPyPwslCrsCrt(pyPwslCrsCrt);
									pyPwslCrsCrtCollection.setPyPwslCrsCrtPwls(pyPwslCrsCrtPwls);
									if(pyPwslCrsCrtPwlsItm!=null){
										pyPwslCrsCrtCollection.setPyPwslCrsCrtPwlsItm(pyPwslCrsCrtPwlsItm);
									}
									pyPwslCrsCrtCollection.setPyPwslCrsCrtQcsList(pyPwslCrsCrtQcsList);
									pyPwslCrsCrtCollectionList.add(pyPwslCrsCrtCollection);
								}
							}
						}
						pyPwslResponse.setPyPwslCrsCrtCollectionList(pyPwslCrsCrtCollectionList);
						pyPwslResponse.setResultJson(bodyStr);
						return pyPwslResponse;
					}

				}
			}

		}
		return null;
	}

	public static boolean checkResponse(PyPwslResponse pyPwslResponse) {
		if (pyPwslResponse != null) {
			if (pyPwslResponse.getPyPwslCrs() != null) {
				if (pyPwslResponse.getPyPwslCrsCrtCollectionList() != null
						&& pyPwslResponse.getPyPwslCrsCrtCollectionList().size() > 0) {
					return true;
				}
			}
		}
		return false;
	}

	public static void main(String[] args) throws Exception {/*
		String repString = IOUtils.toString(new FileInputStream("d:/pwsl/pwsl6.xml"), "UTF-8");
		if (StringUtils.isNotBlank(repString)) {
//			// 连接字符串，实现数据库的查询和实现
//			Map<String, Object> head = new HashMap<String, Object>();
//			head.put("REQUEST_SYSTEM", "PLAZE");
//			head.put("TRN_ID", "11111");
//
//			Map<String, Object> body = new HashMap<String, Object>();
//			body.put("RESPONSE_CODE", "000000");
//			body.put("RESPONSE_DESC", "响应成功");
//			body.put("RESPONSE_BODY", String.valueOf(repString));
//
//			Map<String, Object> response = new HashMap<String, Object>();
//			response.put("HEAD", head);
//			response.put("BODY", body);
//
//			Map<String, Object> params = new HashMap<String, Object>();
//			params.put("RESPONSE", response);
//
//			JSONObject jsonStr = new JSONObject(params);
//			System.out.println("===================返回参数=============================");
//			System.out.println(JSON.toJSONString(jsonStr));
//			String test = JSON.toJSONString(jsonStr);
//			System.out.println("解析后的参数");
			readStringXml(repString, "1222");
			System.out.println(pyPwslCrs.toString());
			System.out.println(pyPwslCrsCrt.toString());
//			System.out.println(pyPwslCrsCrtQcs.toString());
			System.out.println("-------------------------------------------");
			if(pyPwslCrsCrtQcsList!=null&&pyPwslCrsCrtQcsList.size()>0){
				for(PyPwslCrsCrtQcs p:pyPwslCrsCrtQcsList){
					System.out.println(p.toString());
				}
			}
			System.out.println("-------------------------------------------");
			System.out.println(pyPwslCrsCrtPwls.toString());
			System.out.println(pyPwslCrsCrtPwlsItm.toString());
		}

	*/}

}
