package com.huaxia.plaze.modules.id5.webservice;

import java.net.MalformedURLException;
import java.net.URL;
import java.security.PrivateKey;

import javax.annotation.Resource;
import javax.jws.WebService;
import org.apache.commons.lang3.StringUtils;
import org.codehaus.xfire.client.Client;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Node;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.huaxia.opas.util.AppConfig;
import com.huaxia.plaze.modules.MessageWebService;
import com.huaxia.plaze.modules.id5.domain.Education;
import com.huaxia.plaze.modules.id5.domain.Id5Request;
import com.huaxia.plaze.modules.id5.domain.Id5Response;
import com.huaxia.plaze.modules.id5.service.Id5RequestService;
import com.huaxia.plaze.modules.id5.service.Id5ResponseService;
import com.huaxia.plaze.modules.id5.util.EducationParseUtil;
import com.huaxia.plaze.modules.id5.util.ErrorCode;
import com.huaxia.plaze.modules.id5.util.RequestParseUtil;
import com.huaxia.plaze.modules.id5.util.ResponseParseUtil;
import com.huaxia.plaze.modules.id5.util.ReturnJsonUtil;

import cn.id5.gboss.client.api.codec.security.Base64;


@Service
@WebService(serviceName = "WST000300", endpointInterface = "com.huaxia.plaze.modules.MessageWebService")
public class Id5Service implements MessageWebService {

	private final static Logger logger = LoggerFactory.getLogger(Id5Service.class);

	@Resource
	private Id5RequestService id5RequestService;

	@Resource
	private Id5ResponseService id5ResponseService;

	@Override
	public String invoke(String jsonRequest) {
		// 解析请求报文
		Id5Request Id5Request = RequestParseUtil.parsingResult(jsonRequest);
		if (Id5Request == null) {
			return ReturnJsonUtil.getErrorBackJson("", ErrorCode.NO_PASS);
		}
		// 检查报文必要元素
		if (Id5Request != null) {
			if (StringUtils.isBlank(Id5Request.getQueryMode()) || StringUtils.isBlank(Id5Request.getCertNo())
					|| StringUtils.isBlank(Id5Request.getName()) || StringUtils.isBlank(Id5Request.getTrnId())) {
				return ReturnJsonUtil.getErrorBackJson("", ErrorCode.MISS_EL);
			}
		}
		// 保存请求报文
		Id5Request.setCrtUser("PLAZE");
		int rowNumber = id5RequestService.save(Id5Request);
		if (rowNumber <= 0) {
			logger.error("保存请求参数失败！TRN_ID={}", Id5Request.getTrnId());
		}
		// 查找请求处理
		if ("2".equals(Id5Request.getQueryMode())) {
			String responseJson = id5ResponseService.findResponseByRequest(Id5Request.getName(),
					Id5Request.getCertNo(), Id5Request.getMobile());
			if (StringUtils.isNotBlank(responseJson)) {
				return responseJson;
			}
			// 查询找结果为空
			return ReturnJsonUtil.getErrorBackJson("", ErrorCode.DEAL_EX);
		}
		// 查询请求处理
		if ("1".equals(Id5Request.getQueryMode())) {
			// 开始请求DMZ webservice
			Client client = null;
			// 获取配置文件中 webservice配置的url地址
			URL url = null;
			try {
				url = new URL(AppConfig.getInstance().getValue("id5.dmz.webservice.url"));
			} catch (MalformedURLException e) {
				logger.error("[学历] DMZUrl url{} 格式异常:{}", url.toString(), e);
				e.printStackTrace();
			}
			try {
				client = new Client(url);
			} catch (Exception e) {
				logger.error("[学历] 创建请求客户端异常：{}", e);
				e.printStackTrace();
			}

			try {
				Object[] obj = new Object[] { jsonRequest };
				Object[] result = client.invoke("invoke", obj);
				if (result != null) {
					// 解析返回结果
					Id5Response id5Response = ResponseParseUtil.parsingResult(String.valueOf(result[0]));
					id5Response.setCrtUser(Id5Request.getRequestChannel());
					//if(ErrorCode.OK.getCode().equals(id5Response.getResponseCode())){
						int rowChage=id5ResponseService.save(id5Response);
						String responseXml = id5Response.getMessageBody();
						Education education = EducationParseUtil.parseEducationChsi(responseXml);
						education.setCrtUser(Id5Request.getRequestChannel());
						education.setTrnId(id5Response.getTrnId());
						id5ResponseService.saveEduData(education);
						if(rowChage<1){
							logger.error("[学历] 持久化返回结果失败");
						}
					//}
					
					return String.valueOf(result[0]);
				}
			} catch (Exception e) {
				logger.error("[学历] 请求查询异常:{}", e);
				e.printStackTrace();
			} finally {
				if (client != null) {
					client.close();
				}
			}
		}
		return ReturnJsonUtil.getErrorBackJson("test" + Id5Request.getTrnId(), ErrorCode.NO_PASS);
	}
	

}
