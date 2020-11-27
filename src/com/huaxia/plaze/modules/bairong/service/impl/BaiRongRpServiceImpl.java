package com.huaxia.plaze.modules.bairong.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.huaxia.plaze.modules.bairong.mapper.BaiRongRpMapper;
import com.huaxia.plaze.modules.bairong.service.BaiRongRpService;

@Service("baiRongRpService")
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class BaiRongRpServiceImpl implements BaiRongRpService {
	
	@Autowired
	private BaiRongRpMapper baiRongRpMapper;

	@Override
	public void saveResponseInfo(Map<String, String> params) {
		baiRongRpMapper.insertResponseInfo(params);
	}
	
}
