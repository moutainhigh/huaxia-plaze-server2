package com.huaxia.plaze.modules.hz.domain.data;

public class WaterAffairsInfo {
	
	private String trnId;
	private String servCode;
	private String collectionDt;
	private String paymentStatus;
	private String crtUser;
	
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
	public String getServCode() {
		return servCode;
	}
	public void setServCode(String servCode) {
		this.servCode = servCode;
	}
	public String getCollectionDt() {
		return collectionDt;
	}
	public void setCollectionDt(String collectionDt) {
		this.collectionDt = collectionDt;
	}
	public String getPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	
	

}
