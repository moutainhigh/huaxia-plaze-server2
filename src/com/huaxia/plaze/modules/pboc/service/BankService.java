package com.huaxia.plaze.modules.pboc.service;


import java.util.Date;
import java.util.List;
import java.util.Map;

import com.huaxia.plaze.modules.pboc.domain.Bank;
import com.huaxia.plaze.modules.pboc.domain.BankControlTimeNum;

/**
 * 人行二期服务接口
 * @author gaoh
 *
 */
public interface BankService {
	/**
	 *@Title:saveBankReportMessage
	 *@Description:二代人行信息入库
	 *@param bank
	 *@author: gaohui
	 *@Date:2018年9月4日下午3:05:16
	 */
	void saveBankReportMessage(Bank bank);
    /**
     *@Title:saveBankControlLogic
     *@Description:保存 人行控制逻辑数据
     *@param uniqueRelid 唯一关联ID
     *@param sourceId  数据源关联id
     *@param identityType 证件类型
     *@param identityCardNo   身份证号
     *@param name 姓名
     *@param queryFlag 快速查询标识
     *@param source   数据来源
     *@param body 人行报文
     *@author: gaohui
     *@Date:2018年12月11日下午2:56:32
     */
	void saveBankControlLogic(String uniqueRelid, String sourceId, String identityType,String identityCardNo,
			String name,String queryFlag,String source,String body);
	/**
	 *@Title:queryLateIdNoUniqueRelid
	 *@Description:查询最近一次查人行的数据是否存在 
	 *@param param
	 *@return
	 *@author: gaohui
	 *@Date:2018年12月11日下午1:38:47
	 */
	String queryLateIdNoUniqueRelid(Map<String,String> param);
	/**
	 *@Title:findBankMessage
	 *@Description:获取人行报文
	 *@param param
	 *@return
	 *@author: gaohui
	 *@Date:2019年1月5日下午2:40:11
	 */
	String findBankMessage(Map<String,String> param);
	/**
	 *@Title:findBankParserTaskList
	 *@Description:获取人行解析入库任务集合
	 *@param param
	 *@return
	 *@author: gaohui
	 *@Date:2019年1月9日下午1:14:46
	 */
	List<Map<String, String>> findBankParserTaskList(Map<String,Object> param);
	/**
	 *@Title:findBankMessageByUniqueRelid
	 *@Description:根据唯一关联id获取人行相应报文
	 *@param uniqueRelid 唯一关联id
	 *@return
	 *@author: gaohui
	 *@Date:2019年1月9日下午2:47:51
	 */
	String findBankMessageByUniqueRelid(String uniqueRelid);
	/**
	 *@Title:updateBankTaskCall
	 *@Description:根据唯一关联id修改任务表状态
	 *@param uniqueRelid  唯一关联id
	 *@param taskStatus  任务表状态
	 *@author: gaohui
	 *@Date:2019年1月9日下午4:26:08
	 */
	void updateBankTaskCall(String uniqueRelid,String taskStatus);
	/**
	 *@Title:deleteBankTask
	 *@Description:删除人行对内控制表的相关数据
	 *@param uniqueRelid  唯一关联ID
	 *@param taskStatus 任务状态
	 *@author: gaohui
	 *@Date:2019年1月12日下午2:24:12
	 */
	void deleteBankTask(String uniqueRelid,String taskStatus);
	/**
	 *@Title:findBankBodyOriginalUniqueRelid
	 *@Description:查询唯一关联id，用于判断查询唯一关联id的数据，在表中是否存在
	 *@param uniqueRelid 唯一关联id
	 *@return
	 *@author: gaohui
	 *@Date:2019年1月16日下午2:07:21
	 */
	String findBankBodyOriginalUniqueRelid(String uniqueRelid);
	/**
	 *@Title:saveBankTaskHis
	 *@Description:保存人行对内 任务到历史表(根据唯一关联id)
	 *@param uniqueRelid 唯一关联id
	 *@author: gaohui
	 *@Date:2019年1月19日下午4:34:25
	 */
	void saveBankTaskHis(String uniqueRelid);
	/**
	 *@Title:saveDeleteBankBody
	 *@Description:保存超过控制天数的人行报文到历史库 并删除当前库的这些数据
	 *@param dayControl 控制天数
	 *@param queryNum 每次查询数量
	 *@author: gaohui
	 *@Date:2019年1月24日下午4:33:00
	 */
	void saveDeleteBankBody(Integer dayControl, Integer queryNum);
	/**
	 *@Title:findBankControlNumTime
	 *@Description:获取人行 流控所需要的时间 和数量 
	 *@param taskType  人行任务类型
	 *@return
	 *@author: gaohui
	 *@Date:2019年3月15日下午4:32:34
	 */
	BankControlTimeNum findBankControlNumTime(String taskType);
	/**
	 *@Title:findBankNumByTime
	 *@Description:根据时间获取人行查询数量
	 *@param startTime 开始时间
	 *@param endTime   结束时间
	 *@return
	 *@author: gaohui
	 *@Date:2019年3月15日下午4:46:56
	 */
	Integer findBankNumByTime(Date startTime,Date endTime);
}
