package com.huaxia.plaze.modules.pboc.mapper;

import java.util.List;

import com.huaxia.plaze.modules.pboc.domain.psm.PC01data;
import com.huaxia.plaze.modules.pboc.domain.psm.PC01scoreEle;

/**
 *  1.6 评分信息 PSM 
 * @author gaoh
 *
 */
public interface BankScoreInfoMapper {
	/**
	 *@Title:insertScoreInfoDao
	 *@Description: 保存评分信息单元数据 PC01/PC01data
	 *@param pc01Data 评分信息单元数据
	 *@author: gaohui
	 *@Date:2018年9月7日上午9:33:34
	 */
	void insertScoreInfo(PC01data pc01Data);
	/**
	 *@Title:insertScoreEleList
	 *@Description:保存分数说明信息  PC01/PC010D01
	 *@param scoreEleList
	 *@author: gaohui
	 *@Date:2018年9月7日上午9:45:58
	 */
	void insertScoreEleList(List<PC01scoreEle> scoreEleList);
}
