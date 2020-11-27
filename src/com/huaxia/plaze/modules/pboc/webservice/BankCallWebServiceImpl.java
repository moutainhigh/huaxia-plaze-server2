package com.huaxia.plaze.modules.pboc.webservice;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.jws.WebService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.huaxia.plaze.modules.pboc.service.BankTaskCallPlazeService;
import com.huaxia.plaze.util.TaskParamUtil;
import com.huaxia.plaze.util.TaskStatusUtil;

import net.sf.json.JSONObject;



@Service
@WebService(serviceName="BankCallWebService",endpointInterface="com.huaxia.plaze.modules.pboc.webservice.BankCallWebService")
public class BankCallWebServiceImpl implements BankCallWebService {
	
	private static Logger logger = LoggerFactory.getLogger(BankCallWebServiceImpl.class);
	@Resource(name = "bankTaskCallPlazeService")
	private BankTaskCallPlazeService bankTaskCallPlazeService;
	public BankTaskCallPlazeService getBankTaskCallPlazeService() {
		return bankTaskCallPlazeService;
	}
	public void setBankTaskCallPlazeService(BankTaskCallPlazeService bankTaskCallPlazeService) {
		this.bankTaskCallPlazeService = bankTaskCallPlazeService;
	}

	@Override
	public void queryBankMessage(String arg0) {
		
//		if(logger.isInfoEnabled()){
//			logger.info("queryBankMessageParam:{}",arg0);
//		}
		JSONObject json =JSONObject.fromObject(arg0);
		String sourceId = null ;
		String source = "0" ;
		String REQUEST_SYSTEM = null;
		if( json.containsKey("REQUEST") && !"".equals(json.getString("REQUEST")) ){
			JSONObject jsonRequest =JSONObject.fromObject(json.getString("REQUEST"));
			
			if( jsonRequest.containsKey("HEAD") && !"".equals(jsonRequest.getString("HEAD")) ){
				JSONObject jsonRequestHead =JSONObject.fromObject(jsonRequest.getString("HEAD"));
				
				if( jsonRequestHead.containsKey("REQUEST_SYSTEM") && !"".equals(jsonRequestHead.getString("REQUEST_SYSTEM")) ){
					REQUEST_SYSTEM = jsonRequestHead.getString("REQUEST_SYSTEM");
				}
				if( jsonRequestHead.containsKey("TRN_ID") && !"".equals(jsonRequestHead.getString("TRN_ID")) ){
					sourceId = jsonRequestHead.getString("TRN_ID");
				}
			}
			
			if( jsonRequest.containsKey("BODY") && !"".equals(jsonRequest.getString("BODY")) ){
				JSONObject jsonRequestBody =JSONObject.fromObject(jsonRequest.getString("BODY"));
				String identityType = jsonRequestBody.getString("CERT_TYPE");
				String identityNo = jsonRequestBody.getString("CERT_NO");
				String name = jsonRequestBody.getString("NAME");
				String queryFlag = null ;
				if( jsonRequestBody.containsKey("QUERY_TYPE") && !"".equals(jsonRequestBody.getString("QUERY_TYPE")) ){
					queryFlag = jsonRequestBody.getString("QUERY_TYPE");
				}else{
					queryFlag = "2"; //默认走30 天判断逻辑
				}
				String queryLevel = "6";//默认最低查询等级
				Map<String,String> params = new HashMap<String,String>();
				params.put("sourceId", sourceId);
				params.put("taskIp", TaskParamUtil.TASK_IP);
				params.put("identityType", identityType);
				params.put("identityNo", identityNo);
				params.put("name", name);
				if("CAMS".equals(REQUEST_SYSTEM)){
					source = "1" ;
					queryLevel = "1";
				}
				if("0".equals(source)){//三方平台人工
					queryLevel = "0";
				}
				params.put("queryFlag", queryFlag);
				params.put("queryLevel", queryLevel);
				params.put("source", source);
				params.put("taskStatus", TaskStatusUtil.INITIAL);
				params.put("requestNum", "0");
				params.put("failureNum", "0");
				params.put("lstOptUser", TaskParamUtil.CURR_USER);
				bankTaskCallPlazeService.saveBankTaskCallPlaze(params);
			}
			
		}
		
		
	}
	
	
}