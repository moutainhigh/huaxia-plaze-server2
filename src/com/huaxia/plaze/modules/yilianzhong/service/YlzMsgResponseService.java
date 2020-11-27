package com.huaxia.plaze.modules.yilianzhong.service;

import java.util.List;

import com.huaxia.plaze.modules.yilianzhong.domain.YlzMsgResponse;

public interface YlzMsgResponseService {

	/**
	 * 保存报响应报文体
	 * @param ylzMsgResponse
	 * @return
	 */
	int save(YlzMsgResponse ylzMsgResponse);
	
	/**
	 * 根据被查询人的姓名和证件号查找返回报文
	 * @param name 被查询人姓名
	 * @param certNo 被查询人证件号
	 * @return
	 */
	String getYlzMsgResponseByParm(String name,String certNo);
}
