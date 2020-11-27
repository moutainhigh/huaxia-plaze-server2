package com.huaxia.plaze.modules.pboc.mapper;

import java.util.List;

import com.huaxia.plaze.modules.pboc.domain.pom.PB04;

/**
 * 职业信息 POM  
 * @author gaoh
 *
 */
public interface BankProfessionInfoMapper {
	/**
	 *@Title:insertProfessionInfoList
	 *@Description:保存职业信息单元集合
	 *@param pb04List 职业信息单元 PB04  集合
	 *@author: gaohui
	 *@Date:2018年9月6日下午2:06:09
	 */
	void insertProfessionInfoList(List<PB04> pb04List);
}
