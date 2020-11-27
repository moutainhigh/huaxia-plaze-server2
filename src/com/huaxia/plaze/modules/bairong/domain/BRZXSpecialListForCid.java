package com.huaxia.plaze.modules.bairong.domain;

/**
 * 第三方 & 百融 征信& 反欺诈 & 特殊名单核查 & 通过身份证查询
 * 
 * @author zhiguo.li
 *
 */
public class BRZXSpecialListForCid extends BRZX {

	private static final long serialVersionUID = -86292939661999825L;

	// 响应参数 & 通过身份证号查询高危行为
	private String slIdAbnormal;
	
	// 响应参数 & 通过身份证号查询电信欠费
	private String slIdPhoneOverdue;
	
	// 响应参数 & 通过身份证号查询法院失信人
	private String slIdCourtBad;
	
	// 响应参数 & 通过身份证号查询法院被执行人
	private String slIdCourtExecuted;
	
	// 响应参数 & 通过身份证号查询银行(含信用卡)不良
	private String slIdBankBad;
	
	// 响应参数 & 通过身份证号查询银行(含信用卡)短时逾期
	private String slIdBankOverdue;
	
	// 响应参数 & 通过身份证号查询银行(含信用卡)资信不佳
	private String slIdBankFraud;
	
	// 响应参数 & 通过身份证号查询银行(含信用卡)失联
	private String slIdBankLost;
	
	// 响应参数 & 通过身份证号查询银行(含信用卡)拒绝
	private String slIdBankRefuse;
	
	// 响应参数 & 通过身份证号查询非银(含全部非银类型)不良
	private String slIdP2pBad;
	
	// 响应参数 & 通过身份证号查询非银(含全部非银类型)短时逾期
	private String slIdP2pOverdue;
	
	// 响应参数 & 通过身份证号查询非银(含全部非银类型)资信不佳
	private String slIdP2pFraud;
	
	// 响应参数 & 通过身份证号查询非银(含全部非银类型)失联
	private String slIdP2pLost;
	
	// 响应参数 & 通过身份证号查询非银(含全部非银类型)拒绝
	private String slIdP2pRefuse;
	
	// 响应参数 & 通过身份证号查询非银-P2P不良
	private String slIdNbankP2pBad;
	
	// 响应参数 & 通过身份证号查询非银-P2P短时逾期
	private String slIdNbankP2pOverdue;
	
	// 响应参数 & 通过身份证号查询非银-P2P资信不佳
	private String slIdNbankP2pFraud;
	
	// 响应参数 & 通过身份证号查询非银-P2P失联
	private String slIdNbankP2pLost;
	
	// 响应参数 & 通过身份证号查询非银-P2P拒绝
	private String slIdNbankP2pRefuse;
	
	// 响应参数 & 通过身份证号查询非银-小贷不良
	private String slIdNbankMcBad;
	
	// 响应参数 & 通过身份证号查询非银-小贷短时逾期
	private String slIdNbankMcOverdue;
	
	// 响应参数 & 通过身份证号查询非银-小贷资信不佳
	private String slIdNbankMcFraud;
	
	// 响应参数 & 通过身份证号查询非银-小贷失联
	private String slIdNbankMcLost;
	
	// 响应参数 & 通过身份证号查询非银-小贷拒绝
	private String slIdNbankMcRefuse;
	
	// 响应参数 & 通过身份证号查询非银-现金类分期不良
	private String slIdNbankCaBad;
	
	// 响应参数 & 通过身份证号查询非银-现金类分期短时逾期
	private String slIdNbankCaOverdue;
	
	// 响应参数 & 通过身份证号查询非银-现金类分期资信不佳
	private String slIdNbankCaFraud;
	
	// 响应参数 & 通过身份证号查询非银-现金类分期失联
	private String slIdNbankCaLost;
	
	// 响应参数 & 通过身份证号查询非银-现金类分期拒绝
	private String slIdNbankCaRefuse;
	
	// 响应参数 & 通过身份证号查询非银-代偿类分期不良
	private String slIdNbankComBad;
	
	// 响应参数 & 通过身份证号查询非银-代偿类分期短时逾期
	private String slIdNbankComOverdue;
	
