package com.huaxia.plaze.modules.bairong.domain;

import java.util.Date;

/**
 * 百融多头借贷的7天内对应的数据
 * 
 * @author liuwei
 *
 */
public class ApplyLoanStrDay7 {
	
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

	// 按身份证号查询，近7天申请线上小额现金贷的次数
	private String d7IdPdlAllnum;

	// 按身份证号查询，近7天申请线上小额现金贷的机构数
	private String d7IdPdlOrgnum;

	// 按身份证号查询，近7天申请线上现金分期的次数
	private String d7IdCaonAllnum;

	// 按身份证号查询，近7天申请线上现金分期的机构数
	private String d7IdCaonOrgnum;

	// 按身份证号查询，近7天申请信用卡（类信用卡）的次数
	private String d7IdRelAllnum;

	// 按身份证号查询，近7天申请信用卡（类信用卡）的机构数
	private String d7IdRelOrgnum;

	// 按身份证号查询，近7天申请线下现金分期的次数
	private String d7IdCaoffAllnum;

	// 按身份证号查询，近7天申请线下现金分期的机构数
	private String d7IdCaoffOrgnum;

	// 按身份证号查询，近7天申请线下消费分期的次数
	private String d7IdCooffAllnum;

	// 按身份证号查询，近7天申请线下消费分期的机构数
	private String d7IdCooffOrgnum;

	// 按身份证号查询，近7天申请汽车金融的次数
	private String d7IdAfAllnum;

	// 按身份证号查询，近7天申请汽车金融的机构数
	private String d7IdAfOrgnum;

	// 按身份证号查询，近7天申请线上消费分期的次数
	private String d7IdCoonAllnum;

	// 按身份证号查询，近7天申请线上消费分期的机构数
	private String d7IdCoonOrgnum;

	// 按身份证号查询，近7天申请其他的次数
	private String d7IdOthAllnum;

	// 按身份证号查询，近7天申请其他的机构数
	private String d7IdOthOrgnum;

	// 按身份证号查询，近7天在本机构(本机构为银行)的申请次数
	private String d7IdBankSelfnum;

	// 按身份证号查询，近7天在银行机构申请次数
	private String d7IdBankAllnum;

	// 按身份证号查询，近7天在银行机构-传统银行申请次数
	private String d7IdBankTraAllnum;

	// 按身份证号查询，近7天在银行机构-网络零售银行申请次数
	private String d7IdBankRetAllnum;

	// 按身份证号查询，近7天在银行机构申请机构数
	private String d7IdBankOrgnum;

	// 按身份证号查询，近7天在银行机构-传统银行申请机构数
	private String d7IdBankTraOrgnum;

	// 按身份证号查询，近7天在银行机构-网络零售银行申请机构数
	private String d7IdBankRetOrgnum;

	// 按身份证号查询，近7天在银行机构周末申请次数
	private String d7IdBankWeekAllnum;

	// 按身份证号查询，近7天在银行机构周末申请机构数
	private String d7IdBankWeekOrgnum;

	// 按身份证号查询，近7天在银行机构夜间申请次数
	private String d7IdBankNightAllnum;

	// 按身份证号查询，近7天在银行机构夜间申请机构数
	private String d7IdBankNightOrgnum;

	// 按身份证号查询，近7天在本机构(本机构为非银)申请次数
	private String d7IdNbankSelfnum;

	// 按身份证号查询，近7天在非银机构申请次数
	private String d7IdNbankAllnum;

	// 按身份证号查询，近7天在非银机构-p2p机构申请次数
	private String d7IdNbankP2pAllnum;

	// 按身份证号查询，近7天在非银机构-小贷机构申请次数
	private String d7IdNbankMcAllnum;

	// 按身份证号查询，近7天在非银机构-现金类分期机构申请次数
	private String d7IdNbankCaAllnum;

	// 按身份证号查询，近7天在非银机构-消费类分期机构申请次数
	private String d7IdNbankCfAllnum;

	// 按身份证号查询，近7天在非银机构-代偿类分期机构申请次数
	private String d7IdNbankComAllnum;

	// 按身份证号查询，近7天在非银机构-其他申请次数
	private String d7IdNbankOthAllnum;

	// 按身份证号查询，近7天在非银机构-持牌网络小贷机构申请次数
	private String d7IdNbankNsloanAllnum;

	// 按身份证号查询，近7天在非银机构-持牌汽车金融机构申请次数
	private String d7IdNbankAutofinAllnum;

	// 按身份证号查询，近7天在非银机构-持牌小贷机构申请次数
	private String d7IdNbankSloanAllnum;

	// 按身份证号查询，近7天在非银机构-持牌消费金融机构申请次数
	private String d7IdNbankConsAllnum;

	// 按身份证号查询，近7天在非银机构-持牌融资租赁机构申请次数
	private String d7IdNbankFinleaAllnum;

	// 按身份证号查询，近7天在非银机构-其他申请次数
	private String d7IdNbankElseAllnum;

	// 按身份证号查询，近7天在非银机构申请机构数
	private String d7IdNbankOrgnum;

	// 按身份证号查询，近7天在非银机构-p2p申请机构数
	private String d7IdNbankP2pOrgnum;

	// 按身份证号查询，近7天在非银机构-小贷申请机构数
	private String d7IdNbankMcOrgnum;

	// 按身份证号查询，近7天在非银机构-现金类分期申请机构数
	private String d7IdNbankCaOrgnum;

	// 按身份证号查询，近7天在非银机构-消费类分期申请机构数
	private String d7IdNbankCfOrgnum;

	// 按身份证号查询，近7天在非银机构-代偿类分期申请机构数
	private String d7IdNbankComOrgnum;

