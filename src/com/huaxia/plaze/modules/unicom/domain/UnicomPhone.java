package com.huaxia.plaze.modules.unicom.domain;

/**
 * 
 * @author dingguofeng
 * 联通返回报文封装实体类
 *
 */
public class UnicomPhone {
	
	/** 创建用户 */
	private String crtUser;
	
	/** 业务主键 */
	private String trnId;
	
	/** 状态码 */
	private String status;
	
	/** 返回码 */
	private String code;
	
	/** 返回码的中文描述 */
	private String errorDesc;
	
	/** 校验结果 */
	private String checkResult;
	
	/** 运营商类别 */
	private String carrier;
	
	/** 证件号 */
	private String certNo;

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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getErrorDesc() {
		return errorDesc;
	}

	public void setErrorDesc(String errorDesc) {
		this.errorDesc = errorDesc;
	}

	public String getCheckResult() {
		return checkResult;
	}

	public void setCheckResult(String checkResult) {
		this.checkResult = checkResult;
	}

	public String getCarrier() {
		return carrier;
	}

	public void setCarrier(String carrier) {
		this.carrier = carrier;
	}

	public String getCertNo() {
		return certNo;
	}

	public void setCertNo(String certNo) {
		this.certNo = certNo;
	}
	
}
