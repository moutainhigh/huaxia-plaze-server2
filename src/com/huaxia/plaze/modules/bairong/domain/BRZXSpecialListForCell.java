package com.huaxia.plaze.modules.bairong.domain;

/**
 * 第三方 & 百融征信 & 反欺诈 & 特殊名单核查 & 通过手机号查询
 * 
 * @author zhiguo.li
 *
 */
public class BRZXSpecialListForCell extends BRZX {

	private static final long serialVersionUID = 689089641653265475L;

	// 响应参数 & 通过联系人手机查询高危行为
	private String slCellAbnormal;
	
	// 响应参数 & 通过联系人手机查询电信欠费
	private String slCellPhoneOverdue;
	
	// 响应参数 & 通过手机号查询银行(含信用卡)不良
	private String slCellBankBad;
	
	// 响应参数 & 通过手机号查询银行(含信用卡)短时逾期
	private String slCellBankOverdue;
	
	// 响应参数 & 通过手机号查询银行(含信用卡)资信不佳
	private String slCellBankFraud;
	
	// 响应参数 & 通过手机号查询银行(含信用卡)失联
	private String slCellBankLost;
	
	// 响应参数 & 通过手机号查询银行(含信用卡)拒绝
	private String slCellBankRefuse;
	
	// 响应参数 & 通过手机号查询非银(含全部非银类型)不良
	private String slCellP2pBad;
	
	// 响应参数 & 通过手机号查询非银(含全部非银类型)短时逾期
	private String slCellP2pOverdue;
	
	// 响应参数 & 通过手机号查询非银(含全部非银类型)资信不佳
	private String slCellP2pFraud;
	
	// 响应参数 & 通过手机号查询非银(含全部非银类型)失联
	private String slCellP2pLost;
	
	// 响应参数 & 通过手机号查询非银(含全部非银类型)拒绝
	private String slCellP2pRefuse;
	
	// 响应参数 & 通过手机号查询非银-P2P不良
	private String slCellNbankP2pBad;
	
	// 响应参数 & 通过手机号查询非银-P2P短时逾期
	private String slCellNbankP2pOverdue;
	
	// 响应参数 & 通过手机号查询非银-P2P资信不佳
	private String slCellNbankP2pFraud;
	
	// 响应参数 & 通过手机号查询非银-P2P失联
	private String slCellNbankP2pLost;
	
	// 响应参数 & 通过手机号查询非银-P2P拒绝
	private String slCellNbankP2pRefuse;
	
	// 响应参数 & 通过手机号查询非银-小贷不良
	private String slCellNbankMcBad;
	
	// 响应参数 & 通过手机号查询非银-小贷短时逾期
	private String slCellNbankMcOverdue;
	
	// 响应参数 & 通过手机号查询非银-小贷资信不佳
	private String slCellNbankMcFraud;
	
	// 响应参数 & 通过手机号查询非银-小贷失联
	private String slCellNbankMcLost;
	
	// 响应参数 & 通过手机号查询非银-小贷拒绝
	private String slCellNbankMcRefuse;
	
	// 响应参数 & 通过手机号查询非银-现金类分期不良
	private String slCellNbankCaBad;
	
	// 响应参数 & 通过手机号查询非银-现金类分期短时逾期
	private String slCellNbankCaOverdue;
	
	// 响应参数 & 通过手机号查询非银-现金类分期资信不佳
	private String slCellNbankCaFraud;
	
	// 响应参数 & 通过手机号查询非银-现金类分期失联
	private String slCellNbankCaLost;
	
	// 响应参数 & 通过手机号查询非银-现金类分期拒绝
	private String slCellNbankCaRefuse;
	
	// 响应参数 & 通过手机号查询非银-代偿类分期不良
	private String slCellNbankComBad;
	
	// 响应参数 & 通过手机号查询非银-代偿类分期短时逾期
	private String slCellNbankComOverdue;
	
