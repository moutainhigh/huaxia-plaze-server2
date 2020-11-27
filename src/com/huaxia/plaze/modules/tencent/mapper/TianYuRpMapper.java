package com.huaxia.plaze.modules.tencent.mapper;

import java.util.Map;

public interface TianYuRpMapper {

	/**
	 *@Title:insertResponseInfo
	 *@Description:保存百融返回信息 报文体(4000长度内)
	 *@param params
	 *@author: wss
	 *@Date:2019年3月25日下午5:03:23
	 */
	void insertResponseInfo(Map<String, String> params);
	
}
