package com.huaxia.plaze.modules.pboc.mapper;

import java.util.List;

import com.huaxia.plaze.modules.pboc.domain.pah.PF08A;
import com.huaxia.plaze.modules.pboc.domain.pah.PF08ZH;
import com.huaxia.plaze.modules.pboc.domain.pah.PF08Zdata;

/**
 * 1.22 行政奖励记录 PAH
 * 
 * @author gaoh
 *
 */
public interface BankAdministraAwardRecordMapper {
	/**
	 * @Title:insertAdministraAwardRecordInfo
	 * @Description:保存行政奖励记录信息段 PF08A
	 * @param pf08a
	 *            行政奖励记录信息段
	 * @author: gaohui
	 * @Date:2018年10月15日下午3:49:23
	 */
	void insertAdministraAwardRecordInfo(PF08A pf08a);

	/**
	 * @Title:insertAdministraAwardRecordPahLabelState
	 * @Description:保存行政奖励记录的标注及声明信息段 PF08Z/PF08Zdata
	 * @param pf08zData
	 *            标注及声明信息段
	 * @author: gaohui
	 * @Date:2018年10月15日下午4:12:18
	 */
	void insertAdministraAwardRecordPahLabelState(PF08Zdata pf08zData);

	/**
	 * @Title:insertAdministraAwardRecordPahLabelStateInfoList
	 * @Description:保存行政奖励记录的标注及声明信息 PF08Z/PF08ZH 集合
	 * @param pf08zhList
	 *            标注及声明信息 PF08Z/PF08ZH 集合
	 * @author: gaohui
	 * @Date:2018年10月15日下午4:21:47
	 */
	void insertAdministraAwardRecordPahLabelStateInfoList(List<PF08ZH> pf08zhList);
}
