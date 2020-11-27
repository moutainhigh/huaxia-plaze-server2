package com.huaxia.plaze.modules.pboc.domain.pda;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

/**
 * 特殊交易信息段数据
 * 
 * @author gaoh
 *
 */
@Alias("PD01Fdata")
public class PD01Fdata implements Serializable {

	private static final long serialVersionUID = 3119377434728890753L;
	private String PD01FS01;// 特殊交易个数 -- [1..1]
	private String relateId;// 每个 借贷账户信息单元 的关联id
	private String identityCardNo;// 身份证号
	private String uniqueRelid;// 每个身份证号码关联的唯一uuid值

	public String getPD01FS01() {
		return PD01FS01;
	}

	public void setPD01FS01(String pD01FS01) {
		PD01FS01 = pD01FS01;
	}

	public String getRelateId() {
		return relateId;
	}

	public void setRelateId(String relateId) {
		this.relateId = relateId;
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