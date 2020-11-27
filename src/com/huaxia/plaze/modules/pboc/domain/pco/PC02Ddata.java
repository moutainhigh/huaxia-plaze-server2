package com.huaxia.plaze.modules.pboc.domain.pco;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

/**
 * 逾期（透支）汇总信息段数据
 * 
 * @author gaoh
 *
 */
@Alias("PC02Ddata")
public class PC02Ddata implements Serializable {
	private static final long serialVersionUID = 8802732924276222896L;
	private String PC02DS01;// 账户类型数量 [1..1] --
	private String identityCardNo;// 身份证号
	private String uniqueRelid;// 每个身份证号码关联的唯一uuid值

	public String getPC02DS01() {
		return PC02DS01;
	}

	public void setPC02DS01(String pC02DS01) {
		PC02DS01 = pC02DS01;
	}

	public String getIdentityCardNo() {
		return identityCardNo;
	}

	public void setIdentityCardNo(String identityCardNo) {
		this.identityCardNo = identityCardNo;
	}

	public String getUniqueRelid() {
		return uniqueRelid;
	}

	public void setUniqueRelid(String uniqueRelid) {
		this.uniqueRelid = uniqueRelid;
	}

}