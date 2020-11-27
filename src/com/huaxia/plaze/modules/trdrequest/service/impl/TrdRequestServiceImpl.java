package com.huaxia.plaze.modules.trdrequest.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.huaxia.plaze.modules.trdrequest.domain.TrdRequest;
import com.huaxia.plaze.modules.trdrequest.mapper.TrdRequestMapper;
import com.huaxia.plaze.modules.trdrequest.service.TrdRequestService;

@Service("trdRequestService")
public class TrdRequestServiceImpl implements TrdRequestService {
	
	@Resource
	private TrdRequestMapper trdRequestMapper;

	@Override
	public TrdRequest findSetData(String trnCode) {
		return trdRequestMapper.selectSetData(trnCode);
	}

}
