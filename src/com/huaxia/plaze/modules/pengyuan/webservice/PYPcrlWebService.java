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
import com.huaxia.plaze.modules.pengyuan.domain.PyCrsResponse;
import com.huaxia.plaze.modules.pengyuan.domain.PyPcrTenReponse;
import com.huaxia.plaze.modules.pengyuan.domain.PyPcrTenRequest;
import com.huaxia.plaze.modules.pengyuan.service.PyCrsResponseService;
import com.huaxia.plaze.modules.pengyuan.service.PyPcrTenReponseService;
import com.huaxia.plaze.modules.pengyuan.service.PyPcrTenRequestService;
import com.huaxia.plaze.modules.pengyuan.util.ErrorCode;
import com.huaxia.plaze.modules.pengyuan.util.PyPwslResponseHelper;
import com.huaxia.plaze.modules.pengyuan.util.ReturnJsonUtil;
import com.huaxia.plaze.modules.pengyuan.util.pcr.PyPcrResponseHelper;
import com.huaxia.plaze.modules.pengyuan.util.pcr.PyPcrTrnRequestHelper;

@Service
@WebService(serviceName = "WST001601", endpointInterface = "com.huaxia.plaze.modules.MessageWebService")
public class PYPcrlWebService implements MessageWebService {

	private final static Logger logger = LoggerFactory.getLogger(PYPcrlWebService.class);

	@Resource
	private PyPcrTenRequestService pyPcrTenRequestService;

	@Resource
	private PyPcrTenReponseService pyPcrTenReponseService;

	@Resource
	private PyCrsResponseService pyCrsResponseService;

	public static final String CRT_USER = "PLAZE";

	@Override
	public String invoke(String jsonRequest) {
		if (StringUtils.isNotBlank(jsonRequest)) {
			// 解析请求报文
			PyPcrTenRequest pyPcrTenRequest = PyPcrTrnRequestHelper.parsingResult(jsonRequest);
			if (pyPcrTenRequest == null) {
				logger.debug("[区域数据-深圳-鹏元-鹏元个人信用] 关键参数缺失");
				return ReturnJsonUtil.getErrorBackJson(null, ErrorCode.MISS_EL);
			}

			pyPcrTenRequest.setCrtUser(CRT_USER);
			// 持久化请求报文
			int chageRow = pyPcrTenRequestService.savePyPcrTenRequest(pyPcrTenRequest);
			if (chageRow < 0) {
				logger.error("[区域数据-深圳-鹏元-鹏元个人信用] 保存请求报文异常，TRN_ID={}", pyPcrTenRequest.getTrnId());
				return ReturnJsonUtil.getErrorBackJson(pyPcrTenRequest.getTrnId(), ErrorCode.MISS_EL);
			}

			// 处理请求模式2
			if ("2".equals(pyPcrTenRequest.getQueryMode())) {
				// 查找原始报文
				String repMssage =pyCrsResponseService.findPyCrsResponseByConditions(pyPcrTenRequest);
				if (StringUtils.isBlank(repMssage)) {
					// 查询找结果为空
					logger.error("[区域数据-深圳-鹏元-个人信用] 根据请求查询结果为空");
					return ReturnJsonUtil.getErrorBackJson(pyPcrTenRequest.getTrnId(), ErrorCode.DEAL_EX);
				}
				// 组装返回报文
				String responseJson = PyPwslResponseHelper.getQueryModel2Response(repMssage,
						pyPcrTenRequest.getTrnId());
				if (StringUtils.isNotBlank(responseJson)) {
					return responseJson;
				}
				// 查询找结果为空
				logger.error("[区域数据-深圳-鹏元-个人信用] 根据请求查询结果组装返回报文为空");
				return ReturnJsonUtil.getErrorBackJson(pyPcrTenRequest.getTrnId(), ErrorCode.DEAL_EX);
			}
			// 处理请求模式1
			if ("1".equals(pyPcrTenRequest.getQueryMode())) {
				// 开始请求DMZ webservice
				Client client = null;
				// 获取配置文件中 webservice配置的url地址
				URL url = null;
				try {
					url = new URL(AppConfig.getInstance().getValue("area.py.pcr.dmz.webservice.url"));
				} catch (MalformedURLException e) {
					logger.error("[区域数据-深圳-鹏元-个人信用] DMZUrl url{} 格式异常:{}", url.toString(), e);
					e.printStackTrace();
					return ReturnJsonUtil.getErrorBackJson(pyPcrTenRequest.getTrnId(), ErrorCode.DEAL_FAIL);
				}
				try {
					client = new Client(url);
				} catch (Exception e) {
					logger.error("[区域数据-深圳-鹏元-个人信用] 创建请求客户端异常：{}", e);
					e.printStackTrace();
					return ReturnJsonUtil.getErrorBackJson(pyPcrTenRequest.getTrnId(), ErrorCode.DEAL_FAIL);
				}
				try {
					Object[] obj = new Object[] { jsonRequest };
					Object[] result = client.invoke("invoke", obj);
					if (result != null) {
						// 检查返回报文
						String resultStr = String.valueOf(result[0]);
						if (StringUtils.isNotBlank(resultStr)) {
							// 解析返回报文
							PyPcrTenReponse pyPcrTenReponse = PyPcrResponseHelper.getQueryModel1Response(resultStr,null,pyPcrTenRequest.getRequestChannel());
							if (!PyPcrResponseHelper.checkResponse(pyPcrTenReponse)) {
								logger.error("[区域数据-深圳-鹏元-个人信用] 解析dmz返回报文异常");
								//解析请求报文异常时，也将原始报文响应回去
								return String.valueOf(result[0]);
							}
							// 保存解析后的返回报文
							int rwoChage = pyPcrTenReponseService.savePyPcrTenReponse(pyPcrTenReponse);
							if (rwoChage < 1) {
								logger.error("[区域数据-深圳-鹏元-个人高信分] 保存解析后报文异常，TRN_ID={}",
										pyPcrTenReponse.getPyPcrCrs().getTrnId());
							}
							// 保存dmz返回的原始报文
							PyCrsResponse pyCrsResponse = new PyCrsResponse(pyPcrTenRequest.getRequestChannel(),
									pyPcrTenReponse.getPyPcrCrs().getTrnId(),pyPcrTenReponse.getResultJson());
							int chageRowNu = pyCrsResponseService.savePyCrsResponse(pyCrsResponse);
							if (chageRowNu < 1) {
								logger.error("[区域数据-深圳-鹏元-个人高信分] 保存原始报文异常，TRN_ID={}",
										pyPcrTenReponse.getPyPcrCrs().getTrnId());
							}
							return String.valueOf(result[0]);
						}
					}
				} catch (Exception e) {
					logger.error("[区域数据-深圳-鹏元-个人信用] 请求查询异常:{}", e.getMessage());
					e.printStackTrace();
					return ReturnJsonUtil.getErrorBackJson(pyPcrTenRequest.getTrnId(), ErrorCode.DEAL_FAIL);
				} finally {
					if (client != null) {
						client.close();
					}
				}
			}

		}
		logger.error("[区域数据-深圳-鹏元个人信用] 传入参数为空{}", jsonRequest);
		return ReturnJsonUtil.getErrorBackJson(null, ErrorCode.NO_PASS);
	}

}
