package com.huaxia.plaze.common;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;

/**
 * 公共消息报文构建类
 * 
 * @author zhiguo.li
 * @version 1.0.0
 *
 */
public final class MessageBuildUtil {

	public static String buildRequestMessage(Map<String, String> args) {
		JSONObject jsonRoot = new JSONObject();
		if (args != null && args.size() > 0) {
			String key = null;

			JSONObject jsonRequest = new JSONObject();
			jsonRoot.put("REQUEST", jsonRequest);

			// 构建请求头
			JSONObject jsonHead = new JSONObject();
			jsonRequest.put("HEAD", jsonHead);

			key = "REQUEST_CHANNEL";
			if (args.containsKey(key)) {
				jsonHead.put(key, args.get(key));
			} else {
				jsonHead.put(key, "");
			}

			key = "TRN_ID";
			if (args.containsKey(key)) {
				jsonHead.put(key, args.get(key));
			} else {
				jsonHead.put(key, "");
			}

			key = "TRN_CODE";
			if (args.containsKey(key)) {
				if (args.get(key).startsWith("WST")) {
					jsonHead.put(key, args.get(key));
				} else {
				jsonHead.put(key, "WST" + args.get(key));
				}
			} else {
				jsonHead.put(key, "");
			}

			// 构建请求体
			JSONObject jsonBody = new JSONObject();
			jsonRequest.put("BODY", jsonBody);

			key = "QUERY_MODE";
			if (args.containsKey(key)) {
				jsonBody.put(key, args.get(key));
			} else {
				jsonBody.put(key, "");
			}

			key = "CERT_TYPE";
			if (args.containsKey(key)) {
				jsonBody.put(key, args.get(key));
			} else {
				jsonBody.put(key, "");
			}

			key = "CERT_NO";
			if (args.containsKey(key)) {
				jsonBody.put(key, args.get(key));
			} else {
				jsonBody.put(key, "");
			}

			key = "NAME";
			if (args.containsKey(key)) {
				jsonBody.put(key, args.get(key));
			} else {
				jsonBody.put(key, "");
			}

			key = "MOBILE";
			if (args.containsKey(key)) {
				jsonBody.put(key, args.get(key));
			} else {
				jsonBody.put(key, "");
			}
			key = "USERNAME";
			if (args.containsKey(key)) {
				jsonBody.put(key, args.get(key));
			} else {
				jsonBody.put(key, "");
			}
			key = "PASSWORD";
			if (args.containsKey(key)) {
				jsonBody.put(key, args.get(key));
			} else {
				jsonBody.put(key, "");
			}
			key = "API_CODE";
			if (args.containsKey(key)) {
				jsonBody.put(key, args.get(key));
			} else {
				jsonBody.put(key, "");
			}
			key = "CARRIER";
			if (args.containsKey(key)) {
				jsonBody.put(key, args.get(key));
			} else {
				jsonBody.put(key, "");
			}
		}
		return jsonRoot.toJSONString();
	}

	public static String buildResponseMessage(Map<String, String> args) {
		JSONObject jsonRoot = new JSONObject();
		if (args != null && args.size() > 0) {
			String key = null;

			JSONObject jsonRequest = new JSONObject();
			jsonRoot.put("RESPONSE", jsonRequest);

			// 构建请求头
			JSONObject jsonHead = new JSONObject();
			jsonRequest.put("HEAD", jsonHead);

			key = "RESPONSE_CHANNEL";
			if (args.containsKey(key)) {
				jsonHead.put(key, args.get(key));
			} else {
				jsonHead.put(key, "PLAZE");
			}

			key = "TRN_ID";
			if (args.containsKey(key)) {
				jsonHead.put(key, args.get(key));
			} else {
				jsonHead.put(key, "");
			}

			// 构建请求体
			JSONObject jsonBody = new JSONObject();
			jsonRequest.put("BODY", jsonBody);

			key = "RESPONSE_CODE";
			if (args.containsKey(key)) {
				jsonBody.put(key, args.get(key));
			} else {
				jsonBody.put(key, "000000");
			}

			key = "RESPONSE_DESC";
			if (args.containsKey(key)) {
				jsonBody.put(key, args.get(key));
			} else {
				jsonBody.put(key, "处理成功");
			}

			key = "RESPONSE_BODY";
			if (args.containsKey(key)) {
				jsonBody.put(key, args.get(key));
			} else {
				jsonBody.put(key, "");
			}
		}
		return jsonRoot.toJSONString();
	}

	public static void main(String[] args) {
		Map<String, String> messageArgs = new HashMap<String, String>();
		messageArgs.put("REQUEST_CHANNEL", "abc");
		messageArgs.put("TRN_CODE", "000700");
		System.out.println(MessageBuildUtil.buildRequestMessage(messageArgs));
		messageArgs.put("RESPONSE_CHANNEL", "xyz");
		System.out.println(MessageBuildUtil.buildResponseMessage(messageArgs));
	}

}
