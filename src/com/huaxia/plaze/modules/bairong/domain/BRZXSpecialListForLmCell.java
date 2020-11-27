package com.huaxia.plaze.modules.bairong.domain;

/**
 * 第三方 & 百融征信 & 反欺诈 & 特殊名单核查 & 通过联系人手机号查询
 * 
 * @author zhiguo.li
 *
 */
public class BRZXSpecialListForLmCell extends BRZX {

	private static final long serialVersionUID = -307684639688201992L;

	// 记录编号
	private String uuid;

	// 响应参数 & 通过联系人手机查询高危行为
	private String slLmCellAbnormal;
	
	// 响应参数 & 通过联系人手机查询电信欠费
	private String slLmCellPhoneOverdue;
	
	// 响应参数 & 通过联系人手机查询银行(含信用卡)不良
	private String slLmCellBankBad;
	
	// 响应参数 & 通过联系人手机查询银行(含信用卡)短时逾期
	private String slLmCellBankOverdue;
	
	// 响应参数 & 通过联系人手机查询银行(含信用卡)资信不佳
	private String slLmCellBankFraud;
	
	// 响应参数 & 通过联系人手机查询银行(含信用卡)失联
	private String slLmCellBankLost;
	
	// 响应参数 & 通过联系人手机查询银行(含信用卡)拒绝
	private String slLmCellBankRefuse;
	
	// 响应参数 & 通过联系人手机查询非银-P2P不良
	private String slLmCellNbankP2pBad;
	
	// 响应参数 & 通过联系人手机查询非银-P2P短时逾期
	private String slLmCellNbankP2pOverdue;
	
	// 响应参数 & 通过联系人手机查询非银-P2P资信不佳
	private String slLmCellNbankP2pFraud;
	
	// 响应参数 & 通过联系人手机查询非银-P2P失联
	private String slLmCellNbankP2pLost;
	
	// 响应参数 & 通过联系人手机查询非银-P2P拒绝
	private String slLmCellNbankP2pRefuse;
	
	// 响应参数 & 通过联系人手机查询非银-小贷不良
	private String slLmCellNbankMcBad;
	
	// 响应参数 & 通过联系人手机查询非银-小贷短时逾期
	private String slLmCellNbankMcOverdue;
	
	// 响应参数 & 通过联系人手机查询非银-小贷资信不佳
	private String slLmCellNbankMcFraud;
	
	// 响应参数 & 通过联系人手机查询非银-小贷失联
	private String slLmCellNbankMcLost;
	
	// 响应参数 & 通过联系人手机查询非银-小贷拒绝
	private String slLmCellNbankMcRefuse;
	
	// 响应参数 & 通过联系人手机查询非银-现金类分期不良
	private String slLmCellNbankCaBad;
	
	// 响应参数 & 通过联系人手机查询非银-现金类分期短时逾期
	private String slLmCellNbankCaOverdue;
	
	// 响应参数 & 通过联系人手机查询非银-现金类分期资信不佳
	private String slLmCellNbankCaFraud;
	
	// 响应参数 & 通过联系人手机查询非银-现金类分期失联
	private String slLmCellNbankCaLost;
	
	// 响应参数 & 通过联系人手机查询非银-现金类分期拒绝
	private String slLmCellNbankCaRefuse;
	
	// 响应参数 & 通过联系人手机查询非银-代偿类分期不良
	private String slLmCellNbankComBad;
	
	// 响应参数 & 通过联系人手机查询非银-代偿类分期短时逾期
	private String slLmCellNbankComOverdue;
	
	// 响应参数 & 通过联系人手机查询非银-代偿类分期资信不佳
	private String slLmCellNbankComFraud;
	
	// 响应参数 & 通过联系人手机查询非银-代偿类分期失联
	private String slLmCellNbankComLost;
	
	// 响应参数 & 通过联系人手机查询非银-代偿类分期拒绝
	private String slLmCellNbankComRefuse;
	
	// 响应参数 & 通过联系人手机查询非银-消费类分期不良
	private String slLmCellNbankCfBad;
	
	// 响应参数 & 通过联系人手机查询非银-消费类分期短时逾期
	private String slLmCellNbankCfOverdue;
	
	// 响应参数 & 通过联系人手机查询非银-消费类分期资信不佳
	private String slLmCellNbankCfFraud;
	
	// 响应参数 & 通过联系人手机查询非银-消费类分期失联
	private String slLmCellNbankCfLost;
	
	// 响应参数 & 通过联系人手机查询非银-消费类分期拒绝
	private String slLmCellNbankCfRefuse;
	
	// 响应参数 & 通过联系人手机查询非银-其他不良
	private String slLmCellNbankOtherBad;
	
	// 响应参数 & 通过联系人手机查询非银-其他短时逾期
	private String slLmCellNbankOtherOverdue;
	
	// 响应参数 & 通过联系人手机查询非银-其他资信不佳
	private String slLmCellNbankOtherFraud;
	
	// 响应参数 & 通过联系人手机查询非银-其他失联
	private String slLmCellNbankOtherLost;
	
