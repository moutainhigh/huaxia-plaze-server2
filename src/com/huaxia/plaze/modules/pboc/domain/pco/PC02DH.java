package com.huaxia.plaze.modules.pboc.domain.pco;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

/**
 * 逾期（透支）汇总信息
 * 
 * @author gaoh
 *
 */
@Alias("PC02DH")
public class PC02DH implements Serializable {
	private static final long serialVersionUID = -8882416943595560931L;
	private String PC02DD01;// 账户类型 [1..1] --
	private String PC02DS02;// 账户数 [1..1] --
	private String PC02DS03;// 月份数 [1..1] --
	private String PC02DJ01;// 单月最高逾期（透支）总额 [1..1] --
	private String PC02DS04;// 最长逾期（透支）月数 [1..1] --
	private String identityCardNo;// 身份证号
	private String uniqueRelid;// 每个身份证号码关联的唯一uuid值

	public String getPC02DD01() {
		return PC02DD01;
	}

	public void setPC02DD01(String pC02DD01) {
		PC02DD01 = pC02DD01;
	}

	public String getPC02DS02() {
		return PC02DS02;
	}

	public void setPC02DS02(String pC02DS02) {
		PC02DS02 = pC02DS02;
	}

	public String getPC02DS03() {
		return PC02DS03;
	}

	public void setPC02DS03(String pC02DS03) {
		PC02DS03 = pC02DS03;
	}

	public String getPC02DJ01() {
		return PC02DJ01;
	}

	public void setPC02DJ01(String pC02DJ01) {
		PC02DJ01 = pC02DJ01;
	}

	public String getPC02DS04() {
		return PC02DS04;
	}

	public void setPC02DS04(String pC02DS04) {
		PC02DS04 = pC02DS04;
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