package com.huaxia.plaze.modules.jianbing.service;

import java.util.Map;


public interface JianBingResponseService {

	int save (Map<String, Object> info) throws Exception ;
	
	String queryResponseByRequest(String apply_id);
}
