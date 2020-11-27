package com.huaxia.plaze.modules.bairong.mapper;

import com.huaxia.plaze.modules.bairong.domain.BRZX;

public interface BaiRongSpecialListForCidMapper {
	
	/**
	 * @Title:insert
	 *@Description:保存特殊名单核查信息（身份证号）
	 *@param specialListForId 特殊名单核查对象
	 *@return 
	 *@author: wss
	 *@Date:2019年3月25日下午12:29:45
	 */
	int insert(BRZX specialList);
}
