package com.huaxia.plaze.modules.pengyuan.domain;

import java.util.Date;

/**
 * 鹏元个人信用报告历次任职信息表
 * 
 * @author User
 *
 */
public class PyPcrCrsCrtPbiJis {

	// 记录编号
	private String uuid;
	// 创建时间
	private Date crtTime;
	// 创建用户
	private String crtUser;
	// 交易编号
	private String trnId;
	// 工作单位
	private String employer;
	// 工作性质ID
	private String employerType;
	// 职业ID
	private String occupationType;
	// 职务ID
	private String positionType;
	// 职称ID
	private String titleType;
	// 信息来源单位ID
	private String inforUnit;
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

	public String getEmployer() {
		return employer;
	}

	public void setEmployer(String employer) {
		this.employer = employer;
	}

	public String getEmployerType() {
		return employerType;
	}

	public void setEmployerType(String employerType) {
		this.employerType = employerType;
	}

	public String getOccupationType() {
		return occupationType;
	}

	public void setOccupationType(String occupationType) {
		this.occupationType = occupationType;
	}

	public String getPositionType() {
		return positionType;
	}

	public void setPositionType(String positionType) {
		this.positionType = positionType;
	}

	public String getTitleType() {
		return titleType;
	}

	public void setTitleType(String titleType) {
		this.titleType = titleType;
	}

	public String getInforUnit() {
		return inforUnit;
	}

	public void setInforUnit(String inforUnit) {
		this.inforUnit = inforUnit;
	}

	public String getInfoDate() {
		return infoDate;
	}

	public void setInfoDate(String infoDate) {
		this.infoDate = infoDate;
	}

	@Override
	public String toString() {
		return "PyPcrCrsCrtPbiJis [uuid=" + uuid + ", crtTime=" + crtTime + ", crtUser=" + crtUser + ", trnId=" + trnId
				+ ", employer=" + employer + ", employerType=" + employerType + ", occupationType=" + occupationType
				+ ", positionType=" + positionType + ", titleType=" + titleType + ", inforUnit=" + inforUnit
				+ ", infoDate=" + infoDate + "]";
	}

}
