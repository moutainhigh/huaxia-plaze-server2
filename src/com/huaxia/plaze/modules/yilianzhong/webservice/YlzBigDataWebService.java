package com.huaxia.plaze.modules.yilianzhong.webservice;

import java.net.MalformedURLException;
import java.net.URL;

import javax.annotation.Resource;
import javax.jws.WebService;

import org.apache.commons.lang3.StringUtils;
import org.codehaus.xfire.client.Client;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.huaxia.opas.util.AppConfig;
import com.huaxia.plaze.modules.MessageWebService;
import com.huaxia.plaze.modules.yilianzhong.domain.YlzMsgResponse;
import com.huaxia.plaze.modules.yilianzhong.domain.YlzRepData;
import com.huaxia.plaze.modules.yilianzhong.domain.YlzTrnRequest;
import com.huaxia.plaze.modules.yilianzhong.service.YlzMsgResponseService;
import com.huaxia.plaze.modules.yilianzhong.service.YlzRepDataService;
import com.huaxia.plaze.modules.yilianzhong.service.YlzTrnRequestService;
import com.huaxia.plaze.modules.yilianzhong.util.ErrorCode;
import com.huaxia.plaze.modules.yilianzhong.util.ReturnJsonUtil;
import com.huaxia.plaze.modules.yilianzhong.util.YlzResponseParseHelper;
import com.huaxia.plaze.modules.yilianzhong.util.YlzTrnRequestHelper;

@Service
@WebService(serviceName = "WST001700", endpointInterface = "com.huaxia.plaze.modules.MessageWebService")
public class YlzBigDataWebService implements MessageWebService {

	private final static Logger logger = LoggerFactory.getLogger(YlzBigDataWebService.class);

	@Resource
	private YlzTrnRequestService ylzTrnRequestService;
	@Resource
	private YlzRepDataService ylzRepDataService;
	@Resource
	private YlzMsgResponseService ylzMsgResponseService;

	private YlzTrnRequest ylzTrnRequest;

	@Override
	public String invoke(String jsonRequest) {
		if (StringUtils.isNotBlank(jsonRequest)) {
			// 解析请求参数
			YlzTrnRequest ylzTrnRequest = YlzTrnRequestHelper.parsingResult(jsonRequest);
			if (ylzTrnRequest == null) {
				logger.debug("[区域数据-厦门-易联众] 关键参数缺失");
				return ReturnJsonUtil.getErrorBackJson(null, ErrorCode.MISS_EL);
			}
			ylzTrnRequest.setCrtUser("PLAZE");
			// 保存请求参数
			int chagerow = ylzTrnRequestService.save(ylzTrnRequest);
			if (chagerow < 1) {
				logger.error("[区域数据-厦门-易联众] 保存请求报文异常，TRN_ID={}", ylzTrnRequest.getTrnId());
				return ReturnJsonUtil.getErrorBackJson(ylzTrnRequest.getTrnId(), ErrorCode.MISS_EL);
			}
			// 处理查找请求
			if ("2".equals(ylzTrnRequest.getQueryMode())) {
				// 查找原始报文
				String repMssage = ylzMsgResponseService.getYlzMsgResponseByParm(ylzTrnRequest.getName(),
						ylzTrnRequest.getCertNo());
				if (StringUtils.isBlank(repMssage)) {
					// 查询找结果为空
					return ReturnJsonUtil.getErrorBackJson(ylzTrnRequest.getTrnId(), ErrorCode.DEAL_EX);
				}
				// 组装返回报文
				String responseJson = YlzResponseParseHelper.getQueryModel2Response(repMssage,
						ylzTrnRequest.getTrnId());
				if (StringUtils.isNotBlank(responseJson)) {
					return responseJson;
				}
				// 查询找结果为空
				return ReturnJsonUtil.getErrorBackJson(ylzTrnRequest.getTrnId(), ErrorCode.DEAL_EX);
			}
			// 查询请求处理
			if ("1".equals(ylzTrnRequest.getQueryMode())) {
				// 开始请求DMZ webservice
				Client client = null;
				// 获取配置文件中 webservice配置的url地址
				URL url = null;
				try {
					url = new URL(AppConfig.getInstance().getValue("area.ylz.dmz.webservice.url"));
				} catch (MalformedURLException e) {
					logger.error("[区域数据-厦门-易联众] DMZUrl url{} 格式异常:{}", url.toString(), e);
					e.printStackTrace();
					return ReturnJsonUtil.getErrorBackJson(ylzTrnRequest.getTrnId(), ErrorCode.DEAL_FAIL);
				}
				try {
					client = new Client(url);
				} catch (Exception e) {
					logger.error("[区域数据-厦门-易联众] 创建请求客户端异常：{}", e);
					e.printStackTrace();
					return ReturnJsonUtil.getErrorBackJson(ylzTrnRequest.getTrnId(), ErrorCode.DEAL_FAIL);
				}
				try {
					Object[] obj = new Object[] { jsonRequest };
					Object[] result = client.invoke("invoke", obj);
					if (result != null) {
						// 检查返回报文
						String resultStr = String.valueOf(result[0]);
						if (StringUtils.isNotBlank(resultStr)) {
							YlzRepData ylzRepData = YlzResponseParseHelper.getQueryModel1Response(resultStr);
							if (ylzRepData == null) {
								logger.error("[区域数据-厦门-易联众] 解析dmz返回报文异常");
								//解析请求报文异常时，也将原始报文响应回去
								return String.valueOf(result[0]);
							}
							ylzRepData.setCrtUser(ylzTrnRequest.getRequestChannel());
							//添加证件号码
							ylzRepData.setCertNo(ylzTrnRequest.getCertNo());
							// 保存解析后的返回报文
							int rwoChage=ylzRepDataService.save(ylzRepData);
							if(rwoChage<1){
								logger.error("[区域数据-厦门-易联众] 保存解析后报文异常，TRN_ID={}", ylzRepData.getTrnId());
							}
							// 保存dmz返回的原始报文
							YlzMsgResponse ylzMsgResponse = new YlzMsgResponse(null, null, ylzTrnRequest.getRequestChannel(),
									ylzRepData.getTrnId(), ylzRepData.getResultJson());
							int cageRow=ylzMsgResponseService.save(ylzMsgResponse);
							if(cageRow<1){
								logger.error("[区域数据-厦门-易联众] 保存解析后报文异常，TRN_ID={}", ylzRepData.getTrnId());
							}
							return String.valueOf(result[0]);
						}
					}
				} catch (Exception e) {
					logger.error("[区域数据-厦门-易联众] 请求查询异常:{}", e.getMessage());
					e.printStackTrace();
					return ReturnJsonUtil.getErrorBackJson(ylzTrnRequest.getTrnId(), ErrorCode.DEAL_FAIL);
				} finally {
					if (client != null) {
						client.close();
					}
				}

			}
		}
		return ReturnJsonUtil.getErrorBackJson(null, ErrorCode.NO_PASS);
	}

}
