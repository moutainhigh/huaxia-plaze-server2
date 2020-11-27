package com.huaxia.plaze.common;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * 公共消息报文解析类
 * 
 * @author zhiguo.li
 * @version 1.0.0
 *
 */
public final class MessageParseUtil {

	private final static Logger logger = LoggerFactory.getLogger(MessageParseUtil.class);

	public static Map<String, String> parseRequestMessage(String message) {
		Map<String, String> cache = new HashMap<String, String>(8);
		if (StringUtils.isBlank(message)) {
			return cache;
		}

		JSONObject jsonRoot = validate(message);
		if (StringUtils.isNotBlank(jsonRoot.getString("REQUEST"))) {
			String key = null;
			String value = null;

			JSONObject jsonRequest = JSON.parseObject(jsonRoot.getString("REQUEST"));
			if (jsonRequest == null) {
				return cache;
			}

			value = jsonRequest.getString("HEAD");
			if (StringUtils.isNotBlank(value)) {
				JSONObject jsonHead = JSON.parseObject(value);
				if (jsonHead == null) {
					return cache;
				}

				key = "REQUEST_CHANNEL";
				value = jsonHead.getString(key);
				cache.put(key, value);

				key = "TRN_ID";
				value = jsonHead.getString(key);
				cache.put(key, value);

				key = "TRN_CODE";
				value = jsonHead.getString(key);
				cache.put(key, value);
			}

			value = jsonRequest.getString("BODY");
			if (StringUtils.isNotBlank(value)) {
				JSONObject jsonBody = JSON.parseObject(value);
				if (jsonBody == null) {
					return cache;
				}

				key = "QUERY_MODE";
				value = jsonBody.getString(key);
				cache.put(key, value);

				key = "CERT_TYPE";
				value = jsonBody.getString(key);
				cache.put(key, value);

				key = "CERT_NO";
				value = jsonBody.getString(key);
				cache.put(key, value);

				key = "NAME";
				value = jsonBody.getString(key);
				cache.put(key, value);

				key = "MOBILE";
				value = jsonBody.getString(key);
				cache.put(key, value);
				
				key = "CARD_ACCOUNT";
				value = jsonBody.getString(key);
				cache.put(key, value);
				
				key = "SEQUENCE";
				value = jsonBody.getString(key);
				cache.put(key, value);
			}
		}

		return cache;
	}

	public static Map<String, String> parseResponseMessage(String message) {
		Map<String, String> cache = new HashMap<String, String>(5);
		if (StringUtils.isBlank(message)) {
			return cache;
		}

		JSONObject jsonRoot = validate(message);
		if (StringUtils.isNotBlank(jsonRoot.getString("RESPONSE"))) {
			String key = null;
			String value = null;

			JSONObject jsonRequest = JSON.parseObject(jsonRoot.getString("RESPONSE"));
			if (jsonRequest == null) {
				return cache;
			}

			value = jsonRequest.getString("HEAD");
			if (StringUtils.isNotBlank(value)) {
				JSONObject jsonHead = JSON.parseObject(value);
				if (jsonHead == null) {
					return cache;
				}

				key = "RESPONSE_CHANNEL";
				value = jsonHead.getString(key);
				cache.put(key, value);

				key = "TRN_ID";
				value = jsonHead.getString(key);
				cache.put(key, value);
			}

			value = jsonRequest.getString("BODY");
			if (StringUtils.isNotBlank(value)) {
				JSONObject jsonBody = JSON.parseObject(value);
				if (jsonBody == null) {
					return cache;
				}

				key = "RESPONSE_CODE";
				value = jsonBody.getString(key);
				cache.put(key, value);

				key = "RESPONSE_DESC";
				value = jsonBody.getString(key);
				cache.put(key, value);

				key = "RESPONSE_BODY";
				value = jsonBody.getString(key);
				cache.put(key, value);
			}
		}

		return cache;
	}

	private static JSONObject validate(String message) {
		JSONObject jsonRoot = new JSONObject();
		try {
			jsonRoot = JSON.parseObject(message);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("非有效的报文格式 [ {} ]", new Object[] { message });
		}
		return jsonRoot;
	}

	public static void main(String[] args) {
		Map<String, String> requestMessage = MessageParseUtil.parseRequestMessage(
				"{'REQUEST':{'HEAD':{'REQUEST_CHANNEL':'CAMS','TRN_ID':'EA009F0668983D540168983D54300000','TRN_CODE':''},'BODY':{'QUERY_MODE':'2','CERT_TYPE':'00','CERT_NO':'','NAME':'','MOBILE':''}}}");
		System.out.println(requestMessage);

		Map<String, String> responseMessage = MessageParseUtil.parseResponseMessage(
				"{'RESPONSE':{'HEAD':{'RESPONSE_CHANNEL':'PLAZE','TRN_ID':'EA009F0668983D540168983D54300000'},'BODY':{'RESPONSE_CODE':'000000','RESPONSE_DESC':'处理成功','RESPONSE_BODY':''}}}");
		System.out.println(responseMessage);
	}

}
