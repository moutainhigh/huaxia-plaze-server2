package com.huaxia.plaze.modules.bairong.domain;

import java.util.Date;

/**
 * 百通返回的近一个月的相关数据
 * 
 * @author liuwei
 */
public class ApplyLoanStrMonth1 {
	
	private String trnKey;

	// 主键唯一
	private String uuid;

	// 创建时间
	private Date crtTime;

	// 创建用户
	private String crtUser;

	// 业务的主键，实现不同系统之间的同步
	private String trnId;

	// 申请件编号
	private String appId;

	// 按身份证号查询，近1个月申请线上小额现金贷的次数
	private String m1IdPdlAllnum;

	// 按身份证号查询，近1个月申请线上小额现金贷的机构数
	private String m1IdPdlOrgnum;

	// 按身份证号查询，近1个月申请线上现金分期的次数
	private String m1IdCaonAllnum;

	// 按身份证号查询，近1个月申请线上现金分期的机构数
	private String m1IdCaonOrgnum;

	// 按身份证号查询，近1个月申请信用卡（类信用卡）的次数
	private String m1IdRelAllnum;

	// 按身份证号查询，近1个月申请信用卡（类信用卡）的机构数
	private String m1IdRelOrgnum;

	// 按身份证号查询，近1个月申请线下现金分期的次数
	private String m1IdCaoffAllnum;

	// 按身份证号查询，近1个月申请线下现金分期的机构数
	private String m1IdCaoffOrgnum;

	// 按身份证号查询，近1个月申请线下消费分期的次数
	private String m1IdCooffAllnum;

	// 按身份证号查询，近1个月申请线下消费分期的机构数
	private String m1IdCooffOrgnum;

	// 按身份证号查询，近1个月申请汽车金融的次数
	private String m1IdAfAllnum;

	// 按身份证号查询，近1个月申请汽车金融的机构数
	private String m1IdAfOrgnum;

	// 按身份证号查询，近1个月申请线上消费分期的次数
	private String m1IdCoonAllnum;

	// 按身份证号查询，近1个月申请线上消费分期的机构数
	private String m1IdCoonOrgnum;

	// 按身份证号查询，近1个月申请其他的次数
	private String m1IdOthAllnum;

	// 按身份证号查询，近1个月申请其他的机构数
	private String m1IdOthOrgnum;

	// 按身份证号查询，近1个月在本机构(本机构为银行)的申请次数
	private String m1IdBankSelfnum;

	// 按身份证号查询，近1个月在银行机构申请次数
	private String m1IdBankAllnum;

	// 按身份证号查询，近1个月在银行机构-传统银行申请次数
	private String m1IdBankTraAllnum;

	// 按身份证号查询，近1个月在银行机构-网络零售银行申请次数
	private String m1IdBankRetAllnum;

	// 按身份证号查询，近1个月在银行机构申请机构数
	private String m1IdBankOrgnum;

	// 按身份证号查询，近1个月在银行机构-传统银行申请机构数
	private String m1IdBankTraOrgnum;

	// 按身份证号查询，近1个月在银行机构-网络零售银行申请机构数
	private String m1IdBankRetOrgnum;

	// 按身份证号查询，近1个月在银行机构周末申请次数
	private String m1IdBankWeekAllnum;

	// 按身份证号查询，近1个月在银行机构周末申请机构数
	private String m1IdBankWeekOrgnum;

	// 按身份证号查询，近1个月在银行机构夜间申请次数
	private String m1IdBankNightAllnum;

	// 按身份证号查询，近1个月在银行机构夜间申请机构数
	private String m1IdBankNightOrgnum;

	// 按身份证号查询，近1个月在本机构(本机构为非银)申请次数
	private String m1IdNbankSelfnum;

	// 按身份证号查询，近1个月在非银机构申请次数
	private String m1IdNbankAllnum;

	// 按身份证号查询，近1个月在非银机构-p2p机构申请次数
	private String m1IdNbankP2pAllnum;

	// 按身份证号查询，近1个月在非银机构-小贷机构申请次数
	private String m1IdNbankMcAllnum;

	// 按身份证号查询，近1个月在非银机构-现金类分期机构申请次数
	private String m1IdNbankCaAllnum;

	// 按身份证号查询，近1个月在非银机构-消费类分期机构申请次数
	private String m1IdNbankCfAllnum;

	// 按身份证号查询，近1个月在非银机构-代偿类分期机构申请次数
	private String m1IdNbankComAllnum;

	// 按身份证号查询，近1个月在非银机构-其他申请次数
	private String m1IdNbankOthAllnum;

	// 按身份证号查询，近1个月在非银机构-持牌网络小贷机构申请次数
	private String m1IdNbankNsloanAllnum;

	// 按身份证号查询，近1个月在非银机构-持牌汽车金融机构申请次数
	private String m1IdNbankAutofinAllnum;

	// 按身份证号查询，近1个月在非银机构-持牌小贷机构申请次数
	private String m1IdNbankSloanAllnum;

	// 按身份证号查询，近1个月在非银机构-持牌消费金融机构申请次数
	private String m1IdNbankConsAllnum;

	// 按身份证号查询，近1个月在非银机构-持牌融资租赁机构申请次数
	private String m1IdNbankFinleaAllnum;

	// 按身份证号查询，近1个月在非银机构-其他申请次数
	private String m1IdNbankElseAllnum;

	// 按身份证号查询，近1个月在非银机构申请机构数
	private String m1IdNbankOrgnum;

	// 按身份证号查询，近1个月在非银机构-p2p申请机构数
	private String m1IdNbankP2pOrgnum;

	// 按身份证号查询，近1个月在非银机构-小贷申请机构数
	private String m1IdNbankMcOrgnum;

	// 按身份证号查询，近1个月在非银机构-现金类分期申请机构数
	private String m1IdNbankCaOrgnum;

