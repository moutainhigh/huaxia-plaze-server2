package com.huaxia.plaze.modules.bairong.domain;

/**
 * 第三方 & 百融征信 & 反欺诈 & 特殊名单核查 & 通过GID查询
 * 
 * @author zhiguo.li
 * @since 2017-11-01
 *
 */
public class BRZXSpecialListForGid extends BRZX {

	private static final long serialVersionUID = -7507797074214267858L;

	// 通过百融标识查询电信欠费
	private String slGidPhoneOverdue;

	// 通过百融标识查询银行(含信用卡)不良
	private String slGidBankBad;

	// 通过百融标识查询银行(含信用卡)短时逾期
	private String slGidBankOverdue;

	// 通过百融标识查询银行(含信用卡)资信不佳
	private String slGidBankFraud;

	// 通过百融标识查询银行(含信用卡)失联
	private String slGidBankLost;

	// 通过百融标识查询银行(含信用卡)拒绝
	private String slGidBankRefuse;
	

	// 通过百融标识查询非银(含全部非银类型)不良
	private String slGidP2pBad;

	// 通过百融标识查询非银(含全部非银类型)短时逾期
	private String slGidP2pOverdue;

	// 通过百融标识查询非银(含全部非银类型)资信不佳
	private String slGidP2pFraud;

	// 通过百融标识查询非银(含全部非银类型)失联
	private String slGidP2pLost;

	// 通过百融标识查询非银(含全部非银类型)拒绝
	private String slGidP2pRefuse;
	

	// 通过百融用户全局标识查询非银-P2P不良
	private String slGidNbankP2pBad;

	// 通过百融用户全局标识查询非银-P2P短时逾期
	private String slGidNbankP2pOverdue;

	// 通过百融用户全局标识查询非银-P2P资信不佳
	private String slGidNbankP2pFraud;

	// 通过百融用户全局标识查询非银-P2P失联
	private String slGidNbankP2pLost;

	// 通过百融用户全局标识查询非银-P2P拒绝
	private String slGidNbankP2pRefuse;
	

	// 通过百融用户全局标识查询非银-小贷不良
	private String slGidNbankMcBad;

	// 通过百融用户全局标识查询非银-小贷短时逾期
	private String slGidNbankMcOverdue;

	// 通过百融用户全局标识查询非银-小贷资信不佳
	private String slGidNbankMcFraud;

	// 通过百融用户全局标识查询非银-小贷失联
	private String slGidNbankMcLost;

	// 通过百融用户全局标识查询非银-小贷拒绝
	private String slGidNbankMcRefuse;
	

	// 通过百融用户全局标识查询非银-现金类分期不良
	private String slGidNbankCaBad;

	// 通过百融用户全局标识查询非银-现金类分期短时逾期
	private String slGidNbankCaOverdue;

	// 通过百融用户全局标识查询非银-现金类分期资信不佳
	private String slGidNbankCaFraud;

	// 通过百融用户全局标识查询非银-现金类分期失联
	private String slGidNbankCaLost;

	// 通过百融用户全局标识查询非银-现金类分期拒绝
	private String slGidNbankCaRefuse;
	

	// 通过百融用户全局标识查询非银-代偿类分期不良
	private String slGidNbankComBad;

	// 通过百融用户全局标识查询非银-代偿类分期短时逾期
	private String slGidNbankComOverdue;

	// 通过百融用户全局标识查询非银-代偿类分期资信不佳
	private String slGidNbankComFraud;

	// 通过百融用户全局标识查询非银-代偿类分期失联
	private String slGidNbankComLost;

	// 通过百融用户全局标识查询非银-代偿类分期拒绝
	private String slGidNbankComRefuse;
	

	// 通过百融用户全局标识查询非银-消费类分期不良
	private String slGidNbankCfBad;

	// 通过百融用户全局标识查询非银-消费类分期短时逾期
	private String slGidNbankCfOverdue;

	// 通过百融用户全局标识查询非银-消费类分期资信不佳
	private String slGidNbankCfFraud;

	// 通过百融用户全局标识查询非银-消费类分期失联
	private String slGidNbankCfLost;

	// 通过百融用户全局标识查询非银-消费类分期拒绝
	private String slGidNbankCfRefuse;
	

	// 通过百融用户全局标识查询非银-其他不良
	private String slGidNbankOtherBad;

	// 通过百融用户全局标识查询非银-其他短时逾期
	private String slGidNbankOtherOverdue;

	// 通过百融用户全局标识查询非银-其他资信不佳
	private String slGidNbankOtherFraud;

	// 通过百融用户全局标识查询非银-其他失联
	private String slGidNbankOtherLost;

	// 通过百融用户全局标识查询非银-其他拒绝
	private String slGidNbankOtherRefuse;

	public String getSlGidPhoneOverdue() {
		return slGidPhoneOverdue;
	}

