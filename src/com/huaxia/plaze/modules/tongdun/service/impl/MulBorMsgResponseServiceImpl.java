package com.huaxia.plaze.modules.tongdun.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.huaxia.plaze.modules.tongdun.domain.MulBorMsgResponse;
import com.huaxia.plaze.modules.tongdun.mapper.MulBorMsgResponseMapper;
import com.huaxia.plaze.modules.tongdun.service.MulBorMsgResponseService;

/**
 * 多头借贷响应表数据入库
 * 
 * @author liuwei
 *
 */
@Service("mulBorMsgResponseService")
public class MulBorMsgResponseServiceImpl implements MulBorMsgResponseService {

	@Resource
	private MulBorMsgResponseMapper mulBorMsgResponseMapper;
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public int save(MulBorMsgResponse mulBorMsgResponse) {
		// TODO Auto-generated method stub
		return mulBorMsgResponseMapper.insert(mulBorMsgResponse);
	}

	@Override
	public List<MulBorMsgResponse> selectListByParams(String certNo,String mobile,Date startDate,Date endDate) {
		
		Map<String, Object> args = new HashMap<String, Object>();
		args.put("certNo", certNo);
		args.put("mobile", mobile);
		args.put("startDate", startDate);
		args.put("endDate", endDate);
		
		return mulBorMsgResponseMapper.selectListByParams(args);
	}

}
