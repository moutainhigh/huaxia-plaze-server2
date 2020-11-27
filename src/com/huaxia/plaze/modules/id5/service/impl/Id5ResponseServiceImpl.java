package com.huaxia.plaze.modules.id5.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.huaxia.plaze.modules.id5.domain.Education;
import com.huaxia.plaze.modules.id5.domain.Id5Response;
import com.huaxia.plaze.modules.id5.mapper.Id5ResponseMapper;
import com.huaxia.plaze.modules.id5.service.Id5ResponseService;

@Service("id5ResponseService")
public class Id5ResponseServiceImpl implements Id5ResponseService {

	@Resource
	Id5ResponseMapper id5ResponseMapper;

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public int save(Id5Response id5Response) {
		if (id5Response != null) {
			return id5ResponseMapper.save(id5Response);
		}
		return 0;
	}
	public int saveEduData(Education education){
		if (education != null) {
			return id5ResponseMapper.saveEduData(education);
		}
		return 0;
	}

	@Override
	public String findResponseByRequest(String name, String certNo, String mobile) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("name", name);
		parameters.put("certNo", certNo);
		parameters.put("mobile", mobile);
		List<String> result = id5ResponseMapper.findResponseByRequest(parameters);
		if (result.size() > 0) {
			return result.get(0);
		}
		return null;
	}

}
