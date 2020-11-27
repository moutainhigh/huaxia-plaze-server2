package com.huaxia.plaze.modules.jianbing.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.huaxia.plaze.modules.jianbing.domain.JianBingTrnRequest;

public class RequestParseUtil {

	private final static Logger logger = LoggerFactory.getLogger(RequestParseUtil.class);

	public static JianBingTrnRequest parsingResult(String jsonRequest) {
		JianBingTrnRequest jianbingRequest = new JianBingTrnRequest();
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
							jianbingRequest.setRequestChannel(jsonHead.getString("REQUEST_CHANNEL"));
						}
						if (jsonHead.containsKey("TRN_ID") && jsonHead.getString("TRN_ID") != null
								&& !"".equals(jsonHead.getString("TRN_ID"))) {
							jianbingRequest.setTrnId(jsonHead.getString("TRN_ID"));
						}
					}

					if (jsonRequet.containsKey("BODY") && jsonRequet.getString("BODY") != null
							&& !"".equals(jsonRequet.getString("BODY"))) {
						JSONObject jsonBody = JSON.parseObject(jsonRequet.getString("BODY"));
						if (jsonBody.containsKey("QUERY_MODE") && jsonBody.getString("QUERY_MODE") != null
								&& !"".equals(jsonBody.getString("QUERY_MODE"))) {
							jianbingRequest.setQueryMode(jsonBody.getString("QUERY_MODE"));

						}
						if (jsonBody.containsKey("F") && jsonBody.getString("F") != null
								&& !"".equals(jsonBody.getString("F"))) {
							jianbingRequest.setF(jsonBody.getString("F"));
						}
						if (jsonBody.containsKey("PRODUCT_CID") && jsonBody.getString("PRODUCT_CID") != null
								&& !"".equals(jsonBody.getString("PRODUCT_CID"))) {
							jianbingRequest.setProduct_cid(jsonBody.getString("PRODUCT_CID"));
						}
						if (jsonBody.containsKey("APPLY_ID") && jsonBody.getString("APPLY_ID") != null
								&& !"".equals(jsonBody.getString("APPLY_ID"))) {
							jianbingRequest.setApply_id(jsonBody.getString("APPLY_ID"));
						}

						if (jsonBody.containsKey("TIME") && jsonBody.getString("TIME") != null
								&& !"".equals(jsonBody.getString("TIME"))) {
							jianbingRequest.setTime(jsonBody.getString("TIME"));
						}
						if (jsonBody.containsKey("MOBILE") && jsonBody.getString("MOBILE") != null
								&& !"".equals(jsonBody.getString("MOBILE"))) {
							jianbingRequest.setMobile(jsonBody.getString("MOBILE"));
						}
						if (jsonBody.containsKey("NAME") && jsonBody.getString("NAME") != null
								&& !"".equals(jsonBody.getString("NAME"))) {
							jianbingRequest.setName(jsonBody.getString("NAME"));
						}
						if (jsonBody.containsKey("CERT_TYPE") && jsonBody.getString("CERT_TYPE") != null
								&& !"".equals(jsonBody.getString("CERT_TYPE"))) {
							jianbingRequest.setCertType(jsonBody.getString("CERT_TYPE"));
						}
						if (jsonBody.containsKey("CERT_NO") && jsonBody.getString("CERT_NO") != null
								&& !"".equals(jsonBody.getString("CERT_NO"))) {
							jianbingRequest.setCertNo(jsonBody.getString("CERT_NO"));
						}
						return jianbingRequest;
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
