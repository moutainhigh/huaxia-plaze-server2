package com.huaxia.plaze.modules.bairong.domain;

import java.util.Date;

/**
 * 百融多头借贷3个月内的相关数据
 * 
 * @author Liuwei
 */
public class ApplyLoanStrMonth3 {
	
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

	// 按身份证号查询，近3个月申请最大间隔天数
	private String m3IdMaxInteday;

	// 按身份证号查询，近3个月申请最小间隔天数
	private String m3IdMinInteday;

	// 按身份证号查询，近3个月有申请记录月份数
	private String m3IdTotMons;

	// 按身份证号查询，近3个月平均每月申请次数(有申请月份平均)
	private String m3IdAvgMonnum;

	// 按身份证号查询，近3个月最大月申请次数
	private String m3IdMaxMonnum;

	// 按身份证号查询，近3个月最小月申请次数
	private String m3IdMinMonnum;

	// 按身份证号查询，近3个月申请线上小额现金贷的次数
	private String m3IdPdlAllnum;

	// 按身份证号查询，近3个月申请线上小额现金贷的机构数
	private String m3IdPdlOrgnum;

	// 按身份证号查询，近3个月申请线上现金分期的次数
	private String m3IdCaonAllnum;

	// 按身份证号查询，近3个月申请线上现金分期的机构数
	private String m3IdCaonOrgnum;

	// 按身份证号查询，近3个月申请信用卡（类信用卡）的次数
	private String m3IdRelAllnum;

	// 按身份证号查询，近3个月申请信用卡（类信用卡）的机构数
	private String m3IdRelOrgnum;

	// 按身份证号查询，近3个月申请线下现金分期的次数
	private String m3IdCaoffAllnum;

	// 按身份证号查询，近3个月申请线下现金分期的机构数
	private String m3IdCaoffOrgnum;

	// 按身份证号查询，近3个月申请线下消费分期的次数
	private String m3IdCooffAllnum;

	// 按身份证号查询，近3个月申请线下消费分期的机构数
	private String m3IdCooffOrgnum;

	// 按身份证号查询，近3个月申请汽车金融的次数
	private String m3IdAfAllnum;

	// 按身份证号查询，近3个月申请汽车金融的机构数
	private String m3IdAfOrgnum;

	// 按身份证号查询，近3个月申请线上消费分期的次数
	private String m3IdCoonAllnum;

	// 按身份证号查询，近3个月申请线上消费分期的机构数
	private String m3IdCoonOrgnum;

	// 按身份证号查询，近3个月申请其他的次数
	private String m3IdOthAllnum;

	// 按身份证号查询，近3个月申请其他的机构数
	private String m3IdOthOrgnum;

	// 按身份证号查询，近3个月在本机构(本机构为银行)的申请次数
	private String m3IdBankSelfnum;

	// 按身份证号查询，近3个月在银行机构申请次数
	private String m3IdBankAllnum;

	// 按身份证号查询，近3个月在银行机构-传统银行申请次数
	private String m3IdBankTraAllnum;

	// 按身份证号查询，近3个月在银行机构-网络零售银行申请次数
	private String m3IdBankRetAllnum;

	// 按身份证号查询，近3个月在银行机构申请机构数
	private String m3IdBankOrgnum;

	// 按身份证号查询，近3个月在银行机构-传统银行申请机构数
	private String m3IdBankTraOrgnum;

	// 按身份证号查询，近3个月在银行机构-网络零售银行申请机构数
	private String m3IdBankRetOrgnum;

	// 按身份证号查询，近3个月在银行机构有申请记录月份数
	private String m3IdBankTotMons;

	// 按身份证号查询，近3个月在银行机构平均每月申请次数(有申请月份平均)
	private String m3IdBankAvgMonnum;

	// 按身份证号查询，近3个月在银行机构最大月申请次数
	private String m3IdBankMaxMonnum;

	// 按身份证号查询，近3个月在银行机构最小月申请次数
	private String m3IdBankMinMonnum;

	// 按身份证号查询，近3个月在银行机构申请最大间隔天数
	private String m3IdBankMaxInteday;

	// 按身份证号查询，近3个月在银行机构申请最小间隔天数
	private String m3IdBankMinInteday;

	// 按身份证号查询，近3个月在银行机构周末申请次数
	private String m3IdBankWeekAllnum;

	// 按身份证号查询，近3个月在银行机构周末申请机构数
	private String m3IdBankWeekOrgnum;

	// 按身份证号查询，近3个月在银行机构夜间申请次数
	private String m3IdBankNightAllnum;

	// 按身份证号查询，近3个月在银行机构夜间申请机构数
	private String m3IdBankNightOrgnum;

	// 按身份证号查询，近3个月在本机构(本机构为非银)申请次数
	private String m3IdNbankSelfnum;

	// 按身份证号查询，近3个月在非银机构申请次数
	private String m3IdNbankAllnum;

	// 按身份证号查询，近3个月在非银机构-p2p机构申请次数
	private String m3IdNbankP2pAllnum;

	// 按身份证号查询，近3个月在非银机构-小贷机构申请次数
	private String m3IdNbankMcAllnum;

	// 按身份证号查询，近3个月在非银机构-现金类分期机构申请次数
	private String m3IdNbankCaAllnum;

	// 按身份证号查询，近3个月在非银机构-消费类分期机构申请次数
	private String m3IdNbankCfAllnum;

	// 按身份证号查询，近3个月在非银机构-代偿类分期机构申请次数
	private String m3IdNbankComAllnum;

	// 按身份证号查询，近3个月在非银机构-其他申请次数
	private String m3IdNbankOthAllnum;

	// 按身份证号查询，近3个月在非银机构-持牌网络小贷机构申请次数
	private String m3IdNbankNsloanAllnum;

	// 按身份证号查询，近3个月在非银机构-持牌汽车金融机构申请次数
	private String m3IdNbankAutofinAllnum;

	// 按身份证号查询，近3个月在非银机构-持牌小贷机构申请次数
	private String m3IdNbankSloanAllnum;

	// 按身份证号查询，近3个月在非银机构-持牌消费金融机构申请次数
	private String m3IdNbankConsAllnum;

	// 按身份证号查询，近3个月在非银机构-持牌融资租赁机构申请次数
	private String m3IdNbankFinleaAllnum;

	// 按身份证号查询，近3个月在非银机构-其他申请次数
	private String m3IdNbankElseAllnum;

	// 按身份证号查询，近3个月在非银机构申请机构数
	private String m3IdNbankOrgnum;

	// 按身份证号查询，近3个月在非银机构-p2p申请机构数
	private String m3IdNbankP2pOrgnum;

	// 按身份证号查询，近3个月在非银机构-小贷申请机构数
	private String m3IdNbankMcOrgnum;

	// 按身份证号查询，近3个月在非银机构-现金类分期申请机构数
	private String m3IdNbankCaOrgnum;

	// 按身份证号查询，近3个月在非银机构-消费类分期申请机构数
	private String m3IdNbankCfOrgnum;

	// 按身份证号查询，近3个月在非银机构-代偿类分期申请机构数
	private String m3IdNbankComOrgnum;

	// 按身份证号查询，近3个月在非银机构-其他申请机构数
	private String m3IdNbankOthOrgnum;

	// 按身份证号查询，近3个月在非银机构-持牌网络小贷机构申请机构数
	private String m3IdNbankNsloanOrgnum;

