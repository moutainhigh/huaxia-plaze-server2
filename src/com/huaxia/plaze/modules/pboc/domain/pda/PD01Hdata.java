package com.huaxia.plaze.modules.pboc.domain.pda;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

/**
 * 大额专项分期信息段
 * 
 * @author gaoh
 *
 */
@Alias("PD01Hdata")
public class PD01Hdata implements Serializable {

	private static final long serialVersionUID = 2676006863592702510L;
	private String PD01HS01;// 大额专项分期笔数 -- [1..1]
	private String relateId;// 每个 借贷账户信息单元 的关联id
	private String identityCardNo;// 身份证号
	private String uniqueRelid;// 每个身份证号码关联的唯一uuid值

	public String getPD01HS01() {
		return PD01HS01;
	}

	public void setPD01HS01(String pD01HS01) {
		PD01HS01 = pD01HS01;
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
