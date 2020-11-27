package com.huaxia.plaze.modules.pboc.mapper;

import java.util.List;

import com.huaxia.plaze.modules.pboc.domain.pos.PG010H;
import com.huaxia.plaze.modules.pboc.domain.pos.PG01data;


/**
 * 1.23 其他标注及声明信息 POS
 * @author gaoh
 *
 */
public interface BankOtherLabelStateMapper {
	/**
	 *@Title:insertOtherLabelState
	 *@Description:保存其他标注及声明信息单元 PG01/PG01data
	 *@param pg01Data 标注及声明信息单元
	 *@author: gaohui
	 *@Date:2018年10月15日下午4:41:39
	 */
	void insertOtherLabelState(PG01data pg01Data);
	/**
	 *@Title:insertOtherLabelStateInfoList
	 *@Description:保存 其他标注及声明信息  PG01/PG010H 集合
	 *@param pg010hList 其他标注及声明信息  PG01/PG010H 集合
	 *@author: gaohui
	 *@Date:2018年10月15日下午4:48:31
	 */
	void insertOtherLabelStateInfoList(List<PG010H> pg010hList);
}
