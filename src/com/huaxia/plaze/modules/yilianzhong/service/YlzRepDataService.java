package com.huaxia.plaze.modules.yilianzhong.service;

import com.huaxia.plaze.modules.yilianzhong.domain.YlzRepData;

public interface YlzRepDataService {

	/**
	 * 保存解析后的返回报文
	 * @param ylzRepData
	 * @return
	 */
	int save(YlzRepData ylzRepData);
}
