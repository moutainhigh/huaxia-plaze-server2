package com.huaxia.plaze.modules.pboc.mapper;

import java.util.List;

import com.huaxia.plaze.modules.pboc.domain.poq.PH01;


/**
 * 1.24 查询记录 POQ 
 * @author gaoh
 *
 */
public interface BankQueryRecordMapper {
	/**
	 *@Title:insertQueryRecordList
	 *@Description:保存查询记录信息单元 PH01 集合
	 *@param ph01List 查询记录信息单元 PH01 集合
	 *@author: gaohui
	 *@Date:2018年10月16日上午10:15:19
	 */
	void insertQueryRecordList(List<PH01> ph01List);
}