	// 按身份证号查询，近1个月在非银机构-消费类分期申请机构数
	private String m1IdNbankCfOrgnum;

	// 按身份证号查询，近1个月在非银机构-代偿类分期申请机构数
	private String m1IdNbankComOrgnum;

	// 按身份证号查询，近1个月在非银机构-其他申请机构数
	private String m1IdNbankOthOrgnum;

	// 按身份证号查询，近1个月在非银机构-持牌网络小贷机构申请机构数
	private String m1IdNbankNsloanOrgnum;

	// 按身份证号查询，近1个月在非银机构-持牌汽车金融机构申请机构数
	private String m1IdNbankAutofinOrgnum;

	// 按身份证号查询，近1个月在非银机构-持牌小贷机构申请机构数
	private String m1IdNbankSloanOrgnum;

	// 按身份证号查询，近1个月在非银机构-持牌消费金融机构申请机构数
	private String m1IdNbankConsOrgnum;

	// 按身份证号查询，近1个月在非银机构-持牌融资租赁机构申请机构数
	private String m1IdNbankFinleaOrgnum;

	// 按身份证号查询，近1个月在非银机构-其他申请机构数
	private String m1IdNbankElseOrgnum;

	// 按身份证号查询，近1个月在非银机构周末申请次数
	private String m1IdNbankWeekAllnum;

	// 按身份证号查询，近1个月在非银机构周末申请机构数
	private String m1IdNbankWeekOrgnum;

	// 按身份证号查询，近1个月在非银机构夜间申请次数
	private String m1IdNbankNightAllnum;

	// 按身份证号查询，近1个月在非银机构夜间申请机构数
	private String m1IdNbankNightOrgnum;

	// 按手机号查询，近1个月申请线上小额现金贷的次数
	private String m1CellPdlAllnum;

	// 按手机号查询，近1个月申请线上小额现金贷的机构数
	private String m1CellPdlOrgnum;

	// 按手机号查询，近1个月申请线上现金分期的次数
	private String m1CellCaonAllnum;

	// 按手机号查询，近1个月申请线上现金分期的机构数
	private String m1CellCaonOrgnum;

	// 按手机号查询，近1个月申请信用卡（类信用卡）的次数
	private String m1CellRelAllnum;

	// 按手机号查询，近1个月申请信用卡（类信用卡）的机构数
	private String m1CellRelOrgnum;

	// 按手机号查询，近1个月申请线下现金分期的次数
	private String m1CellCaoffAllnum;

	// 按手机号查询，近1个月申请线下现金分期的机构数
	private String m1CellCaoffOrgnum;

	// 按手机号查询，近1个月申请线下消费分期的次数
	private String m1CellCooffAllnum;

	// 按手机号查询，近1个月申请线下消费分期的机构数
	private String m1CellCooffOrgnum;

	// 按手机号查询，近1个月申请汽车金融的次数
	private String m1CellAfAllnum;

	// 按手机号查询，近1个月申请汽车金融的机构数
	private String m1CellAfOrgnum;

	// 按手机号查询，近1个月申请线上消费分期的次数
	private String m1CellCoonAllnum;

	// 按手机号查询，近1个月申请线上消费分期的机构数
	private String m1CellCoonOrgnum;

	// 按手机号查询，近1个月申请其他的次数
	private String m1CellOthAllnum;

	// 按手机号查询，近1个月申请其他的机构数
	private String m1CellOthOrgnum;

	// 按手机号查询，近1个月在本机构(本机构为银行)的申请次数
	private String m1CellBankSelfnum;

	// 按手机号查询，近1个月在银行机构申请次数
	private String m1CellBankAllnum;

	// 按手机号查询，近1个月在银行机构-传统银行申请次数
	private String m1CellBankTraAllnum;

	// 按手机号查询，近1个月在银行机构-网络零售银行申请次数
	private String m1CellBankRetAllnum;

	// 按手机号查询，近1个月在银行机构申请机构数
	private String m1CellBankOrgnum;

	// 按手机号查询，近1个月在银行机构-传统银行申请机构数
	private String m1CellBankTraOrgnum;

	// 按手机号查询，近1个月在银行机构-网络零售银行申请机构数
	private String m1CellBankRetOrgnum;

	// 按手机号查询，近1个月在银行机构周末申请次数
	private String m1CellBankWeekAllnum;

	// 按手机号查询，近1个月在银行机构周末申请机构数
	private String m1CellBankWeekOrgnum;

	// 按手机号查询，近1个月在银行机构夜间申请次数
	private String m1CellBankNightAllnum;

	// 按手机号查询，近1个月在银行机构夜间申请机构数
	private String m1CellBankNightOrgnum;

	// 按手机号查询，近1个月在本机构(本机构为非银)申请次数
	private String m1CellNbankSelfnum;

	// 按手机号查询，近1个月在非银机构申请次数
	private String m1CellNbankAllnum;

	// 按手机号查询，近1个月在非银机构-p2p机构申请次数
	private String m1CellNbankP2pAllnum;

	// 按手机号查询，近1个月在非银机构-小贷机构申请次数
	private String m1CellNbankMcAllnum;

	// 按手机号查询，近1个月在非银机构-现金类分期机构申请次数
	private String m1CellNbankCaAllnum;

	// 按手机号查询，近1个月在非银机构-消费类分期机构申请次数
	private String m1CellNbankCfAllnum;

	// 按手机号查询，近1个月在非银机构-代偿类分期机构申请次数
	private String m1CellNbankComAllnum;

	// 按手机号查询，近1个月在非银机构-其他申请次数
	private String m1CellNbankOthAllnum;

	// 按手机号查询，近1个月在非银机构-持牌网络小贷机构申请次数
	private String m1CellNbankNsloanAllnum;

	// 按手机号查询，近1个月在非银机构-持牌汽车金融机构申请次数
	private String m1CellNbankAutofinAllnum;

