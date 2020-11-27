package com.huaxia.plaze.modules.nciic.mapper;

import java.util.Map;

import com.huaxia.plaze.modules.nciic.domain.NciicXpInfo;
import com.huaxia.plaze.modules.nciic.domain.NciicXpResponse;

public interface PoliceResponseMapper {
	/**
	 * 保存人像比对结果
	 * @param info
	 * @return
	 */
	int insertInfo(NciicXpInfo info);
	/**
	 * 保存人像对比响应原始报文
	 * @param msg
	 */
	int insertResponse(NciicXpResponse msg);
	/**
	 * queryModel=2 根据请求从三方库中查找原始报文
	 * @param parameters
	 * @return
	 */
	String selectResponseByRequest(Map<String, Object> parameters);
}