	// 响应参数 & 通过身份证号查询非银-代偿类分期资信不佳
	private String slIdNbankComFraud;
	
	// 响应参数 & 通过身份证号查询非银-代偿类分期失联
	private String slIdNbankComLost;
	
	// 响应参数 & 通过身份证号查询非银-代偿类分期拒绝
	private String slIdNbankComRefuse;
	
	// 响应参数 & 通过身份证号查询非银-消费类分期不良
	private String slIdNbankCfBad;
	
	// 响应参数 & 通过身份证号查询非银-消费类分期短时逾期
	private String slIdNbankCfOverdue;
	
	// 响应参数 & 通过身份证号查询非银-消费类分期资信不佳
	private String slIdNbankCfFraud;
	
	// 响应参数 & 通过身份证号查询非银-消费类分期失联
	private String slIdNbankCfLost;
	
	// 响应参数 & 通过身份证号查询非银-消费类分期拒绝
	private String slIdNbankCfRefuse;
	
	// 响应参数 & 通过身份证号查询非银-其他不良
	private String slIdNbankOtherBad;
	
	// 响应参数 & 通过身份证号查询非银-其他短时逾期
	private String slIdNbankOtherOverdue;
	
	// 响应参数 & 通过身份证号查询非银-其他资信不佳
	private String slIdNbankOtherFraud;
	
	// 响应参数 & 通过身份证号查询非银-其他失联
	private String slIdNbankOtherLost;
	
	// 响应参数 & 通过身份证号查询非银-其他拒绝
	private String slIdNbankOtherRefuse;

	public String getSlIdAbnormal() {
		return slIdAbnormal;
	}

	public void setSlIdAbnormal(String slIdAbnormal) {
		this.slIdAbnormal = slIdAbnormal;
	}

	public String getSlIdPhoneOverdue() {
		return slIdPhoneOverdue;
	}

	public void setSlIdPhoneOverdue(String slIdPhoneOverdue) {
		this.slIdPhoneOverdue = slIdPhoneOverdue;
	}

	public String getSlIdCourtBad() {
		return slIdCourtBad;
	}

	public void setSlIdCourtBad(String slIdCourtBad) {
		this.slIdCourtBad = slIdCourtBad;
	}

	public String getSlIdCourtExecuted() {
		return slIdCourtExecuted;
	}

	public void setSlIdCourtExecuted(String slIdCourtExecuted) {
		this.slIdCourtExecuted = slIdCourtExecuted;
	}

	public String getSlIdBankBad() {
		return slIdBankBad;
	}

	public void setSlIdBankBad(String slIdBankBad) {
		this.slIdBankBad = slIdBankBad;
	}

	public String getSlIdBankOverdue() {
		return slIdBankOverdue;
	}

	public void setSlIdBankOverdue(String slIdBankOverdue) {
		this.slIdBankOverdue = slIdBankOverdue;
	}

	public String getSlIdBankFraud() {
		return slIdBankFraud;
	}

	public void setSlIdBankFraud(String slIdBankFraud) {
		this.slIdBankFraud = slIdBankFraud;
	}

	public String getSlIdBankLost() {
		return slIdBankLost;
	}

	public void setSlIdBankLost(String slIdBankLost) {
		this.slIdBankLost = slIdBankLost;
	}

	public String getSlIdBankRefuse() {
		return slIdBankRefuse;
	}

	public void setSlIdBankRefuse(String slIdBankRefuse) {
		this.slIdBankRefuse = slIdBankRefuse;
	}

	public String getSlIdP2pBad() {
		return slIdP2pBad;
	}

	public void setSlIdP2pBad(String slIdP2pBad) {
		this.slIdP2pBad = slIdP2pBad;
	}

	public String getSlIdP2pOverdue() {
		return slIdP2pOverdue;
	}

	public void setSlIdP2pOverdue(String slIdP2pOverdue) {
		this.slIdP2pOverdue = slIdP2pOverdue;
	}

	public String getSlIdP2pFraud() {
		return slIdP2pFraud;
	}

	public void setSlIdP2pFraud(String slIdP2pFraud) {
		this.slIdP2pFraud = slIdP2pFraud;
	}

