package com.huaxia.plaze.modules.hnair.service.impl;


import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.huaxia.plaze.modules.hnair.domain.Hnair;
import com.huaxia.plaze.modules.hnair.mapper.HnairMapper;
import com.huaxia.plaze.modules.hnair.service.HnairService;

@Service("hnairService")
public class HnairServiceImpl  implements HnairService {
	private final static Logger logger = LoggerFactory.getLogger(HnairServiceImpl.class);
	@Resource
	private HnairMapper seaAirMapper;
	public HnairMapper getSeaAirMapper() {
		return seaAirMapper;
	}
	public void setSeaAirMapper(HnairMapper seaAirMapper) {
		this.seaAirMapper = seaAirMapper;
	}
	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void save(Hnair seaAir) {
		seaAirMapper.insertSeaAirData(seaAir);
	}
	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public int getCountByAppId(String appId) {
		return seaAirMapper.selectCountByAppId(appId);
	}
}