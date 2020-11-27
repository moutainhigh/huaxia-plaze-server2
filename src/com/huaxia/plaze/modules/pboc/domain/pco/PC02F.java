package com.huaxia.plaze.modules.pboc.domain.pco;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

/**
 * 循环额度下分账户汇总信息段
 * 
 * @author gaoh
 *
 */
@Alias("PC02F")
public class PC02F implements Serializable {
	private static final long serialVersionUID = 6003633198682035269L;
	private String PC02FS01;// 管理机构数 [1..1] --
	private String PC02FS02;// 账户数 [1..1] --
	private String PC02FJ01;// 授信总额 [1..1] --
	private String PC02FJ02;// 余额 [1..1] --
	private String PC02FJ03;// 最近6个月平均应还款 [1..1] --
	private String identityCardNo;// 身份证号
	private String uniqueRelid;// 每个身份证号码关联的唯一uuid值

	public String getPC02FS01() {
		return PC02FS01;
	}

	public void setPC02FS01(String pC02FS01) {
		PC02FS01 = pC02FS01;
	}

	public String getPC02FS02() {
		return PC02FS02;
	}

	public void setPC02FS02(String pC02FS02) {
		PC02FS02 = pC02FS02;
	}

	public String getPC02FJ01() {
		return PC02FJ01;
	}

	public void setPC02FJ01(String pC02FJ01) {
		PC02FJ01 = pC02FJ01;
	}

	public String getPC02FJ02() {
		return PC02FJ02;
	}

	public void setPC02FJ02(String pC02FJ02) {
		PC02FJ02 = pC02FJ02;
	}

	public String getPC02FJ03() {
		return PC02FJ03;
	}

	public void setPC02FJ03(String pC02FJ03) {
		PC02FJ03 = pC02FJ03;
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