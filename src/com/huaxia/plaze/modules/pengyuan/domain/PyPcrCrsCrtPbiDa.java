package com.huaxia.plaze.modules.pengyuan.domain;

/**
 * 鹏元个人信用报告身份警示信息表
 * 
 * @author User
 *
 */
public class PyPcrCrsCrtPbiDa {

	// 记录编号
	private String uuid;
	// 创建时间
	private String crtTime;
	// 创建用户
	private String crtUser;
	// 交易编号
	private String trnId;
	// 规范化后的姓名
	private String name;
	// 规范化后的证件号码
	private String documentNo;
	// 证件类型ID
	private String documentType;
	// 证件签发地
	private String country;
	// 性别ID
	private String gender;
	// 出生日期
	private String birthday;
	// 信息获取日期
	private String infoDate;

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDocumentNo() {
		return documentNo;
	}

	public void setDocumentNo(String documentNo) {
		this.documentNo = documentNo;
	}

	public String getDocumentType() {
		return documentType;
	}

	public void setDocumentType(String documentType) {
		this.documentType = documentType;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getInfoDate() {
		return infoDate;
	}

	public void setInfoDate(String infoDate) {
		this.infoDate = infoDate;
	}

	@Override
	public String toString() {
		return "PyPcrCrsCrtPbiDa [uuid=" + uuid + ", crtTime=" + crtTime + ", crtUser=" + crtUser + ", trnId=" + trnId
				+ ", name=" + name + ", documentNo=" + documentNo + ", documentType=" + documentType + ", country="
				+ country + ", gender=" + gender + ", birthday=" + birthday + ", infoDate=" + infoDate + "]";
	}

}
