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
import com.huaxia.plaze.modules.unicom.domain.UnicomAddress;
import com.huaxia.plaze.modules.unicom.domain.UnicomAddressMsgResponse;
import com.huaxia.plaze.modules.unicom.domain.UnicomAddressTrnRequest;
import com.huaxia.plaze.modules.unicom.service.UnicomAddressService;
import com.huaxia.plaze.modules.unicom.util.CheckPhone;
import com.huaxia.plaze.util.UniaddinforUtil;

import net.sf.json.JSONObject;

/**
 * 联通地址类信息(居住地址)
 * @author lipengfei
 *
 */
@Service
@WebService(serviceName = "WST001103", endpointInterface = "com.huaxia.plaze.modules.MessageWebService")
public class UnicomAddressLiveWebservice implements MessageWebService{

	private final static Logger logger = LoggerFactory.getLogger(UnicomAddressLiveWebservice.class);
	
	// 解析报文变量
    String requestChannel = ""; // 请求渠道
	String trnId          = ""; // 交易编号
	String trnCode        = ""; // 交易代码
	String queryMode      = ""; // 查询类型
	String name           = ""; // 姓名
	String mobile         = "";	// 手机号码
	String address		  = ""; // 详细地址
	String carrier		  = ""; // 手机运行商类别
	String message 		  = ""; // 响应报文报文体
	String responseCode   = ""; // 响应编码
	String checkDesc 	  = ""; // 校验结果中文描述
	
	// 联通地址类信息service	
	@Resource
	private UnicomAddressService unicomAddressService;

