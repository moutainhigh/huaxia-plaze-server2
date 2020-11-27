package com.huaxia.plaze.modules.hnair.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.huaxia.plaze.modules.hnair.domain.HnairMsgResponse;
import com.huaxia.plaze.modules.hnair.mapper.HnairMsgResponseMapper;
import com.huaxia.plaze.modules.hnair.service.HnairMsgResponseService;

@Service("hnairMsgResponseService")
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class HnairMsgResponseServiceImpl implements HnairMsgResponseService {
	private final static Logger logger = LoggerFactory.getLogger(HnairMsgResponseServiceImpl.class);
	
	@Autowired
	private HnairMsgResponseMapper hnairMsgResponseMapper;
	@Override
	public int save(HnairMsgResponse hnairMsgResponse) {
		// TODO Auto-generated method stub
		return hnairMsgResponseMapper.insert(hnairMsgResponse);
	}

	//查询24小时内的数据
	@Override
	public List<HnairMsgResponse> selectListByParams(Date startDate,Date endDate) {
		
		Map<String, Object> args = new HashMap<String, Object>();
		args.put("startDate", startDate);
		args.put("endDate", endDate);
		
		return hnairMsgResponseMapper.selectListByParams(args);
	}
}
