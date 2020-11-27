package com.huaxia.plaze.modules.unicom.service;

import java.util.List;

import com.huaxia.plaze.modules.bairong.domain.ApplyLoanStrMsgResponse;
import com.huaxia.plaze.modules.unicom.domain.UnicomOnline;
import com.huaxia.plaze.modules.unicom.domain.UnicomOnlineMsgResponse;
import com.huaxia.plaze.modules.unicom.domain.UnicomOnlineTrnRequest;

/**
 * 
 * @author dingguofeng
 * 联通在网时长service
 *
 */
public interface UnicomOnlineService {
	
	/**
	 * 保存渠道请求参数入库
	 */
	void saveUnicomOnlineTrnRequest(UnicomOnlineTrnRequest unicomOnlineTrnRequest);
	
	/**
	 * 保存数据源返回的原报文
	 */
	int saveUnicomOnlineMsgResponse(UnicomOnlineMsgResponse unicomOnlineMsgResponse);
	
	/**
	 * 将报文封装实体类插入数据表
	 */
	int saveUnicomOnline(UnicomOnline unicomOnline);
	/**
	 * @Title: queryListByParams
	 *@Description: 查询历史数据
	 *@param certNo
	 *@param mobile
	 *@param name
	 *@return
	 *@author: LiuWei
	 *@Date: 2019年11月5日下午3:14:02
	 */
	List<UnicomOnlineMsgResponse> queryListByParams(String certNo,String mobile,String name);
	/**
	 * @Title: query24HoursListByParams
	 *@Description: TODO查询24小时内的数据
	 *@param certNo
	 *@param mobile
	 *@param name
	 *@return
	 *@author: LiuWei
	 *@Date: 2019年11月5日下午3:14:45
	 */
	List<UnicomOnlineMsgResponse> query24HoursListByParams(String certNo,String mobile,String name);

}
