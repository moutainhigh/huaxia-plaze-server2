package com.huaxia.plaze.modules.pboc.mapper;

import java.util.List;

import com.huaxia.plaze.modules.pboc.domain.pda.PD01A;
import com.huaxia.plaze.modules.pboc.domain.pda.PD01B;
import com.huaxia.plaze.modules.pboc.domain.pda.PD01C;
import com.huaxia.plaze.modules.pboc.domain.pda.PD01DH;
import com.huaxia.plaze.modules.pboc.domain.pda.PD01Ddata;
import com.huaxia.plaze.modules.pboc.domain.pda.PD01EH;
import com.huaxia.plaze.modules.pboc.domain.pda.PD01Edata;
import com.huaxia.plaze.modules.pboc.domain.pda.PD01FH;
import com.huaxia.plaze.modules.pboc.domain.pda.PD01Fdata;
import com.huaxia.plaze.modules.pboc.domain.pda.PD01GH;
import com.huaxia.plaze.modules.pboc.domain.pda.PD01Gdata;
import com.huaxia.plaze.modules.pboc.domain.pda.PD01HH;
import com.huaxia.plaze.modules.pboc.domain.pda.PD01Hdata;
import com.huaxia.plaze.modules.pboc.domain.pda.PD01ZH;
import com.huaxia.plaze.modules.pboc.domain.pda.PD01Zdata;

/**
 *  1.11 借贷账户信息 PDA 
 * @author gaoh
 *
 */
public interface BankDebitCreditInfoMapper {
	/**
	 *@Title:insertDebitCreditBasicInfo
	 *@Description:保存 基本信息段 PD01A
	 *@param pd01a 基本信息段
	 *@author: gaohui
	 *@Date:2018年9月11日上午9:14:26
	 */
	void insertDebitCreditBasicInfo(PD01A pd01a);
	/**
	 *@Title:insertDebitCreditNewstShow
	 *@Description:保存最新表现信息段 PD01B
	 *@param pd01b 最新表现信息段
	 *@author: gaohui
	 *@Date:2018年9月11日上午10:54:49
	 */
	void insertDebitCreditNewstShow(PD01B pd01b);
	/**
	 *@Title:insertDebitCreditNearestMonth
	 *@Description:保存 最近一次月度表现信息段 PD01C
	 *@param pd01c 最近一次月度表现信息段 
	 *@author: gaohui
	 *@Date:2018年9月11日下午1:15:36
	 */
	void insertDebitCreditNearestMonth(PD01C pd01c);
	/**
	 *@Title:insertDebitCreditNearest24MonthRepayRecord
	 *@Description:保存 最近24个月还款记录信息段数据 PD01D/PD01Ddata
	 *@param PD01Ddata 最近24个月还款记录信息段数据 PD01Ddata
	 *@author: gaohui
	 *@Date:2018年9月27日上午10:25:53
	 */
	void insertDebitCreditNearest24MonthRepayRecord(PD01Ddata pd01dData);
	 /**
	  *@Title:insertDebitCreditRepayStatusInfoList
	  *@Description:保存 最近24个月还款状态信息 PD01D/pd01dhList
	  *@param pd01dhList  最近24个月还款状态信息
	  *@author: gaohui
	  *@Date:2018年9月27日上午10:55:18
	  */
	void insertDebitCreditRepayStatusInfoList(List<PD01DH> pd01dhList);
	/**
	 *@Title:insertDebitCreditNearest5YearHistory
	 *@Description: 保存最近5年内历史表现信息段数据 PD01E/PD01Edata
	 *@param pd01eData 最近5年内历史表现信息段数据
	 *@author: gaohui
	 *@Date:2018年9月27日下午3:12:27
	 */
	void insertDebitCreditNearest5YearHistory(PD01Edata pd01eData );
	/**
	 *@Title:insertDebitCreditNearest5YearHisExpressList
	 *@Description:保存最近5年内历史表现信息    PD01E/PD01EH
	 *@param pd01ehList 最近5年内历史表现信息
	 *@author: gaohui
	 *@Date:2018年9月28日上午10:11:07
	 */
	void insertDebitCreditNearest5YearHisExpressList(List<PD01EH> pd01ehList);
	/**
	 *@Title:insertDebitCreditSpecialTransaction
	 *@Description:保存特殊交易信息段数据 PD01F/PD01Fdata
	 *@param pd01fData 特殊交易信息段数据 
	 *@author: gaohui
	 *@Date:2018年9月28日下午1:09:29
	 */
	void insertDebitCreditSpecialTransaction(PD01Fdata pd01fData);
	/**
	 *@Title:insertDebitCreditSpecialTradeList
	 *@Description:保存 特殊交易信息  PD01F/PD01FH 
	 *@param pd01fhList  特殊交易信息  PD01F集合
	 *@author: gaohui
	 *@Date:2018年9月28日下午2:16:24
	 */
	void insertDebitCreditSpecialTradeList(List<PD01FH> pd01fhList);
	/**
	 *@Title:insertDebitCreditSpecialEventExpress
	 *@Description:保存 特殊事件说明信息段 PD01G/PD01Gdata
	 *@param pd01gData 特殊事件说明信息段
	 *@author: gaohui
	 *@Date:2018年9月28日下午3:41:17
	 */
	void insertDebitCreditSpecialEventExpress(PD01Gdata pd01gData);
	/**
	 *@Title:insertDebitCreditSpecialEventExpressInfoList
	 *@Description:保存 特殊事件说明信息  PD01G/PD01GH 
	 *@param pd01ghList 特殊事件说明信息 PD01G集合
	 *@author: gaohui
	 *@Date:2018年9月28日下午4:19:19
	 */
	void insertDebitCreditSpecialEventExpressInfoList(List<PD01GH> pd01ghList);
	/**
	 *@Title:insertDebitCreditDezxFq
	 *@Description:保存 大额专项分期信息段 PD01H/PD01Hdata
	 *@param pd01hData 大额专项分期信息数据
	 *@author: gaohui
	 *@Date:2018年9月29日上午10:54:59
	 */
	void insertDebitCreditDezxFq(PD01Hdata pd01hData);
	/**
	 *@Title:insertDebitCreditDezxFqInfoList
	 *@Description:保存 大额专项分期信息 PD01H/PD01HH  
	 *@param pd01hhList 大额专项分期信息
	 *@author: gaohui
	 *@Date:2018年9月29日下午12:59:42
	 */
	void insertDebitCreditDezxFqInfoList(List<PD01HH> pd01hhList);
	/**
	 *@Title:insertDebitCreditPdaLabelState
	 *@Description:保存 标注及声明信息段 PD01Z/PD01Zdata
	 *@param pd01zData 标注及声明信息段 
	 *@author: gaohui
	 *@Date:2018年9月29日下午2:53:30
	 */
	void insertDebitCreditPdaLabelState(PD01Zdata pd01zData);
	/**
	 *@Title:insertDebitCreditPdaLabelStateInfoList
	 *@Description:保存 标注及声明信息  PD01Z/PD01ZH 集合
	 *@param pd01zhList
	 *@author: gaohui
	 *@Date:2018年10月8日上午10:05:32
	 */
	void insertDebitCreditPdaLabelStateInfoList(List<PD01ZH> pd01zhList);
}