	// 按身份证号查询，近7天在非银机构-其他申请机构数
	private String d7IdNbankOthOrgnum;

	// 按身份证号查询，近7天在非银机构-持牌网络小贷机构申请机构数
	private String d7IdNbankNsloanOrgnum;

	// 按身份证号查询，近7天在非银机构-持牌汽车金融机构申请机构数
	private String d7IdNbankAutofinOrgnum;

	// 按身份证号查询，近7天在非银机构-持牌小贷机构申请机构数
	private String d7IdNbankSloanOrgnum;

	// 按身份证号查询，近7天在非银机构-持牌消费金融机构申请机构数
	private String d7IdNbankConsOrgnum;

	// 按身份证号查询，近7天在非银机构-持牌融资租赁机构申请机构数
	private String d7IdNbankFinleaOrgnum;

	// 按身份证号查询，近7天在非银机构-其他申请机构数
	private String d7IdNbankElseOrgnum;

	// 按身份证号查询，近7天在非银机构周末申请次数
	private String d7IdNbankWeekAllnum;

	// 按身份证号查询，近7天在非银机构周末申请机构数
	private String d7IdNbankWeekOrgnum;

	// 按身份证号查询，近7天在非银机构夜间申请次数
	private String d7IdNbankNightAllnum;

	// 按身份证号查询，近7天在非银机构夜间申请机构数
	private String d7IdNbankNightOrgnum;

	// 按手机号查询，近7天申请线上小额现金贷的次数
	private String d7CellPdlAllnum;

	// 按手机号查询，近7天申请线上小额现金贷的机构数
	private String d7CellPdlOrgnum;

	// 按手机号查询，近7天申请线上现金分期的次数
	private String d7CellCaonAllnum;

	// 按手机号查询，近7天申请线上现金分期的机构数
	private String d7CellCaonOrgnum;

	// 按手机号查询，近7天申请信用卡（类信用卡）的次数
	private String d7CellRelAllnum;

	// 按手机号查询，近7天申请信用卡（类信用卡）的机构数
	private String d7CellRelOrgnum;

	// 按手机号查询，近7天申请线下现金分期的次数
	private String d7CellCaoffAllnum;

	// 按手机号查询，近7天申请线下现金分期的机构数
	private String d7CellCaoffOrgnum;

	// 按手机号查询，近7天申请线下消费分期的次数
	private String d7CellCooffAllnum;

	// 按手机号查询，近7天申请线下消费分期的机构数
	private String d7CellCooffOrgnum;

	// 按手机号查询，近7天申请汽车金融的次数
	private String d7CellAfAllnum;

	// 按手机号查询，近7天申请汽车金融的机构数
	private String d7CellAfOrgnum;

	// 按手机号查询，近7天申请线上消费分期的次数
	private String d7CellCoonAllnum;

	// 按手机号查询，近7天申请线上消费分期的机构数
	private String d7CellCoonOrgnum;

	// 按手机号查询，近7天申请其他的次数
	private String d7CellOthAllnum;

	// 按手机号查询，近7天申请其他的机构数
	private String d7CellOthOrgnum;

	// 按手机号查询，近7天在本机构(本机构为银行)的申请次数
	private String d7CellBankSelfnum;

	// 按手机号查询，近7天在银行机构申请次数
	private String d7CellBankAllnum;

	// 按手机号查询，近7天在银行机构-传统银行申请次数
	private String d7CellBankTraAllnum;

	// 按手机号查询，近7天在银行机构-网络零售银行申请次数
	private String d7CellBankRetAllnum;

	// 按手机号查询，近7天在银行机构申请机构数
	private String d7CellBankOrgnum;

	// 按手机号查询，近7天在银行机构-传统银行申请机构数
	private String d7CellBankTraOrgnum;

	// 按手机号查询，近7天在银行机构-网络零售银行申请机构数
	private String d7CellBankRetOrgnum;

	// 按手机号查询，近7天在银行机构周末申请次数
	private String d7CellBankWeekAllnum;

	// 按手机号查询，近7天在银行机构周末申请机构数
	private String d7CellBankWeekOrgnum;

	// 按手机号查询，近7天在银行机构夜间申请次数
	private String d7CellBankNightAllnum;

	// 按手机号查询，近7天在银行机构夜间申请机构数
	private String d7CellBankNightOrgnum;

	// 按手机号查询，近7天在本机构(本机构为非银)申请次数
	private String d7CellNbankSelfnum;

	// 按手机号查询，近7天在非银机构申请次数
	private String d7CellNbankAllnum;

	// 按手机号查询，近7天在非银机构-p2p机构申请次数
	private String d7CellNbankP2pAllnum;

	// 按手机号查询，近7天在非银机构-小贷机构申请次数
	private String d7CellNbankMcAllnum;

	// 按手机号查询，近7天在非银机构-现金类分期机构申请次数
	private String d7CellNbankCaAllnum;

	// 按手机号查询，近7天在非银机构-消费类分期机构申请次数
	private String d7CellNbankCfAllnum;

	// 按手机号查询，近7天在非银机构-代偿类分期机构申请次数
	private String d7CellNbankComAllnum;

	// 按手机号查询，近7天在非银机构-其他申请次数
	private String d7CellNbankOthAllnum;

	// 按手机号查询，近7天在非银机构-持牌网络小贷机构申请次数
	private String d7CellNbankNsloanAllnum;

	// 按手机号查询，近7天在非银机构-持牌汽车金融机构申请次数
	private String d7CellNbankAutofinAllnum;

	// 按手机号查询，近7天在非银机构-持牌小贷机构申请次数
	private String d7CellNbankSloanAllnum;

	// 按手机号查询，近7天在非银机构-持牌消费金融机构申请次数
	private String d7CellNbankConsAllnum;

