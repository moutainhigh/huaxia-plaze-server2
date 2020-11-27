package com.huaxia.plaze.modules.nciic.util;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.huaxia.plaze.modules.nciic.domain.NciicForeignerRequest;
/**
 * 外国人永久居留证请求报文解析工具类
 * @author User
 *
 */
public class ForeignerRequestParseUtil {

	private final static Logger logger = LoggerFactory.getLogger(ForeignerRequestParseUtil.class);

	public static NciicForeignerRequest parsingRequest(String jsonRequest) {
		NciicForeignerRequest nciicForeignerRequest = new NciicForeignerRequest();
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
							nciicForeignerRequest.setRequestChannel(jsonHead.getString("REQUEST_CHANNEL"));
						}
						if (jsonHead.containsKey("TRN_ID") && jsonHead.getString("TRN_ID") != null
								&& !"".equals(jsonHead.getString("TRN_ID"))) {
							nciicForeignerRequest.setTrnId(jsonHead.getString("TRN_ID"));
						}
					}

					if (jsonRequet.containsKey("BODY") && jsonRequet.getString("BODY") != null
							&& !"".equals(jsonRequet.getString("BODY"))) {
						JSONObject jsonBody = JSON.parseObject(jsonRequet.getString("BODY"));
						if (jsonBody.containsKey("QUERY_MODE") && jsonBody.getString("QUERY_MODE") != null
								&& !"".equals(jsonBody.getString("QUERY_MODE"))) {
							nciicForeignerRequest.setQueryMode(jsonBody.getString("QUERY_MODE"));

						}
						if (jsonBody.containsKey("CERT_TYPE") && jsonBody.getString("CERT_TYPE") != null
								&& !"".equals(jsonBody.getString("CERT_TYPE"))) {
							nciicForeignerRequest.setCertType(jsonBody.getString("CERT_TYPE"));
						}
						if (jsonBody.containsKey("CERT_NO") && jsonBody.getString("CERT_NO") != null
								&& !"".equals(jsonBody.getString("CERT_NO"))) {
							nciicForeignerRequest.setCertNo(jsonBody.getString("CERT_NO"));

						}
						if (jsonBody.containsKey("NAME") && jsonBody.getString("NAME") != null
								&& !"".equals(jsonBody.getString("NAME"))) {
							nciicForeignerRequest.setName(jsonBody.getString("NAME"));
						}
						if (jsonBody.containsKey("BIRTH") && jsonBody.getString("BIRTH") != null
								&& !"".equals(jsonBody.getString("BIRTH"))) {
							nciicForeignerRequest.setBirth(jsonBody.getString("BIRTH"));
						}
						if (jsonBody.containsKey("EXPIRY_DATE") && jsonBody.getString("EXPIRY_DATE") != null
								&& !"".equals(jsonBody.getString("EXPIRY_DATE"))) {
							nciicForeignerRequest.setExpiryDate(jsonBody.getString("EXPIRY_DATE"));
						}
						//检查请求报文的必要元素,
						if(StringUtils.isBlank(nciicForeignerRequest.getQueryMode()) || StringUtils.isBlank(nciicForeignerRequest.getCertNo())
								|| StringUtils.isBlank(nciicForeignerRequest.getName()) || StringUtils.isBlank(nciicForeignerRequest.getTrnId())
								|| StringUtils.isBlank(nciicForeignerRequest.getBirth())|| StringUtils.isBlank(nciicForeignerRequest.getExpiryDate())){
							return null;
						}
						nciicForeignerRequest.setCrtUser("PLAZE");
						return nciicForeignerRequest;
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
