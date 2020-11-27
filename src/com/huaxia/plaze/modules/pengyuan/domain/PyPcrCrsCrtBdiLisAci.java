package com.huaxia.plaze.modules.pengyuan.domain;

/**
 * 鹏元个人信用报告贷款信息账户动态信息表
 * 
 * @author User
 *
 */
public class PyPcrCrsCrtBdiLisAci {

	// 记录编号
	private String uuid;
	// 创建时间
	private String crtTime;
	// 创建用户
	private String crtUser;
	// 交易编号
	private String trnId;
	// 最近还款月份
	private String lastPaymentMonth;
	// 剩余期数
	private Integer remainTerms;
	// 当期贷款余额
	private Double balanceLastTerm;
	// 当期实际还款金额
	private Double rpaLastTerm;
	// 当期实际拖欠总金额
	private Double aaLastTerm;
	// 累计逾期还款次数
	private Integer arrearTimesCount;
	// 最高连续逾期次数
	private Integer atcoCountinuous;
	// 累计逾期次数
	private Integer atcoTotal;
	// 账户连续未按时还款1期的次数
	private Integer arrearTimes1;
	// 账户连续未按时还款2期的次数
	private Integer arrearTimes2;
	// 账户连续未按时还款3期的次数
	private Integer arrearTimes3;
	// 账户连续未按时还款4期的次数
	private Integer arrearTimes4;
	// 账户连续未按时还款5期的次数
	private Integer arrearTimes5;
	// 账户连续未按时还款6期的次数
	private Integer arrearTimes6;
	// 账户连续未按时还款7-12期的次数
	private Integer arrearTimes7_12;
	// 账户连续未按时还款12期以上
	private Integer arrearTimesOver12;
	// 最近月份的信息获取日期
	private String infoDate;

	private String appId;

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

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

	public String getLastPaymentMonth() {
		return lastPaymentMonth;
	}

	public void setLastPaymentMonth(String lastPaymentMonth) {
		this.lastPaymentMonth = lastPaymentMonth;
	}

	public int getRemainTerms() {
		return remainTerms;
	}

	public void setRemainTerms(int remainTerms) {
		this.remainTerms = remainTerms;
	}

	public double getBalanceLastTerm() {
		return balanceLastTerm;
	}

	public void setBalanceLastTerm(double balanceLastTerm) {
		this.balanceLastTerm = balanceLastTerm;
	}

	public double getRpaLastTerm() {
		return rpaLastTerm;
	}

	public void setRpaLastTerm(double rpaLastTerm) {
		this.rpaLastTerm = rpaLastTerm;
	}

	public double getAaLastTerm() {
		return aaLastTerm;
	}

	public void setAaLastTerm(double aaLastTerm) {
		this.aaLastTerm = aaLastTerm;
	}

	public int getArrearTimesCount() {
		return arrearTimesCount;
	}

	public void setArrearTimesCount(int arrearTimesCount) {
		this.arrearTimesCount = arrearTimesCount;
	}

	public int getAtcoCountinuous() {
		return atcoCountinuous;
	}

	public void setAtcoCountinuous(int atcoCountinuous) {
		this.atcoCountinuous = atcoCountinuous;
	}

	public int getAtcoTotal() {
		return atcoTotal;
	}

	public void setAtcoTotal(int atcoTotal) {
		this.atcoTotal = atcoTotal;
	}

	public int getArrearTimes1() {
		return arrearTimes1;
	}

	public void setArrearTimes1(int arrearTimes1) {
		this.arrearTimes1 = arrearTimes1;
	}

	public int getArrearTimes2() {
		return arrearTimes2;
	}

	public void setArrearTimes2(int arrearTimes2) {
		this.arrearTimes2 = arrearTimes2;
	}

	public int getArrearTimes3() {
		return arrearTimes3;
	}

	public void setArrearTimes3(int arrearTimes3) {
		this.arrearTimes3 = arrearTimes3;
	}

	public int getArrearTimes4() {
		return arrearTimes4;
	}

	public void setArrearTimes4(int arrearTimes4) {
		this.arrearTimes4 = arrearTimes4;
	}

	public int getArrearTimes5() {
		return arrearTimes5;
	}

	public void setArrearTimes5(int arrearTimes5) {
		this.arrearTimes5 = arrearTimes5;
	}

	public int getArrearTimes6() {
		return arrearTimes6;
	}

	public void setArrearTimes6(int arrearTimes6) {
		this.arrearTimes6 = arrearTimes6;
	}

	public int getArrearTimes7_12() {
		return arrearTimes7_12;
	}

	public void setArrearTimes7_12(int arrearTimes7_12) {
		this.arrearTimes7_12 = arrearTimes7_12;
	}

	public int getArrearTimesOver12() {
		return arrearTimesOver12;
	}

	public void setArrearTimesOver12(int arrearTimesOver12) {
		this.arrearTimesOver12 = arrearTimesOver12;
	}

	public String getInfoDate() {
		return infoDate;
	}

	public void setInfoDate(String infoDate) {
		this.infoDate = infoDate;
	}

	@Override
	public String toString() {
		return "PyPcrCrsCrtBdiLisAci [uuid=" + uuid + ", crtTime=" + crtTime + ", crtUser=" + crtUser + ", trnId="
				+ trnId + ", lastPaymentMonth=" + lastPaymentMonth + ", remainTerms=" + remainTerms
				+ ", balanceLastTerm=" + balanceLastTerm + ", rpaLastTerm=" + rpaLastTerm + ", aaLastTerm=" + aaLastTerm
				+ ", arrearTimesCount=" + arrearTimesCount + ", atcoCountinuous=" + atcoCountinuous + ", atcoTotal="
				+ atcoTotal + ", arrearTimes1=" + arrearTimes1 + ", arrearTimes2=" + arrearTimes2 + ", arrearTimes3="
				+ arrearTimes3 + ", arrearTimes4=" + arrearTimes4 + ", arrearTimes5=" + arrearTimes5 + ", arrearTimes6="
				+ arrearTimes6 + ", arrearTimes7_12=" + arrearTimes7_12 + ", arrearTimesOver12=" + arrearTimesOver12
				+ ", infoDate=" + infoDate + "]";
	}

}
