package com.huaxia.plaze.modules.pboc.mapper;

import java.util.List;

import com.huaxia.plaze.modules.pboc.domain.pcj.PF02A;
import com.huaxia.plaze.modules.pboc.domain.pcj.PF02ZH;
import com.huaxia.plaze.modules.pboc.domain.pcj.PF02Zdata;


/**
 * 1.16 民事判决记录 PCJ 
 * @author gaoh
 *
 */
public interface BankCivilJudgeRecordMapper {
	/**
	 *@Title:insertCivilJudgeRecordInfo
	 *@Description:保存 民事判决记录信息段 PF02A 
	 *@param pf02a  民事判决记录信息段 
	 *@author: gaohui
	 *@Date:2018年10月12日下午2:59:40
	 */
	void insertCivilJudgeRecordInfo(PF02A pf02a);
	/**
	 *@Title:insertCivilJudgeRecordPcjLabelState
	 *@Description:保存 民事判决记录的标注及声明信息段PF02Z/PF02Zdata
	 *@param pf02zData 标注及声明信息段
	 *@author: gaohui
	 *@Date:2018年10月12日下午3:08:41
	 */
	void insertCivilJudgeRecordPcjLabelState(PF02Zdata pf02zData);
	/**
	 *@Title:insertCivilJudgeRecordPcjLabelStateInfoList
	 *@Description:保存 民事判决记录的 标注及声明信息 PF02Z/PF02ZH集合
	 *@param pf02zhList 民事判决记录的 标注及声明信息
	 *@author: gaohui
	 *@Date:2018年10月12日下午4:28:15
	 */
	void insertCivilJudgeRecordPcjLabelStateInfoList(List<PF02ZH> pf02zhList);
}
