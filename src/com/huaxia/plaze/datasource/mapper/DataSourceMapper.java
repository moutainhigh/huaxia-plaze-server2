package com.huaxia.plaze.datasource.mapper;

import java.util.Map;

public interface DataSourceMapper {

	Map<String, Object> selectConfigurationByParams(Map<String, Object> args);
	
	String selectChannelCodeByName(String channelName);
	
}
