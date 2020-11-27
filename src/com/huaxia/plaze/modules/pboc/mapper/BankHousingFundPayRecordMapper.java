package com.huaxia.plaze.modules.pboc.mapper;

import java.util.List;

import com.huaxia.plaze.modules.pboc.domain.phf.PF05A;
import com.huaxia.plaze.modules.pboc.domain.phf.PF05ZH;
import com.huaxia.plaze.modules.pboc.domain.phf.PF05Zdata;


/**
 * 1.19 住房公积金参缴记录 PHF  [1..1]
 * @author gaoh
 *
 */
public interface BankHousingFundPayRecordMapper {
	/**
	 *@Title:insertHousingFundPayRecordInfo
	 *@Description:保存 住房公积金参缴记录信息段 PF05A 
	 *@param pf05a住房公积金参缴记录信息段 
	 *@author: gaohui
	 *@Date:2018年10月13日下午4:29:23
	 */
	void insertHousingFundPayRecordInfo(PF05A pf05a);
	/**
	 *@Title:insertHousingFundPayRecordPfhLabelState
	 *@Description:保存住房公积金参缴记录的标注及声明信息段 PF05Z/PF05Zdata
	 *@param pf05zData 标注及声明信息段
	 *@author: gaohui
	 *@Date:2018年10月13日下午4:35:22
	 */
	void insertHousingFundPayRecordPfhLabelState(PF05Zdata pf05zData);
	/**
	 *@Title:insertHousingFundPayRecordPfhLabelStateInfoList
	 *@Description:保存住房公积金参缴记录的标注及声明信息 PF05Z/PF05ZH集合
	 *@param pf05zhList 标注及声明信息 PF05Z/PF05ZH集合
	 *@author: gaohui
	 *@Date:2018年10月13日下午4:53:41
	 */
	void insertHousingFundPayRecordPfhLabelStateInfoList(List<PF05ZH> pf05zhList);
}
