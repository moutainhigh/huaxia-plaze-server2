package com.huaxia.plaze.modules.pengyuan.util.pcr;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.huaxia.plaze.modules.pengyuan.domain.PyPcrTenRequest;

public class PyPcrTrnRequestHelper {
	
	private final static Logger logger = LoggerFactory.getLogger(PyPcrTrnRequestHelper.class);
	
	private PyPcrTrnRequestHelper(){
		
	}

	public static PyPcrTenRequest parsingResult(String jsonRequest){
		PyPcrTenRequest pyPcrTenRequest=new PyPcrTenRequest();
		JSONObject jsonObject = null;
		jsonObject = JSON.parseObject(jsonRequest);
		if (jsonObject != null) {
			try {
				if (jsonObject.containsKey("REQUEST") && jsonObject.getString("REQUEST") != null
						&& !"".equals(jsonObject.getString("REQUEST"))) {

					JSONObject jsonRequet = JSON.parseObject(jsonObject.getString("REQUEST"));

					if (jsonRequet.containsKey("HEAD") && jsonRequet.getString("HEAD") != null
							&& !"".equals(jsonRequet.getString("HEAD"))) {
						JSONObject jsonHead = JSON.parseObject(jsonRequet.getString("HEAD"));
						if (jsonHead.containsKey("REQUEST_CHANNEL") && jsonHead.getString("REQUEST_CHANNEL") != null
								&& !"".equals(jsonHead.getString("REQUEST_CHANNEL"))) {
							pyPcrTenRequest.setRequestChannel(jsonHead.getString("REQUEST_CHANNEL"));
						}
						if (jsonHead.containsKey("TRN_ID") && jsonHead.getString("TRN_ID") != null
								&& !"".equals(jsonHead.getString("TRN_ID"))) {
							pyPcrTenRequest.setTrnId(jsonHead.getString("TRN_ID"));
						}else{
							return null;
						}
					}

					if (jsonRequet.containsKey("BODY") && jsonRequet.getString("BODY") != null
							&& !"".equals(jsonRequet.getString("BODY"))) {
						JSONObject jsonBody = JSON.parseObject(jsonRequet.getString("BODY"));
						if (jsonBody.containsKey("QUERY_MODE") && jsonBody.getString("QUERY_MODE") != null
								&& !"".equals(jsonBody.getString("QUERY_MODE"))) {
							pyPcrTenRequest.setQueryMode(jsonBody.getString("QUERY_MODE"));

						}
						if (jsonBody.containsKey("CERT_NO") && jsonBody.getString("CERT_NO") != null
								&& !"".equals(jsonBody.getString("CERT_NO"))) {
							pyPcrTenRequest.setCertNo(jsonBody.getString("CERT_NO"));

						}else{
							return null;
						}
						if (jsonBody.containsKey("NAME") && jsonBody.getString("NAME") != null
								&& !"".equals(jsonBody.getString("NAME"))) {
							pyPcrTenRequest.setName(jsonBody.getString("NAME"));
						}else{
							return null;
						}
//						if (jsonBody.containsKey("QUERY_TYPE") && jsonBody.getString("QUERY_TYPE") != null
//								&& !"".equals(jsonBody.getString("QUERY_TYPE"))) {
//							pyPcrTenRequest.setQueryType(jsonBody.getString("QUERY_TYPE"));
//						}else{
//							return null;
//						}
//						if (jsonBody.containsKey("SUBREPORT_IDS") && jsonBody.getString("SUBREPORT_IDS") != null
//								&& !"".equals(jsonBody.getString("SUBREPORT_IDS"))) {
//							pyPcrTenRequest.setSubreportIds(jsonBody.getString("SUBREPORT_IDS"));
//						}else{
//							return null;
//						}
//						if (jsonBody.containsKey("QUERY_REASEON_ID") && jsonBody.getString("QUERY_REASEON_ID") != null
//								&& !"".equals(jsonBody.getString("QUERY_REASEON_ID"))) {
//							pyPcrTenRequest.setQueryReaseonId(jsonBody.getInteger("QUERY_REASEON_ID"));
//						}else{
//							return null;
//						}
//						if (jsonBody.containsKey("REF_ID") && jsonBody.getString("REF_ID") != null
//								&& !"".equals(jsonBody.getString("REF_ID"))) {
//							pyPcrTenRequest.setRefId(jsonBody.getString("REF_ID"));
//						}
						return pyPcrTenRequest;
					}

				}
			} catch (Exception e) {
				logger.error("[区域数据-深圳-鹏元-个人信用] 解析请求报文异常");
			}
		}
		return null;
	}
}
