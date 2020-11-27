package com.huaxia.plaze.modules.nciic.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.huaxia.plaze.modules.nciic.domain.NciicXpRequest;
import com.huaxia.plaze.modules.nciic.mapper.PoliceRequestMapper;
import com.huaxia.plaze.modules.nciic.service.PoliceRequestService;

/**
 * 公安人像比对，请求信息保存操作
 * @author User
 *
 */
@Service("policeRequestService")
public class PoliceRequestServiceImpl implements PoliceRequestService {

	@Resource
	private PoliceRequestMapper policeRequestMapper;
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public int save(NciicXpRequest xpRequest) {
		try {
			return policeRequestMapper.save(xpRequest);
		} catch (Exception e) {
			
		}
		return 0;
	}

}
