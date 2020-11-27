package com.huaxia.plaze.modules.unicom.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.huaxia.plaze.modules.unicom.domain.UnicomOnline;
import com.huaxia.plaze.modules.unicom.domain.UnicomOnlineMsgResponse;
import com.huaxia.plaze.modules.unicom.domain.UnicomOnlineTrnRequest;
import com.huaxia.plaze.modules.unicom.mapper.UnicomOnlineMapper;
import com.huaxia.plaze.modules.unicom.service.UnicomOnlineService;

@Service("unicomOnlineService")
public class UnicomOnlineServiceImpl implements UnicomOnlineService {
	
	@Resource
	private UnicomOnlineMapper unicomOnlineMapper;

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public void saveUnicomOnlineTrnRequest(UnicomOnlineTrnRequest unicomOnlineTrnRequest) {
		unicomOnlineMapper.insertUnicomOnlineTrnRequest(unicomOnlineTrnRequest);
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public int saveUnicomOnlineMsgResponse(UnicomOnlineMsgResponse unicomOnlineMsgResponse) {
		return unicomOnlineMapper.insertUnicomOnlineMsgResponse(unicomOnlineMsgResponse);
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public int saveUnicomOnline(UnicomOnline unicomOnline) {
		return unicomOnlineMapper.insertUnicomOnline(unicomOnline);
	}

	@Override
	public List<UnicomOnlineMsgResponse> queryListByParams(String certNo, String mobile, String name) {
		Map<String, Object> args = new HashMap<String, Object>();
		args.put("certNo", certNo);
		args.put("mobile", mobile);
		args.put("name", name);
		return unicomOnlineMapper.selectListByParams(args);
	}

	@Override
	public List<UnicomOnlineMsgResponse> query24HoursListByParams(String certNo, String mobile, String name) {
		Map<String, Object> args = new HashMap<String, Object>();
		args.put("certNo", certNo);
		args.put("mobile", mobile);
		args.put("name", name);
		return unicomOnlineMapper.select24HoursListByParams(args);
	}

}
