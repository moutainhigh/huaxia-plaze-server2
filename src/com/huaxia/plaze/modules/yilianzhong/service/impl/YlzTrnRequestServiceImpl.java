package com.huaxia.plaze.modules.yilianzhong.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.huaxia.plaze.modules.yilianzhong.domain.YlzTrnRequest;
import com.huaxia.plaze.modules.yilianzhong.mapper.YlzTrnRequestMapper;
import com.huaxia.plaze.modules.yilianzhong.service.YlzTrnRequestService;

@Service("YlzTrnRequestService")
public class YlzTrnRequestServiceImpl implements YlzTrnRequestService {

	@Resource
	private YlzTrnRequestMapper ylzTrnRequestMapper;
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public int save(YlzTrnRequest ylzTrnRequest) {
		if(ylzTrnRequest!=null){
			return ylzTrnRequestMapper.save(ylzTrnRequest);
		}
		return 0;
	}

}
