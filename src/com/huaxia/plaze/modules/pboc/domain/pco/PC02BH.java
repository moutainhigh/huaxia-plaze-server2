package com.huaxia.plaze.modules.pboc.domain.pco;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

/**
 * 被追偿汇总信息
 * 
 * @author gaoh
 *
 */
@Alias("PC02BH")
public class PC02BH implements Serializable {
	private static final long serialVersionUID = -1237517518113717429L;
	private String PC02BD01;// 业务类型 [1..1] --
	private String PC02BS03;// 账户数 [1..1] --
	private String PC02BJ02;// 余额 [1..1] --
	private String identityCardNo;// 身份证号
	private String uniqueRelid;// 每个身份证号码关联的唯一uuid值

	public String getPC02BD01() {
		return PC02BD01;
	}

	public void setPC02BD01(String pC02BD01) {
		PC02BD01 = pC02BD01;
	}

	public String getPC02BS03() {
		return PC02BS03;
	}

	public void setPC02BS03(String pC02BS03) {
		PC02BS03 = pC02BS03;
	}

	public String getPC02BJ02() {
		return PC02BJ02;
	}

	public void setPC02BJ02(String pC02BJ02) {
		PC02BJ02 = pC02BJ02;
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