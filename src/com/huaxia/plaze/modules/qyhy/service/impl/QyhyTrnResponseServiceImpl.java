package com.huaxia.plaze.modules.qyhy.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.huaxia.plaze.modules.qyhy.domain.QyhyResponseParameters;
import com.huaxia.plaze.modules.qyhy.mapper.QyhyTrnResponseMapper;
import com.huaxia.plaze.modules.qyhy.service.QyhyTrnResponseService;

@Service("qyhyTrnResponseService")
public class QyhyTrnResponseServiceImpl implements QyhyTrnResponseService {

	@Resource
	private QyhyTrnResponseMapper qyhyTrnResponseMapper;
	
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public int save(QyhyResponseParameters trnResponseParameter) {
		if (trnResponseParameter != null) {
			return qyhyTrnResponseMapper.save(trnResponseParameter);
		}
		return 0;
	}

	@Override
	public String findResponseByRequest(String enterprise, String certNo, String trnId) {

		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("enterprise", enterprise);
		parameters.put("certNo", certNo);
		parameters.put("trnId", trnId);
		List<String> result = qyhyTrnResponseMapper.findResponseByRequest(parameters);
		if (result.size() > 0) {
			return result.get(0);
		}
	
		return null;
	}


	@Override
	public int saveBodyOriginal(QyhyResponseParameters trnResponseParameters) {
		return qyhyTrnResponseMapper.insertBodyOriginal(trnResponseParameters);
	}

}
