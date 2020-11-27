package com.huaxia.plaze.modules.bairong.mapper;

import java.util.Map;

public interface BaiRongTrnRqMapper {
	
	/**
	 *@Title:insertRqInfo
	 *@Description:保存百融交易请求
	 *@param params
	 *@author: wss
	 *@Date:2019年3月25日上午9:40:42
	 */
	void insertRqInfo(Map<String, String> params);
	/**
	 *@Title:selectpkUuidByTrnId
	 *@Description:根据TrnId获取pkUuid
	 *@param TrnId
	 *@return
	 *@author: wss
	 *@Date:2019年3月25日下午3:29:40
	 */
	String selectPkUuidByTrnId(String TrnId);
}
