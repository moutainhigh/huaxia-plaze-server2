package com.huaxia.plaze.modules.hnair.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.huaxia.plaze.modules.hnair.domain.HnairTrnRequest;
import com.huaxia.plaze.modules.hnair.mapper.HnairTrnRequestMapper;
import com.huaxia.plaze.modules.hnair.service.HnairTrnRequestService;

@Service("hnairTrnRequestService")
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class HnairTrnRequestServiceImpl implements HnairTrnRequestService {
	private final static Logger logger = LoggerFactory.getLogger(HnairTrnRequestServiceImpl.class);
	@Autowired
	private HnairTrnRequestMapper hnairTrnRequestMapper;
	@Override
	public int save(HnairTrnRequest hnairTrnRequest) {
		// TODO Auto-generated method stub
		return hnairTrnRequestMapper.insert(hnairTrnRequest);
	}

	
}