	@Override
	public String invoke(String jsonRequest) {

		// 接收opas-plaze-server的请求json
//		logger.info("接收到联通地址类(居住地址)请求json>>"+jsonRequest);
		
		// 解析cams请求报文,以第三方查询平台报文交互接口1.0.8为准
		JSONObject jsonObject = JSONObject.fromObject(jsonRequest);
		if (jsonObject != null) {
			if (jsonObject.containsKey("REQUEST") && jsonObject.getString("REQUEST") != null
					&& !"".equals(jsonObject.getString("REQUEST"))) {
				JSONObject jsonRequet = JSONObject.fromObject(jsonObject.getString("REQUEST"));
				// 报文head部分
				if (jsonRequet.containsKey("HEAD") && jsonRequet.getString("HEAD") != null
						&& !"".equals(jsonRequet.getString("HEAD"))) {
					JSONObject jsonHead = JSONObject.fromObject(jsonRequet.getString("HEAD"));
					// 请求渠道
					if (jsonHead.containsKey("REQUEST_CHANNEL") && jsonHead.getString("REQUEST_CHANNEL") != null
							&& !"".equals(jsonHead.getString("REQUEST_CHANNEL"))) {
						requestChannel = jsonHead.getString("REQUEST_CHANNEL");
					}
					// 交易编号
					if (jsonHead.containsKey("TRN_ID") && jsonHead.getString("TRN_ID") != null
							&& !"".equals(jsonHead.getString("TRN_ID"))) {
						trnId = jsonHead.getString("TRN_ID");
					}
					// 交易代码
					if (jsonHead.containsKey("TRN_CODE") && jsonHead.getString("TRN_CODE") != null
							&& !"".equals(jsonHead.getString("TRN_CODE"))) {
						trnCode = jsonHead.getString("TRN_CODE");
					}
				}
				
				// 报文body部分
				if (jsonRequet.containsKey("BODY") && jsonRequet.getString("BODY") != null
						&& !"".equals(jsonRequet.getString("BODY"))) {
					JSONObject jsonBody = JSONObject.fromObject(jsonRequet.getString("BODY"));
					// 查询类型
					if (jsonBody.containsKey("QUERY_MODE") && jsonBody.getString("QUERY_MODE") != null
							&& !"".equals(jsonBody.getString("QUERY_MODE"))) {
						queryMode = jsonBody.getString("QUERY_MODE");
					}
					// 姓名
					if (jsonBody.containsKey("NAME") && jsonBody.getString("NAME") != null
							&& !"".equals(jsonBody.getString("NAME"))) {
						name = jsonBody.getString("NAME");
					}
					// 手机号
					if (jsonBody.containsKey("MOBILE") && jsonBody.getString("MOBILE") != null
							&& !"".equals(jsonBody.getString("MOBILE"))) {
						mobile = jsonBody.getString("MOBILE");
						// 运行商类别
						carrier = CheckPhone.getCarrier(mobile);
					}
					// 详细地址
					if (jsonBody.containsKey("CODDA") && jsonBody.getString("CODDA") != null
							&& !"".equals(jsonBody.getString("CODDA"))) {
						address = jsonBody.getString("CODDA");
					}
					 
					// 将运营商类别拼入请求中
					jsonBody.put("CARRIER", carrier);
					jsonRequet.put("BODY", jsonBody.toString());
					jsonObject.put("REQUEST", jsonRequet.toString());
				}
				
			}
		}
		
//		logger.info("联通地址类(居住地址)请求DMZjson>>"+jsonObject);
		
		// 保存请求参数
		UnicomAddressTrnRequest uniaddinforRequest = new UnicomAddressTrnRequest();
		uniaddinforRequest.setCrtUser("PLAZE"); // 创建用户
		uniaddinforRequest.setTrnId(trnId);	// 交易编号
		uniaddinforRequest.setRequestChannel(requestChannel); // 请求渠道
		uniaddinforRequest.setQueryMode(queryMode); //查询类型
		uniaddinforRequest.setName(name); // 姓名
		uniaddinforRequest.setMobile(mobile); // 手机号码
		uniaddinforRequest.setCarrier(carrier); // 手机运营商
		uniaddinforRequest.setApiKey("360016"); // 产品ID
		uniaddinforRequest.setAddress(address); //详细地址
		unicomAddressService.saveUnicomAddressTrnRequest(uniaddinforRequest);
		
		
		// 调用DMZ,发起请求
		Client client = null;
		// DMZ的返回结果报文
		String response = null;
		try{
			client = new Client(new URL(AppConfig.getInstance().getValue("unicom.address.live.dmz.webservice.url")));
			// 请求报文添加了运营商类别
			Object[] obj = new Object[] { jsonObject.toString() };
			Object[] result = client.invoke("invoke", obj);
						
//			logger.info("居住地址类返回结果>>"+result);
			
			// 解析DMZ返回报文
			if(result != null && !"".equals(result)){
				JSONObject jsonResponse = JSONObject.fromObject(String.valueOf(result[0]));
				// 返回结果报文 RESPONSE
				JSONObject jsonRes = null;
				// 返回结果报文报文体 BODY
				JSONObject jsonBody = null;
				// 返回报文体中的 RESPONSE_BODY
				JSONObject jsMessage = null;
				
//				logger.info("联通地址类(居住地址)DMZ返回结果报文>>"+jsonResponse);
				
				if (jsonResponse.containsKey("RESPONSE") && jsonResponse.getString("RESPONSE") != null
						&& !"".equals(jsonResponse.getString("RESPONSE"))) {
					jsonRes = JSONObject.fromObject(jsonResponse.getString("RESPONSE"));
					if (jsonRes.containsKey("BODY") && jsonRes.getString("BODY") != null
							&& !"".equals(jsonRes.getString("BODY"))) {
						jsonBody = JSONObject.fromObject(jsonRes.getString("BODY"));
						if (jsonBody.containsKey("RESPONSE_BODY") && jsonBody.getString("RESPONSE_BODY") != null
								&& !"".equals(jsonBody.getString("RESPONSE_BODY"))) {
							// 获取返回报文的报文体 message不用于操作,只保存至响应结果存储表
							message = jsonBody.getString("RESPONSE_BODY");
							jsMessage = JSONObject.fromObject(message);
						}
						if (jsonBody.containsKey("RESPONSE_CODE") && jsonBody.getString("RESPONSE_CODE") != null
								&& !"".equals(jsonBody.getString("RESPONSE_CODE"))) {
							// 获取响应编码
							responseCode = jsonBody.getString("RESPONSE_CODE");
						}
						
						// 如果是审批的请求,返回报文拼接手机运营商以及手机号码
						if("CAMS".equals(requestChannel)){
							jsonBody.put("mobile", mobile);
							jsonBody.put("CARRIER", carrier);
							jsonRes.put("BODY", jsonBody.toString());
							jsonResponse.put("RESPONSE", jsonRes.toString());		
						}
												
						// 判断响应编码,999999是DMZ请求异常的返回码,直接返回DMZ的结果报文
						if("999999".equals(responseCode)){
							return String.valueOf(jsonResponse.toString());
						}
						
						//转String,return
						response = String.valueOf(jsonResponse.toString());
					}
					// 保存DMZ整体结果报文
					UnicomAddressMsgResponse unicomAddressMsgResponse = new UnicomAddressMsgResponse();
					unicomAddressMsgResponse.setCrtUser(requestChannel);
					unicomAddressMsgResponse.setTrnId(trnId);
					unicomAddressMsgResponse.setMessageBody(message);
					unicomAddressService.saveUnicomAddressMsgResponse(unicomAddressMsgResponse);
								
				}
				
				//解析DMZ结果报文,入库
				UnicomAddress unicomAddress = new UnicomAddress();
				unicomAddress.setCrtUser(requestChannel); // 创建用户
				unicomAddress.setTrnId(trnId); // 交易编号
				unicomAddress.setApiKey("360016"); //产品ID
				unicomAddress.setCarrier(carrier); //运营商类别
				unicomAddress.setMobile(mobile); // 手机号
				
				// 解析结果报文体
				if(jsMessage != null && !"".equals(jsMessage)){
					// 查询状态码
					if(jsMessage.containsKey("status") && jsMessage.getString("status")!=null 
							&& !"".equals(jsMessage.getString("status"))){
						unicomAddress.setStatus(jsMessage.getString("status"));		
					}
					// 返回码
					if(jsMessage.containsKey("code") && jsMessage.getString("code")!=null 
							&& !"".equals(jsMessage.getString("code"))){
						unicomAddress.setCode(jsMessage.getString("code"));	
					}
					// 返回码中文描述
					if(jsMessage.containsKey("errorDesc") && jsMessage.getString("errorDesc")!=null 
							&& !"".equals(jsMessage.getString("errorDesc"))){
						unicomAddress.setErrorDesc(jsMessage.getString("errorDesc"));
					}
					// 校验结果
					if(jsMessage.containsKey("checkResult") && jsMessage.getString("checkResult")!=null
							&& !"".equals(jsMessage.getString("checkResult"))){
						String checkResult = jsMessage.getString("checkResult");
						unicomAddress.setCheckResult(checkResult);
						// 获取校验结果中文描述(校验结果,手机运营商,产品ID)
						checkDesc = UniaddinforUtil.gainCheckDesc(checkResult, carrier,"360016");
						unicomAddress.setCheckDesc(checkDesc);
						// 将校验结果的中文描述添加进返回报文						
						jsonBody.put("checkDesc", checkDesc);
						jsonRes.put("BODY", jsonBody.toString());
						jsonResponse.put("RESPONSE", jsonRes.toString());
					}
				}
				unicomAddressService.saveUnicomAddress(unicomAddress);
				
//				logger.info("居住地址类返回cams的报文>>"+jsonResponse.toString());
				
				// 将DMZ的返回报文返回给cams
				return String.valueOf(jsonResponse.toString());							
			}
		}catch(Exception e){
			e.printStackTrace();
			logger.error("联通地址类信息(居住地址)请求查询异常,交易编号:"+trnId, e);
			return response;
		}
				
		return response;
	}
	
	
}
