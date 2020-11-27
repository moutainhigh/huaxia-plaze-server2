package com.huaxia.plaze.modules.unicom.domain;
/**
 * 联通地址类信息   原始报文实体类
 * @author lipengfei
 *
 */
public class UnicomAddressMsgResponse {

	// 创建用户
	private String crtUser;
	// 业务主键
	private String trnId;
	// 报文体
	private String messageBody;
	
	
	public UnicomAddressMsgResponse() {
		super();
	}
	
	public UnicomAddressMsgResponse(String crtUser, String trnId, String messageBody) {
		super();
		this.crtUser = crtUser;
		this.trnId = trnId;
		this.messageBody = messageBody;
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
