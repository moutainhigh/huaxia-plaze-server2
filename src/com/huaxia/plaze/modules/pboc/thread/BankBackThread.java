package com.huaxia.plaze.modules.pboc.thread;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.codehaus.xfire.client.Client;
import org.codehaus.xfire.transport.http.CommonsHttpMessageSender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.huaxia.plaze.modules.pboc.service.BankService;
import com.huaxia.plaze.modules.pboc.service.BankTaskCallPlazeService;
import com.huaxia.plaze.util.TaskParamUtil;
import com.huaxia.plaze.util.TaskStatusUtil;

import net.sf.json.JSONObject;

/**
 * 给第三方系统返回报文
 * 
 * @author gaoh
 *
 */
public class BankBackThread implements Runnable {
	
	private final static Logger logger = LoggerFactory.getLogger(BankBackThread.class);
	
	private BankTaskCallPlazeService bankTaskCallPlazeService;
	
	private BankService bankService;

	public BankBackThread(ThreadLocal<Map<String, Object>> wrapper) {
		Map<String, Object> services = wrapper.get();
		this.bankService = (BankService) services.get("bankService");
		this.bankTaskCallPlazeService = (BankTaskCallPlazeService) services.get("bankTaskCallPlazeService");
	}

	@Override
	public void run() {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("taskIp", TaskParamUtil.TASK_IP);
		paramMap.put("querySize", TaskParamUtil.BANK_BACK_QUERY_SIZE);
		while (true) {
			boolean reStartBankFlag = false;// 线程重启标志(报错时线程不会中断)
			sleepThread(TaskParamUtil.BANK_BACK_MULTIPLE_SLEEPTIME_MM);
			List<Map<String, String>> taskList = null;
			try {
				taskList = bankTaskCallPlazeService.findBankBackTaskPlazeList(paramMap);
			} catch (Exception e) {
				if (logger.isErrorEnabled()) {
					logger.error("bankBackThreadError: Exception:{}", e);
				}
				reStartBankFlag = true;
			}
			if (taskList != null && taskList.size() > 0) {
				for (Map<String, String> task : taskList) {
					String taskStatus = task.get("TASK_STATUS");
					// String code = taskStatus;//将查询结果成功失败标识 赋值给 code 返给查询方
					String source = task.get("SOURCE");
					String uniqueRelid = task.get("UNIQUE_RELID");// 三方平台入库的关联id
					String sourceId = task.get("SOURCE_ID");// 数据源发来的关联id
					String idNo = task.get("IDENTITY_NO");// 当前请求被查询人证件号
					String identityType = task.get("IDENTITY_TYPE");// 当前请求被查询人证件号类型
					String name = task.get("NAME");// 当前请求被查询人姓名
					String bankBackUrl = "";
					String sourceMethod = "";
					Integer timeOut = 10000;// 默认10秒
					if ("1".equals(source)) {// 信审
						bankBackUrl = TaskParamUtil.BANK_BACK_XINSHEN_URL;
						sourceMethod = TaskParamUtil.BANK_BACK_XINSHEN_METHOD;
						timeOut = TaskParamUtil.BANK_BACK_XINSHEN_TIME_OUT;
						String jsonBody = "";
						JSONObject jsonObject = new JSONObject();
						JSONObject responseObject = new JSONObject();
						JSONObject responseHeadObject = new JSONObject();
						responseHeadObject.put("RESPONSE_SYSTEM", "PLAZE");
						responseHeadObject.put("TRN_ID", sourceId);
						responseObject.put("HEAD", responseHeadObject);
						JSONObject responseBodyObject = new JSONObject();
						try {
							// 记录任务表历史信息
							bankTaskCallPlazeService.saveBankTaskPlazeHis(uniqueRelid);
						} catch (Exception e) {
							if (logger.isErrorEnabled()) {
								logger.error("bankBackThreadError:" + uniqueRelid + " Exception:{}", e);
							}
							reStartBankFlag = true;
						}
						if ("2".equals(taskStatus)) {// 成功
							Map<String, String> paramBody = new HashMap<String, String>();
							paramBody.put("identityCardNo", idNo);
							paramBody.put("identityType", identityType);
							paramBody.put("name", name);
							String body = "";
							try {
								body = bankService.findBankMessage(paramBody);
								if(body == null || "".equals(body)){
									body = "AAA001";
								}
							} catch (Exception e) {
								if (logger.isErrorEnabled()) {
									logger.error("bankBackThreadError:" + uniqueRelid + " Exception:{}", e);
								}
								reStartBankFlag = true;
							}
							if (reStartBankFlag) {// 查询报错跳出本次循环
								continue;
							}
							responseBodyObject.put("RESPONSE_CODE", "000000");
							responseBodyObject.put("RESPONSE_DESC", "处理成功");
							responseBodyObject.put("RESPONSE_BODY", body);
						}
						
						responseObject.put("BODY", responseBodyObject);
						jsonObject.put("RESPONSE", responseObject);
						jsonBody = jsonObject.toString();
						// 是否请求接口失败 默认false
						boolean callErrorFlag = backMessageToSource(bankBackUrl, timeOut, jsonBody, sourceMethod,
								uniqueRelid);

						try {
							if (!callErrorFlag) {// 调用对方接口成功
								bankTaskCallPlazeService.deleteBankTaskPlaze(uniqueRelid, taskStatus);
							} else {// 调用对方接口失败
								bankTaskCallPlazeService.updateBankTaskPlaze(uniqueRelid,
										TaskStatusUtil.CALL_QUERY_ERROE, taskStatus, TaskParamUtil.CURR_USER, null,
										null);
							}
						} catch (Exception e) {
							if (logger.isErrorEnabled()) {
								logger.error("bankBackThreadError:" + uniqueRelid + " Exception:{}", e);
							}
							reStartBankFlag = true;
						}

						// 单笔延迟时间
						sleepThread(TaskParamUtil.BANK_BACK_SINGLE_SLEEPTIME_MM);
						continue;
					}
					if ("0".equals(source)) {// 人工
						if ("2".equals(taskStatus)) {// 成功
							try {
								bankTaskCallPlazeService.deleteBankTaskPlaze(uniqueRelid, taskStatus);
							} catch (Exception e) {
								if (logger.isErrorEnabled()) {
									logger.error("bankBackThreadError:" + uniqueRelid + " Exception:{}", e);
								}
								reStartBankFlag = true;
							}
						} else {

						}
						continue;
					}
				}
				// 循环结束
			} else {// 没数据时加大延迟时间

				sleepThread(TaskParamUtil.BANK_BACK_THREAD_SLEEPTIME_MM);

			}

			//
			if (reStartBankFlag) {
				if (logger.isErrorEnabled()) {
					logger.error("bankBackThreadError: Exception:{}", "bankBackThread Restart!! 请查看报错原因!!");
				}
				sleepThread(8000);
			}

		}

	}

