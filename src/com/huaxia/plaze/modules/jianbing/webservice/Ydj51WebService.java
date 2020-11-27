package com.huaxia.plaze.modules.jianbing.webservice;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.jws.WebService;
import org.apache.commons.lang3.StringUtils;
import org.codehaus.xfire.client.Client;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.huaxia.opas.util.AppConfig;
import com.huaxia.plaze.modules.MessageWebService;
import com.huaxia.plaze.modules.jianbing.domain.JianBingTrnRequest;
import com.huaxia.plaze.modules.jianbing.service.JianBingRequestService;
import com.huaxia.plaze.modules.jianbing.service.JianBingResponseService;
import com.huaxia.plaze.modules.jianbing.util.ErrorCode;
import com.huaxia.plaze.modules.jianbing.util.RequestParseUtil;
import com.huaxia.plaze.modules.jianbing.util.ResponseParseUtil;
import com.huaxia.plaze.modules.jianbing.util.ReturnJsonUtil;

@Service
@WebService(serviceName = "WST000600", endpointInterface = "com.huaxia.plaze.modules.MessageWebService")
public class Ydj51WebService implements MessageWebService {

	private final static Logger logger = LoggerFactory.getLogger(Ydj51WebService.class);

	@Resource
	private JianBingRequestService jianBingRequestService;

	@Resource
	private JianBingResponseService jianBingResponseService;

