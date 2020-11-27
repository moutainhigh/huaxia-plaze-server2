package com.huaxia.plaze.modules.bairong.domain;

import java.util.Date;

/**
 * 百融多头借贷15天内相关的数据
 * 
 * @author Liuwei
 *
 */
public class ApplyLoanStrDay15 {
	
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

	// 按身份证号查询，近15天申请线上小额现金贷的次数
	private String d15IdPdlAllnum;

	// 按身份证号查询，近15天申请线上小额现金贷的机构数
	private String d15IdPdlOrgnum;

	// 按身份证号查询，近15天申请线上现金分期的次数
	private String d15IdCaonAllnum;

	// 按身份证号查询，近15天申请线上现金分期的机构数
	private String d15IdCaonOrgnum;

	// 按身份证号查询，近15天申请信用卡（类信用卡）的次数
	private String d15IdRelAllnum;

	// 按身份证号查询，近15天申请信用卡（类信用卡）的机构数
	private String d15IdRelOrgnum;

	// 按身份证号查询，近15天申请线下现金分期的次数
	private String d15IdCaoffAllnum;

	// 按身份证号查询，近15天申请线下现金分期的机构数
	private String d15IdCaoffOrgnum;

	// 按身份证号查询，近15天申请线下消费分期的次数
	private String d15IdCooffAllnum;

	// 按身份证号查询，近15天申请线下消费分期的机构数
	private String d15IdCooffOrgnum;

	// 按身份证号查询，近15天申请汽车金融的次数
	private String d15IdAfAllnum;

	// 按身份证号查询，近15天申请汽车金融的机构数
	private String d15IdAfOrgnum;

	// 按身份证号查询，近15天申请线上消费分期的次数
	private String d15IdCoonAllnum;

	// 按身份证号查询，近15天申请线上消费分期的机构数
	private String d15IdCoonOrgnum;

	// 按身份证号查询，近15天申请其他的次数
	private String d15IdOthAllnum;

	// 按身份证号查询，近15天申请其他的机构数
	private String d15IdOthOrgnum;

	// 按身份证号查询，近15天在本机构(本机构为银行)的申请次数
	private String d15IdBankSelfnum;

	// 按身份证号查询，近15天在银行机构申请次数
	private String d15IdBankAllnum;

	// 按身份证号查询，近15天在银行机构-传统银行申请次数
	private String d15IdBankTraAllnum;

	// 按身份证号查询，近15天在银行机构-网络零售银行申请次数
	private String d15IdBankRetAllnum;

	// 按身份证号查询，近15天在银行机构申请机构数
	private String d15IdBankOrgnum;

	// 按身份证号查询，近15天在银行机构-传统银行申请机构数
	private String d15IdBankTraOrgnum;

	// 按身份证号查询，近15天在银行机构-网络零售银行申请机构数
	private String d15IdBankRetOrgnum;

	// 按身份证号查询，近15天在银行机构周末申请次数
	private String d15IdBankWeekAllnum;

	// 按身份证号查询，近15天在银行机构周末申请机构数
	private String d15IdBankWeekOrgnum;

	// 按身份证号查询，近15天在银行机构夜间申请次数
	private String d15IdBankNightAllnum;

	// 按身份证号查询，近15天在银行机构夜间申请机构数
	private String d15IdBankNightOrgnum;

	// 按身份证号查询，近15天在本机构(本机构为非银)申请次数
	private String d15IdNbankSelfnum;

	// 按身份证号查询，近15天在非银机构申请次数
	private String d15IdNbankAllnum;

	// 按身份证号查询，近15天在非银机构-p2p机构申请次数
	private String d15IdNbankP2pAllnum;

	// 按身份证号查询，近15天在非银机构-小贷机构申请次数
	private String d15IdNbankMcAllnum;

	// 按身份证号查询，近15天在非银机构-现金类分期机构申请次数
	private String d15IdNbankCaAllnum;

	// 按身份证号查询，近15天在非银机构-消费类分期机构申请次数
	private String d15IdNbankCfAllnum;

	// 按身份证号查询，近15天在非银机构-代偿类分期机构申请次数
	private String d15IdNbankComAllnum;

	// 按身份证号查询，近15天在非银机构-其他申请次数
	private String d15IdNbankOthAllnum;

	// 按身份证号查询，近15天在非银机构-持牌网络小贷机构申请次数
	private String d15IdNbankNsloanAllnum;

	// 按身份证号查询，近15天在非银机构-持牌汽车金融机构申请次数
	private String d15IdNbankAutofinAllnum;

	// 按身份证号查询，近15天在非银机构-持牌小贷机构申请次数
	private String d15IdNbankSloanAllnum;

	// 按身份证号查询，近15天在非银机构-持牌消费金融机构申请次数
	private String d15IdNbankConsAllnum;

	// 按身份证号查询，近15天在非银机构-持牌融资租赁机构申请次数
	private String d15IdNbankFinleaAllnum;

	// 按身份证号查询，近15天在非银机构-其他申请次数
	private String d15IdNbankElseAllnum;

	// 按身份证号查询，近15天在非银机构申请机构数
	private String d15IdNbankOrgnum;

	// 按身份证号查询，近15天在非银机构-p2p申请机构数
	private String d15IdNbankP2pOrgnum;

	// 按身份证号查询，近15天在非银机构-小贷申请机构数
	private String d15IdNbankMcOrgnum;

	// 按身份证号查询，近15天在非银机构-现金类分期申请机构数
	private String d15IdNbankCaOrgnum;

	// 按身份证号查询，近15天在非银机构-消费类分期申请机构数
	private String d15IdNbankCfOrgnum;

	// 按身份证号查询，近15天在非银机构-代偿类分期申请机构数
	private String d15IdNbankComOrgnum;

