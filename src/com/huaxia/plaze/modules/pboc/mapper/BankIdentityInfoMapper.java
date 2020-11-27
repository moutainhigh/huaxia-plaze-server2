package com.huaxia.plaze.modules.pboc.mapper;

import java.util.List;

import com.huaxia.plaze.modules.pboc.domain.pim.PB01A;
import com.huaxia.plaze.modules.pboc.domain.pim.PB01BH;
import com.huaxia.plaze.modules.pboc.domain.pim.PB01Bdata;

/**
 * 1.2 身份信息 PIM   
 * @author gaoh
 *
 */
public interface BankIdentityInfoMapper {
	
	/**
	 *@Title:insertIdentityProfile
	 *@Description:保存  基本概况信息段 PB01A 
	 *@param pb01a
	 *@author: gaohui
	 *@Date:2018年12月3日上午10:09:36
	 */
	void insertIdentityProfile(PB01A pb01a);
	/**
	 *@Title:insertPhoneNumberData
	 *@Description:保存手机号码信息段数据
	 *@param pb01bData 手机号码信息段数据PB01B/PB01Bdata
	 *@author: gaohui
	 *@Date:2018年9月6日上午8:48:55
	 */
	void insertPhoneNumberData(PB01Bdata pb01bData);
	/**
	 *@Title:insertPhoneNumberDetailList
	 *@Description:保存 手机号码信息list集合
	 *@param pb01bhList
	 *@author: gaohui
	 *@Date:2018年9月6日上午9:28:35
	 */
	void insertPhoneNumberDetailList(List<PB01BH> pb01bhList);
}
