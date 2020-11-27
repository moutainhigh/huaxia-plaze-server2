package com.huaxia.plaze.modules.unicom.domain;


/**
 * 
 * @author dingguofeng
 * 联通在网时长  原始报文  封装实体类
 *
 */
public class UnicomOnlineMsgResponse {

	
	/** 创建用户 */
	private String crtUser;
	
	/** 业务主键 */
	private String trnId;
	
	/** 原始报文 */
	private String messageBody;

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
