package com.huaxia.plaze.datasource.interfaces;

import java.util.Map;

/**
 * 数据源回调处理接口
 * 
 * @author zhiguo.li
 *
 */
public interface DataSourceInvoker {
	
	/** 数据源校验结果 */
	public final static String VALIDATE_RESULT = "end_num";

	/**
	 * 数据源处理方法
	 * 
	 * @param args
	 *            请求报文参数
	 * 
	 *            <pre>
	 *            [ source_code_num  ] 数据源编号
	 *            [ channel_code_num ] 渠道编号
	 *            </pre>
	 * 
	 * @return 校验类型
	 * 
	 *            <pre>
	 *            [  1 ] 通过:数据源请求放行
	 *            [  0 ] 忽略:查询数量达到设定阈值, 数据源请求忽略, 即当前查询不允许发起.
	 *            [ -1 ] 拒绝:查询数量超过设定阈值, 数据源请求拒绝.
	 *            </pre>
	 */
	Object validate(Map<String, Object> args);

}
