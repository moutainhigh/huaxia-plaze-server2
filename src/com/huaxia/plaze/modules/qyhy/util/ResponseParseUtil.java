package com.huaxia.plaze.modules.qyhy.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.huaxia.plaze.modules.qyhy.domain.QyhyResponseParameters;

/**
 * 企业行业返回参数解析工具类
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

	public static QyhyResponseParameters parsingResult(String parameter) {
		QyhyResponseParameters trnResponseParameters = new QyhyResponseParameters();

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
						trnResponseParameters.setTrnId(jsonHead.getString("TRN_ID"));
					}
				}

				if (jsonRes.containsKey("BODY")&& jsonRes.getString("BODY") != null
						&& !"".equals(jsonRes.getString("BODY"))) {
					JSONObject jsonBody = JSON.parseObject(jsonRes.getString("BODY"));
					if (jsonBody.containsKey("RESPONSE_BODY") && jsonBody.getString("RESPONSE_BODY") != null
							&& !"".equals(jsonBody.getString("RESPONSE_BODY"))) {
						trnResponseParameters.setResponseBody(jsonBody.getString("RESPONSE_BODY"));
						bodyStr = jsonBody.getString("RESPONSE_BODY");
//						System.out.println("======================bodyStr=" + bodyStr + "=========================");
						
					}
					if (jsonBody.containsKey("RESPONSE_CODE") && jsonBody.getString("RESPONSE_CODE") != null
							&& !"".equals(jsonBody.getString("RESPONSE_CODE"))) {
						trnResponseParameters.setResponseCode(jsonBody.getString("RESPONSE_CODE"));
					}
				}

			}
			return trnResponseParameters;

		}
		return null;
	}
	

	public static String getQueryModel2Response(String messageBody,String trnId){
		if (StringUtils.isNotBlank(messageBody)) {
			// 连接字符串，实现数据库的查询和实现
			Map<String, Object> head = new HashMap<String, Object>();
			head.put("REQUEST_SYSTEM", "PLAZE");
			head.put("TRN_ID", trnId);
			
			Map<String, Object> body = new HashMap<String, Object>();
			body.put("RESPONSE_CODE", "000000");
			body.put("RESPONSE_DESC", "处理成功");
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

	public static void main(String[] args) {

		String appId1="1801050623P50698";//1801050623P50698.txt
		String url="D:/chenmeng01/XMLforLeeQyhyInfoTest/zuiquanbaowen/"+appId1+ ".txt";
		File file = new File(url);
		String message = null;
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "GBK"));
			message = reader.readLine();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
				}
			}
		}
		if (StringUtils.isNotBlank(message)) {
			// 连接字符串，实现数据库的查询和实现
			Map<String, Object> head = new HashMap<String, Object>();
			head.put("REQUEST_SYSTEM", "PLAZE");
			head.put("TRN_ID", "11111");

			Map<String, Object> body = new HashMap<String, Object>();
			body.put("RESPONSE_CODE", "E000000");
			body.put("RESPONSE_DESC", "响应成功");
			body.put("RESPONSE_BODY", String.valueOf(message));

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
