package com.huaxia.plaze.modules.nciic.service.impl;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.huaxia.plaze.modules.nciic.mapper.PoliceXPDataSourceMapper;
import com.huaxia.plaze.modules.nciic.service.PoliceXPService;

@Service("policeXPService")
public class PoliceXPServiceImpl implements PoliceXPService {

	@Resource
	private PoliceXPDataSourceMapper policeXPDataSourceMapper;

	@Override
	public void callDataSource(Map<String, Object> args) {
		policeXPDataSourceMapper.callDataSourceCount(args);
	}

}
