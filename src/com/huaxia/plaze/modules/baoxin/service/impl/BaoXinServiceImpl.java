package com.huaxia.plaze.modules.baoxin.service.impl;

import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.huaxia.plaze.modules.baoxin.domain.BaoXinBase;
import com.huaxia.plaze.modules.baoxin.domain.BaoXinRequest;
import com.huaxia.plaze.modules.baoxin.domain.BaoXinResponse;
import com.huaxia.plaze.modules.baoxin.mapper.BaoXinMapper;
import com.huaxia.plaze.modules.baoxin.service.BaoXinService;
@Service
public class BaoXinServiceImpl implements BaoXinService{

	private static final Logger logger = LoggerFactory.getLogger(BaoXinServiceImpl.class);
	@Resource
	private BaoXinMapper baoXinMapper;
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public int saveRequest(BaoXinRequest request) {
		try {
			baoXinMapper.saveRequest(request);
		} catch (Exception e) {
			logger.error("保存保信汽车请求报文失败", e);
		}
		return 0;
	}
	@Override
	public int selectCountOfDay() {
		try {
			return baoXinMapper.selectCountOfDay();
		} catch (Exception e) {
			logger.error("查询当天已查询条数失败", e);
		}
		return 0;
	}
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public void saveReponse(BaoXinResponse baoXinResponse) {
		try {
			baoXinMapper.saveResponse(baoXinResponse);
		} catch (Exception e) {
			logger.error("保存保信汽车响应原始报文失败", e);
		}
	}
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public void saveBase(BaoXinBase base) {
		try {
			baoXinMapper.saveBase(base);
		} catch (Exception e) {
			logger.error("保存保信汽车解析表失败", e);
		}
	}
	@Override
	public void callDataSource(Map<String, Object> args) {
		baoXinMapper.callDataSource(args);
	}
	@Override
	public String findBody(String certNo) {
		return baoXinMapper.selectBody(certNo);
	}

}