	// 按手机号查询，近1个月在非银机构-持牌小贷机构申请次数
	private String m1CellNbankSloanAllnum;

	// 按手机号查询，近1个月在非银机构-持牌消费金融机构申请次数
	private String m1CellNbankConsAllnum;

	// 按手机号查询，近1个月在非银机构-持牌融资租赁机构申请次数
	private String m1CellNbankFinleaAllnum;

	// 按手机号查询，近1个月在非银机构-其他申请次数
	private String m1CellNbankElseAllnum;

	// 按手机号查询，近1个月在非银机构申请机构数
	private String m1CellNbankOrgnum;

	// 按手机号查询，近1个月在非银机构-p2p申请机构数
	private String m1CellNbankP2pOrgnum;

	// 按手机号查询，近1个月在非银机构-小贷申请机构数
	private String m1CellNbankMcOrgnum;

	// 按手机号查询，近1个月在非银机构-现金类分期申请机构数
	private String m1CellNbankCaOrgnum;

	// 按手机号查询，近1个月在非银机构-消费类分期申请机构数
	private String m1CellNbankCfOrgnum;

	// 按手机号查询，近1个月在非银机构-代偿类分期申请机构数
	private String m1CellNbankComOrgnum;

	// 按手机号查询，近1个月在非银机构-其他申请机构数
	private String m1CellNbankOthOrgnum;

	// 按手机号查询，近1个月在非银机构-持牌网络小贷机构申请机构数
	private String m1CellNbankNsloanOrgnum;

	// 按手机号查询，近1个月在非银机构-持牌汽车金融机构申请机构数
	private String m1CellNbankAutofinOrgnum;

	// 按手机号查询，近1个月在非银机构-持牌小贷机构申请机构数
	private String m1CellNbankSloanOrgnum;

	// 按手机号查询，近1个月在非银机构-持牌消费金融机构申请机构数
	private String m1CellNbankConsOrgnum;

	// 按手机号查询，近1个月在非银机构-持牌融资租赁机构申请机构数
	private String m1CellNbankFinleaOrgnum;

	// 按手机号查询，近1个月在非银机构-其他申请机构数
	private String m1CellNbankElseOrgnum;

	// 按手机号查询，近1个月在非银机构周末申请次数
	private String m1CellNbankWeekAllnum;

	// 按手机号查询，近1个月在非银机构周末申请机构数
	private String m1CellNbankWeekOrgnum;

	// 按手机号查询，近1个月在非银机构夜间申请次数
	private String m1CellNbankNightAllnum;

	// 按手机号查询，近1个月在非银机构夜间申请机构数
	private String m1CellNbankNightOrgnum;

	public String getUuid() {
		return uuid;
	}

	public Date getCrtTime() {
		return crtTime;
	}

	public String getCrtUser() {
		return crtUser;
	}

	public String getTrnId() {
		return trnId;
	}

	public String getAppId() {
		return appId;
	}

	public String getM1IdPdlAllnum() {
		return m1IdPdlAllnum;
	}

	public String getM1IdPdlOrgnum() {
		return m1IdPdlOrgnum;
	}

	public String getM1IdCaonAllnum() {
		return m1IdCaonAllnum;
	}

	public String getM1IdCaonOrgnum() {
		return m1IdCaonOrgnum;
	}

	public String getM1IdRelAllnum() {
		return m1IdRelAllnum;
	}

	public String getM1IdRelOrgnum() {
		return m1IdRelOrgnum;
	}

	public String getM1IdCaoffAllnum() {
		return m1IdCaoffAllnum;
	}

	public String getM1IdCaoffOrgnum() {
		return m1IdCaoffOrgnum;
	}

	public String getM1IdCooffAllnum() {
		return m1IdCooffAllnum;
	}

	public String getM1IdCooffOrgnum() {
		return m1IdCooffOrgnum;
	}

	public String getM1IdAfAllnum() {
		return m1IdAfAllnum;
	}

	public String getM1IdAfOrgnum() {
		return m1IdAfOrgnum;
	}

	public String getM1IdCoonAllnum() {
		return m1IdCoonAllnum;
	}

	public String getM1IdCoonOrgnum() {
		return m1IdCoonOrgnum;
	}

	public String getM1IdOthAllnum() {
		return m1IdOthAllnum;
	}

	public String getM1IdOthOrgnum() {
		return m1IdOthOrgnum;
	}

	public String getM1IdBankSelfnum() {
		return m1IdBankSelfnum;
	}

	public String getM1IdBankAllnum() {
		return m1IdBankAllnum;
	}

	public String getM1IdBankTraAllnum() {
		return m1IdBankTraAllnum;
	}

	public String getM1IdBankRetAllnum() {
		return m1IdBankRetAllnum;
	}

	public String getM1IdBankOrgnum() {
		return m1IdBankOrgnum;
	}

	public String getM1IdBankTraOrgnum() {
		return m1IdBankTraOrgnum;
	}

	public String getM1IdBankRetOrgnum() {
		return m1IdBankRetOrgnum;
	}

	public String getM1IdBankWeekAllnum() {
		return m1IdBankWeekAllnum;
	}

	public String getM1IdBankWeekOrgnum() {
		return m1IdBankWeekOrgnum;
	}

	public String getM1IdBankNightAllnum() {
		return m1IdBankNightAllnum;
	}

	public String getM1IdBankNightOrgnum() {
		return m1IdBankNightOrgnum;
	}

	public String getM1IdNbankSelfnum() {
		return m1IdNbankSelfnum;
	}

	public String getM1IdNbankAllnum() {
		return m1IdNbankAllnum;
	}

	public String getM1IdNbankP2pAllnum() {
		return m1IdNbankP2pAllnum;
	}

	public String getM1IdNbankMcAllnum() {
		return m1IdNbankMcAllnum;
	}

