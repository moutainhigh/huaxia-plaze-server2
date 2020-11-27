package com.huaxia.plaze.modules.nciic.service;

import com.huaxia.plaze.modules.nciic.domain.NciicXpRequest;

public interface PoliceRequestService {
	/**
	 * 保存公安人像对比 请求信息
	 * @param xpRequest
	 * @return
	 */
	public int save(NciicXpRequest xpRequest);
}