	// 响应参数 & 通过手机号查询非银-代偿类分期资信不佳
	private String slCellNbankComFraud;
	
	// 响应参数 & 通过手机号查询非银-代偿类分期失联
	private String slCellNbankComLost;
	
	// 响应参数 & 通过手机号查询非银-代偿类分期拒绝
	private String slCellNbankComRefuse;
	
	// 响应参数 & 通过手机号查询非银-消费类分期不良
	private String slCellNbankCfBad;
	
	// 响应参数 & 通过手机号查询非银-消费类分期短时逾期
	private String slCellNbankCfOverdue;
	
	// 响应参数 & 通过手机号查询非银-消费类分期资信不佳
	private String slCellNbankCfFraud;
	
	// 响应参数 & 通过手机号查询非银-消费类分期失联
	private String slCellNbankCfLost;
	
	// 响应参数 & 通过手机号查询非银-消费类分期拒绝
	private String slCellNbankCfRefuse;
	
	// 响应参数 & 通过手机号查询非银-其他不良
	private String slCellNbankOtherBad;
	
	// 响应参数 & 通过手机号查询非银-其他短时逾期
	private String slCellNbankOtherOverdue;
	
	// 响应参数 & 通过手机号查询非银-其他资信不佳
	private String slCellNbankOtherFraud;
	
	// 响应参数 & 通过手机号查询非银-其他失联
	private String slCellNbankOtherLost;
	
	// 响应参数 & 通过手机号查询非银-其他拒绝
	private String slCellNbankOtherRefuse;

	public String getSlCellAbnormal() {
		return slCellAbnormal;
	}

	public void setSlCellAbnormal(String slCellAbnormal) {
		this.slCellAbnormal = slCellAbnormal;
	}

	public String getSlCellPhoneOverdue() {
		return slCellPhoneOverdue;
	}

	public void setSlCellPhoneOverdue(String slCellPhoneOverdue) {
		this.slCellPhoneOverdue = slCellPhoneOverdue;
	}

	public String getSlCellBankBad() {
		return slCellBankBad;
	}

	public void setSlCellBankBad(String slCellBankBad) {
		this.slCellBankBad = slCellBankBad;
	}

	public String getSlCellBankOverdue() {
		return slCellBankOverdue;
	}

	public void setSlCellBankOverdue(String slCellBankOverdue) {
		this.slCellBankOverdue = slCellBankOverdue;
	}

	public String getSlCellBankFraud() {
		return slCellBankFraud;
	}

	public void setSlCellBankFraud(String slCellBankFraud) {
		this.slCellBankFraud = slCellBankFraud;
	}

	public String getSlCellBankLost() {
		return slCellBankLost;
	}

	public void setSlCellBankLost(String slCellBankLost) {
		this.slCellBankLost = slCellBankLost;
	}

	public String getSlCellBankRefuse() {
		return slCellBankRefuse;
	}

	public void setSlCellBankRefuse(String slCellBankRefuse) {
		this.slCellBankRefuse = slCellBankRefuse;
	}

	public String getSlCellP2pBad() {
		return slCellP2pBad;
	}

	public void setSlCellP2pBad(String slCellP2pBad) {
		this.slCellP2pBad = slCellP2pBad;
	}

	public String getSlCellP2pOverdue() {
		return slCellP2pOverdue;
	}

	public void setSlCellP2pOverdue(String slCellP2pOverdue) {
		this.slCellP2pOverdue = slCellP2pOverdue;
	}

	public String getSlCellP2pFraud() {
		return slCellP2pFraud;
	}

	public void setSlCellP2pFraud(String slCellP2pFraud) {
		this.slCellP2pFraud = slCellP2pFraud;
	}

	public String getSlCellP2pLost() {
		return slCellP2pLost;
	}

	public void setSlCellP2pLost(String slCellP2pLost) {
		this.slCellP2pLost = slCellP2pLost;
	}

	public String getSlCellP2pRefuse() {
		return slCellP2pRefuse;
	}

