package com.huaxia.plaze.modules.hz.service;

import com.huaxia.plaze.modules.hz.domain.HzCollection;
import com.huaxia.plaze.modules.hz.domain.HzMsgResponse;
import com.huaxia.plaze.modules.hz.domain.HzTrnRequest;

/**
 * 
 * @author dingguofeng
 * 杭州区域数据service
 *
 */
public interface HzService {
	
	/**
	 * 保存渠道请求参数入库
	 */
	void saveHzTrnRequest(HzTrnRequest hzTrnRequest);
	
	/**
	 * 保存数据源返回的原报文
	 */
	void saveHzMsgResponse(HzMsgResponse hzMsgResponse);
	
	/**
	 * 将报文封装实体类插入数据表
	 */
	void saveHzCollection(HzCollection hzCollection);
	
	String finBody(String certNo);

}
