package com.huaxia.plaze.modules.bairong.webservice;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javax.jws.WebService;

import org.apache.commons.lang3.StringUtils;
import org.codehaus.xfire.client.Client;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huaxia.opas.util.AppConfig;
import com.huaxia.plaze.modules.MessageWebService;
import com.huaxia.plaze.modules.bairong.domain.BRZX;
import com.huaxia.plaze.modules.bairong.parse.BrzxMessageParser;
import com.huaxia.plaze.modules.bairong.service.BaiRongRpService;
import com.huaxia.plaze.modules.bairong.service.BaiRongService;
import com.huaxia.plaze.modules.bairong.service.BaiRongTrnRqService;
import com.huaxia.plaze.modules.bairong.util.BrzxRequestParseUtil;
import com.huaxia.plaze.modules.bairong.util.ResponseCode;
import com.huaxia.plaze.modules.bairong.util.BrzxResponseParseUtil;
import com.huaxia.plaze.modules.bairong.util.BrzxReturnJsonUtil;

@Service
@WebService(serviceName="WST000400", endpointInterface="com.huaxia.plaze.modules.MessageWebService")
public class BaiRongWebServiceImpl implements MessageWebService {

	private final static Logger logger = LoggerFactory.getLogger(BaiRongWebServiceImpl.class);
	
	@Autowired
	private BaiRongTrnRqService baiRongTrnRqService;
	
	@Autowired
	private BaiRongService baiRongService;
	
	@Autowired
	private BaiRongRpService baiRongRpService;
	
	@Override
	public String invoke(String jsonRequest) {
		
		logger.debug("调用成功");
		
		// 解析请求报文
		Map<String, String> params = BrzxRequestParseUtil.parseRequestInfo(jsonRequest);
		
		// 检查报文必要元素
		if (params != null) {
			if (StringUtils.isBlank(params.get("queryMode")) || StringUtils.isBlank(params.get("certNo"))
					|| StringUtils.isBlank(params.get("name")) || StringUtils.isBlank(params.get("trnId"))
					|| StringUtils.isBlank(params.get("mobile"))) {
				return BrzxReturnJsonUtil.getReturnInfo(params, ResponseCode.MISS_EL);
			}
		} else {
			return BrzxReturnJsonUtil.getReturnInfo(params, ResponseCode.NO_PASS);
		}
		
		// 查询渠道
		// 保存请求信息
		baiRongTrnRqService.saveBrRqInfo(params);
		
		Client client = null;
		try {
			client = new Client(new URL(AppConfig.getInstance().getValue("bairong.sp.dmz.webservice.url")));
			Object[] obj = new Object[] { jsonRequest };
			Object[] result = client.invoke("invoke", obj);
			if (result != null) {
				// 解析返回报文信息
				Map<String, String> response = BrzxResponseParseUtil.parseResponseInfo(String.valueOf(result[0]));
				response.put("rqChannel" , params.get("rqChannel"));
				// 返回报文信息入库
				baiRongRpService.saveResponseInfo(response);
				try {
					// 报文解析入库
					BRZX brzx = new BrzxMessageParser().parse(response.get("responseBody"));
					brzx.setCertNo(params.get("certNo"));
					brzx.setTrnId(params.get("trnId"));
					brzx.setCrtUser(params.get("rqChannel"));
					baiRongService.save(brzx);
				} catch (Exception e ) {
					logger.error("[百融征信] 解析入库异常:{}", e.getMessage());
				}
				
				logger.debug("返回报文："+String.valueOf(result[0]));
				return String.valueOf(result[0]);
			}
		} catch (Exception e) {
			logger.error("[百融征信] 请求查询异常:{}", e.getMessage());
		} finally {
			if (client != null) {
				client.close();
			}
		}
		return BrzxReturnJsonUtil.getReturnInfo(params,ResponseCode.DATA_SOURCE_RESP_EX);
	}
}