	// 按手机号查询，近7天在非银机构-持牌融资租赁机构申请次数
	private String d7CellNbankFinleaAllnum;

	// 按手机号查询，近7天在非银机构-其他申请次数
	private String d7CellNbankElseAllnum;

	// 按手机号查询，近7天在非银机构申请机构数
	private String d7CellNbankOrgnum;

	// 按手机号查询，近7天在非银机构-p2p申请机构数
	private String d7CellNbankP2pOrgnum;

	// 按手机号查询，近7天在非银机构-小贷申请机构数
	private String d7CellNbankMcOrgnum;

	// 按手机号查询，近7天在非银机构-现金类分期申请机构数
	private String d7CellNbankCaOrgnum;

	// 按手机号查询，近7天在非银机构-消费类分期申请机构数
	private String d7CellNbankCfOrgnum;

	// 按手机号查询，近7天在非银机构-代偿类分期申请机构数
	private String d7CellNbankComOrgnum;

	// 按手机号查询，近7天在非银机构-其他申请机构数
	private String d7CellNbankOthOrgnum;

	// 按手机号查询，近7天在非银机构-持牌网络小贷机构申请机构数
	private String d7CellNbankNsloanOrgnum;

	// 按手机号查询，近7天在非银机构-持牌汽车金融机构申请机构数
	private String d7CellNbankAutofinOrgnum;

	// 按手机号查询，近7天在非银机构-持牌小贷机构申请机构数
	private String d7CellNbankSloanOrgnum;

	// 按手机号查询，近7天在非银机构-持牌消费金融机构申请机构数
	private String d7CellNbankConsOrgnum;

	// 按手机号查询，近7天在非银机构-持牌融资租赁机构申请机构数
	private String d7CellNbankFinleaOrgnum;

	// 按手机号查询，近7天在非银机构-其他申请机构数
	private String d7CellNbankElseOrgnum;

	// 按手机号查询，近7天在非银机构周末申请次数
	private String d7CellNbankWeekAllnum;

	// 按手机号查询，近7天在非银机构周末申请机构数
	private String d7CellNbankWeekOrgnum;

	// 按手机号查询，近7天在非银机构夜间申请次数
	private String d7CellNbankNightAllnum;

	// 按手机号查询，近7天在非银机构夜间申请机构数
	private String d7CellNbankNightOrgnum;

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

	public String getD7IdPdlAllnum() {
		return d7IdPdlAllnum;
	}

	public String getD7IdPdlOrgnum() {
		return d7IdPdlOrgnum;
	}

	public String getD7IdCaonAllnum() {
		return d7IdCaonAllnum;
	}

	public String getD7IdCaonOrgnum() {
		return d7IdCaonOrgnum;
	}

	public String getD7IdRelAllnum() {
		return d7IdRelAllnum;
	}

	public String getD7IdRelOrgnum() {
		return d7IdRelOrgnum;
	}

	public String getD7IdCaoffAllnum() {
		return d7IdCaoffAllnum;
	}

	public String getD7IdCaoffOrgnum() {
		return d7IdCaoffOrgnum;
	}

	public String getD7IdCooffAllnum() {
		return d7IdCooffAllnum;
	}

	public String getD7IdCooffOrgnum() {
		return d7IdCooffOrgnum;
	}

	public String getD7IdAfAllnum() {
		return d7IdAfAllnum;
	}

	public String getD7IdAfOrgnum() {
		return d7IdAfOrgnum;
	}

	public String getD7IdCoonAllnum() {
		return d7IdCoonAllnum;
	}

	public String getD7IdCoonOrgnum() {
		return d7IdCoonOrgnum;
	}

	public String getD7IdOthAllnum() {
		return d7IdOthAllnum;
	}

	public String getD7IdOthOrgnum() {
		return d7IdOthOrgnum;
	}

	public String getD7IdBankSelfnum() {
		return d7IdBankSelfnum;
	}

	public String getD7IdBankAllnum() {
		return d7IdBankAllnum;
	}

	public String getD7IdBankTraAllnum() {
		return d7IdBankTraAllnum;
	}

	public String getD7IdBankRetAllnum() {
		return d7IdBankRetAllnum;
	}

	public String getD7IdBankOrgnum() {
		return d7IdBankOrgnum;
	}

	public String getD7IdBankTraOrgnum() {
		return d7IdBankTraOrgnum;
	}

	public String getD7IdBankRetOrgnum() {
		return d7IdBankRetOrgnum;
	}

	public String getD7IdBankWeekAllnum() {
		return d7IdBankWeekAllnum;
	}

	public String getD7IdBankWeekOrgnum() {
		return d7IdBankWeekOrgnum;
	}

	public String getD7IdBankNightAllnum() {
		return d7IdBankNightAllnum;
	}

	public String getD7IdBankNightOrgnum() {
		return d7IdBankNightOrgnum;
	}

	public String getD7IdNbankSelfnum() {
		return d7IdNbankSelfnum;
	}

	public String getD7IdNbankAllnum() {
		return d7IdNbankAllnum;
	}

	public String getD7IdNbankP2pAllnum() {
		return d7IdNbankP2pAllnum;
	}

	public String getD7IdNbankMcAllnum() {
		return d7IdNbankMcAllnum;
	}

	public String getD7IdNbankCaAllnum() {
		return d7IdNbankCaAllnum;
	}

	public String getD7IdNbankCfAllnum() {
		return d7IdNbankCfAllnum;
	}

	public String getD7IdNbankComAllnum() {
		return d7IdNbankComAllnum;
	}

	public String getD7IdNbankOthAllnum() {
		return d7IdNbankOthAllnum;
	}

