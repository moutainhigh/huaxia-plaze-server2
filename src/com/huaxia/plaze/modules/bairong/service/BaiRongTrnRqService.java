package com.huaxia.plaze.modules.bairong.service;

import java.util.Map;

public interface BaiRongTrnRqService {

	/**
	 *@Title:saveRqInfo
	 *@Description:保存百融交易请求
	 *@param params
	 *@author: wss
	 *@Date:2019年3月25日上午9:38:35
	 */
	void saveBrRqInfo(Map<String, String> params);
	
	/**
	 *@Title:findTrnIdByPkUuid
	 *@Description:根据TrnId查询pkUuid
	 *@param TrnId
	 *@return
	 *@author: wss
	 *@Date:2019年3月25日下午3:28:12
	 */
	String findPkUuidByTrnId(String TrnId);
}
