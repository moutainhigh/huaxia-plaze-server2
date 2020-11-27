package com.huaxia.plaze.modules.pengyuan.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.huaxia.plaze.modules.pengyuan.domain.PyCrsResponse;
import com.huaxia.plaze.modules.pengyuan.domain.PyPcrTenRequest;
import com.huaxia.plaze.modules.pengyuan.mapper.PyCrsResponseMapper;
import com.huaxia.plaze.modules.pengyuan.service.PyCrsResponseService;

@Service("pyCrsResponseService")
public class PyCrsResponseServiceImpl implements PyCrsResponseService {

	private final static Logger logger = LoggerFactory.getLogger(PyCrsResponseServiceImpl.class);
	
	@Resource
	private PyCrsResponseMapper pyCrsResponseMapper;
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public int savePyCrsResponse(PyCrsResponse pyCrsResponse) {
		if(pyCrsResponse!=null){
			try {
				return pyCrsResponseMapper.savePyCrsResponse(pyCrsResponse);
			} catch (Exception e) {
				logger.error("[区域数据-深圳-个人高信分] pyCrsResponseMapper.savePyCrsResponse()持久化异常{}",e.getMessage());
				e.printStackTrace();
			}
		}
		return 0;
	}

	@Override
	public String findPyCrsResponseByConditions(PyPcrTenRequest pyPcrTenRequest) {
		if(pyPcrTenRequest!=null){
			try {
				List<String> strList=pyCrsResponseMapper.findPyCrsResponseByConditions(pyPcrTenRequest);
				if(strList!=null&&strList.size()>0){
					return strList.get(0);
				}
			} catch (Exception e) {
				logger.error("[区域数据-深圳-个人高信分] 根据请求查找结果异常{}",e.getMessage());
				e.printStackTrace();
			}
		}
		return null;
	}

}
