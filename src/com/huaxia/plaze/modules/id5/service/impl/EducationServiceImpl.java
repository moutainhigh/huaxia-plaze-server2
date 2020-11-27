package com.huaxia.plaze.modules.id5.service.impl;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.huaxia.plaze.modules.id5.mapper.EducationDataSourceMapper;
import com.huaxia.plaze.modules.id5.service.EducationService;

@Service("educationService")
public class EducationServiceImpl implements EducationService {

	@Resource
	private EducationDataSourceMapper educationDataSourceMapper;

	@Override
	public void callDataSource(Map<String, Object> args) {
		educationDataSourceMapper.callDataSourceCount(args);
	}

}
