package com.huaxia.plaze.modules.nciic.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.huaxia.plaze.modules.nciic.domain.NciicInfo;
import com.huaxia.plaze.modules.nciic.domain.NciicMsgResponse;
import com.huaxia.plaze.modules.nciic.mapper.NciicResponseMapper;
import com.huaxia.plaze.modules.nciic.service.NciicResponseService;

@Service("nciicResponseService")
public class NciicResponseServiceImpl implements NciicResponseService {

	@Resource
	NciicResponseMapper nciicResponseMapper;

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public int save(NciicInfo nciicInfo) {
		if (nciicInfo != null) {
			NciicMsgResponse msg = new NciicMsgResponse();
					msg.setMessageBody(nciicInfo.getBodyStr());
			        msg.setName(nciicInfo.getXm());
			        msg.setCertNo(nciicInfo.getGmsfhm());
			        msg.setCrtUser(nciicInfo.getCrtUser());
			        msg.setTrnId(nciicInfo.getTrnId());
			        nciicResponseMapper.insertMsg(msg);
			return nciicResponseMapper.insert(nciicInfo);
		}
		return 0;
	}

	@Override
	public String queryResponseByRequest(String name, String certNo) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("name", name);
		parameters.put("certNo", certNo);
		return nciicResponseMapper.selectResponseByRequest(parameters);
	}

}