	public String getSlIdP2pLost() {
		return slIdP2pLost;
	}

	public void setSlIdP2pLost(String slIdP2pLost) {
		this.slIdP2pLost = slIdP2pLost;
	}

	public String getSlIdP2pRefuse() {
		return slIdP2pRefuse;
	}

	public void setSlIdP2pRefuse(String slIdP2pRefuse) {
		this.slIdP2pRefuse = slIdP2pRefuse;
	}

	public String getSlIdNbankP2pBad() {
		return slIdNbankP2pBad;
	}

	public void setSlIdNbankP2pBad(String slIdNbankP2pBad) {
		this.slIdNbankP2pBad = slIdNbankP2pBad;
	}

	public String getSlIdNbankP2pOverdue() {
		return slIdNbankP2pOverdue;
	}

	public void setSlIdNbankP2pOverdue(String slIdNbankP2pOverdue) {
		this.slIdNbankP2pOverdue = slIdNbankP2pOverdue;
	}

	public String getSlIdNbankP2pFraud() {
		return slIdNbankP2pFraud;
	}

	public void setSlIdNbankP2pFraud(String slIdNbankP2pFraud) {
		this.slIdNbankP2pFraud = slIdNbankP2pFraud;
	}

	public String getSlIdNbankP2pLost() {
		return slIdNbankP2pLost;
	}

	public void setSlIdNbankP2pLost(String slIdNbankP2pLost) {
		this.slIdNbankP2pLost = slIdNbankP2pLost;
	}

	public String getSlIdNbankP2pRefuse() {
		return slIdNbankP2pRefuse;
	}

	public void setSlIdNbankP2pRefuse(String slIdNbankP2pRefuse) {
		this.slIdNbankP2pRefuse = slIdNbankP2pRefuse;
	}

	public String getSlIdNbankMcBad() {
		return slIdNbankMcBad;
	}

	public void setSlIdNbankMcBad(String slIdNbankMcBad) {
		this.slIdNbankMcBad = slIdNbankMcBad;
	}

	public String getSlIdNbankMcOverdue() {
		return slIdNbankMcOverdue;
	}

	public void setSlIdNbankMcOverdue(String slIdNbankMcOverdue) {
		this.slIdNbankMcOverdue = slIdNbankMcOverdue;
	}

	public String getSlIdNbankMcFraud() {
		return slIdNbankMcFraud;
	}

	public void setSlIdNbankMcFraud(String slIdNbankMcFraud) {
		this.slIdNbankMcFraud = slIdNbankMcFraud;
	}

	public String getSlIdNbankMcLost() {
		return slIdNbankMcLost;
	}

	public void setSlIdNbankMcLost(String slIdNbankMcLost) {
		this.slIdNbankMcLost = slIdNbankMcLost;
	}

	public String getSlIdNbankMcRefuse() {
		return slIdNbankMcRefuse;
	}

	public void setSlIdNbankMcRefuse(String slIdNbankMcRefuse) {
		this.slIdNbankMcRefuse = slIdNbankMcRefuse;
	}

	public String getSlIdNbankCaBad() {
		return slIdNbankCaBad;
	}

	public void setSlIdNbankCaBad(String slIdNbankCaBad) {
		this.slIdNbankCaBad = slIdNbankCaBad;
	}

	public String getSlIdNbankCaOverdue() {
		return slIdNbankCaOverdue;
	}

	public void setSlIdNbankCaOverdue(String slIdNbankCaOverdue) {
		this.slIdNbankCaOverdue = slIdNbankCaOverdue;
	}

	public String getSlIdNbankCaFraud() {
		return slIdNbankCaFraud;
	}

	public void setSlIdNbankCaFraud(String slIdNbankCaFraud) {
		this.slIdNbankCaFraud = slIdNbankCaFraud;
	}

	public String getSlIdNbankCaLost() {
		return slIdNbankCaLost;
	}

	public void setSlIdNbankCaLost(String slIdNbankCaLost) {
		this.slIdNbankCaLost = slIdNbankCaLost;
	}

	public String getSlIdNbankCaRefuse() {
		return slIdNbankCaRefuse;
	}

