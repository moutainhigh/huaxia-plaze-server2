package com.huaxia.plaze.modules.id5.service;

import com.huaxia.plaze.modules.id5.domain.Education;
import com.huaxia.plaze.modules.id5.domain.Id5Response;

public interface Id5ResponseService {

	int save(Id5Response id5Response);
	int saveEduData(Education education);
	String findResponseByRequest(String name,String certNo,String mobile);
}
