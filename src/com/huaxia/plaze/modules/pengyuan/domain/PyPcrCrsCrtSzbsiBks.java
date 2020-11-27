package com.huaxia.plaze.modules.pengyuan.domain;

/**
 * 鹏元个人信用报告深圳基本摘要信息银行信息表
 * 
 * @author User
 *
 */
public class PyPcrCrsCrtSzbsiBks {

	// 记录编号
	private String uuid;
	// 创建时间
	private String crtTime;
	// 创建用户
	private String crtUser;
	// 交易编号
	private String trnId;
	// 历史贷款笔数
	private Integer loanCount;
	// 获取活动贷款笔数
	private Integer loanNotSquareCount;
	// 合计贷款总额
	private Double loanAmount;
	// 所有贷款合计余额
	private Double loanBalanceAmount;
	// 所有贷款合计拖欠总额
	private Double loanArrearAmount;
	// 最近24个月最高连续逾期次数
	private Integer loanHistoryArrearTimes;
	// 银行信用卡数
	private Integer creditcardCount;
	// 未注销信用卡数
	private Integer creditcardUsingCount;
	// 当前所有信用卡合计授信总额
	private Double cpOverdraftAmount;
	// 当前所有信用卡合计透支余额
	private Double creditcardOverdraftAmount;
	// 首次开卡日期
	private String creditcardFirstOpen;

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

	public Integer getLoanCount() {
		return loanCount;
	}

	public void setLoanCount(Integer loanCount) {
		this.loanCount = loanCount;
	}

	public Integer getLoanNotSquareCount() {
		return loanNotSquareCount;
	}

	public void setLoanNotSquareCount(Integer loanNotSquareCount) {
		this.loanNotSquareCount = loanNotSquareCount;
	}

	public Double getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(Double loanAmount) {
		this.loanAmount = loanAmount;
	}

	public Double getLoanBalanceAmount() {
		return loanBalanceAmount;
	}

	public void setLoanBalanceAmount(Double loanBalanceAmount) {
		this.loanBalanceAmount = loanBalanceAmount;
	}

	public Double getLoanArrearAmount() {
		return loanArrearAmount;
	}

	public void setLoanArrearAmount(Double loanArrearAmount) {
		this.loanArrearAmount = loanArrearAmount;
	}

	public Integer getLoanHistoryArrearTimes() {
		return loanHistoryArrearTimes;
	}

	public void setLoanHistoryArrearTimes(Integer loanHistoryArrearTimes) {
		this.loanHistoryArrearTimes = loanHistoryArrearTimes;
	}

	public Integer getCreditcardCount() {
		return creditcardCount;
	}

	public void setCreditcardCount(Integer creditcardCount) {
		this.creditcardCount = creditcardCount;
	}

	public Integer getCreditcardUsingCount() {
		return creditcardUsingCount;
	}

	public void setCreditcardUsingCount(Integer creditcardUsingCount) {
		this.creditcardUsingCount = creditcardUsingCount;
	}

	public Double getCpOverdraftAmount() {
		return cpOverdraftAmount;
	}

	public void setCpOverdraftAmount(Double cpOverdraftAmount) {
		this.cpOverdraftAmount = cpOverdraftAmount;
	}

	public Double getCreditcardOverdraftAmount() {
		return creditcardOverdraftAmount;
	}

	public void setCreditcardOverdraftAmount(Double creditcardOverdraftAmount) {
		this.creditcardOverdraftAmount = creditcardOverdraftAmount;
	}

	public String getCreditcardFirstOpen() {
		return creditcardFirstOpen;
	}

	public void setCreditcardFirstOpen(String creditcardFirstOpen) {
		this.creditcardFirstOpen = creditcardFirstOpen;
	}

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	@Override
	public String toString() {
		return "PyPcrCrsCrtSzbsiBks [uuid=" + uuid + ", crtTime=" + crtTime + ", crtUser=" + crtUser + ", trnId="
				+ trnId + ", loanCount=" + loanCount + ", loanNotSquareCount=" + loanNotSquareCount + ", loanAmount="
				+ loanAmount + ", loanBalanceAmount=" + loanBalanceAmount + ", loanArrearAmount=" + loanArrearAmount
				+ ", loanHistoryArrearTimes=" + loanHistoryArrearTimes + ", creditcardCount=" + creditcardCount
				+ ", creditcardUsingCount=" + creditcardUsingCount + ", cpOverdraftAmount=" + cpOverdraftAmount
				+ ", creditcardOverdraftAmount=" + creditcardOverdraftAmount + ", creditcardFirstOpen="
				+ creditcardFirstOpen + ", appId=" + appId + "]";
	}

	

}