	// 按身份证号查询，近3个月在非银机构-持牌汽车金融机构申请机构数
	private String m3IdNbankAutofinOrgnum;

	// 按身份证号查询，近3个月在非银机构-持牌小贷机构申请机构数
	private String m3IdNbankSloanOrgnum;

	// 按身份证号查询，近3个月在非银机构-持牌消费金融机构申请机构数
	private String m3IdNbankConsOrgnum;

	// 按身份证号查询，近3个月在非银机构-持牌融资租赁机构申请机构数
	private String m3IdNbankFinleaOrgnum;

	// 按身份证号查询，近3个月在非银机构-其他申请机构数
	private String m3IdNbankElseOrgnum;

	// 按身份证号查询，近3个月在非银机构有申请记录月份数
	private String m3IdNbankTotMons;

	// 按身份证号查询，近3个月在非银机构平均每月申请次数(有申请月份平均)
	private String m3IdNbankAvgMonnum;

	// 按身份证号查询，近3个月在非银机构最大月申请次数
	private String m3IdNbankMaxMonnum;

	// 按身份证号查询，近3个月在非银机构最小月申请次数
	private String m3IdNbankMinMonnum;

	// 按身份证号查询，近3个月在非银机构申请最大间隔天数
	private String m3IdNbankMaxInteday;

	// 按身份证号查询，近3个月在非银机构申请最小间隔天数
	private String m3IdNbankMinInteday;

	// 按身份证号查询，近3个月在非银机构周末申请次数
	private String m3IdNbankWeekAllnum;

	// 按身份证号查询，近3个月在非银机构周末申请机构数
	private String m3IdNbankWeekOrgnum;

	// 按身份证号查询，近3个月在非银机构夜间申请次数
	private String m3IdNbankNightAllnum;

	// 按身份证号查询，近3个月在非银机构夜间申请机构数
	private String m3IdNbankNightOrgnum;

	// 按手机号查询，近3个月申请最大间隔天数
	private String m3CellMaxInteday;

	// 按手机号查询，近3个月申请最小间隔天数
	private String m3CellMinInteday;

	// 按手机号查询，近3个月有申请记录月份数
	private String m3CellTotMons;

	// 按手机号查询，近3个月平均每月申请次数(有申请月份平均)
	private String m3CellAvgMonnum;

	// 按手机号查询，近3个月最大月申请次数
	private String m3CellMaxMonnum;

	// 按手机号查询，近3个月最小月申请次数
	private String m3CellMinMonnum;

	// 按手机号查询，近3个月申请线上小额现金贷的次数
	private String m3CellPdlAllnum;

	// 按手机号查询，近3个月申请线上小额现金贷的机构数
	private String m3CellPdlOrgnum;

	// 按手机号查询，近3个月申请线上现金分期的次数
	private String m3CellCaonAllnum;

	// 按手机号查询，近3个月申请线上现金分期的机构数
	private String m3CellCaonOrgnum;

	// 按手机号查询，近3个月申请信用卡（类信用卡）的次数
	private String m3CellRelAllnum;

	// 按手机号查询，近3个月申请信用卡（类信用卡）的机构数
	private String m3CellRelOrgnum;

	// 按手机号查询，近3个月申请线下现金分期的次数
	private String m3CellCaoffAllnum;

	// 按手机号查询，近3个月申请线下现金分期的机构数
	private String m3CellCaoffOrgnum;

	// 按手机号查询，近3个月申请线下消费分期的次数
	private String m3CellCooffAllnum;

	// 按手机号查询，近3个月申请线下消费分期的机构数
	private String m3CellCooffOrgnum;

	// 按手机号查询，近3个月申请汽车金融的次数
	private String m3CellAfAllnum;

	// 按手机号查询，近3个月申请汽车金融的机构数
	private String m3CellAfOrgnum;

	// 按手机号查询，近3个月申请线上消费分期的次数
	private String m3CellCoonAllnum;

	// 按手机号查询，近3个月申请线上消费分期的机构数
	private String m3CellCoonOrgnum;

	// 按手机号查询，近3个月申请其他的次数
	private String m3CellOthAllnum;

	// 按手机号查询，近3个月申请其他的机构数
	private String m3CellOthOrgnum;

	// 按手机号查询，近3个月在本机构(本机构为银行)的申请次数
	private String m3CellBankSelfnum;

	// 按手机号查询，近3个月在银行机构申请次数
	private String m3CellBankAllnum;

	// 按手机号查询，近3个月在银行机构-传统银行申请次数
	private String m3CellBankTraAllnum;

	// 按手机号查询，近3个月在银行机构-网络零售银行申请次数
	private String m3CellBankRetAllnum;

	// 按手机号查询，近3个月在银行机构申请机构数
	private String m3CellBankOrgnum;

	// 按手机号查询，近3个月在银行机构-传统银行申请机构数
	private String m3CellBankTraOrgnum;

	// 按手机号查询，近3个月在银行机构-网络零售银行申请机构数
	private String m3CellBankRetOrgnum;

	// 按手机号查询，近3个月在银行机构有申请记录月份数
	private String m3CellBankTotMons;

	// 按手机号查询，近3个月在银行机构平均每月申请次数(有申请月份平均)
	private String m3CellBankAvgMonnum;

	// 按手机号查询，近3个月在银行机构最大月申请次数
	private String m3CellBankMaxMonnum;

	// 按手机号查询，近3个月在银行机构最小月申请次数
	private String m3CellBankMinMonnum;

	// 按手机号查询，近3个月在银行机构申请最大间隔天数
	private String m3CellBankMaxInteday;

	// 按手机号查询，近3个月在银行机构申请最小间隔天数
	private String m3CellBankMinInteday;

	// 按手机号查询，近3个月在银行机构周末申请次数
	private String m3CellBankWeekAllnum;

	// 按手机号查询，近3个月在银行机构周末申请机构数
	private String m3CellBankWeekOrgnum;

	// 按手机号查询，近3个月在银行机构夜间申请次数
	private String m3CellBankNightAllnum;

	// 按手机号查询，近3个月在银行机构夜间申请机构数
	private String m3CellBankNightOrgnum;

	// 按手机号查询，近3个月在本机构(本机构为非银)申请次数
	private String m3CellNbankSelfnum;

	// 按手机号查询，近3个月在非银机构申请次数
	private String m3CellNbankAllnum;

	// 按手机号查询，近3个月在非银机构-p2p机构申请次数
	private String m3CellNbankP2pAllnum;

	// 按手机号查询，近3个月在非银机构-小贷机构申请次数
	private String m3CellNbankMcAllnum;

	// 按手机号查询，近3个月在非银机构-现金类分期机构申请次数
	private String m3CellNbankCaAllnum;

	// 按手机号查询，近3个月在非银机构-消费类分期机构申请次数
	private String m3CellNbankCfAllnum;

	// 按手机号查询，近3个月在非银机构-代偿类分期机构申请次数
	private String m3CellNbankComAllnum;

	// 按手机号查询，近3个月在非银机构-其他申请次数
	private String m3CellNbankOthAllnum;

	// 按手机号查询，近3个月在非银机构-持牌网络小贷机构申请次数
	private String m3CellNbankNsloanAllnum;

	// 按手机号查询，近3个月在非银机构-持牌汽车金融机构申请次数
	private String m3CellNbankAutofinAllnum;

