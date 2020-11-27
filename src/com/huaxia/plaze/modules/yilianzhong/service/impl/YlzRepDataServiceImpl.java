package com.huaxia.plaze.modules.yilianzhong.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.huaxia.plaze.modules.yilianzhong.domain.YlzRepData;
import com.huaxia.plaze.modules.yilianzhong.mapper.YlzRepDataMapper;
import com.huaxia.plaze.modules.yilianzhong.service.YlzRepDataService;

@Service("YlzRepDataService")
public class YlzRepDataServiceImpl implements YlzRepDataService {

	@Resource
	private YlzRepDataMapper ylzRepDataMapper;

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public int save(YlzRepData ylzRepData) {
		if (ylzRepData != null) {
			return ylzRepDataMapper.save(ylzRepData);
		}
		return 0;
	}

}
