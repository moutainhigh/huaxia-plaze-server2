package com.huaxia.plaze.modules.pengyuan.domain;

/**
 * 鹏元个人信用报告贷款信息账户基本信息表
 * 
 * @author User
 *
 */
public class PyPcrCrsCrtBdiLisAbi {

	// 记录编号
	private String uuid;
	// 创建时间
	private String crtTime;
	// 创建用户
	private String crtUser;
	// 交易编号
	private String trnId;
	// 贷款账号
	private String accountNo;
	// 发放贷款银行ID
	private Integer unit;
	// 放贷币种
	private String currency;
	// 贷款项目ID
	private String loanItem;
	// 担保方式ID
	private String guaranteeMode;
	// 授信额度
	private Double authorizedAmount;
	// 贷款总额
	private Double amount;
	// 账户状态ID
	private String status;
	// 贷款发放日
	private String openDate;
	// 贷款到期日
	private String maturityDate;
	// 还款开始月份
	private String paymentBeginDate;
	// 还款周期ID
	private String paymentPlan;
	// 还款方式ID
	private String paymentMode;
	// 协定其还款额
	private Double installmentPlan;
	// 信息获取日期
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

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public Integer getUnit() {
		return unit;
	}

	public void setUnit(Integer unit) {
		this.unit = unit;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getLoanItem() {
		return loanItem;
	}

	public void setLoanItem(String loanItem) {
		this.loanItem = loanItem;
	}

	public String getGuaranteeMode() {
		return guaranteeMode;
	}

	public void setGuaranteeMode(String guaranteeMode) {
		this.guaranteeMode = guaranteeMode;
	}

	public Double getAuthorizedAmount() {
		return authorizedAmount;
	}

	public void setAuthorizedAmount(Double authorizedAmount) {
		this.authorizedAmount = authorizedAmount;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getOpenDate() {
		return openDate;
	}

	public void setOpenDate(String openDate) {
		this.openDate = openDate;
	}

	public String getMaturityDate() {
		return maturityDate;
	}

	public void setMaturityDate(String maturityDate) {
		this.maturityDate = maturityDate;
	}

	public String getPaymentBeginDate() {
		return paymentBeginDate;
	}

	public void setPaymentBeginDate(String paymentBeginDate) {
		this.paymentBeginDate = paymentBeginDate;
	}

	public String getPaymentPlan() {
		return paymentPlan;
	}

	public void setPaymentPlan(String paymentPlan) {
		this.paymentPlan = paymentPlan;
	}

	public String getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}

	public Double getInstallmentPlan() {
		return installmentPlan;
	}

	public void setInstallmentPlan(Double installmentPlan) {
		this.installmentPlan = installmentPlan;
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
		return "PyPcrCrsCrtBdiLisAbi [uuid=" + uuid + ", crtTime=" + crtTime + ", crtUser=" + crtUser + ", trnId="
				+ trnId + ", accountNo=" + accountNo + ", unit=" + unit + ", currency=" + currency + ", loanItem="
				+ loanItem + ", guaranteeMode=" + guaranteeMode + ", authorizedAmount=" + authorizedAmount + ", amount="
				+ amount + ", status=" + status + ", openDate=" + openDate + ", maturityDate=" + maturityDate
				+ ", paymentBeginDate=" + paymentBeginDate + ", paymentPlan=" + paymentPlan + ", paymentMode="
				+ paymentMode + ", installmentPlan=" + installmentPlan + ", infoDate=" + infoDate + ", appId=" + appId
				+ "]";
	}


}
