package com.huaxia.plaze.modules.jianbing.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Node;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.huaxia.plaze.modules.jianbing.domain.JianBingGjjBrief;
import com.huaxia.plaze.modules.jianbing.domain.JianBingGjjDetail;

/**
 * 51易达金返回参数解析工具类
 */
public class ResponseParseUtil {
	
	private final static Logger logger = LoggerFactory.getLogger(ResponseParseUtil.class);


	public static boolean parsingArguments(String parameter) {
		String responseCode = "";
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
						responseCode = jsonBody.getString("RESPONSE_CODE");
					}
				}

			}
		}
		if ("000000".equals(responseCode)) {
			return true;
		}
		return false;
	}

	public static Map<String, Object> parsingResult(String parameter) throws Exception {
		Map<String, Object>  info = new HashMap<>();
		String trnId =null;

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
						trnId = jsonHead.getString("TRN_ID");
						info.put("trnId", trnId);
						
					}
				}

				if (jsonRes.containsKey("BODY")) {
					JSONObject jsonBody = JSON.parseObject(jsonRes.getString("BODY"));
					if (jsonBody.containsKey("RESPONSE_BODY") && jsonBody.getString("RESPONSE_BODY") != null
							&& !"".equals(jsonBody.getString("RESPONSE_BODY"))) {
						bodyStr = jsonBody.getString("RESPONSE_BODY");
						logger.info("======================返回数据=" + bodyStr + "=========================");
						info.put("bodyStr", bodyStr);
						
					    
					}
				}

			}
			return info;

	}
	
	
}
