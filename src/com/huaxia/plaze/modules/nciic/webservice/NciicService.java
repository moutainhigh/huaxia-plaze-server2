package com.huaxia.plaze.modules.nciic.webservice;

import java.net.MalformedURLException;
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
import com.huaxia.plaze.modules.nciic.util.ErrorCode;
import com.huaxia.plaze.modules.nciic.util.RequestParseUtil;
import com.huaxia.plaze.modules.nciic.util.ResponseParseUtil;
import com.huaxia.plaze.modules.nciic.util.ReturnJsonUtil;
import com.huaxia.plaze.modules.nciic.domain.NciicInfo;
import com.huaxia.plaze.modules.nciic.domain.NciicRequest;
import com.huaxia.plaze.modules.nciic.domain.NciicResponse;
import com.huaxia.plaze.modules.nciic.service.NciicRequestService;
import com.huaxia.plaze.modules.nciic.service.NciicResponseService;

@Service
@WebService(serviceName = "WST000200", endpointInterface = "com.huaxia.plaze.modules.MessageWebService")
public class NciicService implements MessageWebService {

	private final static Logger logger = LoggerFactory.getLogger(NciicService.class);

	@Resource
	private NciicRequestService nciicRequestService;

	@Resource
	private NciicResponseService nciicResponseService;

	@Override
	public String invoke(String jsonRequest) {
		// 解析请求报文
		NciicRequest nciicRequest = RequestParseUtil.parsingResult(jsonRequest);
		if (nciicRequest == null) {
			return ReturnJsonUtil.getErrorBackJson("", ErrorCode.NO_PASS);
		}
		// 检查报文必要元素
		if (nciicRequest != null) {
			if (StringUtils.isBlank(nciicRequest.getQueryMode()) || StringUtils.isBlank(nciicRequest.getCertNo())
					|| StringUtils.isBlank(nciicRequest.getName()) || StringUtils.isBlank(nciicRequest.getTrnId())
					) {
				return ReturnJsonUtil.getErrorBackJson("", ErrorCode.MISS_EL);
			}
		}
		// 保存请求报文
		nciicRequest.setCrtUser("PLAZE");
		int rowNumber = nciicRequestService.save(nciicRequest);
		if (rowNumber <= 0) {
			logger.info("保存请求参数失败！TRN_ID={}", nciicRequest.getTrnId());
		}
		// 查找请求处理  暂时不用查找处理功能
		/*if ("2".equals(nciicRequest.getQueryMode())) {
			String responseJson = nciicResponseService.queryResponseByRequest(nciicRequest.getName(),
					nciicRequest.getCertNo());
				if (StringUtils.isNotBlank(responseJson)) {
					// 连接字符串，实现数据库的查询和实现
					Map<String, Object> head = new HashMap<String, Object>();
					head.put("REQUEST_SYSTEM", "CAMS");
					head.put("TRN_ID", nciicRequest.getTrnId());
					
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
					System.out.println(JSON.toJSONString(jsonStr));
					responseJson = JSON.toJSONString(jsonStr);
				return responseJson;
			}
			// 查询找结果为空
			return ReturnJsonUtil.getErrorBackJson("", ErrorCode.DEAL_EX);
		}*/
		// 查询请求处理(查询是取DMZ查询 查找在本地库查找)
		if ("1".equals(nciicRequest.getQueryMode())) {
			// 开始请求DMZ webservice
			Client client = null;
			// 获取配置文件中 webservice配置的url地址
			URL url = null;
			try {
				 url = new URL(AppConfig.getInstance().getValue("nciic.dmz.webservice.url"));
			} catch (MalformedURLException e) {
				logger.error("[简项公安] DMZUrl url{} 格式异常:{}", url.toString(), e);
				e.printStackTrace();
			}
			try {
				client = new Client(url);
			} catch (Exception e) {
				logger.error("[简项公安] 创建请求客户端异常：{}", e);
				e.printStackTrace();
			}

			try {
				Object[] obj = new Object[] { jsonRequest };
				Object[] result = client.invoke("invoke", obj);
				if (result != null) {
					if(ResponseParseUtil.parsingArguments(String.valueOf(result[0]))){
					// 解析返回结果
					NciicInfo nciicInfo = ResponseParseUtil.parsingResult(String.valueOf(result[0]));
					/** 原始报文表的crtUser存各个渠道的请求代号 丁国峰 */
					nciicInfo.setCrtUser(nciicRequest.getRequestChannel());
						int rowChage=nciicResponseService.save(nciicInfo);
						if(rowChage<1){
							logger.error("[简项公安] 持久化返回结果失败");
						}
					}else{
						logger.error("[简项公安] 持久化返回结果失败");
					}
					
					return String.valueOf(result[0]);
				}
			} catch (Exception e) {
				logger.error("[简项公安] 请求查询异常:{}", e.getMessage());
				e.printStackTrace();
				return ReturnJsonUtil.getErrorBackJson(nciicRequest.getTrnId(), ErrorCode.DEAL_EX);
			} finally {
				if (client != null) {
					client.close();
				}
			}
		}
		return ReturnJsonUtil.getErrorBackJson(nciicRequest.getTrnId(), ErrorCode.DEAL_FAIL);
	}

}
