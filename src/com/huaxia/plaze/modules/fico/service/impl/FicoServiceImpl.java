package com.huaxia.plaze.modules.fico.service.impl;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.huaxia.plaze.modules.fico.domain.Fico;
import com.huaxia.plaze.modules.fico.mapper.FicoMapper;
import com.huaxia.plaze.modules.fico.service.FicoService;

@Service("ficoService")
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class FicoServiceImpl implements FicoService {
	private final static Logger logger = LoggerFactory.getLogger(FicoServiceImpl.class);
	@Autowired
	private FicoMapper ficoMapper;
	
	@Override
	public String  test(String params) {
		// TODO Auto-generated method stub
		
		return "Hello World!"+params;
	}
	
	public FicoMapper getFicoMapper() {
		return ficoMapper;
	}
	public void setFicoMapper(FicoMapper ficoMapper) {
		this.ficoMapper = ficoMapper;
	}

	public static Logger getLogger() {
		return logger;
	}

	@Override
	public int getCountByAppId(String appId) {
		return ficoMapper.getCountByAppId( appId);
	}

	@Override
	public int save(Fico fico) {
		return ficoMapper.insert(fico);
	}

	@Override
	public Fico selectConfirmPboc(String appId) {
		return ficoMapper.selectConfirmPboc(appId);
	}
	@Override
	public void saveFicoUpdateDataAdapterAction(Fico fico, String appId, String ficoTaskType) {
		ficoMapper.insert(fico);
	}
	@Override
	public Map<String, String> selectBizInpApplC1JudgeFlag(Map<String, String> params) {
		return ficoMapper.selectBizInpApplC1JudgeFlag(params);
	}
}
