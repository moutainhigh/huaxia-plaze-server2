package com.huaxia.plaze.modules.bairong.domain;

import java.util.Date;

/**
 * 百融距最早相关机构申请的相关天数
 * 
 * @author liuwei
 */
public class ApplyLoanStrFst {
	
	private String trnKey;

	// 主键唯一
	private String uuid;

	// 创建时间
	private Date crtTime;

	// 创建用户
	private String crtUser;

	// 业务的主键，实现不同系统之间的同步
	private String trnId;

	// 申请件编号
	private String appId;

	// 按身份证号查询，距最早在银行机构申请的间隔天数
	private String fstIdBankInteday;

	// 按身份证号查询，距最早在非银行机构申请的间隔天数
	private String fstIdNbankInteday;

	// 按手机号查询，距最早在银行机构申请的间隔天数
	private String fstCellBankInteday;

	// 按手机号查询，距最早在非银机构申请的间隔天数
	private String fstCellNbankInteday;

	public String getUuid() {
		return uuid;
	}

	public Date getCrtTime() {
		return crtTime;
	}

	public String getCrtUser() {
		return crtUser;
	}

	public String getTrnId() {
		return trnId;
	}

	public String getAppId() {
		return appId;
	}

	public String getFstIdBankInteday() {
		return fstIdBankInteday;
	}

	public String getFstIdNbankInteday() {
		return fstIdNbankInteday;
	}

	public String getFstCellBankInteday() {
		return fstCellBankInteday;
	}

	public String getFstCellNbankInteday() {
		return fstCellNbankInteday;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public void setCrtTime(Date crtTime) {
		this.crtTime = crtTime;
	}

	public void setCrtUser(String crtUser) {
		this.crtUser = crtUser;
	}

	public void setTrnId(String trnId) {
		this.trnId = trnId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public void setFstIdBankInteday(String fstIdBankInteday) {
		this.fstIdBankInteday = fstIdBankInteday;
	}

	public void setFstIdNbankInteday(String fstIdNbankInteday) {
		this.fstIdNbankInteday = fstIdNbankInteday;
	}

	public void setFstCellBankInteday(String fstCellBankInteday) {
		this.fstCellBankInteday = fstCellBankInteday;
	}

	public void setFstCellNbankInteday(String fstCellNbankInteday) {
		this.fstCellNbankInteday = fstCellNbankInteday;
	}

	public String getTrnKey() {
		return trnKey;
	}

	public void setTrnKey(String trnKey) {
		this.trnKey = trnKey;
	}

}
