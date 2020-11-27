package com.huaxia.plaze.modules.fico.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.huaxia.plaze.modules.fico.domain.FicoMsgResponse;
import com.huaxia.plaze.modules.fico.mapper.FicoMsgResponseMapper;
import com.huaxia.plaze.modules.fico.service.FicoMsgResponseService;

@Service("ficoMsgResponseService")
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class FicoMsgResponseServiceImpl implements FicoMsgResponseService {
	private final static Logger logger = LoggerFactory.getLogger(FicoMsgResponseServiceImpl.class);
	
	@Resource
	private FicoMsgResponseMapper ficoMsgResponseMapper;
	@Override
	public int save(FicoMsgResponse ficoMsgResponse) {
		// TODO Auto-generated method stub
		return ficoMsgResponseMapper.insert(ficoMsgResponse);
	}

	//查询24小时内的数据
	@Override
	public List<FicoMsgResponse> selectListByParams(Date startDate,Date endDate) {
		
		Map<String, Object> args = new HashMap<String, Object>();
		args.put("startDate", startDate);
		args.put("endDate", endDate);
		
		return ficoMsgResponseMapper.selectListByParams(args);
	}
}
