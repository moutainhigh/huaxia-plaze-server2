package com.huaxia.plaze.modules.qyhy.service;

import java.util.List;
import java.util.Map;

import com.huaxia.plaze.modules.qyhy.domain.QyhyTrnRequestParameters;

/**
 * 交易请求表 三方平台
 * @author chenmeng
 *
 */
public interface QyhyTrnRequestService {
	/**
	 *@Title:saveQyhyRequestParameters
	 *@Description:保存企业行业交易请求
	 *@param parameters
	 *@author: chenmeng
	 *@Date:2019年3月25日下午4:03:00
	 */
	int saveQyhyRequestParameters(QyhyTrnRequestParameters parameters);
	/**
	 *@Title:findQyhyParamList
	 *@Description:查找企业行业参数
	 *@param trnId 交易编号
	 *@author: chenmeng
	 *@Date:2019年3月28日下午18:03:00
	 */
	List<Map<String, String>> findQyhyParamList(String trnId);
	
	/** 30天逻辑,查询30天之内是否查询过企业行业数据 */
	String findHistoryReport(String enterprise);

}
