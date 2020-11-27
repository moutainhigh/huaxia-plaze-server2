package com.huaxia.plaze.modules.nciic.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.huaxia.plaze.modules.nciic.domain.NciicForeignerInfo;
import com.huaxia.plaze.modules.nciic.domain.NciicForeignerResponse;
import com.huaxia.plaze.modules.nciic.mapper.ForeignerResponseMapper;
import com.huaxia.plaze.modules.nciic.service.ForeignerResponseService;

@Service("foreignerResponseService")
public class ForeignerResponseServiceImpl implements ForeignerResponseService {
	
	private static final Logger logger  = LoggerFactory.getLogger(ForeignerResponseServiceImpl.class);
	@Resource
	private ForeignerResponseMapper foreignerResponseMapper;
	/**
	 * 保存解析后的 info信息 和原始报文
	 */
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public int save(NciicForeignerInfo nciicForeignerInfo) {
		try {
			NciicForeignerResponse nciicForeignerResponse = new NciicForeignerResponse();
			nciicForeignerResponse.setMessageBody(nciicForeignerInfo.getBodyStr());
			nciicForeignerResponse.setCrtUser(nciicForeignerInfo.getCrtUser());
			nciicForeignerResponse.setTrnId(nciicForeignerInfo.getTrnId());
			foreignerResponseMapper.insertInfo(nciicForeignerInfo);
			return foreignerResponseMapper.insertResponse(nciicForeignerResponse);
		} catch (Exception e) {
			logger.error("持久化解析报文数据失败{}", e);
			e.printStackTrace();
		}
		return 0;
	}
	
	@Override
	public String queryResponseByRequest(String name, String certNo,String birth,String expiryDate) {
		try {
			Map<String, Object> parameters = new HashMap<String, Object>();
			parameters.put("name", name);
			parameters.put("certNo", certNo);
			parameters.put("birth", certNo);
			parameters.put("expiryDate", certNo);
			return foreignerResponseMapper.selectResponseByRequest(parameters);
		} catch (Exception e) {
			logger.error("【外国人永久居留证信息，查找原始报文失败message{}】", e.getMessage());
			e.printStackTrace();
		}
		return null;
	}

}
