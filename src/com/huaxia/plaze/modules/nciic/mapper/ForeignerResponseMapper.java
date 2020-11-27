package com.huaxia.plaze.modules.nciic.mapper;

import java.util.Map;

import com.huaxia.plaze.modules.nciic.domain.NciicForeignerInfo;
import com.huaxia.plaze.modules.nciic.domain.NciicForeignerResponse;

public interface ForeignerResponseMapper {
	/**
	 * 保存外国人永久居留证信息核查服务结果
	 * @param info
	 * @return
	 */
	int insertInfo(NciicForeignerInfo info);
	/**
	 * 保存外国人永久居留证信息核查服务响应原始报文
	 * @param msg
	 */
	int insertResponse(NciicForeignerResponse msg);
	/**
	 * queryModel=2 根据请求从三方库中查找原始报文
	 * @param parameters
	 * @return
	 */
	String selectResponseByRequest(Map<String, Object> parameters);
}
