package com.huaxia.plaze.modules.id5.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.huaxia.plaze.modules.id5.domain.Id5Request;

public class RequestParseUtil {

	private final static Logger logger = LoggerFactory.getLogger(RequestParseUtil.class);

	public static Id5Request parsingResult(String jsonRequest) {
		Id5Request hdMoblRequest = new Id5Request();
		JSONObject jsonObject = null;
		try {
			jsonObject = JSON.parseObject(jsonRequest);
			if (jsonObject != null) {

				if (jsonObject.containsKey("REQUEST") && jsonObject.getString("REQUEST") != null
						&& !"".equals(jsonObject.getString("REQUEST"))) {

					JSONObject jsonRequet = JSON.parseObject(jsonObject.getString("REQUEST"));

					if (jsonRequet.containsKey("HEAD") && jsonRequet.getString("HEAD") != null
							&& !"".equals(jsonRequet.getString("HEAD"))) {
						JSONObject jsonHead = JSON.parseObject(jsonRequet.getString("HEAD"));
						if (jsonHead.containsKey("REQUEST_CHANNEL") && jsonHead.getString("REQUEST_CHANNEL") != null
								&& !"".equals(jsonHead.getString("REQUEST_CHANNEL"))) {
							hdMoblRequest.setRequestChannel(jsonHead.getString("REQUEST_CHANNEL"));
						}
						if (jsonHead.containsKey("TRN_ID") && jsonHead.getString("TRN_ID") != null
								&& !"".equals(jsonHead.getString("TRN_ID"))) {
							hdMoblRequest.setTrnId(jsonHead.getString("TRN_ID"));
						}
					}

					if (jsonRequet.containsKey("BODY") && jsonRequet.getString("BODY") != null
							&& !"".equals(jsonRequet.getString("BODY"))) {
						JSONObject jsonBody = JSON.parseObject(jsonRequet.getString("BODY"));
						if (jsonBody.containsKey("QUERY_MODE") && jsonBody.getString("QUERY_MODE") != null
								&& !"".equals(jsonBody.getString("QUERY_MODE"))) {
							hdMoblRequest.setQueryMode(jsonBody.getString("QUERY_MODE"));

						}
						if (jsonBody.containsKey("CERT_TYPE") && jsonBody.getString("CERT_TYPE") != null
								&& !"".equals(jsonBody.getString("CERT_TYPE"))) {
							hdMoblRequest.setCertType(jsonBody.getString("CERT_TYPE"));
						}
						if (jsonBody.containsKey("CERT_NO") && jsonBody.getString("CERT_NO") != null
								&& !"".equals(jsonBody.getString("CERT_NO"))) {
							hdMoblRequest.setCertNo(jsonBody.getString("CERT_NO"));

						}
						if (jsonBody.containsKey("NAME") && jsonBody.getString("NAME") != null
								&& !"".equals(jsonBody.getString("NAME"))) {
							hdMoblRequest.setName(jsonBody.getString("NAME"));
						}
						if (jsonBody.containsKey("MOBILE") && jsonBody.getString("MOBILE") != null
								&& !"".equals(jsonBody.getString("MOBILE"))) {
							hdMoblRequest.setMobile(jsonBody.getString("MOBILE"));
						}
						return hdMoblRequest;
					}

				}
			}
		} catch (Exception e) {
			logger.error("请求参数解析异常 [{}]", e);
			e.printStackTrace();
		}
		return null;
	}
}
