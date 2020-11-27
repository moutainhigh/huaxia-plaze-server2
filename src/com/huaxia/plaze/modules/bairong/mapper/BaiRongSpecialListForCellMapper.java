package com.huaxia.plaze.modules.bairong.mapper;

import com.huaxia.plaze.modules.bairong.domain.BRZX;
import com.huaxia.plaze.modules.bairong.domain.BRZXSpecialListForCell;

public interface BaiRongSpecialListForCellMapper {

	/**
	 *@Title:insert
	 *@Description:保存特殊名单核查信息（手机号）
	 *@param specialList
	 *@return
	 *@author: wss
	 *@Date:2019年3月27日下午1:53:19
	 */
	int insert(BRZX specialList);
	
	/**
	 *@Title:selectSpecialListForCellByFkUuid
	 *@Description:根据fkUuid查询对应的特殊名单核查信息对象
	 *@param fkUuid
	 *@return
	 *@author: wss
	 *@Date:2019年3月27日下午1:54:20
	 */
	BRZXSpecialListForCell selectSpecialListForCellByFkUuid(String fkUuid);
}