	// 响应参数 & 通过联系人手机查询非银-其他拒绝
	private String slLmCellNbankOtherRefuse;

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getSlLmCellAbnormal() {
		return slLmCellAbnormal;
	}

	public void setSlLmCellAbnormal(String slLmCellAbnormal) {
		this.slLmCellAbnormal = slLmCellAbnormal;
	}

	public String getSlLmCellPhoneOverdue() {
		return slLmCellPhoneOverdue;
	}

	public void setSlLmCellPhoneOverdue(String slLmCellPhoneOverdue) {
		this.slLmCellPhoneOverdue = slLmCellPhoneOverdue;
	}

	public String getSlLmCellBankBad() {
		return slLmCellBankBad;
	}

	public void setSlLmCellBankBad(String slLmCellBankBad) {
		this.slLmCellBankBad = slLmCellBankBad;
	}

	public String getSlLmCellBankOverdue() {
		return slLmCellBankOverdue;
	}

	public void setSlLmCellBankOverdue(String slLmCellBankOverdue) {
		this.slLmCellBankOverdue = slLmCellBankOverdue;
	}

	public String getSlLmCellBankFraud() {
		return slLmCellBankFraud;
	}

	public void setSlLmCellBankFraud(String slLmCellBankFraud) {
		this.slLmCellBankFraud = slLmCellBankFraud;
	}

	public String getSlLmCellBankLost() {
		return slLmCellBankLost;
	}

	public void setSlLmCellBankLost(String slLmCellBankLost) {
		this.slLmCellBankLost = slLmCellBankLost;
	}

	public String getSlLmCellBankRefuse() {
		return slLmCellBankRefuse;
	}

	public void setSlLmCellBankRefuse(String slLmCellBankRefuse) {
		this.slLmCellBankRefuse = slLmCellBankRefuse;
	}

	public String getSlLmCellNbankP2pBad() {
		return slLmCellNbankP2pBad;
	}

	public void setSlLmCellNbankP2pBad(String slLmCellNbankP2pBad) {
		this.slLmCellNbankP2pBad = slLmCellNbankP2pBad;
	}

	public String getSlLmCellNbankP2pOverdue() {
		return slLmCellNbankP2pOverdue;
	}

	public void setSlLmCellNbankP2pOverdue(String slLmCellNbankP2pOverdue) {
		this.slLmCellNbankP2pOverdue = slLmCellNbankP2pOverdue;
	}

	public String getSlLmCellNbankP2pFraud() {
		return slLmCellNbankP2pFraud;
	}

	public void setSlLmCellNbankP2pFraud(String slLmCellNbankP2pFraud) {
		this.slLmCellNbankP2pFraud = slLmCellNbankP2pFraud;
	}

	public String getSlLmCellNbankP2pLost() {
		return slLmCellNbankP2pLost;
	}

	public void setSlLmCellNbankP2pLost(String slLmCellNbankP2pLost) {
		this.slLmCellNbankP2pLost = slLmCellNbankP2pLost;
	}

	public String getSlLmCellNbankP2pRefuse() {
		return slLmCellNbankP2pRefuse;
	}

	public void setSlLmCellNbankP2pRefuse(String slLmCellNbankP2pRefuse) {
		this.slLmCellNbankP2pRefuse = slLmCellNbankP2pRefuse;
	}

	public String getSlLmCellNbankMcBad() {
		return slLmCellNbankMcBad;
	}

	public void setSlLmCellNbankMcBad(String slLmCellNbankMcBad) {
		this.slLmCellNbankMcBad = slLmCellNbankMcBad;
	}

	public String getSlLmCellNbankMcOverdue() {
		return slLmCellNbankMcOverdue;
	}

	public void setSlLmCellNbankMcOverdue(String slLmCellNbankMcOverdue) {
		this.slLmCellNbankMcOverdue = slLmCellNbankMcOverdue;
	}

	public String getSlLmCellNbankMcFraud() {
		return slLmCellNbankMcFraud;
	}

	public void setSlLmCellNbankMcFraud(String slLmCellNbankMcFraud) {
		this.slLmCellNbankMcFraud = slLmCellNbankMcFraud;
	}

	public String getSlLmCellNbankMcLost() {
		return slLmCellNbankMcLost;
	}

	public void setSlLmCellNbankMcLost(String slLmCellNbankMcLost) {
		this.slLmCellNbankMcLost = slLmCellNbankMcLost;
	}

	public String getSlLmCellNbankMcRefuse() {
		return slLmCellNbankMcRefuse;
	}

	public void setSlLmCellNbankMcRefuse(String slLmCellNbankMcRefuse) {
		this.slLmCellNbankMcRefuse = slLmCellNbankMcRefuse;
	}

	public String getSlLmCellNbankCaBad() {
		return slLmCellNbankCaBad;
	}

	public void setSlLmCellNbankCaBad(String slLmCellNbankCaBad) {
		this.slLmCellNbankCaBad = slLmCellNbankCaBad;
	}

	public String getSlLmCellNbankCaOverdue() {
		return slLmCellNbankCaOverdue;
	}

	public void setSlLmCellNbankCaOverdue(String slLmCellNbankCaOverdue) {
		this.slLmCellNbankCaOverdue = slLmCellNbankCaOverdue;
	}

