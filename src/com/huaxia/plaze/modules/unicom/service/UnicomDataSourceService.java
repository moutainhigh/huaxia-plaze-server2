package com.huaxia.plaze.modules.unicom.service;

import java.util.Map;

import com.huaxia.plaze.datasource.service.DataSourceCountService;

/**
 * 联通运营商数据源服务接口
 * 
 * @author zhiguo.li
 * @version 1.0.0
 *
 */
public interface UnicomDataSourceService extends DataSourceCountService {

	/** 手机实名认证 */
	public final static String DATASOURCE_001100 = "001100";

	/** 在网时长 */
	public final static String DATASOURCE_001101 = "001101";
	
	/** 联通地址类信息 (工作地址)*/
	public final static String DATASOURCE_001102 = "001102";
	
	/** 联通地址类信息 (居住地址)*/
	public final static String DATASOURCE_001103 = "001103";
	
	public void callOnlineDataSource(Map<String, Object> args);

	public void callUnicomWorkDataSource(Map<String, Object> args);

	public void callUnicomLiveDataSource(Map<String, Object> args);
}