	/**
	 * @Title:backMessageToSource
	 * @Description:将报文返回给请求端
	 * @param sourceUrl
	 *            请求端地址
	 * @param timeOut
	 *            最大连接超时时间
	 * @param jsonBody
	 *            报文
	 * @param sourceMethod
	 *            请求端方法
	 * @param uniqueRelid
	 *            关联id
	 * @author: gaohui
	 * @Date:2019年1月5日下午1:13:08
	 */
	private boolean backMessageToSource(String sourceUrl, Integer timeOut, String jsonBody, String sourceMethod,
			String uniqueRelid) {
		boolean callErrorFlag = false;// 是否请求接口失败
		Client client = null;
		try {
			URL url = new URL(sourceUrl);
			HttpURLConnection httpConnection = (HttpURLConnection) url.openConnection();
			httpConnection.setReadTimeout(timeOut);// 设置http连接的读超时，单位是毫秒
			httpConnection.connect();
			client = new Client(httpConnection.getInputStream(), null);
			// 设置发送超时限制，单位是毫秒
			client.setProperty(CommonsHttpMessageSender.HTTP_TIMEOUT, String.valueOf(timeOut));
			client.setProperty(CommonsHttpMessageSender.DISABLE_KEEP_ALIVE, "true");
			client.setProperty(CommonsHttpMessageSender.DISABLE_EXPECT_CONTINUE, "true");
			Object[] params = new Object[] { jsonBody };
			client.invoke(sourceMethod, params);
		} catch (Exception e) {// 回调对方接口失败
			callErrorFlag = true;
			if (logger.isErrorEnabled()) {
				logger.error("bankBackThreadClientError:" + uniqueRelid + " Exception:{}", e);
			}
		} finally {
			// 清除缓存数据
			if (client != null) {
				client.close();
				client = null;
			}
		}
		return callErrorFlag;
	}

	/**
	 * @Title:sleepThread
	 * @Description:使线程停顿一段时间
	 * @param time
	 *            停顿时间（毫秒）
	 * @author: gaohui
	 * @Date:2019年1月8日下午2:03:57
	 */
	private void sleepThread(Integer time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			if (logger.isInfoEnabled()) {
				logger.info("threadSleepBank:Exception：{}", e);
			}
		}
	}

}
