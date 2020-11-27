package com.huaxia.plaze.modules.pengyuan.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.huaxia.plaze.modules.pengyuan.domain.PyPwslCrs;
import com.huaxia.plaze.modules.pengyuan.domain.PyPwslCrsCrt;
import com.huaxia.plaze.modules.pengyuan.domain.PyPwslCrsCrtCollection;
import com.huaxia.plaze.modules.pengyuan.domain.PyPwslCrsCrtPwls;
import com.huaxia.plaze.modules.pengyuan.domain.PyPwslCrsCrtPwlsItm;
import com.huaxia.plaze.modules.pengyuan.domain.PyPwslCrsCrtQcs;
import com.huaxia.plaze.modules.pengyuan.domain.PyPwslMsgResponse;
import com.huaxia.plaze.modules.pengyuan.domain.PyPwslResponse;
import com.huaxia.plaze.modules.pengyuan.mapper.PyPwslCrsCrtMapper;
import com.huaxia.plaze.modules.pengyuan.mapper.PyPwslCrsCrtPwlsItmMapper;
import com.huaxia.plaze.modules.pengyuan.mapper.PyPwslCrsCrtPwlsMapper;
import com.huaxia.plaze.modules.pengyuan.mapper.PyPwslCrsCrtQcsMapper;
import com.huaxia.plaze.modules.pengyuan.mapper.PyPwslCrsMapper;
import com.huaxia.plaze.modules.pengyuan.mapper.PyPwslMsgResponseMapper;
import com.huaxia.plaze.modules.pengyuan.service.PyPwslResponseService;

@Service("pyPwslResponseService")
public class PyPwslResponseServiceImpl implements PyPwslResponseService {

	private final static Logger logger = LoggerFactory.getLogger(PyPwslResponseServiceImpl.class);

	@Resource
	private PyPwslCrsCrtMapper pyPwslCrsCrtMapper;
	@Resource
	private PyPwslCrsCrtPwlsItmMapper pyPwslCrsCrtPwlsItmMapper;
	@Resource
	private PyPwslCrsCrtPwlsMapper pyPwslCrsCrtPwlsMapper;
	@Resource
	private PyPwslCrsCrtQcsMapper pyPwslCrsCrtQcsMapper;
	@Resource
	private PyPwslCrsMapper pyPwslCrsMapper;
	@Resource
	private PyPwslMsgResponseMapper pyPwslMsgResponseMapper;

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public int savePyPwslResponse(PyPwslResponse pyPwslResponse) {
		if (pyPwslResponse != null) {
			PyPwslCrs pyPwslCrs = pyPwslResponse.getPyPwslCrs();
			if (pyPwslCrs != null) {
				try {
					pyPwslCrsMapper.save(pyPwslCrs);
				} catch (Exception e) {
					logger.error("[区域数据-深圳-鹏元-个人高信分] 持久化返回报文异常{}", e.getMessage());
					e.printStackTrace();
				}
			}
			List<PyPwslCrsCrtCollection> pyPwslCrsCrtCollectionList = pyPwslResponse.getPyPwslCrsCrtCollectionList();
			if (pyPwslCrsCrtCollectionList != null && pyPwslCrsCrtCollectionList.size() > 0) {
				try {
					for (PyPwslCrsCrtCollection pyPwslCrsCrtCollection : pyPwslCrsCrtCollectionList) {
						PyPwslCrsCrt pyPwslCrsCrt = pyPwslCrsCrtCollection.getPyPwslCrsCrt();
						if (pyPwslCrsCrt != null) {
							pyPwslCrsCrtMapper.save(pyPwslCrsCrt);
						}
						PyPwslCrsCrtPwls pyPwslCrsCrtPwls = pyPwslCrsCrtCollection.getPyPwslCrsCrtPwls();
						if (pyPwslCrsCrtPwls != null) {
							pyPwslCrsCrtPwlsMapper.save(pyPwslCrsCrtPwls);
						}
						PyPwslCrsCrtPwlsItm pyPwslCrsCrtPwlsItm = pyPwslCrsCrtCollection.getPyPwslCrsCrtPwlsItm();
						if (pyPwslCrsCrtPwlsItm != null) {
							pyPwslCrsCrtPwlsItmMapper.save(pyPwslCrsCrtPwlsItm);
						}
						List<PyPwslCrsCrtQcs> pyPwslCrsCrtQcsList = pyPwslCrsCrtCollection.getPyPwslCrsCrtQcsList();
						if (pyPwslCrsCrtQcsList != null && pyPwslCrsCrtQcsList.size()>0) {
							for(PyPwslCrsCrtQcs pyPwslCrsCrtQcs:pyPwslCrsCrtQcsList){
								pyPwslCrsCrtQcsMapper.save(pyPwslCrsCrtQcs);
							}
							
						}
					}
					return 1;
				} catch (Exception e) {
					logger.error("[区域数据-深圳-鹏元-个人高信分] 持久化解析后返回报文异常{}", e.getMessage());
					e.printStackTrace();
				}
			}
		}
		return 0;
	}

	@Override
	public int save(PyPwslMsgResponse pyPwslMsgResponse) {
		if (pyPwslMsgResponse != null) {
			try {
				return pyPwslMsgResponseMapper.save(pyPwslMsgResponse);
			} catch (Exception e) {
				logger.error("[区域数据-深圳-鹏元-个人高信分] 持久化返回报文异常{}", e.getMessage());
				e.printStackTrace();
			}
		}
		return 0;
	}

	@Override
	public String findMsgByRequest(String name, String certNo) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("name", name);
		parameters.put("certNo", certNo);
		try {
			List<String> list = pyPwslMsgResponseMapper.findMsgByRequest(parameters);
			if (list.size() > 0) {
				return list.get(0);
			}
		} catch (Exception e) {
			logger.error("[区域数据-深圳-鹏元-个人高信分] 查找返回异常{}", e.getMessage());
			e.printStackTrace();
		}
		return null;
	}

}
