package com.huaxia.plaze.modules.fico.mapper;

import java.util.List;
import java.util.Map;

import com.huaxia.plaze.modules.fico.domain.FicoMsgResponse;

public interface FicoMsgResponseMapper {
	
	int insert(FicoMsgResponse ficoMsgResponse);
	
	List<FicoMsgResponse> selectListByParams(Map<String, Object> args);
}
