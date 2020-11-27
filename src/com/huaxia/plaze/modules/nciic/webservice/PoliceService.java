package com.huaxia.plaze.modules.nciic.webservice;

import java.net.MalformedURLException;
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
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.huaxia.opas.util.AppConfig;
import com.huaxia.plaze.modules.MessageWebService;
import com.huaxia.plaze.modules.nciic.domain.NciicXpInfo;
import com.huaxia.plaze.modules.nciic.domain.NciicXpRequest;
import com.huaxia.plaze.modules.nciic.service.PoliceRequestService;
import com.huaxia.plaze.modules.nciic.service.PoliceResponseService;
import com.huaxia.plaze.modules.nciic.util.ErrorCode;
import com.huaxia.plaze.modules.nciic.util.PoliceRequestParseUtil;
import com.huaxia.plaze.modules.nciic.util.PoliceResponseParseUtil;
import com.huaxia.plaze.modules.nciic.util.ReturnJsonUtil;

@Service
@WebService(serviceName = "WST000201", endpointInterface = "com.huaxia.plaze.modules.MessageWebService")
public class PoliceService implements MessageWebService {

	@Resource
	private PoliceRequestService policeRequestService;
	@Resource
	private PoliceResponseService policeResponseService;

	private final static Logger logger = LoggerFactory.getLogger(PoliceService.class);

	@Override
	public String invoke(String jsonRequest) {
		//一， 解析请求报文
		NciicXpRequest xpRequest = PoliceRequestParseUtil.parsingRequest(jsonRequest);
		if (xpRequest == null) {
			return ReturnJsonUtil.getBackJson("", ErrorCode.NO_PASS, "");
		}
		
		// 二，保存请求报文
		int number = policeRequestService.save(xpRequest);
		if (number < 1) {
			logger.info("保存请求参数失败！trn_id={}", xpRequest.getTrnId());
		}
		
		// 三，查找
		if ("2".equals(xpRequest.getQueryMode())) {
			String responseJson = policeResponseService.queryResponseByRequest(xpRequest.getName(),
					xpRequest.getCertNo());
			if (StringUtils.isNotBlank(responseJson)) {
				return ReturnJsonUtil.getBackJson(xpRequest.getTrnId(), ErrorCode.OK, responseJson);
			} else {
				// 查询找结果为空
				return ReturnJsonUtil.getBackJson(xpRequest.getTrnId(), ErrorCode.DEAL_EX, "");
			}
		}

		// 四，联机查询
		if ("1".equals(xpRequest.getQueryMode())) {
			Client client = null;
			try {
				client = new Client(new URL(AppConfig.getInstance().getValue("police.xp.dmz.webservice.url")));
				Object[] result = client.invoke("invoke", new Object[] { jsonRequest });
				String resultStr = String.valueOf(result[0]);
				//判断响应成功或失败（响应码000000或999999）
				boolean flag = PoliceResponseParseUtil.checkResponseCode(resultStr);
				if (flag) {
					//1，解析响应报文
					NciicXpInfo xpInfo = PoliceResponseParseUtil.parseResult(resultStr);
					if (xpInfo == null) {
						logger.error("人像比对】解析dmz报文异常 trn_id = " + xpRequest.getTrnId());
					}else{
						xpInfo.setCrtUser(xpRequest.getRequestChannel());
						//2，持久换响应报文和解析数据
						int rowChange = policeResponseService.save(xpInfo);
						if (rowChange < 1) {
							logger.error("【人像比对】持久化返回结果失败");
						}else{
							CloseableHttpClient httpClient = null;
							CloseableHttpResponse response = null;
							try {
								if("CAMS".equals(xpRequest.getRequestChannel()) && "系统判断为同一人".equals(xpInfo.getResultFx())){
									String requestJson = createRequestJson(xpRequest);
									httpClient = HttpClients.createDefault();
									HttpPost post = new HttpPost(AppConfig.getInstance().getValue("ibis.reg.webservice.url"));
									post.setProtocolVersion(HttpVersion.HTTP_1_0);
									post.addHeader(HTTP.CONN_DIRECTIVE, HTTP.CONN_CLOSE);
									StringEntity paramEntity = new StringEntity(requestJson,"UTF-8");
									paramEntity.setContentType("application/json");
									post.setEntity(paramEntity);
									response = httpClient.execute(post);
									HttpEntity value = response.getEntity();
									String resStr = EntityUtils.toString(value);
									EntityUtils.consume(value);
									JSONObject json = JSONObject.parseObject(resStr);
									if(logger.isInfoEnabled()){
										logger.info("人脸注册响应报文：{}",resStr);
									}
									if("0".equals(json.getString("code"))){
										logger.info("人像调用人脸注册系统接口失败，响应报文={}",resStr);
									}
									JSONObject jsonresult = json.getJSONObject("result");
									if(!"0000".equals(jsonresult.getString("code"))){
										logger.info("人像注册人脸系统比对失败，响应报文为={}",resStr);
									}
								}
							} catch (Exception e) {
								logger.error("人像注册人脸识别系统出错appid=【"+xpRequest.getAppId()+"】",e);
							}finally{
								if(response != null){
									response.close();
								}
								if(httpClient!=null){
									httpClient.close();
								}
							}
						}
					}
				} else {
					logger.error("dmz返回的报文中原始报文不存在！！！");
				}
				// 将dmz响应报文，传递下去
				return resultStr;
			} catch (Exception e) {
				logger.error("公安人像比对 】请求dmz查询异常{}", e);
				return ReturnJsonUtil.getBackJson(xpRequest.getTrnId(), ErrorCode.DEAL_EX, "");
			} finally {
				if (client != null) {
					client.close();
				}
			}

		}
		return ReturnJsonUtil.getBackJson(xpRequest.getTrnId(), ErrorCode.DEAL_FAIL, "");
	}
	