	// 按身份证号查询，近15天在非银机构-其他申请机构数
	private String d15IdNbankOthOrgnum;

	// 按身份证号查询，近15天在非银机构-持牌网络小贷机构申请机构数
	private String d15IdNbankNsloanOrgnum;

	// 按身份证号查询，近15天在非银机构-持牌汽车金融机构申请机构数
	private String d15IdNbankAutofinOrgnum;

	// 按身份证号查询，近15天在非银机构-持牌小贷机构申请机构数
	private String d15IdNbankSloanOrgnum;

	// 按身份证号查询，近15天在非银机构-持牌消费金融机构申请机构数
	private String d15IdNbankConsOrgnum;

	// 按身份证号查询，近15天在非银机构-持牌融资租赁机构申请机构数
	private String d15IdNbankFinleaOrgnum;

	// 按身份证号查询，近15天在非银机构-其他申请机构数
	private String d15IdNbankElseOrgnum;

	// 按身份证号查询，近15天在非银机构周末申请次数
	private String d15IdNbankWeekAllnum;

	// 按身份证号查询，近15天在非银机构周末申请机构数
	private String d15IdNbankWeekOrgnum;

	// 按身份证号查询，近15天在非银机构夜间申请次数
	private String d15IdNbankNightAllnum;

	// 按身份证号查询，近15天在非银机构夜间申请机构数
	private String d15IdNbankNightOrgnum;

	// 按手机号查询，近15天申请线上小额现金贷的次数
	private String d15CellPdlAllnum;

	// 按手机号查询，近15天申请线上小额现金贷的机构数
	private String d15CellPdlOrgnum;

	// 按手机号查询，近15天申请线上现金分期的次数
	private String d15CellCaonAllnum;

	// 按手机号查询，近15天申请线上现金分期的机构数
	private String d15CellCaonOrgnum;

	// 按手机号查询，近15天申请信用卡（类信用卡）的次数
	private String d15CellRelAllnum;

	// 按手机号查询，近15天申请信用卡（类信用卡）的机构数
	private String d15CellRelOrgnum;

	// 按手机号查询，近15天申请线下现金分期的次数
	private String d15CellCaoffAllnum;

	// 按手机号查询，近15天申请线下现金分期的机构数
	private String d15CellCaoffOrgnum;

	// 按手机号查询，近15天申请线下消费分期的次数
	private String d15CellCooffAllnum;

	// 按手机号查询，近15天申请线下消费分期的机构数
	private String d15CellCooffOrgnum;

	// 按手机号查询，近15天申请汽车金融的次数
	private String d15CellAfAllnum;

	// 按手机号查询，近15天申请汽车金融的机构数
	private String d15CellAfOrgnum;

	// 按手机号查询，近15天申请线上消费分期的次数
	private String d15CellCoonAllnum;

	// 按手机号查询，近15天申请线上消费分期的机构数
	private String d15CellCoonOrgnum;

	// 按手机号查询，近15天申请其他的次数
	private String d15CellOthAllnum;

	// 按手机号查询，近15天申请其他的机构数
	private String d15CellOthOrgnum;

	// 按手机号查询，近15天在本机构(本机构为银行)的申请次数
	private String d15CellBankSelfnum;

	// 按手机号查询，近15天在银行机构申请次数
	private String d15CellBankAllnum;

	// 按手机号查询，近15天在银行机构-传统银行申请次数
	private String d15CellBankTraAllnum;

	// 按手机号查询，近15天在银行机构-网络零售银行申请次数
	private String d15CellBankRetAllnum;

	// 按手机号查询，近15天在银行机构申请机构数
	private String d15CellBankOrgnum;

	// 按手机号查询，近15天在银行机构-传统银行申请机构数
	private String d15CellBankTraOrgnum;

	// 按手机号查询，近15天在银行机构-网络零售银行申请机构数
	private String d15CellBankRetOrgnum;

	// 按手机号查询，近15天在银行机构周末申请次数
	private String d15CellBankWeekAllnum;

	// 按手机号查询，近15天在银行机构周末申请机构数
	private String d15CellBankWeekOrgnum;

	// 按手机号查询，近15天在银行机构夜间申请次数
	private String d15CellBankNightAllnum;

	// 按手机号查询，近15天在银行机构夜间申请机构数
	private String d15CellBankNightOrgnum;

	// 按手机号查询，近15天在本机构(本机构为非银)申请次数
	private String d15CellNbankSelfnum;

	// 按手机号查询，近15天在非银机构申请次数
	private String d15CellNbankAllnum;

	// 按手机号查询，近15天在非银机构-p2p机构申请次数
	private String d15CellNbankP2pAllnum;

	// 按手机号查询，近15天在非银机构-小贷机构申请次数
	private String d15CellNbankMcAllnum;

	// 按手机号查询，近15天在非银机构-现金类分期机构申请次数
	private String d15CellNbankCaAllnum;

	// 按手机号查询，近15天在非银机构-消费类分期机构申请次数
	private String d15CellNbankCfAllnum;

	// 按手机号查询，近15天在非银机构-代偿类分期机构申请次数
	private String d15CellNbankComAllnum;

	// 按手机号查询，近15天在非银机构-其他申请次数
	private String d15CellNbankOthAllnum;

	// 按手机号查询，近15天在非银机构-持牌网络小贷机构申请次数
	private String d15CellNbankNsloanAllnum;

	// 按手机号查询，近15天在非银机构-持牌汽车金融机构申请次数
	private String d15CellNbankAutofinAllnum;

	// 按手机号查询，近15天在非银机构-持牌小贷机构申请次数
	private String d15CellNbankSloanAllnum;

