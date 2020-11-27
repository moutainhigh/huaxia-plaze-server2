package com.huaxia.plaze.modules.qyhy.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.huaxia.plaze.modules.qyhy.mapper.EnterpriseDataMapper;
import com.huaxia.plaze.modules.qyhy.service.EnterpriseDataService;

@Service("enterpriseDataService")
public class EnterpriseDataServiceImpl implements EnterpriseDataService {
	
	@Resource
	private EnterpriseDataMapper enterpriseDataMapper;

	@Override
	public String findCountByEnterprise(String enterprise) {
		return enterpriseDataMapper.selectCountByEnterprise(enterprise);
	}

}
