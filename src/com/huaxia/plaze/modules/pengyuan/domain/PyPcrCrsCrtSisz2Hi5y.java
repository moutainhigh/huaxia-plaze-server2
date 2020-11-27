package com.huaxia.plaze.modules.pengyuan.domain;

/**
 * 鹏元个人信用报告个人社会保险近5年内参保历史信息表
 * 
 * @author User
 *
 */
public class PyPcrCrsCrtSisz2Hi5y {

	// 记录编号
	private String uuid;
	// 创建时间
	private String crtTime;
	// 创建用户
	private String crtUser;
	// 交易编号
	private String trnId;
	// 信息获取日期
	private String infoDate;
	// 单位名称
	private String unitName;
	// 参保单位类型
	private String unitType;
	// 参保种类ID
	private String insuranceType;
	// 参保起始月份
	private String startDate;
	// 参保终止月份
	private String endDate;
	// tartDate至endDate时间段内该单位参保情况
	private String insuranceState;

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

	public String getInfoDate() {
		return infoDate;
	}

	public void setInfoDate(String infoDate) {
		this.infoDate = infoDate;
	}

	public String getUnitName() {
		return unitName;
	}

	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}

	public String getUnitType() {
		return unitType;
	}

	public void setUnitType(String unitType) {
		this.unitType = unitType;
	}

	public String getInsuranceType() {
		return insuranceType;
	}

	public void setInsuranceType(String insuranceType) {
		this.insuranceType = insuranceType;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getInsuranceState() {
		return insuranceState;
	}

	public void setInsuranceState(String insuranceState) {
		this.insuranceState = insuranceState;
	}

	@Override
	public String toString() {
		return "PyPcrCrsCrtSisz2Hi5y [uuid=" + uuid + ", crtTime=" + crtTime + ", crtUser=" + crtUser + ", trnId="
				+ trnId + ", infoDate=" + infoDate + ", unitName=" + unitName + ", unitType=" + unitType
				+ ", insuranceType=" + insuranceType + ", startDate=" + startDate + ", endDate=" + endDate
				+ ", insuranceState=" + insuranceState + "]";
	}

}
