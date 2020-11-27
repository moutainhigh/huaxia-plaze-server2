package com.huaxia.plaze.modules.pboc.domain.pim;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

/**
 * 手机号码信息段数据
 * 
 * @author gaoh
 *
 */
@Alias("PB01Bdata")
public class PB01Bdata implements Serializable {
	private static final long serialVersionUID = -4412272339776159049L;

	private String PB01BS01;// 手机号码个数 [1..1]

	private String identityCardNo;// 身份证号
	private String uniqueRelid;// 每个身份证号码关联的唯一uuid值

	public String getPB01BS01() {
		return PB01BS01;
	}

	public void setPB01BS01(String pB01BS01) {
		PB01BS01 = pB01BS01;
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
