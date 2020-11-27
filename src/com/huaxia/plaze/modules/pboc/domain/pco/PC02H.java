package com.huaxia.plaze.modules.pboc.domain.pco;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

/**
 * 贷记卡账户汇总信息段
 * 
 * @author gaoh
 *
 */
@Alias("PC02H")
public class PC02H implements Serializable {
	private static final long serialVersionUID = -6962436201614684915L;
	private String PC02HS01;// 发卡机构数 [1..1] --
	private String PC02HS02;// 账户数 [1..1] --
	private String PC02HJ01;// 授信总额 [1..1] --
	private String PC02HJ02;// 单家行最高授信额 [1..1] --
	private String PC02HJ03;// 单家行最低授信额 [1..1] --
	private String PC02HJ04;// 已用额度 [1..1] --
	private String PC02HJ05;// 最近6个月平均使用额度 [1..1] --
	private String identityCardNo;// 身份证号
	private String uniqueRelid;// 每个身份证号码关联的唯一uuid值

	public String getPC02HS01() {
		return PC02HS01;
	}

	public void setPC02HS01(String pC02HS01) {
		PC02HS01 = pC02HS01;
	}

	public String getPC02HS02() {
		return PC02HS02;
	}

	public void setPC02HS02(String pC02HS02) {
		PC02HS02 = pC02HS02;
	}

	public String getPC02HJ01() {
		return PC02HJ01;
	}

	public void setPC02HJ01(String pC02HJ01) {
		PC02HJ01 = pC02HJ01;
	}

	public String getPC02HJ02() {
		return PC02HJ02;
	}

	public void setPC02HJ02(String pC02HJ02) {
		PC02HJ02 = pC02HJ02;
	}

	public String getPC02HJ03() {
		return PC02HJ03;
	}

	public void setPC02HJ03(String pC02HJ03) {
		PC02HJ03 = pC02HJ03;
	}

	public String getPC02HJ04() {
		return PC02HJ04;
	}

	public void setPC02HJ04(String pC02HJ04) {
		PC02HJ04 = pC02HJ04;
	}

	public String getPC02HJ05() {
		return PC02HJ05;
	}

	public void setPC02HJ05(String pC02HJ05) {
		PC02HJ05 = pC02HJ05;
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