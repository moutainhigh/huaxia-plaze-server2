package com.huaxia.plaze.modules.pengyuan.domain;

/**
 * 鹏元个人信用报告银行概要信息表
 * 
 * @author User
 *
 */
public class PyCrsCrtBsi {

	// 记录编号
	private String uuid;
	// 创建时间
	private String crtTime;
	// 创建用户
	private String crtUser;
	// 交易编号
	private String trnId;
	// 子报告ID
	private Integer subReportType;
	// 收费子报告ID
	private Integer subReportTypeCost;
	// 子报告查询状态
	private Integer treatResult;
	// 错误代码
	private String treatErrorCode;
	// 错误信息
	private String errorMessage;
	// 银行信用卡总数
	private Integer creditcardCount;
	// 未注销信用卡数
	private Integer creditcardUsingCount;
	// 首次开卡日期
	private String creditcardFirstOpen;
	// 异常信用卡数
	private Integer caCount;
	// 当前所有信用卡合计授信总额
	private Double cpOverdraftAmount;
	// 当前所有信用卡合计透支余额
	private Double cOverdraftAmount;
	// 信用卡已销户张数
	private Integer creditcardCancelCount;
	// 当前所有信用卡上月合计透支发生金额
	private Double coLastOccurAmount;
	// 卡最高额度
	private Double highestOverdraftAmount;
	// 最坏卡状态
	private Integer worstCardStatus;
	// 贷款总笔数
	private Integer loanCount;
	// 放贷银行总数
	private Integer loanBankCount;
	// 活动贷款总笔数
	private Integer loanNotSquareCount;
	// 首次贷款日期（包括已经结清的贷款）
	private String loanFirstOpen;
	// 异常贷款笔数
	private Integer loanAbnormalCount;
	// 合计贷款总额
	private Double loanAmount;
	// 合计贷款余额
	private Double loanBalanceAmount;
	// 合计贷款拖欠总额
	private Double loanArrearAmount;
	// 所有贷款未按时还款总次数
	private Integer loanHistoryArrearTimes;
	// 最坏一笔贷款状态
	private Integer worstLoanStatus;
	// 近12个月最高连续逾期次数
	private Integer loanHistory12ArrearTimes;
	// 已结清账户数
	private Integer settleAccountCount;
	// 最近5年内曾发生过逾期账户数
	private Integer year5overDueAccountCount;
	
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

	public Integer getSubReportType() {
		return subReportType;
	}

	public void setSubReportType(Integer subReportType) {
		this.subReportType = subReportType;
	}

	public Integer getSubReportTypeCost() {
		return subReportTypeCost;
	}

	public void setSubReportTypeCost(Integer subReportTypeCost) {
		this.subReportTypeCost = subReportTypeCost;
	}

	public Integer getTreatResult() {
		return treatResult;
	}

	public void setTreatResult(Integer treatResult) {
		this.treatResult = treatResult;
	}

	public String getTreatErrorCode() {
		return treatErrorCode;
	}

