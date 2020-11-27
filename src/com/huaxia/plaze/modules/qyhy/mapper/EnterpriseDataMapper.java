package com.huaxia.plaze.modules.qyhy.mapper;

import org.apache.ibatis.annotations.Param;

public interface EnterpriseDataMapper {
	
	/**
	 * 根据单位全称,查询企业名单库是否存在数据
	 */
	String selectCountByEnterprise(@Param("enterprise")String enterprise);

}
