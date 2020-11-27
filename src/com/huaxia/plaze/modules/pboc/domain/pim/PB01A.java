package com.huaxia.plaze.modules.pboc.domain.pim;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

/**
 * 基本概况信息段
 * 
 * @author gaoh
 *
 */
@Alias("PB01A")
public class PB01A implements Serializable {

	private static final long serialVersionUID = -4197050529363090429L;
	private String PB01AD01;// 性别 -- [1..1]
	private String PB01AR01;// 出生日期 -- [1..1]
	private String PB01AD02;// 学历 -- [1..1]
	private String PB01AD03;// 学位 -- [1..1]
	private String PB01AD04;// 就业状况 -- [1..1]
	private String PB01AQ01;// 电子邮箱 -- [1..1]
	private String PB01AQ02;// 通讯地址 -- [1..1]
	private String PB01AD05;// 国籍 -- [1..1]
	private String PB01AQ03;// 户籍地址 -- [1..1]
	private String identityCardNo;// 身份证号
	private String uniqueRelid;// 每个身份证号码关联的唯一uuid值

	public String getPB01AD01() {
		return PB01AD01;
	}

	public void setPB01AD01(String pB01AD01) {
		PB01AD01 = pB01AD01;
	}

	public String getPB01AR01() {
		return PB01AR01;
	}

	public void setPB01AR01(String pB01AR01) {
		PB01AR01 = pB01AR01;
	}

	public String getPB01AD02() {
		return PB01AD02;
	}

	public void setPB01AD02(String pB01AD02) {
		PB01AD02 = pB01AD02;
	}

	public String getPB01AD03() {
		return PB01AD03;
	}

	public void setPB01AD03(String pB01AD03) {
		PB01AD03 = pB01AD03;
	}

	public String getPB01AD04() {
		return PB01AD04;
	}

	public void setPB01AD04(String pB01AD04) {
		PB01AD04 = pB01AD04;
	}

	public String getPB01AQ01() {
		return PB01AQ01;
	}

	public void setPB01AQ01(String pB01AQ01) {
		PB01AQ01 = pB01AQ01;
	}

	public String getPB01AQ02() {
		return PB01AQ02;
	}

	public void setPB01AQ02(String pB01AQ02) {
		PB01AQ02 = pB01AQ02;
	}

	public String getPB01AD05() {
		return PB01AD05;
	}

	public void setPB01AD05(String pB01AD05) {
		PB01AD05 = pB01AD05;
	}

	public String getPB01AQ03() {
		return PB01AQ03;
	}

	public void setPB01AQ03(String pB01AQ03) {
		PB01AQ03 = pB01AQ03;
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