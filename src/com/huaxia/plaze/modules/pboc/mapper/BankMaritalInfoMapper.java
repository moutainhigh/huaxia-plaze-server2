package com.huaxia.plaze.modules.pboc.mapper;

import com.huaxia.plaze.modules.pboc.domain.pmm.PB02;

/**
 * 1.3 婚姻信息 PMM 
 * @author gaoh
 *
 */
public interface BankMaritalInfoMapper {
	/**
	 *@Title:insertMaritalInfo
	 *@Description:保存 婚姻信息单元 PB02 
	 *@param pb02 婚姻信息单元
	 *@author: gaohui
	 *@Date:2018年12月3日上午11:20:12
	 */
	void insertMaritalInfo(PB02 pb02);
}