	public String getSlLmCellNbankCaFraud() {
		return slLmCellNbankCaFraud;
	}

	public void setSlLmCellNbankCaFraud(String slLmCellNbankCaFraud) {
		this.slLmCellNbankCaFraud = slLmCellNbankCaFraud;
	}

	public String getSlLmCellNbankCaLost() {
		return slLmCellNbankCaLost;
	}

	public void setSlLmCellNbankCaLost(String slLmCellNbankCaLost) {
		this.slLmCellNbankCaLost = slLmCellNbankCaLost;
	}

	public String getSlLmCellNbankCaRefuse() {
		return slLmCellNbankCaRefuse;
	}

	public void setSlLmCellNbankCaRefuse(String slLmCellNbankCaRefuse) {
		this.slLmCellNbankCaRefuse = slLmCellNbankCaRefuse;
	}

	public String getSlLmCellNbankComBad() {
		return slLmCellNbankComBad;
	}

	public void setSlLmCellNbankComBad(String slLmCellNbankComBad) {
		this.slLmCellNbankComBad = slLmCellNbankComBad;
	}

	public String getSlLmCellNbankComOverdue() {
		return slLmCellNbankComOverdue;
	}

	public void setSlLmCellNbankComOverdue(String slLmCellNbankComOverdue) {
		this.slLmCellNbankComOverdue = slLmCellNbankComOverdue;
	}

	public String getSlLmCellNbankComFraud() {
		return slLmCellNbankComFraud;
	}

	public void setSlLmCellNbankComFraud(String slLmCellNbankComFraud) {
		this.slLmCellNbankComFraud = slLmCellNbankComFraud;
	}

	public String getSlLmCellNbankComLost() {
		return slLmCellNbankComLost;
	}

	public void setSlLmCellNbankComLost(String slLmCellNbankComLost) {
		this.slLmCellNbankComLost = slLmCellNbankComLost;
	}

	public String getSlLmCellNbankComRefuse() {
		return slLmCellNbankComRefuse;
	}

	public void setSlLmCellNbankComRefuse(String slLmCellNbankComRefuse) {
		this.slLmCellNbankComRefuse = slLmCellNbankComRefuse;
	}

	public String getSlLmCellNbankCfBad() {
		return slLmCellNbankCfBad;
	}

	public void setSlLmCellNbankCfBad(String slLmCellNbankCfBad) {
		this.slLmCellNbankCfBad = slLmCellNbankCfBad;
	}

	public String getSlLmCellNbankCfOverdue() {
		return slLmCellNbankCfOverdue;
	}

	public void setSlLmCellNbankCfOverdue(String slLmCellNbankCfOverdue) {
		this.slLmCellNbankCfOverdue = slLmCellNbankCfOverdue;
	}

	public String getSlLmCellNbankCfFraud() {
		return slLmCellNbankCfFraud;
	}

	public void setSlLmCellNbankCfFraud(String slLmCellNbankCfFraud) {
		this.slLmCellNbankCfFraud = slLmCellNbankCfFraud;
	}

	public String getSlLmCellNbankCfLost() {
		return slLmCellNbankCfLost;
	}

	public void setSlLmCellNbankCfLost(String slLmCellNbankCfLost) {
		this.slLmCellNbankCfLost = slLmCellNbankCfLost;
	}

	public String getSlLmCellNbankCfRefuse() {
		return slLmCellNbankCfRefuse;
	}

	public void setSlLmCellNbankCfRefuse(String slLmCellNbankCfRefuse) {
		this.slLmCellNbankCfRefuse = slLmCellNbankCfRefuse;
	}

	public String getSlLmCellNbankOtherBad() {
		return slLmCellNbankOtherBad;
	}

	public void setSlLmCellNbankOtherBad(String slLmCellNbankOtherBad) {
		this.slLmCellNbankOtherBad = slLmCellNbankOtherBad;
	}

	public String getSlLmCellNbankOtherOverdue() {
		return slLmCellNbankOtherOverdue;
	}

	public void setSlLmCellNbankOtherOverdue(String slLmCellNbankOtherOverdue) {
		this.slLmCellNbankOtherOverdue = slLmCellNbankOtherOverdue;
	}

	public String getSlLmCellNbankOtherFraud() {
		return slLmCellNbankOtherFraud;
	}

	public void setSlLmCellNbankOtherFraud(String slLmCellNbankOtherFraud) {
		this.slLmCellNbankOtherFraud = slLmCellNbankOtherFraud;
	}

	public String getSlLmCellNbankOtherLost() {
		return slLmCellNbankOtherLost;
	}

	public void setSlLmCellNbankOtherLost(String slLmCellNbankOtherLost) {
		this.slLmCellNbankOtherLost = slLmCellNbankOtherLost;
	}

	public String getSlLmCellNbankOtherRefuse() {
		return slLmCellNbankOtherRefuse;
	}

	public void setSlLmCellNbankOtherRefuse(String slLmCellNbankOtherRefuse) {
		this.slLmCellNbankOtherRefuse = slLmCellNbankOtherRefuse;
	}

	
}
