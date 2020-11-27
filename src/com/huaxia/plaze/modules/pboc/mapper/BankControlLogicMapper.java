package com.huaxia.plaze.modules.pboc.mapper;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.huaxia.plaze.modules.pboc.domain.BankControlTimeNum;

/**
 * 人行控制逻辑
 * @author gaoh
 *
 */
public interface BankControlLogicMapper {
	/**
	 *@Title:insertBankTaskCall
	 *@Description:插入三方平台的 任务控制表  三方平台解析入库用
	 *@param uniqueRelid 唯一关联id
	 *@param sourceId 数据源关联id
	 *@param taskIp 入库机器ip
	 *@param taskStatus 任务状态
	 *@param identityType 身份类型
	 *@param identityNo 身份号码
	 *@param name 姓名
	 *@param queryFlag  查询标识
	 *@param source 数据来源 
	 *@author: gaohui
	 *@Date:2019年1月19日下午1:25:58
	 */
	void insertBankTaskCall(@Param("uniqueRelid")String uniqueRelid,@Param("sourceId")String sourceId,
			@Param("taskIp")String taskIp,@Param("taskStatus")String taskStatus,
			@Param("identityType")String identityType,@Param("identityNo")String identityNo,
			@Param("name")String name,@Param("queryFlag")String queryFlag,@Param("source")String source);
	/**
	 *@Title:insertBankBodyOriginal
	 *@Description:保存 人行原始报文数据
	 *@param identityCardNo 身份证号
	 *@param identityType 身份类型
	 *@param name  姓名
	 *@param uniqueRelid  唯一关联ID
	 *@param body  人行报文
	 *@param taskIp 任务ip
	 *@author: gaohui
	 *@Date:2019年1月19日下午1:29:53
	 */
	void insertBankBodyOriginal(@Param("identityCardNo")String identityCardNo,@Param("identityType")String identityType,
			@Param("name")String name, @Param("uniqueRelid")String uniqueRelid, @Param("body")String body,
			@Param("taskIp")String taskIp);
	/**
	 *@Title:selectLateIdNoUniqueRelid
	 *@Description:查询最近一次查人行的数据是否存在 
	 *@param param
	 *@return
	 *@author: gaohui
	 *@Date:2018年12月11日下午1:38:47
	 */
	String selectLateIdNoUniqueRelid(Map<String,String> param);
	/**
	 *@Title:selectBankMessage
	 *@Description:获取人行报文
	 *@param param
	 *@return
	 *@author: gaohui
	 *@Date:2019年1月5日下午2:40:11
	 */
	String selectBankMessage(Map<String,String> param);
	/**
	 *@Title:selectBankParserTaskList
	 *@Description:获取人行解析入库任务集合
	 *@param param
	 *@return
	 *@author: gaohui
	 *@Date:2019年1月9日下午1:14:46
	 */
	List<Map<String, String>> selectBankParserTaskList(Map<String,Object> param);
	/**
	 *@Title:selectBankMessageByUniqueRelid
	 *@Description:根据唯一关联id获取人行相应报文
	 *@param uniqueRelid 唯一关联id
	 *@return
	 *@author: gaohui
	 *@Date:2019年1月9日下午2:47:51
	 */
	String selectBankMessageByUniqueRelid(@Param("uniqueRelid")String uniqueRelid);
	/**
	 *@Title:updateBankTaskCall
	 *@Description:根据唯一关联id修改任务表状态
	 *@param uniqueRelid  唯一关联id
	 *@param taskStatus  任务表状态
	 *@author: gaohui
	 *@Date:2019年1月9日下午4:26:08
	 */
	void updateBankTaskCall(@Param("uniqueRelid")String uniqueRelid,@Param("taskStatus")String taskStatus);
	/**
	 *@Title:deleteBankTask
	 *@Description:删除人行对内控制表的相关数据
	 *@param uniqueRelid  唯一关联ID
	 *@param taskStatus 任务状态
	 *@author: gaohui
	 *@Date:2019年1月12日下午2:24:12
	 */
	void deleteBankTask(@Param("uniqueRelid")String uniqueRelid,@Param("taskStatus")String taskStatus);
	/**
	 *@Title:selectBankBodyOriginalUniqueRelid
	 *@Description:查询唯一关联id，用于判断查询唯一关联id的数据，在表中是否存在
	 *@param uniqueRelid 唯一关联id
	 *@return
	 *@author: gaohui
	 *@Date:2019年1月16日下午2:07:21
	 */
	String selectBankBodyOriginalUniqueRelid(@Param("uniqueRelid")String uniqueRelid);
	/**
	 *@Title:insertBankTaskHis
	 *@Description:保存人行对内 任务到历史表(根据唯一关联id)
	 *@param uniqueRelid 唯一关联id
	 *@author: gaohui
	 *@Date:2019年1月19日下午4:34:25
	 */
	void insertBankTaskHis(@Param("uniqueRelid")String uniqueRelid);
	
	/**
	 *@Title:selectBankBodyUniqueRelidList
	 *@Description:根据控制天数和每次查询数量查出所需的uniqueRelid集合
	 *@param dayControl 控制天数
	 *@param queryNum 每次查询数量
	 *@param taskIp 任务ip  
	 *@return
	 *@author: gaohui
	 *@Date:2019年1月24日下午4:30:18
	 */
	List<String> selectBankBodyUniqueRelidList(@Param("dayControl")Integer dayControl, 
			@Param("queryNum")Integer queryNum, @Param("taskIp")String taskIp);
	/**
	 *@Title:saveBankBodyHis
	 *@Description:保存原始报文到历史表 根据 唯一关联id集合
	 *@param uniqueRelidList 唯一关联id集合
	 *@author: gaohui
	 *@Date:2019年1月25日上午10:34:57
	 */
	void saveBankBodyHis(@Param("uniqueRelidList")List<String> uniqueRelidList);
	/**
	 *@Title:deleteBankBody
	 *@Description:删除原始报文 根据唯一关联id集合
	 *@param uniqueRelidList 唯一关联id集合
	 *@author: gaohui
	 *@Date:2019年1月25日下午2:29:10
	 */
	void deleteBankBody(@Param("uniqueRelidList")List<String> uniqueRelidList);
	/**
	 *@Title:selectBankControlNumTime
	 *@Description:获取人行 流控所需要的时间 和数量 
	 *@param taskType  人行任务类型
	 *@return
	 *@author: gaohui
	 *@Date:2019年3月15日下午4:32:34
	 */
	BankControlTimeNum selectBankControlNumTime(@Param("taskType")String taskType);
	/**
	 *@Title:selectBankNumByTime
	 *@Description:根据时间获取人行查询数量
	 *@param startTime 开始时间
	 *@param endTime   结束时间
	 *@return
	 *@author: gaohui
	 *@Date:2019年3月15日下午4:46:56
	 */
	Integer selectBankNumByTime(@Param("startTime")Date startTime,@Param("endTime")Date endTime);
}
