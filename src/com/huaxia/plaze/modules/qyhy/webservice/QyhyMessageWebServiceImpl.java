package com.huaxia.plaze.modules.qyhy.webservice;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.jws.WebService;

import org.codehaus.xfire.client.Client;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.huaxia.opas.util.AppConfig;
import com.huaxia.plaze.modules.MessageWebService;
import com.huaxia.plaze.modules.qyhy.adapter.QyhyInfoParseAdapter;
import com.huaxia.plaze.modules.qyhy.domain.QyhyInfo;
import com.huaxia.plaze.modules.qyhy.domain.QyhyResponseParameters;
import com.huaxia.plaze.modules.qyhy.domain.QyhyTrnRequestParameters;
import com.huaxia.plaze.modules.qyhy.service.QyhyInfoService;
import com.huaxia.plaze.modules.qyhy.service.QyhyTrnRequestService;
import com.huaxia.plaze.modules.qyhy.service.QyhyTrnResponseService;
import com.huaxia.plaze.modules.qyhy.util.ErrorCode;
import com.huaxia.plaze.modules.qyhy.util.RequestParseUtil;
import com.huaxia.plaze.modules.qyhy.util.ResponseParseUtil;
import com.huaxia.plaze.modules.qyhy.util.ReturnJsonUtil;

@Service
@WebService(serviceName="WST001200",endpointInterface="com.huaxia.plaze.modules.MessageWebService")
public class QyhyMessageWebServiceImpl implements MessageWebService{
	private static Logger logger = LoggerFactory.getLogger(QyhyMessageWebServiceImpl.class);
	
	@Resource(name="qyhyInfoService")
	private QyhyInfoService qyhyInfoService;
	
	@Resource(name="qyhyTrnRequestService")
	private  QyhyTrnRequestService qyhyTrnRequestService;
	
	@Resource(name="qyhyTrnResponseService")
	private QyhyTrnResponseService qyhyTrnResponseService;
	
	public QyhyMessageWebServiceImpl() {
		//获取配置参数
		AppConfig config = AppConfig.getInstance();
	}
	
	@Override
	public String invoke(String jsonRequest) {
		
		// 分解请求参数
		QyhyTrnRequestParameters trnRequestParameters= RequestParseUtil.parsingResult(jsonRequest);
		
		if (trnRequestParameters == null) {
			return ReturnJsonUtil.getErrorBackJson("", ErrorCode.NO_PASS);
		}

		String response = ReturnJsonUtil.getErrorBackJson("trnId :" + trnRequestParameters.getTrnId(), ErrorCode.DEAL_EX);
		
		// 保存请求报文
		String enterprise = "";
		String identityNo = "";		
		try {
			trnRequestParameters.setCrtUser("PLAZE");
			enterprise = trnRequestParameters.getEnterprise();
			identityNo = trnRequestParameters.getCertNo();
			
			/** 加入30天查库逻辑 */
			String historyReport = qyhyTrnRequestService.findHistoryReport(enterprise);
			int rowNumber = qyhyTrnRequestService.saveQyhyRequestParameters(trnRequestParameters);
			if (rowNumber <= 0) {
				logger.error("保存请求参数失败！TRN_ID={}", trnRequestParameters.getTrnId());
			}
			if(historyReport != null && !"".equals(historyReport)){
				Map<String, Object> head = new HashMap<String, Object>();
				head.put("REQUEST_SYSTEM", "PLAZE");
				head.put("TRN_ID", trnRequestParameters.getTrnId());

				Map<String, Object> body = new HashMap<String, Object>();
				body.put("RESPONSE_CODE", "000000");
				body.put("RESPONSE_DESC", "处理成功");
				body.put("RESPONSE_BODY", historyReport);

				Map<String, Object> res = new HashMap<String, Object>();
				res.put("HEAD", head);
				res.put("BODY", body);

				Map<String, Object> params = new HashMap<String, Object>();
				params.put("RESPONSE", res);

				JSONObject jsonStr = new JSONObject(params);
				return JSON.toJSONString(jsonStr);
			}
		} catch (Exception e1) {
			e1.printStackTrace();
			logger.error("",e1);
			return response;
		}
		
		if ("3".equals(trnRequestParameters.getQueryMode())) {
			// 开始请求DMZ webservice
			Client client = null;
			URL url = null;
			
			try {
				url = new URL(AppConfig.getInstance().getValue("qyhy.dmz.webservice.url"));
				client = new Client(url);
			} catch (Exception e) {
				logger.error("[企业行业信息] 创建客户端异常:{}", e);
				e.printStackTrace();
				return response;
			}

			try {
				Object[] obj = new Object[] { jsonRequest };
				Object[] result = client.invoke("invoke", obj);
				if (result != null) {
					response = String.valueOf(result[0]);
					QyhyResponseParameters trnResponseParameters = ResponseParseUtil.parsingResult(String.valueOf(result[0]));
					String trnId = trnResponseParameters.getTrnId(); 
					String responseBody = trnResponseParameters.getResponseBody();//BODY体里面的RESPONSE_BODY,即原始报文
					String responseCode = trnResponseParameters.getResponseCode();
					if(!"000000".equals(responseCode)){
						return response;
					}
					// 构建请求参数
					StringBuilder builder = new StringBuilder();
					builder.append(trnId);//交易编号
					builder.append("##,##");
					builder.append(enterprise);//单位全称
					builder.append("##,##");
					builder.append(identityNo);//身份证号
					builder.append("##,##");
					builder.append(responseBody);//原始报文
					String builderMessage = builder.toString();
					QyhyInfoParseAdapter qyhyInfoParseAdapter = new QyhyInfoParseAdapter();
					QyhyInfo qyhyInfo = null;
					//解析原始报文
					qyhyInfo = qyhyInfoParseAdapter.parse(builderMessage);
					try {
						if (qyhyInfo != null) {
							qyhyInfoService.saveQyhyInfoUpdateDataAdapterAction(qyhyInfo, trnId,trnRequestParameters.getRequestChannel());
							if (logger.isDebugEnabled()) {
								logger.debug("[客户端 & 企业行业信息] 报文数据持久化成功, 申请件编号: {}", trnId);
							}
						}
						} catch (Exception e) {
							 if (logger.isErrorEnabled()) {
								 logger.error("[客户端 & 企业行业信息] 报文数据持久化失败   "+trnId+" Exception:{}",e);
							 }
						}
					
					trnResponseParameters.setCrtUser(trnRequestParameters.getRequestChannel());
					//保存原始报文
					int saveResult =qyhyTrnResponseService.saveBodyOriginal(trnResponseParameters);
					if (saveResult <= 0) {
						logger.error("保存原始报文失败！TRN_ID={}", trnResponseParameters.getTrnId());
					}
					return response;
				}
			} catch (Exception e) {
				logger.error("[企业行业信息] 请求查询异常:{}", e.getMessage());
				e.printStackTrace();
			} finally {
				if (client != null) {
					client.close();
				}
			}
		}
		
		return response;
			
	}

}