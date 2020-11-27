package com.huaxia.plaze.modules.pengyuan.util;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class ReturnJsonUtil {

	public static String getErrorBackJson(String TRN_ID,ErrorCode errorCode){
		
			// 连接字符串，实现数据库的查询和实现
			Map<String, Object> head = new HashMap<String, Object>();
			head.put("RESPONSE_CHANNEL", "PLAZE");
			head.put("TRN_ID", TRN_ID);
			
			Map<String, Object> body = new HashMap<String, Object>();
			body.put("RESPONSE_CODE", errorCode.getCode());
			body.put("RESPONSE_DESC", errorCode.getDescription());
			body.put("RESPONSE_BODY", "");
			
			Map<String, Object> response = new HashMap<String, Object>();
			response.put("HEAD", head);
			response.put("BODY", body);
			
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("RESPONSE", response);
			
			JSONObject jsonStr = new JSONObject(params);
			return JSON.toJSONString(jsonStr);
	}
	
	
	public static void main(String[] args) {
		String backString=getErrorBackJson("11111",ErrorCode.OK);
		System.out.println(backString);
	}
}
