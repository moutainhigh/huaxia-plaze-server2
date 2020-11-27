package com.huaxia.plaze.modules.yilianzhong.mapper;

import com.huaxia.plaze.modules.yilianzhong.domain.YlzTrnRequest;

public interface YlzTrnRequestMapper {

	/**
	 * 保存解析后的请求报文
	 * @param ylzTrnRequest
	 * @return
	 */
	int save(YlzTrnRequest ylzTrnRequest);
}
