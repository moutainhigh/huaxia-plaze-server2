package com.huaxia.plaze.modules.jianbing.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.huaxia.plaze.modules.jianbing.domain.JianBingTrnRequest;
import com.huaxia.plaze.modules.jianbing.mapper.JianBingRequestMapper;
import com.huaxia.plaze.modules.jianbing.service.JianBingRequestService;

@Service("jianBingRequestService")
public class JianBingRequestServiceImpl implements JianBingRequestService {

	@Resource
	JianBingRequestMapper jianBingRequestMapper;

	@Override
	public int save(JianBingTrnRequest request) {
		if (request != null) {
			return jianBingRequestMapper.save(request);
		}
		return 0;
	}

}
