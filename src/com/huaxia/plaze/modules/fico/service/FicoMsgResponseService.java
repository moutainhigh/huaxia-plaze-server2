package com.huaxia.plaze.modules.fico.service;

import java.util.Date;
import java.util.List;

import com.huaxia.plaze.modules.fico.domain.FicoMsgResponse;

public interface FicoMsgResponseService {
	
	int save(FicoMsgResponse ficoMsgResponse);
	
	public List<FicoMsgResponse> selectListByParams(Date startDate,Date endDate);
}
