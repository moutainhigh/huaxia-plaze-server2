package com.huaxia.plaze.modules.pengyuan.service.impl;

import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.huaxia.plaze.modules.pengyuan.domain.PyPwslTrnRequest;
import com.huaxia.plaze.modules.pengyuan.mapper.PyPwslTrnRequestMapper;
import com.huaxia.plaze.modules.pengyuan.service.PyPwslTrnRequestService;

@Service("pyPwslTrnRequestService")
public class PyPwslTrnRequestServiceImpl implements PyPwslTrnRequestService {

	private final static Logger logger = LoggerFactory.getLogger(PyPwslTrnRequestServiceImpl.class);
	
	@Resource
	private PyPwslTrnRequestMapper pyPwslTrnRequestMapper;

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public int save(PyPwslTrnRequest pyPwslTrnRequest) {
		if (pyPwslTrnRequest != null) {
			try {
				pyPwslTrnRequestMapper.save(pyPwslTrnRequest);
			} catch (Exception e) {
				logger.error("[区域数据-深圳-鹏元-个人高信分] 持久化请求报文异常{}",e.getMessage());
				e.printStackTrace();
			}
		}
		return 0;
	}

}
