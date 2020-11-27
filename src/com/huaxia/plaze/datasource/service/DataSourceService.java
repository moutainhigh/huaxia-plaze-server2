package com.huaxia.plaze.datasource.service;

import java.util.Map;

/**
 * 数据源查询配置接口
 * 
 * @author zhiguo.li
 *
 */
public interface DataSourceService {

	/**
	 * 获取数据源查询配置信息
	 * 
	 * @param dataSource
	 *            数据源（编号）
	 * @param channel
	 *            请求渠道（编号）
	 * @return 数据源查询配置信息
	 * @see 查询数量限制配置表
	 */
	Map<String, Object> getConfigurationByParams(String dataSource, String channel);

	/**
	 * 根据渠道名称获取对应渠道编号
	 * 
	 * @param channelName
	 *            渠道名称
	 * @return 渠道代码
	 */
	String getChannelCodeByName(String channelName);

}
