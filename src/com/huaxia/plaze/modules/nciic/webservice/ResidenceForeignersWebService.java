package com.huaxia.plaze.modules.nciic.webservice;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.jws.WebService;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpVersion;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.codehaus.xfire.client.Client;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.huaxia.opas.util.AppConfig;
import com.huaxia.plaze.modules.MessageWebService;
import com.huaxia.plaze.modules.nciic.domain.NciicForeignerInfo;
import com.huaxia.plaze.modules.nciic.domain.NciicForeignerRequest;
import com.huaxia.plaze.modules.nciic.service.impl.ForeignerRequestServiceImpl;
import com.huaxia.plaze.modules.nciic.service.impl.ForeignerResponseServiceImpl;
import com.huaxia.plaze.modules.nciic.util.ErrorCode;
import com.huaxia.plaze.modules.nciic.util.ForeignerRequestParseUtil;
import com.huaxia.plaze.modules.nciic.util.ForeignerResponseParseUtil;
import com.huaxia.plaze.modules.nciic.util.ReturnJsonUtil;

//@Service
//@WebService(serviceName = "WST000202", endpointInterface = "com.huaxia.plaze.modules.MessageWebService")
@Component
public class ResidenceForeignersWebService implements MessageWebService {
/**
 * insert into general_class_setting values('WST000202','com.huaxia.plaze.modules.nciic.webservice.ResidenceForeignersWebService','invoke','residenceForeignersWebService');
commit;
 */
	@Resource
	private ForeignerRequestServiceImpl foreignerRequestServiceImpl;
	@Resource
	private ForeignerResponseServiceImpl foreignerResponseServiceImpl;

	private final static Logger logger = LoggerFactory.getLogger(ResidenceForeignersWebService.class);

	@Override
	public String invoke(String jsonRequest) {
		//一， 解析请求报文
		NciicForeignerRequest nciicForeignerRequest = ForeignerRequestParseUtil.parsingRequest(jsonRequest);
		if (nciicForeignerRequest == null) {
			return ReturnJsonUtil.getBackJson("", ErrorCode.NO_PASS, "");
		}
		
		// 二，保存请求报文
		int number = foreignerRequestServiceImpl.save(nciicForeignerRequest);
		if (number < 1) {
			logger.info("保存请求参数失败！trn_id={}", nciicForeignerRequest.getTrnId());
		}
		
		// 三，查找
		if ("2".equals(nciicForeignerRequest.getQueryMode())) {
			String responseJson = foreignerResponseServiceImpl.queryResponseByRequest(nciicForeignerRequest.getName(),
					nciicForeignerRequest.getCertNo(),nciicForeignerRequest.getBirth(),nciicForeignerRequest.getExpiryDate());
			if (StringUtils.isNotBlank(responseJson)) {
				return ReturnJsonUtil.getBackJson(nciicForeignerRequest.getTrnId(), ErrorCode.OK, responseJson);
			} else {
				// 查询找结果为空
				return ReturnJsonUtil.getBackJson(nciicForeignerRequest.getTrnId(), ErrorCode.DEAL_EX, "");
			}
		} 

		// 四，联机查询
		if ("1".equals(nciicForeignerRequest.getQueryMode())) {
			Client client = null;
			try {
				client = new Client(new URL(AppConfig.getInstance().getValue("police.foreigner.dmz.webservice.url")));
				Object[] result = client.invoke("invoke", new Object[] { jsonRequest });
				String resultStr = String.valueOf(result[0]);
				//判断响应成功或失败（响应码000000或999999）
				boolean flag = ForeignerResponseParseUtil.checkResponseCode(resultStr);
				if (flag) {
					//1，解析响应报文
					NciicForeignerInfo nciicForeignerInfo = ForeignerResponseParseUtil.parseResult(resultStr,nciicForeignerRequest.getCertType());
					if (nciicForeignerInfo == null) {
						logger.error("外国人永久居留证】解析dmz报文异常 trn_id = " + nciicForeignerRequest.getTrnId());
					}else{
						nciicForeignerInfo.setCrtUser(nciicForeignerRequest.getRequestChannel());
						nciicForeignerInfo.setCertType(nciicForeignerRequest.getCertType());
						//2，持久换响应报文和解析数据
						int rowChange = foreignerResponseServiceImpl.save(nciicForeignerInfo);
						if (rowChange < 1) {
							logger.error("【外国人永久居留证】持久化返回结果失败");
						}
					}
				} else {
					logger.error("dmz返回的报文中原始报文不存在！！！");
				}
				// 将dmz响应报文，传递下去
				return resultStr;
			} catch (Exception e) {
				logger.error("【外国人永久居留证 】请求dmz查询异常{}", e);
				return ReturnJsonUtil.getBackJson(nciicForeignerRequest.getTrnId(), ErrorCode.DEAL_EX, "");
			} finally {
				if (client != null) {
					client.close();
				}
			}
		}
		return ReturnJsonUtil.getBackJson(nciicForeignerRequest.getTrnId(), ErrorCode.DEAL_FAIL, "");
	}
}
