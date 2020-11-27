package com.huaxia.plaze.modules.pboc.mapper;

import com.huaxia.plaze.modules.pboc.domain.pno.PC030H;
import com.huaxia.plaze.modules.pboc.domain.pno.PC03data;

/**
 * 1.8 非信贷交易信息概要 PNO 
 * @author gaoh
 *
 */
public interface BankNoCreditTransactionMapper {
	/**
	 *@Title:insertPostPayArreagageAum
	 *@Description:保存 后付费业务欠费信息汇总信息单元数据PC03data
	 *@param pc03Data 后付费业务欠费信息汇总信息单元数据
	 *@author: gaohui
	 *@Date:2018年9月10日下午1:17:36
	 */
	void insertPostPayArreagageAum(PC03data pc03Data);
	/**
	 *@Title:insertPostPayArreagageAumDel
	 *@Description:保存后付费业务欠信息汇总信息 PC030H 
	 *@param pc03h 后付费业务欠信息汇总信息
	 *@author: gaohui
	 *@Date:2018年9月10日下午1:32:23
	 */
	void insertPostPayArreagageAumDel(PC030H pc03h);
}
