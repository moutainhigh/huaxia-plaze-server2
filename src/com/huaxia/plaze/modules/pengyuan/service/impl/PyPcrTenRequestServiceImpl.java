package com.huaxia.plaze.modules.pengyuan.service.impl;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.huaxia.plaze.modules.pengyuan.domain.PyPcrTenRequest;
import com.huaxia.plaze.modules.pengyuan.mapper.PyPcrTenRequestMapper;
import com.huaxia.plaze.modules.pengyuan.service.PyPcrTenRequestService;

@Service("pyPcrTenRequestService")
public class PyPcrTenRequestServiceImpl implements PyPcrTenRequestService {

	private final static Logger logger = LoggerFactory.getLogger(PyPcrTenRequestServiceImpl.class);
	
	@Resource
	private PyPcrTenRequestMapper pyPcrTenRequestMapper;
	
	@Override
	public int savePyPcrTenRequest(PyPcrTenRequest pyPcrTenRequest) {
		if(pyPcrTenRequest!=null){
			try {
				return pyPcrTenRequestMapper.savePyPcrTenRequest(pyPcrTenRequest);
			} catch (Exception e) {
				logger.error("[区域数据-深圳-鹏元-个人信用] 持久化请求报文失败{}",e.getMessage());
				e.printStackTrace();
			}
		}
		return 0;
	}

}
