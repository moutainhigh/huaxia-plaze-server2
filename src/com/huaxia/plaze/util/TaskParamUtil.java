package com.huaxia.plaze.util;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.huaxia.opas.util.AppConfig;

/**
 * 三方任务 参数配置
 * 
 * @author gaoh
 * @author zhiguo.li, 2019-09-04, 删除简项公安配置项, 由异步调用修改为同步调用.
 *
 */
public class TaskParamUtil {

	private final static Logger logger = LoggerFactory.getLogger(TaskParamUtil.class);
	public final static String CURR_USER = "HX";// 系统默认用户名
	public final static String USER_COPY = "HXC";// 系统30逻辑用户名
	public final static String TASK_IP;// 当前服务器ip地址

	// 人行参数配置=============================
	public final static String BANK_XML_PATH;// 报文存储路径
	public final static String BANK_NOTSEARCH_TIME_START;// 人行不查询时间 开始
	public final static String BANK_NOTSEARCH_TIME_END;// 人行不查询时间 结束
	public final static String BANK_SEARCH_DAYS_CONTROL;// 人行查询天数控制
	public final static Integer BANK_THREAD_SLEEPTIME_MM;// 人行查询无数据时间隔时间
	public final static Integer BANK_SINGLE_SLEEPTIME_MM;// 人行查询单笔发起间隔时间
	public final static Integer BANK_MULTIPLE_SLEEPTIME_MM;// 人行有数据时查库 间隔时间
	public final static Integer BANK_QUERY_SIZE;// 每次查询任务数
	public final static String BANK_HTTP_URL;// 获取人行接口URL

	// 人行返回报文 参数配置
	public final static String BANK_BACK_QUERY_SIZE;// 人行返回报文 每次查询任务数
	public final static Integer BANK_BACK_THREAD_SLEEPTIME_MM;// 人行查询无数据时间隔时间
	public final static Integer BANK_BACK_SINGLE_SLEEPTIME_MM;// 人行查询单笔发起间隔时间
	public final static Integer BANK_BACK_MULTIPLE_SLEEPTIME_MM;// 人行有数据时查库 间隔时间
	public final static String BANK_BACK_XINSHEN_URL;// 人行返回报文信审的URL
	public final static String BANK_BACK_XINSHEN_METHOD;// 人行返回报文信审的method
	public final static Integer BANK_BACK_XINSHEN_TIME_OUT;// 人行返回报文信审的连接超时时间

	// 人行解析入库报文 参数配置
	public final static String BANK_PARSER_QUERY_SIZE;// 人行解析入库报文 每次查询任务数
	public final static Integer BANK_PARSER_THREAD_SLEEPTIME_MM;// 人行解析入库报文查询无数据时间隔时间
	public final static Integer BANK_PARSER_MULTIPLE_SLEEPTIME_MM;// 人行解析入库报文有数据时查库
																	// 间隔时间
	// 人行超过控制天数的报文到历史表 参数配置
	public final static Integer BANK_BODY_HIS_CONTROL_DAY;// 人行 每次将原报文插入历史表的
															// 天数控制
	public final static Integer BANK_BODY_HIS_QUERY_NUM;// 人行 每次将原报文插入历史表的 条数 控制

	static {
		Enumeration<NetworkInterface> nis;
		String ip = null;
		try {
			nis = NetworkInterface.getNetworkInterfaces();
			for (; nis.hasMoreElements();) {
				NetworkInterface ni = nis.nextElement();
				Enumeration<InetAddress> ias = ni.getInetAddresses();
				for (; ias.hasMoreElements();) {
					InetAddress ia = ias.nextElement();
					if (ia instanceof Inet4Address && !ia.getHostAddress().equals("127.0.0.1")) {
						ip = ia.getHostAddress();
					}
				}
			}
		} catch (Exception e) {
			if (logger.isInfoEnabled()) {
				logger.info("TaskParamUtilException:{}", e);
			}
		}
		TASK_IP = ip;

		AppConfig appConfig = AppConfig.getInstance();
		
		// 人行参数配置
		BANK_XML_PATH = appConfig.getValue("BANK_XML_PATH");
		BANK_NOTSEARCH_TIME_START = appConfig.getValue("BANK_NOTSEARCH_TIME_START");
		BANK_NOTSEARCH_TIME_END = appConfig.getValue("BANK_NOTSEARCH_TIME_END");
		BANK_SEARCH_DAYS_CONTROL = appConfig.getValue("BANK_SEARCH_DAYS_CONTROL");
		BANK_THREAD_SLEEPTIME_MM = Integer.valueOf(appConfig.getValue("BANK_THREAD_SLEEPTIME_MM"));
		BANK_SINGLE_SLEEPTIME_MM = Integer.valueOf(appConfig.getValue("BANK_SINGLE_SLEEPTIME_MM"));
		BANK_MULTIPLE_SLEEPTIME_MM = Integer.valueOf(appConfig.getValue("BANK_MULTIPLE_SLEEPTIME_MM"));
		BANK_QUERY_SIZE = Integer.valueOf(appConfig.getValue("BANK_QUERY_SIZE"));
		BANK_HTTP_URL = appConfig.getValue("BANK_HTTP_URL");
		
		// 人行返回报文 参数配置
		BANK_BACK_QUERY_SIZE = appConfig.getValue("BANK_BACK_QUERY_SIZE");
		BANK_BACK_THREAD_SLEEPTIME_MM = Integer.valueOf(appConfig.getValue("BANK_BACK_THREAD_SLEEPTIME_MM"));
		BANK_BACK_SINGLE_SLEEPTIME_MM = Integer.valueOf(appConfig.getValue("BANK_BACK_SINGLE_SLEEPTIME_MM"));
		BANK_BACK_MULTIPLE_SLEEPTIME_MM = Integer.valueOf(appConfig.getValue("BANK_BACK_MULTIPLE_SLEEPTIME_MM"));
		BANK_BACK_XINSHEN_URL = appConfig.getValue("BANK_BACK_XINSHEN_URL");
		BANK_BACK_XINSHEN_METHOD = appConfig.getValue("BANK_BACK_XINSHEN_METHOD");
		BANK_BACK_XINSHEN_TIME_OUT = Integer.valueOf(appConfig.getValue("BANK_BACK_XINSHEN_TIME_OUT"));
		
		// 人行解析入库报文 参数配置
		BANK_PARSER_QUERY_SIZE = appConfig.getValue("BANK_PARSER_QUERY_SIZE");
		BANK_PARSER_THREAD_SLEEPTIME_MM = Integer.valueOf(appConfig.getValue("BANK_PARSER_THREAD_SLEEPTIME_MM"));
		BANK_PARSER_MULTIPLE_SLEEPTIME_MM = Integer.valueOf(appConfig.getValue("BANK_PARSER_MULTIPLE_SLEEPTIME_MM"));
		
		// 人行超过控制天数的报文到历史表 参数配置
		BANK_BODY_HIS_CONTROL_DAY = Integer.valueOf(appConfig.getValue("BANK_BODY_HIS_CONTROL_DAY"));
		BANK_BODY_HIS_QUERY_NUM = Integer.valueOf(appConfig.getValue("BANK_BODY_HIS_QUERY_NUM"));
	}

}
