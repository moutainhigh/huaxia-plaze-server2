package com.huaxia.plaze.modules.tencent.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.huaxia.plaze.modules.tencent.domain.TYAntifraud;
import com.huaxia.plaze.modules.tencent.domain.TYAntifraudData;
import com.huaxia.plaze.modules.tencent.domain.TYAntifraudRiskInfo;
import com.huaxia.plaze.modules.tencent.mapper.TYAntifraudMapper;
import com.huaxia.plaze.modules.tencent.service.TYAntifraudService;

@Service("tyAntifraudService")
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class TYAntifraudServiceImpl  implements TYAntifraudService {
	private final static Logger logger = LoggerFactory.getLogger(TYAntifraudServiceImpl.class);

	@Autowired
	private TYAntifraudMapper tyAntifraudDao;
	
	public TYAntifraudMapper getTyAntifraudDao() {
		return tyAntifraudDao;
	}

	public void setTyAntifraudDao(TYAntifraudMapper tyAntifraudDao) {
		this.tyAntifraudDao = tyAntifraudDao;
	}

	@Override
	public void save(TYAntifraud tyAntifraud) {
		//保存天御分主表信息TIANYU_ANTIFRAUD_BASE 
		TYAntifraudData tyAntifraudData=tyAntifraud.getTyAntifraudData();
		tyAntifraudDao.insertTyData(tyAntifraudData);
		List<TYAntifraudRiskInfo> listTYAntifraudRiskInfo=tyAntifraud.getListTYAntifraudRiskInfo();
		// 设置天御分主表对应分表信息
		for (TYAntifraudRiskInfo tyAntifraudRiskInfo : listTYAntifraudRiskInfo) {
			tyAntifraudRiskInfo.setCertNo(tyAntifraudData.getCertNo());
			tyAntifraudRiskInfo.setTrnId(tyAntifraudData.getTrnId());
			tyAntifraudRiskInfo.setCrtUser(tyAntifraudData.getCrtUser());
		}
		// 保存天御分对应主表的风险码信息 TIANYU_ANTIFRAUD_RISKINFO 
		if(listTYAntifraudRiskInfo!=null&&!listTYAntifraudRiskInfo.isEmpty()&&listTYAntifraudRiskInfo.size()>0){
			tyAntifraudDao.insertBatchTyRisk(listTYAntifraudRiskInfo);
		}
	}
}