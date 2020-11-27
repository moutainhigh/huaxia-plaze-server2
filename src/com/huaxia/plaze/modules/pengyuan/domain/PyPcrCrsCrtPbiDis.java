package com.huaxia.plaze.modules.pengyuan.domain;

import java.util.Date;

/**
 * 鹏元个人信用报告证件信息表
 * 
 * @author User
 *
 */
public class PyPcrCrsCrtPbiDis {

	// 记录编号
	private String uuid;
	// 创建时间
	private Date crtTime;
	// 创建用户
	private String crtUser;
	// 交易编号
	private String trnId;
	// 规范化后姓名
	private String name;
	// 规范化后证件号码
	private String documentNo;
	// 证件类型ID
	private String documentType;
	// 证件签发地
	private String country;
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

	public Date getCrtTime() {
		return crtTime;
	}

	public void setCrtTime(Date crtTime) {
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

	public String getInfoDate() {
		return infoDate;
	}

	public void setInfoDate(String infoDate) {
		this.infoDate = infoDate;
	}

	@Override
	public String toString() {
		return "PyPcrCrsCrtPbiDis [uuid=" + uuid + ", crtTime=" + crtTime + ", crtUser=" + crtUser + ", trnId=" + trnId
				+ ", name=" + name + ", documentNo=" + documentNo + ", documentType=" + documentType + ", country="
				+ country + ", infoDate=" + infoDate + "]";
	}

}