	public void setSlIdNbankCaRefuse(String slIdNbankCaRefuse) {
		this.slIdNbankCaRefuse = slIdNbankCaRefuse;
	}

	public String getSlIdNbankComBad() {
		return slIdNbankComBad;
	}

	public void setSlIdNbankComBad(String slIdNbankComBad) {
		this.slIdNbankComBad = slIdNbankComBad;
	}

	public String getSlIdNbankComOverdue() {
		return slIdNbankComOverdue;
	}

	public void setSlIdNbankComOverdue(String slIdNbankComOverdue) {
		this.slIdNbankComOverdue = slIdNbankComOverdue;
	}

	public String getSlIdNbankComFraud() {
		return slIdNbankComFraud;
	}

	public void setSlIdNbankComFraud(String slIdNbankComFraud) {
		this.slIdNbankComFraud = slIdNbankComFraud;
	}

	public String getSlIdNbankComLost() {
		return slIdNbankComLost;
	}

	public void setSlIdNbankComLost(String slIdNbankComLost) {
		this.slIdNbankComLost = slIdNbankComLost;
	}

	public String getSlIdNbankComRefuse() {
		return slIdNbankComRefuse;
	}

	public void setSlIdNbankComRefuse(String slIdNbankComRefuse) {
		this.slIdNbankComRefuse = slIdNbankComRefuse;
	}

	public String getSlIdNbankCfBad() {
		return slIdNbankCfBad;
	}

	public void setSlIdNbankCfBad(String slIdNbankCfBad) {
		this.slIdNbankCfBad = slIdNbankCfBad;
	}

	public String getSlIdNbankCfOverdue() {
		return slIdNbankCfOverdue;
	}

	public void setSlIdNbankCfOverdue(String slIdNbankCfOverdue) {
		this.slIdNbankCfOverdue = slIdNbankCfOverdue;
	}

	public String getSlIdNbankCfFraud() {
		return slIdNbankCfFraud;
	}

	public void setSlIdNbankCfFraud(String slIdNbankCfFraud) {
		this.slIdNbankCfFraud = slIdNbankCfFraud;
	}

	public String getSlIdNbankCfLost() {
		return slIdNbankCfLost;
	}

	public void setSlIdNbankCfLost(String slIdNbankCfLost) {
		this.slIdNbankCfLost = slIdNbankCfLost;
	}

	public String getSlIdNbankCfRefuse() {
		return slIdNbankCfRefuse;
	}

	public void setSlIdNbankCfRefuse(String slIdNbankCfRefuse) {
		this.slIdNbankCfRefuse = slIdNbankCfRefuse;
	}

	public String getSlIdNbankOtherBad() {
		return slIdNbankOtherBad;
	}

	public void setSlIdNbankOtherBad(String slIdNbankOtherBad) {
		this.slIdNbankOtherBad = slIdNbankOtherBad;
	}

	public String getSlIdNbankOtherOverdue() {
		return slIdNbankOtherOverdue;
	}

	public void setSlIdNbankOtherOverdue(String slIdNbankOtherOverdue) {
		this.slIdNbankOtherOverdue = slIdNbankOtherOverdue;
	}

	public String getSlIdNbankOtherFraud() {
		return slIdNbankOtherFraud;
	}

	public void setSlIdNbankOtherFraud(String slIdNbankOtherFraud) {
		this.slIdNbankOtherFraud = slIdNbankOtherFraud;
	}

	public String getSlIdNbankOtherLost() {
		return slIdNbankOtherLost;
	}

	public void setSlIdNbankOtherLost(String slIdNbankOtherLost) {
		this.slIdNbankOtherLost = slIdNbankOtherLost;
	}

	public String getSlIdNbankOtherRefuse() {
		return slIdNbankOtherRefuse;
	}

