package com.huaxia.plaze.modules.pboc.mapper;

import java.util.List;

import com.huaxia.plaze.modules.pboc.domain.pce.PF03A;
import com.huaxia.plaze.modules.pboc.domain.pce.PF03ZH;
import com.huaxia.plaze.modules.pboc.domain.pce.PF03Zdata;


/**
 * 1.17 强制执行记录 PCE   
 * @author gaoh
 *
 */
public interface BankForceExecuteRecordMapper {
	/**
	 *@Title:insertForceExecuteRecordInfo
	 *@Description:保存强制执行记录信息段 PF03A
	 *@param pf03a 强制执行记录信息段 
	 *@author: gaohui
	 *@Date:2018年10月12日下午4:51:35
	 */
	void insertForceExecuteRecordInfo(PF03A pf03a);
	/**
	 *@Title:insertForceExecuteRecordPceLabelState
	 *@Description:保存强制执行记录的 标注及声明信息段 PF03Z/PF03Zdata
	 *@param pf03zData 标注及声明信息段 
	 *@author: gaohui
	 *@Date:2018年10月13日上午11:05:40
	 */
	void insertForceExecuteRecordPceLabelState(PF03Zdata pf03zData);
	/**
	 *@Title:insertForceExecuteRecordPceLabelStateInfoList
	 *@Description:保存强制执行记录的标注及声明信息 PF03Z/PF03ZH 集合
	 *@param pf03zhList 标注及声明信息集合
	 *@author: gaohui
	 *@Date:2018年10月13日下午2:06:43
	 */
	void insertForceExecuteRecordPceLabelStateInfoList(List<PF03ZH> pf03zhList);
}
