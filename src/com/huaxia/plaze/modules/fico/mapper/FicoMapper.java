package com.huaxia.plaze.modules.fico.mapper;

import java.util.Map;

import com.huaxia.plaze.modules.fico.domain.Fico;;

public interface FicoMapper {

	int getCountByAppId(String appId);

	int insert(Fico fico);
	
	Fico selectConfirmPboc(String appId);
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
