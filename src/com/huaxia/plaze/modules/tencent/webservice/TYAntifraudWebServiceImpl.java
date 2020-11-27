package com.huaxia.plaze.modules.tencent.webservice;

import java.net.URL;
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
import com.huaxia.plaze.modules.tencent.domain.TYAntifraud;
import com.huaxia.plaze.modules.tencent.parse.TianYuMessageParser;
import com.huaxia.plaze.modules.tencent.service.TYAntifraudRpService;
import com.huaxia.plaze.modules.tencent.service.TYAntifraudRqInfoService;
import com.huaxia.plaze.modules.tencent.service.TYAntifraudService;
import com.huaxia.plaze.modules.tencent.util.TianYuRequestParseUtil;
import com.huaxia.plaze.modules.tencent.util.ResponseCode;
import com.huaxia.plaze.modules.tencent.util.TianYuResponseParseUtil;
import com.huaxia.plaze.modules.tencent.util.TianYuReturnJsonUtil;

@Service
@WebService(serviceName="WST001000", endpointInterface="com.huaxia.plaze.modules.MessageWebService")
public class TYAntifraudWebServiceImpl implements MessageWebService {
	
	private final static Logger logger = LoggerFactory.getLogger(TYAntifraudWebServiceImpl.class);

	@Autowired
	private TYAntifraudRqInfoService tyAntifraudRqInfoService;
	
	@Autowired
	private TYAntifraudService tyAntifraudService;

	@Autowired
	private TYAntifraudRpService tyAntifraudRpService;
	
	@Override
	public String invoke(String jsonRequest) {
		
		logger.debug("调用成功");
		// 解析请求报文
		Map<String, String> params = TianYuRequestParseUtil.parseRequestInfo(jsonRequest);
		
		// 检查报文必要元素
		if (params != null) {
			if (StringUtils.isBlank(params.get("queryMode")) || StringUtils.isBlank(params.get("certNo"))
					|| StringUtils.isBlank(params.get("name")) || StringUtils.isBlank(params.get("trnId"))
					|| StringUtils.isBlank(params.get("mobile"))) {
				return TianYuReturnJsonUtil.getReturnInfo(params, ResponseCode.MISS_EL);
			}
		} else {
			return TianYuReturnJsonUtil.getReturnInfo(params, ResponseCode.NO_PASS);
		}
		
		// 查询渠道
		// 保存请求参数信息
		tyAntifraudRqInfoService.saveTYRqInfo(params);
		
		Client client = null;
		try {
			client = new Client(new URL(AppConfig.getInstance().getValue("tianyu.antifraud.dmz.webservice.url")));
			Object[] obj = new Object[] { jsonRequest };
			// 将请求报文转发到dmz 并获取返回信息
			Object[] result = client.invoke("invoke", obj);
			if (result != null) {
				// 解析返回报文信息
				Map<String, String> response = TianYuResponseParseUtil.parseResponseInfo(String.valueOf(result[0]));
				response.put("rqChannel", params.get("rqChannel"));
				// 响应信息入库
				tyAntifraudRpService.saveResponseInfo(response);

				try {
					// 解析响应报文
					TYAntifraud tyAntifraud = new TianYuMessageParser().parse(response.get("responseBody"));
					// 设置主表参数
					tyAntifraud.getTyAntifraudData().setCertNo(params.get("certNo"));
					tyAntifraud.getTyAntifraudData().setTrnId(params.get("trnId"));
					tyAntifraud.getTyAntifraudData().setCrtUser(params.get("rqChannel"));
					// 入库保存
					tyAntifraudService.save(tyAntifraud);
				} catch (Exception e) {
					logger.error("[天御分] 解析入库异常:{}", e.getMessage());
				}
				
				logger.debug("返回响应报文"+result[0]);
				// 向审批返回响应报文
				return String.valueOf(result[0]);
			}
		} catch (Exception e) {
			logger.error("[天御分] 请求查询异常:{}", e.getMessage());
		} finally {
			if (client != null) {
				client.close();
			}
		}
		return TianYuReturnJsonUtil.getReturnInfo(params,ResponseCode.DATA_SOURCE_RESP_EX);
	}

}