	// 按手机号查询，近15天在非银机构-持牌消费金融机构申请次数
	private String d15CellNbankConsAllnum;

	// 按手机号查询，近15天在非银机构-持牌融资租赁机构申请次数
	private String d15CellNbankFinleaAllnum;

	// 按手机号查询，近15天在非银机构-其他申请次数
	private String d15CellNbankElseAllnum;

	// 按手机号查询，近15天在非银机构申请机构数
	private String d15CellNbankOrgnum;

	// 按手机号查询，近15天在非银机构-p2p申请机构数
	private String d15CellNbankP2pOrgnum;

	// 按手机号查询，近15天在非银机构-小贷申请机构数
	private String d15CellNbankMcOrgnum;

	// 按手机号查询，近15天在非银机构-现金类分期申请机构数
	private String d15CellNbankCaOrgnum;

	// 按手机号查询，近15天在非银机构-消费类分期申请机构数
	private String d15CellNbankCfOrgnum;

	// 按手机号查询，近15天在非银机构-代偿类分期申请机构数
	private String d15CellNbankComOrgnum;

	// 按手机号查询，近15天在非银机构-其他申请机构数
	private String d15CellNbankOthOrgnum;

	// 按手机号查询，近15天在非银机构-持牌网络小贷机构申请机构数
	private String d15CellNbankNsloanOrgnum;

	// 按手机号查询，近15天在非银机构-持牌汽车金融机构申请机构数
	private String d15CellNbankAutofinOrgnum;

	// 按手机号查询，近15天在非银机构-持牌小贷机构申请机构数
	private String d15CellNbankSloanOrgnum;

	// 按手机号查询，近15天在非银机构-持牌消费金融机构申请机构数
	private String d15CellNbankConsOrgnum;

	// 按手机号查询，近15天在非银机构-持牌融资租赁机构申请机构数
	private String d15CellNbankFinleaOrgnum;

	// 按手机号查询，近15天在非银机构-其他申请机构数
	private String d15CellNbankElseOrgnum;

	// 按手机号查询，近15天在非银机构周末申请次数
	private String d15CellNbankWeekAllnum;

	// 按手机号查询，近15天在非银机构周末申请机构数
	private String d15CellNbankWeekOrgnum;

	// 按手机号查询，近15天在非银机构夜间申请次数
	private String d15CellNbankNightAllnum;

	// 按手机号查询，近15天在非银机构夜间申请机构数
	private String d15CellNbankNightOrgnum;

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

	public String getD15IdPdlAllnum() {
		return d15IdPdlAllnum;
	}

	public String getD15IdPdlOrgnum() {
		return d15IdPdlOrgnum;
	}

	public String getD15IdCaonAllnum() {
		return d15IdCaonAllnum;
	}

	public String getD15IdCaonOrgnum() {
		return d15IdCaonOrgnum;
	}

	public String getD15IdRelAllnum() {
		return d15IdRelAllnum;
	}

	public String getD15IdRelOrgnum() {
		return d15IdRelOrgnum;
	}

	public String getD15IdCaoffAllnum() {
		return d15IdCaoffAllnum;
	}

	public String getD15IdCaoffOrgnum() {
		return d15IdCaoffOrgnum;
	}

	public String getD15IdCooffAllnum() {
		return d15IdCooffAllnum;
	}

	public String getD15IdCooffOrgnum() {
		return d15IdCooffOrgnum;
	}

	public String getD15IdAfAllnum() {
		return d15IdAfAllnum;
	}

	public String getD15IdAfOrgnum() {
		return d15IdAfOrgnum;
	}

	public String getD15IdCoonAllnum() {
		return d15IdCoonAllnum;
	}

	public String getD15IdCoonOrgnum() {
		return d15IdCoonOrgnum;
	}

	public String getD15IdOthAllnum() {
		return d15IdOthAllnum;
	}

	public String getD15IdOthOrgnum() {
		return d15IdOthOrgnum;
	}

	public String getD15IdBankSelfnum() {
		return d15IdBankSelfnum;
	}

	public String getD15IdBankAllnum() {
		return d15IdBankAllnum;
	}

	public String getD15IdBankTraAllnum() {
		return d15IdBankTraAllnum;
	}

	public String getD15IdBankRetAllnum() {
		return d15IdBankRetAllnum;
	}

	public String getD15IdBankOrgnum() {
		return d15IdBankOrgnum;
	}

	public String getD15IdBankTraOrgnum() {
		return d15IdBankTraOrgnum;
	}

	public String getD15IdBankRetOrgnum() {
		return d15IdBankRetOrgnum;
	}

	public String getD15IdBankWeekAllnum() {
		return d15IdBankWeekAllnum;
	}

	public String getD15IdBankWeekOrgnum() {
		return d15IdBankWeekOrgnum;
	}

	public String getD15IdBankNightAllnum() {
		return d15IdBankNightAllnum;
	}

	public String getD15IdBankNightOrgnum() {
		return d15IdBankNightOrgnum;
	}

	public String getD15IdNbankSelfnum() {
		return d15IdNbankSelfnum;
	}

	public String getD15IdNbankAllnum() {
		return d15IdNbankAllnum;
	}

	public String getD15IdNbankP2pAllnum() {
		return d15IdNbankP2pAllnum;
	}

	public String getD15IdNbankMcAllnum() {
		return d15IdNbankMcAllnum;
	}

	public String getD15IdNbankCaAllnum() {
		return d15IdNbankCaAllnum;
	}

	public String getD15IdNbankCfAllnum() {
		return d15IdNbankCfAllnum;
	}

	public String getD15IdNbankComAllnum() {
		return d15IdNbankComAllnum;
	}

	public String getD15IdNbankOthAllnum() {
		return d15IdNbankOthAllnum;
	}

