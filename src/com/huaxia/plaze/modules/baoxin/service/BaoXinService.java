package com.huaxia.plaze.modules.baoxin.service;

import java.util.Map;

import com.huaxia.plaze.modules.baoxin.domain.BaoXinBase;
import com.huaxia.plaze.modules.baoxin.domain.BaoXinRequest;
import com.huaxia.plaze.modules.baoxin.domain.BaoXinResponse;

public interface BaoXinService {

	int saveRequest(BaoXinRequest request);

	int selectCountOfDay();

	void saveReponse(BaoXinResponse baoXinResponse);

	void saveBase(BaoXinBase base);

	void callDataSource(Map<String, Object> args);

	String findBody(String certNo);

}