	public String getM1IdNbankCaAllnum() {
		return m1IdNbankCaAllnum;
	}

	public String getM1IdNbankCfAllnum() {
		return m1IdNbankCfAllnum;
	}

	public String getM1IdNbankComAllnum() {
		return m1IdNbankComAllnum;
	}

	public String getM1IdNbankOthAllnum() {
		return m1IdNbankOthAllnum;
	}

	public String getM1IdNbankNsloanAllnum() {
		return m1IdNbankNsloanAllnum;
	}

	public String getM1IdNbankAutofinAllnum() {
		return m1IdNbankAutofinAllnum;
	}

	public String getM1IdNbankSloanAllnum() {
		return m1IdNbankSloanAllnum;
	}

	public String getM1IdNbankConsAllnum() {
		return m1IdNbankConsAllnum;
	}

	public String getM1IdNbankFinleaAllnum() {
		return m1IdNbankFinleaAllnum;
	}

	public String getM1IdNbankElseAllnum() {
		return m1IdNbankElseAllnum;
	}

	public String getM1IdNbankOrgnum() {
		return m1IdNbankOrgnum;
	}

	public String getM1IdNbankP2pOrgnum() {
		return m1IdNbankP2pOrgnum;
	}

	public String getM1IdNbankMcOrgnum() {
		return m1IdNbankMcOrgnum;
	}

	public String getM1IdNbankCaOrgnum() {
		return m1IdNbankCaOrgnum;
	}

	public String getM1IdNbankCfOrgnum() {
		return m1IdNbankCfOrgnum;
	}

	public String getM1IdNbankComOrgnum() {
		return m1IdNbankComOrgnum;
	}

	public String getM1IdNbankOthOrgnum() {
		return m1IdNbankOthOrgnum;
	}

	public String getM1IdNbankNsloanOrgnum() {
		return m1IdNbankNsloanOrgnum;
	}

	public String getM1IdNbankAutofinOrgnum() {
		return m1IdNbankAutofinOrgnum;
	}

	public String getM1IdNbankSloanOrgnum() {
		return m1IdNbankSloanOrgnum;
	}

	public String getM1IdNbankConsOrgnum() {
		return m1IdNbankConsOrgnum;
	}

	public String getM1IdNbankFinleaOrgnum() {
		return m1IdNbankFinleaOrgnum;
	}

	public String getM1IdNbankElseOrgnum() {
		return m1IdNbankElseOrgnum;
	}

	public String getM1IdNbankWeekAllnum() {
		return m1IdNbankWeekAllnum;
	}

	public String getM1IdNbankWeekOrgnum() {
		return m1IdNbankWeekOrgnum;
	}

	public String getM1IdNbankNightAllnum() {
		return m1IdNbankNightAllnum;
	}

	public String getM1IdNbankNightOrgnum() {
		return m1IdNbankNightOrgnum;
	}

	public String getM1CellPdlAllnum() {
		return m1CellPdlAllnum;
	}

	public String getM1CellPdlOrgnum() {
		return m1CellPdlOrgnum;
	}

	public String getM1CellCaonAllnum() {
		return m1CellCaonAllnum;
	}

	public String getM1CellCaonOrgnum() {
		return m1CellCaonOrgnum;
	}

	public String getM1CellRelAllnum() {
		return m1CellRelAllnum;
	}

	public String getM1CellRelOrgnum() {
		return m1CellRelOrgnum;
	}

	public String getM1CellCaoffAllnum() {
		return m1CellCaoffAllnum;
	}

	public String getM1CellCaoffOrgnum() {
		return m1CellCaoffOrgnum;
	}

	public String getM1CellCooffAllnum() {
		return m1CellCooffAllnum;
	}

	public String getM1CellCooffOrgnum() {
		return m1CellCooffOrgnum;
	}

	public String getM1CellAfAllnum() {
		return m1CellAfAllnum;
	}

	public String getM1CellAfOrgnum() {
		return m1CellAfOrgnum;
	}

	public String getM1CellCoonAllnum() {
		return m1CellCoonAllnum;
	}

	public String getM1CellCoonOrgnum() {
		return m1CellCoonOrgnum;
	}

	public String getM1CellOthAllnum() {
		return m1CellOthAllnum;
	}

	public String getM1CellOthOrgnum() {
		return m1CellOthOrgnum;
	}

	public String getM1CellBankSelfnum() {
		return m1CellBankSelfnum;
	}

	public String getM1CellBankAllnum() {
		return m1CellBankAllnum;
	}

	public String getM1CellBankTraAllnum() {
		return m1CellBankTraAllnum;
	}

	public String getM1CellBankRetAllnum() {
		return m1CellBankRetAllnum;
	}

	public String getM1CellBankOrgnum() {
		return m1CellBankOrgnum;
	}

	public String getM1CellBankTraOrgnum() {
		return m1CellBankTraOrgnum;
	}

	public String getM1CellBankRetOrgnum() {
		return m1CellBankRetOrgnum;
	}

	public String getM1CellBankWeekAllnum() {
		return m1CellBankWeekAllnum;
	}

	public String getM1CellBankWeekOrgnum() {
		return m1CellBankWeekOrgnum;
	}

	public String getM1CellBankNightAllnum() {
		return m1CellBankNightAllnum;
	}

	public String getM1CellBankNightOrgnum() {
		return m1CellBankNightOrgnum;
	}

	public String getM1CellNbankSelfnum() {
		return m1CellNbankSelfnum;
	}

	public String getM1CellNbankAllnum() {
		return m1CellNbankAllnum;
	}

	public String getM1CellNbankP2pAllnum() {
		return m1CellNbankP2pAllnum;
	}

	public String getM1CellNbankMcAllnum() {
		return m1CellNbankMcAllnum;
	}

