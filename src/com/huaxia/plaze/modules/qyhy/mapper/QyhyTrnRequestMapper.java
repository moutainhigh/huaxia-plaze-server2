package com.huaxia.plaze.modules.qyhy.mapper;

import java.util.List;
import java.util.Map;

import com.huaxia.plaze.modules.qyhy.domain.QyhyTrnRequestParameters;

public interface QyhyTrnRequestMapper {
	/**
	 *@Title:insertQyhyRequestParammeters
	 *@Description:保存企业行业交易请求
	 *@param parameters
	 *@author: chenmeng
	 * @return 
	 *@Date:2019年3月25日下午4:19:00
	 */
	int insertQyhyRequestParammeters(QyhyTrnRequestParameters parameters);
	/**
	 *@Title:selectQyhyParamList
	 *@Description:获取企业行业公司中文名称和身份证号码这两个参数
	 *@param trnId
	 *@author: chenmeng
	 * @return 
	 *@Date:2019年3月28日下午18:00:00
	 */
	List<Map<String, String>> selectQyhyParamList(String trnId);
	
	String selectHistoryReport(String enterprise);

}