	// 按手机号查询，近3个月在非银机构-持牌小贷机构申请次数
	private String m3CellNbankSloanAllnum;

	// 按手机号查询，近3个月在非银机构-持牌消费金融机构申请次数
	private String m3CellNbankConsAllnum;

	// 按手机号查询，近3个月在非银机构-持牌融资租赁机构申请次数
	private String m3CellNbankFinleaAllnum;

	// 按手机号查询，近3个月在非银机构-其他申请次数
	private String m3CellNbankElseAllnum;

	// 按手机号查询，近3个月在非银机构申请机构数
	private String m3CellNbankOrgnum;

	// 按手机号查询，近3个月在非银机构-p2p申请机构数
	private String m3CellNbankP2pOrgnum;

	// 按手机号查询，近3个月在非银机构-小贷申请机构数
	private String m3CellNbankMcOrgnum;

	// 按手机号查询，近3个月在非银机构-现金类分期申请机构数
	private String m3CellNbankCaOrgnum;

	// 按手机号查询，近3个月在非银机构-消费类分期申请机构数
	private String m3CellNbankCfOrgnum;

	// 按手机号查询，近3个月在非银机构-代偿类分期申请机构数
	private String m3CellNbankComOrgnum;

	// 按手机号查询，近3个月在非银机构-其他申请机构数
	private String m3CellNbankOthOrgnum;

	// 按手机号查询，近3个月在非银机构-持牌网络小贷机构申请机构数
	private String m3CellNbankNsloanOrgnum;

	// 按手机号查询，近3个月在非银机构-持牌汽车金融机构申请机构数
	private String m3CellNbankAutofinOrgnum;

	// 按手机号查询，近3个月在非银机构-持牌小贷机构申请机构数
	private String m3CellNbankSloanOrgnum;

	// 按手机号查询，近3个月在非银机构-持牌消费金融机构申请机构数
	private String m3CellNbankConsOrgnum;

	// 按手机号查询，近3个月在非银机构-持牌融资租赁机构申请机构数
	private String m3CellNbankFinleaOrgnum;

	// 按手机号查询，近3个月在非银机构-其他申请机构数
	private String m3CellNbankElseOrgnum;

	// 按手机号查询，近3个月在非银机构有申请记录月份数
	private String m3CellNbankTotMons;

	// 按手机号查询，近3个月在非银机构平均每月申请次数(有申请月份平均)
	private String m3CellNbankAvgMonnum;

	// 按手机号查询，近3个月在非银机构最大月申请次数
	private String m3CellNbankMaxMonnum;

	// 按手机号查询，近3个月在非银机构最小月申请次数
	private String m3CellNbankMinMonnum;

	// 按手机号查询，近3个月在非银机构申请最大间隔天数
	private String m3CellNbankMaxInteday;

	// 按手机号查询，近3个月在非银机构申请最小间隔天数
	private String m3CellNbankMinInteday;

	// 按手机号查询，近3个月在非银机构周末申请次数
	private String m3CellNbankWeekAllnum;

	// 按手机号查询，近3个月在非银机构周末申请机构数
	private String m3CellNbankWeekOrgnum;

	// 按手机号查询，近3个月在非银机构夜间申请次数
	private String m3CellNbankNightAllnum;

	// 按手机号查询，近3个月在非银机构夜间申请机构数
	private String m3CellNbankNightOrgnum;

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

	public String getM3IdMaxInteday() {
		return m3IdMaxInteday;
	}

	public String getM3IdMinInteday() {
		return m3IdMinInteday;
	}

	public String getM3IdTotMons() {
		return m3IdTotMons;
	}

	public String getM3IdAvgMonnum() {
		return m3IdAvgMonnum;
	}

	public String getM3IdMaxMonnum() {
		return m3IdMaxMonnum;
	}

	public String getM3IdMinMonnum() {
		return m3IdMinMonnum;
	}

	public String getM3IdPdlAllnum() {
		return m3IdPdlAllnum;
	}

	public String getM3IdPdlOrgnum() {
		return m3IdPdlOrgnum;
	}

	public String getM3IdCaonAllnum() {
		return m3IdCaonAllnum;
	}

	public String getM3IdCaonOrgnum() {
		return m3IdCaonOrgnum;
	}

	public String getM3IdRelAllnum() {
		return m3IdRelAllnum;
	}

	public String getM3IdRelOrgnum() {
		return m3IdRelOrgnum;
	}

	public String getM3IdCaoffAllnum() {
		return m3IdCaoffAllnum;
	}

	public String getM3IdCaoffOrgnum() {
		return m3IdCaoffOrgnum;
	}

	public String getM3IdCooffAllnum() {
		return m3IdCooffAllnum;
	}

	public String getM3IdCooffOrgnum() {
		return m3IdCooffOrgnum;
	}

	public String getM3IdAfAllnum() {
		return m3IdAfAllnum;
	}

	public String getM3IdAfOrgnum() {
		return m3IdAfOrgnum;
	}

	public String getM3IdCoonAllnum() {
		return m3IdCoonAllnum;
	}

	public String getM3IdCoonOrgnum() {
		return m3IdCoonOrgnum;
	}

	public String getM3IdOthAllnum() {
		return m3IdOthAllnum;
	}

	public String getM3IdOthOrgnum() {
		return m3IdOthOrgnum;
	}

	public String getM3IdBankSelfnum() {
		return m3IdBankSelfnum;
	}

	public String getM3IdBankAllnum() {
		return m3IdBankAllnum;
	}

	public String getM3IdBankTraAllnum() {
		return m3IdBankTraAllnum;
	}

	public String getM3IdBankRetAllnum() {
		return m3IdBankRetAllnum;
	}

	public String getM3IdBankOrgnum() {
		return m3IdBankOrgnum;
	}

	public String getM3IdBankTraOrgnum() {
		return m3IdBankTraOrgnum;
	}

	public String getM3IdBankRetOrgnum() {
		return m3IdBankRetOrgnum;
	}

	public String getM3IdBankTotMons() {
		return m3IdBankTotMons;
	}

	public String getM3IdBankAvgMonnum() {
		return m3IdBankAvgMonnum;
	}

	public String getM3IdBankMaxMonnum() {
		return m3IdBankMaxMonnum;
	}

	public String getM3IdBankMinMonnum() {
		return m3IdBankMinMonnum;
	}

	public String getM3IdBankMaxInteday() {
		return m3IdBankMaxInteday;
	}

	public String getM3IdBankMinInteday() {
		return m3IdBankMinInteday;
	}

	public String getM3IdBankWeekAllnum() {
		return m3IdBankWeekAllnum;
	}

	public String getM3IdBankWeekOrgnum() {
		return m3IdBankWeekOrgnum;
	}

	public String getM3IdBankNightAllnum() {
		return m3IdBankNightAllnum;
	}

	public String getM3IdBankNightOrgnum() {
		return m3IdBankNightOrgnum;
	}

	public String getM3IdNbankSelfnum() {
		return m3IdNbankSelfnum;
	}

	public String getM3IdNbankAllnum() {
		return m3IdNbankAllnum;
	}

	public String getM3IdNbankP2pAllnum() {
		return m3IdNbankP2pAllnum;
	}

	public String getM3IdNbankMcAllnum() {
		return m3IdNbankMcAllnum;
	}

