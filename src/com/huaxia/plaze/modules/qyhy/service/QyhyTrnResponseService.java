package com.huaxia.plaze.modules.qyhy.service;

import com.huaxia.plaze.modules.qyhy.domain.QyhyResponseParameters;

public interface QyhyTrnResponseService {
	/**
	 * @title 保存响应参数
	 * @param trnResponseParameter
	 * @author chenmeng
	 * @Data 2019年3月28日下午2点20分35秒
	 */
	int save(QyhyResponseParameters trnResponseParameter);
	/**
	 * @title 获取响应报文
	 * @param enterprise
	 * @param certNo
	 * @param trnId
	 * @author chenmeng
	 * @Data 2019年3月28日下午2点45分12秒
	 */
	String findResponseByRequest(String enterprise,String certNo,String trnId);
	/**
	 * @title 保存原始报文
	 * @param trnResponseParameters
	 * @author chenmeng
	 * @return 
	 * @Data 2019年3月29日下午2点24分12秒
	 */
	int saveBodyOriginal(QyhyResponseParameters trnResponseParameters);
}
