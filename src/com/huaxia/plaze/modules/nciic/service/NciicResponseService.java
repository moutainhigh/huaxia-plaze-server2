package com.huaxia.plaze.modules.nciic.service;

import java.util.Map;

import com.huaxia.plaze.modules.nciic.domain.NciicInfo;


public interface NciicResponseService {

	int save(NciicInfo hdMoblResponse);
	
	String queryResponseByRequest(String name,String certNo);
}
