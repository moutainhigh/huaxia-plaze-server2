package com.huaxia.plaze.modules.qyhy.webservice;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.jws.WebService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.huaxia.plaze.modules.MessageWebService;
import com.huaxia.plaze.modules.qyhy.service.EnterpriseDataService;

import net.sf.json.JSONObject;

/**
 * 
 * 企业名单库检索,供pad调用
 *
 */
@Service
@WebService(serviceName="WST001201",endpointInterface="com.huaxia.plaze.modules.MessageWebService")
public class EnterpriseDataWebService implements MessageWebService {
	
	private final static Logger logger = LoggerFactory.getLogger(EnterpriseDataWebService.class);

	@Resource
	private EnterpriseDataService enterpriseDataService;
	
	@Override
	public String invoke(String jsonRequest) {

		String trnId = "";
		String enterprise = "";
		try {
			JSONObject jsonObject = JSONObject.fromObject(jsonRequest);
			
			if(jsonObject.containsKey("REQUEST") && jsonObject.getString("REQUEST") != null
					&& !"".equals(jsonObject.getString("REQUEST")) ){
				JSONObject jsRquest = JSONObject.fromObject(jsonObject.getString("REQUEST"));
				if (jsRquest.containsKey("HEAD") && jsRquest.getString("HEAD") != null
						&& !"".equals(jsRquest.getString("HEAD"))) {
					JSONObject jsHead = JSONObject.fromObject(jsRquest.getString("HEAD"));
					if (jsHead.containsKey("TRN_ID") && jsHead.getString("TRN_ID") != null
							&& !"".equals(jsHead.getString("TRN_ID"))) {
						trnId = jsHead.getString("TRN_ID");
					}
				}
				if(jsRquest.containsKey("BODY") && jsRquest.getString("BODY") != null
						&& !"".equals(jsRquest.getString("BODY"))){
					JSONObject jsBody = JSONObject.fromObject(jsRquest.getString("BODY"));
					if(jsBody.containsKey("ENTERPRISE_NAME") && jsBody.getString("ENTERPRISE_NAME") != null
							&& !"".equals(jsBody.getString("ENTERPRISE_NAME"))){
						enterprise = jsBody.getString("ENTERPRISE_NAME");
					}
				}
			}
		} catch (Exception e) {
			logger.error("检索企业名单库解析请求参数异常", e);
			e.printStackTrace();
			return getResponseMessage(trnId, "000002", "关键元素项校验不通过", "","");
		}
		
		try {
			if(enterprise != null && !"".equals(enterprise)){
				logger.info("请求参数单位全称为 : " + enterprise);
				String enterpriseLevel = enterpriseDataService.findCountByEnterprise(enterprise);
//				int enterpriseCount = 0;
				/*if("华夏银行".equals(enterprise)){
					enterpriseCount = 1;
				}*/
				if(enterpriseLevel != null){
					return getResponseMessage(trnId, "000000", "处理成功", "匹配成功",enterpriseLevel);
				} else {
					return getResponseMessage(trnId, "000000", "处理成功", "","");
				}
				
			} else {
				logger.info("请求参数单位名称为空!");
				return getResponseMessage(trnId, "000002", "关键元素项校验不通过", "","");
			}
		} catch (Exception e) {
			logger.error("企业名单库检索异常!");
			e.printStackTrace();
			return getResponseMessage(trnId, "999998", "处理失败", "","");
		}
		
	}
	
	private String getResponseMessage(String trd_id,String code,String desc,String responseBody,String level){
		
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("RESPONSE_CHANNEL", "PLAZE");
		head.put("TRN_ID", trd_id);
		
		Map<String, Object> body = new HashMap<String, Object>();
		body.put("RESPONSE_CODE", code);
		body.put("RESPONSE_DESC", desc);
		body.put("RESPONSE_BODY", responseBody);
		body.put("ENTERPRISE_LEVEL", level);
		
		Map<String, Object> response = new HashMap<String, Object>();
		response.put("HEAD", head);
		response.put("BODY", body);
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("RESPONSE", response);
		
		JSONObject json = JSONObject.fromObject(params);
		return json.toString();
		
	}
	

}
