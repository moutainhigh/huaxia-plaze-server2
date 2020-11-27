package com.huaxia.plaze.modules.pboc.domain.pco;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

/**
 * 呆账汇总信息段
 * 
 * @author gaoh
 *
 */
@Alias("PC02C")
public class PC02C implements Serializable {
	private static final long serialVersionUID = 653224978109768002L;
	private String PC02CS01;// 账户数 [1..1] --
	private String PC02CJ01;// 余额 [1..1] --
	private String identityCardNo;// 身份证号
	private String uniqueRelid;// 每个身份证号码关联的唯一uuid值

	public String getPC02CS01() {
		return PC02CS01;
	}

	public void setPC02CS01(String pC02CS01) {
		PC02CS01 = pC02CS01;
	}

	public String getPC02CJ01() {
		return PC02CJ01;
	}

	public void setPC02CJ01(String pC02CJ01) {
		PC02CJ01 = pC02CJ01;
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