package com.huaxia.plaze.modules.hnair.mapper;

import java.util.List;
import java.util.Map;

import com.huaxia.plaze.modules.hnair.domain.HnairMsgResponse;

public interface HnairMsgResponseMapper {
	
	int insert(HnairMsgResponse hnairMsgResponse);
	
	List<HnairMsgResponse> selectListByParams(Map<String, Object> args);
}
