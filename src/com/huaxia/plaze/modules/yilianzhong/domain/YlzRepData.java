package com.huaxia.plaze.modules.yilianzhong.domain;

import java.util.Date;

public class YlzRepData {

	//记录编号
	private String uuid;
	//创建时间
	private Date crtTime;
	//创建用户
	private String crtUser;
	//批次编号
	private String trnId;
	//单位名称
	private String companyName;
	//是否在职
	private String isOnJob;
	//参保状态
	private String insuredStatues;
	//还款能力
	private String repaymentAbility;
	//当前单位初缴日期
	private String beginPaymentDate;
	//最近一次交费日期
	private String latestPaymentDate;
	//返回原始报文体
	private String ResultJson;
	//证件号码
	private String certNo;

	public String getCertNo() {
		return certNo;
	}

	public void setCertNo(String certNo) {
		this.certNo = certNo;
	}

	public String getResultJson() {
		return ResultJson;
	}

	public void setResultJson(String resultJson) {
		ResultJson = resultJson;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public Date getCrtTime() {
		return crtTime;
	}

	public void setCrtTime(Date crtTime) {
		this.crtTime = crtTime;
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

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getIsOnJob() {
		return isOnJob;
	}

	public void setIsOnJob(String isOnJob) {
		this.isOnJob = isOnJob;
	}

	public String getInsuredStatues() {
		return insuredStatues;
	}

	public void setInsuredStatues(String insuredStatues) {
		this.insuredStatues = insuredStatues;
	}

	public String getRepaymentAbility() {
		return repaymentAbility;
	}

	public void setRepaymentAbility(String repaymentAbility) {
		this.repaymentAbility = repaymentAbility;
	}

	public String getBeginPaymentDate() {
		return beginPaymentDate;
	}

	public void setBeginPaymentDate(String beginPaymentDate) {
		this.beginPaymentDate = beginPaymentDate;
	}

	public String getLatestPaymentDate() {
		return latestPaymentDate;
	}

	public void setLatestPaymentDate(String latestPaymentDate) {
		this.latestPaymentDate = latestPaymentDate;
	}

//	public YlzRepData(String uuid, Date crtTime, String crtUser, String trnId, String companyName, String isOnJob,
//			String insuredStatues, String repaymentAbility, String beginPaymentDate, String latestPaymentDate) {
//		this.uuid = uuid;
//		this.crtTime = crtTime;
//		this.crtUser = crtUser;
//		this.trnId = trnId;
//		this.companyName = companyName;
//		this.isOnJob = isOnJob;
//		this.insuredStatues = insuredStatues;
//		this.repaymentAbility = repaymentAbility;
//		this.beginPaymentDate = beginPaymentDate;
//		this.latestPaymentDate = latestPaymentDate;
//	}

	public YlzRepData() {
	}

	public YlzRepData(String uuid, Date crtTime, String crtUser, String trnId, String companyName, String isOnJob,
			String insuredStatues, String repaymentAbility, String beginPaymentDate, String latestPaymentDate,
			String certNo) {
		super();
		this.uuid = uuid;
		this.crtTime = crtTime;
		this.crtUser = crtUser;
		this.trnId = trnId;
		this.companyName = companyName;
		this.isOnJob = isOnJob;
		this.insuredStatues = insuredStatues;
		this.repaymentAbility = repaymentAbility;
		this.beginPaymentDate = beginPaymentDate;
		this.latestPaymentDate = latestPaymentDate;
		this.certNo = certNo;
	}

	@Override
	public String toString() {
		return "YlzRepData [uuid=" + uuid + ", crtTime=" + crtTime + ", crtUser=" + crtUser + ", trnId=" + trnId
				+ ", companyName=" + companyName + ", isOnJob=" + isOnJob + ", insuredStatues=" + insuredStatues
				+ ", repaymentAbility=" + repaymentAbility + ", beginPaymentDate=" + beginPaymentDate
				+ ", latestPaymentDate=" + latestPaymentDate + ",  certNo=" + certNo
				+ "]";
	}

//	@Override
//	public String toString() {
//		return "YlzRepData [uuid=" + uuid + ", crtTime=" + crtTime + ", crtUser=" + crtUser + ", trnId=" + trnId
//				+ ", companyName=" + companyName + ", isOnJob=" + isOnJob + ", insuredStatues=" + insuredStatues
//				+ ", repaymentAbility=" + repaymentAbility + ", beginPaymentDate=" + beginPaymentDate
//				+ ", latestPaymentDate=" + latestPaymentDate + "]";
//	}

}
