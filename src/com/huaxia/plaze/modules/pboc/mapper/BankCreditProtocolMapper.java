package com.huaxia.plaze.modules.pboc.mapper;

import java.util.List;

import com.huaxia.plaze.modules.pboc.domain.pca.PD02A;
import com.huaxia.plaze.modules.pboc.domain.pca.PD02ZH;
import com.huaxia.plaze.modules.pboc.domain.pca.PD02Zdata;


/**
 * 1.12 授信协议信息 PCA  [1..1]  
 * @author gaoh
 *
 */
public interface BankCreditProtocolMapper {
	/**
	 *@Title:insertCreditProtocolBasicInfo
	 *@Description:保存 基本信息段 PD02A
	 *@param pd02a 基本信息段
	 *@author: gaohui
	 *@Date:2018年10月8日下午3:21:18
	 */
	void insertCreditProtocolBasicInfo(PD02A pd02a);
	/**
	 *@Title:insertCreditProtocolPcaLabelState
	 *@Description:保存 授信协议信息的标注及声明信息段 PD02Z/PD02Zdata
	 *@param pd02zData
	 *@author: gaohui
	 *@Date:2018年10月9日下午2:17:27
	 */
	void insertCreditProtocolPcaLabelState(PD02Zdata pd02zData);
	/**
	 *@Title:insertCreditProtocolPcaLabelStateInfoList
	 *@Description:保存授信协议信息的标注及声明信息 PD02Z/PD02ZH 的集合
	 *@param pd02zhList 授信协议信息的标注及声明信息
	 *@author: gaohui
	 *@Date:2018年10月9日下午2:29:44
	 */
	void insertCreditProtocolPcaLabelStateInfoList(List<PD02ZH> pd02zhList);
}
