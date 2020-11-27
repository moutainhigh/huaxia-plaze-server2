package com.huaxia.plaze.modules.yilianzhong.util;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.huaxia.plaze.modules.yilianzhong.domain.YlzRepData;

public class YlzResponseParseHelper {

	private final static Logger logger = LoggerFactory.getLogger(YlzResponseParseHelper.class);

	private YlzResponseParseHelper() {
	}

	public static String getQueryModel2Response(String messageBody, String trnId) {
		if (StringUtils.isNotBlank(messageBody)) {
			String bodyStr = "";
			// 连接字符串，实现数据库的查询和实现
			Map<String, Object> head = new HashMap<String, Object>();
			head.put("REQUEST_SYSTEM", "PLAZE");
			head.put("TRN_ID", trnId);

			Map<String, Object> body = new HashMap<String, Object>();
			body.put("RESPONSE_CODE", ErrorCode.OK.getCode());
			body.put("RESPONSE_DESC", ErrorCode.OK.getDescription());
			body.put("RESPONSE_BODY", String.valueOf(messageBody));

			Map<String, Object> response = new HashMap<String, Object>();
			response.put("HEAD", head);
			response.put("BODY", body);

			Map<String, Object> params = new HashMap<String, Object>();
			params.put("RESPONSE", response);

			JSONObject jsonStr = new JSONObject(params);
			return JSON.toJSONString(jsonStr);
		}
		return null;
	}

	public static YlzRepData getQueryModel1Response(String repString) {
		YlzRepData ylzRepData = new YlzRepData();
		if (StringUtils.isNotBlank(repString)) {
			String bodyStr = "";
			try {
				JSONObject jsonResponse = JSON.parseObject(repString);
				if (jsonResponse.containsKey("RESPONSE") && jsonResponse.getString("RESPONSE") != null
						&& !"".equals(jsonResponse.getString("RESPONSE"))) {
					JSONObject jsonRes = JSON.parseObject(jsonResponse.getString("RESPONSE"));

					if (jsonRes.containsKey("HEAD") && jsonRes.getString("HEAD") != null
							&& !"".equals(jsonRes.getString("HEAD"))) {
						JSONObject jsonHead = JSON.parseObject(jsonRes.getString("HEAD"));
						if (jsonHead.containsKey("TRN_ID") && jsonHead.getString("TRN_ID") != null
								&& !"".equals(jsonHead.getString("TRN_ID"))) {
							ylzRepData.setTrnId(jsonHead.getString("TRN_ID"));
						}else{
							return null;
						}
					}

					if (jsonRes.containsKey("BODY") && jsonRes.getString("BODY") != null
							&& !"".equals(jsonRes.getString("BODY"))) {
						JSONObject jsonBody = JSON.parseObject(jsonRes.getString("BODY"));
						if (jsonBody.containsKey("RESPONSE_CODE") && jsonBody.getString("RESPONSE_CODE") != null
								&& !"".equals(jsonBody.getString("RESPONSE_CODE"))) {
							String responseCode = jsonBody.getString("RESPONSE_CODE");
							//判断是否返回成功
							if ((ErrorCode.OK.getCode()).equals(responseCode)) {
								if (jsonBody.containsKey("RESPONSE_BODY") && jsonBody.getString("RESPONSE_BODY") != null
										&& !"".equals(jsonBody.getString("RESPONSE_BODY"))) {
									bodyStr = jsonBody.getString("RESPONSE_BODY");
									// 去掉中括号
									ylzRepData.setResultJson(bodyStr);
									bodyStr = bodyStr.substring(1, bodyStr.length() - 1);
									JSONObject responseJson = JSON.parseObject(bodyStr);
									if (responseJson.containsKey("insuredStatues")
											&& responseJson.getString("insuredStatues") != null
											&& !"".equals(responseJson.getString("insuredStatues"))) {
										ylzRepData.setInsuredStatues(responseJson.getString("insuredStatues"));
									} else {
										return null;
									}
									if (responseJson.containsKey("beginPaymentDate")
											&& responseJson.getString("beginPaymentDate") != null
											&& !"".equals(responseJson.getString("beginPaymentDate"))) {
										ylzRepData.setBeginPaymentDate(responseJson.getString("beginPaymentDate"));
									} else {
										return null;
									}
									if (responseJson.containsKey("latestPaymentDate")
											&& responseJson.getString("latestPaymentDate") != null
											&& !"".equals(responseJson.getString("latestPaymentDate"))) {
										ylzRepData.setLatestPaymentDate(responseJson.getString("latestPaymentDate"));
									} else {
										return null;
									}
									if (responseJson.containsKey("companyName")
											&& responseJson.getString("companyName") != null
											&& !"".equals(responseJson.getString("companyName"))) {
										ylzRepData.setCompanyName(responseJson.getString("companyName"));
									} else {
										return null;
									}
									if (responseJson.containsKey("repaymentAbility")
											&& responseJson.getString("repaymentAbility") != null
											&& !"".equals(responseJson.getString("repaymentAbility"))) {
										ylzRepData.setRepaymentAbility(responseJson.getString("repaymentAbility"));
									} else {
										return null;
									}
									if (responseJson.containsKey("isOnJob") && responseJson.getString("isOnJob") != null
											&& !"".equals(responseJson.getString("isOnJob"))) {
										ylzRepData.setIsOnJob(responseJson.getString("isOnJob"));
									} else {
										return null;
									}
								}else{
									//响应报文为空
									return null;
								}

							} else {
								// 请求dmz失败
								return null;
							}
						}
					}

				}
			} catch (Exception e) {
				logger.error("[区域数据-厦门-易联众] 返回报文解析异常");
				e.printStackTrace();
				return null;
			}
		}

		return ylzRepData;
	}

	public static void main(String[] args) {
		String str = "[{\"insuredStatues\":\"-2\",\"beginPaymentDate\":\"-2\",\"latestPaymentDate\":\"-2\",\"companyName\":\"-2\",\"repaymentAbility\":\"-2\",\"isOnJob\":\"-2\"}]";
		str = str.substring(1, str.length() - 1);
		JSONObject jsonBody = JSON.parseObject(str);
		String test = jsonBody.getString("insuredStatues");
		System.out.println(test);
	}

}
