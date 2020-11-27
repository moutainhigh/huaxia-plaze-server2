package com.huaxia.plaze.modules.nciic.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.huaxia.plaze.modules.nciic.domain.NciicRequest;
import com.huaxia.plaze.modules.nciic.mapper.NciicRequestMapper;
import com.huaxia.plaze.modules.nciic.service.NciicRequestService;

@Service("nciicRequestService")
public class NciicRequestServiceImpl implements NciicRequestService {

	@Resource
	NciicRequestMapper nciicRequestMapper;

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public int save(NciicRequest nciicRequest) {
		if (nciicRequest != null) {
			return nciicRequestMapper.save(nciicRequest);
		}
		return 0;
	}

}
