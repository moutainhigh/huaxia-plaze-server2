package com.huaxia.plaze.modules.bairong.util;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class BrzxRequestParseUtil {

	public static final Logger logger = LoggerFactory.getLogger(BrzxRequestParseUtil.class);
	
	/**
	 *@Title:parseRequset
	 *@Description:解析审批请求报文
	 *@param jsonRequest
	 *@return
	 *@author: wss
	 *@Date:2019年3月27日下午4:09:02
	 */
	public static Map<String, String> parseRequestInfo(String jsonRequest) {
		
		Map<String, String> params = new HashMap<>();
		JSONObject jsonObject = null;
		try {
			jsonObject = JSON.parseObject(jsonRequest);
			if (jsonObject != null) {
				// 解析请求参数
				if (jsonObject.containsKey("REQUEST") && jsonObject.getString("REQUEST") != null
						&& !"".equals(jsonObject.getString("REQUEST"))) {
					
					JSONObject jsonRequet = JSON.parseObject(jsonObject.getString("REQUEST"));
					
					if (jsonRequet.containsKey("HEAD") && jsonRequet.getString("HEAD") != null
							&& !"".equals(jsonRequet.getString("HEAD"))) {
						JSONObject jsonHead = JSON.parseObject(jsonRequet.getString("HEAD"));
						if (jsonHead.containsKey("REQUEST_CHANNEL") && jsonHead.getString("REQUEST_CHANNEL") != null
								&& !"".equals(jsonHead.getString("REQUEST_CHANNEL"))) {
//							rqChannel = jsonHead.getString("REQUEST_CHANNEL");
							params.put("rqChannel", jsonHead.getString("REQUEST_CHANNEL"));
						}
						if (jsonHead.containsKey("TRN_ID") && jsonHead.getString("TRN_ID") != null
								&& !"".equals(jsonHead.getString("TRN_ID"))) {
//							trnId = jsonHead.getString("TRN_ID");
							params.put("trnId", jsonHead.getString("TRN_ID"));
						}
						if (jsonHead.containsKey("TRN_CODE") && jsonHead.getString("TRN_CODE") != null
								&& !"".equals(jsonHead.getString("TRN_CODE"))) {
//							trnCode = jsonHead.getString("TRN_CODE"); // T000400
							params.put("trnCode", jsonHead.getString("TRN_CODE"));
						}
					}
					
					if (jsonRequet.containsKey("BODY") && jsonRequet.getString("BODY") != null
							&& !"".equals(jsonRequet.getString("BODY"))) {
						JSONObject jsonBody = JSON.parseObject(jsonRequet.getString("BODY"));
						if (jsonBody.containsKey("QUERY_MODE") && jsonBody.getString("QUERY_MODE") != null
								&& !"".equals(jsonBody.getString("QUERY_MODE"))) {
//							queryMode = jsonBody.getString("QUERY_MODE");
							params.put("queryMode", jsonBody.getString("QUERY_MODE"));
		
						}
						if (jsonBody.containsKey("CERT_TYPE") && jsonBody.getString("CERT_TYPE") != null
								&& !"".equals(jsonBody.getString("CERT_TYPE"))) {
//							certType = jsonBody.getString("CERT_TYPE");
							params.put("certType", jsonBody.getString("CERT_TYPE"));
						}
						if (jsonBody.containsKey("CERT_NO") && jsonBody.getString("CERT_NO") != null
								&& !"".equals(jsonBody.getString("CERT_NO"))) {
//							certNo = jsonBody.getString("CERT_NO");
							params.put("certNo", jsonBody.getString("CERT_NO"));
		
						}
						if (jsonBody.containsKey("NAME") && jsonBody.getString("NAME") != null
								&& !"".equals(jsonBody.getString("NAME"))) {
//							name = jsonBody.getString("NAME");
							params.put("name", jsonBody.getString("NAME"));
						}
						if (jsonBody.containsKey("MOBILE") && jsonBody.getString("MOBILE") != null
								&& !"".equals(jsonBody.getString("MOBILE"))) {
//							mobile = jsonBody.getString("MOBILE");
							params.put("mobile", jsonBody.getString("MOBILE"));
						}
					}
					return params;
				}
			}
		} catch (Exception e) {
			logger.error("请求参数解析异常 [{}]", e);
			e.printStackTrace();
		}
		return null;
	}
	
}
