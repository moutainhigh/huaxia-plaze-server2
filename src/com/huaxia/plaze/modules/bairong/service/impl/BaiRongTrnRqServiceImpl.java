package com.huaxia.plaze.modules.bairong.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.huaxia.plaze.modules.bairong.mapper.BaiRongTrnRqMapper;
import com.huaxia.plaze.modules.bairong.service.BaiRongTrnRqService;

@Service("baiRongTrnRqService")
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class BaiRongTrnRqServiceImpl implements BaiRongTrnRqService {

	@Autowired
	private BaiRongTrnRqMapper baiRongTrnRqMapper;
	
	@Override
	public void saveBrRqInfo(Map<String, String> params) {
		baiRongTrnRqMapper.insertRqInfo(params);
	}

	@Override
	public String findPkUuidByTrnId(String trnId) {
		
		return baiRongTrnRqMapper.selectPkUuidByTrnId(trnId);
	}
	
}
