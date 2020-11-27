package com.huaxia.plaze.modules.general.webservice;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.jws.WebService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.huaxia.plaze.modules.MessageWebService;
import com.huaxia.plaze.modules.general.domain.GeneralData;
import com.huaxia.plaze.modules.general.service.GeneralService;
import com.huaxia.util.SpringContextUtil;

import net.sf.json.JSONObject;

/**
 * 
 * @author dingguofeng
 * 
 * 三方平台总接口，对外发布统一接口
 *
 */
@Service
@WebService(serviceName = "TRN", endpointInterface = "com.huaxia.plaze.modules.MessageWebService")
public class TrnGeneralWebservice implements MessageWebService {
	
	private final static Logger logger = LoggerFactory.getLogger(TrnGeneralWebservice.class);
	
	@Resource
	private GeneralService generalService;

	@Override
	public String invoke(String jsonRequest) {
		
		logger.info("接收到渠道端传过来的参数>>"+jsonRequest);
		
		String trnCode = "";
		
		JSONObject jsonObject = null;
		try {
			jsonObject = JSONObject.fromObject(jsonRequest);
		} catch (Exception e) {
			e.printStackTrace();
			Map<String, Object> head = new HashMap<String, Object>();
			head.put("RESPONSE_CHANNEL", "PLAZE");
			head.put("TRN_ID", "");

			Map<String, Object> body = new HashMap<String, Object>();
			body.put("RESPONSE_CODE", "999999");
			body.put("RESPONSE_DESC", "处理失败,请求参数不是JSON格式");
			body.put("RESPONSE_BODY", "");

			Map<String, Object> response = new HashMap<String, Object>();
			response.put("HEAD", head);
			response.put("BODY", body);

			Map<String, Object> params = new HashMap<String, Object>();
			params.put("RESPONSE", response);

			JSONObject json = JSONObject.fromObject(params);
			return json.toString();
		}
		if (jsonObject != null) {
			if (jsonObject.containsKey("REQUEST") && jsonObject.getString("REQUEST") != null
					&& !"".equals(jsonObject.getString("REQUEST"))) {
				JSONObject jsonRequet = JSONObject.fromObject(jsonObject.getString("REQUEST"));
				if (jsonRequet.containsKey("HEAD") && jsonRequet.getString("HEAD") != null
						&& !"".equals(jsonRequet.getString("HEAD"))) {
					JSONObject jsonHead = JSONObject.fromObject(jsonRequet.getString("HEAD"));
					if (jsonHead.containsKey("TRN_CODE") && jsonHead.getString("TRN_CODE") != null
							&& !"".equals(jsonHead.getString("TRN_CODE"))) {
						trnCode = jsonHead.getString("TRN_CODE");
					}
				}
			}
		}
		
		/** 反馈给渠道方的报文 */
		String response = "";

		try {
			/** 根据trncode来判断是否存在对应的数据源接口 */
			GeneralData generalData = generalService.findGeneralData(trnCode);
			if(generalData != null){
				/** 获取处理该数据源的发起查询类和执行方法 */
				Class<?> clazz = Class.forName(generalData.getClassName());
				Object obj = SpringContextUtil.getBean(generalData.getBeanName());
				Method method = clazz.getMethod(generalData.getMethod(), String.class);
				
				/** 执行查询类的方法,以发起第三方查询 */
				Object result = method.invoke(obj, jsonRequest);
				if(result != null){
					response = result.toString();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("处理异常",e);
			Map<String, Object> head = new HashMap<String, Object>();
			head.put("RESPONSE_CHANNEL", "PLAZE");
			head.put("TRN_ID", "");

			Map<String, Object> body = new HashMap<String, Object>();
			body.put("RESPONSE_CODE", "999999");
			body.put("RESPONSE_DESC", "处理失败");
			body.put("RESPONSE_BODY", "");

			Map<String, Object> responserep = new HashMap<String, Object>();
			responserep.put("HEAD", head);
			responserep.put("BODY", body);

			Map<String, Object> params = new HashMap<String, Object>();
			params.put("RESPONSE", responserep);

			JSONObject json = JSONObject.fromObject(params);
			response = json.toString();
		}
		return response;
	}
}
