package com.huaxia.plaze.modules.tongdun.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.huaxia.plaze.modules.tongdun.domain.MulBorTrnRequest;
import com.huaxia.plaze.modules.tongdun.mapper.MulBorTrnRequestMapper;
import com.huaxia.plaze.modules.tongdun.service.MulBorTrnRequestService;

/**
 * 多头借贷调用表数据入库
 * 
 * @author liuwei
 *
 */
@Service("mulBorTrnRequestService")
public class MulBorTrnRequestServiceImpl implements MulBorTrnRequestService {

	@Autowired
	private MulBorTrnRequestMapper mulBorTrnRequestMapper;

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public int save(MulBorTrnRequest mulBorTrnRequest) {

		return mulBorTrnRequestMapper.insert(mulBorTrnRequest);
	}

	public MulBorTrnRequestMapper getMulBorTrnRequestMapper() {
		return mulBorTrnRequestMapper;
	}

	public void setMulBorTrnRequestMapper(MulBorTrnRequestMapper mulBorTrnRequestMapper) {
		this.mulBorTrnRequestMapper = mulBorTrnRequestMapper;
	}

}