	public String getD7IdNbankNsloanAllnum() {
		return d7IdNbankNsloanAllnum;
	}

	public String getD7IdNbankAutofinAllnum() {
		return d7IdNbankAutofinAllnum;
	}

	public String getD7IdNbankSloanAllnum() {
		return d7IdNbankSloanAllnum;
	}

	public String getD7IdNbankConsAllnum() {
		return d7IdNbankConsAllnum;
	}

	public String getD7IdNbankFinleaAllnum() {
		return d7IdNbankFinleaAllnum;
	}

	public String getD7IdNbankElseAllnum() {
		return d7IdNbankElseAllnum;
	}

	public String getD7IdNbankOrgnum() {
		return d7IdNbankOrgnum;
	}

	public String getD7IdNbankP2pOrgnum() {
		return d7IdNbankP2pOrgnum;
	}

	public String getD7IdNbankMcOrgnum() {
		return d7IdNbankMcOrgnum;
	}

	public String getD7IdNbankCaOrgnum() {
		return d7IdNbankCaOrgnum;
	}

	public String getD7IdNbankCfOrgnum() {
		return d7IdNbankCfOrgnum;
	}

	public String getD7IdNbankComOrgnum() {
		return d7IdNbankComOrgnum;
	}

	public String getD7IdNbankOthOrgnum() {
		return d7IdNbankOthOrgnum;
	}

	public String getD7IdNbankNsloanOrgnum() {
		return d7IdNbankNsloanOrgnum;
	}

	public String getD7IdNbankAutofinOrgnum() {
		return d7IdNbankAutofinOrgnum;
	}

	public String getD7IdNbankSloanOrgnum() {
		return d7IdNbankSloanOrgnum;
	}

	public String getD7IdNbankConsOrgnum() {
		return d7IdNbankConsOrgnum;
	}

	public String getD7IdNbankFinleaOrgnum() {
		return d7IdNbankFinleaOrgnum;
	}

	public String getD7IdNbankElseOrgnum() {
		return d7IdNbankElseOrgnum;
	}

	public String getD7IdNbankWeekAllnum() {
		return d7IdNbankWeekAllnum;
	}

	public String getD7IdNbankWeekOrgnum() {
		return d7IdNbankWeekOrgnum;
	}

	public String getD7IdNbankNightAllnum() {
		return d7IdNbankNightAllnum;
	}

	public String getD7IdNbankNightOrgnum() {
		return d7IdNbankNightOrgnum;
	}

	public String getD7CellPdlAllnum() {
		return d7CellPdlAllnum;
	}

	public String getD7CellPdlOrgnum() {
		return d7CellPdlOrgnum;
	}

	public String getD7CellCaonAllnum() {
		return d7CellCaonAllnum;
	}

	public String getD7CellCaonOrgnum() {
		return d7CellCaonOrgnum;
	}

	public String getD7CellRelAllnum() {
		return d7CellRelAllnum;
	}

	public String getD7CellRelOrgnum() {
		return d7CellRelOrgnum;
	}

	public String getD7CellCaoffAllnum() {
		return d7CellCaoffAllnum;
	}

	public String getD7CellCaoffOrgnum() {
		return d7CellCaoffOrgnum;
	}

	public String getD7CellCooffAllnum() {
		return d7CellCooffAllnum;
	}

	public String getD7CellCooffOrgnum() {
		return d7CellCooffOrgnum;
	}

	public String getD7CellAfAllnum() {
		return d7CellAfAllnum;
	}

	public String getD7CellAfOrgnum() {
		return d7CellAfOrgnum;
	}

	public String getD7CellCoonAllnum() {
		return d7CellCoonAllnum;
	}

	public String getD7CellCoonOrgnum() {
		return d7CellCoonOrgnum;
	}

	public String getD7CellOthAllnum() {
		return d7CellOthAllnum;
	}

	public String getD7CellOthOrgnum() {
		return d7CellOthOrgnum;
	}

	public String getD7CellBankSelfnum() {
		return d7CellBankSelfnum;
	}

	public String getD7CellBankAllnum() {
		return d7CellBankAllnum;
	}

	public String getD7CellBankTraAllnum() {
		return d7CellBankTraAllnum;
	}

	public String getD7CellBankRetAllnum() {
		return d7CellBankRetAllnum;
	}

	public String getD7CellBankOrgnum() {
		return d7CellBankOrgnum;
	}

	public String getD7CellBankTraOrgnum() {
		return d7CellBankTraOrgnum;
	}

	public String getD7CellBankRetOrgnum() {
		return d7CellBankRetOrgnum;
	}

	public String getD7CellBankWeekAllnum() {
		return d7CellBankWeekAllnum;
	}

	public String getD7CellBankWeekOrgnum() {
		return d7CellBankWeekOrgnum;
	}

	public String getD7CellBankNightAllnum() {
		return d7CellBankNightAllnum;
	}

	public String getD7CellBankNightOrgnum() {
		return d7CellBankNightOrgnum;
	}

	public String getD7CellNbankSelfnum() {
		return d7CellNbankSelfnum;
	}

	public String getD7CellNbankAllnum() {
		return d7CellNbankAllnum;
	}

	public String getD7CellNbankP2pAllnum() {
		return d7CellNbankP2pAllnum;
	}

	public String getD7CellNbankMcAllnum() {
		return d7CellNbankMcAllnum;
	}

	public String getD7CellNbankCaAllnum() {
		return d7CellNbankCaAllnum;
	}

	public String getD7CellNbankCfAllnum() {
		return d7CellNbankCfAllnum;
	}

	public String getD7CellNbankComAllnum() {
		return d7CellNbankComAllnum;
	}

