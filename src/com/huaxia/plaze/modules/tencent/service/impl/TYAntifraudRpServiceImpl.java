package com.huaxia.plaze.modules.tencent.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.huaxia.plaze.modules.tencent.mapper.TianYuRpMapper;
import com.huaxia.plaze.modules.tencent.service.TYAntifraudRpService;

@Service
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class TYAntifraudRpServiceImpl implements TYAntifraudRpService {
	
	@Autowired
	private TianYuRpMapper tianYuResponseMapper;

	@Override
	public void saveResponseInfo(Map<String, String> params) {
		tianYuResponseMapper.insertResponseInfo(params);
	}
	
}
