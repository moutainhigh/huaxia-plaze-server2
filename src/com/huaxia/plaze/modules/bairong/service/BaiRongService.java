package com.huaxia.plaze.modules.bairong.service;

import com.huaxia.plaze.modules.bairong.domain.BRZX;
import com.huaxia.plaze.modules.bairong.domain.BRZXSpecialListForCell;

public interface BaiRongService {
	
	/**
	 * @Title:save
	 *@Description:百融征信解析入库
	 *@param brzx 百融征信对象
	 *@return 
	 *@author: wss
	 *@Date:2019年3月25日11:26:55
	 */
	int save(BRZX brzx);

	/**
	 * @Title:saveSpecialListForId
	 *@Description:保存特殊名单核查信息（身份证号）
	 *@param specialListForId 特殊名单核查对象
	 *@return 
	 *@author: wss
	 *@Date:2019年3月25日11:26:59
	 */
	int saveSpecialListForId(BRZX specialListForId);

	/**
	 * @Title:saveSpecialListForCell
	 *@Description:保存特殊名单核查信息（手机）
	 *@param specialListForCell 特殊名单核查对象
	 *@return  
	 *@author: wss
	 *@Date:2019年3月25日11:27:07
	 */
	int saveSpecialListForCell(BRZX specialListForCell);

	/**
	 * @Title:saveSpecialListForLmCell
	 *@Description:保存特殊名单核查信息（联系人手机号）
	 *@param specialListForLm 特殊名单核查对象
	 *@return 
	 *@author: wss
	 *@Date:2019年3月25日11:27:10
	 */
	int saveSpecialListForLmCell(BRZX specialListForLm);
	
	/**
	 * 保存特殊名单核查信息（GID）
	 *@param specialListForGid
	 *@return 特殊名单核查对象
	 *@author: wss
	 *@Date:2019年3月25日11:27:19
	 */
	int saveSpecialListForGid(BRZX specialListForGid);
	
	/**
	 * @Title:saveSpecialListBase
	 *@Description:保存特殊名单信息到基库
	 *@param brzx 百融征信对象
	 *@return
	 *@author: wss
	 *@Date:2019年3月25日11:27:19
	 */
	int saveSpecialListBase(BRZX brzx);
	/**
	 *@Title:findSpecialListForCellByFkUuid
	 *@Description:根据fkUuid查询特殊信息
	 *@param fkUuid
	 *@return
	 *@author: wss
	 *@Date:2019年3月27日下午1:56:27
	 */
	BRZXSpecialListForCell findSpecialListForCellByFkUuid(String fkUuid);
}
