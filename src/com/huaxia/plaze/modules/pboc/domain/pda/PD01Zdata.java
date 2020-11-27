package com.huaxia.plaze.modules.pboc.domain.pda;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

/**
 * 标注及声明信息段数据
 * 
 * @author gaoh
 *
 */
@Alias("PD01Zdata")
public class PD01Zdata implements Serializable {
	private static final long serialVersionUID = 3338643127920243289L;
	private String PD01ZS01;// 标注及声明个数 -- [1..1]
	private String relateId;// 每个 借贷账户信息单元 的关联id
	private String identityCardNo;// 身份证号
	private String uniqueRelid;// 每个身份证号码关联的唯一uuid值

	public String getPD01ZS01() {
		return PD01ZS01;
	}

	public void setPD01ZS01(String pD01ZS01) {
		PD01ZS01 = pD01ZS01;
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