	@Override
	public String invoke(String jsonRequest) {
		// 解析请求报文
		JianBingTrnRequest jianBingRequest = RequestParseUtil.parsingResult(jsonRequest);
		if (jianBingRequest == null) {
			return ReturnJsonUtil.getErrorBackJson("", ErrorCode.NO_PASS);
		}
		// 检查报文必要元素
		if (jianBingRequest != null) {
			if (StringUtils.isBlank(jianBingRequest.getF()) || StringUtils.isBlank(jianBingRequest.getApply_id())
					|| StringUtils.isBlank(jianBingRequest.getProduct_cid())
					|| StringUtils.isBlank(jianBingRequest.getTime())) {
				return ReturnJsonUtil.getErrorBackJson("", ErrorCode.MISS_EL);
			}
		}
		// 保存请求报文
		String Channel = jianBingRequest.getRequestChannel();
		if (StringUtils.isNotBlank(Channel)) {
			jianBingRequest.setCrtUser(Channel);
		} else {
			jianBingRequest.setCrtUser("PLAZE");
		}
		int rowNumber = 0;
		try {
			rowNumber = jianBingRequestService.save(jianBingRequest);
		} catch (Exception e) {
			logger.error("请求报文，解析入库至请求表异常:{}", e);
		}
		if (rowNumber <= 0) {
			logger.error("保存请求参数失败！TRN_ID={}", jianBingRequest.getTrnId());
		}
		// 查找请求处理
		if ("2".equals(jianBingRequest.getQueryMode())) {
			String responseJson = jianBingResponseService.queryResponseByRequest(jianBingRequest.getApply_id());
			if (StringUtils.isNotBlank(responseJson)) {
				// 连接字符串，实现数据库的查询和实现
				Map<String, Object> head = new HashMap<String, Object>();

				head.put("REQUEST_SYSTEM", "PLAZE");
				head.put("TRN_ID", jianBingRequest.getTrnId());

				Map<String, Object> body = new HashMap<String, Object>();
				body.put("RESPONSE_CODE", "000000");
				body.put("RESPONSE_DESC", "处理成功");
				body.put("RESPONSE_BODY", String.valueOf(responseJson));

				Map<String, Object> response = new HashMap<String, Object>();
				response.put("HEAD", head);
				response.put("BODY", body);

				Map<String, Object> params = new HashMap<String, Object>();
				params.put("RESPONSE", response);

				JSONObject jsonStr = new JSONObject(params);
				System.out.println("===================返回参数=============================");
				responseJson = JSON.toJSONString(jsonStr);
				return responseJson;
			}
			// 查找结果为空
			logger.info("查找请求处理完毕，但响应表中无要查询的相应数据,数据对应的trn_id为:{}",jianBingRequest.getTrnId());
			return ReturnJsonUtil.getErrorBackJson("", ErrorCode.DATA_NOTFOUND);
		}
		// 查询请求处理(查询是取DMZ查询 查找在本地库查找)
		if ("1".equals(jianBingRequest.getQueryMode())) {
			// 开始请求DMZ webservice
			Client client = null;
			// 获取配置文件中 webservice配置的url地址
			URL url = null;
			try {
				url = new URL(AppConfig.getInstance().getValue("jianbing.ydj51.dmz.webservice.url"));
				client = new Client(url);
			} catch (Exception e) {
				logger.error("[51易达金] 创建请求客户端出错，错误trn_id为:"+jianBingRequest.getTrnId()+"错误异常为：{}", e);
				return ReturnJsonUtil.getErrorBackJson(jianBingRequest.getTrnId(), ErrorCode.DATA_SOURCE_YDJDMZ);
			}
			try {
				Object[] obj = new Object[] { jsonRequest };
				Object[] result = client.invoke("invoke", obj);
				// 解析dmz返回的结果信息
				if (result != null) {
					if (ResponseParseUtil.parsingArguments(String.valueOf(result[0]))) {
						Map<String, Object> info = ResponseParseUtil.parsingResult(String.valueOf(result[0]));

						if (StringUtils.isNotBlank(Channel)) {
							info.put("crtUser", Channel);
						} else {
							info.put("crtUser", "PLAZE");
						}

						info.put("applyId", jianBingRequest.getApply_id());
						int rowChage = jianBingResponseService.save(info);
						if (rowChage < 1) {
							logger.error("[51易达金] 持久化返回结果失败");
						} else {
							logger.info("[51易达金] 持久化返回结果成功");
						}
					} else {
						logger.error("[51易达金] 持久化返回结果失败");
					}

					return String.valueOf(result[0]);
				}
			} catch (Exception e) {
				e.printStackTrace();
				logger.error("[51易达金] 请求dmz查询并解析响应过程中出错，出错trn_id:" + jianBingRequest.getTrnId() + "出错原因为:{}", e);
				return ReturnJsonUtil.getErrorBackJson(jianBingRequest.getTrnId(), ErrorCode.DATA_PARSE_YDJDMZ);
			} finally {
				if (client != null) {
					client.close();
				}
			}
		}
		
		// 先查找，若无信息则发起查询请求处理(查询是取DMZ查询 查找在本地库查找)
		if ("3".equals(jianBingRequest.getQueryMode())) {
			String responseJson = jianBingResponseService.queryResponseByRequest(jianBingRequest.getApply_id());
			if (StringUtils.isNotBlank(responseJson)) {
				// 连接字符串，实现数据库的查询和实现
				Map<String, Object> head = new HashMap<String, Object>();

				head.put("REQUEST_SYSTEM", "PLAZE");
				head.put("TRN_ID", jianBingRequest.getTrnId());

				Map<String, Object> body = new HashMap<String, Object>();
				body.put("RESPONSE_CODE", "000000");
				body.put("RESPONSE_DESC", "处理成功");
				body.put("RESPONSE_BODY", String.valueOf(responseJson));

				Map<String, Object> response = new HashMap<String, Object>();
				response.put("HEAD", head);
				response.put("BODY", body);

				Map<String, Object> params = new HashMap<String, Object>();
				params.put("RESPONSE", response);

				JSONObject jsonStr = new JSONObject(params);
				System.out.println("===================返回参数=============================");
				responseJson = JSON.toJSONString(jsonStr);
				
			}
			//如果本地数据库无数据，则调用dmz进行查询
			if(StringUtils.isBlank(responseJson)){
				// 开始请求DMZ webservice
				Client client = null;
				// 获取配置文件中 webservice配置的url地址
				URL url = null;
				try {
					url = new URL(AppConfig.getInstance().getValue("jianbing.ydj51.dmz.webservice.url"));
					client = new Client(url);
				} catch (Exception e) {
					logger.error("[51易达金] 创建请求客户端出错，错误trn_id为:"+jianBingRequest.getTrnId()+"错误异常为：{}", e);
					return ReturnJsonUtil.getErrorBackJson(jianBingRequest.getTrnId(), ErrorCode.DATA_SOURCE_YDJDMZ);
				}
				try {
					Object[] obj = new Object[] { jsonRequest };
					Object[] result = client.invoke("invoke", obj);
					// 解析dmz返回的结果信息
					if (result != null) {
						if (ResponseParseUtil.parsingArguments(String.valueOf(result[0]))) {
							Map<String, Object> info = ResponseParseUtil.parsingResult(String.valueOf(result[0]));

							if (StringUtils.isNotBlank(Channel)) {
								info.put("crtUser", Channel);
							} else {
								info.put("crtUser", "PLAZE");
							}

							info.put("applyId", jianBingRequest.getApply_id());
							int rowChage = jianBingResponseService.save(info);
							if (rowChage < 1) {
								logger.error("[51易达金] 持久化返回结果失败");
							} else {
								logger.info("[51易达金] 持久化返回结果成功");
							}
						} else {
							logger.error("[51易达金] 持久化返回结果失败");
						}

						return String.valueOf(result[0]);
					}
				} catch (Exception e) {
					e.printStackTrace();
					logger.error("[51易达金] 请求dmz查询并解析响应过程中出错，出错trn_id:" + jianBingRequest.getTrnId() + "出错原因为:{}", e);
					return ReturnJsonUtil.getErrorBackJson(jianBingRequest.getTrnId(), ErrorCode.DATA_PARSE_YDJDMZ);
				} finally {
					if (client != null) {
						client.close();
					}
				}
			}
			return responseJson;
		}
		
		return ReturnJsonUtil.getErrorBackJson(jianBingRequest.getTrnId(), ErrorCode.DEAL_FAIL);
	}

}
