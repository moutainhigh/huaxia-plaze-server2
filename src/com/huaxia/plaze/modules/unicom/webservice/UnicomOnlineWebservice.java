package com.huaxia.plaze.modules.unicom.webservice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.jws.WebService;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.huaxia.opas.util.AppConfig;
import com.huaxia.plaze.common.MessageBuildUtil;
import com.huaxia.plaze.common.MessageParseUtil;
import com.huaxia.plaze.modules.MessageWebService;
import com.huaxia.plaze.modules.unicom.domain.UnicomOnline;
import com.huaxia.plaze.modules.unicom.domain.UnicomOnlineMsgResponse;
import com.huaxia.plaze.modules.unicom.domain.UnicomOnlineTrnRequest;
import com.huaxia.plaze.modules.unicom.service.UnicomOnlineService;
import com.huaxia.plaze.modules.unicom.util.CheckPhone;
import com.huaxia.plaze.util.WebServiceUtil;

import net.sf.json.JSONObject;

/**
 * 
 * @author dingguofeng
 * 
 * 联通在网时长,渠道(审批)调用webservice方法,
 *
 */
@Service
@WebService(serviceName = "WST001101", endpointInterface = "com.huaxia.plaze.modules.MessageWebService")
public class UnicomOnlineWebservice implements MessageWebService {
	
	private final static Logger logger = LoggerFactory.getLogger(UnicomOnlineWebservice.class);

	@Resource
	private UnicomOnlineService unicomOnlineService;
	
