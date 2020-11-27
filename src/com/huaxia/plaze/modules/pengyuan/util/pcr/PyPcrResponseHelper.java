package com.huaxia.plaze.modules.pengyuan.util.pcr;


import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.huaxia.plaze.modules.pengyuan.domain.PyPcrTenReponse;
import com.huaxia.plaze.modules.yilianzhong.util.ErrorCode;

public class PyPcrResponseHelper {

	private final static Logger logger = LoggerFactory.getLogger(PyPcrResponseHelper.class);

	private static String trnId;

	private static String bodyStr;

	private static PyPcrTenReponse pyPcrTenReponse;

	private PyPcrResponseHelper() {

	}

	public static PyPcrTenReponse getQueryModel1Response(String repString,String appId,String crtUser) {
		if (StringUtils.isNotBlank(repString)) {

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
									pyPcrTenReponse = PyReponseXmlReader.readStringXml(bodyStr, trnId,appId,crtUser);
									if (pyPcrTenReponse != null) {
										pyPcrTenReponse.setResultJson(bodyStr);
									}else{
										pyPcrTenReponse=new PyPcrTenReponse();
										pyPcrTenReponse.setResultJson(bodyStr);
									}
									return pyPcrTenReponse;
								}

							} else {
								// 请求dmz失败
								return null;
							}
						}
					}

				}
			} catch (Exception e) {
				logger.error("[区域数据-深圳-鹏元-个人信用] 返回报文解析异常");
				e.printStackTrace();
			}
		}
		return null;
	}

	public static boolean checkResponse(PyPcrTenReponse pyPcrTenReponse) {
		if (pyPcrTenReponse != null) {
			if (pyPcrTenReponse.getPyPcrCrs() != null) {
				if (pyPcrTenReponse.getPyCisReportCollectionList() != null
						&& pyPcrTenReponse.getPyCisReportCollectionList().size() > 0) {
					return true;
				}
			}
		}
		return false;
	}

}
