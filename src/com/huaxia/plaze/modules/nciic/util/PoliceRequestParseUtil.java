package com.huaxia.plaze.modules.nciic.util;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.huaxia.plaze.modules.nciic.domain.NciicXpRequest;
/**
 * 公安人像比对 请求报文解析工具类
 * @author User
 *
 */
public class PoliceRequestParseUtil {

	private final static Logger logger = LoggerFactory.getLogger(PoliceRequestParseUtil.class);

	public static NciicXpRequest parsingRequest(String jsonRequest) {
		NciicXpRequest nciicXpRequest = new NciicXpRequest();
		JSONObject jsonObject = null;
		try {
			jsonObject = JSON.parseObject(jsonRequest);
			if (jsonObject != null) {

				if (jsonObject.containsKey("REQUEST") && jsonObject.getString("REQUEST") != null
						&& !"".equals(jsonObject.getString("REQUEST"))) {

					JSONObject jsonRequet = JSON.parseObject(jsonObject.getString("REQUEST"));

					if (jsonRequet.containsKey("HEAD") && jsonRequet.getString("HEAD") != null
							&& !"".equals(jsonRequet.getString("HEAD"))) {
						JSONObject jsonHead = JSON.parseObject(jsonRequet.getString("HEAD"));
						if (jsonHead.containsKey("REQUEST_CHANNEL") && jsonHead.getString("REQUEST_CHANNEL") != null
								&& !"".equals(jsonHead.getString("REQUEST_CHANNEL"))) {
							nciicXpRequest.setRequestChannel(jsonHead.getString("REQUEST_CHANNEL"));
						}
						if (jsonHead.containsKey("TRN_ID") && jsonHead.getString("TRN_ID") != null
								&& !"".equals(jsonHead.getString("TRN_ID"))) {
							nciicXpRequest.setTrnId(jsonHead.getString("TRN_ID"));
						}
						if (jsonHead.containsKey("APP_ID") && jsonHead.getString("APP_ID") != null
								&& !"".equals(jsonHead.getString("APP_ID"))) {
							nciicXpRequest.setAppId(jsonHead.getString("APP_ID"));
						}
					}

					if (jsonRequet.containsKey("BODY") && jsonRequet.getString("BODY") != null
							&& !"".equals(jsonRequet.getString("BODY"))) {
						JSONObject jsonBody = JSON.parseObject(jsonRequet.getString("BODY"));
						if (jsonBody.containsKey("QUERY_MODE") && jsonBody.getString("QUERY_MODE") != null
								&& !"".equals(jsonBody.getString("QUERY_MODE"))) {
							nciicXpRequest.setQueryMode(jsonBody.getString("QUERY_MODE"));

						}
						if (jsonBody.containsKey("CERT_TYPE") && jsonBody.getString("CERT_TYPE") != null
								&& !"".equals(jsonBody.getString("CERT_TYPE"))) {
							nciicXpRequest.setCertType(jsonBody.getString("CERT_TYPE"));
						}
						if (jsonBody.containsKey("CERT_NO") && jsonBody.getString("CERT_NO") != null
								&& !"".equals(jsonBody.getString("CERT_NO"))) {
							nciicXpRequest.setCertNo(jsonBody.getString("CERT_NO"));

						}
						if (jsonBody.containsKey("NAME") && jsonBody.getString("NAME") != null
								&& !"".equals(jsonBody.getString("NAME"))) {
							nciicXpRequest.setName(jsonBody.getString("NAME"));
						}
						if (jsonBody.containsKey("MOBILE") && jsonBody.getString("MOBILE") != null
								&& !"".equals(jsonBody.getString("MOBILE"))) {
							nciicXpRequest.setMobile(jsonBody.getString("MOBILE"));
						}
						if (jsonBody.containsKey("XP") && jsonBody.getString("XP") != null
								&& !"".equals(jsonBody.getString("XP"))) {
							nciicXpRequest.setXp(jsonBody.getString("XP"));
						}
						//检查请求报文的必要元素
						if(StringUtils.isBlank(nciicXpRequest.getQueryMode()) || StringUtils.isBlank(nciicXpRequest.getCertNo())
								|| StringUtils.isBlank(nciicXpRequest.getName()) || StringUtils.isBlank(nciicXpRequest.getTrnId())
								|| StringUtils.isBlank(nciicXpRequest.getXp())){
							return null;
						}
						nciicXpRequest.setCrtUser("PLAZE");
						return nciicXpRequest;
					}

				}
			}
		} catch (Exception e) {
			logger.error("请求参数解析异常 [{}]", e);
			e.printStackTrace();
		}
		return null;
	}
}