	public String getM1CellNbankCaAllnum() {
		return m1CellNbankCaAllnum;
	}

	public String getM1CellNbankCfAllnum() {
		return m1CellNbankCfAllnum;
	}

	public String getM1CellNbankComAllnum() {
		return m1CellNbankComAllnum;
	}

	public String getM1CellNbankOthAllnum() {
		return m1CellNbankOthAllnum;
	}

	public String getM1CellNbankNsloanAllnum() {
		return m1CellNbankNsloanAllnum;
	}

	public String getM1CellNbankAutofinAllnum() {
		return m1CellNbankAutofinAllnum;
	}

	public String getM1CellNbankSloanAllnum() {
		return m1CellNbankSloanAllnum;
	}

	public String getM1CellNbankConsAllnum() {
		return m1CellNbankConsAllnum;
	}

	public String getM1CellNbankFinleaAllnum() {
		return m1CellNbankFinleaAllnum;
	}

	public String getM1CellNbankElseAllnum() {
		return m1CellNbankElseAllnum;
	}

	public String getM1CellNbankOrgnum() {
		return m1CellNbankOrgnum;
	}

	public String getM1CellNbankP2pOrgnum() {
		return m1CellNbankP2pOrgnum;
	}

	public String getM1CellNbankMcOrgnum() {
		return m1CellNbankMcOrgnum;
	}

	public String getM1CellNbankCaOrgnum() {
		return m1CellNbankCaOrgnum;
	}

	public String getM1CellNbankCfOrgnum() {
		return m1CellNbankCfOrgnum;
	}

	public String getM1CellNbankComOrgnum() {
		return m1CellNbankComOrgnum;
	}

	public String getM1CellNbankOthOrgnum() {
		return m1CellNbankOthOrgnum;
	}

	public String getM1CellNbankNsloanOrgnum() {
		return m1CellNbankNsloanOrgnum;
	}

	public String getM1CellNbankAutofinOrgnum() {
		return m1CellNbankAutofinOrgnum;
	}

	public String getM1CellNbankSloanOrgnum() {
		return m1CellNbankSloanOrgnum;
	}

	public String getM1CellNbankConsOrgnum() {
		return m1CellNbankConsOrgnum;
	}

	public String getM1CellNbankFinleaOrgnum() {
		return m1CellNbankFinleaOrgnum;
	}

	public String getM1CellNbankElseOrgnum() {
		return m1CellNbankElseOrgnum;
	}

	public String getM1CellNbankWeekAllnum() {
		return m1CellNbankWeekAllnum;
	}

	public String getM1CellNbankWeekOrgnum() {
		return m1CellNbankWeekOrgnum;
	}

	public String getM1CellNbankNightAllnum() {
		return m1CellNbankNightAllnum;
	}

