package com.huaxia.plaze.modules.hnair.webservice;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.jws.WebService;

import org.codehaus.xfire.client.Client;
import org.codehaus.xfire.transport.http.CommonsHttpMessageSender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.huaxia.opas.util.AppConfig;
import com.huaxia.opas.util.UUIDGen;
import com.huaxia.plaze.modules.MessageWebService;
import com.huaxia.plaze.modules.hnair.adapter.HnairAdapter;
import com.huaxia.plaze.modules.hnair.domain.Hnair;
import com.huaxia.plaze.modules.hnair.domain.HnairMsgResponse;
import com.huaxia.plaze.modules.hnair.domain.HnairTrnRequest;
import com.huaxia.plaze.modules.hnair.service.HnairMsgResponseService;
import com.huaxia.plaze.modules.hnair.service.HnairService;
import com.huaxia.plaze.modules.hnair.service.HnairTrnRequestService;
import com.huaxia.plaze.util.TaskStatusUtil;

@Service
@WebService(serviceName = "WST000500", endpointInterface = "com.huaxia.plaze.modules.MessageWebService")
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class HnairWebServiceImpl implements MessageWebService {
	private final static Logger logger = LoggerFactory.getLogger(HnairWebServiceImpl.class);
	private final static AppConfig appConfig = AppConfig.getInstance();

	// 对应调用的service
	@Resource
	private HnairTrnRequestService hnairTrnRequestService;

	// 对应响应的service
	@Resource
	private HnairMsgResponseService hnairMsgResponseService;

	@Resource
	private HnairService hnairService;
		
		// 信审同步地址（默认）
	 	private String defaultXinShenTongBuUrl;
	 	
		public String getDefaultXinShenTongBuUrl() {
			return defaultXinShenTongBuUrl;
		}
		public void setDefaultXinShenTongBuUrl(String defaultXinShenTongBuUrl) {
			this.defaultXinShenTongBuUrl = defaultXinShenTongBuUrl;
		}
		
	@Override
	public String invoke(String jsonRequest) {
		AppConfig config = AppConfig.getInstance();
		setDefaultXinShenTongBuUrl(config.getValue("DEFAULT_XINSHEN_TONGBU_URL"));
		// 分解请求参数
		String requestChannel = "";
		String trnId = "";
		String trnCode = "";
		String queryMode = "";
		String certType = "";
		String crtNo = "";
		String name = "";
		String mobile = "";
		String appId = "";
		String requestBody = "";
		// 解析调用的报文
		JSONObject jsonObject = JSON.parseObject(jsonRequest);
		if (jsonObject != null) {
			if (jsonObject.containsKey("REQUEST") && jsonObject.getString("REQUEST") != null
					&& !"".equals(jsonObject.getString("REQUEST"))) {
				JSONObject jsonRequet = JSON.parseObject(jsonObject.getString("REQUEST"));
				if (jsonRequet.containsKey("HEAD") && jsonRequet.getString("HEAD") != null
						&& !"".equals(jsonRequet.getString("HEAD"))) {
					JSONObject jsonHead = JSON.parseObject(jsonRequet.getString("HEAD"));
					if (jsonHead.containsKey("REQUEST_CHANNEL") && jsonHead.getString("REQUEST_CHANNEL") != null
							&& !"".equals(jsonHead.getString("REQUEST_CHANNEL"))) {
						requestChannel = jsonHead.getString("REQUEST_CHANNEL");
					}
					if (jsonHead.containsKey("TRN_ID") && jsonHead.getString("TRN_ID") != null
							&& !"".equals(jsonHead.getString("TRN_ID"))) {
						trnId = jsonHead.getString("TRN_ID");
					}
					if (jsonHead.containsKey("TRN_CODE") && jsonHead.getString("TRN_CODE") != null
							&& !"".equals(jsonHead.getString("TRN_CODE"))) {
						trnCode = jsonHead.getString("TRN_CODE");
					}
				}

				if (jsonRequet.containsKey("BODY") && jsonRequet.getString("BODY") != null
						&& !"".equals(jsonRequet.getString("BODY"))) {
					JSONObject jsonBody = JSON.parseObject(jsonRequet.getString("BODY"));
					if (jsonBody.containsKey("QUERY_MODE") && jsonBody.getString("QUERY_MODE") != null
							&& !"".equals(jsonBody.getString("QUERY_MODE"))) {
						queryMode = jsonBody.getString("QUERY_MODE");
					}
					if (jsonBody.containsKey("CERT_TYPE") && jsonBody.getString("CERT_TYPE") != null
							&& !"".equals(jsonBody.getString("CERT_TYPE"))) {
						certType = jsonBody.getString("CERT_TYPE");
					}
					if (jsonBody.containsKey("CERT_NO") && jsonBody.getString("CERT_NO") != null
							&& !"".equals(jsonBody.getString("CERT_NO"))) {
						crtNo = jsonBody.getString("CERT_NO");
					}
					if (jsonBody.containsKey("NAME") && jsonBody.getString("NAME") != null
							&& !"".equals(jsonBody.getString("NAME"))) {
						name = jsonBody.getString("NAME");
					}
					if (jsonBody.containsKey("MOBILE") && jsonBody.getString("MOBILE") != null
							&& !"".equals(jsonBody.getString("MOBILE"))) {
						mobile = jsonBody.getString("MOBILE");
					}
					if (jsonBody.containsKey("APPID") && jsonBody.getString("APPID") != null
							&& !"".equals(jsonBody.getString("APPID"))) {
						appId = jsonBody.getString("APPID");
					}
					if (jsonBody.containsKey("REQUESTBODY") && jsonBody.getString("REQUESTBODY") != null
							&& !"".equals(jsonBody.getString("REQUESTBODY"))) {
						requestBody = jsonBody.getString("REQUESTBODY");
					}
				}
			}
		}

		// 调用报文入库
		HnairTrnRequest hnairTrnRequest = new HnairTrnRequest();
		hnairTrnRequest.setUuid(UUIDGen.getUUID());
		hnairTrnRequest.setCrtTime(new Date());
		hnairTrnRequest.setCrtUser("PLAZE");
		hnairTrnRequest.setTrnId(trnId);
		hnairTrnRequest.setRequestChannel(requestChannel);
		hnairTrnRequest.setQueryMode(queryMode);
		hnairTrnRequest.setCertType(certType);
		hnairTrnRequest.setCertNo(crtNo);
		hnairTrnRequest.setName(name);
		hnairTrnRequest.setMobile(mobile);
		hnairTrnRequest.setRequestBody(requestBody);
		hnairTrnRequestService.save(hnairTrnRequest);

		//查询模式为1联机查询
		if (queryMode.equals("1") || queryMode.equals("")) {

			//发送报文，返回结果
			return	sendData(requestChannel,jsonRequest,trnId,crtNo);
			
		//查询模式为2本地和联机查找
		} else if (queryMode.equals("2")) {
			List<HnairMsgResponse> responseList = new ArrayList<HnairMsgResponse>(1);
			Calendar calendar = Calendar.getInstance();
			Date endDate = calendar.getTime();
			calendar.add(Calendar.DAY_OF_YEAR, -1);
			Date startDate = calendar.getTime();
			responseList = 	hnairMsgResponseService.selectListByParams(startDate,endDate);
			//数据库中没有24小时内该条数据，进行联机查找数据入库
			//如果本地没有数据，联机
			if (responseList.size() == 0) {
				//发送报文，返回结果
				return	sendData(appId,jsonRequest,trnId,crtNo);
				
				//如果本地没有数据，联机
			} else {
				if (responseList.get(0).getMessageBody() == null  || responseList.get(0).getMessageBody().equals("")) {
				
					//发送报文，返回结果
				return	sendData(appId,jsonRequest,trnId,crtNo);
				
				//如果本地有数据，本地查询
				} else {

						String message = responseList.get(0).getMessageBody();
						// 连接字符串，实现数据库的查询和实现
						Map<String, Object> head = new HashMap<String, Object>();
						head.put("RESPONSE_CHANNEL", "PLAZE");
						head.put("TRN_ID", trnId);
						
						Map<String, Object> body = new HashMap<String, Object>();
						body.put("RESPONSE_CODE", "000000");
						body.put("RESPONSE_DESC", "处理成功");
						body.put("RESPONSE_BODY", String.valueOf(message));
						
						Map<String, Object> response = new HashMap<String, Object>();
						response.put("HEAD", head);
						response.put("BODY", body);
						
						Map<String, Object> params = new HashMap<String, Object>();
						params.put("RESPONSE", response);
						
						JSONObject jsonStr = new JSONObject(params);
						return JSON.toJSONString(jsonStr);		
					
				}
			}
		}

		return "No Data!";
	}
	
	
	public String sendData(String requestChannel,String jsonRequest,String trnId,String certNo){
		
		// 调用DMZ
		Client client = null;
		String returnMessage = null;
		Object[] result = null;
		try {
			URL url = new URL(appConfig.getValue("hnair.dmz.webservice.url"));
			HttpURLConnection httpConnection = (HttpURLConnection) url.openConnection();
			httpConnection.setReadTimeout(30000);// 设置http连接的读超时，单位是毫秒
			httpConnection.connect();
			client = new Client(httpConnection.getInputStream(), null);
			// 设置发送超时限制，单位是毫秒
			client.setProperty(CommonsHttpMessageSender.HTTP_TIMEOUT, String.valueOf(30000));
			client.setProperty(CommonsHttpMessageSender.DISABLE_KEEP_ALIVE, "true");
			client.setProperty(CommonsHttpMessageSender.DISABLE_EXPECT_CONTINUE, "true");
			result = client.invoke("invoke", new Object[] { jsonRequest });
		} catch (Exception e) {
			if (logger.isInfoEnabled()) {
				logger.info("trnId=" + trnId + "fico的webservice连链接异常", e);
			}
		}

		try {
			String message = "";
			if (result != null) {
				// 分解请求参数
				JSONObject jsonResponse = JSON.parseObject(String.valueOf(result[0]));
				if (jsonResponse.containsKey("RESPONSE") && jsonResponse.getString("RESPONSE") != null
						&& !"".equals(jsonResponse.getString("RESPONSE"))) {
					JSONObject jsonRes = JSON.parseObject(jsonResponse.getString("RESPONSE"));

					if (jsonRes.containsKey("HEAD") && jsonRes.getString("HEAD") != null
							&& !"".equals(jsonRes.getString("HEAD"))) {
						JSONObject jsonHead = JSON.parseObject(jsonRes.getString("HEAD"));
						if (jsonHead.containsKey("TRN_ID") && jsonHead.getString("TRN_ID") != null
								&& !"".equals(jsonHead.getString("TRN_ID"))) {
							trnId = jsonHead.getString("TRN_ID");
						}
					}

					if (jsonRes.containsKey("BODY") && jsonRes.getString("BODY") != null
							&& !"".equals(jsonRes.getString("BODY"))) {
						JSONObject jsonBody = JSON.parseObject(jsonRes.getString("BODY"));
						if (jsonBody.containsKey("RESPONSE_BODY") && jsonBody.getString("RESPONSE_BODY") != null
								&& !"".equals(jsonBody.getString("RESPONSE_BODY"))) {
							message = jsonBody.getString("RESPONSE_BODY");
						}
					}

					// 响应报文入库
					HnairMsgResponse hnairMsgResponse = new HnairMsgResponse();
					hnairMsgResponse.setCrtUser(requestChannel);
					hnairMsgResponse.setTrnId(trnId);
					hnairMsgResponse.setMessageBody(message);
					hnairMsgResponseService.save(hnairMsgResponse);

					//报文解析入库
					Hnair hnair = HnairAdapter.parsehnair(message);
					try {
					if (hnair != null) {
						hnair.setTrnId(trnId);
						hnair.setCrtUser(requestChannel);
						hnair.setCertNo(certNo);
						hnairService.save(hnair);
						if (logger.isDebugEnabled()) {
							logger.debug("[三方客户端 & 海航] 报文数据持久化成功, trnId: {}",trnId);
						}
					 }
					} catch (Exception e) {
						 if (logger.isErrorEnabled()) {
							 logger.error("[三方客户端 & 海航] 报文数据入库失败   "+trnId+" Exception:{}",e);
						 }
					}

				}
				return String.valueOf(result[0]);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("[FICO] 请求查询异常:{}", e.getMessage());
		} finally {
			if (client != null) {
				client.close();
			}
		}
		return null;
	}
}
