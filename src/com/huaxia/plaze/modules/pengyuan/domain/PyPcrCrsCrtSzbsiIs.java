package com.huaxia.plaze.modules.pengyuan.domain;

/**
 * 鹏元个人信用报告深圳基本摘要信息社保信息表
 * 
 * @author User
 *
 */
public class PyPcrCrsCrtSzbsiIs {

	// 记录编号
	private String uuid;
	// 创建时间
	private String crtTime;
	// 创建用户
	private String crtUser;
	// 交易编号
	private String trnId;
	// 最近申报缴费基数
	private Double insurePay;
	// 最近实际缴费基数
	private Double factInsurePay;
	// 投保状态
	private String currentStatus;
	// 信息获取时间
	private String infoDate;
	// 最近投保单位
	private String lastUnitName;
	
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
	public Double getInsurePay() {
		return insurePay;
	}
	public void setInsurePay(Double insurePay) {
		this.insurePay = insurePay;
	}
	public Double getFactInsurePay() {
		return factInsurePay;
	}
	public void setFactInsurePay(Double factInsurePay) {
		this.factInsurePay = factInsurePay;
	}
	public String getCurrentStatus() {
		return currentStatus;
	}
	public void setCurrentStatus(String currentStatus) {
		this.currentStatus = currentStatus;
	}
	public String getInfoDate() {
		return infoDate;
	}
	public void setInfoDate(String infoDate) {
		this.infoDate = infoDate;
	}
	public String getLastUnitName() {
		return lastUnitName;
	}
	public void setLastUnitName(String lastUnitName) {
		this.lastUnitName = lastUnitName;
	}
	@Override
	public String toString() {
		return "PyPcrCrsCrtSzbsiIs [uuid=" + uuid + ", crtTime=" + crtTime + ", crtUser=" + crtUser + ", trnId=" + trnId
				+ ", insurePay=" + insurePay + ", factInsurePay=" + factInsurePay + ", currentStatus=" + currentStatus
				+ ", infoDate=" + infoDate + ", lastUnitName=" + lastUnitName + "]";
	}


}