	public String getM1CellNbankNightOrgnum() {
		return m1CellNbankNightOrgnum;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public void setCrtTime(Date crtTime) {
		this.crtTime = crtTime;
	}

	public void setCrtUser(String crtUser) {
		this.crtUser = crtUser;
	}

	public void setTrnId(String trnId) {
		this.trnId = trnId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public void setM1IdPdlAllnum(String m1IdPdlAllnum) {
		this.m1IdPdlAllnum = m1IdPdlAllnum;
	}

	public void setM1IdPdlOrgnum(String m1IdPdlOrgnum) {
		this.m1IdPdlOrgnum = m1IdPdlOrgnum;
	}

	public void setM1IdCaonAllnum(String m1IdCaonAllnum) {
		this.m1IdCaonAllnum = m1IdCaonAllnum;
	}

	public void setM1IdCaonOrgnum(String m1IdCaonOrgnum) {
		this.m1IdCaonOrgnum = m1IdCaonOrgnum;
	}

	public void setM1IdRelAllnum(String m1IdRelAllnum) {
		this.m1IdRelAllnum = m1IdRelAllnum;
	}

	public void setM1IdRelOrgnum(String m1IdRelOrgnum) {
		this.m1IdRelOrgnum = m1IdRelOrgnum;
	}

	public void setM1IdCaoffAllnum(String m1IdCaoffAllnum) {
		this.m1IdCaoffAllnum = m1IdCaoffAllnum;
	}

	public void setM1IdCaoffOrgnum(String m1IdCaoffOrgnum) {
		this.m1IdCaoffOrgnum = m1IdCaoffOrgnum;
	}

	public void setM1IdCooffAllnum(String m1IdCooffAllnum) {
		this.m1IdCooffAllnum = m1IdCooffAllnum;
	}

	public void setM1IdCooffOrgnum(String m1IdCooffOrgnum) {
		this.m1IdCooffOrgnum = m1IdCooffOrgnum;
	}

	public void setM1IdAfAllnum(String m1IdAfAllnum) {
		this.m1IdAfAllnum = m1IdAfAllnum;
	}

	public void setM1IdAfOrgnum(String m1IdAfOrgnum) {
		this.m1IdAfOrgnum = m1IdAfOrgnum;
	}

	public void setM1IdCoonAllnum(String m1IdCoonAllnum) {
		this.m1IdCoonAllnum = m1IdCoonAllnum;
	}

	public void setM1IdCoonOrgnum(String m1IdCoonOrgnum) {
		this.m1IdCoonOrgnum = m1IdCoonOrgnum;
	}

	public void setM1IdOthAllnum(String m1IdOthAllnum) {
		this.m1IdOthAllnum = m1IdOthAllnum;
	}

	public void setM1IdOthOrgnum(String m1IdOthOrgnum) {
		this.m1IdOthOrgnum = m1IdOthOrgnum;
	}

	public void setM1IdBankSelfnum(String m1IdBankSelfnum) {
		this.m1IdBankSelfnum = m1IdBankSelfnum;
	}

	public void setM1IdBankAllnum(String m1IdBankAllnum) {
		this.m1IdBankAllnum = m1IdBankAllnum;
	}

	public void setM1IdBankTraAllnum(String m1IdBankTraAllnum) {
		this.m1IdBankTraAllnum = m1IdBankTraAllnum;
	}

	public void setM1IdBankRetAllnum(String m1IdBankRetAllnum) {
		this.m1IdBankRetAllnum = m1IdBankRetAllnum;
	}

	public void setM1IdBankOrgnum(String m1IdBankOrgnum) {
		this.m1IdBankOrgnum = m1IdBankOrgnum;
	}

	public void setM1IdBankTraOrgnum(String m1IdBankTraOrgnum) {
		this.m1IdBankTraOrgnum = m1IdBankTraOrgnum;
	}

	public void setM1IdBankRetOrgnum(String m1IdBankRetOrgnum) {
		this.m1IdBankRetOrgnum = m1IdBankRetOrgnum;
	}

	public void setM1IdBankWeekAllnum(String m1IdBankWeekAllnum) {
		this.m1IdBankWeekAllnum = m1IdBankWeekAllnum;
	}

	public void setM1IdBankWeekOrgnum(String m1IdBankWeekOrgnum) {
		this.m1IdBankWeekOrgnum = m1IdBankWeekOrgnum;
	}

	public void setM1IdBankNightAllnum(String m1IdBankNightAllnum) {
		this.m1IdBankNightAllnum = m1IdBankNightAllnum;
	}

	public void setM1IdBankNightOrgnum(String m1IdBankNightOrgnum) {
		this.m1IdBankNightOrgnum = m1IdBankNightOrgnum;
	}

	public void setM1IdNbankSelfnum(String m1IdNbankSelfnum) {
		this.m1IdNbankSelfnum = m1IdNbankSelfnum;
	}

	public void setM1IdNbankAllnum(String m1IdNbankAllnum) {
		this.m1IdNbankAllnum = m1IdNbankAllnum;
	}

	public void setM1IdNbankP2pAllnum(String m1IdNbankP2pAllnum) {
		this.m1IdNbankP2pAllnum = m1IdNbankP2pAllnum;
	}

	public void setM1IdNbankMcAllnum(String m1IdNbankMcAllnum) {
		this.m1IdNbankMcAllnum = m1IdNbankMcAllnum;
	}

	public void setM1IdNbankCaAllnum(String m1IdNbankCaAllnum) {
		this.m1IdNbankCaAllnum = m1IdNbankCaAllnum;
	}

	public void setM1IdNbankCfAllnum(String m1IdNbankCfAllnum) {
		this.m1IdNbankCfAllnum = m1IdNbankCfAllnum;
	}

	public void setM1IdNbankComAllnum(String m1IdNbankComAllnum) {
		this.m1IdNbankComAllnum = m1IdNbankComAllnum;
	}

	public void setM1IdNbankOthAllnum(String m1IdNbankOthAllnum) {
		this.m1IdNbankOthAllnum = m1IdNbankOthAllnum;
	}

	public void setM1IdNbankNsloanAllnum(String m1IdNbankNsloanAllnum) {
		this.m1IdNbankNsloanAllnum = m1IdNbankNsloanAllnum;
	}

	public void setM1IdNbankAutofinAllnum(String m1IdNbankAutofinAllnum) {
		this.m1IdNbankAutofinAllnum = m1IdNbankAutofinAllnum;
	}

	public void setM1IdNbankSloanAllnum(String m1IdNbankSloanAllnum) {
		this.m1IdNbankSloanAllnum = m1IdNbankSloanAllnum;
	}

	public void setM1IdNbankConsAllnum(String m1IdNbankConsAllnum) {
		this.m1IdNbankConsAllnum = m1IdNbankConsAllnum;
	}

	public void setM1IdNbankFinleaAllnum(String m1IdNbankFinleaAllnum) {
		this.m1IdNbankFinleaAllnum = m1IdNbankFinleaAllnum;
	}

	public void setM1IdNbankElseAllnum(String m1IdNbankElseAllnum) {
		this.m1IdNbankElseAllnum = m1IdNbankElseAllnum;
	}

	public void setM1IdNbankOrgnum(String m1IdNbankOrgnum) {
		this.m1IdNbankOrgnum = m1IdNbankOrgnum;
	}

	public void setM1IdNbankP2pOrgnum(String m1IdNbankP2pOrgnum) {
		this.m1IdNbankP2pOrgnum = m1IdNbankP2pOrgnum;
	}

	public void setM1IdNbankMcOrgnum(String m1IdNbankMcOrgnum) {
		this.m1IdNbankMcOrgnum = m1IdNbankMcOrgnum;
	}

	public void setM1IdNbankCaOrgnum(String m1IdNbankCaOrgnum) {
		this.m1IdNbankCaOrgnum = m1IdNbankCaOrgnum;
	}

	public void setM1IdNbankCfOrgnum(String m1IdNbankCfOrgnum) {
		this.m1IdNbankCfOrgnum = m1IdNbankCfOrgnum;
	}

	public void setM1IdNbankComOrgnum(String m1IdNbankComOrgnum) {
		this.m1IdNbankComOrgnum = m1IdNbankComOrgnum;
	}

	public void setM1IdNbankOthOrgnum(String m1IdNbankOthOrgnum) {
		this.m1IdNbankOthOrgnum = m1IdNbankOthOrgnum;
	}

	public void setM1IdNbankNsloanOrgnum(String m1IdNbankNsloanOrgnum) {
		this.m1IdNbankNsloanOrgnum = m1IdNbankNsloanOrgnum;
	}

	public void setM1IdNbankAutofinOrgnum(String m1IdNbankAutofinOrgnum) {
		this.m1IdNbankAutofinOrgnum = m1IdNbankAutofinOrgnum;
	}

	public void setM1IdNbankSloanOrgnum(String m1IdNbankSloanOrgnum) {
		this.m1IdNbankSloanOrgnum = m1IdNbankSloanOrgnum;
	}

	public void setM1IdNbankConsOrgnum(String m1IdNbankConsOrgnum) {
		this.m1IdNbankConsOrgnum = m1IdNbankConsOrgnum;
	}

	public void setM1IdNbankFinleaOrgnum(String m1IdNbankFinleaOrgnum) {
		this.m1IdNbankFinleaOrgnum = m1IdNbankFinleaOrgnum;
	}

	public void setM1IdNbankElseOrgnum(String m1IdNbankElseOrgnum) {
		this.m1IdNbankElseOrgnum = m1IdNbankElseOrgnum;
	}

	public void setM1IdNbankWeekAllnum(String m1IdNbankWeekAllnum) {
		this.m1IdNbankWeekAllnum = m1IdNbankWeekAllnum;
	}

	public void setM1IdNbankWeekOrgnum(String m1IdNbankWeekOrgnum) {
		this.m1IdNbankWeekOrgnum = m1IdNbankWeekOrgnum;
	}

	public void setM1IdNbankNightAllnum(String m1IdNbankNightAllnum) {
		this.m1IdNbankNightAllnum = m1IdNbankNightAllnum;
	}

	public void setM1IdNbankNightOrgnum(String m1IdNbankNightOrgnum) {
		this.m1IdNbankNightOrgnum = m1IdNbankNightOrgnum;
	}

	public void setM1CellPdlAllnum(String m1CellPdlAllnum) {
		this.m1CellPdlAllnum = m1CellPdlAllnum;
	}

	public void setM1CellPdlOrgnum(String m1CellPdlOrgnum) {
		this.m1CellPdlOrgnum = m1CellPdlOrgnum;
	}

	public void setM1CellCaonAllnum(String m1CellCaonAllnum) {
		this.m1CellCaonAllnum = m1CellCaonAllnum;
	}

	public void setM1CellCaonOrgnum(String m1CellCaonOrgnum) {
		this.m1CellCaonOrgnum = m1CellCaonOrgnum;
	}

	public void setM1CellRelAllnum(String m1CellRelAllnum) {
		this.m1CellRelAllnum = m1CellRelAllnum;
	}

	public void setM1CellRelOrgnum(String m1CellRelOrgnum) {
		this.m1CellRelOrgnum = m1CellRelOrgnum;
	}

	public void setM1CellCaoffAllnum(String m1CellCaoffAllnum) {
		this.m1CellCaoffAllnum = m1CellCaoffAllnum;
	}

	public void setM1CellCaoffOrgnum(String m1CellCaoffOrgnum) {
		this.m1CellCaoffOrgnum = m1CellCaoffOrgnum;
	}

	public void setM1CellCooffAllnum(String m1CellCooffAllnum) {
		this.m1CellCooffAllnum = m1CellCooffAllnum;
	}

	public void setM1CellCooffOrgnum(String m1CellCooffOrgnum) {
		this.m1CellCooffOrgnum = m1CellCooffOrgnum;
	}

	public void setM1CellAfAllnum(String m1CellAfAllnum) {
		this.m1CellAfAllnum = m1CellAfAllnum;
	}

	public void setM1CellAfOrgnum(String m1CellAfOrgnum) {
		this.m1CellAfOrgnum = m1CellAfOrgnum;
	}

	public void setM1CellCoonAllnum(String m1CellCoonAllnum) {
		this.m1CellCoonAllnum = m1CellCoonAllnum;
	}

	public void setM1CellCoonOrgnum(String m1CellCoonOrgnum) {
		this.m1CellCoonOrgnum = m1CellCoonOrgnum;
	}

	public void setM1CellOthAllnum(String m1CellOthAllnum) {
		this.m1CellOthAllnum = m1CellOthAllnum;
	}

	public void setM1CellOthOrgnum(String m1CellOthOrgnum) {
		this.m1CellOthOrgnum = m1CellOthOrgnum;
	}

	public void setM1CellBankSelfnum(String m1CellBankSelfnum) {
		this.m1CellBankSelfnum = m1CellBankSelfnum;
	}

	public void setM1CellBankAllnum(String m1CellBankAllnum) {
		this.m1CellBankAllnum = m1CellBankAllnum;
	}

	public void setM1CellBankTraAllnum(String m1CellBankTraAllnum) {
		this.m1CellBankTraAllnum = m1CellBankTraAllnum;
	}

	public void setM1CellBankRetAllnum(String m1CellBankRetAllnum) {
		this.m1CellBankRetAllnum = m1CellBankRetAllnum;
	}

	public void setM1CellBankOrgnum(String m1CellBankOrgnum) {
		this.m1CellBankOrgnum = m1CellBankOrgnum;
	}

	public void setM1CellBankTraOrgnum(String m1CellBankTraOrgnum) {
		this.m1CellBankTraOrgnum = m1CellBankTraOrgnum;
	}

	public void setM1CellBankRetOrgnum(String m1CellBankRetOrgnum) {
		this.m1CellBankRetOrgnum = m1CellBankRetOrgnum;
	}

	public void setM1CellBankWeekAllnum(String m1CellBankWeekAllnum) {
		this.m1CellBankWeekAllnum = m1CellBankWeekAllnum;
	}

	public void setM1CellBankWeekOrgnum(String m1CellBankWeekOrgnum) {
		this.m1CellBankWeekOrgnum = m1CellBankWeekOrgnum;
	}

	public void setM1CellBankNightAllnum(String m1CellBankNightAllnum) {
		this.m1CellBankNightAllnum = m1CellBankNightAllnum;
	}

	public void setM1CellBankNightOrgnum(String m1CellBankNightOrgnum) {
		this.m1CellBankNightOrgnum = m1CellBankNightOrgnum;
	}

	public void setM1CellNbankSelfnum(String m1CellNbankSelfnum) {
		this.m1CellNbankSelfnum = m1CellNbankSelfnum;
	}

	public void setM1CellNbankAllnum(String m1CellNbankAllnum) {
		this.m1CellNbankAllnum = m1CellNbankAllnum;
	}

	public void setM1CellNbankP2pAllnum(String m1CellNbankP2pAllnum) {
		this.m1CellNbankP2pAllnum = m1CellNbankP2pAllnum;
	}

	public void setM1CellNbankMcAllnum(String m1CellNbankMcAllnum) {
		this.m1CellNbankMcAllnum = m1CellNbankMcAllnum;
	}

	public void setM1CellNbankCaAllnum(String m1CellNbankCaAllnum) {
		this.m1CellNbankCaAllnum = m1CellNbankCaAllnum;
	}

	public void setM1CellNbankCfAllnum(String m1CellNbankCfAllnum) {
		this.m1CellNbankCfAllnum = m1CellNbankCfAllnum;
	}

	public void setM1CellNbankComAllnum(String m1CellNbankComAllnum) {
		this.m1CellNbankComAllnum = m1CellNbankComAllnum;
	}

	public void setM1CellNbankOthAllnum(String m1CellNbankOthAllnum) {
		this.m1CellNbankOthAllnum = m1CellNbankOthAllnum;
	}

	public void setM1CellNbankNsloanAllnum(String m1CellNbankNsloanAllnum) {
		this.m1CellNbankNsloanAllnum = m1CellNbankNsloanAllnum;
	}

	public void setM1CellNbankAutofinAllnum(String m1CellNbankAutofinAllnum) {
		this.m1CellNbankAutofinAllnum = m1CellNbankAutofinAllnum;
	}

	public void setM1CellNbankSloanAllnum(String m1CellNbankSloanAllnum) {
		this.m1CellNbankSloanAllnum = m1CellNbankSloanAllnum;
	}

	public void setM1CellNbankConsAllnum(String m1CellNbankConsAllnum) {
		this.m1CellNbankConsAllnum = m1CellNbankConsAllnum;
	}

	public void setM1CellNbankFinleaAllnum(String m1CellNbankFinleaAllnum) {
		this.m1CellNbankFinleaAllnum = m1CellNbankFinleaAllnum;
	}

	public void setM1CellNbankElseAllnum(String m1CellNbankElseAllnum) {
		this.m1CellNbankElseAllnum = m1CellNbankElseAllnum;
	}

	public void setM1CellNbankOrgnum(String m1CellNbankOrgnum) {
		this.m1CellNbankOrgnum = m1CellNbankOrgnum;
	}

	public void setM1CellNbankP2pOrgnum(String m1CellNbankP2pOrgnum) {
		this.m1CellNbankP2pOrgnum = m1CellNbankP2pOrgnum;
	}

	public void setM1CellNbankMcOrgnum(String m1CellNbankMcOrgnum) {
		this.m1CellNbankMcOrgnum = m1CellNbankMcOrgnum;
	}

	public void setM1CellNbankCaOrgnum(String m1CellNbankCaOrgnum) {
		this.m1CellNbankCaOrgnum = m1CellNbankCaOrgnum;
	}

	public void setM1CellNbankCfOrgnum(String m1CellNbankCfOrgnum) {
		this.m1CellNbankCfOrgnum = m1CellNbankCfOrgnum;
	}

	public void setM1CellNbankComOrgnum(String m1CellNbankComOrgnum) {
		this.m1CellNbankComOrgnum = m1CellNbankComOrgnum;
	}

	public void setM1CellNbankOthOrgnum(String m1CellNbankOthOrgnum) {
		this.m1CellNbankOthOrgnum = m1CellNbankOthOrgnum;
	}

	public void setM1CellNbankNsloanOrgnum(String m1CellNbankNsloanOrgnum) {
		this.m1CellNbankNsloanOrgnum = m1CellNbankNsloanOrgnum;
	}

	public void setM1CellNbankAutofinOrgnum(String m1CellNbankAutofinOrgnum) {
		this.m1CellNbankAutofinOrgnum = m1CellNbankAutofinOrgnum;
	}

	public void setM1CellNbankSloanOrgnum(String m1CellNbankSloanOrgnum) {
		this.m1CellNbankSloanOrgnum = m1CellNbankSloanOrgnum;
	}

	public void setM1CellNbankConsOrgnum(String m1CellNbankConsOrgnum) {
		this.m1CellNbankConsOrgnum = m1CellNbankConsOrgnum;
	}

	public void setM1CellNbankFinleaOrgnum(String m1CellNbankFinleaOrgnum) {
		this.m1CellNbankFinleaOrgnum = m1CellNbankFinleaOrgnum;
	}

	public void setM1CellNbankElseOrgnum(String m1CellNbankElseOrgnum) {
		this.m1CellNbankElseOrgnum = m1CellNbankElseOrgnum;
	}

	public void setM1CellNbankWeekAllnum(String m1CellNbankWeekAllnum) {
		this.m1CellNbankWeekAllnum = m1CellNbankWeekAllnum;
	}

	public void setM1CellNbankWeekOrgnum(String m1CellNbankWeekOrgnum) {
		this.m1CellNbankWeekOrgnum = m1CellNbankWeekOrgnum;
	}

	public void setM1CellNbankNightAllnum(String m1CellNbankNightAllnum) {
		this.m1CellNbankNightAllnum = m1CellNbankNightAllnum;
	}

	public void setM1CellNbankNightOrgnum(String m1CellNbankNightOrgnum) {
		this.m1CellNbankNightOrgnum = m1CellNbankNightOrgnum;
	}

	public String getTrnKey() {
		return trnKey;
	}

	public void setTrnKey(String trnKey) {
		this.trnKey = trnKey;
	}

}
