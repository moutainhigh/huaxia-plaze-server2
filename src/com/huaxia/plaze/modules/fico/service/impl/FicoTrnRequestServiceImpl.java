package com.huaxia.plaze.modules.fico.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.huaxia.plaze.modules.fico.domain.FicoTrnRequest;
import com.huaxia.plaze.modules.fico.mapper.FicoTrnRequestMapper;
import com.huaxia.plaze.modules.fico.service.FicoTrnRequestService;

@Service("ficoTrnRequestService")
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class FicoTrnRequestServiceImpl implements FicoTrnRequestService {
	private final static Logger logger = LoggerFactory.getLogger(FicoTrnRequestServiceImpl.class);
	@Autowired
	private FicoTrnRequestMapper ficoTrnRequestMapper;
	@Override
	public int save(FicoTrnRequest ficoTrnRequest) {
		// TODO Auto-generated method stub
		return ficoTrnRequestMapper.insert(ficoTrnRequest);
	}
	
}