	@Override
	public String invoke(String jsonRequest) {

		// 响应报文结果
		String responseMessage = "";

		// 查询结果集列表
		List<UnicomOnlineMsgResponse> unicomOnlineMsgResponseList = null;

		// 响应参数
		Map<String, String> responseArgs = new HashMap<String, String>();

		// 决策参数
		boolean decision = false;

		// [1] 请求参数解析
		Map<String, String> requestArgs = MessageParseUtil.parseRequestMessage(jsonRequest);

		// [2] 请求参数持久化
		saveRequestParams(requestArgs);
		
        //重新组装发送报文，添加数据
		jsonRequest = assembleRequestMessage(requestArgs);
		
		// [3] 根据"查询模式"进行查询动作决策
		String queryMode = requestArgs.get("QUERY_MODE");
		String requestChannel = requestArgs.get("REQUEST_CHANNEL");
		String mobileNum = requestArgs.get("MOBILE");
		JSONObject jsonResponse = null;
		switch (queryMode) {
		// 联机查询
		case "1":
			responseMessage = queryRequestInvoke(jsonRequest);
			decision = StringUtils.isBlank(responseMessage);
			logger.info("在网时长查询模式 [ {} ] 决策路由 [ {} ]", new Object[] { queryMode, (decision ? "无此数据" : "联机查询") });
			if (decision) {
				responseArgs.put("TRN_ID", requestArgs.get("TRN_ID"));
				responseArgs.put("RESPONSE_CODE", "999998");
				responseArgs.put("RESPONSE_DESC", "处理失败");
				responseMessage = MessageBuildUtil.buildResponseMessage(responseArgs);
			} else {
				int result = 0;

				// 1.响应报文持久化
				responseArgs = MessageParseUtil.parseResponseMessage(responseMessage);
				result = saveResponseParams(responseArgs);
				if (result > 0) {
					logger.info("在网时长响应报文持久化成功! 交易编号 [ {} ], 查询模式 [ {} ]",
							new Object[] { requestArgs.get("TRN_ID"), queryMode });
				}

				// 2.响应数据持久化
				result = saveResponseData(responseArgs.get("RESPONSE_BODY"), requestArgs);
				if (result > 0) {
					logger.info("在网时长应用数据持久化成功! 交易编号 [ {} ], 查询模式 [ {} ]",
							new Object[] { requestArgs.get("TRN_ID"), queryMode });
				}
			}
			break;
		// 联机查找
		case "2":
			responseArgs.put("TRN_ID", requestArgs.get("TRN_ID"));

			String name = requestArgs.get("NAME");
			String certNo = requestArgs.get("CERT_NO");
			String mobile = requestArgs.get("MOBILE");
			unicomOnlineMsgResponseList = unicomOnlineService.queryListByParams(certNo, mobile, name);
			decision = (unicomOnlineMsgResponseList == null || unicomOnlineMsgResponseList.size() == 0);
			logger.info("在网时长查询模式 [ {} ] 决策路由 [ {} ]", new Object[] { queryMode, (decision ? "联机查询" : "联机查找") });
			if (decision) {
				responseMessage = MessageBuildUtil.buildResponseMessage(responseArgs);
			} else {
				responseArgs.put("RESPONSE_BODY", unicomOnlineMsgResponseList.get(0).getMessageBody());
				responseMessage = MessageBuildUtil.buildResponseMessage(responseArgs);
				logger.info("在网时长查找交易编号 [ {} ] 映射交易编号 [ {} ]",
						new Object[] { (unicomOnlineMsgResponseList.get(0)).getTrnId(), requestArgs.get("TRN_ID") });
			}
			break;
		// 联机查找查询
		/** 删除24小时查库逻辑,恢复信审请求,返回报文中增加运营商类别标签 */
		case "3":
//			unicomOnlineMsgResponseList = unicomOnlineService.query24HoursListByParams(requestArgs.get("CERT_NO"),
//					requestArgs.get("MOBILE"), requestArgs.get("NAME"));
//			decision = (unicomOnlineMsgResponseList == null || unicomOnlineMsgResponseList.size() == 0);
//			logger.info("在网时长查询模式 [ {} ] 决策路由 [ {} ]", new Object[] { queryMode, (decision ? "联机查询" : "联机查找") });
//			if (decision) {
				responseMessage = queryRequestInvoke(jsonRequest);
				if (StringUtils.isBlank(responseMessage)) {
					responseArgs.put("TRN_ID", requestArgs.get("TRN_ID"));
					responseArgs.put("RESPONSE_CODE", "999999");
					responseArgs.put("RESPONSE_DESC", "处理失败");
					responseMessage = MessageBuildUtil.buildResponseMessage(responseArgs);
					jsonResponse = JSONObject.fromObject(responseMessage);
				} else {
					int result = 0;

					// 1.响应报文持久化
					responseArgs = MessageParseUtil.parseResponseMessage(responseMessage);
					if("999999".equals(responseArgs.get("RESPONSE_CODE"))){
						return responseMessage;
					}
					result = saveResponseParams(responseArgs);
					if (result > 0) {
						logger.info("在网时长响应报文持久化成功! 交易编号 [ {} ], 查询模式 [ {} ]",
								new Object[] { requestArgs.get("TRN_ID"), queryMode });
					}

					result = 0;

					// 2.响应数据持久化
					result = saveResponseData(responseArgs.get("RESPONSE_BODY"), requestArgs);
					if (result > 0) {
						logger.info("在网时长应用数据持久化成功! 交易编号 [ {} ], 查询模式 [ {} ]",
								new Object[] { requestArgs.get("TRN_ID"), queryMode });
					}
				}
				jsonResponse = JSONObject.fromObject(responseMessage);
				if (jsonResponse.containsKey("RESPONSE") && jsonResponse.getString("RESPONSE") != null
						&& !"".equals(jsonResponse.getString("RESPONSE"))) {
					JSONObject jsonRes = JSONObject.fromObject(jsonResponse.getString("RESPONSE"));
					if (jsonRes.containsKey("BODY") && jsonRes.getString("BODY") != null
							&& !"".equals(jsonRes.getString("BODY"))) {
						JSONObject jsonBody = JSONObject.fromObject(jsonRes.getString("BODY"));
						if("CAMS".equals(requestChannel)){
							jsonBody.put("CARRIER", CheckPhone.getCarrier(mobileNum));
							jsonRes.put("BODY", jsonBody.toString());
							jsonResponse.put("RESPONSE", jsonRes.toString());
						}
					}
				}
				
//			} else {
//				responseArgs.put("RESPONSE_BODY", unicomOnlineMsgResponseList.get(0).getMessageBody());
//				responseMessage = MessageBuildUtil.buildResponseMessage(responseArgs);
//			}
			break;
		}
		return String.valueOf(jsonResponse.toString());
	
	}