	public String getM3IdNbankCaAllnum() {
		return m3IdNbankCaAllnum;
	}

	public String getM3IdNbankCfAllnum() {
		return m3IdNbankCfAllnum;
	}

	public String getM3IdNbankComAllnum() {
		return m3IdNbankComAllnum;
	}

	public String getM3IdNbankOthAllnum() {
		return m3IdNbankOthAllnum;
	}

	public String getM3IdNbankNsloanAllnum() {
		return m3IdNbankNsloanAllnum;
	}

	public String getM3IdNbankAutofinAllnum() {
		return m3IdNbankAutofinAllnum;
	}

	public String getM3IdNbankSloanAllnum() {
		return m3IdNbankSloanAllnum;
	}

	public String getM3IdNbankConsAllnum() {
		return m3IdNbankConsAllnum;
	}

	public String getM3IdNbankFinleaAllnum() {
		return m3IdNbankFinleaAllnum;
	}

	public String getM3IdNbankElseAllnum() {
		return m3IdNbankElseAllnum;
	}

	public String getM3IdNbankOrgnum() {
		return m3IdNbankOrgnum;
	}

	public String getM3IdNbankP2pOrgnum() {
		return m3IdNbankP2pOrgnum;
	}

	public String getM3IdNbankMcOrgnum() {
		return m3IdNbankMcOrgnum;
	}

	public String getM3IdNbankCaOrgnum() {
		return m3IdNbankCaOrgnum;
	}

	public String getM3IdNbankCfOrgnum() {
		return m3IdNbankCfOrgnum;
	}

	public String getM3IdNbankComOrgnum() {
		return m3IdNbankComOrgnum;
	}

	public String getM3IdNbankOthOrgnum() {
		return m3IdNbankOthOrgnum;
	}

	public String getM3IdNbankNsloanOrgnum() {
		return m3IdNbankNsloanOrgnum;
	}

	public String getM3IdNbankAutofinOrgnum() {
		return m3IdNbankAutofinOrgnum;
	}

	public String getM3IdNbankSloanOrgnum() {
		return m3IdNbankSloanOrgnum;
	}

	public String getM3IdNbankConsOrgnum() {
		return m3IdNbankConsOrgnum;
	}

	public String getM3IdNbankFinleaOrgnum() {
		return m3IdNbankFinleaOrgnum;
	}

	public String getM3IdNbankElseOrgnum() {
		return m3IdNbankElseOrgnum;
	}

	public String getM3IdNbankTotMons() {
		return m3IdNbankTotMons;
	}

	public String getM3IdNbankAvgMonnum() {
		return m3IdNbankAvgMonnum;
	}

	public String getM3IdNbankMaxMonnum() {
		return m3IdNbankMaxMonnum;
	}

	public String getM3IdNbankMinMonnum() {
		return m3IdNbankMinMonnum;
	}

	public String getM3IdNbankMaxInteday() {
		return m3IdNbankMaxInteday;
	}

	public String getM3IdNbankMinInteday() {
		return m3IdNbankMinInteday;
	}

	public String getM3IdNbankWeekAllnum() {
		return m3IdNbankWeekAllnum;
	}

	public String getM3IdNbankWeekOrgnum() {
		return m3IdNbankWeekOrgnum;
	}

	public String getM3IdNbankNightAllnum() {
		return m3IdNbankNightAllnum;
	}

	public String getM3IdNbankNightOrgnum() {
		return m3IdNbankNightOrgnum;
	}

	public String getM3CellMaxInteday() {
		return m3CellMaxInteday;
	}

	public String getM3CellMinInteday() {
		return m3CellMinInteday;
	}

	public String getM3CellTotMons() {
		return m3CellTotMons;
	}

	public String getM3CellAvgMonnum() {
		return m3CellAvgMonnum;
	}

	public String getM3CellMaxMonnum() {
		return m3CellMaxMonnum;
	}

	public String getM3CellMinMonnum() {
		return m3CellMinMonnum;
	}

	public String getM3CellPdlAllnum() {
		return m3CellPdlAllnum;
	}

	public String getM3CellPdlOrgnum() {
		return m3CellPdlOrgnum;
	}

	public String getM3CellCaonAllnum() {
		return m3CellCaonAllnum;
	}

	public String getM3CellCaonOrgnum() {
		return m3CellCaonOrgnum;
	}

	public String getM3CellRelAllnum() {
		return m3CellRelAllnum;
	}

	public String getM3CellRelOrgnum() {
		return m3CellRelOrgnum;
	}

	public String getM3CellCaoffAllnum() {
		return m3CellCaoffAllnum;
	}

	public String getM3CellCaoffOrgnum() {
		return m3CellCaoffOrgnum;
	}

	public String getM3CellCooffAllnum() {
		return m3CellCooffAllnum;
	}

	public String getM3CellCooffOrgnum() {
		return m3CellCooffOrgnum;
	}

	public String getM3CellAfAllnum() {
		return m3CellAfAllnum;
	}

	public String getM3CellAfOrgnum() {
		return m3CellAfOrgnum;
	}

	public String getM3CellCoonAllnum() {
		return m3CellCoonAllnum;
	}

	public String getM3CellCoonOrgnum() {
		return m3CellCoonOrgnum;
	}

	public String getM3CellOthAllnum() {
		return m3CellOthAllnum;
	}

	public String getM3CellOthOrgnum() {
		return m3CellOthOrgnum;
	}

	public String getM3CellBankSelfnum() {
		return m3CellBankSelfnum;
	}

	public String getM3CellBankAllnum() {
		return m3CellBankAllnum;
	}

	public String getM3CellBankTraAllnum() {
		return m3CellBankTraAllnum;
	}

	public String getM3CellBankRetAllnum() {
		return m3CellBankRetAllnum;
	}

	public String getM3CellBankOrgnum() {
		return m3CellBankOrgnum;
	}

	public String getM3CellBankTraOrgnum() {
		return m3CellBankTraOrgnum;
	}

	public String getM3CellBankRetOrgnum() {
		return m3CellBankRetOrgnum;
	}

	public String getM3CellBankTotMons() {
		return m3CellBankTotMons;
	}

	public String getM3CellBankAvgMonnum() {
		return m3CellBankAvgMonnum;
	}

	public String getM3CellBankMaxMonnum() {
		return m3CellBankMaxMonnum;
	}

	public String getM3CellBankMinMonnum() {
		return m3CellBankMinMonnum;
	}

	public String getM3CellBankMaxInteday() {
		return m3CellBankMaxInteday;
	}

	public String getM3CellBankMinInteday() {
		return m3CellBankMinInteday;
	}

	public String getM3CellBankWeekAllnum() {
		return m3CellBankWeekAllnum;
	}

	public String getM3CellBankWeekOrgnum() {
		return m3CellBankWeekOrgnum;
	}

	public String getM3CellBankNightAllnum() {
		return m3CellBankNightAllnum;
	}

	public String getM3CellBankNightOrgnum() {
		return m3CellBankNightOrgnum;
	}

	public String getM3CellNbankSelfnum() {
		return m3CellNbankSelfnum;
	}

	public String getM3CellNbankAllnum() {
		return m3CellNbankAllnum;
	}

	public String getM3CellNbankP2pAllnum() {
		return m3CellNbankP2pAllnum;
	}

	public String getM3CellNbankMcAllnum() {
		return m3CellNbankMcAllnum;
	}

