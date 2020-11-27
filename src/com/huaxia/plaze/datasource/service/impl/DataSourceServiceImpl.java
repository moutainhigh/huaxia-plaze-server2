package com.huaxia.plaze.datasource.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.huaxia.plaze.datasource.mapper.DataSourceMapper;
import com.huaxia.plaze.datasource.service.DataSourceService;

@Service("dataSourceService")
public class DataSourceServiceImpl implements DataSourceService {

	@Resource
	private DataSourceMapper dataSourceMapper;

	@Override
	public Map<String, Object> getConfigurationByParams(String dataSource, String channel) {
		Map<String, Object> args = new HashMap<String, Object>();
		args.put("sourceCode", dataSource);
		args.put("channelCode", channel);
		return dataSourceMapper.selectConfigurationByParams(args);
	}

	@Override
	public String getChannelCodeByName(String channelName) {
		return dataSourceMapper.selectChannelCodeByName(channelName);
	}
	
}
