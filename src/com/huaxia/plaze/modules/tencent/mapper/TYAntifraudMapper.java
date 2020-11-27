package com.huaxia.plaze.modules.tencent.mapper;

import java.util.List;

import com.huaxia.plaze.modules.tencent.domain.TYAntifraudData;
import com.huaxia.plaze.modules.tencent.domain.TYAntifraudRiskInfo;

public interface TYAntifraudMapper {
	/**
	 *@Title:insertTyData
	 *@Description:插入天御分主表数据
	 *@param tyAntifraudData
	 *@author: wss
	 *@Date:2019年3月26日14:24:39
	 */
	void insertTyData(TYAntifraudData tyAntifraudData);
	/**
	 *@Title:insertBatchTyRisk
	 *@Description:批量插入天御分风险代码数据
	 *@param listTYAntifraudRiskInfo
	 *@author: wss
	 *@Date:2019年3月26日14:24:51
	 */
	void insertBatchTyRisk(List<TYAntifraudRiskInfo> listTYAntifraudRiskInfo);
}
