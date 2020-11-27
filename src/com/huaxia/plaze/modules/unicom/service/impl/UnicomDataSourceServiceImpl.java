package com.huaxia.plaze.modules.unicom.service.impl;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.huaxia.plaze.modules.unicom.mapper.UnicomDataSourceMapper;
import com.huaxia.plaze.modules.unicom.service.UnicomDataSourceService;

@Service("unicomDataSourceService")
public class UnicomDataSourceServiceImpl implements UnicomDataSourceService {
	
	@Resource
	private UnicomDataSourceMapper unicomDataSourceMapper;

	@Override
	public void callDataSource(Map<String, Object> args) {
		unicomDataSourceMapper.callDataSourceCount(args);
	}

	@Override
	public void callOnlineDataSource(Map<String, Object> args){
		unicomDataSourceMapper.callOnlineDataSourceCount(args);
	}
	@Override
	public void callUnicomWorkDataSource(Map<String, Object> args) {
		unicomDataSourceMapper.callUnicomWorkDataSourceCount(args);		
	}
	@Override
	public void callUnicomLiveDataSource(Map<String, Object> args) {
		unicomDataSourceMapper.callUnicomLiveDataSourceCount(args);		
	}

}
