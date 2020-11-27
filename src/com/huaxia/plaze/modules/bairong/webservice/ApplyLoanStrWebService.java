package com.huaxia.plaze.modules.bairong.webservice;

import java.util.Calendar;
import java.util.Date;
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
import com.huaxia.plaze.modules.bairong.adapter.ApplyLoanStrAdapter;
import com.huaxia.plaze.modules.bairong.domain.ApplyLoanStr;
import com.huaxia.plaze.modules.bairong.domain.ApplyLoanStrMsgResponse;
import com.huaxia.plaze.modules.bairong.domain.ApplyLoanStrTrnRequest;
import com.huaxia.plaze.modules.bairong.service.ApplyLoanStrService;
import com.huaxia.plaze.util.WebServiceUtil;
import com.huaxia.util.GuidUtil;

@Service
@WebService(serviceName = "WST000700", endpointInterface = "com.huaxia.plaze.modules.MessageWebService")
public class ApplyLoanStrWebService implements MessageWebService {

	private final static Logger logger = LoggerFactory.getLogger(ApplyLoanStrWebService.class);
	private static AppConfig appConfig = AppConfig.getInstance();

	@Resource
	private ApplyLoanStrService applyLoanStrService;

	@Override
	public String invoke(String jsonRequest) {
		// 响应报文结果
		String responseMessage = "";

		// 查询结果集列表
		List<ApplyLoanStrMsgResponse> applyLoanStrList = null;

		// 响应参数
		Map<String, String> responseArgs = new HashMap<String, String>();

		// 决策参数
		boolean decision = false;

		// [1] 请求参数解析
		Map<String, String> requestArgs = MessageParseUtil.parseRequestMessage(jsonRequest);

		// [2] 请求参数持久化
		saveRequestParams(requestArgs);

		// [3] 根据"查询模式"进行查询动作决策
		String queryMode = requestArgs.get("QUERY_MODE");
		switch (queryMode) {
		// 联机查询
		case "1":
			// 重新组装发送的报文，添加用户名及密码。
			jsonRequest = assembleRequestMessage(requestArgs);
			responseMessage = queryRequestInvoke(jsonRequest);
			decision = StringUtils.isBlank(responseMessage);
			logger.info("百融多头借贷查询模式 [ {} ] 决策路由 [ {} ]", new Object[] { queryMode, (decision ? "无此数据" : "联机查询") });
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
					logger.info("百融多头借贷响应报文持久化成功! 交易编号 [ {} ], 查询模式 [ {} ]",
							new Object[] { requestArgs.get("TRN_ID"), queryMode });
				}

				// 2.响应数据持久化
				result = saveResponseData(responseArgs.get("RESPONSE_BODY"), requestArgs);
				if (result > 0) {
					logger.info("百融多头借贷应用数据持久化成功! 交易编号 [ {} ], 查询模式 [ {} ]",
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
			applyLoanStrList = applyLoanStrService.queryListByParams(certNo, mobile, name);
			decision = (applyLoanStrList == null || applyLoanStrList.size() == 0);
			logger.info("百融多头借贷查询模式 [ {} ] 决策路由 [ {} ]", new Object[] { queryMode, (decision ? "联机查询" : "联机查找") });
			if (decision) {
				responseMessage = MessageBuildUtil.buildResponseMessage(responseArgs);
			} else {
				responseArgs.put("RESPONSE_BODY", applyLoanStrList.get(0).getMessageBody());
				responseMessage = MessageBuildUtil.buildResponseMessage(responseArgs);
				logger.info("百融多头借贷查找交易编号 [ {} ] 映射交易编号 [ {} ]",
						new Object[] { (applyLoanStrList.get(0)).getTrnId(), requestArgs.get("TRN_ID") });
			}
			break;
		// 联机查找查询
		case "3":
			Calendar calendar = Calendar.getInstance();
			Date endDate = calendar.getTime();
			calendar.add(Calendar.DAY_OF_YEAR, -1);
			Date startDate = calendar.getTime();
			applyLoanStrList = applyLoanStrService.queryListByParams(requestArgs.get("CERT_NO"),
					requestArgs.get("MOBILE"), requestArgs.get("NAME"), startDate, endDate);
			decision = (applyLoanStrList == null || applyLoanStrList.size() == 0);
			logger.info("百融多头借贷查询模式 [ {} ] 决策路由 [ {} ]", new Object[] { queryMode, (decision ? "联机查询" : "联机查找") });
			if (decision) {
				// 重新组装发送的报文，添加用户名及密码。
				jsonRequest = assembleRequestMessage(requestArgs);
				responseMessage = queryRequestInvoke(jsonRequest);
				if (StringUtils.isBlank(responseMessage)) {
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
						logger.info("百融多头借贷响应报文持久化成功! 交易编号 [ {} ], 查询模式 [ {} ]",
								new Object[] { requestArgs.get("TRN_ID"), queryMode });
					}

					result = 0;

					// 2.响应数据持久化
					result = saveResponseData(responseArgs.get("RESPONSE_BODY"), requestArgs);
					if (result > 0) {
						logger.info("百融多头借贷应用数据持久化成功! 交易编号 [ {} ], 查询模式 [ {} ]",
								new Object[] { requestArgs.get("TRN_ID"), queryMode });
					}
				}
			} else {
				responseArgs.put("RESPONSE_BODY", applyLoanStrList.get(0).getMessageBody());
				responseMessage = MessageBuildUtil.buildResponseMessage(responseArgs);
			}
			break;
		}
		return responseMessage;
	}

