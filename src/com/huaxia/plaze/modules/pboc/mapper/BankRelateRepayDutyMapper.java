package com.huaxia.plaze.modules.pboc.mapper;

import java.util.List;

import com.huaxia.plaze.modules.pboc.domain.pcr.PD03A;
import com.huaxia.plaze.modules.pboc.domain.pcr.PD03ZH;
import com.huaxia.plaze.modules.pboc.domain.pcr.PD03Zdata;


/**
 * 1.13 相关还款责任信息 PCR 
 * @author gaoh
 *
 */
public interface BankRelateRepayDutyMapper {
	/**
	 *@Title:insertRelateRepayDutyInfo
	 *@Description:保存相关还款责任信息段  PD03A 
	 *@param pd03a 相关还款责任信息段 
	 *@author: gaohui
	 *@Date:2018年10月9日下午4:28:17
	 */
	void insertRelateRepayDutyInfo(PD03A pd03a);
	/**
	 *@Title:insertRelateRepayDutyPcrLabelState
	 *@Description:保存相关还款责任信息的标注及声明信息 PD03Z/PD03Zdata
	 *@param pd03zData
	 *@author: gaohui
	 *@Date:2018年10月9日下午6:11:17
	 */
	void insertRelateRepayDutyPcrLabelState(PD03Zdata pd03zData);
	/**
	 *@Title:insertRelateRepayDutyPcrLabelStateInfoList
	 *@Description:保存相关还款责任信息的标注及声明信息 PD03Z/PD03ZH 集合
	 *@param pd03zhList 标注及声明信息 集合
	 *@author: gaohui
	 *@Date:2018年10月9日下午6:16:36
	 */
	void insertRelateRepayDutyPcrLabelStateInfoList(List<PD03ZH> pd03zhList);
 
}
