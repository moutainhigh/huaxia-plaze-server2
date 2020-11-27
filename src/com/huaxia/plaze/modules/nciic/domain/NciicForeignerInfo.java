package com.huaxia.plaze.modules.nciic.domain;

import java.io.Serializable;

/**
 * 第三方 & 外国人永久居留证
 * 
 * @author liyanan
 *
 */
public class NciicForeignerInfo implements Serializable {
	
	private String uuid;

	// 申请件编号
	private String trnId;

	// 创建时间
	private String crtTime;

	// 创建人
	private String crtUser;

	//使用单位 
	private String sbm;
	
	//业务发生地 
	private String fsd;
	
	//业务类型 
	private String ywlx;
	
	//证件号码
	private String zjhm;
	
	//姓名
	private String xm;
	
	//出生日期
	private String csrq;
	
	//证件有效期日
	private String zjyxqr;
	
	//最新版本号 
	private String zxbbh;
	
	//核查结果 
	private String resultCode;
	
	// 错误代码
	private String errorCode;

	// 错误描述/缺失必录项描述
	private String errorMessage;

	// 缺失必录项字段名称
	private String errorMessageCol;
	
	//证件类型 
	private String certType;
	
	//原报文 冗余字段 暂时存放一下
	private String bodyStr; 
	
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

	public String getCrtUser() {
		return crtUser;
	}

	public void setCrtUser(String crtUser) {
		this.crtUser = crtUser;
	}

	public String getCrtTime() {
		return crtTime;
	}

	public void setCrtTime(String crtTime) {
		this.crtTime = crtTime;
	}

	public String getXm() {
		return xm;
	}

	public void setXm(String xm) {
		this.xm = xm;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getErrorMessageCol() {
		return errorMessageCol;
	}

	public void setErrorMessageCol(String errorMessageCol) {
		this.errorMessageCol = errorMessageCol;
	}

	public String getSbm() {
		return sbm;
	}

	public String getFsd() {
		return fsd;
	}

	public String getYwlx() {
		return ywlx;
	}

	public String getZjhm() {
		return zjhm;
	}

	public String getCsrq() {
		return csrq;
	}

	public String getZjyxqr() {
		return zjyxqr;
	}

	public String getZxbbh() {
		return zxbbh;
	}

	public String getResultCode() {
		return resultCode;
	}

	public void setSbm(String sbm) {
		this.sbm = sbm;
	}

	public void setFsd(String fsd) {
		this.fsd = fsd;
	}

	public void setYwlx(String ywlx) {
		this.ywlx = ywlx;
	}

	public void setZjhm(String zjhm) {
		this.zjhm = zjhm;
	}

	public void setCsrq(String csrq) {
		this.csrq = csrq;
	}

	public void setZjyxqr(String zjyxqr) {
		this.zjyxqr = zjyxqr;
	}

	public void setZxbbh(String zxbbh) {
		this.zxbbh = zxbbh;
	}

	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}

	public String getBodyStr() {
		return bodyStr;
	}

	public void setBodyStr(String bodyStr) {
		this.bodyStr = bodyStr;
	}

	public String getCertType() {
		return certType;
	}

	public void setCertType(String certType) {
		this.certType = certType;
	}
	
}
