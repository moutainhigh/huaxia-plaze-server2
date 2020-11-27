package com.huaxia.plaze.util;

import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;

import org.apache.commons.lang3.StringUtils;
import org.codehaus.xfire.client.Client;
import org.codehaus.xfire.transport.http.CommonsHttpMessageSender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * WebService 公共调用类
 * 
 * @author zhiguo.li
 *
 */
public class WebServiceUtil {

	private final static Logger logger = LoggerFactory.getLogger(WebServiceUtil.class);

	/**
	 * WebService 请求调用
	 * 
	 * @param url
	 *            请求地址
	 * @param args
	 *            请求参数
	 * @return 请求响应结果
	 * @throws Exception
	 *             请求参数 {@code url} 或 {@code method} 为空时，抛出
	 *             <strong>请求参数缺失</strong>异常。
	 */
	public static Object[] call(String url, Object[] args) throws SocketTimeoutException, Exception {
		return call(url, "invoke", args);
	}

	/**
	 * WebService 请求调用
	 * 
	 * @param url
	 *            请求地址
	 * @param method
	 *            请求方法
	 * @param args
	 *            请求参数
	 * @return 请求响应结果
	 * @throws Exception
	 *             请求参数 {@code url} 或 {@code method} 为空时，抛出
	 *             <strong>请求参数缺失</strong>异常。
	 */
	public static Object[] call(String url, String method, Object[] args) throws SocketTimeoutException, Exception {
		return call(url, method, args, 3000, "10000");
	}

	/**
	 * WebService 请求调用
	 * 
	 * @param url
	 *            请求地址
	 * @param method
	 *            请求方法
	 * @param args
	 *            请求参数
	 * @param connectionTimeout
	 *            连接超时时间
	 * @param httpTimeout
	 *            处理超时时间
	 * @return 请求响应结果
	 * @throws Exception
	 *             请求参数 {@code url} 或 {@code method} 为空时，抛出
	 *             <strong>请求参数缺失</strong>异常。
	 */
	public static Object[] call(String url, String method, Object[] args, int connectionTimeout, String httpTimeout)
			throws SocketTimeoutException, Exception {
		if (StringUtils.isBlank(url) || StringUtils.isBlank(method)) {
			throw new Exception("请求参数缺失");
		}

		Object[] response = new Object[0];
		Client client = null;
		try {
			HttpURLConnection httpConnection = (HttpURLConnection) new URL(url).openConnection();

			// 设置HTTP连接超时时间（单位是毫秒）
			if (StringUtils.isBlank(String.valueOf(connectionTimeout))) {
				httpConnection.setConnectTimeout(3000);
			} else {
				httpConnection.setConnectTimeout(connectionTimeout);
			}

			httpConnection.connect();
			client = new Client(httpConnection.getInputStream(), null);

			// 设置发送的超时限制（单位是毫秒）
			if (StringUtils.isBlank(httpTimeout)) {
				client.setProperty(CommonsHttpMessageSender.HTTP_TIMEOUT, "30000");
			} else {
				client.setProperty(CommonsHttpMessageSender.HTTP_TIMEOUT, httpTimeout);
			}

			client.setProperty(CommonsHttpMessageSender.DISABLE_KEEP_ALIVE, "true");
			client.setProperty(CommonsHttpMessageSender.DISABLE_EXPECT_CONTINUE, "true");
			response = client.invoke(method, args);
		} catch (SocketTimeoutException e) {
			logger.error("连接或读取超时 [ {} ]", new Object[] { e.getMessage() }, e);
			throw e;
		} catch (Exception e) {
			logger.error("请求调用处理异常 [ {} ]", new Object[] { e.getMessage() }, e);
			throw e;
		} finally {
			if (client != null) {
				client.close();
			}
		}
		return response;
	}

}
