package com.huaxia.plaze.modules.nciic.service;

import com.huaxia.plaze.modules.nciic.domain.NciicXpInfo;

public interface PoliceResponseService {

	/**
	 * 持久化dmz响应报文
	 * @param hdMoblResponse
	 * @return
	 */
	int save(NciicXpInfo hdMoblResponse);
	/**
	 * 人像比对，queryModel = 2,查找原始报文
	 * @param name 姓名
	 * @param certNo 证件号码
	 * @return
	 */
	String queryResponseByRequest(String name,String certNo);
}
