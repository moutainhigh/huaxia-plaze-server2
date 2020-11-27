package com.huaxia.plaze.modules.hnair.service;


import com.huaxia.plaze.modules.hnair.domain.Hnair;

/**
 * 海航 
 * 
 * @author gaohui 
 *
 */
public interface HnairService {
	/**
	 * @Title: save
	 *@Description: TODO
	 *@param seaAir
	 *@author: LiuWei
	 *@Date: 2019年4月3日下午5:06:58
	 */
	void save(Hnair seaAir);
	/**
	 * @Title: getCountByAppId
	 *@Description: TODO
	 *@param appId
	 *@return
	 *@author: LiuWei
	 *@Date: 2019年4月3日下午5:07:07
	 */
	int getCountByAppId(String appId);
	
}
