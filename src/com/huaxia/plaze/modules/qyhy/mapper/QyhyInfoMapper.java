package com.huaxia.plaze.modules.qyhy.mapper;

import java.sql.SQLException;
import java.util.List;

import com.huaxia.plaze.modules.qyhy.domain.QyhyInfoBasic;
import com.huaxia.plaze.modules.qyhy.domain.QyhyInfoData;
import com.huaxia.plaze.modules.qyhy.domain.QyhyInfoMetaData;
import com.huaxia.plaze.modules.qyhy.domain.QyhyInfoOrgBasic;
import com.huaxia.plaze.modules.qyhy.domain.QyhyInfoOrgDetail;
import com.huaxia.plaze.modules.qyhy.domain.QyhyInfoPerson;
import com.huaxia.plaze.modules.qyhy.domain.QyhyInfoPunishBreak;
import com.huaxia.plaze.modules.qyhy.domain.QyhyInfoShareHolder;

/**
 * @title 保存企业行业解析后的数据
 * @author chenmeng
 *
 */
public interface QyhyInfoMapper {   
	/**
	 *@Title:insertQyhyInfoData
	 *@Description:插入  企业行业信息 成功失败 参数存储表
	 *@param qyhyInfoData
	 *@author: gaohui
	 *@Date:2018年4月24日上午9:05:57
	 */
	void insertQyhyInfoData(QyhyInfoData qyhyInfoData);
	/**
	 *@Title:insertQyhyInfoShareHolderList
	 *@Description:插入 SHAREHOLDER 股东及出资信息
	 *@param qyhyInfoShareHolderList
	 *@author: gaohui
	 *@Date:2018年4月24日上午10:13:00
	 */
	void insertQyhyInfoShareHolderList(List<QyhyInfoShareHolder> qyhyInfoShareHolderList);
	/**
	 *@Title:insertQyhyInfoBasic
	 *@Description:插入 BASIC 照面信息
	 *@param qyhyInfoBasic
	 *@author: gaohui
	 *@Date:2018年4月24日下午2:09:37
	 */
	void insertQyhyInfoBasic(QyhyInfoBasic qyhyInfoBasic);
	/**
	 *@Title:insertQyhyInfoPersonList
	 *@Description:插入 PERSON 主要管理人员
	 *@param qyhyInfoPersonList
	 *@author: gaohui
	 *@Date:2018年4月24日下午2:23:21
	 */
	void insertQyhyInfoPersonList(List<QyhyInfoPerson> qyhyInfoPersonList);
	/**
	 *@Title:insertQyhyInfoPunishBreakList
	 *@Description:插入 PUNISHBREAK 失信被执行人信息	
	 *@param qyhyInfoPunishBreakList
	 *@author: gaohui
	 *@Date:2018年4月24日下午2:32:52
	 */
	void insertQyhyInfoPunishBreakList(List<QyhyInfoPunishBreak> qyhyInfoPunishBreakList)throws SQLException;
	/**
	 *@Title:insertQyhyInfoOrgBasicList
	 *@Description:插入 ORGBASIC 组织机构列表	
	 *@param qyhyInfoOrgBasicList
	 *@author: gaohui
	 *@Date:2018年4月24日下午2:40:22
	 */
	void insertQyhyInfoOrgBasicList(List<QyhyInfoOrgBasic> qyhyInfoOrgBasicList);
	/**
	 *@Title:insertQyhyInfoOrgDetail
	 *@Description:插入 ORGDETAIL 组织机构详情
	 *@param qyhyInfoOrgDetail
	 *@author: gaohui
	 *@Date:2018年4月24日下午2:51:03
	 */
	void insertQyhyInfoOrgDetail(QyhyInfoOrgDetail qyhyInfoOrgDetail);
	/**
	 *@Title:insertQyhyInfoMetaData
	 *@Description:插入 METADATA 元数据来源
	 *@param qyhyInfoMetaData
	 *@author: gaohui
	 *@Date:2018年4月26日上午9:01:07
	 */
	void insertQyhyInfoMetaData(QyhyInfoMetaData qyhyInfoMetaData);



}
