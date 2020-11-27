package com.huaxia.plaze.modules.unicom.webservice;

import java.net.URL;

import javax.annotation.Resource;
import javax.jws.WebService;

import org.codehaus.xfire.client.Client;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.huaxia.opas.util.AppConfig;
import com.huaxia.plaze.modules.MessageWebService;
import com.huaxia.plaze.modules.unicom.domain.UnicomPhone;
import com.huaxia.plaze.modules.unicom.domain.UnicomPhoneMsgResponse;
import com.huaxia.plaze.modules.unicom.domain.UnicomPhoneTrnRequest;
import com.huaxia.plaze.modules.unicom.service.UnicomPhoneService;
import com.huaxia.plaze.modules.unicom.util.CheckPhone;

import net.sf.json.JSONObject;

/**
 * 
 * @author dingguofeng
 * 
 * 联通手机实名制,渠道(包括审批,网申)调用webservice方法,
 *
 */
@Service
@WebService(serviceName = "WST001100", endpointInterface = "com.huaxia.plaze.modules.MessageWebService")
public class UnicomPhoneWebservice implements MessageWebService {
	
	private final static Logger logger = LoggerFactory.getLogger(UnicomPhoneWebservice.class);
	
	@Resource
	private UnicomPhoneService unicomPhoneService;

	@Override
	public String invoke(String jsonRequest) {
		
		logger.debug("接收到渠道端传过来的参数>>"+jsonRequest);
		
		/** 接收渠道(包括审批,网申)传过来的请求参数,分解成各变量 */
		String requestChannel = "";
		String trnId          = "";
		String trnCode        = "";
		String queryMode      = "";
		String certType       = "";
		String certNo         = "";
		String name           = "";
		String mobile         = "";
		String carrier        = "";
		
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
					if (jsonHead.containsKey("TRN_CODE") && jsonHead.getString("TRN_CODE") != null
							&& !"".equals(jsonHead.getString("TRN_CODE"))) {
						trnCode = jsonHead.getString("TRN_CODE");
					}
				}
				