	public void setSlGidPhoneOverdue(String slGidPhoneOverdue) {
		this.slGidPhoneOverdue = slGidPhoneOverdue;
	}

	public String getSlGidBankBad() {
		return slGidBankBad;
	}

	public void setSlGidBankBad(String slGidBankBad) {
		this.slGidBankBad = slGidBankBad;
	}

	public String getSlGidBankOverdue() {
		return slGidBankOverdue;
	}

	public void setSlGidBankOverdue(String slGidBankOverdue) {
		this.slGidBankOverdue = slGidBankOverdue;
	}

	public String getSlGidBankFraud() {
		return slGidBankFraud;
	}

	public void setSlGidBankFraud(String slGidBankFraud) {
		this.slGidBankFraud = slGidBankFraud;
	}

	public String getSlGidBankLost() {
		return slGidBankLost;
	}

	public void setSlGidBankLost(String slGidBankLost) {
		this.slGidBankLost = slGidBankLost;
	}

	public String getSlGidBankRefuse() {
		return slGidBankRefuse;
	}

	public void setSlGidBankRefuse(String slGidBankRefuse) {
		this.slGidBankRefuse = slGidBankRefuse;
	}

	public String getSlGidP2pBad() {
		return slGidP2pBad;
	}

	public void setSlGidP2pBad(String slGidP2pBad) {
		this.slGidP2pBad = slGidP2pBad;
	}

	public String getSlGidP2pOverdue() {
		return slGidP2pOverdue;
	}

	public void setSlGidP2pOverdue(String slGidP2pOverdue) {
		this.slGidP2pOverdue = slGidP2pOverdue;
	}

	public String getSlGidP2pFraud() {
		return slGidP2pFraud;
	}

	public void setSlGidP2pFraud(String slGidP2pFraud) {
		this.slGidP2pFraud = slGidP2pFraud;
	}

	public String getSlGidP2pLost() {
		return slGidP2pLost;
	}

	public void setSlGidP2pLost(String slGidP2pLost) {
		this.slGidP2pLost = slGidP2pLost;
	}

	public String getSlGidP2pRefuse() {
		return slGidP2pRefuse;
	}

	public void setSlGidP2pRefuse(String slGidP2pRefuse) {
		this.slGidP2pRefuse = slGidP2pRefuse;
	}

	public String getSlGidNbankP2pBad() {
		return slGidNbankP2pBad;
	}

	public void setSlGidNbankP2pBad(String slGidNbankP2pBad) {
		this.slGidNbankP2pBad = slGidNbankP2pBad;
	}

	public String getSlGidNbankP2pOverdue() {
		return slGidNbankP2pOverdue;
	}

	public void setSlGidNbankP2pOverdue(String slGidNbankP2pOverdue) {
		this.slGidNbankP2pOverdue = slGidNbankP2pOverdue;
	}

	public String getSlGidNbankP2pFraud() {
		return slGidNbankP2pFraud;
	}

	public void setSlGidNbankP2pFraud(String slGidNbankP2pFraud) {
		this.slGidNbankP2pFraud = slGidNbankP2pFraud;
	}

	public String getSlGidNbankP2pLost() {
		return slGidNbankP2pLost;
	}

	public void setSlGidNbankP2pLost(String slGidNbankP2pLost) {
		this.slGidNbankP2pLost = slGidNbankP2pLost;
	}

	public String getSlGidNbankP2pRefuse() {
		return slGidNbankP2pRefuse;
	}

	public void setSlGidNbankP2pRefuse(String slGidNbankP2pRefuse) {
		this.slGidNbankP2pRefuse = slGidNbankP2pRefuse;
	}

	public String getSlGidNbankMcBad() {
		return slGidNbankMcBad;
	}

	public void setSlGidNbankMcBad(String slGidNbankMcBad) {
		this.slGidNbankMcBad = slGidNbankMcBad;
	}

	public String getSlGidNbankMcOverdue() {
		return slGidNbankMcOverdue;
	}

	public void setSlGidNbankMcOverdue(String slGidNbankMcOverdue) {
		this.slGidNbankMcOverdue = slGidNbankMcOverdue;
	}

	public String getSlGidNbankMcFraud() {
		return slGidNbankMcFraud;
	}

	public void setSlGidNbankMcFraud(String slGidNbankMcFraud) {
		this.slGidNbankMcFraud = slGidNbankMcFraud;
	}

	public String getSlGidNbankMcLost() {
		return slGidNbankMcLost;
	}

	public void setSlGidNbankMcLost(String slGidNbankMcLost) {
		this.slGidNbankMcLost = slGidNbankMcLost;
	}

	public String getSlGidNbankMcRefuse() {
		return slGidNbankMcRefuse;
	}

	public void setSlGidNbankMcRefuse(String slGidNbankMcRefuse) {
		this.slGidNbankMcRefuse = slGidNbankMcRefuse;
	}

	public String getSlGidNbankCaBad() {
		return slGidNbankCaBad;
	}

