package com.huaxia.plaze.modules.yilianzhong.mapper;

import com.huaxia.plaze.modules.yilianzhong.domain.YlzRepData;

public interface YlzRepDataMapper {

	/**
	 * 保存解析后的返回报文
	 * @param ylzRepData
	 * @return
	 */
	int save(YlzRepData ylzRepData);
}
