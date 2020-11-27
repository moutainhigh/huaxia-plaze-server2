package com.huaxia.plaze.modules.pboc.domain.pqo;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

/**
 * 查询记录汇总信息段
 * 
 * @author gaoh
 *
 */
@Alias("PC05B")
public class PC05B implements Serializable {

	private static final long serialVersionUID = 2670867502925462925L;
	private String PC05BS01;// 最近1个月内的查询机构数（贷款审批） -- [1..1]
	private String PC05BS02;// 最近1个月内的查询机构数（信用卡审批） -- [1..1]
	private String PC05BS03;// 最近1个月内的查询次数（贷款审批） -- [1..1]
	private String PC05BS04;// 最近1个月内的查询次数（信用卡审批） -- [1..1]
	private String PC05BS05;// 最近1个月内的查询次数（本人查询） -- [1..1]
	private String PC05BS06;// 最近2年内的查询次数（贷后管理） -- [1..1]
	private String PC05BS07;// 最近2年内的查询次数（担保资格审查） -- [1..1]
	private String PC05BS08;// 最近2年内的查询次数（特约商户实名审查） -- [1..1]
	private String identityCardNo;// 身份证号
	private String uniqueRelid;// 每个身份证号码关联的唯一uuid值

	public String getPC05BS01() {
		return PC05BS01;
	}

	public void setPC05BS01(String pC05BS01) {
		PC05BS01 = pC05BS01;
	}

	public String getPC05BS02() {
		return PC05BS02;
	}

	public void setPC05BS02(String pC05BS02) {
		PC05BS02 = pC05BS02;
	}

	public String getPC05BS03() {
		return PC05BS03;
	}

	public void setPC05BS03(String pC05BS03) {
		PC05BS03 = pC05BS03;
	}

	public String getPC05BS04() {
		return PC05BS04;
	}

	public void setPC05BS04(String pC05BS04) {
		PC05BS04 = pC05BS04;
	}

	public String getPC05BS05() {
		return PC05BS05;
	}

	public void setPC05BS05(String pC05BS05) {
		PC05BS05 = pC05BS05;
	}

	public String getPC05BS06() {
		return PC05BS06;
	}

	public void setPC05BS06(String pC05BS06) {
		PC05BS06 = pC05BS06;
	}

	public String getPC05BS07() {
		return PC05BS07;
	}

	public void setPC05BS07(String pC05BS07) {
		PC05BS07 = pC05BS07;
	}

	public String getPC05BS08() {
		return PC05BS08;
	}

	public void setPC05BS08(String pC05BS08) {
		PC05BS08 = pC05BS08;
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