package com.huaxia.plaze.modules.hz.domain;

public class HzMsgResponse {
	
	
	private String crtUser; // 创建用户
		
	private String trnId; // 交易编号
	
	private String messageBody; // 响应报文体

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

	public String getMessageBody() {
		return messageBody;
	}

	public void setMessageBody(String messageBody) {
		this.messageBody = messageBody;
	}
	
}
