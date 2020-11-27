package com.huaxia.plaze.modules.tongdun.service;

import java.util.Date;
import java.util.List;

import com.huaxia.plaze.modules.tongdun.domain.MulBorMsgResponse;

public interface MulBorMsgResponseService {
	
	int save(MulBorMsgResponse mulBorMsgResponse);
	
	public List<MulBorMsgResponse> selectListByParams(String certNo,String mobile,Date startDate,Date endDate);
}