	private int saveResponseData(String responseMessage, Map<String, String> requestArgs) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("message", responseMessage);
		params.put("name", requestArgs.get("NAME"));
		params.put("crtNo", requestArgs.get("CERT_NO"));
		params.put("mobile", requestArgs.get("MOBILE"));
		params.put("crtUser", requestArgs.get("REQUEST_CHANNEL"));
		params.put("trnId", requestArgs.get("TRN_ID"));
		params.put("cardAccount", requestArgs.get("CARD_ACCOUNT"));
		params.put("sequence", requestArgs.get("SEQUENCE"));
		ApplyLoanStr applyLoanStr = ApplyLoanStrAdapter.parseApplyLoanStr(params);
		return applyLoanStrService.saveApplyLoanStr(applyLoanStr);
	}

	private int saveResponseParams(Map<String, String> responseArgs) {
		ApplyLoanStrMsgResponse applyLoanStrResponse = new ApplyLoanStrMsgResponse();
		applyLoanStrResponse.setCrtUser(responseArgs.get("RESPONSE_CHANNEL"));
		applyLoanStrResponse.setTrnId(responseArgs.get("TRN_ID"));
		applyLoanStrResponse.setMessageBody(responseArgs.get("RESPONSE_BODY"));
		return applyLoanStrService.saveResponse(applyLoanStrResponse);
	}

	private void saveRequestParams(Map<String, String> requestArgs) {
		ApplyLoanStrTrnRequest applyLoanStrRequest = new ApplyLoanStrTrnRequest();
		applyLoanStrRequest.setUuid(GuidUtil.getGuid());
		applyLoanStrRequest.setCrtTime(new Date());
		applyLoanStrRequest.setCrtUser(requestArgs.get("REQUEST_CHANNEL"));
		applyLoanStrRequest.setTrnId(requestArgs.get("TRN_ID"));
		applyLoanStrRequest.setRequestChannel(requestArgs.get("REQUEST_CHANNEL"));
		applyLoanStrRequest.setQueryMode(requestArgs.get("QUERY_MODE"));
		applyLoanStrRequest.setCertType(requestArgs.get("CERT_TYPE"));
		applyLoanStrRequest.setCertNo(requestArgs.get("CERT_NO"));
		applyLoanStrRequest.setName(requestArgs.get("NAME"));
		applyLoanStrRequest.setMobile(requestArgs.get("MOBILE"));
		applyLoanStrRequest.setCradAccount(requestArgs.get("CARD_ACCOUNT"));
		if (StringUtils.isNotBlank(requestArgs.get("SEQUENCE"))) {
			applyLoanStrRequest.setSequence(Long.parseLong(requestArgs.get("SEQUENCE")));
		}
		applyLoanStrService.saveRequest(applyLoanStrRequest);
	}

	private String queryRequestInvoke(String jsonRequest) {
		String message = "";
		try {
			String url = AppConfig.getInstance().getValue("bairong.dtjd.dmz.webservice.url");
			int connectionTimeout = Integer
					.parseInt(AppConfig.getInstance().getValue("bairong.dtjd.dmz.webservice.connection_timeout"));
			String httpTimeout = AppConfig.getInstance().getValue("bairong.dtjd.dmz.webservice.http_timeout");
			Object[] response = WebServiceUtil.call(url, "invoke", new Object[] { jsonRequest }, connectionTimeout,
					httpTimeout);
			message = String.valueOf(response[0]);
		} catch (Exception e) {
			logger.error("请求外围数据源异常 [ {} ]", e.getMessage(), e);
		}
		return message;
	}

	/**
	 * @Title: assembleBatchRequestMessage
	 * @Description: TODO
	 * @param requestArgs
	 * @return
	 * @author: LiuWei
	 * @Date: 2019年10月22日下午1:20:33
	 */
	private String assembleRequestMessage(Map<String, String> requestArgs) {
		// 联机批量请求
		if ("BATCH".equals(requestArgs.get("REQUEST_CHANNEL"))) {
			requestArgs.put("USERNAME", appConfig.getValue("bairong.dtjd.batch.userName"));
			requestArgs.put("PASSWORD", appConfig.getValue("bairong.dtjd.batch.password"));
			requestArgs.put("API_CODE", appConfig.getValue("bairong.dtjd.batch.apiCode"));
		} 
		// 联机单笔请求 + 联机渠道请求
		else {
			requestArgs.put("USERNAME", appConfig.getValue("bairong.dtjd.single.userName"));
			requestArgs.put("PASSWORD", appConfig.getValue("bairong.dtjd.single.password"));
			requestArgs.put("API_CODE", appConfig.getValue("bairong.dtjd.single.apiCode"));
		}
		return MessageBuildUtil.buildRequestMessage(requestArgs);
	}

}
