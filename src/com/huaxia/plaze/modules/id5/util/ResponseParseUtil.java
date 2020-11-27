package com.huaxia.plaze.modules.id5.util;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.huaxia.plaze.modules.id5.domain.Id5Response;


/**
 * 华道返回参数解析工具类
 */
public class ResponseParseUtil {

	public static boolean parsingArguments(String parameter) {
		String responseCode = "";
		String responseDesc = "";
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
						responseDesc = jsonBody.getString("RESPONSE_DESC");
					}
				}

			}
		}
		if ("000000".equals(responseCode)) {
			return true;
		}
		return false;
	}

	public static Id5Response parsingResult(String parameter) {
		Id5Response id5Response = new Id5Response();

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
						id5Response.setTrnId(jsonHead.getString("TRN_ID"));
					}
				}

				if (jsonRes.containsKey("BODY")) {
					JSONObject jsonBody = JSON.parseObject(jsonRes.getString("BODY"));
					if (jsonBody.containsKey("RESPONSE_BODY") && jsonBody.getString("RESPONSE_BODY") != null
							&& !"".equals(jsonBody.getString("RESPONSE_BODY"))) {
						bodyStr = jsonBody.getString("RESPONSE_BODY");
						id5Response.setMessageBody(bodyStr);
						/*
						JSONObject resultJson = JSON.parseObject(bodyStr);
						if (resultJson.containsKey("CODE") && resultJson.getString("CODE") != null
								&& !"".equals(resultJson.getString("CODE"))) {
							String code = resultJson.getString("CODE");
							id5Response.setResponseCode(code);
						}*/
				
					}
				}

			}
			return id5Response;

		}
		return null;
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
