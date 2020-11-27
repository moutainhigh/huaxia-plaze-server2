package com.huaxia.plaze.modules.pboc.dispatcher;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.huaxia.plaze.modules.pboc.caller.BankTaskCaller;
import com.huaxia.plaze.modules.pboc.thread.BankBackThread;
import com.huaxia.plaze.modules.pboc.thread.BankSaveThread;

/**
 * 任务分发器
 * 
 * @author gaoh
 * @author zhiguo.li 2019-03-27 人行数据源单独异步单独处理
 *
 */
public class PbocTaskDispatcher extends HttpServlet {

	private static final long serialVersionUID = 5849340742045338536L;

	@Override
	public void init() throws ServletException {
		ApplicationContext context = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
		Map<String, Object> services = new HashMap<String, Object>();
		services.put("bankService", context.getBean("bankService"));
		services.put("bankTaskCallPlazeService", context.getBean("bankTaskCallPlazeService"));
		
		ThreadLocal<Map<String, Object>> wrapper = new ThreadLocal<Map<String, Object>>();
		wrapper.set(services);
		
		// 启动人行请求线程
		startTaskHandler(wrapper);
		// 启动人行返回给请求端数据线程
		startBankBackThread(wrapper);
		// 启动人行解析入库到三方平台线程
		startBankSaveThread(wrapper);
	}

	/**
	 * @Title:startTaskHandler
	 * @Description:人行请求线程启动
	 * @author: gaohui
	 * @Date:2019年2月1日下午2:33:03
	 */
	private void startTaskHandler(ThreadLocal<Map<String, Object>> wrapper) {
		Thread defaultTaskHandler = new Thread(new BankTaskCaller(wrapper));
		defaultTaskHandler.setDaemon(true);
		defaultTaskHandler.start();
	}

	/**
	 * @Title:startBankBackThread
	 * @Description:人行返回给请求端数据的线程启动
	 * @author: gaohui
	 * @Date:2019年1月31日上午9:23:45
	 */
	private void startBankBackThread(ThreadLocal<Map<String, Object>> wrapper) {
		Thread defaultTaskHandler = new Thread(new BankBackThread(wrapper));
		defaultTaskHandler.setDaemon(true);
		defaultTaskHandler.start();
	}

	/**
	 * @Title:startBankSaveThread
	 * @Description:人行解析入库到三方平台线程启动
	 * @author: gaohui
	 * @Date:2019年2月1日下午2:33:48
	 */
	private void startBankSaveThread(ThreadLocal<Map<String, Object>> wrapper) {
		Thread defaultTaskHandler = new Thread(new BankSaveThread(wrapper));
		defaultTaskHandler.setDaemon(true);
		defaultTaskHandler.start();
	}

}
