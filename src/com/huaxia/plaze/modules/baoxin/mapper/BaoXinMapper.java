package com.huaxia.plaze.modules.baoxin.mapper;

import java.util.Map;

import com.huaxia.plaze.modules.baoxin.domain.BaoXinBase;
import com.huaxia.plaze.modules.baoxin.domain.BaoXinRequest;
import com.huaxia.plaze.modules.baoxin.domain.BaoXinResponse;

public interface BaoXinMapper {

	void saveRequest(BaoXinRequest request);

	int selectCountOfDay();

	void saveResponse(BaoXinResponse baoXinResponse);

	void saveBase(BaoXinBase base);

	void callDataSource(Map<String, Object> args);

	String selectBody(String certNo);

}
