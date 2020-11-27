package com.huaxia.plaze.modules.id5.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.huaxia.plaze.modules.id5.domain.Id5Request;
import com.huaxia.plaze.modules.id5.mapper.Id5RequestMapper;
import com.huaxia.plaze.modules.id5.service.Id5RequestService;


@Service("id5RequestService")
public class Id5RequestServiceImpl implements Id5RequestService {

	@Resource
	Id5RequestMapper id5RequestMapper;

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public int save(Id5Request id5Request) {
		if (id5Request != null) {
			return id5RequestMapper.save(id5Request);
		}
		return 0;
	}

}
