package com.huaxia.plaze.modules.pboc.mapper;

import java.util.List;

import com.huaxia.plaze.modules.pboc.domain.pco.PC02AH;
import com.huaxia.plaze.modules.pboc.domain.pco.PC02Adata;
import com.huaxia.plaze.modules.pboc.domain.pco.PC02BH;
import com.huaxia.plaze.modules.pboc.domain.pco.PC02Bdata;
import com.huaxia.plaze.modules.pboc.domain.pco.PC02C;
import com.huaxia.plaze.modules.pboc.domain.pco.PC02DH;
import com.huaxia.plaze.modules.pboc.domain.pco.PC02Ddata;
import com.huaxia.plaze.modules.pboc.domain.pco.PC02E;
import com.huaxia.plaze.modules.pboc.domain.pco.PC02F;
import com.huaxia.plaze.modules.pboc.domain.pco.PC02G;
import com.huaxia.plaze.modules.pboc.domain.pco.PC02H;
import com.huaxia.plaze.modules.pboc.domain.pco.PC02I;
import com.huaxia.plaze.modules.pboc.domain.pco.PC02KH;
import com.huaxia.plaze.modules.pboc.domain.pco.PC02Kdata;


/**
 * 1.7 信贷交易信息概要 PCO
 * @author gaoh
 *
 */
public interface BankCreditLoanTransactionMapper {
	/**
	 *@Title:insertCreditTransactionData
	 *@Description:保存信贷交易提示信息段数据 PC02A/PC02Adata
	 *@param PC02Adata 信贷交易提示信息段数据
	 *@author: gaohui
	 *@Date:2018年9月7日上午10:53:13
	 */
	void insertCreditTransactionData(PC02Adata pc02aData);
	/**
	 *@Title:insertCreditTransactionDetailList
	 *@Description:保存信贷交易提示信息 PC02AH 集合
	 *@param pc02ahList 信贷交易提示信息 PC02AH 集合
	 *@author: gaohui
	 *@Date:2018年9月7日下午1:32:31
	 */
	void insertCreditTransactionDetailList(List<PC02AH> pc02ahList);
	/**
	 *@Title:insertBeRecoveriedSumData
	 *@Description:保存被追偿汇总信息段数据PC02B/PC02Bdata
	 *@param pc02bData 被追偿汇总信息段数据PC02B/PC02Bdata
	 *@author: gaohui
	 *@Date:2018年9月7日下午1:59:03
	 */
	void insertBeRecoveriedSumData(PC02Bdata pc02bData);
	/**
	 *@Title:insertBeRecoveriedSumDelList
	 *@Description:保存被追偿汇总信息 PC02B/PC02BH 集合
	 *@param pc02bhList 被追偿汇总信息 PC02B/PC02BH 集合
	 *@author: gaohui
	 *@Date:2018年9月7日下午2:28:08
	 */
	void insertBeRecoveriedSumDelList(List<PC02BH> pc02bhList);
	/**
	 *@Title:insertBadDebtsSum
	 *@Description:保存 呆账汇总信息段 PC02C
	 *@param pc02c 呆账汇总信息段
	 *@author: gaohui
	 *@Date:2018年9月7日下午2:55:47
	 */
	void insertBadDebtsSum(PC02C pc02c);
	/**
	 *@Title:insertOverdueDraftSum
	 *@Description:保存逾期（透支）汇总信息段数据 PC02D/PC02Ddata
	 *@param pc02dData 逾期（透支）汇总信息段数据
	 *@author: gaohui
	 *@Date:2018年9月8日上午10:13:02
	 */
	void insertOverdueDraftSum(PC02Ddata pc02dData);
	/**
	 *@Title:insertOverdueDraftSumDelList
	 *@Description:保存逾期（透支）汇总信息  PC02DH集合
	 *@param pc02dList 逾期（透支）汇总信息  PC02DH集合
	 *@author: gaohui
	 *@Date:2018年9月8日上午10:31:14
	 */
	void insertOverdueDraftSumDelList(List<PC02DH> pc02dList);
	/**
	 *@Title:insertNoRevolveLoanAccoSum
	 *@Description:保存非循环贷账户汇总信息段 PC02E 
	 *@param pc02e 非循环贷账户汇总信息段 PC02E 
	 *@author: gaohui
	 *@Date:2018年9月8日下午2:45:58
	 */
	void insertNoRevolveLoanAccoSum(PC02E pc02e);
	/**
	 *@Title:insertRevolveLimSubAccoSum
	 *@Description:保存循环额度下分账户汇总信息段 PC02F 
	 *@param pc02f 循环额度下分账户汇总信息段 PC02F 
	 *@author: gaohui
	 *@Date:2018年9月8日下午4:22:59
	 */
	void insertRevolveLimSubAccoSum(PC02F pc02f);
	/**
	 *@Title:insertRevolveLoanAccoSum
	 *@Description:保存循环贷账户汇总信息段 PC02G
	 *@param pc02g 循环贷账户汇总信息段 PC02G
	 *@author: gaohui
	 *@Date:2018年9月8日下午4:49:46
	 */
	void insertRevolveLoanAccoSum(PC02G pc02g);
	/**
	 *@Title:insertCreditCardAccoSum
	 *@Description:保存 贷记卡账户汇总信息段 PC02H 
	 *@param pc02h 贷记卡账户汇总信息段 PC02H
	 *@author: gaohui
	 *@Date:2018年9月10日上午8:35:11
	 */
	void insertCreditCardAccoSum(PC02H pc02h);
	/**
	 *@Title:insertSemiCreditCardAccoSum
	 *@Description:保存准贷记卡账户汇总信息段 PC02I
	 *@param pc02i 准贷记卡账户汇总信息段 PC02I
	 *@author: gaohui
	 *@Date:2018年9月10日上午9:03:48
	 */
	void insertSemiCreditCardAccoSum(PC02I pc02i);
	/**
	 *@Title:insertRelatedRepayDutySum
	 *@Description:保存相关还款责任汇总信息段数据   PC02K/pc02kData
	 *@param pc02kData相关还款责任汇总信息段数据 
	 *@author: gaohui
	 *@Date:2018年9月10日上午10:27:13
	 */
	void insertRelatedRepayDutySum(PC02Kdata pc02kData);
	/**
	 *@Title:insertRelatedRepayDutySumDelList
	 *@Description:保存 相关还款责任汇总信息  PC02KH 集合
	 *@param pc02khList
	 *@author: gaohui
	 *@Date:2018年9月10日上午10:32:43
	 */
	void insertRelatedRepayDutySumDelList(List<PC02KH> pc02khList);
}
