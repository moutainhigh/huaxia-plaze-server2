package com.huaxia.plaze.modules.bairong.thread;

import java.util.ArrayList;
import java.util.List;

import com.huaxia.opas.util.AppConfig;
import com.huaxia.plaze.common.thread.TaskThread;
import com.huaxia.plaze.util.WebServiceUtil;

/**
 * 百融多头借贷批量任务处理线程
 * 
 * @author zhiguo.li
 * @version 1.0.0
 *
 */
public class ApplyLoanStrTaskThread extends TaskThread {

	private static final String WS_URL;

	private static int WS_CONNECT_TIMEOUT;

	private static String WS_HTTP_TIMEOUT;

	static {
		AppConfig appConfig = AppConfig.getInstance();
		WS_URL = appConfig.getValue("bairong.dtjd.dmz.webservice.url");
		WS_CONNECT_TIMEOUT = Integer.parseInt(appConfig.getValue("bairong.dtjd.dmz.webservice.connection_timeout"));
		WS_HTTP_TIMEOUT = appConfig.getValue("bairong.dtjd.dmz.webservice.http_timeout");
	}

	@Override
	public List<String> call() throws Exception {
		List<String> messages = new ArrayList<String>();

		List<String> taskList = getTaskList();
		if (taskList == null || taskList.size() == 0) {
			return messages;
		}

		for (String task : taskList) {
			try {
				Object[] response = WebServiceUtil.call(WS_URL, "invoke", new Object[] { task }, WS_CONNECT_TIMEOUT,
						WS_HTTP_TIMEOUT);
				String message = String.valueOf(response[0]);
				logger.debug("百融数据源响应报文[ {} ]", message);
				messages.add(message);
			} catch (Exception e) {
				logger.error("百融数据源调用异常 [ {} ]", e.getMessage(), e);
			}
		}

		// 计数锁减1
		getTaskLatch().countDown();

		logger.info("任务线程 [ {} ] 处理完成! 处理条数 [ {} ]", new Object[] { getTaskName(), taskList.size() });

		return messages;
	}

	@Override
	public TaskThread getTaskThread() {
		return new ApplyLoanStrTaskThread();
	}

}
