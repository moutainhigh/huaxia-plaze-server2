package com.huaxia.plaze.datasource.service;

import java.util.Map;

/**
 * 公共数据源查询数量服务
 * 
 * @author zhiguo.li
 *
 */
public interface DataSourceCountService {

	/**
	 * 数据源查询数量限制校验
	 * 
	 * @param args
	 * 
	 *            <pre>
	 * [ 输入 ]
	 * 
	 * source_code_num - 数据源代码
	 * channel_code_num - 渠道代码
	 * 
	 * [ 输出 ]
	 * 
	 * end_num
	 *            </pre>
	 */
	void callDataSource(Map<String, Object> args);

}
