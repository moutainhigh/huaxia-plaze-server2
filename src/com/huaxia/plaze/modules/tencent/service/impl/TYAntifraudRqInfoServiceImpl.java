package com.huaxia.plaze.modules.tencent.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.huaxia.plaze.modules.tencent.mapper.TYAntifraudTrnRqMapper;
import com.huaxia.plaze.modules.tencent.service.TYAntifraudRqInfoService;

@Service
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class TYAntifraudRqInfoServiceImpl implements TYAntifraudRqInfoService {
	
	@Autowired
	private TYAntifraudTrnRqMapper tyAntifraudTrnRqMapper;

	@Override
	public void saveTYRqInfo(Map<String, String> params) {
		tyAntifraudTrnRqMapper.insertRqInfo(params);
	}

}