	public String getM3CellNbankCaAllnum() {
		return m3CellNbankCaAllnum;
	}

	public String getM3CellNbankCfAllnum() {
		return m3CellNbankCfAllnum;
	}

	public String getM3CellNbankComAllnum() {
		return m3CellNbankComAllnum;
	}

	public String getM3CellNbankOthAllnum() {
		return m3CellNbankOthAllnum;
	}

	public String getM3CellNbankNsloanAllnum() {
		return m3CellNbankNsloanAllnum;
	}

	public String getM3CellNbankAutofinAllnum() {
		return m3CellNbankAutofinAllnum;
	}

	public String getM3CellNbankSloanAllnum() {
		return m3CellNbankSloanAllnum;
	}

	public String getM3CellNbankConsAllnum() {
		return m3CellNbankConsAllnum;
	}

	public String getM3CellNbankFinleaAllnum() {
		return m3CellNbankFinleaAllnum;
	}

	public String getM3CellNbankElseAllnum() {
		return m3CellNbankElseAllnum;
	}

	public String getM3CellNbankOrgnum() {
		return m3CellNbankOrgnum;
	}

	public String getM3CellNbankP2pOrgnum() {
		return m3CellNbankP2pOrgnum;
	}

	public String getM3CellNbankMcOrgnum() {
		return m3CellNbankMcOrgnum;
	}

	public String getM3CellNbankCaOrgnum() {
		return m3CellNbankCaOrgnum;
	}

	public String getM3CellNbankCfOrgnum() {
		return m3CellNbankCfOrgnum;
	}

	public String getM3CellNbankComOrgnum() {
		return m3CellNbankComOrgnum;
	}

	public String getM3CellNbankOthOrgnum() {
		return m3CellNbankOthOrgnum;
	}

	public String getM3CellNbankNsloanOrgnum() {
		return m3CellNbankNsloanOrgnum;
	}

	public String getM3CellNbankAutofinOrgnum() {
		return m3CellNbankAutofinOrgnum;
	}

	public String getM3CellNbankSloanOrgnum() {
		return m3CellNbankSloanOrgnum;
	}

	public String getM3CellNbankConsOrgnum() {
		return m3CellNbankConsOrgnum;
	}

	public String getM3CellNbankFinleaOrgnum() {
		return m3CellNbankFinleaOrgnum;
	}

	public String getM3CellNbankElseOrgnum() {
		return m3CellNbankElseOrgnum;
	}

	public String getM3CellNbankTotMons() {
		return m3CellNbankTotMons;
	}

	public String getM3CellNbankAvgMonnum() {
		return m3CellNbankAvgMonnum;
	}

	public String getM3CellNbankMaxMonnum() {
		return m3CellNbankMaxMonnum;
	}

	public String getM3CellNbankMinMonnum() {
		return m3CellNbankMinMonnum;
	}

	public String getM3CellNbankMaxInteday() {
		return m3CellNbankMaxInteday;
	}

	public String getM3CellNbankMinInteday() {
		return m3CellNbankMinInteday;
	}

	public String getM3CellNbankWeekAllnum() {
		return m3CellNbankWeekAllnum;
	}

	public String getM3CellNbankWeekOrgnum() {
		return m3CellNbankWeekOrgnum;
	}

	public String getM3CellNbankNightAllnum() {
		return m3CellNbankNightAllnum;
	}

