package com.huaxia.plaze.modules.pboc.service;

import java.util.List;
import java.util.Map;

/**
 * 任务请求表 三方平台
 * @author gaoh
 *
 */
public interface BankTaskCallPlazeService {
	
	/**
	 *@Title:findBankTaskCallPlazeList
	 *@Description:获取任务表集合
	 *@param param
	 *@return
	 *@author: gaohui
	 *@Date:2018年11月20日下午1:36:09
	 */
	List<Map<String,String>> findBankTaskCallPlazeList(Map<String,Object> param);
	/**
	 *@Title:findBankParamList
	 *@Description:根据身份证号、身份证类型、姓名、任务类型、任务状态  获取人行相关参数
	 *@param identityNo 身份证号
	 *@param identityType 身份证类型
	 *@param name 姓名
	 *@param taskStatus 任务状态
	 *@return
	 *@author: gaohui
	 *@Date:2018年12月17日上午11:24:12
	 */
	List<Map<String,String>> findBankParamList(String identityNo,String identityType,String name, String taskStatus);
	/**
	 *@Title:updateTaskStatus
	 *@Description:修改任务状态
	 *@param identityNo 身份证号
	 *@param identityType 证件类型
	 *@param name  姓名 
	 *@param updateStatus 修改成的状态
	 *@param currStatus   当前的状态
	 *@param taskIp 任务服务地址
	 *@param lstOptUser 最后操作人
	 *@param requestAddNum 请求次数的增加数字
	 *@param failureAddNum 失败次数的增加数字
	 *@return
	 *@author: gaohui
	 *@Date:2018年12月10日下午3:35:35
	 */
	int updateTaskStatus(String identityNo,String identityType,String name, String updateStatus, String currStatus,String taskIp,
			     String lstOptUser,String requestAddNum,String failureAddNum);
	/**
	 *@Title:saveBankTaskCallPlaze
	 *@Description:保存人行对外任务请求
	 *@param params
	 *@author: gaohui
	 *@Date:2018年12月29日上午11:13:52
	 */
	void saveBankTaskCallPlaze(Map<String,String> params);
	/**
	 *@Title:findBankBackTaskPlazeList
	 *@Description:获取要返回给请求端数据的任务
	 *@param param
	 *@return
	 *@author: gaohui
	 *@Date:2019年1月4日上午11:26:41
	 */
	List<Map<String,String>> findBankBackTaskPlazeList(Map<String,Object> param);
	
	/**
	 *@Title:deleteBankTaskPlaze
	 *@Description:删除人行对外控制表相关数据
	 *@param uniqueRelid  唯一关联ID
	 *@param taskStatus 任务状态
	 *@author: gaohui
	 *@Date:2019年1月8日上午10:58:34
	 */
	void deleteBankTaskPlaze(String uniqueRelid, String taskStatus);
	/**
	 *@Title:updateBankTaskPlaze
	 *@Description:修改人行对外控制表相关数据
	 *@param uniqueRelid 唯一关联ID
	 *@param updateStatus 修改成的任务状态
	 *@param currStatus  当前任务状态
	 *@param lstOptUser  当前操作人
	 *@param requestAddNum 请求次数
	 *@param failureAddNum 失败次数
	 *@author: gaohui
	 *@Date:2019年1月12日下午4:48:25
	 */
	void updateBankTaskPlaze(String uniqueRelid, String updateStatus, String currStatus, 
			String lstOptUser, String requestAddNum, String failureAddNum);
	/**
	 *@Title:saveBankTaskPlazeHis
	 *@Description:保存人行对外任务到历史表(根据唯一关联id)
	 *@param uniqueRelid 根据唯一关联
	 *@author: gaohui
	 *@Date:2019年1月15日下午3:39:36
	 */
	void saveBankTaskPlazeHis(String uniqueRelid);
	
	/**
	 * 根据sourceid更改PBOC_TRN_SINGLE_REVIEW表review_status的状态
	 */
	void updatePbocTrnSingleReview(String sourceId,String status);
	
	/**
	 * 获取发送二代人行请求所需要的用户名和密码
	 */
	Map<String , String> findUserAndPwd();
}
