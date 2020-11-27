package com.huaxia.plaze.modules.pboc.mapper;

import java.util.List;

import com.huaxia.plaze.modules.pboc.domain.ppq.PF07A;
import com.huaxia.plaze.modules.pboc.domain.ppq.PF07ZH;
import com.huaxia.plaze.modules.pboc.domain.ppq.PF07Zdata;



/**
 * 1.21 执业资格记录 PPQ   
 * @author gaoh
 *
 */
public interface BankPracticeQualifyRecordMapper {
	/**
	 *@Title:insertPracticeQualifyRecordInfo
	 *@Description:保存执业资格记录信息段 PF07A  
	 *@param pf07a 执业资格记录信息段
	 *@author: gaohui
	 *@Date:2018年10月15日下午3:03:07
	 */
	void insertPracticeQualifyRecordInfo(PF07A pf07a);
	/**
	 *@Title:insertPracticeQualifyRecordPpqLabelState
	 *@Description:保存执业资格记录的标注及声明信息段 PF07Z/PF07Zdata
	 *@param pf07zData 标注及声明信息段  
	 *@author: gaohui
	 *@Date:2018年10月15日下午3:25:29
	 */
	void insertPracticeQualifyRecordPpqLabelState(PF07Zdata pf07zData);
	/**
	 *@Title:insertPracticeQualifyRecordPpqLabelStateInfoList
	 *@Description:保存执业资格记录的标注及声明信息 PF07Z/PF07ZH 集合
	 *@param pf07zhList 标注及声明信息 PF07Z/PF07ZH 集合
	 *@author: gaohui
	 *@Date:2018年10月15日下午3:26:39
	 */
	void insertPracticeQualifyRecordPpqLabelStateInfoList(List<PF07ZH> pf07zhList);
}
