package com.huaxia.plaze.modules.id5.mapper;

import java.util.List;
import java.util.Map;

import com.huaxia.plaze.modules.id5.domain.Education;
import com.huaxia.plaze.modules.id5.domain.Id5Response;


public interface Id5ResponseMapper {

	int save(Id5Response id5Response);
	List<String> findResponseByRequest(Map<String,Object> parameters);
	int saveEduData(Education education);
}
