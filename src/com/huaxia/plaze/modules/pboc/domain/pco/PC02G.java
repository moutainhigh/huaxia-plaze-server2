package com.huaxia.plaze.modules.pboc.domain.pco;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

/**
 * 循环贷账户汇总信息段
 * 
 * @author gaoh
 *
 */
@Alias("PC02G")
public class PC02G implements Serializable {
	private static final long serialVersionUID = 5705747361010847742L;
	private String PC02GS01;// 管理机构数 [1..1] --
	private String PC02GS02;// 账户数 [1..1] --
	private String PC02GJ01;// 授信总额 [1..1] --
	private String PC02GJ02;// 余额 [1..1] --
	private String PC02GJ03;// 最近6个月平均应还款 [1..1] --
	private String identityCardNo;// 身份证号
	private String uniqueRelid;// 每个身份证号码关联的唯一uuid值

	public String getPC02GS01() {
		return PC02GS01;
	}

	public void setPC02GS01(String pC02GS01) {
		PC02GS01 = pC02GS01;
	}

	public String getPC02GS02() {
		return PC02GS02;
	}

	public void setPC02GS02(String pC02GS02) {
		PC02GS02 = pC02GS02;
	}

	public String getPC02GJ01() {
		return PC02GJ01;
	}

	public void setPC02GJ01(String pC02GJ01) {
		PC02GJ01 = pC02GJ01;
	}

	public String getPC02GJ02() {
		return PC02GJ02;
	}

	public void setPC02GJ02(String pC02GJ02) {
		PC02GJ02 = pC02GJ02;
	}

	public String getPC02GJ03() {
		return PC02GJ03;
	}

	public void setPC02GJ03(String pC02GJ03) {
		PC02GJ03 = pC02GJ03;
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