	private int saveResponseData(String responseMessage, Map<String, String> requestArgs) {
		UnicomOnline unicomOnline = new UnicomOnline();
		unicomOnline.setCrtUser(requestArgs.get("REQUEST_CHANNEL"));
		unicomOnline.setTrnId(requestArgs.get("TRN_ID"));
		unicomOnline.setCarrier(requestArgs.get("CARRIER"));
		unicomOnline.setCertNo(requestArgs.get("CERT_NO"));
		JSONObject jsMessage = JSONObject.fromObject(responseMessage);
		if(jsMessage != null){
			if(jsMessage.containsKey("status") && jsMessage.getString("status")!=null 
					&& !"".equals(jsMessage.getString("status"))){
				unicomOnline.setStatus(jsMessage.getString("status"));
			}
			if(jsMessage.containsKey("code") && jsMessage.getString("code")!=null 
					&& !"".equals(jsMessage.getString("code"))){
				unicomOnline.setCode(jsMessage.getString("code"));
			}
			if(jsMessage.containsKey("errorDesc") && jsMessage.getString("errorDesc")!=null 
					&& !"".equals(jsMessage.getString("errorDesc"))){
				unicomOnline.setErrorDesc(jsMessage.getString("errorDesc"));
			}
			if(jsMessage.containsKey("checkResult") && jsMessage.getString("checkResult")!=null 
					&& !"".equals(jsMessage.getString("checkResult")) && !"null".equals(jsMessage.getString("checkResult"))){
				unicomOnline.setCheckResult(jsMessage.getString("checkResult"));
			}
		}
		return	unicomOnlineService.saveUnicomOnline(unicomOnline);
	}

	private int saveResponseParams(Map<String, String> responseArgs) {
		UnicomOnlineMsgResponse unicomOnlineMsgResponse = new UnicomOnlineMsgResponse();
		unicomOnlineMsgResponse.setCrtUser(responseArgs.get("RESPONSE_CHANNEL"));
		unicomOnlineMsgResponse.setTrnId(responseArgs.get("TRN_ID"));
	 	unicomOnlineMsgResponse.setMessageBody(responseArgs.get("RESPONSE_BODY"));
	 	return unicomOnlineService.saveUnicomOnlineMsgResponse(unicomOnlineMsgResponse);
	}

	private void saveRequestParams(Map<String, String> requestArgs) {
		UnicomOnlineTrnRequest unicomOnlineTrnRequest = new UnicomOnlineTrnRequest();
		unicomOnlineTrnRequest.setCrtUser(requestArgs.get("REQUEST_CHANNEL"));
		unicomOnlineTrnRequest.setTrnId(requestArgs.get("TRN_ID"));
		unicomOnlineTrnRequest.setRequestChannel(requestArgs.get("REQUEST_CHANNEL"));
		unicomOnlineTrnRequest.setQueryMode(requestArgs.get("QUERY_MODE"));
		unicomOnlineTrnRequest.setCertType(requestArgs.get("CERT_TYPE"));
		unicomOnlineTrnRequest.setCertNo(requestArgs.get("CERT_NO"));
		unicomOnlineTrnRequest.setName(requestArgs.get("NAME"));
		unicomOnlineTrnRequest.setMobile(requestArgs.get("MOBILE"));
		unicomOnlineService.saveUnicomOnlineTrnRequest(unicomOnlineTrnRequest);
	}

	private String queryRequestInvoke(String jsonRequest) {
		String message = "";
		try {
			String url = AppConfig.getInstance().getValue("unicom.online.dmz.webservice.url");
			int connectionTimeout = Integer
					.parseInt(AppConfig.getInstance().getValue("unicom.online.dmz.webservice.connection_timeout"));
			String httpTimeout = AppConfig.getInstance().getValue("unicom.online.dmz.webservice.http_timeout");			
			Object[] response = WebServiceUtil.call(url, "invoke", new Object[] { jsonRequest }, connectionTimeout,
					httpTimeout);
			message = String.valueOf(response[0]);
		} catch (Exception e) {
			logger.error("请求外围数据源异常 [ {} ]", e.getMessage(), e);
		}
		return message;
	}
	/**
	 * @Title: assembleRequestMessage
	 *@Description: 重新组装发送报文
	 *@param requestArgs
	 *@return
	 *@author: LiuWei
	 *@Date: 2019年11月5日下午2:39:48
	 */
	private String assembleRequestMessage(Map<String, String> requestArgs) {
		String mobile = requestArgs.get("MOBILE");
		String carrier = CheckPhone.getCarrier(mobile);
		requestArgs.put("CARRIER", carrier);
		return MessageBuildUtil.buildRequestMessage(requestArgs);
	}
}