	public String getM3CellNbankNightOrgnum() {
		return m3CellNbankNightOrgnum;
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

	public void setM3IdMaxInteday(String m3IdMaxInteday) {
		this.m3IdMaxInteday = m3IdMaxInteday;
	}

	public void setM3IdMinInteday(String m3IdMinInteday) {
		this.m3IdMinInteday = m3IdMinInteday;
	}

	public void setM3IdTotMons(String m3IdTotMons) {
		this.m3IdTotMons = m3IdTotMons;
	}

	public void setM3IdAvgMonnum(String m3IdAvgMonnum) {
		this.m3IdAvgMonnum = m3IdAvgMonnum;
	}

	public void setM3IdMaxMonnum(String m3IdMaxMonnum) {
		this.m3IdMaxMonnum = m3IdMaxMonnum;
	}

	public void setM3IdMinMonnum(String m3IdMinMonnum) {
		this.m3IdMinMonnum = m3IdMinMonnum;
	}

	public void setM3IdPdlAllnum(String m3IdPdlAllnum) {
		this.m3IdPdlAllnum = m3IdPdlAllnum;
	}

	public void setM3IdPdlOrgnum(String m3IdPdlOrgnum) {
		this.m3IdPdlOrgnum = m3IdPdlOrgnum;
	}

	public void setM3IdCaonAllnum(String m3IdCaonAllnum) {
		this.m3IdCaonAllnum = m3IdCaonAllnum;
	}

	public void setM3IdCaonOrgnum(String m3IdCaonOrgnum) {
		this.m3IdCaonOrgnum = m3IdCaonOrgnum;
	}

	public void setM3IdRelAllnum(String m3IdRelAllnum) {
		this.m3IdRelAllnum = m3IdRelAllnum;
	}

	public void setM3IdRelOrgnum(String m3IdRelOrgnum) {
		this.m3IdRelOrgnum = m3IdRelOrgnum;
	}

	public void setM3IdCaoffAllnum(String m3IdCaoffAllnum) {
		this.m3IdCaoffAllnum = m3IdCaoffAllnum;
	}

	public void setM3IdCaoffOrgnum(String m3IdCaoffOrgnum) {
		this.m3IdCaoffOrgnum = m3IdCaoffOrgnum;
	}

	public void setM3IdCooffAllnum(String m3IdCooffAllnum) {
		this.m3IdCooffAllnum = m3IdCooffAllnum;
	}

	public void setM3IdCooffOrgnum(String m3IdCooffOrgnum) {
		this.m3IdCooffOrgnum = m3IdCooffOrgnum;
	}

	public void setM3IdAfAllnum(String m3IdAfAllnum) {
		this.m3IdAfAllnum = m3IdAfAllnum;
	}

	public void setM3IdAfOrgnum(String m3IdAfOrgnum) {
		this.m3IdAfOrgnum = m3IdAfOrgnum;
	}

	public void setM3IdCoonAllnum(String m3IdCoonAllnum) {
		this.m3IdCoonAllnum = m3IdCoonAllnum;
	}

	public void setM3IdCoonOrgnum(String m3IdCoonOrgnum) {
		this.m3IdCoonOrgnum = m3IdCoonOrgnum;
	}

	public void setM3IdOthAllnum(String m3IdOthAllnum) {
		this.m3IdOthAllnum = m3IdOthAllnum;
	}

	public void setM3IdOthOrgnum(String m3IdOthOrgnum) {
		this.m3IdOthOrgnum = m3IdOthOrgnum;
	}

	public void setM3IdBankSelfnum(String m3IdBankSelfnum) {
		this.m3IdBankSelfnum = m3IdBankSelfnum;
	}

	public void setM3IdBankAllnum(String m3IdBankAllnum) {
		this.m3IdBankAllnum = m3IdBankAllnum;
	}

	public void setM3IdBankTraAllnum(String m3IdBankTraAllnum) {
		this.m3IdBankTraAllnum = m3IdBankTraAllnum;
	}

	public void setM3IdBankRetAllnum(String m3IdBankRetAllnum) {
		this.m3IdBankRetAllnum = m3IdBankRetAllnum;
	}

	public void setM3IdBankOrgnum(String m3IdBankOrgnum) {
		this.m3IdBankOrgnum = m3IdBankOrgnum;
	}

	public void setM3IdBankTraOrgnum(String m3IdBankTraOrgnum) {
		this.m3IdBankTraOrgnum = m3IdBankTraOrgnum;
	}

	public void setM3IdBankRetOrgnum(String m3IdBankRetOrgnum) {
		this.m3IdBankRetOrgnum = m3IdBankRetOrgnum;
	}

	public void setM3IdBankTotMons(String m3IdBankTotMons) {
		this.m3IdBankTotMons = m3IdBankTotMons;
	}

	public void setM3IdBankAvgMonnum(String m3IdBankAvgMonnum) {
		this.m3IdBankAvgMonnum = m3IdBankAvgMonnum;
	}

	public void setM3IdBankMaxMonnum(String m3IdBankMaxMonnum) {
		this.m3IdBankMaxMonnum = m3IdBankMaxMonnum;
	}

	public void setM3IdBankMinMonnum(String m3IdBankMinMonnum) {
		this.m3IdBankMinMonnum = m3IdBankMinMonnum;
	}

	public void setM3IdBankMaxInteday(String m3IdBankMaxInteday) {
		this.m3IdBankMaxInteday = m3IdBankMaxInteday;
	}

	public void setM3IdBankMinInteday(String m3IdBankMinInteday) {
		this.m3IdBankMinInteday = m3IdBankMinInteday;
	}

	public void setM3IdBankWeekAllnum(String m3IdBankWeekAllnum) {
		this.m3IdBankWeekAllnum = m3IdBankWeekAllnum;
	}

	public void setM3IdBankWeekOrgnum(String m3IdBankWeekOrgnum) {
		this.m3IdBankWeekOrgnum = m3IdBankWeekOrgnum;
	}

	public void setM3IdBankNightAllnum(String m3IdBankNightAllnum) {
		this.m3IdBankNightAllnum = m3IdBankNightAllnum;
	}

	public void setM3IdBankNightOrgnum(String m3IdBankNightOrgnum) {
		this.m3IdBankNightOrgnum = m3IdBankNightOrgnum;
	}

	public void setM3IdNbankSelfnum(String m3IdNbankSelfnum) {
		this.m3IdNbankSelfnum = m3IdNbankSelfnum;
	}

	public void setM3IdNbankAllnum(String m3IdNbankAllnum) {
		this.m3IdNbankAllnum = m3IdNbankAllnum;
	}

	public void setM3IdNbankP2pAllnum(String m3IdNbankP2pAllnum) {
		this.m3IdNbankP2pAllnum = m3IdNbankP2pAllnum;
	}

	public void setM3IdNbankMcAllnum(String m3IdNbankMcAllnum) {
		this.m3IdNbankMcAllnum = m3IdNbankMcAllnum;
	}

	public void setM3IdNbankCaAllnum(String m3IdNbankCaAllnum) {
		this.m3IdNbankCaAllnum = m3IdNbankCaAllnum;
	}

	public void setM3IdNbankCfAllnum(String m3IdNbankCfAllnum) {
		this.m3IdNbankCfAllnum = m3IdNbankCfAllnum;
	}

	public void setM3IdNbankComAllnum(String m3IdNbankComAllnum) {
		this.m3IdNbankComAllnum = m3IdNbankComAllnum;
	}

	public void setM3IdNbankOthAllnum(String m3IdNbankOthAllnum) {
		this.m3IdNbankOthAllnum = m3IdNbankOthAllnum;
	}

	public void setM3IdNbankNsloanAllnum(String m3IdNbankNsloanAllnum) {
		this.m3IdNbankNsloanAllnum = m3IdNbankNsloanAllnum;
	}

	public void setM3IdNbankAutofinAllnum(String m3IdNbankAutofinAllnum) {
		this.m3IdNbankAutofinAllnum = m3IdNbankAutofinAllnum;
	}

	public void setM3IdNbankSloanAllnum(String m3IdNbankSloanAllnum) {
		this.m3IdNbankSloanAllnum = m3IdNbankSloanAllnum;
	}

	public void setM3IdNbankConsAllnum(String m3IdNbankConsAllnum) {
		this.m3IdNbankConsAllnum = m3IdNbankConsAllnum;
	}

	public void setM3IdNbankFinleaAllnum(String m3IdNbankFinleaAllnum) {
		this.m3IdNbankFinleaAllnum = m3IdNbankFinleaAllnum;
	}

	public void setM3IdNbankElseAllnum(String m3IdNbankElseAllnum) {
		this.m3IdNbankElseAllnum = m3IdNbankElseAllnum;
	}

	public void setM3IdNbankOrgnum(String m3IdNbankOrgnum) {
		this.m3IdNbankOrgnum = m3IdNbankOrgnum;
	}

	public void setM3IdNbankP2pOrgnum(String m3IdNbankP2pOrgnum) {
		this.m3IdNbankP2pOrgnum = m3IdNbankP2pOrgnum;
	}

	public void setM3IdNbankMcOrgnum(String m3IdNbankMcOrgnum) {
		this.m3IdNbankMcOrgnum = m3IdNbankMcOrgnum;
	}

	public void setM3IdNbankCaOrgnum(String m3IdNbankCaOrgnum) {
		this.m3IdNbankCaOrgnum = m3IdNbankCaOrgnum;
	}

	public void setM3IdNbankCfOrgnum(String m3IdNbankCfOrgnum) {
		this.m3IdNbankCfOrgnum = m3IdNbankCfOrgnum;
	}

	public void setM3IdNbankComOrgnum(String m3IdNbankComOrgnum) {
		this.m3IdNbankComOrgnum = m3IdNbankComOrgnum;
	}

	public void setM3IdNbankOthOrgnum(String m3IdNbankOthOrgnum) {
		this.m3IdNbankOthOrgnum = m3IdNbankOthOrgnum;
	}

	public void setM3IdNbankNsloanOrgnum(String m3IdNbankNsloanOrgnum) {
		this.m3IdNbankNsloanOrgnum = m3IdNbankNsloanOrgnum;
	}

	public void setM3IdNbankAutofinOrgnum(String m3IdNbankAutofinOrgnum) {
		this.m3IdNbankAutofinOrgnum = m3IdNbankAutofinOrgnum;
	}

	public void setM3IdNbankSloanOrgnum(String m3IdNbankSloanOrgnum) {
		this.m3IdNbankSloanOrgnum = m3IdNbankSloanOrgnum;
	}

	public void setM3IdNbankConsOrgnum(String m3IdNbankConsOrgnum) {
		this.m3IdNbankConsOrgnum = m3IdNbankConsOrgnum;
	}

	public void setM3IdNbankFinleaOrgnum(String m3IdNbankFinleaOrgnum) {
		this.m3IdNbankFinleaOrgnum = m3IdNbankFinleaOrgnum;
	}

	public void setM3IdNbankElseOrgnum(String m3IdNbankElseOrgnum) {
		this.m3IdNbankElseOrgnum = m3IdNbankElseOrgnum;
	}

	public void setM3IdNbankTotMons(String m3IdNbankTotMons) {
		this.m3IdNbankTotMons = m3IdNbankTotMons;
	}

	public void setM3IdNbankAvgMonnum(String m3IdNbankAvgMonnum) {
		this.m3IdNbankAvgMonnum = m3IdNbankAvgMonnum;
	}

	public void setM3IdNbankMaxMonnum(String m3IdNbankMaxMonnum) {
		this.m3IdNbankMaxMonnum = m3IdNbankMaxMonnum;
	}

	public void setM3IdNbankMinMonnum(String m3IdNbankMinMonnum) {
		this.m3IdNbankMinMonnum = m3IdNbankMinMonnum;
	}

	public void setM3IdNbankMaxInteday(String m3IdNbankMaxInteday) {
		this.m3IdNbankMaxInteday = m3IdNbankMaxInteday;
	}

	public void setM3IdNbankMinInteday(String m3IdNbankMinInteday) {
		this.m3IdNbankMinInteday = m3IdNbankMinInteday;
	}

	public void setM3IdNbankWeekAllnum(String m3IdNbankWeekAllnum) {
		this.m3IdNbankWeekAllnum = m3IdNbankWeekAllnum;
	}

	public void setM3IdNbankWeekOrgnum(String m3IdNbankWeekOrgnum) {
		this.m3IdNbankWeekOrgnum = m3IdNbankWeekOrgnum;
	}

	public void setM3IdNbankNightAllnum(String m3IdNbankNightAllnum) {
		this.m3IdNbankNightAllnum = m3IdNbankNightAllnum;
	}

	public void setM3IdNbankNightOrgnum(String m3IdNbankNightOrgnum) {
		this.m3IdNbankNightOrgnum = m3IdNbankNightOrgnum;
	}

	public void setM3CellMaxInteday(String m3CellMaxInteday) {
		this.m3CellMaxInteday = m3CellMaxInteday;
	}

	public void setM3CellMinInteday(String m3CellMinInteday) {
		this.m3CellMinInteday = m3CellMinInteday;
	}

	public void setM3CellTotMons(String m3CellTotMons) {
		this.m3CellTotMons = m3CellTotMons;
	}

	public void setM3CellAvgMonnum(String m3CellAvgMonnum) {
		this.m3CellAvgMonnum = m3CellAvgMonnum;
	}

	public void setM3CellMaxMonnum(String m3CellMaxMonnum) {
		this.m3CellMaxMonnum = m3CellMaxMonnum;
	}

	public void setM3CellMinMonnum(String m3CellMinMonnum) {
		this.m3CellMinMonnum = m3CellMinMonnum;
	}

	public void setM3CellPdlAllnum(String m3CellPdlAllnum) {
		this.m3CellPdlAllnum = m3CellPdlAllnum;
	}

	public void setM3CellPdlOrgnum(String m3CellPdlOrgnum) {
		this.m3CellPdlOrgnum = m3CellPdlOrgnum;
	}

	public void setM3CellCaonAllnum(String m3CellCaonAllnum) {
		this.m3CellCaonAllnum = m3CellCaonAllnum;
	}

	public void setM3CellCaonOrgnum(String m3CellCaonOrgnum) {
		this.m3CellCaonOrgnum = m3CellCaonOrgnum;
	}

	public void setM3CellRelAllnum(String m3CellRelAllnum) {
		this.m3CellRelAllnum = m3CellRelAllnum;
	}

	public void setM3CellRelOrgnum(String m3CellRelOrgnum) {
		this.m3CellRelOrgnum = m3CellRelOrgnum;
	}

	public void setM3CellCaoffAllnum(String m3CellCaoffAllnum) {
		this.m3CellCaoffAllnum = m3CellCaoffAllnum;
	}

	public void setM3CellCaoffOrgnum(String m3CellCaoffOrgnum) {
		this.m3CellCaoffOrgnum = m3CellCaoffOrgnum;
	}

	public void setM3CellCooffAllnum(String m3CellCooffAllnum) {
		this.m3CellCooffAllnum = m3CellCooffAllnum;
	}

	public void setM3CellCooffOrgnum(String m3CellCooffOrgnum) {
		this.m3CellCooffOrgnum = m3CellCooffOrgnum;
	}

	public void setM3CellAfAllnum(String m3CellAfAllnum) {
		this.m3CellAfAllnum = m3CellAfAllnum;
	}

	public void setM3CellAfOrgnum(String m3CellAfOrgnum) {
		this.m3CellAfOrgnum = m3CellAfOrgnum;
	}

	public void setM3CellCoonAllnum(String m3CellCoonAllnum) {
		this.m3CellCoonAllnum = m3CellCoonAllnum;
	}

	public void setM3CellCoonOrgnum(String m3CellCoonOrgnum) {
		this.m3CellCoonOrgnum = m3CellCoonOrgnum;
	}

	public void setM3CellOthAllnum(String m3CellOthAllnum) {
		this.m3CellOthAllnum = m3CellOthAllnum;
	}

	public void setM3CellOthOrgnum(String m3CellOthOrgnum) {
		this.m3CellOthOrgnum = m3CellOthOrgnum;
	}

	public void setM3CellBankSelfnum(String m3CellBankSelfnum) {
		this.m3CellBankSelfnum = m3CellBankSelfnum;
	}

	public void setM3CellBankAllnum(String m3CellBankAllnum) {
		this.m3CellBankAllnum = m3CellBankAllnum;
	}

	public void setM3CellBankTraAllnum(String m3CellBankTraAllnum) {
		this.m3CellBankTraAllnum = m3CellBankTraAllnum;
	}

	public void setM3CellBankRetAllnum(String m3CellBankRetAllnum) {
		this.m3CellBankRetAllnum = m3CellBankRetAllnum;
	}

	public void setM3CellBankOrgnum(String m3CellBankOrgnum) {
		this.m3CellBankOrgnum = m3CellBankOrgnum;
	}

	public void setM3CellBankTraOrgnum(String m3CellBankTraOrgnum) {
		this.m3CellBankTraOrgnum = m3CellBankTraOrgnum;
	}

	public void setM3CellBankRetOrgnum(String m3CellBankRetOrgnum) {
		this.m3CellBankRetOrgnum = m3CellBankRetOrgnum;
	}

	public void setM3CellBankTotMons(String m3CellBankTotMons) {
		this.m3CellBankTotMons = m3CellBankTotMons;
	}

	public void setM3CellBankAvgMonnum(String m3CellBankAvgMonnum) {
		this.m3CellBankAvgMonnum = m3CellBankAvgMonnum;
	}

	public void setM3CellBankMaxMonnum(String m3CellBankMaxMonnum) {
		this.m3CellBankMaxMonnum = m3CellBankMaxMonnum;
	}

	public void setM3CellBankMinMonnum(String m3CellBankMinMonnum) {
		this.m3CellBankMinMonnum = m3CellBankMinMonnum;
	}

	public void setM3CellBankMaxInteday(String m3CellBankMaxInteday) {
		this.m3CellBankMaxInteday = m3CellBankMaxInteday;
	}

	public void setM3CellBankMinInteday(String m3CellBankMinInteday) {
		this.m3CellBankMinInteday = m3CellBankMinInteday;
	}

	public void setM3CellBankWeekAllnum(String m3CellBankWeekAllnum) {
		this.m3CellBankWeekAllnum = m3CellBankWeekAllnum;
	}

	public void setM3CellBankWeekOrgnum(String m3CellBankWeekOrgnum) {
		this.m3CellBankWeekOrgnum = m3CellBankWeekOrgnum;
	}

	public void setM3CellBankNightAllnum(String m3CellBankNightAllnum) {
		this.m3CellBankNightAllnum = m3CellBankNightAllnum;
	}

	public void setM3CellBankNightOrgnum(String m3CellBankNightOrgnum) {
		this.m3CellBankNightOrgnum = m3CellBankNightOrgnum;
	}

	public void setM3CellNbankSelfnum(String m3CellNbankSelfnum) {
		this.m3CellNbankSelfnum = m3CellNbankSelfnum;
	}

	public void setM3CellNbankAllnum(String m3CellNbankAllnum) {
		this.m3CellNbankAllnum = m3CellNbankAllnum;
	}

	public void setM3CellNbankP2pAllnum(String m3CellNbankP2pAllnum) {
		this.m3CellNbankP2pAllnum = m3CellNbankP2pAllnum;
	}

	public void setM3CellNbankMcAllnum(String m3CellNbankMcAllnum) {
		this.m3CellNbankMcAllnum = m3CellNbankMcAllnum;
	}

	public void setM3CellNbankCaAllnum(String m3CellNbankCaAllnum) {
		this.m3CellNbankCaAllnum = m3CellNbankCaAllnum;
	}

	public void setM3CellNbankCfAllnum(String m3CellNbankCfAllnum) {
		this.m3CellNbankCfAllnum = m3CellNbankCfAllnum;
	}

	public void setM3CellNbankComAllnum(String m3CellNbankComAllnum) {
		this.m3CellNbankComAllnum = m3CellNbankComAllnum;
	}

	public void setM3CellNbankOthAllnum(String m3CellNbankOthAllnum) {
		this.m3CellNbankOthAllnum = m3CellNbankOthAllnum;
	}

	public void setM3CellNbankNsloanAllnum(String m3CellNbankNsloanAllnum) {
		this.m3CellNbankNsloanAllnum = m3CellNbankNsloanAllnum;
	}

	public void setM3CellNbankAutofinAllnum(String m3CellNbankAutofinAllnum) {
		this.m3CellNbankAutofinAllnum = m3CellNbankAutofinAllnum;
	}

	public void setM3CellNbankSloanAllnum(String m3CellNbankSloanAllnum) {
		this.m3CellNbankSloanAllnum = m3CellNbankSloanAllnum;
	}

	public void setM3CellNbankConsAllnum(String m3CellNbankConsAllnum) {
		this.m3CellNbankConsAllnum = m3CellNbankConsAllnum;
	}

	public void setM3CellNbankFinleaAllnum(String m3CellNbankFinleaAllnum) {
		this.m3CellNbankFinleaAllnum = m3CellNbankFinleaAllnum;
	}

	public void setM3CellNbankElseAllnum(String m3CellNbankElseAllnum) {
		this.m3CellNbankElseAllnum = m3CellNbankElseAllnum;
	}

	public void setM3CellNbankOrgnum(String m3CellNbankOrgnum) {
		this.m3CellNbankOrgnum = m3CellNbankOrgnum;
	}

	public void setM3CellNbankP2pOrgnum(String m3CellNbankP2pOrgnum) {
		this.m3CellNbankP2pOrgnum = m3CellNbankP2pOrgnum;
	}

	public void setM3CellNbankMcOrgnum(String m3CellNbankMcOrgnum) {
		this.m3CellNbankMcOrgnum = m3CellNbankMcOrgnum;
	}

	public void setM3CellNbankCaOrgnum(String m3CellNbankCaOrgnum) {
		this.m3CellNbankCaOrgnum = m3CellNbankCaOrgnum;
	}

	public void setM3CellNbankCfOrgnum(String m3CellNbankCfOrgnum) {
		this.m3CellNbankCfOrgnum = m3CellNbankCfOrgnum;
	}

	public void setM3CellNbankComOrgnum(String m3CellNbankComOrgnum) {
		this.m3CellNbankComOrgnum = m3CellNbankComOrgnum;
	}

	public void setM3CellNbankOthOrgnum(String m3CellNbankOthOrgnum) {
		this.m3CellNbankOthOrgnum = m3CellNbankOthOrgnum;
	}

	public void setM3CellNbankNsloanOrgnum(String m3CellNbankNsloanOrgnum) {
		this.m3CellNbankNsloanOrgnum = m3CellNbankNsloanOrgnum;
	}

	public void setM3CellNbankAutofinOrgnum(String m3CellNbankAutofinOrgnum) {
		this.m3CellNbankAutofinOrgnum = m3CellNbankAutofinOrgnum;
	}

	public void setM3CellNbankSloanOrgnum(String m3CellNbankSloanOrgnum) {
		this.m3CellNbankSloanOrgnum = m3CellNbankSloanOrgnum;
	}

	public void setM3CellNbankConsOrgnum(String m3CellNbankConsOrgnum) {
		this.m3CellNbankConsOrgnum = m3CellNbankConsOrgnum;
	}

	public void setM3CellNbankFinleaOrgnum(String m3CellNbankFinleaOrgnum) {
		this.m3CellNbankFinleaOrgnum = m3CellNbankFinleaOrgnum;
	}

	public void setM3CellNbankElseOrgnum(String m3CellNbankElseOrgnum) {
		this.m3CellNbankElseOrgnum = m3CellNbankElseOrgnum;
	}

	public void setM3CellNbankTotMons(String m3CellNbankTotMons) {
		this.m3CellNbankTotMons = m3CellNbankTotMons;
	}

	public void setM3CellNbankAvgMonnum(String m3CellNbankAvgMonnum) {
		this.m3CellNbankAvgMonnum = m3CellNbankAvgMonnum;
	}

	public void setM3CellNbankMaxMonnum(String m3CellNbankMaxMonnum) {
		this.m3CellNbankMaxMonnum = m3CellNbankMaxMonnum;
	}

	public void setM3CellNbankMinMonnum(String m3CellNbankMinMonnum) {
		this.m3CellNbankMinMonnum = m3CellNbankMinMonnum;
	}

	public void setM3CellNbankMaxInteday(String m3CellNbankMaxInteday) {
		this.m3CellNbankMaxInteday = m3CellNbankMaxInteday;
	}

	public void setM3CellNbankMinInteday(String m3CellNbankMinInteday) {
		this.m3CellNbankMinInteday = m3CellNbankMinInteday;
	}

	public void setM3CellNbankWeekAllnum(String m3CellNbankWeekAllnum) {
		this.m3CellNbankWeekAllnum = m3CellNbankWeekAllnum;
	}

	public void setM3CellNbankWeekOrgnum(String m3CellNbankWeekOrgnum) {
		this.m3CellNbankWeekOrgnum = m3CellNbankWeekOrgnum;
	}

	public void setM3CellNbankNightAllnum(String m3CellNbankNightAllnum) {
		this.m3CellNbankNightAllnum = m3CellNbankNightAllnum;
	}

	public void setM3CellNbankNightOrgnum(String m3CellNbankNightOrgnum) {
		this.m3CellNbankNightOrgnum = m3CellNbankNightOrgnum;
	}

	public String getTrnKey() {
		return trnKey;
	}

	public void setTrnKey(String trnKey) {
		this.trnKey = trnKey;
	}

}
