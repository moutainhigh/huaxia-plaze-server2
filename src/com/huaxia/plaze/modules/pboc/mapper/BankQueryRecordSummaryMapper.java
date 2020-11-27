package com.huaxia.plaze.modules.pboc.mapper;

import com.huaxia.plaze.modules.pboc.domain.pqo.PC05A;
import com.huaxia.plaze.modules.pboc.domain.pqo.PC05B;

/**
 * 1.10 查询记录概要 PQO 
 * @author gaoh
 *
 */
public interface BankQueryRecordSummaryMapper {
	/**
	 *@Title:insertLastQueryRecord
	 *@Description:保存上一次查询记录 PC05A
	 *@param pc05a  上一次查询记录 PC05A
	 *@author: gaohui
	 *@Date:2018年9月10日下午3:15:23
	 */
	void insertLastQueryRecord(PC05A pc05a);
	/**
	 *@Title:insertQueryRecordSum
	 *@Description:保存查询记录汇总 PC05B
	 *@param pc05b 查询记录汇总 
	 *@author: gaohui
	 *@Date:2018年9月10日下午3:23:15
	 */
	void insertQueryRecordSum(PC05B pc05b);
}
