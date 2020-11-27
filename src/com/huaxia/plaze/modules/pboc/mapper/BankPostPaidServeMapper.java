package com.huaxia.plaze.modules.pboc.mapper;

import java.util.List;

import com.huaxia.plaze.modules.pboc.domain.pnd.PE01A;
import com.huaxia.plaze.modules.pboc.domain.pnd.PE01ZH;
import com.huaxia.plaze.modules.pboc.domain.pnd.PE01Zdata;



/**
 *  1.14 后付费业务信息 PND 
 * @author gaoh
 *
 */
public interface BankPostPaidServeMapper {
	/**
	 *@Title:insertPostPaidServeInfo
	 *@Description:保存后付费业务信息 PE01A
	 *@param pe01a 后付费业务信息
	 *@author: gaohui
	 *@Date:2018年10月11日下午1:57:55
	 */
	void insertPostPaidServeInfo(PE01A pe01a);
	/**
	 *@Title:insertPostPaidServePndLabelState
	 *@Description:保存后付费业务信息 的标注及声明信息段 PE01Z/pe01zData 
	 *@param pe01zData 标注及声明信息段 
	 *@author: gaohui
	 *@Date:2018年10月11日下午2:38:06
	 */
	void insertPostPaidServePndLabelState(PE01Zdata pe01zData);
	/**
	 *@Title:insertPostPaidServePndLabelStateInfoList
	 *@Description:保存后付费业务信息 的标注及声明信息PE01Z/PE01ZH集合
	 *@param pe01zhList 标注及声明信息PE01Z
	 *@author: gaohui
	 *@Date:2018年10月11日下午3:11:11
	 */
	void insertPostPaidServePndLabelStateInfoList(List<PE01ZH> pe01zhList);
}
