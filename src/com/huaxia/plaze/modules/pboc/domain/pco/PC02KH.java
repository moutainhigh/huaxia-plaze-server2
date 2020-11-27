package com.huaxia.plaze.modules.pboc.domain.pco;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

/**
 * 相关还款责任汇总信息
 * 
 * @author gaoh
 *
 */
@Alias("PC02KH")
public class PC02KH implements Serializable {

	private static final long serialVersionUID = 8637455080355120280L;
	private String PC02KD01;// 借款 人身份类别 [1..1] --
	private String PC02KD02;// 还款责任类型 [1..1] --
	private String PC02KS02;// 账户数 [1..1] --
	private String PC02KJ01;// 还款责任金额 [1..1] --
	private String PC02KJ02;// 余额 [1..1] --
	private String identityCardNo;// 身份证号
	private String uniqueRelid;// 每个身份证号码关联的唯一uuid值

	public String getPC02KD01() {
		return PC02KD01;
	}

	public void setPC02KD01(String pC02KD01) {
		PC02KD01 = pC02KD01;
	}

	public String getPC02KD02() {
		return PC02KD02;
	}

	public void setPC02KD02(String pC02KD02) {
		PC02KD02 = pC02KD02;
	}

	public String getPC02KS02() {
		return PC02KS02;
	}

	public void setPC02KS02(String pC02KS02) {
		PC02KS02 = pC02KS02;
	}

	public String getPC02KJ01() {
		return PC02KJ01;
	}

	public void setPC02KJ01(String pC02KJ01) {
		PC02KJ01 = pC02KJ01;
	}

	public String getPC02KJ02() {
		return PC02KJ02;
	}

	public void setPC02KJ02(String pC02KJ02) {
		PC02KJ02 = pC02KJ02;
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