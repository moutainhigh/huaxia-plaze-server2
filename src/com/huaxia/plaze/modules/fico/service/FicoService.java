package com.huaxia.plaze.modules.fico.service;

import java.util.Map;

import com.huaxia.plaze.modules.fico.domain.Fico;


public interface FicoService {
	

	String  test(String params);
	
	
	int getCountByAppId(String appId);
	

	int save(Fico fico);
	
	Fico selectConfirmPboc(String appid);
	/**
	 *@Title:saveFicoUpdateDataAdapterAction
	 *@Description:Fico 大数据评分 入库
	 *@param fico
	 *@param appId
	 *@param ficoTaskType
	 *@author: gaohui
	 *@Date:2018年4月17日下午4:27:27
	 */
	
	void saveFicoUpdateDataAdapterAction(Fico fico,String appId,String ficoTaskType);
	/**
	 *@Title:selectBizInpApplC1JudgeFlag
	 *@Description:获取申请件的主卡判断标识（YDJ_FLAG, MATCHING_CARD_FLAG ）
	 *@param params
	 *@return
	 *@author: gaohui
	 *@Date:2018年8月30日上午9:07:15
	 */

	Map<String,String> selectBizInpApplC1JudgeFlag(Map<String,String> params);
}