package com.huaxia.plaze.modules.hnair.service;

import java.util.Date;
import java.util.List;

import com.huaxia.plaze.modules.hnair.domain.HnairMsgResponse;

public interface HnairMsgResponseService {
	
	int save(HnairMsgResponse hanirMsgResponse);
	
	public List<HnairMsgResponse> selectListByParams(Date startDate,Date endDate);
}
