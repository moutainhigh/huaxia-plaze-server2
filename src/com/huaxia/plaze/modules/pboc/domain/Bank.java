package com.huaxia.plaze.modules.pboc.domain;

import java.io.Serializable;
/**
 * 人行二期
 * @author gaoh
 *
 */
public class Bank implements Serializable {
	 
	private static final long serialVersionUID = -2604250987665426111L;
	private PRH PRH;//报告头       [1..1]
	private PIM PIM;//身份信息   [1..1]  
	private PMM PMM;//婚姻信息   [1..1] 
	private PRM PRM;//居住信息   [1..1] 
	private POM POM;//职业信息   [1..1]
	private PSM PSM;//评分信息   [1..1]
	private PCO PCO;//信贷交易信息概要     [1..1]
	private PNO PNO;//非信贷交易信息概要  [1..1]
	private PPO PPO;//公共信息概要   [1..1]
	private PQO PQO;//查询记录概要    [1..1]
	private PDA PDA;//借贷账户信息   [1..1]
	private PCA PCA;// 授信协议信息   [1..1] 
	private PCR PCR;//相关还款责任信息    [1..1] 
	private PND PND;//后付费业务信息    [1..1] 
	private POT POT;//欠税记录           [1..1] 
	private PCJ PCJ;//民事判决记录   [1..1]  
	private PCE PCE;//强制执行记录    [1..1]
	private PAP PAP;//行政处罚记录    [1..1]
	private PHF PHF;//住房公积金参缴记录   [1..1] 
	private PBS PBS;//低保救助记录    [1..1] 
	private PPQ PPQ;//执业资格记录   [1..1] 
	private PAH PAH;//行政奖励记录    [1..1] 
	private POS POS;//其他标注及声明信息   [1..1] 
	private POQ POQ;//查询记录   [1..1] 
    private String identityCardNo;//身份证号
	private String uniqueRelid;//每个身份证号码关联的唯一uuid值
	public PRH getPRH() {
		return PRH;
	}
	public void setPRH(PRH pRH) {
		PRH = pRH;
	}
	public PIM getPIM() {
		return PIM;
	}
	public void setPIM(PIM pIM) {
		PIM = pIM;
	}
	public PMM getPMM() {
		return PMM;
	}
	public void setPMM(PMM pMM) {
		PMM = pMM;
	}
	public PRM getPRM() {
		return PRM;
	}
	public void setPRM(PRM pRM) {
		PRM = pRM;
	}
	public POM getPOM() {
		return POM;
	}
	public void setPOM(POM pOM) {
		POM = pOM;
	}
	public PSM getPSM() {
		return PSM;
	}
	public void setPSM(PSM pSM) {
		PSM = pSM;
	}
	public PCO getPCO() {
		return PCO;
	}
	public void setPCO(PCO pCO) {
		PCO = pCO;
	}
	public PNO getPNO() {
		return PNO;
	}
	public void setPNO(PNO pNO) {
		PNO = pNO;
	}
	public PPO getPPO() {
		return PPO;
	}
	public void setPPO(PPO pPO) {
		PPO = pPO;
	}
	public PQO getPQO() {
		return PQO;
	}
	public void setPQO(PQO pQO) {
		PQO = pQO;
	}
	public PDA getPDA() {
		return PDA;
	}
	public void setPDA(PDA pDA) {
		PDA = pDA;
	}
	public PCA getPCA() {
		return PCA;
	}
	public void setPCA(PCA pCA) {
		PCA = pCA;
	}
	public PCR getPCR() {
		return PCR;
	}
	public void setPCR(PCR pCR) {
		PCR = pCR;
	}
	public PND getPND() {
		return PND;
	}
	public void setPND(PND pND) {
		PND = pND;
	}
	public POT getPOT() {
		return POT;
	}
	public void setPOT(POT pOT) {
		POT = pOT;
	}
	public PCJ getPCJ() {
		return PCJ;
	}
	public void setPCJ(PCJ pCJ) {
		PCJ = pCJ;
	}
	public PCE getPCE() {
		return PCE;
	}
	public void setPCE(PCE pCE) {
		PCE = pCE;
	}
	public PAP getPAP() {
		return PAP;
	}
	public void setPAP(PAP pAP) {
		PAP = pAP;
	}
	public PHF getPHF() {
		return PHF;
	}
	public void setPHF(PHF pHF) {
		PHF = pHF;
	}
	public PBS getPBS() {
		return PBS;
	}
	public void setPBS(PBS pBS) {
		PBS = pBS;
	}
	public PPQ getPPQ() {
		return PPQ;
	}
	public void setPPQ(PPQ pPQ) {
		PPQ = pPQ;
	}
	public PAH getPAH() {
		return PAH;
	}
	public void setPAH(PAH pAH) {
		PAH = pAH;
	}
	public POS getPOS() {
		return POS;
	}
	public void setPOS(POS pOS) {
		POS = pOS;
	}
	public POQ getPOQ() {
		return POQ;
	}
	public void setPOQ(POQ pOQ) {
		POQ = pOQ;
	}
	public String getIdentityCardNo() {
		return identityCardNo;
	}
	public void setIdentityCardNo(String identityCardNo) {
		this.identityCardNo = identityCardNo;
	}
	public String getUniqueRelid() {
		return uniqueRelid;
	}
	public void setUniqueRelid(String uniqueRelid) {
		this.uniqueRelid = uniqueRelid;
	}
	
	
}
