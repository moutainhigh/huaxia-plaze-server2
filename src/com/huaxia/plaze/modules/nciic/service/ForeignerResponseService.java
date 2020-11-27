package com.huaxia.plaze.modules.nciic.service;

import com.huaxia.plaze.modules.nciic.domain.NciicForeignerInfo;

public interface ForeignerResponseService {

	/**
	 * 持久化dmz响应报文
	 * @param hdMoblResponse
	 * @return
	 */
	int save(NciicForeignerInfo nciicForeignerInfo);
	/**
	 * 外国人永久居留证信息，queryModel = 2,查找原始报文
	 * @param name 姓名
	 * @param certNo 证件号码
	 * @return
	 */
	String queryResponseByRequest(String name, String certNo,String birth,String expiryDate);
}