	public String createRequestJson(NciicXpRequest xpRequest){
		Map<String,Object> request = new HashMap<String,Object>();
		request.put("Buscode", "reg");   					//接口代码
		request.put("verCode", "ver001");					//版本代码
		request.put("orgCode", "0001");						//法人机构代码
		request.put("ctfno", xpRequest.getCertNo());		//证件号码  建议要求身份证
		request.put("ctfname", xpRequest.getName());		//姓名
		//.......证件类型要做映射
		if(xpRequest.getCertType().equals("01")){			//身份证映射
			xpRequest.setCertType("0200");
		}
		if(xpRequest.getCertType().equals("03")){			//护照映射
			xpRequest.setCertType("0201");
		}
		if(xpRequest.getCertType().equals("04")){ 			//港澳台通行证
			xpRequest.setCertType("0202");
		}
		if(xpRequest.getCertType().equals("91")){ 			//台湾居民居住证
			xpRequest.setCertType("0203");
		}
		request.put("ctftype", xpRequest.getCertType());	//证件类型
		request.put("customerId", "");						//核心客户号
		request.put("property", "");						//客户属性
		request.put("channel", "0306");						//渠道
		request.put("tradingCode", "0600");					//交易代码
		request.put("engineCode", "cyface");				//引擎代码
		request.put("regfileData", xpRequest.getXp());		//base64照片
		request.put("netCheckStatus", "0");					//0：表示用regfileData进行注册，1：表示要联网核查获取客户注册文件
		request.put("netCheckFileData", "");
		request.put("netCheckImgType", "");
		request.put("tradingFlowNo", xpRequest.getAppId());	//业务交易流水号
		request.put("tradingDate", "");						//业务交易日期
		request.put("tradingTime", "");     				//业务交易时间
		request.put("equipmenNo", "");						//设备号
		request.put("organizationNo", "");  				//机构号
		request.put("tellerNo", "");						//柜员号
		request.put("bankcarNo", "");						//银行卡号
		JSONObject jsonObject = new JSONObject(request);
		return JSON.toJSONString(jsonObject);
	}
}
