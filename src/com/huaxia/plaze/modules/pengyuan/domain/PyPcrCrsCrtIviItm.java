package com.huaxia.plaze.modules.pengyuan.domain;

/**
 * 鹏元个人信用报告身份证号码校验信息内容表
 * 
 * @author User
 *
 */
public class PyPcrCrsCrtIviItm {

	// 记录编号
	private String uuid;
	// 创建时间
	private String crtTime;
	// 创建用户
	private String crtUser;
	// 交易编号
	private String trnId;
	// 被查询者证件号码
	private String documentNo;
	// 出生日期
	private String birthday;
	// 性别ID
	private String gender;
	// 原始发证地区
	private String originalAddress;
	// 校验位校验结果
	private String verifyOfParity;
	// 地区位校验结果
	private String verifyOfArea;
	// 出生日期位校验结果
	private String verifyOfBirthday;
	// 是否18位证件号码
	private String is18Indentify;
	// 校验结果
	private String verifyResult;

	private String appId;

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getCrtTime() {
		return crtTime;
	}

	public void setCrtTime(String crtTime) {
		this.crtTime = crtTime;
	}

	public String getCrtUser() {
		return crtUser;
	}

	public void setCrtUser(String crtUser) {
		this.crtUser = crtUser;
	}

	public String getTrnId() {
		return trnId;
	}

	public void setTrnId(String trnId) {
		this.trnId = trnId;
	}

	public String getDocumentNo() {
		return documentNo;
	}

	public void setDocumentNo(String documentNo) {
		this.documentNo = documentNo;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getOriginalAddress() {
		return originalAddress;
	}

	public void setOriginalAddress(String originalAddress) {
		this.originalAddress = originalAddress;
	}

	public String getVerifyOfParity() {
		return verifyOfParity;
	}

	public void setVerifyOfParity(String verifyOfParity) {
		this.verifyOfParity = verifyOfParity;
	}

	public String getVerifyOfArea() {
		return verifyOfArea;
	}

	public void setVerifyOfArea(String verifyOfArea) {
		this.verifyOfArea = verifyOfArea;
	}

	public String getVerifyOfBirthday() {
		return verifyOfBirthday;
	}

	public void setVerifyOfBirthday(String verifyOfBirthday) {
		this.verifyOfBirthday = verifyOfBirthday;
	}

	public String getIs18Indentify() {
		return is18Indentify;
	}

	public void setIs18Indentify(String is18Indentify) {
		this.is18Indentify = is18Indentify;
	}

	public String getVerifyResult() {
		return verifyResult;
	}

	public void setVerifyResult(String verifyResult) {
		this.verifyResult = verifyResult;
	}

	@Override
	public String toString() {
		return "PyPcrCrsCrtIviItm [uuid=" + uuid + ", crtTime=" + crtTime + ", crtUser=" + crtUser + ", trnId=" + trnId
				+ ", documentNo=" + documentNo + ", birthday=" + birthday + ", gender=" + gender + ", originalAddress="
				+ originalAddress + ", verifyOfParity=" + verifyOfParity + ", verifyOfArea=" + verifyOfArea
				+ ", verifyOfBirthday=" + verifyOfBirthday + ", is18Indentify=" + is18Indentify + ", verifyResult="
				+ verifyResult + "]";
	}

}