	public String getD15IdNbankNsloanAllnum() {
		return d15IdNbankNsloanAllnum;
	}

	public String getD15IdNbankAutofinAllnum() {
		return d15IdNbankAutofinAllnum;
	}

	public String getD15IdNbankSloanAllnum() {
		return d15IdNbankSloanAllnum;
	}

	public String getD15IdNbankConsAllnum() {
		return d15IdNbankConsAllnum;
	}

	public String getD15IdNbankFinleaAllnum() {
		return d15IdNbankFinleaAllnum;
	}

	public String getD15IdNbankElseAllnum() {
		return d15IdNbankElseAllnum;
	}

	public String getD15IdNbankOrgnum() {
		return d15IdNbankOrgnum;
	}

	public String getD15IdNbankP2pOrgnum() {
		return d15IdNbankP2pOrgnum;
	}

	public String getD15IdNbankMcOrgnum() {
		return d15IdNbankMcOrgnum;
	}

	public String getD15IdNbankCaOrgnum() {
		return d15IdNbankCaOrgnum;
	}

	public String getD15IdNbankCfOrgnum() {
		return d15IdNbankCfOrgnum;
	}

	public String getD15IdNbankComOrgnum() {
		return d15IdNbankComOrgnum;
	}

	public String getD15IdNbankOthOrgnum() {
		return d15IdNbankOthOrgnum;
	}

	public String getD15IdNbankNsloanOrgnum() {
		return d15IdNbankNsloanOrgnum;
	}

	public String getD15IdNbankAutofinOrgnum() {
		return d15IdNbankAutofinOrgnum;
	}

	public String getD15IdNbankSloanOrgnum() {
		return d15IdNbankSloanOrgnum;
	}

	public String getD15IdNbankConsOrgnum() {
		return d15IdNbankConsOrgnum;
	}

	public String getD15IdNbankFinleaOrgnum() {
		return d15IdNbankFinleaOrgnum;
	}

	public String getD15IdNbankElseOrgnum() {
		return d15IdNbankElseOrgnum;
	}

	public String getD15IdNbankWeekAllnum() {
		return d15IdNbankWeekAllnum;
	}

	public String getD15IdNbankWeekOrgnum() {
		return d15IdNbankWeekOrgnum;
	}

	public String getD15IdNbankNightAllnum() {
		return d15IdNbankNightAllnum;
	}

	public String getD15IdNbankNightOrgnum() {
		return d15IdNbankNightOrgnum;
	}

	public String getD15CellPdlAllnum() {
		return d15CellPdlAllnum;
	}

	public String getD15CellPdlOrgnum() {
		return d15CellPdlOrgnum;
	}

	public String getD15CellCaonAllnum() {
		return d15CellCaonAllnum;
	}

	public String getD15CellCaonOrgnum() {
		return d15CellCaonOrgnum;
	}

	public String getD15CellRelAllnum() {
		return d15CellRelAllnum;
	}

	public String getD15CellRelOrgnum() {
		return d15CellRelOrgnum;
	}

	public String getD15CellCaoffAllnum() {
		return d15CellCaoffAllnum;
	}

	public String getD15CellCaoffOrgnum() {
		return d15CellCaoffOrgnum;
	}

	public String getD15CellCooffAllnum() {
		return d15CellCooffAllnum;
	}

	public String getD15CellCooffOrgnum() {
		return d15CellCooffOrgnum;
	}

	public String getD15CellAfAllnum() {
		return d15CellAfAllnum;
	}

	public String getD15CellAfOrgnum() {
		return d15CellAfOrgnum;
	}

	public String getD15CellCoonAllnum() {
		return d15CellCoonAllnum;
	}

	public String getD15CellCoonOrgnum() {
		return d15CellCoonOrgnum;
	}

	public String getD15CellOthAllnum() {
		return d15CellOthAllnum;
	}

	public String getD15CellOthOrgnum() {
		return d15CellOthOrgnum;
	}

	public String getD15CellBankSelfnum() {
		return d15CellBankSelfnum;
	}

	public String getD15CellBankAllnum() {
		return d15CellBankAllnum;
	}

	public String getD15CellBankTraAllnum() {
		return d15CellBankTraAllnum;
	}

	public String getD15CellBankRetAllnum() {
		return d15CellBankRetAllnum;
	}

	public String getD15CellBankOrgnum() {
		return d15CellBankOrgnum;
	}

	public String getD15CellBankTraOrgnum() {
		return d15CellBankTraOrgnum;
	}

	public String getD15CellBankRetOrgnum() {
		return d15CellBankRetOrgnum;
	}

	public String getD15CellBankWeekAllnum() {
		return d15CellBankWeekAllnum;
	}

	public String getD15CellBankWeekOrgnum() {
		return d15CellBankWeekOrgnum;
	}

	public String getD15CellBankNightAllnum() {
		return d15CellBankNightAllnum;
	}

	public String getD15CellBankNightOrgnum() {
		return d15CellBankNightOrgnum;
	}

	public String getD15CellNbankSelfnum() {
		return d15CellNbankSelfnum;
	}

	public String getD15CellNbankAllnum() {
		return d15CellNbankAllnum;
	}

	public String getD15CellNbankP2pAllnum() {
		return d15CellNbankP2pAllnum;
	}

	public String getD15CellNbankMcAllnum() {
		return d15CellNbankMcAllnum;
	}

	public String getD15CellNbankCaAllnum() {
		return d15CellNbankCaAllnum;
	}

	public String getD15CellNbankCfAllnum() {
		return d15CellNbankCfAllnum;
	}

	public String getD15CellNbankComAllnum() {
		return d15CellNbankComAllnum;
	}