	public String getD7CellNbankOthAllnum() {
		return d7CellNbankOthAllnum;
	}

	public String getD7CellNbankNsloanAllnum() {
		return d7CellNbankNsloanAllnum;
	}

	public String getD7CellNbankAutofinAllnum() {
		return d7CellNbankAutofinAllnum;
	}

	public String getD7CellNbankSloanAllnum() {
		return d7CellNbankSloanAllnum;
	}

	public String getD7CellNbankConsAllnum() {
		return d7CellNbankConsAllnum;
	}

	public String getD7CellNbankFinleaAllnum() {
		return d7CellNbankFinleaAllnum;
	}

	public String getD7CellNbankElseAllnum() {
		return d7CellNbankElseAllnum;
	}

	public String getD7CellNbankOrgnum() {
		return d7CellNbankOrgnum;
	}

	public String getD7CellNbankP2pOrgnum() {
		return d7CellNbankP2pOrgnum;
	}

	public String getD7CellNbankMcOrgnum() {
		return d7CellNbankMcOrgnum;
	}

	public String getD7CellNbankCaOrgnum() {
		return d7CellNbankCaOrgnum;
	}

	public String getD7CellNbankCfOrgnum() {
		return d7CellNbankCfOrgnum;
	}

	public String getD7CellNbankComOrgnum() {
		return d7CellNbankComOrgnum;
	}

	public String getD7CellNbankOthOrgnum() {
		return d7CellNbankOthOrgnum;
	}

	public String getD7CellNbankNsloanOrgnum() {
		return d7CellNbankNsloanOrgnum;
	}

	public String getD7CellNbankAutofinOrgnum() {
		return d7CellNbankAutofinOrgnum;
	}

	public String getD7CellNbankSloanOrgnum() {
		return d7CellNbankSloanOrgnum;
	}

	public String getD7CellNbankConsOrgnum() {
		return d7CellNbankConsOrgnum;
	}

	public String getD7CellNbankFinleaOrgnum() {
		return d7CellNbankFinleaOrgnum;
	}

	public String getD7CellNbankElseOrgnum() {
		return d7CellNbankElseOrgnum;
	}

	public String getD7CellNbankWeekAllnum() {
		return d7CellNbankWeekAllnum;
	}

	public String getD7CellNbankWeekOrgnum() {
		return d7CellNbankWeekOrgnum;
	}

	public String getD7CellNbankNightAllnum() {
		return d7CellNbankNightAllnum;
	}

