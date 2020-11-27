package com.huaxia.plaze.modules.pboc.mapper;

import java.util.List;

import com.huaxia.plaze.modules.pboc.domain.prh.PA01A;
import com.huaxia.plaze.modules.pboc.domain.prh.PA01B;
import com.huaxia.plaze.modules.pboc.domain.prh.PA01CH;
import com.huaxia.plaze.modules.pboc.domain.prh.PA01Cdata;
import com.huaxia.plaze.modules.pboc.domain.prh.PA01D;
import com.huaxia.plaze.modules.pboc.domain.prh.PA01E;


/**
 *  1.1 报告头 PRH 
 * @author gaoh
 *
 */
public interface BankReportHeaderMapper {
	/**
	 *@Title:insertReportMarkInfo
	 *@Description:保存 报告标识信息段 PA01A 
	 *@param pa01a 报告标识信息段
	 *@author: gaohui
	 *@Date:2018年12月3日上午9:38:34
	 */
	 void insertReportMarkInfo(PA01A pa01a);
	 /**
	  *@Title:insertCurQueryRequest
	  *@Description:保存 本次查询请求信息段  PA01B
	  *@param pa01b 本次查询请求信息段
	  *@author: gaohui
	  *@Date:2018年12月3日上午9:56:48
	  */
	 void insertCurQueryRequest(PA01B pa01b);
	/**
	 *@Title:insertOtherIdentityMark
	 *@Description:保存其他身份标识信息段数据
	 *@param pa01cData 其他身份标识信息段  PA01C/PA01Cdata
	 *@author: gaohui
	 *@Date:2018年9月5日下午3:40:36
	 */
	void insertOtherIdentityMark(PA01Cdata pa01cData);
	/**
	 *@Title:insertIdentityDataList
	 *@Description:插入身份信息list集合
	 *@param pa01chList pa01chList 身份信息  PA01C/PA01CH 集合
	 *@author: gaohui
	 *@Date:2018年9月5日下午4:14:51
	 */
	void insertIdentityDataList(List<PA01CH> pa01chList);
	/**
	 *@Title:insertCheatProofCaution
	 *@Description: 插入防欺诈警示信息段  PA01D 
	 *@param pa01d 防欺诈警示信息段
	 *@author: gaohui
	 *@Date:2018年9月5日下午4:14:51
	 */
	void insertCheatProofCaution(PA01D pa01d);
	/**
	 *@Title:insertDissentHint
	 *@Description:插入异议提示信息
	 *@param pa01e
	 *@author: gaohui
	 *@Date:2018年9月5日下午6:15:51
	 */
	void insertDissentHint(PA01E pa01e);
}
