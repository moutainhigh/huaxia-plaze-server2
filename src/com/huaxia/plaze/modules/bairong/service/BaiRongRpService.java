package com.huaxia.plaze.modules.bairong.service;

import java.util.Map;

public interface BaiRongRpService {

	/**
	 *@Title:saveResponseInfo
	 *@Description:保存百融响应信息 报文体(4000长度内)
	 *@param params
	 *@author: wss
	 *@Date:2019年3月25日下午4:58:55
	 */
	void saveResponseInfo(Map<String, String> params);
}