	public void setTreatErrorCode(String treatErrorCode) {
		this.treatErrorCode = treatErrorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
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

	public String getCreditcardFirstOpen() {
		return creditcardFirstOpen;
	}

	public void setCreditcardFirstOpen(String creditcardFirstOpen) {
		this.creditcardFirstOpen = creditcardFirstOpen;
	}

	public Integer getCaCount() {
		return caCount;
	}

	public void setCaCount(Integer caCount) {
		this.caCount = caCount;
	}

	public Double getCpOverdraftAmount() {
		return cpOverdraftAmount;
	}

	public void setCpOverdraftAmount(Double cpOverdraftAmount) {
		this.cpOverdraftAmount = cpOverdraftAmount;
	}

	public Double getcOverdraftAmount() {
		return cOverdraftAmount;
	}

	public void setcOverdraftAmount(Double cOverdraftAmount) {
		this.cOverdraftAmount = cOverdraftAmount;
	}

	public Integer getCreditcardCancelCount() {
		return creditcardCancelCount;
	}

	public void setCreditcardCancelCount(Integer creditcardCancelCount) {
		this.creditcardCancelCount = creditcardCancelCount;
	}

	public Double getCoLastOccurAmount() {
		return coLastOccurAmount;
	}

	public void setCoLastOccurAmount(Double coLastOccurAmount) {
		this.coLastOccurAmount = coLastOccurAmount;
	}

	public Double getHighestOverdraftAmount() {
		return highestOverdraftAmount;
	}

	public void setHighestOverdraftAmount(Double highestOverdraftAmount) {
		this.highestOverdraftAmount = highestOverdraftAmount;
	}

	public Integer getWorstCardStatus() {
		return worstCardStatus;
	}

	public void setWorstCardStatus(Integer worstCardStatus) {
		this.worstCardStatus = worstCardStatus;
	}

	public Integer getLoanCount() {
		return loanCount;
	}

	public void setLoanCount(Integer loanCount) {
		this.loanCount = loanCount;
	}

	public Integer getLoanBankCount() {
		return loanBankCount;
	}

	public void setLoanBankCount(Integer loanBankCount) {
		this.loanBankCount = loanBankCount;
	}

	public Integer getLoanNotSquareCount() {
		return loanNotSquareCount;
	}

	public void setLoanNotSquareCount(Integer loanNotSquareCount) {
		this.loanNotSquareCount = loanNotSquareCount;
	}

	public String getLoanFirstOpen() {
		return loanFirstOpen;
	}

	public void setLoanFirstOpen(String loanFirstOpen) {
		this.loanFirstOpen = loanFirstOpen;
	}

	public Integer getLoanAbnormalCount() {
		return loanAbnormalCount;
	}

	public void setLoanAbnormalCount(Integer loanAbnormalCount) {
		this.loanAbnormalCount = loanAbnormalCount;
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

	public Integer getWorstLoanStatus() {
		return worstLoanStatus;
	}

	public void setWorstLoanStatus(Integer worstLoanStatus) {
		this.worstLoanStatus = worstLoanStatus;
	}

	public Integer getLoanHistory12ArrearTimes() {
		return loanHistory12ArrearTimes;
	}

	public void setLoanHistory12ArrearTimes(Integer loanHistory12ArrearTimes) {
		this.loanHistory12ArrearTimes = loanHistory12ArrearTimes;
	}

	public Integer getSettleAccountCount() {
		return settleAccountCount;
	}

	public void setSettleAccountCount(Integer settleAccountCount) {
		this.settleAccountCount = settleAccountCount;
	}

	public Integer getYear5overDueAccountCount() {
		return year5overDueAccountCount;
	}

	public void setYear5overDueAccountCount(Integer year5overDueAccountCount) {
		this.year5overDueAccountCount = year5overDueAccountCount;
	}

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	@Override
	public String toString() {
		return "PyCrsCrtBsi [uuid=" + uuid + ", crtTime=" + crtTime + ", crtUser=" + crtUser + ", trnId=" + trnId
				+ ", subReportType=" + subReportType + ", subReportTypeCost=" + subReportTypeCost + ", treatResult="
				+ treatResult + ", treatErrorCode=" + treatErrorCode + ", errorMessage=" + errorMessage
				+ ", creditcardCount=" + creditcardCount + ", creditcardUsingCount=" + creditcardUsingCount
				+ ", creditcardFirstOpen=" + creditcardFirstOpen + ", caCount=" + caCount + ", cpOverdraftAmount="
				+ cpOverdraftAmount + ", cOverdraftAmount=" + cOverdraftAmount + ", creditcardCancelCount="
				+ creditcardCancelCount + ", coLastOccurAmount=" + coLastOccurAmount + ", highestOverdraftAmount="
				+ highestOverdraftAmount + ", worstCardStatus=" + worstCardStatus + ", loanCount=" + loanCount
				+ ", loanBankCount=" + loanBankCount + ", loanNotSquareCount=" + loanNotSquareCount + ", loanFirstOpen="
				+ loanFirstOpen + ", loanAbnormalCount=" + loanAbnormalCount + ", loanAmount=" + loanAmount
				+ ", loanBalanceAmount=" + loanBalanceAmount + ", loanArrearAmount=" + loanArrearAmount
				+ ", loanHistoryArrearTimes=" + loanHistoryArrearTimes + ", worstLoanStatus=" + worstLoanStatus
				+ ", loanHistory12ArrearTimes=" + loanHistory12ArrearTimes + ", settleAccountCount="
				+ settleAccountCount + ", year5overDueAccountCount=" + year5overDueAccountCount + ", appId=" + appId
				+ "]";
	}
	


}
