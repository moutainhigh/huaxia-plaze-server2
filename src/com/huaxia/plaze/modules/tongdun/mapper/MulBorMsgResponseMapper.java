package com.huaxia.plaze.modules.tongdun.mapper;

import java.util.List;
import java.util.Map;

import com.huaxia.plaze.modules.tongdun.domain.MulBorMsgResponse;


public interface MulBorMsgResponseMapper {
	
	int insert(MulBorMsgResponse mulBorMsgResponse);
	
	List<MulBorMsgResponse> selectListByParams(Map<String, Object> args);
}
