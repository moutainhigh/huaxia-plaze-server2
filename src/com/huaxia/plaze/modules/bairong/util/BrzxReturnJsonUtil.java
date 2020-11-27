package com.huaxia.plaze.modules.bairong.util;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * 返回报文组装器
 * @author User
 *
 */
public class BrzxReturnJsonUtil {

	public static final Logger logger = LoggerFactory.getLogger(BrzxReturnJsonUtil.class);
	/**
	 *@Title:getReturnInfo
	 *@Description:组装返回报文信息
	 *@param responseInfo
	 *@return
	 *@author: wss
	 *@Date:2019年3月27日下午5:21:09
	 */
	public static String getReturnInfo(Map<String, String> responseInfo, ResponseCode rpCood) {
		try {
			Map<String, Object> head = new HashMap<String, Object>();
			head.put("RESPONSE_CHANNEL", "PLAZE");
			head.put("TRN_ID", responseInfo.get("trnId"));
			
			Map<String, Object> body = new HashMap<String, Object>();
			body.put("RESPONSE_CODE", rpCood.getCode());
			body.put("RESPONSE_DESC", rpCood.getDescription());
			body.put("RESPONSE_BODY", String.valueOf(responseInfo.get("responseBody")));
			
			Map<String, Object> response = new HashMap<String, Object>();
			response.put("HEAD", head);
			response.put("BODY", body);
			
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("RESPONSE", response);
			
			JSONObject jsonStr = new JSONObject(param);
			return JSON.toJSONString(jsonStr);
		} catch (Exception e) {
			logger.error("返回报文组装异常 [{}]", e);
			return null;
		}
		
	}
}
