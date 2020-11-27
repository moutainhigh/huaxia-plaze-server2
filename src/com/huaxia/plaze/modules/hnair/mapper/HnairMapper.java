package com.huaxia.plaze.modules.hnair.mapper;

import com.huaxia.plaze.modules.hnair.domain.Hnair;

public interface HnairMapper {
	/**
	 * @Title: insertSeaAirData
	 *@Description: TODO
	 *@param seaAir
	 *@author: LiuWei
	 *@Date: 2019年4月3日下午4:51:59
	 */
	void insertSeaAirData(Hnair seaAir);
	/**
	 * @Title: selectCountByAppId
	 *@Description: TODO
	 *@param appId
	 *@return
	 *@author: LiuWei
	 *@Date: 2019年4月3日下午4:51:55
	 */
	int selectCountByAppId(String appId);
}
