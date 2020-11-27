package com.huaxia.plaze.modules.pboc.mapper;

import java.util.List;

import com.huaxia.plaze.modules.pboc.domain.pbs.PF06A;
import com.huaxia.plaze.modules.pboc.domain.pbs.PF06ZH;
import com.huaxia.plaze.modules.pboc.domain.pbs.PF06Zdata;


/**
 *  1.20 低保救助记录 PBS 
 * @author gaoh
 *
 */
public interface BankLowIncomeSalveRecordMapper {
	/**
	 *@Title:insertLowIncomeSalveRecordInfo
	 *@Description:保存低保救助记录信息段 PF06A 
	 *@param pf06a 低保救助记录信息段
	 *@author: gaohui
	 *@Date:2018年10月15日上午9:56:18
	 */
	void insertLowIncomeSalveRecordInfo(PF06A pf06a);
	/**
	 *@Title:insertLowIncomeSalveRecordPbsLabelState
	 *@Description:保存低保救助记录信息的 标注及声明信息段 PF06Z/PF06Zdata
	 *@param PF06Zdata  标注及声明信息段 
	 *@author: gaohui
	 *@Date:2018年10月15日上午10:19:48
	 */
	void insertLowIncomeSalveRecordPbsLabelState(PF06Zdata PF06Zdata);
	/**
	 *@Title:insertLowIncomeSalveRecordPbsLabelStateInfoList
	 *@Description:保存低保救助记录信息的 标注及声明信息 PF06Z/PF06ZH 集合
	 *@param pf06zhList 标注及声明信息 PF06Z/PF06ZH 集合
	 *@author: gaohui
	 *@Date:2018年10月15日下午2:44:30
	 */
	void insertLowIncomeSalveRecordPbsLabelStateInfoList(List<PF06ZH> pf06zhList);
}