	public String getD7CellNbankNightOrgnum() {
		return d7CellNbankNightOrgnum;
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

	public void setD7IdPdlAllnum(String d7IdPdlAllnum) {
		this.d7IdPdlAllnum = d7IdPdlAllnum;
	}

	public void setD7IdPdlOrgnum(String d7IdPdlOrgnum) {
		this.d7IdPdlOrgnum = d7IdPdlOrgnum;
	}

	public void setD7IdCaonAllnum(String d7IdCaonAllnum) {
		this.d7IdCaonAllnum = d7IdCaonAllnum;
	}

	public void setD7IdCaonOrgnum(String d7IdCaonOrgnum) {
		this.d7IdCaonOrgnum = d7IdCaonOrgnum;
	}

	public void setD7IdRelAllnum(String d7IdRelAllnum) {
		this.d7IdRelAllnum = d7IdRelAllnum;
	}

	public void setD7IdRelOrgnum(String d7IdRelOrgnum) {
		this.d7IdRelOrgnum = d7IdRelOrgnum;
	}

	public void setD7IdCaoffAllnum(String d7IdCaoffAllnum) {
		this.d7IdCaoffAllnum = d7IdCaoffAllnum;
	}

	public void setD7IdCaoffOrgnum(String d7IdCaoffOrgnum) {
		this.d7IdCaoffOrgnum = d7IdCaoffOrgnum;
	}

	public void setD7IdCooffAllnum(String d7IdCooffAllnum) {
		this.d7IdCooffAllnum = d7IdCooffAllnum;
	}

	public void setD7IdCooffOrgnum(String d7IdCooffOrgnum) {
		this.d7IdCooffOrgnum = d7IdCooffOrgnum;
	}

	public void setD7IdAfAllnum(String d7IdAfAllnum) {
		this.d7IdAfAllnum = d7IdAfAllnum;
	}

	public void setD7IdAfOrgnum(String d7IdAfOrgnum) {
		this.d7IdAfOrgnum = d7IdAfOrgnum;
	}

	public void setD7IdCoonAllnum(String d7IdCoonAllnum) {
		this.d7IdCoonAllnum = d7IdCoonAllnum;
	}

	public void setD7IdCoonOrgnum(String d7IdCoonOrgnum) {
		this.d7IdCoonOrgnum = d7IdCoonOrgnum;
	}

	public void setD7IdOthAllnum(String d7IdOthAllnum) {
		this.d7IdOthAllnum = d7IdOthAllnum;
	}

	public void setD7IdOthOrgnum(String d7IdOthOrgnum) {
		this.d7IdOthOrgnum = d7IdOthOrgnum;
	}

	public void setD7IdBankSelfnum(String d7IdBankSelfnum) {
		this.d7IdBankSelfnum = d7IdBankSelfnum;
	}

	public void setD7IdBankAllnum(String d7IdBankAllnum) {
		this.d7IdBankAllnum = d7IdBankAllnum;
	}

	public void setD7IdBankTraAllnum(String d7IdBankTraAllnum) {
		this.d7IdBankTraAllnum = d7IdBankTraAllnum;
	}

	public void setD7IdBankRetAllnum(String d7IdBankRetAllnum) {
		this.d7IdBankRetAllnum = d7IdBankRetAllnum;
	}

	public void setD7IdBankOrgnum(String d7IdBankOrgnum) {
		this.d7IdBankOrgnum = d7IdBankOrgnum;
	}

	public void setD7IdBankTraOrgnum(String d7IdBankTraOrgnum) {
		this.d7IdBankTraOrgnum = d7IdBankTraOrgnum;
	}

	public void setD7IdBankRetOrgnum(String d7IdBankRetOrgnum) {
		this.d7IdBankRetOrgnum = d7IdBankRetOrgnum;
	}

	public void setD7IdBankWeekAllnum(String d7IdBankWeekAllnum) {
		this.d7IdBankWeekAllnum = d7IdBankWeekAllnum;
	}

	public void setD7IdBankWeekOrgnum(String d7IdBankWeekOrgnum) {
		this.d7IdBankWeekOrgnum = d7IdBankWeekOrgnum;
	}

	public void setD7IdBankNightAllnum(String d7IdBankNightAllnum) {
		this.d7IdBankNightAllnum = d7IdBankNightAllnum;
	}

	public void setD7IdBankNightOrgnum(String d7IdBankNightOrgnum) {
		this.d7IdBankNightOrgnum = d7IdBankNightOrgnum;
	}

	public void setD7IdNbankSelfnum(String d7IdNbankSelfnum) {
		this.d7IdNbankSelfnum = d7IdNbankSelfnum;
	}

	public void setD7IdNbankAllnum(String d7IdNbankAllnum) {
		this.d7IdNbankAllnum = d7IdNbankAllnum;
	}

	public void setD7IdNbankP2pAllnum(String d7IdNbankP2pAllnum) {
		this.d7IdNbankP2pAllnum = d7IdNbankP2pAllnum;
	}

	public void setD7IdNbankMcAllnum(String d7IdNbankMcAllnum) {
		this.d7IdNbankMcAllnum = d7IdNbankMcAllnum;
	}

	public void setD7IdNbankCaAllnum(String d7IdNbankCaAllnum) {
		this.d7IdNbankCaAllnum = d7IdNbankCaAllnum;
	}

	public void setD7IdNbankCfAllnum(String d7IdNbankCfAllnum) {
		this.d7IdNbankCfAllnum = d7IdNbankCfAllnum;
	}

	public void setD7IdNbankComAllnum(String d7IdNbankComAllnum) {
		this.d7IdNbankComAllnum = d7IdNbankComAllnum;
	}

	public void setD7IdNbankOthAllnum(String d7IdNbankOthAllnum) {
		this.d7IdNbankOthAllnum = d7IdNbankOthAllnum;
	}

	public void setD7IdNbankNsloanAllnum(String d7IdNbankNsloanAllnum) {
		this.d7IdNbankNsloanAllnum = d7IdNbankNsloanAllnum;
	}

	public void setD7IdNbankAutofinAllnum(String d7IdNbankAutofinAllnum) {
		this.d7IdNbankAutofinAllnum = d7IdNbankAutofinAllnum;
	}

	public void setD7IdNbankSloanAllnum(String d7IdNbankSloanAllnum) {
		this.d7IdNbankSloanAllnum = d7IdNbankSloanAllnum;
	}

	public void setD7IdNbankConsAllnum(String d7IdNbankConsAllnum) {
		this.d7IdNbankConsAllnum = d7IdNbankConsAllnum;
	}

	public void setD7IdNbankFinleaAllnum(String d7IdNbankFinleaAllnum) {
		this.d7IdNbankFinleaAllnum = d7IdNbankFinleaAllnum;
	}

	public void setD7IdNbankElseAllnum(String d7IdNbankElseAllnum) {
		this.d7IdNbankElseAllnum = d7IdNbankElseAllnum;
	}

	public void setD7IdNbankOrgnum(String d7IdNbankOrgnum) {
		this.d7IdNbankOrgnum = d7IdNbankOrgnum;
	}

	public void setD7IdNbankP2pOrgnum(String d7IdNbankP2pOrgnum) {
		this.d7IdNbankP2pOrgnum = d7IdNbankP2pOrgnum;
	}

	public void setD7IdNbankMcOrgnum(String d7IdNbankMcOrgnum) {
		this.d7IdNbankMcOrgnum = d7IdNbankMcOrgnum;
	}

	public void setD7IdNbankCaOrgnum(String d7IdNbankCaOrgnum) {
		this.d7IdNbankCaOrgnum = d7IdNbankCaOrgnum;
	}

	public void setD7IdNbankCfOrgnum(String d7IdNbankCfOrgnum) {
		this.d7IdNbankCfOrgnum = d7IdNbankCfOrgnum;
	}

	public void setD7IdNbankComOrgnum(String d7IdNbankComOrgnum) {
		this.d7IdNbankComOrgnum = d7IdNbankComOrgnum;
	}

	public void setD7IdNbankOthOrgnum(String d7IdNbankOthOrgnum) {
		this.d7IdNbankOthOrgnum = d7IdNbankOthOrgnum;
	}

	public void setD7IdNbankNsloanOrgnum(String d7IdNbankNsloanOrgnum) {
		this.d7IdNbankNsloanOrgnum = d7IdNbankNsloanOrgnum;
	}

	public void setD7IdNbankAutofinOrgnum(String d7IdNbankAutofinOrgnum) {
		this.d7IdNbankAutofinOrgnum = d7IdNbankAutofinOrgnum;
	}

	public void setD7IdNbankSloanOrgnum(String d7IdNbankSloanOrgnum) {
		this.d7IdNbankSloanOrgnum = d7IdNbankSloanOrgnum;
	}

	public void setD7IdNbankConsOrgnum(String d7IdNbankConsOrgnum) {
		this.d7IdNbankConsOrgnum = d7IdNbankConsOrgnum;
	}

	public void setD7IdNbankFinleaOrgnum(String d7IdNbankFinleaOrgnum) {
		this.d7IdNbankFinleaOrgnum = d7IdNbankFinleaOrgnum;
	}

	public void setD7IdNbankElseOrgnum(String d7IdNbankElseOrgnum) {
		this.d7IdNbankElseOrgnum = d7IdNbankElseOrgnum;
	}

	public void setD7IdNbankWeekAllnum(String d7IdNbankWeekAllnum) {
		this.d7IdNbankWeekAllnum = d7IdNbankWeekAllnum;
	}

	public void setD7IdNbankWeekOrgnum(String d7IdNbankWeekOrgnum) {
		this.d7IdNbankWeekOrgnum = d7IdNbankWeekOrgnum;
	}

	public void setD7IdNbankNightAllnum(String d7IdNbankNightAllnum) {
		this.d7IdNbankNightAllnum = d7IdNbankNightAllnum;
	}

	public void setD7IdNbankNightOrgnum(String d7IdNbankNightOrgnum) {
		this.d7IdNbankNightOrgnum = d7IdNbankNightOrgnum;
	}

	public void setD7CellPdlAllnum(String d7CellPdlAllnum) {
		this.d7CellPdlAllnum = d7CellPdlAllnum;
	}

	public void setD7CellPdlOrgnum(String d7CellPdlOrgnum) {
		this.d7CellPdlOrgnum = d7CellPdlOrgnum;
	}

	public void setD7CellCaonAllnum(String d7CellCaonAllnum) {
		this.d7CellCaonAllnum = d7CellCaonAllnum;
	}

	public void setD7CellCaonOrgnum(String d7CellCaonOrgnum) {
		this.d7CellCaonOrgnum = d7CellCaonOrgnum;
	}

	public void setD7CellRelAllnum(String d7CellRelAllnum) {
		this.d7CellRelAllnum = d7CellRelAllnum;
	}

	public void setD7CellRelOrgnum(String d7CellRelOrgnum) {
		this.d7CellRelOrgnum = d7CellRelOrgnum;
	}

	public void setD7CellCaoffAllnum(String d7CellCaoffAllnum) {
		this.d7CellCaoffAllnum = d7CellCaoffAllnum;
	}

	public void setD7CellCaoffOrgnum(String d7CellCaoffOrgnum) {
		this.d7CellCaoffOrgnum = d7CellCaoffOrgnum;
	}

	public void setD7CellCooffAllnum(String d7CellCooffAllnum) {
		this.d7CellCooffAllnum = d7CellCooffAllnum;
	}

	public void setD7CellCooffOrgnum(String d7CellCooffOrgnum) {
		this.d7CellCooffOrgnum = d7CellCooffOrgnum;
	}

	public void setD7CellAfAllnum(String d7CellAfAllnum) {
		this.d7CellAfAllnum = d7CellAfAllnum;
	}

	public void setD7CellAfOrgnum(String d7CellAfOrgnum) {
		this.d7CellAfOrgnum = d7CellAfOrgnum;
	}

	public void setD7CellCoonAllnum(String d7CellCoonAllnum) {
		this.d7CellCoonAllnum = d7CellCoonAllnum;
	}

	public void setD7CellCoonOrgnum(String d7CellCoonOrgnum) {
		this.d7CellCoonOrgnum = d7CellCoonOrgnum;
	}

	public void setD7CellOthAllnum(String d7CellOthAllnum) {
		this.d7CellOthAllnum = d7CellOthAllnum;
	}

	public void setD7CellOthOrgnum(String d7CellOthOrgnum) {
		this.d7CellOthOrgnum = d7CellOthOrgnum;
	}

	public void setD7CellBankSelfnum(String d7CellBankSelfnum) {
		this.d7CellBankSelfnum = d7CellBankSelfnum;
	}

	public void setD7CellBankAllnum(String d7CellBankAllnum) {
		this.d7CellBankAllnum = d7CellBankAllnum;
	}

	public void setD7CellBankTraAllnum(String d7CellBankTraAllnum) {
		this.d7CellBankTraAllnum = d7CellBankTraAllnum;
	}

	public void setD7CellBankRetAllnum(String d7CellBankRetAllnum) {
		this.d7CellBankRetAllnum = d7CellBankRetAllnum;
	}

	public void setD7CellBankOrgnum(String d7CellBankOrgnum) {
		this.d7CellBankOrgnum = d7CellBankOrgnum;
	}

	public void setD7CellBankTraOrgnum(String d7CellBankTraOrgnum) {
		this.d7CellBankTraOrgnum = d7CellBankTraOrgnum;
	}

	public void setD7CellBankRetOrgnum(String d7CellBankRetOrgnum) {
		this.d7CellBankRetOrgnum = d7CellBankRetOrgnum;
	}

	public void setD7CellBankWeekAllnum(String d7CellBankWeekAllnum) {
		this.d7CellBankWeekAllnum = d7CellBankWeekAllnum;
	}

	public void setD7CellBankWeekOrgnum(String d7CellBankWeekOrgnum) {
		this.d7CellBankWeekOrgnum = d7CellBankWeekOrgnum;
	}

	public void setD7CellBankNightAllnum(String d7CellBankNightAllnum) {
		this.d7CellBankNightAllnum = d7CellBankNightAllnum;
	}

	public void setD7CellBankNightOrgnum(String d7CellBankNightOrgnum) {
		this.d7CellBankNightOrgnum = d7CellBankNightOrgnum;
	}

	public void setD7CellNbankSelfnum(String d7CellNbankSelfnum) {
		this.d7CellNbankSelfnum = d7CellNbankSelfnum;
	}

	public void setD7CellNbankAllnum(String d7CellNbankAllnum) {
		this.d7CellNbankAllnum = d7CellNbankAllnum;
	}

	public void setD7CellNbankP2pAllnum(String d7CellNbankP2pAllnum) {
		this.d7CellNbankP2pAllnum = d7CellNbankP2pAllnum;
	}

	public void setD7CellNbankMcAllnum(String d7CellNbankMcAllnum) {
		this.d7CellNbankMcAllnum = d7CellNbankMcAllnum;
	}

	public void setD7CellNbankCaAllnum(String d7CellNbankCaAllnum) {
		this.d7CellNbankCaAllnum = d7CellNbankCaAllnum;
	}

	public void setD7CellNbankCfAllnum(String d7CellNbankCfAllnum) {
		this.d7CellNbankCfAllnum = d7CellNbankCfAllnum;
	}

	public void setD7CellNbankComAllnum(String d7CellNbankComAllnum) {
		this.d7CellNbankComAllnum = d7CellNbankComAllnum;
	}

	public void setD7CellNbankOthAllnum(String d7CellNbankOthAllnum) {
		this.d7CellNbankOthAllnum = d7CellNbankOthAllnum;
	}

	public void setD7CellNbankNsloanAllnum(String d7CellNbankNsloanAllnum) {
		this.d7CellNbankNsloanAllnum = d7CellNbankNsloanAllnum;
	}

	public void setD7CellNbankAutofinAllnum(String d7CellNbankAutofinAllnum) {
		this.d7CellNbankAutofinAllnum = d7CellNbankAutofinAllnum;
	}

	public void setD7CellNbankSloanAllnum(String d7CellNbankSloanAllnum) {
		this.d7CellNbankSloanAllnum = d7CellNbankSloanAllnum;
	}

	public void setD7CellNbankConsAllnum(String d7CellNbankConsAllnum) {
		this.d7CellNbankConsAllnum = d7CellNbankConsAllnum;
	}

	public void setD7CellNbankFinleaAllnum(String d7CellNbankFinleaAllnum) {
		this.d7CellNbankFinleaAllnum = d7CellNbankFinleaAllnum;
	}

	public void setD7CellNbankElseAllnum(String d7CellNbankElseAllnum) {
		this.d7CellNbankElseAllnum = d7CellNbankElseAllnum;
	}

	public void setD7CellNbankOrgnum(String d7CellNbankOrgnum) {
		this.d7CellNbankOrgnum = d7CellNbankOrgnum;
	}

	public void setD7CellNbankP2pOrgnum(String d7CellNbankP2pOrgnum) {
		this.d7CellNbankP2pOrgnum = d7CellNbankP2pOrgnum;
	}

	public void setD7CellNbankMcOrgnum(String d7CellNbankMcOrgnum) {
		this.d7CellNbankMcOrgnum = d7CellNbankMcOrgnum;
	}

	public void setD7CellNbankCaOrgnum(String d7CellNbankCaOrgnum) {
		this.d7CellNbankCaOrgnum = d7CellNbankCaOrgnum;
	}

	public void setD7CellNbankCfOrgnum(String d7CellNbankCfOrgnum) {
		this.d7CellNbankCfOrgnum = d7CellNbankCfOrgnum;
	}

	public void setD7CellNbankComOrgnum(String d7CellNbankComOrgnum) {
		this.d7CellNbankComOrgnum = d7CellNbankComOrgnum;
	}

	public void setD7CellNbankOthOrgnum(String d7CellNbankOthOrgnum) {
		this.d7CellNbankOthOrgnum = d7CellNbankOthOrgnum;
	}

	public void setD7CellNbankNsloanOrgnum(String d7CellNbankNsloanOrgnum) {
		this.d7CellNbankNsloanOrgnum = d7CellNbankNsloanOrgnum;
	}

	public void setD7CellNbankAutofinOrgnum(String d7CellNbankAutofinOrgnum) {
		this.d7CellNbankAutofinOrgnum = d7CellNbankAutofinOrgnum;
	}

	public void setD7CellNbankSloanOrgnum(String d7CellNbankSloanOrgnum) {
		this.d7CellNbankSloanOrgnum = d7CellNbankSloanOrgnum;
	}

	public void setD7CellNbankConsOrgnum(String d7CellNbankConsOrgnum) {
		this.d7CellNbankConsOrgnum = d7CellNbankConsOrgnum;
	}

	public void setD7CellNbankFinleaOrgnum(String d7CellNbankFinleaOrgnum) {
		this.d7CellNbankFinleaOrgnum = d7CellNbankFinleaOrgnum;
	}

	public void setD7CellNbankElseOrgnum(String d7CellNbankElseOrgnum) {
		this.d7CellNbankElseOrgnum = d7CellNbankElseOrgnum;
	}

	public void setD7CellNbankWeekAllnum(String d7CellNbankWeekAllnum) {
		this.d7CellNbankWeekAllnum = d7CellNbankWeekAllnum;
	}

	public void setD7CellNbankWeekOrgnum(String d7CellNbankWeekOrgnum) {
		this.d7CellNbankWeekOrgnum = d7CellNbankWeekOrgnum;
	}

	public void setD7CellNbankNightAllnum(String d7CellNbankNightAllnum) {
		this.d7CellNbankNightAllnum = d7CellNbankNightAllnum;
	}

	public void setD7CellNbankNightOrgnum(String d7CellNbankNightOrgnum) {
		this.d7CellNbankNightOrgnum = d7CellNbankNightOrgnum;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getTrnKey() {
		return trnKey;
	}

	public void setTrnKey(String trnKey) {
		this.trnKey = trnKey;
	}

}
