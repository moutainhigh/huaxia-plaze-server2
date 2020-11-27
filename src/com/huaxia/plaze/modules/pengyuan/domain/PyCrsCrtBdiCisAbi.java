package com.huaxia.plaze.modules.pengyuan.domain;

/**
 * 
 * @author User 鹏元个人信用报告银行信用信息信用卡基本信息表
 */
public class PyCrsCrtBdiCisAbi {

	// 记录编号
	private String uuid;
	// 创建时间
	private String crtTime;
	// 创建用户
	private String crtUser;
	// 交易编号
	private String trnId;
	
	private String appId;
	// 信用卡号
	private String creditcardNO;
	// 信用卡名
	private String creditcardName;
	// 信用卡发放单位ID
	private String unit;
	// 信用卡类型ID
	private String creditcardType;
	// 信用卡级别ID
	private String creditcardGrade;
	// 信用卡币种
	private String currency;
	// 开户日期
	private String openDate;
	// 可透支额度
	private Double permittedOverdraft;
	// 当前信用卡状态ID
	private String status;
	// 信息获取日期
	private String infoDate;
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
	public String getAppId() {
		return appId;
	}
	public void setAppId(String appId) {
		this.appId = appId;
	}
	public String getCreditcardNO() {
		return creditcardNO;
	}
	public void setCreditcardNO(String creditcardNO) {
		this.creditcardNO = creditcardNO;
	}
	public String getCreditcardName() {
		return creditcardName;
	}
	public void setCreditcardName(String creditcardName) {
		this.creditcardName = creditcardName;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getCreditcardType() {
		return creditcardType;
	}
	public void setCreditcardType(String creditcardType) {
		this.creditcardType = creditcardType;
	}
	public String getCreditcardGrade() {
		return creditcardGrade;
	}
	public void setCreditcardGrade(String creditcardGrade) {
		this.creditcardGrade = creditcardGrade;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getOpenDate() {
		return openDate;
	}
	public void setOpenDate(String openDate) {
		this.openDate = openDate;
	}
	public Double getPermittedOverdraft() {
		return permittedOverdraft;
	}
	public void setPermittedOverdraft(Double permittedOverdraft) {
		this.permittedOverdraft = permittedOverdraft;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getInfoDate() {
		return infoDate;
	}
	public void setInfoDate(String infoDate) {
		this.infoDate = infoDate;
	}
	@Override
	public String toString() {
		return "PyCrsCrtBdiCisAbi [uuid=" + uuid + ", crtTime=" + crtTime + ", crtUser=" + crtUser + ", trnId=" + trnId
				+ ", appId=" + appId + ", creditcardNO=" + creditcardNO + ", creditcardName=" + creditcardName
				+ ", unit=" + unit + ", creditcardType=" + creditcardType + ", creditcardGrade=" + creditcardGrade
				+ ", currency=" + currency + ", openDate=" + openDate + ", permittedOverdraft=" + permittedOverdraft
				+ ", status=" + status + ", infoDate=" + infoDate + "]";
	}


}
