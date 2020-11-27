package com.huaxia.plaze.modules.qyhy.mapper;

import java.util.List;
import java.util.Map;

import com.huaxia.plaze.modules.qyhy.domain.QyhyResponseParameters;

public interface QyhyTrnResponseMapper {

	int save(QyhyResponseParameters trnResponseParameter);

	List<String> findResponseByRequest(Map<String, Object> parameters);

	int insertBodyOriginal(QyhyResponseParameters trnResponseParameters);

}
