package com.huaxia.plaze.modules.szjd.webservice;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.huaxia.plaze.modules.szjd.domain.SzjdRequest;
import com.huaxia.plaze.modules.szjd.service.SzjdService;

import net.sf.json.JSONObject;
@Component
public class SzjdDealDataAdapter {
	
	private final static Logger logger = LoggerFactory.getLogger(SzjdDealDataAdapter.class);
	
	@Resource
	private SzjdService szjdService;
	
	public String dealSzjdRequest(String jsonRequest){
		
		/** 接收渠道(审批)传过来的请求参数,分解成各变量 */
		String requestChannel = "";
		String trnId          = "";
		String certType       = "";
		String certNo         = "";
		String name           = "";
		String queryReason    = "";
		String productDate    = "";
		
		JSONObject jsonObject = JSONObject.fromObject(jsonRequest);
		if (jsonObject != null) {
			if (jsonObject.containsKey("REQUEST") && jsonObject.getString("REQUEST") != null
					&& !"".equals(jsonObject.getString("REQUEST"))) {
				JSONObject jsonRequet = JSONObject.fromObject(jsonObject.getString("REQUEST"));
				if (jsonRequet.containsKey("HEAD") && jsonRequet.getString("HEAD") != null
						&& !"".equals(jsonRequet.getString("HEAD"))) {
					JSONObject jsonHead = JSONObject.fromObject(jsonRequet.getString("HEAD"));
					if (jsonHead.containsKey("REQUEST_CHANNEL") && jsonHead.getString("REQUEST_CHANNEL") != null
							&& !"".equals(jsonHead.getString("REQUEST_CHANNEL"))) {
						requestChannel = jsonHead.getString("REQUEST_CHANNEL");
					}
					if (jsonHead.containsKey("TRN_ID") && jsonHead.getString("TRN_ID") != null
							&& !"".equals(jsonHead.getString("TRN_ID"))) {
						trnId = jsonHead.getString("TRN_ID");
					}
				}
				
				if (jsonRequet.containsKey("BODY") && jsonRequet.getString("BODY") != null
						&& !"".equals(jsonRequet.getString("BODY"))) {
					JSONObject jsonBody = JSONObject.fromObject(jsonRequet.getString("BODY"));
					if (jsonBody.containsKey("CERT_TYPE") && jsonBody.getString("CERT_TYPE") != null
							&& !"".equals(jsonBody.getString("CERT_TYPE"))) {
						certType = jsonBody.getString("CERT_TYPE");
					}
					if (jsonBody.containsKey("CERT_NO") && jsonBody.getString("CERT_NO") != null
							&& !"".equals(jsonBody.getString("CERT_NO"))) {
						certNo = jsonBody.getString("CERT_NO");
					}
					if (jsonBody.containsKey("NAME") && jsonBody.getString("NAME") != null
							&& !"".equals(jsonBody.getString("NAME"))) {
						name = jsonBody.getString("NAME");
					}
					if (jsonBody.containsKey("QUERY_REASON") && jsonBody.getString("QUERY_REASON") != null
							&& !"".equals(jsonBody.getString("QUERY_REASON"))) {
						queryReason = jsonBody.getString("QUERY_REASON");
					}
					if (jsonBody.containsKey("PRODUCT_DATE") && jsonBody.getString("PRODUCT_DATE") != null
							&& !"".equals(jsonBody.getString("PRODUCT_DATE"))) {
						productDate = jsonBody.getString("PRODUCT_DATE");
					}
				}
			}
		}
		
		try {
			SzjdRequest szjdRequest = new SzjdRequest();
			szjdRequest.setCrtUser(requestChannel);
			szjdRequest.setTrnId(trnId);
			szjdRequest.setIdNum(certNo);
			szjdRequest.setIdType(certType);
			szjdRequest.setUserName(name);
			szjdRequest.setStatus("0");
			szjdRequest.setQueryReason(queryReason);
			szjdRequest.setProductDate(productDate);
			szjdService.saveSzjdRequst(szjdRequest);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("数字解读处理失败,业务主键"+trnId, e);
			Map<String, Object> head = new HashMap<String, Object>();
			head.put("RESPONSE_CHANNEL", "PLAZE");
			head.put("TRN_ID", trnId);

			Map<String, Object> body = new HashMap<String, Object>();
			body.put("RESPONSE_CODE", "999999");
			body.put("RESPONSE_DESC", "处理失败");
			body.put("RESPONSE_BODY", "");

			Map<String, Object> response = new HashMap<String, Object>();
			response.put("HEAD", head);
			response.put("BODY", body);

			Map<String, Object> params = new HashMap<String, Object>();
			params.put("RESPONSE", response);

			JSONObject json = JSONObject.fromObject(params);
			return json.toString();
		}
		
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("RESPONSE_CHANNEL", "PLAZE");
		head.put("TRN_ID", trnId);

		Map<String, Object> body = new HashMap<String, Object>();
		body.put("RESPONSE_CODE", "000000");
		body.put("RESPONSE_DESC", "处理成功");
		body.put("RESPONSE_BODY", "");

		Map<String, Object> response = new HashMap<String, Object>();
		response.put("HEAD", head);
		response.put("BODY", body);

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("RESPONSE", response);

		JSONObject json = JSONObject.fromObject(params);
		return json.toString();
		
	}

}
