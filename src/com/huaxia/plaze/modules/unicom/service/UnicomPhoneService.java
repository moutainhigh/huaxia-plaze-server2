package com.huaxia.plaze.modules.unicom.service;

import com.huaxia.plaze.modules.unicom.domain.UnicomPhone;
import com.huaxia.plaze.modules.unicom.domain.UnicomPhoneMsgResponse;
import com.huaxia.plaze.modules.unicom.domain.UnicomPhoneTrnRequest;

/**
 * 
 * @author dingguofeng
 * 联通手机实名制service
 *
 */
public interface UnicomPhoneService {
	
	/**
	 * 保存渠道请求参数入库
	 */
	void saveUnicomPhoneTrnRequest(UnicomPhoneTrnRequest unicomPhoneTrnRequest);
	
	/**
	 * 保存数据源返回的原报文
	 */
	void saveUnicomPhoneMsgResponse(UnicomPhoneMsgResponse unicomPhoneMsgResponse);
	
	/**
	 * 将报文封装实体类插入数据表
	 */
	void saveUnicomPhone(UnicomPhone unicomPhone);

}
