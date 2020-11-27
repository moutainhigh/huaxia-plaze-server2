package com.huaxia.plaze.modules.yilianzhong.mapper;

import java.util.List;
import java.util.Map;

import com.huaxia.plaze.modules.yilianzhong.domain.YlzMsgResponse;

public interface YlzMsgResponseMapper {

	/**
	 * 保存报响应报文体
	 * @param ylzMsgResponse
	 * @return
	 */
	int save(YlzMsgResponse ylzMsgResponse);
	
	/**
	 * 根据被查询人的姓名和证件号查找返回报文
	 * @param parameters
	 * @return
	 */
	List<String> getYlzMsgResponseByParm(Map<String,Object> parameters);
}
