package com.huaxia.plaze.modules.pengyuan.mapper;

import java.util.List;

import com.huaxia.plaze.modules.pengyuan.domain.PyCrsResponse;
import com.huaxia.plaze.modules.pengyuan.domain.PyPcrTenRequest;


public interface PyCrsResponseMapper {

	int savePyCrsResponse(PyCrsResponse pyCrsResponse);
	
	List<String> findPyCrsResponseByConditions(PyPcrTenRequest pyPcrTenRequest);
}