				if (jsonRequet.containsKey("BODY") && jsonRequet.getString("BODY") != null
						&& !"".equals(jsonRequet.getString("BODY"))) {
					JSONObject jsonBody = JSONObject.fromObject(jsonRequet.getString("BODY"));
					if (jsonBody.containsKey("QUERY_MODE") && jsonBody.getString("QUERY_MODE") != null
							&& !"".equals(jsonBody.getString("QUERY_MODE"))) {
						queryMode = jsonBody.getString("QUERY_MODE");
					}
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
					if (jsonBody.containsKey("MOBILE") && jsonBody.getString("MOBILE") != null
							&& !"".equals(jsonBody.getString("MOBILE"))) {
						mobile = jsonBody.getString("MOBILE");
					}
					
					/** 获取手机号后,同时判断手机号的运营商类别,并加入到请求json串中 */
					carrier = CheckPhone.getCarrier(mobile);
					
					jsonBody.put("CARRIER", carrier);
					jsonRequet.put("BODY", jsonBody.toString());
					jsonObject.put("REQUEST", jsonRequet.toString());
				}
				
			}
		}
		
		/** 将请求参数入库 */
		UnicomPhoneTrnRequest unicomPhoneTrnRequest = new UnicomPhoneTrnRequest();
		unicomPhoneTrnRequest.setCrtUser("PLAZE");
		unicomPhoneTrnRequest.setTrnId(trnId);
		unicomPhoneTrnRequest.setRequestChannel(requestChannel);
		unicomPhoneTrnRequest.setQueryMode(queryMode);
		unicomPhoneTrnRequest.setCertType(certType);
		unicomPhoneTrnRequest.setCertNo(certNo);
		unicomPhoneTrnRequest.setName(name);
		unicomPhoneTrnRequest.setMobile(mobile);
		unicomPhoneService.saveUnicomPhoneTrnRequest(unicomPhoneTrnRequest);
		
		/** 调用dmz的webservice,发起三方请求 */
		Client client = null;
		String message = "";
		String responseCode = "";
		//作为返回报文
		String response = null;
		try {
			client = new Client(new URL(AppConfig.getInstance().getValue("unicom.phone.dmz.webservice.url")));
			
			/** 此处的jsonObject.toString()作为参数,其中包含CARRIER运营商类别 */
			Object[] obj = new Object[] { jsonObject.toString() };
			Object[] result = client.invoke("invoke", obj);
			
			if(result != null){
				JSONObject jsonResponse = JSONObject.fromObject(String.valueOf(result[0]));
				if (jsonResponse.containsKey("RESPONSE") && jsonResponse.getString("RESPONSE") != null
						&& !"".equals(jsonResponse.getString("RESPONSE"))) {
					JSONObject jsonRes = JSONObject.fromObject(jsonResponse.getString("RESPONSE"));
					if (jsonRes.containsKey("BODY") && jsonRes.getString("BODY") != null
							&& !"".equals(jsonRes.getString("BODY"))) {
						JSONObject jsonBody = JSONObject.fromObject(jsonRes.getString("BODY"));
						if (jsonBody.containsKey("RESPONSE_BODY") && jsonBody.getString("RESPONSE_BODY") != null
								&& !"".equals(jsonBody.getString("RESPONSE_BODY"))) {
							message = jsonBody.getString("RESPONSE_BODY");
						}
						if (jsonBody.containsKey("RESPONSE_CODE") && jsonBody.getString("RESPONSE_CODE") != null
								&& !"".equals(jsonBody.getString("RESPONSE_CODE"))) {
							responseCode = jsonBody.getString("RESPONSE_CODE");
						}
						
						/** 如果渠道方是审批系统,需要将运营商类别加入返回报文中返回,如果是其他渠道(网申)
						 *  则不需要加入 */
						if("CAMS".equals(requestChannel)){
							jsonBody.put("CARRIER", carrier);
							jsonRes.put("BODY", jsonBody.toString());
							jsonResponse.put("RESPONSE", jsonRes.toString());
						}
						
						//为return的String赋值
						response = String.valueOf(jsonResponse.toString());
						
						if("999999".equals(responseCode)){
							return String.valueOf(jsonResponse.toString());
						}
						
					}
					
					/** 原始报文入库 */
					UnicomPhoneMsgResponse unicomPhoneMsgResponse = new UnicomPhoneMsgResponse();
					unicomPhoneMsgResponse.setCrtUser(requestChannel);
					unicomPhoneMsgResponse.setTrnId(trnId);
					unicomPhoneMsgResponse.setMessageBody(message);
					unicomPhoneService.saveUnicomPhoneMsgResponse(unicomPhoneMsgResponse);
					
				}
				
				UnicomPhone unicomPhone = new UnicomPhone();
				unicomPhone.setCrtUser(requestChannel);
				unicomPhone.setTrnId(trnId);
				unicomPhone.setCarrier(carrier);
				unicomPhone.setCertNo(certNo);
				JSONObject jsMessage = JSONObject.fromObject(message);
				if(jsMessage != null){
					if(jsMessage.containsKey("status") && jsMessage.getString("status")!=null 
							&& !"".equals(jsMessage.getString("status"))){
						unicomPhone.setStatus(jsMessage.getString("status"));
					}
					if(jsMessage.containsKey("code") && jsMessage.getString("code")!=null 
							&& !"".equals(jsMessage.getString("code"))){
						unicomPhone.setCode(jsMessage.getString("code"));
					}
					if(jsMessage.containsKey("errorDesc") && jsMessage.getString("errorDesc")!=null 
							&& !"".equals(jsMessage.getString("errorDesc"))){
						unicomPhone.setErrorDesc(jsMessage.getString("errorDesc"));
					}
					if(jsMessage.containsKey("checkResult") && jsMessage.getString("checkResult")!=null 
							&& !"".equals(jsMessage.getString("checkResult")) && !"null".equals(jsMessage.getString("checkResult"))){
						unicomPhone.setCheckResult(jsMessage.getString("checkResult"));
					}
				}
				unicomPhoneService.saveUnicomPhone(unicomPhone);
				
				/** 如果是审批系统的请求,jsonResponse.toString()包含运营商类别CARRIER */
				return String.valueOf(jsonResponse.toString());
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("联通手机实名制请求查询异常"+trnId, e);
			return response;
		}
		
		return response;
	}

}