	public String getD15CellNbankOthAllnum() {
		return d15CellNbankOthAllnum;
	}

	public String getD15CellNbankNsloanAllnum() {
		return d15CellNbankNsloanAllnum;
	}

	public String getD15CellNbankAutofinAllnum() {
		return d15CellNbankAutofinAllnum;
	}

	public String getD15CellNbankSloanAllnum() {
		return d15CellNbankSloanAllnum;
	}

	public String getD15CellNbankConsAllnum() {
		return d15CellNbankConsAllnum;
	}

	public String getD15CellNbankFinleaAllnum() {
		return d15CellNbankFinleaAllnum;
	}

	public String getD15CellNbankElseAllnum() {
		return d15CellNbankElseAllnum;
	}

	public String getD15CellNbankOrgnum() {
		return d15CellNbankOrgnum;
	}

	public String getD15CellNbankP2pOrgnum() {
		return d15CellNbankP2pOrgnum;
	}

	public String getD15CellNbankMcOrgnum() {
		return d15CellNbankMcOrgnum;
	}

	public String getD15CellNbankCaOrgnum() {
		return d15CellNbankCaOrgnum;
	}

	public String getD15CellNbankCfOrgnum() {
		return d15CellNbankCfOrgnum;
	}

	public String getD15CellNbankComOrgnum() {
		return d15CellNbankComOrgnum;
	}

	public String getD15CellNbankOthOrgnum() {
		return d15CellNbankOthOrgnum;
	}

	public String getD15CellNbankNsloanOrgnum() {
		return d15CellNbankNsloanOrgnum;
	}

	public String getD15CellNbankAutofinOrgnum() {
		return d15CellNbankAutofinOrgnum;
	}

	public String getD15CellNbankSloanOrgnum() {
		return d15CellNbankSloanOrgnum;
	}

	public String getD15CellNbankConsOrgnum() {
		return d15CellNbankConsOrgnum;
	}

	public String getD15CellNbankFinleaOrgnum() {
		return d15CellNbankFinleaOrgnum;
	}

	public String getD15CellNbankElseOrgnum() {
		return d15CellNbankElseOrgnum;
	}

	public String getD15CellNbankWeekAllnum() {
		return d15CellNbankWeekAllnum;
	}

	public String getD15CellNbankWeekOrgnum() {
		return d15CellNbankWeekOrgnum;
	}

	public String getD15CellNbankNightAllnum() {
		return d15CellNbankNightAllnum;
	}

