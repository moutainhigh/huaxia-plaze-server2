package com.huaxia.plaze.modules.trdrequest.webservice;

import java.net.URL;

import javax.annotation.Resource;
import javax.jws.WebService;

import org.codehaus.xfire.client.Client;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.huaxia.plaze.modules.MessageWebService;
import com.huaxia.plaze.modules.trdrequest.domain.TrdRequest;
import com.huaxia.plaze.modules.trdrequest.service.TrdRequestService;

import net.sf.json.JSONObject;

@Service
@WebService(serviceName = "TRNREQUEST", endpointInterface = "com.huaxia.plaze.modules.MessageWebService")
public class TrdRequestServer implements MessageWebService {
	
	private final static Logger logger = LoggerFactory.getLogger(TrdRequestServer.class);
	
	@Resource
	private TrdRequestService trdRequestService;
	
	public String invoke(String jsonRequest){
		
		logger.info(jsonRequest);
		
		/** 如果执行到此处，说明参数中一定能get到trncode,所以不用加非空判断 */
		JSONObject jsonObject = JSONObject.fromObject(jsonRequest);
		JSONObject jsonRequet = JSONObject.fromObject(jsonObject.getString("REQUEST"));
		JSONObject jsonHead = JSONObject.fromObject(jsonRequet.getString("HEAD"));
		String trnCode = jsonHead.getString("TRN_CODE");
		
		String response = "";
		TrdRequest trdRequest = trdRequestService.findSetData(trnCode);
		if(trdRequest != null){
			Client client = null;
			try {
				client = new Client(new URL(trdRequest.getRequestUrl()));
				Object[] result = client.invoke(trdRequest.getMethod(), new Object[] { jsonRequest });
				if(result != null){
					response = String.valueOf(result[0]);
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return response;
	}

}
