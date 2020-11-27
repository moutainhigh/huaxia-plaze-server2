package com.huaxia.plaze.modules.pengyuan.domain;

/**
 * 鹏元个人信用报告深圳基本摘要信息电话欠费信息表
 * 
 * @author User
 *
 */
public class PyPcrCrsCrtSzbsiTs {

	// 记录编号
	private String uuid;
	// 创建时间
	private String crtTime;
	// 创建用户
	private String crtUser;
	// 交易编号
	private String trnId;
	// 是否有电话费欠缴记录
	private String isOweFee;
	// 信息获取时间
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

	public String getIsOweFee() {
		return isOweFee;
	}

	public void setIsOweFee(String isOweFee) {
		this.isOweFee = isOweFee;
	}

	public String getInfoDate() {
		return infoDate;
	}

	public void setInfoDate(String infoDate) {
		this.infoDate = infoDate;
	}

	@Override
	public String toString() {
		return "PyPcrCrsCrtSzbsiTs [uuid=" + uuid + ", crtTime=" + crtTime + ", crtUser=" + crtUser + ", trnId=" + trnId
				+ ", isOweFee=" + isOweFee + ", infoDate=" + infoDate + "]";
	}

}