	public void setSlCellP2pRefuse(String slCellP2pRefuse) {
		this.slCellP2pRefuse = slCellP2pRefuse;
	}

	public String getSlCellNbankP2pBad() {
		return slCellNbankP2pBad;
	}

	public void setSlCellNbankP2pBad(String slCellNbankP2pBad) {
		this.slCellNbankP2pBad = slCellNbankP2pBad;
	}

	public String getSlCellNbankP2pOverdue() {
		return slCellNbankP2pOverdue;
	}

	public void setSlCellNbankP2pOverdue(String slCellNbankP2pOverdue) {
		this.slCellNbankP2pOverdue = slCellNbankP2pOverdue;
	}

	public String getSlCellNbankP2pFraud() {
		return slCellNbankP2pFraud;
	}

	public void setSlCellNbankP2pFraud(String slCellNbankP2pFraud) {
		this.slCellNbankP2pFraud = slCellNbankP2pFraud;
	}

	public String getSlCellNbankP2pLost() {
		return slCellNbankP2pLost;
	}

	public void setSlCellNbankP2pLost(String slCellNbankP2pLost) {
		this.slCellNbankP2pLost = slCellNbankP2pLost;
	}

	public String getSlCellNbankP2pRefuse() {
		return slCellNbankP2pRefuse;
	}

	public void setSlCellNbankP2pRefuse(String slCellNbankP2pRefuse) {
		this.slCellNbankP2pRefuse = slCellNbankP2pRefuse;
	}

	public String getSlCellNbankMcBad() {
		return slCellNbankMcBad;
	}

	public void setSlCellNbankMcBad(String slCellNbankMcBad) {
		this.slCellNbankMcBad = slCellNbankMcBad;
	}

	public String getSlCellNbankMcOverdue() {
		return slCellNbankMcOverdue;
	}

	public void setSlCellNbankMcOverdue(String slCellNbankMcOverdue) {
		this.slCellNbankMcOverdue = slCellNbankMcOverdue;
	}

	public String getSlCellNbankMcFraud() {
		return slCellNbankMcFraud;
	}

	public void setSlCellNbankMcFraud(String slCellNbankMcFraud) {
		this.slCellNbankMcFraud = slCellNbankMcFraud;
	}

	public String getSlCellNbankMcLost() {
		return slCellNbankMcLost;
	}

	public void setSlCellNbankMcLost(String slCellNbankMcLost) {
		this.slCellNbankMcLost = slCellNbankMcLost;
	}

	public String getSlCellNbankMcRefuse() {
		return slCellNbankMcRefuse;
	}

	public void setSlCellNbankMcRefuse(String slCellNbankMcRefuse) {
		this.slCellNbankMcRefuse = slCellNbankMcRefuse;
	}

	public String getSlCellNbankCaBad() {
		return slCellNbankCaBad;
	}

	public void setSlCellNbankCaBad(String slCellNbankCaBad) {
		this.slCellNbankCaBad = slCellNbankCaBad;
	}

	public String getSlCellNbankCaOverdue() {
		return slCellNbankCaOverdue;
	}

	public void setSlCellNbankCaOverdue(String slCellNbankCaOverdue) {
		this.slCellNbankCaOverdue = slCellNbankCaOverdue;
	}

	public String getSlCellNbankCaFraud() {
		return slCellNbankCaFraud;
	}

	public void setSlCellNbankCaFraud(String slCellNbankCaFraud) {
		this.slCellNbankCaFraud = slCellNbankCaFraud;
	}

	public String getSlCellNbankCaLost() {
		return slCellNbankCaLost;
	}

	public void setSlCellNbankCaLost(String slCellNbankCaLost) {
		this.slCellNbankCaLost = slCellNbankCaLost;
	}

	public String getSlCellNbankCaRefuse() {
		return slCellNbankCaRefuse;
	}

