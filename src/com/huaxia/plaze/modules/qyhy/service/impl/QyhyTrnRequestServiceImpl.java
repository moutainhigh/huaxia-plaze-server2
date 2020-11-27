package com.huaxia.plaze.modules.qyhy.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huaxia.plaze.modules.qyhy.domain.QyhyTrnRequestParameters;
import com.huaxia.plaze.modules.qyhy.mapper.QyhyTrnRequestMapper;
import com.huaxia.plaze.modules.qyhy.service.QyhyTrnRequestService;

@Service("qyhyTrnRequestService")
public class QyhyTrnRequestServiceImpl implements QyhyTrnRequestService{

	@Autowired
	private QyhyTrnRequestMapper qyhyTrnRequestMapper;
	

	public QyhyTrnRequestMapper getQyhyTrnRequestMapper() {
		return qyhyTrnRequestMapper;
	}


	public void setQyhyTrnRequestMapper(QyhyTrnRequestMapper qyhyTrnRequestMapper) {
		this.qyhyTrnRequestMapper = qyhyTrnRequestMapper;
	}


	@Override
	public int saveQyhyRequestParameters(QyhyTrnRequestParameters parameters) {
		return qyhyTrnRequestMapper.insertQyhyRequestParammeters(parameters);
		
	}


	@Override
	public List<Map<String, String>> findQyhyParamList(String trnId) {
		return qyhyTrnRequestMapper.selectQyhyParamList(trnId);
	}


	@Override
	public String findHistoryReport(String enterprise) {
		return qyhyTrnRequestMapper.selectHistoryReport(enterprise);
	}

}
