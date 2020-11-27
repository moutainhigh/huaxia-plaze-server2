package com.huaxia.plaze.modules.yilianzhong.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.huaxia.plaze.modules.yilianzhong.domain.YlzMsgResponse;
import com.huaxia.plaze.modules.yilianzhong.mapper.YlzMsgResponseMapper;
import com.huaxia.plaze.modules.yilianzhong.service.YlzMsgResponseService;

@Service("YlzMsgResponseService")
public class YlzMsgResponseServiceImpl implements YlzMsgResponseService{
	private final static Logger logger = LoggerFactory.getLogger(YlzMsgResponseServiceImpl.class);
	@Resource
	private YlzMsgResponseMapper ylzMsgResponseMapper;
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public int save(YlzMsgResponse ylzMsgResponse) {
		if(ylzMsgResponse!=null){
			try {
				return ylzMsgResponseMapper.save(ylzMsgResponse);
			} catch (Exception e) {
				logger.error("厦门易联众持久化相应解析数据异常："+e.getMessage());
			}
		}
		return 0;
	}

	@Override
	public String getYlzMsgResponseByParm(String name, String certNo) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("name", name);
		parameters.put("certNo", certNo);
		try {
			List<String> list=ylzMsgResponseMapper.getYlzMsgResponseByParm(parameters);
			if(list.size()>0){
				return list.get(0);
			}
		} catch (Exception e) {
			logger.error("厦门易联众请求查找结果异常："+e.getMessage());
		}
		return null;
	}


}
