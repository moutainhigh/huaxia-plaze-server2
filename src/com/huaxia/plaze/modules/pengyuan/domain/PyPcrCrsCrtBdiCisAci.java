package com.huaxia.plaze.modules.pengyuan.domain;

/**
 * 
 * @author User 鹏元个人信用报告银行信用信息信用卡账户动态信息表
 */
public class PyPcrCrsCrtBdiCisAci {

	// 记录编号
	private String uuid;
	// 创建时间
	private String crtTime;
	// 创建用户
	private String crtUser;
	// 交易编号
	private String trnId;
	// 上月透支余额
	private Double overdraftBalanceForLastMonth;
	// 上月透支发生金额
	private Double overdraftOccurForLastMonth;
	// 上月取现金额
	private Double withdrawForLastMonth;
	// 上月取现次数
	private Integer withdrawTimesForLastMonth;
	// 上月消费金额
	private Double purchaseForLastMonth;
	// 上月消费次数
	private Integer purchaseTimesForLastMonth;
	// 上月消费金额
	private Double overdraftForLast6Month;
	// 近上月消费次数
	private Double purchaseForLast6Month;
	// 近6个月消费总次数
	private Integer purchaseTimesForLast6Month;
	// 近6个月透支总额
	private Double withdrawForLast6Month;
	// 近6个月取现总次数
	private Integer withdrawTimesForLast6Month;
	// 近12个月透支总额
	private Double overdraftForLast12Month;
	// 近12个月消费总额
	private Double purchaseForLast12Month;
	// 近12个月取现总额
	private Double withdrawForLast12Month;
	// 最近月份的信息获取日期
	private String infoDate;

	private String appId;

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getCrtTime() {
		return crtTime;
	}

	public void setCrtTime(String crtTime) {
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

	public Double getOverdraftBalanceForLastMonth() {
		return overdraftBalanceForLastMonth;
	}

	public void setOverdraftBalanceForLastMonth(Double overdraftBalanceForLastMonth) {
		this.overdraftBalanceForLastMonth = overdraftBalanceForLastMonth;
	}

	public Double getOverdraftOccurForLastMonth() {
		return overdraftOccurForLastMonth;
	}

	public void setOverdraftOccurForLastMonth(Double overdraftOccurForLastMonth) {
		this.overdraftOccurForLastMonth = overdraftOccurForLastMonth;
	}

	public Double getWithdrawForLastMonth() {
		return withdrawForLastMonth;
	}

	public void setWithdrawForLastMonth(Double withdrawForLastMonth) {
		this.withdrawForLastMonth = withdrawForLastMonth;
	}

	public Integer getWithdrawTimesForLastMonth() {
		return withdrawTimesForLastMonth;
	}

	public void setWithdrawTimesForLastMonth(Integer withdrawTimesForLastMonth) {
		this.withdrawTimesForLastMonth = withdrawTimesForLastMonth;
	}

	public Double getPurchaseForLastMonth() {
		return purchaseForLastMonth;
	}

	public void setPurchaseForLastMonth(Double purchaseForLastMonth) {
		this.purchaseForLastMonth = purchaseForLastMonth;
	}

	public Integer getPurchaseTimesForLastMonth() {
		return purchaseTimesForLastMonth;
	}

	public void setPurchaseTimesForLastMonth(Integer purchaseTimesForLastMonth) {
		this.purchaseTimesForLastMonth = purchaseTimesForLastMonth;
	}

	public Double getOverdraftForLast6Month() {
		return overdraftForLast6Month;
	}

	public void setOverdraftForLast6Month(Double overdraftForLast6Month) {
		this.overdraftForLast6Month = overdraftForLast6Month;
	}

	public Double getPurchaseForLast6Month() {
		return purchaseForLast6Month;
	}

	public void setPurchaseForLast6Month(Double purchaseForLast6Month) {
		this.purchaseForLast6Month = purchaseForLast6Month;
	}

	public Integer getPurchaseTimesForLast6Month() {
		return purchaseTimesForLast6Month;
	}

	public void setPurchaseTimesForLast6Month(Integer purchaseTimesForLast6Month) {
		this.purchaseTimesForLast6Month = purchaseTimesForLast6Month;
	}

	public Double getWithdrawForLast6Month() {
		return withdrawForLast6Month;
	}

	public void setWithdrawForLast6Month(Double withdrawForLast6Month) {
		this.withdrawForLast6Month = withdrawForLast6Month;
	}

	public Integer getWithdrawTimesForLast6Month() {
		return withdrawTimesForLast6Month;
	}

	public void setWithdrawTimesForLast6Month(Integer withdrawTimesForLast6Month) {
		this.withdrawTimesForLast6Month = withdrawTimesForLast6Month;
	}

	public Double getOverdraftForLast12Month() {
		return overdraftForLast12Month;
	}

	public void setOverdraftForLast12Month(Double overdraftForLast12Month) {
		this.overdraftForLast12Month = overdraftForLast12Month;
	}

	public Double getPurchaseForLast12Month() {
		return purchaseForLast12Month;
	}

	public void setPurchaseForLast12Month(Double purchaseForLast12Month) {
		this.purchaseForLast12Month = purchaseForLast12Month;
	}

	public Double getWithdrawForLast12Month() {
		return withdrawForLast12Month;
	}

	public void setWithdrawForLast12Month(Double withdrawForLast12Month) {
		this.withdrawForLast12Month = withdrawForLast12Month;
	}

	public String getInfoDate() {
		return infoDate;
	}

	public void setInfoDate(String infoDate) {
		this.infoDate = infoDate;
	}

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	@Override
	public String toString() {
		return "PyPcrCrsCrtBdiCisAci [uuid=" + uuid + ", crtTime=" + crtTime + ", crtUser=" + crtUser + ", trnId="
				+ trnId + ", overdraftBalanceForLastMonth=" + overdraftBalanceForLastMonth
				+ ", overdraftOccurForLastMonth=" + overdraftOccurForLastMonth + ", withdrawForLastMonth="
				+ withdrawForLastMonth + ", withdrawTimesForLastMonth=" + withdrawTimesForLastMonth
				+ ", purchaseForLastMonth=" + purchaseForLastMonth + ", purchaseTimesForLastMonth="
				+ purchaseTimesForLastMonth + ", overdraftForLast6Month=" + overdraftForLast6Month
				+ ", purchaseForLast6Month=" + purchaseForLast6Month + ", purchaseTimesForLast6Month="
				+ purchaseTimesForLast6Month + ", withdrawForLast6Month=" + withdrawForLast6Month
				+ ", withdrawTimesForLast6Month=" + withdrawTimesForLast6Month + ", overdraftForLast12Month="
				+ overdraftForLast12Month + ", purchaseForLast12Month=" + purchaseForLast12Month
				+ ", withdrawForLast12Month=" + withdrawForLast12Month + ", infoDate=" + infoDate + ", appId=" + appId
				+ "]";
	}

	
}
