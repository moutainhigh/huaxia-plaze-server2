package com.huaxia.plaze.modules.qyhy.service;

import com.huaxia.plaze.modules.qyhy.domain.QyhyInfo;

public interface QyhyInfoService {
	/**
	 *@Title:saveQyhyInfoUpdateDataAdapterAction
	 *@Description:保存企业行业信息
	 *@param qyhyInfo
	 *@param uniqueRelid
	 *@param qyhyTaskType
	 *@author: chenmeng
	 *@Date:2019年3月27日上午10:32:51
	 */
	void saveQyhyInfoUpdateDataAdapterAction(QyhyInfo qyhyInfo,String uniqueRelid,String crtUser)throws Exception;
	
}
