package com.huaxia.plaze.modules.bairong.domain;

import java.util.Date;

/**
 * 百融借贷意向基础表
 * 
 * @author liuwei
 * @author zhiguo.li, 2019-09-11, 增加"uukey"属性，解决同一笔交易重发数据完整性问题。
 */
public class ApplyLoanStrBase {
	
	// 数据库关联使用，无业务涵义。
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

	// 身份证号码
	private String certNo;

	// 手机号码
	private String mobile;

	// 姓名
	private String name;

	// 返回的number编号
	private String swiftNumber;

	// 返回的code
	private String code;

	// 产品输出标识
	private String flagApplyloanstr;

	//发卡账户
	private String cradAccount;
	
	//序号
	private Long sequence;
	
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

	public String getCertNo() {
		return certNo;
	}

	public String getMobile() {
		return mobile;
	}

	public String getName() {
		return name;
	}

	public String getSwiftNumber() {
		return swiftNumber;
	}

	public String getCode() {
		return code;
	}

	public String getFlagApplyloanstr() {
		return flagApplyloanstr;
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

	public void setCertNo(String certNo) {
		this.certNo = certNo;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSwiftNumber(String swiftNumber) {
		this.swiftNumber = swiftNumber;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setFlagApplyloanstr(String flagApplyloanstr) {
		this.flagApplyloanstr = flagApplyloanstr;
	}

	public String getTrnKey() {
		return trnKey;
	}

	public void setTrnKey(String trnKey) {
		this.trnKey = trnKey;
	}

	public String getCradAccount() {
		return cradAccount;
	}

	public void setCradAccount(String cradAccount) {
		this.cradAccount = cradAccount;
	}

	public Long getSequence() {
		return sequence;
	}

	public void setSequence(Long sequence) {
		this.sequence = sequence;
	}

	
}
