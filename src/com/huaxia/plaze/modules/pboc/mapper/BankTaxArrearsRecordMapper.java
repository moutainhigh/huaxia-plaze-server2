package com.huaxia.plaze.modules.pboc.mapper;

import java.util.List;

import com.huaxia.plaze.modules.pboc.domain.pot.PF01A;
import com.huaxia.plaze.modules.pboc.domain.pot.PF01ZH;
import com.huaxia.plaze.modules.pboc.domain.pot.PF01Zdata;

/**
 * 1.15 欠税记录 POT  
 * @author gaoh
 *
 */
public interface BankTaxArrearsRecordMapper {
	/**
	 *@Title:insertTaxArrearsRecordInfo
	 *@Description:保存欠税记录信息PF01A
	 *@param pf01a 欠税记录信息
	 *@author: gaohui
	 *@Date:2018年10月11日下午4:02:17
	 */
	void insertTaxArrearsRecordInfo(PF01A pf01a);
	/**
	 *@Title:insertTaxArrearsRecordPotLabelState
	 *@Description:保存欠税记录的 标注及声明信息段 PF01Z/PF01Zdata
	 *@param pf01zData 标注及声明信息段数据
	 *@author: gaohui
	 *@Date:2018年10月11日下午4:23:19
	 */
	void insertTaxArrearsRecordPotLabelState(PF01Zdata pf01zData);
	/**
	 *@Title:insertTaxArrearsRecordPotLabelStateInfoList
	 *@Description:保存欠税记录的标注及声明信息 PF01Z/PF01ZH 集合
	 *@param pf01zhList 标注及声明信息PF01Z/PF01ZH 集合
	 *@author: gaohui
	 *@Date:2018年10月11日下午4:40:27
	 */
	void insertTaxArrearsRecordPotLabelStateInfoList(List<PF01ZH> pf01zhList);
}
