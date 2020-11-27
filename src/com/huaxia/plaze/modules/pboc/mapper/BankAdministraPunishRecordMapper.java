package com.huaxia.plaze.modules.pboc.mapper;

import java.util.List;

import com.huaxia.plaze.modules.pboc.domain.pap.PF04A;
import com.huaxia.plaze.modules.pboc.domain.pap.PF04ZH;
import com.huaxia.plaze.modules.pboc.domain.pap.PF04Zdata;


/**
 * 1.18 行政处罚记录 PAP  
 * @author gaoh
 *
 */
public interface BankAdministraPunishRecordMapper {
	/**
	 *@Title:insertAdministraPunishRecordInfo
	 *@Description:保存行政处罚记录信息段 PF04A
	 *@param pf04 行政处罚记录信息段
	 *@author: gaohui
	 *@Date:2018年10月13日下午3:07:18
	 */
	void insertAdministraPunishRecordInfo(PF04A pf04a);
	/**
	 *@Title:insertAdministraPunishRecordPapLabelState
	 *@Description:保存 行政处罚记录的标注及声明信息段 PF04Z/PF04Zdata
	 *@param pf04zData标注及声明信息段 
	 *@author: gaohui
	 *@Date:2018年10月13日下午3:27:09
	 */
	void insertAdministraPunishRecordPapLabelState(PF04Zdata pf04zData);
	/**
	 *@Title:insertAdministraPunishRecordPapLabelStateInfoList
	 *@Description:保存 行政处罚记录的标注及声明信息 PF04Z/PF04ZH 集合 
	 *@param pf04zhList 标注及声明信息 PF04Z/PF04ZH 集合
	 *@author: gaohui
	 *@Date:2018年10月13日下午3:45:27
	 */
	void insertAdministraPunishRecordPapLabelStateInfoList(List<PF04ZH> pf04zhList);
}
