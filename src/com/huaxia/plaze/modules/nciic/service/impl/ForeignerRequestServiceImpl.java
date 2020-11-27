package com.huaxia.plaze.modules.nciic.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.huaxia.plaze.modules.nciic.domain.NciicForeignerRequest;
import com.huaxia.plaze.modules.nciic.mapper.ForeignerRequestMapper;
import com.huaxia.plaze.modules.nciic.service.ForeignerRequestService;

/**
 * 外国人永久居留证信息，请求信息保存操作
 * @author User
 *
 */
@Service("foreignerRequestService")
public class ForeignerRequestServiceImpl implements ForeignerRequestService {

	@Resource
	private ForeignerRequestMapper foreignerRequestMapper;
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public int save(NciicForeignerRequest foreignerRequest) {
		try {
			return foreignerRequestMapper.insert(foreignerRequest);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

}
