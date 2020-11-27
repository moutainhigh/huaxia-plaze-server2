package com.huaxia.plaze.modules.id5.domain;

import java.util.Date;

/**
 * 第三方 & 学历
 * 
 * @author zhiguo.li
 *
 */
public class Id5Response {

	private String crtUser;
	private String trnId;
	private String messageBody;
	private String responseCode;
	public String getResponseCode() {
		return responseCode;
	}
	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
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
	public String getMessageBody() {
		return messageBody;
	}
	public void setMessageBody(String messageBody) {
		this.messageBody = messageBody;
	}

	
	
}