	public String getD15CellNbankNightOrgnum() {
		return d15CellNbankNightOrgnum;
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

	public void setD15IdPdlAllnum(String d15IdPdlAllnum) {
		this.d15IdPdlAllnum = d15IdPdlAllnum;
	}

	public void setD15IdPdlOrgnum(String d15IdPdlOrgnum) {
		this.d15IdPdlOrgnum = d15IdPdlOrgnum;
	}

	public void setD15IdCaonAllnum(String d15IdCaonAllnum) {
		this.d15IdCaonAllnum = d15IdCaonAllnum;
	}

	public void setD15IdCaonOrgnum(String d15IdCaonOrgnum) {
		this.d15IdCaonOrgnum = d15IdCaonOrgnum;
	}

	public void setD15IdRelAllnum(String d15IdRelAllnum) {
		this.d15IdRelAllnum = d15IdRelAllnum;
	}

	public void setD15IdRelOrgnum(String d15IdRelOrgnum) {
		this.d15IdRelOrgnum = d15IdRelOrgnum;
	}

	public void setD15IdCaoffAllnum(String d15IdCaoffAllnum) {
		this.d15IdCaoffAllnum = d15IdCaoffAllnum;
	}

	public void setD15IdCaoffOrgnum(String d15IdCaoffOrgnum) {
		this.d15IdCaoffOrgnum = d15IdCaoffOrgnum;
	}

	public void setD15IdCooffAllnum(String d15IdCooffAllnum) {
		this.d15IdCooffAllnum = d15IdCooffAllnum;
	}

	public void setD15IdCooffOrgnum(String d15IdCooffOrgnum) {
		this.d15IdCooffOrgnum = d15IdCooffOrgnum;
	}

	public void setD15IdAfAllnum(String d15IdAfAllnum) {
		this.d15IdAfAllnum = d15IdAfAllnum;
	}

	public void setD15IdAfOrgnum(String d15IdAfOrgnum) {
		this.d15IdAfOrgnum = d15IdAfOrgnum;
	}

	public void setD15IdCoonAllnum(String d15IdCoonAllnum) {
		this.d15IdCoonAllnum = d15IdCoonAllnum;
	}

	public void setD15IdCoonOrgnum(String d15IdCoonOrgnum) {
		this.d15IdCoonOrgnum = d15IdCoonOrgnum;
	}

	public void setD15IdOthAllnum(String d15IdOthAllnum) {
		this.d15IdOthAllnum = d15IdOthAllnum;
	}

	public void setD15IdOthOrgnum(String d15IdOthOrgnum) {
		this.d15IdOthOrgnum = d15IdOthOrgnum;
	}

	public void setD15IdBankSelfnum(String d15IdBankSelfnum) {
		this.d15IdBankSelfnum = d15IdBankSelfnum;
	}

	public void setD15IdBankAllnum(String d15IdBankAllnum) {
		this.d15IdBankAllnum = d15IdBankAllnum;
	}

	public void setD15IdBankTraAllnum(String d15IdBankTraAllnum) {
		this.d15IdBankTraAllnum = d15IdBankTraAllnum;
	}

	public void setD15IdBankRetAllnum(String d15IdBankRetAllnum) {
		this.d15IdBankRetAllnum = d15IdBankRetAllnum;
	}

	public void setD15IdBankOrgnum(String d15IdBankOrgnum) {
		this.d15IdBankOrgnum = d15IdBankOrgnum;
	}

	public void setD15IdBankTraOrgnum(String d15IdBankTraOrgnum) {
		this.d15IdBankTraOrgnum = d15IdBankTraOrgnum;
	}

	public void setD15IdBankRetOrgnum(String d15IdBankRetOrgnum) {
		this.d15IdBankRetOrgnum = d15IdBankRetOrgnum;
	}

	public void setD15IdBankWeekAllnum(String d15IdBankWeekAllnum) {
		this.d15IdBankWeekAllnum = d15IdBankWeekAllnum;
	}

	public void setD15IdBankWeekOrgnum(String d15IdBankWeekOrgnum) {
		this.d15IdBankWeekOrgnum = d15IdBankWeekOrgnum;
	}

	public void setD15IdBankNightAllnum(String d15IdBankNightAllnum) {
		this.d15IdBankNightAllnum = d15IdBankNightAllnum;
	}

	public void setD15IdBankNightOrgnum(String d15IdBankNightOrgnum) {
		this.d15IdBankNightOrgnum = d15IdBankNightOrgnum;
	}

	public void setD15IdNbankSelfnum(String d15IdNbankSelfnum) {
		this.d15IdNbankSelfnum = d15IdNbankSelfnum;
	}

	public void setD15IdNbankAllnum(String d15IdNbankAllnum) {
		this.d15IdNbankAllnum = d15IdNbankAllnum;
	}

	public void setD15IdNbankP2pAllnum(String d15IdNbankP2pAllnum) {
		this.d15IdNbankP2pAllnum = d15IdNbankP2pAllnum;
	}

	public void setD15IdNbankMcAllnum(String d15IdNbankMcAllnum) {
		this.d15IdNbankMcAllnum = d15IdNbankMcAllnum;
	}

	public void setD15IdNbankCaAllnum(String d15IdNbankCaAllnum) {
		this.d15IdNbankCaAllnum = d15IdNbankCaAllnum;
	}

	public void setD15IdNbankCfAllnum(String d15IdNbankCfAllnum) {
		this.d15IdNbankCfAllnum = d15IdNbankCfAllnum;
	}

	public void setD15IdNbankComAllnum(String d15IdNbankComAllnum) {
		this.d15IdNbankComAllnum = d15IdNbankComAllnum;
	}

	public void setD15IdNbankOthAllnum(String d15IdNbankOthAllnum) {
		this.d15IdNbankOthAllnum = d15IdNbankOthAllnum;
	}

	public void setD15IdNbankNsloanAllnum(String d15IdNbankNsloanAllnum) {
		this.d15IdNbankNsloanAllnum = d15IdNbankNsloanAllnum;
	}

	public void setD15IdNbankAutofinAllnum(String d15IdNbankAutofinAllnum) {
		this.d15IdNbankAutofinAllnum = d15IdNbankAutofinAllnum;
	}

	public void setD15IdNbankSloanAllnum(String d15IdNbankSloanAllnum) {
		this.d15IdNbankSloanAllnum = d15IdNbankSloanAllnum;
	}

	public void setD15IdNbankConsAllnum(String d15IdNbankConsAllnum) {
		this.d15IdNbankConsAllnum = d15IdNbankConsAllnum;
	}

	public void setD15IdNbankFinleaAllnum(String d15IdNbankFinleaAllnum) {
		this.d15IdNbankFinleaAllnum = d15IdNbankFinleaAllnum;
	}

	public void setD15IdNbankElseAllnum(String d15IdNbankElseAllnum) {
		this.d15IdNbankElseAllnum = d15IdNbankElseAllnum;
	}

	public void setD15IdNbankOrgnum(String d15IdNbankOrgnum) {
		this.d15IdNbankOrgnum = d15IdNbankOrgnum;
	}

	public void setD15IdNbankP2pOrgnum(String d15IdNbankP2pOrgnum) {
		this.d15IdNbankP2pOrgnum = d15IdNbankP2pOrgnum;
	}

	public void setD15IdNbankMcOrgnum(String d15IdNbankMcOrgnum) {
		this.d15IdNbankMcOrgnum = d15IdNbankMcOrgnum;
	}

	public void setD15IdNbankCaOrgnum(String d15IdNbankCaOrgnum) {
		this.d15IdNbankCaOrgnum = d15IdNbankCaOrgnum;
	}

	public void setD15IdNbankCfOrgnum(String d15IdNbankCfOrgnum) {
		this.d15IdNbankCfOrgnum = d15IdNbankCfOrgnum;
	}

	public void setD15IdNbankComOrgnum(String d15IdNbankComOrgnum) {
		this.d15IdNbankComOrgnum = d15IdNbankComOrgnum;
	}

	public void setD15IdNbankOthOrgnum(String d15IdNbankOthOrgnum) {
		this.d15IdNbankOthOrgnum = d15IdNbankOthOrgnum;
	}

	public void setD15IdNbankNsloanOrgnum(String d15IdNbankNsloanOrgnum) {
		this.d15IdNbankNsloanOrgnum = d15IdNbankNsloanOrgnum;
	}

	public void setD15IdNbankAutofinOrgnum(String d15IdNbankAutofinOrgnum) {
		this.d15IdNbankAutofinOrgnum = d15IdNbankAutofinOrgnum;
	}

	public void setD15IdNbankSloanOrgnum(String d15IdNbankSloanOrgnum) {
		this.d15IdNbankSloanOrgnum = d15IdNbankSloanOrgnum;
	}

	public void setD15IdNbankConsOrgnum(String d15IdNbankConsOrgnum) {
		this.d15IdNbankConsOrgnum = d15IdNbankConsOrgnum;
	}

	public void setD15IdNbankFinleaOrgnum(String d15IdNbankFinleaOrgnum) {
		this.d15IdNbankFinleaOrgnum = d15IdNbankFinleaOrgnum;
	}

	public void setD15IdNbankElseOrgnum(String d15IdNbankElseOrgnum) {
		this.d15IdNbankElseOrgnum = d15IdNbankElseOrgnum;
	}

	public void setD15IdNbankWeekAllnum(String d15IdNbankWeekAllnum) {
		this.d15IdNbankWeekAllnum = d15IdNbankWeekAllnum;
	}

	public void setD15IdNbankWeekOrgnum(String d15IdNbankWeekOrgnum) {
		this.d15IdNbankWeekOrgnum = d15IdNbankWeekOrgnum;
	}

	public void setD15IdNbankNightAllnum(String d15IdNbankNightAllnum) {
		this.d15IdNbankNightAllnum = d15IdNbankNightAllnum;
	}

	public void setD15IdNbankNightOrgnum(String d15IdNbankNightOrgnum) {
		this.d15IdNbankNightOrgnum = d15IdNbankNightOrgnum;
	}

	public void setD15CellPdlAllnum(String d15CellPdlAllnum) {
		this.d15CellPdlAllnum = d15CellPdlAllnum;
	}

	public void setD15CellPdlOrgnum(String d15CellPdlOrgnum) {
		this.d15CellPdlOrgnum = d15CellPdlOrgnum;
	}

	public void setD15CellCaonAllnum(String d15CellCaonAllnum) {
		this.d15CellCaonAllnum = d15CellCaonAllnum;
	}

	public void setD15CellCaonOrgnum(String d15CellCaonOrgnum) {
		this.d15CellCaonOrgnum = d15CellCaonOrgnum;
	}

	public void setD15CellRelAllnum(String d15CellRelAllnum) {
		this.d15CellRelAllnum = d15CellRelAllnum;
	}

	public void setD15CellRelOrgnum(String d15CellRelOrgnum) {
		this.d15CellRelOrgnum = d15CellRelOrgnum;
	}

	public void setD15CellCaoffAllnum(String d15CellCaoffAllnum) {
		this.d15CellCaoffAllnum = d15CellCaoffAllnum;
	}

	public void setD15CellCaoffOrgnum(String d15CellCaoffOrgnum) {
		this.d15CellCaoffOrgnum = d15CellCaoffOrgnum;
	}

	public void setD15CellCooffAllnum(String d15CellCooffAllnum) {
		this.d15CellCooffAllnum = d15CellCooffAllnum;
	}

	public void setD15CellCooffOrgnum(String d15CellCooffOrgnum) {
		this.d15CellCooffOrgnum = d15CellCooffOrgnum;
	}

	public void setD15CellAfAllnum(String d15CellAfAllnum) {
		this.d15CellAfAllnum = d15CellAfAllnum;
	}

	public void setD15CellAfOrgnum(String d15CellAfOrgnum) {
		this.d15CellAfOrgnum = d15CellAfOrgnum;
	}

	public void setD15CellCoonAllnum(String d15CellCoonAllnum) {
		this.d15CellCoonAllnum = d15CellCoonAllnum;
	}

	public void setD15CellCoonOrgnum(String d15CellCoonOrgnum) {
		this.d15CellCoonOrgnum = d15CellCoonOrgnum;
	}

	public void setD15CellOthAllnum(String d15CellOthAllnum) {
		this.d15CellOthAllnum = d15CellOthAllnum;
	}

	public void setD15CellOthOrgnum(String d15CellOthOrgnum) {
		this.d15CellOthOrgnum = d15CellOthOrgnum;
	}

	public void setD15CellBankSelfnum(String d15CellBankSelfnum) {
		this.d15CellBankSelfnum = d15CellBankSelfnum;
	}

	public void setD15CellBankAllnum(String d15CellBankAllnum) {
		this.d15CellBankAllnum = d15CellBankAllnum;
	}

	public void setD15CellBankTraAllnum(String d15CellBankTraAllnum) {
		this.d15CellBankTraAllnum = d15CellBankTraAllnum;
	}

	public void setD15CellBankRetAllnum(String d15CellBankRetAllnum) {
		this.d15CellBankRetAllnum = d15CellBankRetAllnum;
	}

	public void setD15CellBankOrgnum(String d15CellBankOrgnum) {
		this.d15CellBankOrgnum = d15CellBankOrgnum;
	}

	public void setD15CellBankTraOrgnum(String d15CellBankTraOrgnum) {
		this.d15CellBankTraOrgnum = d15CellBankTraOrgnum;
	}

	public void setD15CellBankRetOrgnum(String d15CellBankRetOrgnum) {
		this.d15CellBankRetOrgnum = d15CellBankRetOrgnum;
	}

	public void setD15CellBankWeekAllnum(String d15CellBankWeekAllnum) {
		this.d15CellBankWeekAllnum = d15CellBankWeekAllnum;
	}

	public void setD15CellBankWeekOrgnum(String d15CellBankWeekOrgnum) {
		this.d15CellBankWeekOrgnum = d15CellBankWeekOrgnum;
	}

	public void setD15CellBankNightAllnum(String d15CellBankNightAllnum) {
		this.d15CellBankNightAllnum = d15CellBankNightAllnum;
	}

	public void setD15CellBankNightOrgnum(String d15CellBankNightOrgnum) {
		this.d15CellBankNightOrgnum = d15CellBankNightOrgnum;
	}

	public void setD15CellNbankSelfnum(String d15CellNbankSelfnum) {
		this.d15CellNbankSelfnum = d15CellNbankSelfnum;
	}

	public void setD15CellNbankAllnum(String d15CellNbankAllnum) {
		this.d15CellNbankAllnum = d15CellNbankAllnum;
	}

	public void setD15CellNbankP2pAllnum(String d15CellNbankP2pAllnum) {
		this.d15CellNbankP2pAllnum = d15CellNbankP2pAllnum;
	}

	public void setD15CellNbankMcAllnum(String d15CellNbankMcAllnum) {
		this.d15CellNbankMcAllnum = d15CellNbankMcAllnum;
	}

	public void setD15CellNbankCaAllnum(String d15CellNbankCaAllnum) {
		this.d15CellNbankCaAllnum = d15CellNbankCaAllnum;
	}

	public void setD15CellNbankCfAllnum(String d15CellNbankCfAllnum) {
		this.d15CellNbankCfAllnum = d15CellNbankCfAllnum;
	}

	public void setD15CellNbankComAllnum(String d15CellNbankComAllnum) {
		this.d15CellNbankComAllnum = d15CellNbankComAllnum;
	}

	public void setD15CellNbankOthAllnum(String d15CellNbankOthAllnum) {
		this.d15CellNbankOthAllnum = d15CellNbankOthAllnum;
	}

	public void setD15CellNbankNsloanAllnum(String d15CellNbankNsloanAllnum) {
		this.d15CellNbankNsloanAllnum = d15CellNbankNsloanAllnum;
	}

	public void setD15CellNbankAutofinAllnum(String d15CellNbankAutofinAllnum) {
		this.d15CellNbankAutofinAllnum = d15CellNbankAutofinAllnum;
	}

	public void setD15CellNbankSloanAllnum(String d15CellNbankSloanAllnum) {
		this.d15CellNbankSloanAllnum = d15CellNbankSloanAllnum;
	}

	public void setD15CellNbankConsAllnum(String d15CellNbankConsAllnum) {
		this.d15CellNbankConsAllnum = d15CellNbankConsAllnum;
	}

	public void setD15CellNbankFinleaAllnum(String d15CellNbankFinleaAllnum) {
		this.d15CellNbankFinleaAllnum = d15CellNbankFinleaAllnum;
	}

	public void setD15CellNbankElseAllnum(String d15CellNbankElseAllnum) {
		this.d15CellNbankElseAllnum = d15CellNbankElseAllnum;
	}

	public void setD15CellNbankOrgnum(String d15CellNbankOrgnum) {
		this.d15CellNbankOrgnum = d15CellNbankOrgnum;
	}

	public void setD15CellNbankP2pOrgnum(String d15CellNbankP2pOrgnum) {
		this.d15CellNbankP2pOrgnum = d15CellNbankP2pOrgnum;
	}

	public void setD15CellNbankMcOrgnum(String d15CellNbankMcOrgnum) {
		this.d15CellNbankMcOrgnum = d15CellNbankMcOrgnum;
	}

	public void setD15CellNbankCaOrgnum(String d15CellNbankCaOrgnum) {
		this.d15CellNbankCaOrgnum = d15CellNbankCaOrgnum;
	}

	public void setD15CellNbankCfOrgnum(String d15CellNbankCfOrgnum) {
		this.d15CellNbankCfOrgnum = d15CellNbankCfOrgnum;
	}

	public void setD15CellNbankComOrgnum(String d15CellNbankComOrgnum) {
		this.d15CellNbankComOrgnum = d15CellNbankComOrgnum;
	}

	public void setD15CellNbankOthOrgnum(String d15CellNbankOthOrgnum) {
		this.d15CellNbankOthOrgnum = d15CellNbankOthOrgnum;
	}

	public void setD15CellNbankNsloanOrgnum(String d15CellNbankNsloanOrgnum) {
		this.d15CellNbankNsloanOrgnum = d15CellNbankNsloanOrgnum;
	}

	public void setD15CellNbankAutofinOrgnum(String d15CellNbankAutofinOrgnum) {
		this.d15CellNbankAutofinOrgnum = d15CellNbankAutofinOrgnum;
	}

	public void setD15CellNbankSloanOrgnum(String d15CellNbankSloanOrgnum) {
		this.d15CellNbankSloanOrgnum = d15CellNbankSloanOrgnum;
	}

	public void setD15CellNbankConsOrgnum(String d15CellNbankConsOrgnum) {
		this.d15CellNbankConsOrgnum = d15CellNbankConsOrgnum;
	}

	public void setD15CellNbankFinleaOrgnum(String d15CellNbankFinleaOrgnum) {
		this.d15CellNbankFinleaOrgnum = d15CellNbankFinleaOrgnum;
	}

	public void setD15CellNbankElseOrgnum(String d15CellNbankElseOrgnum) {
		this.d15CellNbankElseOrgnum = d15CellNbankElseOrgnum;
	}

	public void setD15CellNbankWeekAllnum(String d15CellNbankWeekAllnum) {
		this.d15CellNbankWeekAllnum = d15CellNbankWeekAllnum;
	}

	public void setD15CellNbankWeekOrgnum(String d15CellNbankWeekOrgnum) {
		this.d15CellNbankWeekOrgnum = d15CellNbankWeekOrgnum;
	}

	public void setD15CellNbankNightAllnum(String d15CellNbankNightAllnum) {
		this.d15CellNbankNightAllnum = d15CellNbankNightAllnum;
	}

	public void setD15CellNbankNightOrgnum(String d15CellNbankNightOrgnum) {
		this.d15CellNbankNightOrgnum = d15CellNbankNightOrgnum;
	}

	public String getTrnKey() {
		return trnKey;
	}

	public void setTrnKey(String trnKey) {
		this.trnKey = trnKey;
	}

}
