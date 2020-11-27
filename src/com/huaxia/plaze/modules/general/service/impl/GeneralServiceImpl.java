package com.huaxia.plaze.modules.general.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.huaxia.plaze.modules.general.domain.GeneralData;
import com.huaxia.plaze.modules.general.mapper.GeneralMapper;
import com.huaxia.plaze.modules.general.service.GeneralService;

@Service("generalService")
public class GeneralServiceImpl implements GeneralService {

	@Resource
	private GeneralMapper generalMapper;
	
	@Override
	public GeneralData findGeneralData(String trnCode) {
		return generalMapper.selectGeneralData(trnCode);
	}

}
