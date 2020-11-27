package com.huaxia.plaze.modules.nciic.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.huaxia.plaze.modules.nciic.domain.NciicXpInfo;
import com.huaxia.plaze.modules.nciic.domain.NciicXpResponse;
import com.huaxia.plaze.modules.nciic.mapper.PoliceResponseMapper;
import com.huaxia.plaze.modules.nciic.service.PoliceResponseService;

@Service("policeResponseService")
public class PoliceResponseServiceImpl implements PoliceResponseService {
	
	private static final Logger logger  = LoggerFactory.getLogger(PoliceResponseServiceImpl.class);
	@Resource
	private PoliceResponseMapper policeResponseMapper;
	/**
	 * 保存解析后的 info信息 和原始报文
	 */
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public int save(NciicXpInfo xpInfo) {
		try {
			NciicXpResponse xpResponse = new NciicXpResponse();
			xpResponse.setMessageBody(xpInfo.getBodyStr());
			xpResponse.setName(xpInfo.getXm());
			xpResponse.setCertNo(xpInfo.getGmsfhm());
			xpResponse.setCrtUser(xpInfo.getCrtUser());
			xpResponse.setTrnId(xpInfo.getTrnId());
			policeResponseMapper.insertInfo(xpInfo);
			return policeResponseMapper.insertResponse(xpResponse);
		} catch (Exception e) {
			logger.error("持久化解析报文数据失败{}", e);
			e.printStackTrace();
		}
		return 0;
	}
	
	@Override
	public String queryResponseByRequest(String name, String certNo) {
		try {
			Map<String, Object> parameters = new HashMap<String, Object>();
			parameters.put("name", name);
			parameters.put("certNo", certNo);
			return policeResponseMapper.selectResponseByRequest(parameters);
		} catch (Exception e) {
			logger.error("【人像比对，查找原始报文失败message{}】", e.getMessage());
			e.printStackTrace();
		}
		return null;
	}

}
