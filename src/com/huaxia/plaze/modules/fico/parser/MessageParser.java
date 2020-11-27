package com.huaxia.plaze.modules.fico.parser;

/**
 * 报文解析器
 * 
 * @author zhiguo.li
 *
 */
public interface MessageParser<T> {

	/**
	 * 报文解析处理
	 * 
	 * @param message
	 *            报文
	 * @return 指定类型对象
	 * @throws Exception
	 */
	T parse(String message) throws Exception;

}
