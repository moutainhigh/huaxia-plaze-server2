package com.huaxia.plaze.modules.nciic.mapper;

import java.util.List;
import java.util.Map;

import com.huaxia.plaze.modules.nciic.domain.NciicInfo;
import com.huaxia.plaze.modules.nciic.domain.NciicMsgResponse;
import com.huaxia.plaze.modules.nciic.domain.NciicResponse;

public interface NciicResponseMapper {

	int insert(NciicInfo info);

	void insertMsg(NciicMsgResponse msg);

	String selectResponseByRequest(Map<String, Object> parameters);
}
