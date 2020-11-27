package com.huaxia.plaze.modules.szjd.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.huaxia.plaze.modules.szjd.domain.SzjdRequest;
import com.huaxia.plaze.modules.szjd.mapper.SzjdMapper;
import com.huaxia.plaze.modules.szjd.service.SzjdService;

@Service("szjdService")
public class SzjdServiceImpl implements SzjdService {
	
	@Resource
	private SzjdMapper szjdMapper;

	@Override
	public void saveSzjdRequst(SzjdRequest szjdRequest) {
		szjdMapper.insertSzjdRequest(szjdRequest);
	}

}