	public void setSlIdNbankOtherRefuse(String slIdNbankOtherRefuse) {
		this.slIdNbankOtherRefuse = slIdNbankOtherRefuse;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BRZXSpecialListForId [slIdAbnormal=");
		builder.append(slIdAbnormal);
		builder.append(", slIdPhoneOverdue=");
		builder.append(slIdPhoneOverdue);
		builder.append(", slIdCourtBad=");
		builder.append(slIdCourtBad);
		builder.append(", slIdCourtExecuted=");
		builder.append(slIdCourtExecuted);
		builder.append(", slIdBankBad=");
		builder.append(slIdBankBad);
		builder.append(", slIdBankOverdue=");
		builder.append(slIdBankOverdue);
		builder.append(", slIdBankFraud=");
		builder.append(slIdBankFraud);
		builder.append(", slIdBankLost=");
		builder.append(slIdBankLost);
		builder.append(", slIdBankRefuse=");
		builder.append(slIdBankRefuse);
		builder.append(", slIdP2pBad=");
		builder.append(slIdP2pBad);
		builder.append(", slIdP2pOverdue=");
		builder.append(slIdP2pOverdue);
		builder.append(", slIdP2pFraud=");
		builder.append(slIdP2pFraud);
		builder.append(", slIdP2pLost=");
		builder.append(slIdP2pLost);
		builder.append(", slIdP2pRefuse=");
		builder.append(slIdP2pRefuse);
		builder.append(", slIdNbankP2pBad=");
		builder.append(slIdNbankP2pBad);
		builder.append(", slIdNbankP2pOverdue=");
		builder.append(slIdNbankP2pOverdue);
		builder.append(", slIdNbankP2pFraud=");
		builder.append(slIdNbankP2pFraud);
		builder.append(", slIdNbankP2pLost=");
		builder.append(slIdNbankP2pLost);
		builder.append(", slIdNbankP2pRefuse=");
		builder.append(slIdNbankP2pRefuse);
		builder.append(", slIdNbankMcBad=");
		builder.append(slIdNbankMcBad);
		builder.append(", slIdNbankMcOverdue=");
		builder.append(slIdNbankMcOverdue);
		builder.append(", slIdNbankMcFraud=");
		builder.append(slIdNbankMcFraud);
		builder.append(", slIdNbankMcLost=");
		builder.append(slIdNbankMcLost);
		builder.append(", slIdNbankMcRefuse=");
		builder.append(slIdNbankMcRefuse);
		builder.append(", slIdNbankCaBad=");
		builder.append(slIdNbankCaBad);
		builder.append(", slIdNbankCaOverdue=");
		builder.append(slIdNbankCaOverdue);
		builder.append(", slIdNbankCaFraud=");
		builder.append(slIdNbankCaFraud);
		builder.append(", slIdNbankCaLost=");
		builder.append(slIdNbankCaLost);
		builder.append(", slIdNbankCaRefuse=");
		builder.append(slIdNbankCaRefuse);
		builder.append(", slIdNbankComBad=");
		builder.append(slIdNbankComBad);
		builder.append(", slIdNbankComOverdue=");
		builder.append(slIdNbankComOverdue);
		builder.append(", slIdNbankComFraud=");
		builder.append(slIdNbankComFraud);
		builder.append(", slIdNbankComLost=");
		builder.append(slIdNbankComLost);
		builder.append(", slIdNbankComRefuse=");
		builder.append(slIdNbankComRefuse);
		builder.append(", slIdNbankCfBad=");
		builder.append(slIdNbankCfBad);
		builder.append(", slIdNbankCfOverdue=");
		builder.append(slIdNbankCfOverdue);
		builder.append(", slIdNbankCfFraud=");
		builder.append(slIdNbankCfFraud);
		builder.append(", slIdNbankCfLost=");
		builder.append(slIdNbankCfLost);
		builder.append(", slIdNbankCfRefuse=");
		builder.append(slIdNbankCfRefuse);
		builder.append(", slIdNbankOtherBad=");
		builder.append(slIdNbankOtherBad);
		builder.append(", slIdNbankOtherOverdue=");
		builder.append(slIdNbankOtherOverdue);
		builder.append(", slIdNbankOtherFraud=");
		builder.append(slIdNbankOtherFraud);
		builder.append(", slIdNbankOtherLost=");
		builder.append(slIdNbankOtherLost);
		builder.append(", slIdNbankOtherRefuse=");
		builder.append(slIdNbankOtherRefuse);
		builder.append("]");
		return builder.toString();
	}
	
}