	public void setSlGidNbankCaBad(String slGidNbankCaBad) {
		this.slGidNbankCaBad = slGidNbankCaBad;
	}

	public String getSlGidNbankCaOverdue() {
		return slGidNbankCaOverdue;
	}

	public void setSlGidNbankCaOverdue(String slGidNbankCaOverdue) {
		this.slGidNbankCaOverdue = slGidNbankCaOverdue;
	}

	public String getSlGidNbankCaFraud() {
		return slGidNbankCaFraud;
	}

	public void setSlGidNbankCaFraud(String slGidNbankCaFraud) {
		this.slGidNbankCaFraud = slGidNbankCaFraud;
	}

	public String getSlGidNbankCaLost() {
		return slGidNbankCaLost;
	}

	public void setSlGidNbankCaLost(String slGidNbankCaLost) {
		this.slGidNbankCaLost = slGidNbankCaLost;
	}

	public String getSlGidNbankCaRefuse() {
		return slGidNbankCaRefuse;
	}

	public void setSlGidNbankCaRefuse(String slGidNbankCaRefuse) {
		this.slGidNbankCaRefuse = slGidNbankCaRefuse;
	}

	public String getSlGidNbankComBad() {
		return slGidNbankComBad;
	}

	public void setSlGidNbankComBad(String slGidNbankComBad) {
		this.slGidNbankComBad = slGidNbankComBad;
	}

	public String getSlGidNbankComOverdue() {
		return slGidNbankComOverdue;
	}

	public void setSlGidNbankComOverdue(String slGidNbankComOverdue) {
		this.slGidNbankComOverdue = slGidNbankComOverdue;
	}

	public String getSlGidNbankComFraud() {
		return slGidNbankComFraud;
	}

	public void setSlGidNbankComFraud(String slGidNbankComFraud) {
		this.slGidNbankComFraud = slGidNbankComFraud;
	}

	public String getSlGidNbankComLost() {
		return slGidNbankComLost;
	}

	public void setSlGidNbankComLost(String slGidNbankComLost) {
		this.slGidNbankComLost = slGidNbankComLost;
	}

	public String getSlGidNbankComRefuse() {
		return slGidNbankComRefuse;
	}

	public void setSlGidNbankComRefuse(String slGidNbankComRefuse) {
		this.slGidNbankComRefuse = slGidNbankComRefuse;
	}

	public String getSlGidNbankCfBad() {
		return slGidNbankCfBad;
	}

	public void setSlGidNbankCfBad(String slGidNbankCfBad) {
		this.slGidNbankCfBad = slGidNbankCfBad;
	}

	public String getSlGidNbankCfOverdue() {
		return slGidNbankCfOverdue;
	}

	public void setSlGidNbankCfOverdue(String slGidNbankCfOverdue) {
		this.slGidNbankCfOverdue = slGidNbankCfOverdue;
	}

	public String getSlGidNbankCfFraud() {
		return slGidNbankCfFraud;
	}

	public void setSlGidNbankCfFraud(String slGidNbankCfFraud) {
		this.slGidNbankCfFraud = slGidNbankCfFraud;
	}

	public String getSlGidNbankCfLost() {
		return slGidNbankCfLost;
	}

	public void setSlGidNbankCfLost(String slGidNbankCfLost) {
		this.slGidNbankCfLost = slGidNbankCfLost;
	}

	public String getSlGidNbankCfRefuse() {
		return slGidNbankCfRefuse;
	}

	public void setSlGidNbankCfRefuse(String slGidNbankCfRefuse) {
		this.slGidNbankCfRefuse = slGidNbankCfRefuse;
	}

	public String getSlGidNbankOtherBad() {
		return slGidNbankOtherBad;
	}

	public void setSlGidNbankOtherBad(String slGidNbankOtherBad) {
		this.slGidNbankOtherBad = slGidNbankOtherBad;
	}

	public String getSlGidNbankOtherOverdue() {
		return slGidNbankOtherOverdue;
	}

	public void setSlGidNbankOtherOverdue(String slGidNbankOtherOverdue) {
		this.slGidNbankOtherOverdue = slGidNbankOtherOverdue;
	}

	public String getSlGidNbankOtherFraud() {
		return slGidNbankOtherFraud;
	}

	public void setSlGidNbankOtherFraud(String slGidNbankOtherFraud) {
		this.slGidNbankOtherFraud = slGidNbankOtherFraud;
	}

	public String getSlGidNbankOtherLost() {
		return slGidNbankOtherLost;
	}

	public void setSlGidNbankOtherLost(String slGidNbankOtherLost) {
		this.slGidNbankOtherLost = slGidNbankOtherLost;
	}

	public String getSlGidNbankOtherRefuse() {
		return slGidNbankOtherRefuse;
	}

	public void setSlGidNbankOtherRefuse(String slGidNbankOtherRefuse) {
		this.slGidNbankOtherRefuse = slGidNbankOtherRefuse;
	}

}
