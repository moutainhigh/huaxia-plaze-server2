package com.huaxia.plaze.modules.unicom.domain;
/**
 * 联通地址类信息,结果报文解析入库实体类
 * @author lipengfei
 *
 */
public class UnicomAddress {

	// 创建用户
	private String crtUser; 
	
	// 交易编号
	private String trnId;
	
	// 交易关联键
	private String trnKey;
	
	// 产品ID
	private String apiKey;
	
	// 状态码
	private String status;
	
	// 返回码
	private String code;
	
	// 返回码中文描述
	private String errorDesc;
	
	// 校验结果
	private String checkResult;
	
	// 校验结果中文描述
	private String checkDesc;
	
	// 运行商类别
	private String carrier;
	
	// 手机号码
	private String mobile;

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

	public String getTrnKey() {
		return trnKey;
	}

	public void setTrnKey(String trnKey) {
		this.trnKey = trnKey;
	}

	public String getApiKey() {
		return apiKey;
	}

	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
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

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getCheckDesc() {
		return checkDesc;
	}

	public void setCheckDesc(String checkDesc) {
		this.checkDesc = checkDesc;
	}
	
}
