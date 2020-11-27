package com.huaxia.plaze.modules.pengyuan.service;

import com.huaxia.plaze.modules.pengyuan.domain.PyCrsResponse;
import com.huaxia.plaze.modules.pengyuan.domain.PyPcrTenRequest;

public interface PyCrsResponseService {

	int savePyCrsResponse(PyCrsResponse pyCrsResponse);
	
	String findPyCrsResponseByConditions(PyPcrTenRequest pyPcrTenRequest);
}
