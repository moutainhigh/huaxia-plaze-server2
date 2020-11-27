package com.huaxia.plaze.modules.baoxin.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.huaxia.opas.util.AppConfig;
import com.huaxia.plaze.modules.baoxin.domain.BaoXinBase;
import com.huaxia.plaze.modules.baoxin.domain.BaoXinRequest;
import com.huaxia.plaze.modules.nciic.util.ErrorCode;

public class BaoXinUtil {
	
	private static final  Logger logger = LoggerFactory.getLogger(BaoXinUtil.class);
	
	private static String codeStr = "0000000000";
	/**
	 * 解析请求报文
	 * @param jsonRequest 请求报文
	 * @return
	 */
	public static BaoXinRequest parseRequest(String jsonRequest) {
		BaoXinRequest baoXinReqeust = new BaoXinRequest();
		JSONObject jsonObject = null;
		try {
			jsonObject = JSON.parseObject(jsonRequest);
			JSONObject request = jsonObject.getJSONObject("REQUEST");
			JSONObject jsonHead = request.getJSONObject("HEAD");
			baoXinReqeust.setTrnId(jsonHead.getString("TRN_ID"));
			baoXinReqeust.setTrnCode(jsonHead.getString("TRN_CODE"));
			baoXinReqeust.setRequestChannel(jsonHead.getString("REQUEST_CHANNEL"));
			JSONObject jsonBody = request.getJSONObject("BODY");
			baoXinReqeust.setQueryMode(jsonBody.getString("QUERY_MODE"));
			baoXinReqeust.setCertType(jsonBody.getString("CERT_TYPE"));
			baoXinReqeust.setCertNo(jsonBody.getString("CERT_NO"));
			baoXinReqeust.setName(jsonBody.getString("NAME"));
			if(StringUtils.isBlank(baoXinReqeust.getQueryMode()) || StringUtils.isBlank(baoXinReqeust.getCertNo())
					|| StringUtils.isBlank(baoXinReqeust.getTrnId()) || StringUtils.isBlank(baoXinReqeust.getName())){
				return null;
			}
			return baoXinReqeust;
		} catch (Exception e) {
			logger.info("解析出错的保信请求报文：={}",jsonRequest);
			logger.error("解析保信汽车请求报文失败！", e);
		}
		return null;
	}
	/**
	 * 构建响应报文
	 * @param trnId 业务主键编号
	 * @param errorCode  错误类型
	 * @param result  
	 * @return
	 */
	public static String getResponseJson(String trnId, ErrorCode errorCode, String result) {

		// 连接字符串，实现数据库的查询和实现
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("RESPONSE_CHANNEL", "PLAZE");
		head.put("TRN_ID", trnId);

		Map<String, Object> body = new HashMap<String, Object>();
		body.put("RESPONSE_CODE", errorCode.getCode());
		body.put("RESPONSE_DESC", errorCode.getDescription());
		body.put("RESPONSE_BODY", result);

		Map<String, Object> response = new HashMap<String, Object>();
		response.put("HEAD", head);
		response.put("BODY", body);

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("RESPONSE", response);

		JSONObject jsonStr = new JSONObject(params);
		return JSON.toJSONString(jsonStr);
	}
	public static String buildInsurerUuid(int count) {
		String bankCode = AppConfig.getInstance().getValue("plaze.bxqc.bankCode");
		String countNow = String.valueOf(count+1);
		String dateStr =new SimpleDateFormat("yyyyMMdd").format(new Date());
		String uuid = bankCode+dateStr+codeStr.substring(0, 10-countNow.length())+countNow;
		return uuid;
	}
	public static void main(String[] args) {
		System.out.println(buildInsurerUuid(10));
		System.out.println(new SimpleDateFormat("yyyyMMdd").format(new Date()));
	}
	public static BaoXinBase parseMessageBody(String result,String trnId) {
		BaoXinBase base = new BaoXinBase();
		try {
			JSONObject jsonObject = JSONObject.parseObject(result);
			String retCode = jsonObject.getString("retCode");
			if(jsonObject.containsKey("retCode") && ("000000".equals(retCode) || "999999".equals(retCode))){
				base.setRetCode(jsonObject.getString("retCode"));
				base.setRetMessage(jsonObject.getString("retMessage"));
				base.setInsurerUuid(jsonObject.getString("insurerUuid"));
				JSONObject financialProductsInfoRes = jsonObject.getJSONObject("financialProductsInfoRes");
				base.setBankCode(financialProductsInfoRes.getString("bankCode"));
				base.setReturnTime(financialProductsInfoRes.getString("returnTime"));
				base.setRiskValueRange(financialProductsInfoRes.getString("riskValueRange"));
				base.setCarAge(financialProductsInfoRes.getString("carAge"));
				return base;
			}else{
				logger.info("响应报文为异常，报文为=：{}",result);
			}
			
		} catch (Exception e) {
			logger.error("保信汽车解析响应报文出错"+trnId, e);
			logger.error("解析失败的原始报文为："+result);
		}
		return null;
	}
}
