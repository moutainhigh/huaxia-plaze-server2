package com.huaxia.plaze.modules.tongdun.webservice;

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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.huaxia.opas.util.AppConfig;
import com.huaxia.plaze.modules.MessageWebService;
import com.huaxia.plaze.modules.tongdun.adapter.MultipleBorrowAdapter;
import com.huaxia.plaze.modules.tongdun.domain.MulBorInfo;
import com.huaxia.plaze.modules.tongdun.domain.MulBorMsgResponse;
import com.huaxia.plaze.modules.tongdun.domain.MulBorTrnRequest;
import com.huaxia.plaze.modules.tongdun.service.MulBorMsgResponseService;
import com.huaxia.plaze.modules.tongdun.service.MulBorTrnRequestService;
import com.huaxia.plaze.modules.tongdun.service.MultipleBorrowService;
import com.huaxia.util.GuidUtil;

@Service
@WebService(serviceName = "WST001500", endpointInterface = "com.huaxia.plaze.modules.MessageWebService")
public class DtjdWebService implements MessageWebService {

	private final static Logger logger = LoggerFactory.getLogger(DtjdWebService.class);

	@Resource
	private MultipleBorrowService multipleBorrowService;

	@Resource
	private MulBorTrnRequestService mulBorTrnRequestService;

	@Resource
	private MulBorMsgResponseService mulBorMsgResponseService;

	@Override
	public String invoke(String jsonRequest) {
		// 分解请求参数
		String requestChannel = "";
		String trnId = "";
		String trnCode = "";
		String queryMode = "";
		String certType = "";
		String crtNo = "";
		String name = "";
		String mobile = "";
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
				}
			}
		}

		// 调用报文入库
		MulBorTrnRequest mulBorTrnRequest = new MulBorTrnRequest();
		mulBorTrnRequest.setUuid(GuidUtil.getGuid());
		mulBorTrnRequest.setCrtTime(new Date());
		mulBorTrnRequest.setCrtUser("PLAZE");
		mulBorTrnRequest.setTrnId(trnId);
		mulBorTrnRequest.setRequestChannel(requestChannel);
		mulBorTrnRequest.setQueryMode(queryMode);
		mulBorTrnRequest.setCertType(certType);
		mulBorTrnRequest.setCertNo(crtNo);
		mulBorTrnRequest.setName(name);
		mulBorTrnRequest.setMobile(mobile);
		mulBorTrnRequestService.save(mulBorTrnRequest);

		if (queryMode.equals("1") || queryMode.equals("")) {
			// 查询模式状态为1，是联机查找，报文解析入库
			Client client = null;
			String message = "";
			try {
				client = new Client(new URL(AppConfig.getInstance().getValue("tongdun.dtjd.dmz.webservice.url")));
				Object[] obj = new Object[] { jsonRequest };
				Object[] result = client.invoke("invoke", obj);

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
						MulBorMsgResponse mulBorMsgResponse = new MulBorMsgResponse();
						mulBorMsgResponse.setCrtUser(requestChannel);
						mulBorMsgResponse.setTrnId(trnId);
						mulBorMsgResponse.setMessageBody(message);
						mulBorMsgResponseService.save(mulBorMsgResponse);
					}
					//dmz返回999，代表异常，不进行分解入库，返回信息
					if("999".equals(message)){
						return String.valueOf(result[0]);
					}
					//没有异常，分解入库
					MulBorInfo mulbor = new MultipleBorrowAdapter().parseMulBorInfo(message, "", requestChannel, crtNo,
							mobile, trnId);
					multipleBorrowService.save(mulbor);
					return String.valueOf(result[0]);
				}
			} catch (Exception e) {
				e.printStackTrace();
				logger.error("[多头借贷] 请求查询异常:{}", e.getMessage());
			} finally {
				if (client != null) {
					client.close();
				}
			}
		} else if (queryMode.equals("2")) {
			List<MulBorMsgResponse> responseList = new ArrayList<MulBorMsgResponse>(1);
			Calendar calendar = Calendar.getInstance();
			Date endDate = calendar.getTime();
			calendar.add(Calendar.DAY_OF_YEAR, -1);
			Date startDate = calendar.getTime();
			responseList = mulBorMsgResponseService.selectListByParams(crtNo, mobile, startDate, endDate);
			// 数据库中没有24小时内该条数据，进行联机查找数据入库
			if (responseList.size() == 0) {
				Client client = null;
				String message = "";
				try {
					client = new Client(new URL(AppConfig.getInstance().getValue("tongdun.dtjd.dmz.webservice.url")));
					Object[] obj = new Object[] { jsonRequest };
					Object[] result = client.invoke("invoke", obj);

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
							MulBorMsgResponse mulBorMsgResponse = new MulBorMsgResponse();
							mulBorMsgResponse.setCrtUser(requestChannel);
							mulBorMsgResponse.setTrnId(trnId);
							mulBorMsgResponse.setMessageBody(message);
							mulBorMsgResponseService.save(mulBorMsgResponse);
						}
						MulBorInfo mulbor = new MultipleBorrowAdapter().parseMulBorInfo(message, "", requestChannel,
								crtNo, mobile, trnId);
						multipleBorrowService.save(mulbor);
						return String.valueOf(result[0]);
					}
				} catch (Exception e) {
					e.printStackTrace();
					logger.error("[多头借贷] 请求查询异常:{}", e.getMessage());
				} finally {
					if (client != null) {
						client.close();
					}
				}
			} else if (responseList.get(0).getMessageBody() == null
					|| responseList.get(0).getMessageBody().equals("")) {
				System.out.println("没有值！");
				Client client = null;
				String message = "";
				try {
					client = new Client(new URL(AppConfig.getInstance().getValue("tongdun.dtjd.dmz.webservice.url")));
					Object[] obj = new Object[] { jsonRequest };
					Object[] result = client.invoke("invoke", obj);

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
							MulBorMsgResponse mulBorMsgResponse = new MulBorMsgResponse();
							mulBorMsgResponse.setCrtUser(requestChannel);
							mulBorMsgResponse.setTrnId(trnId);
							mulBorMsgResponse.setMessageBody(message);
							mulBorMsgResponseService.save(mulBorMsgResponse);
						}
						MulBorInfo mulbor = new MultipleBorrowAdapter().parseMulBorInfo(message, "", requestChannel,
								crtNo, mobile, trnId);
						multipleBorrowService.save(mulbor);
						return String.valueOf(result[0]);
					}
				} catch (Exception e) {
					e.printStackTrace();
					logger.error("[多头借贷] 请求查询异常:{}", e.getMessage());
				} finally {
					if (client != null) {
						client.close();
					}
				}

			} else {
				// 数据库中存在24小时内该条数据，进行数据入库
				try {
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

				} catch (Exception e) {
					e.printStackTrace();
					logger.error("[多头借贷] 请求查询异常:{}", e.getMessage());
				} finally {

				}
			}

		}

		return null;
	}

}
