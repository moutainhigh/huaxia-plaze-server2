package com.huaxia.plaze.modules.baoxin.domain;

public class BaoXinBase {

	private String uuid;

	// 业务主键编号
	private String trnId;

	// 创建时间
	private String crtTime;

	// 创建人
	private String crtUser;
	// 交易流水号
	private String insurerUuid;
	//非营业个人车辆风险价值
	private String riskValueRange;
	//车龄
	private String carAge;
	
	private String certNo;
	
	private String retCode;
	
	private String retMessage;
	
	private String bankCode;
	
	private String returnTime;

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getTrnId() {
		return trnId;
	}

	public void setTrnId(String trnId) {
		this.trnId = trnId;
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

	public String getInsurerUuid() {
		return insurerUuid;
	}

	public void setInsurerUuid(String insurerUuid) {
		this.insurerUuid = insurerUuid;
	}

	public String getRiskValueRange() {
		return riskValueRange;
	}

	public void setRiskValueRange(String riskValueRange) {
		this.riskValueRange = riskValueRange;
	}

	public String getCarAge() {
		return carAge;
	}

	public void setCarAge(String carAge) {
		this.carAge = carAge;
	}

	public String getCertNo() {
		return certNo;
	}

	public void setCertNo(String certNo) {
		this.certNo = certNo;
	}

	public String getRetCode() {
		return retCode;
	}

	public void setRetCode(String retCode) {
		this.retCode = retCode;
	}

	public String getRetMessage() {
		return retMessage;
	}

	public void setRetMessage(String retMessage) {
		this.retMessage = retMessage;
	}

	public String getBankCode() {
		return bankCode;
	}

	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}

	public String getReturnTime() {
		return returnTime;
	}

	public void setReturnTime(String returnTime) {
		this.returnTime = returnTime;
	}
	
	
	

}