	public void setSlCellNbankCaRefuse(String slCellNbankCaRefuse) {
		this.slCellNbankCaRefuse = slCellNbankCaRefuse;
	}

	public String getSlCellNbankComBad() {
		return slCellNbankComBad;
	}

	public void setSlCellNbankComBad(String slCellNbankComBad) {
		this.slCellNbankComBad = slCellNbankComBad;
	}

	public String getSlCellNbankComOverdue() {
		return slCellNbankComOverdue;
	}

	public void setSlCellNbankComOverdue(String slCellNbankComOverdue) {
		this.slCellNbankComOverdue = slCellNbankComOverdue;
	}

	public String getSlCellNbankComFraud() {
		return slCellNbankComFraud;
	}

	public void setSlCellNbankComFraud(String slCellNbankComFraud) {
		this.slCellNbankComFraud = slCellNbankComFraud;
	}

	public String getSlCellNbankComLost() {
		return slCellNbankComLost;
	}

	public void setSlCellNbankComLost(String slCellNbankComLost) {
		this.slCellNbankComLost = slCellNbankComLost;
	}

	public String getSlCellNbankComRefuse() {
		return slCellNbankComRefuse;
	}

	public void setSlCellNbankComRefuse(String slCellNbankComRefuse) {
		this.slCellNbankComRefuse = slCellNbankComRefuse;
	}

	public String getSlCellNbankCfBad() {
		return slCellNbankCfBad;
	}

	public void setSlCellNbankCfBad(String slCellNbankCfBad) {
		this.slCellNbankCfBad = slCellNbankCfBad;
	}

	public String getSlCellNbankCfOverdue() {
		return slCellNbankCfOverdue;
	}

	public void setSlCellNbankCfOverdue(String slCellNbankCfOverdue) {
		this.slCellNbankCfOverdue = slCellNbankCfOverdue;
	}

	public String getSlCellNbankCfFraud() {
		return slCellNbankCfFraud;
	}

	public void setSlCellNbankCfFraud(String slCellNbankCfFraud) {
		this.slCellNbankCfFraud = slCellNbankCfFraud;
	}

	public String getSlCellNbankCfLost() {
		return slCellNbankCfLost;
	}

	public void setSlCellNbankCfLost(String slCellNbankCfLost) {
		this.slCellNbankCfLost = slCellNbankCfLost;
	}

	public String getSlCellNbankCfRefuse() {
		return slCellNbankCfRefuse;
	}

	public void setSlCellNbankCfRefuse(String slCellNbankCfRefuse) {
		this.slCellNbankCfRefuse = slCellNbankCfRefuse;
	}

	public String getSlCellNbankOtherBad() {
		return slCellNbankOtherBad;
	}

	public void setSlCellNbankOtherBad(String slCellNbankOtherBad) {
		this.slCellNbankOtherBad = slCellNbankOtherBad;
	}

	public String getSlCellNbankOtherOverdue() {
		return slCellNbankOtherOverdue;
	}

	public void setSlCellNbankOtherOverdue(String slCellNbankOtherOverdue) {
		this.slCellNbankOtherOverdue = slCellNbankOtherOverdue;
	}

	public String getSlCellNbankOtherFraud() {
		return slCellNbankOtherFraud;
	}

	public void setSlCellNbankOtherFraud(String slCellNbankOtherFraud) {
		this.slCellNbankOtherFraud = slCellNbankOtherFraud;
	}

	public String getSlCellNbankOtherLost() {
		return slCellNbankOtherLost;
	}

	public void setSlCellNbankOtherLost(String slCellNbankOtherLost) {
		this.slCellNbankOtherLost = slCellNbankOtherLost;
	}

	public String getSlCellNbankOtherRefuse() {
		return slCellNbankOtherRefuse;
	}

	public void setSlCellNbankOtherRefuse(String slCellNbankOtherRefuse) {
		this.slCellNbankOtherRefuse = slCellNbankOtherRefuse;
	}

}
