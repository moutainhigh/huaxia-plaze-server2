package com.huaxia.plaze.modules.pengyuan.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.huaxia.plaze.modules.pengyuan.domain.PyPwslTrnRequest;

public class PyPwslTrnRequestHelper {
	
	private PyPwslTrnRequestHelper(){
		
	}

	public static PyPwslTrnRequest parsingResult(String jsonRequest){
		PyPwslTrnRequest pyPwslTrnRequest=new PyPwslTrnRequest();
		JSONObject jsonObject = null;
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
						pyPwslTrnRequest.setRequestChannel(jsonHead.getString("REQUEST_CHANNEL"));
					}
					if (jsonHead.containsKey("TRN_ID") && jsonHead.getString("TRN_ID") != null
							&& !"".equals(jsonHead.getString("TRN_ID"))) {
						pyPwslTrnRequest.setTrnId(jsonHead.getString("TRN_ID"));
					}else{
						return null;
					}
				}

				if (jsonRequet.containsKey("BODY") && jsonRequet.getString("BODY") != null
						&& !"".equals(jsonRequet.getString("BODY"))) {
					JSONObject jsonBody = JSON.parseObject(jsonRequet.getString("BODY"));
					if (jsonBody.containsKey("QUERY_MODE") && jsonBody.getString("QUERY_MODE") != null
							&& !"".equals(jsonBody.getString("QUERY_MODE"))) {
						pyPwslTrnRequest.setQueryMode(jsonBody.getString("QUERY_MODE"));

					}
					if (jsonBody.containsKey("CERT_NO") && jsonBody.getString("CERT_NO") != null
							&& !"".equals(jsonBody.getString("CERT_NO"))) {
						pyPwslTrnRequest.setCertNo(jsonBody.getString("CERT_NO"));

					}else{
						return null;
					}
					if (jsonBody.containsKey("NAME") && jsonBody.getString("NAME") != null
							&& !"".equals(jsonBody.getString("NAME"))) {
						pyPwslTrnRequest.setName(jsonBody.getString("NAME"));
					}else{
						return null;
					}
					return pyPwslTrnRequest;
				}

			}
		}
		return null;
	}
}
