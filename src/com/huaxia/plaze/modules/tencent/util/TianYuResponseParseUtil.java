package com.huaxia.plaze.modules.tencent.util;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class TianYuResponseParseUtil {

	/**
	 *@Title:parseResponseInfo
	 *@Description:解析返回报文信息
	 *@param ResponseInfo
	 *@return
	 *@author: wss
	 *@Date:2019年3月27日下午4:42:59
	 */
	public static Map<String, String> parseResponseInfo(String ResponseInfo) {
		// 分解返回参数
		Map<String, String> response = new HashMap<>();
		JSONObject jsonResponse = JSON.parseObject(ResponseInfo);
		if (jsonResponse.containsKey("RESPONSE") && jsonResponse.getString("RESPONSE") != null
				&& !"".equals(jsonResponse.getString("RESPONSE"))) {
			JSONObject jsonRes = JSON.parseObject(jsonResponse.getString("RESPONSE"));

			if (jsonRes.containsKey("HEAD") && jsonRes.getString("HEAD") != null
					&& !"".equals(jsonRes.getString("HEAD"))) {
				JSONObject jsonHead = JSON.parseObject(jsonRes.getString("HEAD"));
				if (jsonHead.containsKey("TRN_ID") && jsonHead.getString("TRN_ID") != null
						&& !"".equals(jsonHead.getString("TRN_ID"))) {
					response.put("trnId", jsonHead.getString("TRN_ID"));
				}
				if (jsonHead.containsKey("RESPONSE_CHANNEL") && jsonHead.getString("RESPONSE_CHANNEL") != null
						&& !"".equals(jsonHead.getString("RESPONSE_CHANNEL"))) {
					response.put("rpChannel", jsonHead.getString("RESPONSE_CHANNEL"));
				}
			}

			if (jsonRes.containsKey("BODY") && jsonRes.getString("BODY") != null
					&& !"".equals(jsonRes.getString("BODY"))) {
				JSONObject jsonBody = JSON.parseObject(jsonRes.getString("BODY"));
				if (jsonBody.containsKey("RESPONSE_BODY") && jsonBody.getString("RESPONSE_BODY") != null
						&& !"".equals(jsonBody.getString("RESPONSE_BODY"))) {
						response.put("responseBody", jsonBody.getString("RESPONSE_BODY"));
				}
				if (jsonBody.containsKey("RESPONSE_CODE") && jsonBody.getString("RESPONSE_CODE") != null
						&& !"".equals(jsonBody.getString("RESPONSE_CODE"))) {
					response.put("responseCode", jsonBody.getString("RESPONSE_CODE"));
				}
				if (jsonBody.containsKey("RESPONSE_DESC") && jsonBody.getString("RESPONSE_DESC") != null
						&& !"".equals(jsonBody.getString("RESPONSE_DESC"))) {
					response.put("responseDesc", jsonBody.getString("RESPONSE_DESC"));
				}
			}

		}
		return response;
	}
}
