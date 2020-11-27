package com.huaxia.plaze.modules.unicom.mapper;

import java.util.List;
import java.util.Map;

import com.huaxia.plaze.modules.bairong.domain.ApplyLoanStrMsgResponse;
import com.huaxia.plaze.modules.unicom.domain.UnicomOnline;
import com.huaxia.plaze.modules.unicom.domain.UnicomOnlineMsgResponse;
import com.huaxia.plaze.modules.unicom.domain.UnicomOnlineTrnRequest;

public interface UnicomOnlineMapper {
	
	void insertUnicomOnlineTrnRequest(UnicomOnlineTrnRequest unicomOnlineTrnRequest);
	
	int insertUnicomOnlineMsgResponse(UnicomOnlineMsgResponse unicomOnlineMsgResponse);
	
	int insertUnicomOnline(UnicomOnline unicomOnline);
	/**
	 * @Title: selectListByParams
	 *@Description: 查询历史数据
	 *@param args
	 *@return
	 *@author: LiuWei
	 *@Date: 2019年11月5日下午3:17:25
	 */
	List<UnicomOnlineMsgResponse> selectListByParams(Map<String, Object> args);
	/**
	 * @Title: select24HoursListByParams
	 *@Description: TODO查询24小时内的数据
	 *@param args
	 *@return
	 *@author: LiuWei
	 *@Date: 2019年11月5日下午3:17:37
	 */
	List<UnicomOnlineMsgResponse> select24HoursListByParams(Map<String, Object> args);
}
