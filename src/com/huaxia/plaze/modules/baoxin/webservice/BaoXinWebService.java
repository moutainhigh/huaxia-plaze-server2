package com.huaxia.plaze.modules.baoxin.webservice;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.jws.WebService;

import org.apache.commons.lang.StringUtils;
import org.codehaus.xfire.client.Client;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.huaxia.opas.util.AppConfig;
import com.huaxia.plaze.modules.MessageWebService;
import com.huaxia.plaze.modules.baoxin.domain.BaoXinBase;
import com.huaxia.plaze.modules.baoxin.domain.BaoXinRequest;
import com.huaxia.plaze.modules.baoxin.domain.BaoXinResponse;
import com.huaxia.plaze.modules.baoxin.service.BaoXinService;
import com.huaxia.plaze.modules.baoxin.util.BaoXinUtil;
import com.huaxia.plaze.modules.nciic.util.ErrorCode;
import com.huaxia.util.SpringContextUtil;
@Component
public class BaoXinWebService {

	private static final Logger logger = LoggerFactory.getLogger(BaoXinWebService.class);
	@Resource
	private BaoXinService baoXinServiceImpl;
	
	public String invoke(String jsonRequest) {

		//一，解析请求报文
		BaoXinRequest request = BaoXinUtil.parseRequest(jsonRequest);
		if(request == null){
			return BaoXinUtil.getResponseJson("", ErrorCode.NO_PASS, "");
		}
		int count = baoXinServiceImpl.selectCountOfDay();
		String insurerUuid = BaoXinUtil.buildInsurerUuid(count);
		JSONObject jsonObject = JSON.parseObject(jsonRequest);
		JSONObject jsonBody = jsonObject.getJSONObject("REQUEST").getJSONObject("BODY");
		jsonBody.put("INSURER_UUID", insurerUuid);
		jsonRequest = JSON.toJSONString(jsonObject);
		request.setInsurerUuid(insurerUuid);
		request.setCrtUser("PLAZE");
		//二，保存请求报文
		 baoXinServiceImpl.saveRequest(request);
		 //24小时验证，24小时查库
		 try {
				String messageBody = baoXinServiceImpl.findBody(request.getCertNo());
				if(StringUtils.isNotBlank(messageBody)){
					Map<String, Object> head = new HashMap<String, Object>();
					head.put("RESPONSE_CHANNEL", "PLAZE");
					head.put("TRN_ID", request.getTrnId());

					Map<String, Object> body = new HashMap<String, Object>();
					body.put("RESPONSE_CODE", "000000");
					body.put("RESPONSE_DESC", "处理成功");
					body.put("RESPONSE_BODY", messageBody);

					Map<String, Object> response = new HashMap<String, Object>();
					response.put("HEAD", head);
					response.put("BODY", body);

					Map<String, Object> params = new HashMap<String, Object>();
					params.put("RESPONSE", response);

					JSONObject json = new JSONObject(params);
					return json.toString();
				}
			} catch (Exception e1) {
				e1.printStackTrace();
				logger.error("保信汽车数据24小时查库失败",e1);
			}
		 
		 //联机查询
		 String response = "";
		 String result = "";
		 if("1".equals(request.getQueryMode())){
			 Client client = null;
			 try {
				URL url = new URL(AppConfig.getInstance().getValue("baoxin_dmz_webservice.url"));
				 client = new Client(url);
				 Object[] results = client.invoke("invoke", new Object[]{jsonRequest});
				 result = String.valueOf(results[0]);
				 JSONObject jsonObj= JSONObject.parseObject(result);
				 JSONObject responseObj = jsonObj.getJSONObject("RESPONSE");
				 JSONObject bodyObj = responseObj.getJSONObject("BODY");
				 if(!"000000".equals(bodyObj.getString("RESPONSE_CODE"))){
					 return result;
				 }else{
					 response = bodyObj.getString("RESPONSE_BODY");
				 }
			} catch (Exception e) {
				logger.error("保信汽车查询异常"+request.getTrnId(), e);
			}
		 }
		 //保存原始响应报文
		 BaoXinResponse baoXinResponse = new BaoXinResponse();
		 baoXinResponse.setCrtUser(request.getRequestChannel());
		 baoXinResponse.setTrnId(request.getTrnId());
		 baoXinResponse.setMessageBody(response);
		 baoXinServiceImpl.saveReponse(baoXinResponse);
		 //保存解析报文信息
		 BaoXinBase base = BaoXinUtil.parseMessageBody(response,request.getTrnId());
		 if(null != base){
			 base.setTrnId(request.getTrnId());
			 base.setCrtUser(request.getRequestChannel());
			 base.setCertNo(request.getCertNo());
			 baoXinServiceImpl.saveBase(base);
		 }
		return result;
	}

}
