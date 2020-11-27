package com.huaxia.plaze.modules.unicom.mapper;

import java.util.Map;

import com.huaxia.plaze.datasource.mapper.DataSourceCountMapper;

public interface UnicomDataSourceMapper extends DataSourceCountMapper {

	void callOnlineDataSourceCount(Map<String, Object> args);

	void callUnicomWorkDataSourceCount(Map<String, Object> args);

	void callUnicomLiveDataSourceCount(Map<String, Object> args);	
}
