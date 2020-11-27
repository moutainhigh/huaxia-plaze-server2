package com.huaxia.plaze.modules.pengyuan.webservice;

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
import com.huaxia.plaze.modules.pengyuan.domain.PyPwslMsgResponse;
import com.huaxia.plaze.modules.pengyuan.domain.PyPwslResponse;
import com.huaxia.plaze.modules.pengyuan.domain.PyPwslTrnRequest;
import com.huaxia.plaze.modules.pengyuan.service.PyPwslResponseService;
import com.huaxia.plaze.modules.pengyuan.service.PyPwslTrnRequestService;
import com.huaxia.plaze.modules.pengyuan.util.ErrorCode;
import com.huaxia.plaze.modules.pengyuan.util.PyPwslResponseHelper;
import com.huaxia.plaze.modules.pengyuan.util.PyPwslTrnRequestHelper;
import com.huaxia.plaze.modules.pengyuan.util.ReturnJsonUtil;

/**
 * 区域数据-深圳-鹏元-个人高信分
 * @author User
 *
 */
@Service
@WebService(serviceName = "WST001602", endpointInterface = "com.huaxia.plaze.modules.MessageWebService")
public class PYPwslWebService implements MessageWebService {

	private final static Logger logger = LoggerFactory.getLogger(PYPwslWebService.class);
	@Resource
	private PyPwslTrnRequestService pyPwslTrnRequestService;
	@Resource
	private PyPwslResponseService pyPwslResponseService;

	public static final String CRT_USER = "PLAZE";

	private PyPwslTrnRequest pyPwslTrnRequest;
	

	@Override
	public String invoke(String jsonRequest) {
		if (StringUtils.isNotBlank(jsonRequest)) {
			// 解析请求报文
			pyPwslTrnRequest = PyPwslTrnRequestHelper.parsingResult(jsonRequest);
			if (pyPwslTrnRequest == null) {
				logger.debug("[区域数据-深圳-鹏元-个人高信分] 关键参数缺失");
				return ReturnJsonUtil.getErrorBackJson(null, ErrorCode.MISS_EL);
			}
			pyPwslTrnRequest.setCrtUser(CRT_USER);
			// 持久化请求报文
			int chageRow = pyPwslTrnRequestService.save(pyPwslTrnRequest);
			if (chageRow < 0) {
				logger.error("[区域数据-深圳-鹏元-个人高信分] 保存请求报文异常，TRN_ID={}", pyPwslTrnRequest.getTrnId());
				return ReturnJsonUtil.getErrorBackJson(pyPwslTrnRequest.getTrnId(), ErrorCode.MISS_EL);
			}
			// 处理请求模式2
			if ("2".equals(pyPwslTrnRequest.getQueryMode())) {
				// 查找原始报文
				String repMssage = pyPwslResponseService.findMsgByRequest(pyPwslTrnRequest.getName(), pyPwslTrnRequest.getCertNo());
				if (StringUtils.isBlank(repMssage)) {
					// 查询找结果为空
					return ReturnJsonUtil.getErrorBackJson(pyPwslTrnRequest.getTrnId(), ErrorCode.DEAL_EX);
				}
				// 组装返回报文
				String responseJson = PyPwslResponseHelper.getQueryModel2Response(repMssage,
						pyPwslTrnRequest.getTrnId());
				if (StringUtils.isNotBlank(responseJson)) {
					return responseJson;
				}
				// 查询找结果为空
				return ReturnJsonUtil.getErrorBackJson(pyPwslTrnRequest.getTrnId(), ErrorCode.DEAL_EX);
			}
			// 处理请求模式1
			if ("1".equals(pyPwslTrnRequest.getQueryMode())) {
				// 开始请求DMZ webservice
				Client client = null;
				// 获取配置文件中 webservice配置的url地址
				URL url = null;
				try {
					url = new URL(AppConfig.getInstance().getValue("area.py.pwsl.dmz.webservice.url"));
				} catch (MalformedURLException e) {
					logger.error("[区域数据-深圳-鹏元-个人高信分] DMZUrl url{} 格式异常:{}", url.toString(), e);
					e.printStackTrace();
					return ReturnJsonUtil.getErrorBackJson(pyPwslTrnRequest.getTrnId(), ErrorCode.DEAL_FAIL);
				}
				try {
					client = new Client(url);
				} catch (Exception e) {
					logger.error("[区域数据-深圳-鹏元-个人高信分] 创建请求客户端异常：{}", e);
					e.printStackTrace();
					return ReturnJsonUtil.getErrorBackJson(pyPwslTrnRequest.getTrnId(), ErrorCode.DEAL_FAIL);
				}
				try {
					Object[] obj = new Object[] { jsonRequest };
					Object[] result = client.invoke("invoke", obj);
					if (result != null) {
						// 检查返回报文
						String resultStr = String.valueOf(result[0]);
						if (StringUtils.isNotBlank(resultStr)) {
							PyPwslResponse pyPwslResponse=PyPwslResponseHelper.getQueryModel1Response(resultStr,null,pyPwslTrnRequest.getRequestChannel());
							if (!PyPwslResponseHelper.checkResponse(pyPwslResponse)) {
								logger.error("[区域数据-深圳-鹏元-个人高信分] 解析dmz返回报文异常");
								//解析请求报文异常时，也将原始报文响应回去
								return String.valueOf(result[0]);
							}
							// 保存解析后的返回报文
							int rwoChage=pyPwslResponseService.savePyPwslResponse(pyPwslResponse);
							if(rwoChage<1){
								logger.error("[区域数据-深圳-鹏元-个人高信分] 保存解析后报文异常，TRN_ID={}", pyPwslResponse.getPyPwslCrs().getTrnId());
							}
							// 保存dmz返回的原始报文
							PyPwslMsgResponse PyPwslMsgResponse=new PyPwslMsgResponse(null,null,pyPwslTrnRequest.getRequestChannel(),pyPwslResponse.getPyPwslCrs().getTrnId(),pyPwslResponse.getResultJson());
							int cageRow=pyPwslResponseService.save(PyPwslMsgResponse);
							if(cageRow<1){
								logger.error("[区域数据-深圳-鹏元-个人高信分] 保存原始报文异常，TRN_ID={}", pyPwslResponse.getPyPwslCrs().getTrnId());
							}
							return resultStr;
						}
					}
				} catch (Exception e) {
					logger.error("[区域数据-深圳-鹏元-个人高信分] 请求查询异常:{}", e.getMessage());
					e.printStackTrace();
					return ReturnJsonUtil.getErrorBackJson(pyPwslTrnRequest.getTrnId(), ErrorCode.DEAL_FAIL);
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
