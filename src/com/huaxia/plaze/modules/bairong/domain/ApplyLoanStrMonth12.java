package com.huaxia.plaze.modules.bairong.domain;

import java.util.Date;

/**
 * 百融多头借贷的12个月相关数据
 * 
 * @author liuwei
 */
public class ApplyLoanStrMonth12 {
	
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

	// 按身份证号查询，近12个月申请最大间隔天数
	private String m12IdMaxInteday;

	// 按身份证号查询，近12个月申请最小间隔天数
	private String m12IdMinInteday;

	// 按身份证号查询，近12个月有申请记录月份数
	private String m12IdTotMons;

	// 按身份证号查询，近12个月平均每月申请次数(有申请月份平均)
	private String m12IdAvgMonnum;

	// 按身份证号查询，近12个月最大月申请次数
	private String m12IdMaxMonnum;

	// 按身份证号查询，近12个月最小月申请次数
	private String m12IdMinMonnum;

	// 按身份证号查询，近12个月申请线上小额现金贷的次数
	private String m12IdPdlAllnum;

	// 按身份证号查询，近12个月申请线上小额现金贷的机构数
	private String m12IdPdlOrgnum;

	// 按身份证号查询，近12个月申请线上现金分期的次数
	private String m12IdCaonAllnum;

	// 按身份证号查询，近12个月申请线上现金分期的机构数
	private String m12IdCaonOrgnum;

	// 按身份证号查询，近12个月申请信用卡（类信用卡）的次数
	private String m12IdRelAllnum;

	// 按身份证号查询，近12个月申请信用卡（类信用卡）的机构数
	private String m12IdRelOrgnum;

	// 按身份证号查询，近12个月申请线下现金分期的次数
	private String m12IdCaoffAllnum;

	// 按身份证号查询，近12个月申请线下现金分期的机构数
	private String m12IdCaoffOrgnum;

	// 按身份证号查询，近12个月申请线下消费分期的次数
	private String m12IdCooffAllnum;

	// 按身份证号查询，近12个月申请线下消费分期的机构数
	private String m12IdCooffOrgnum;

	// 按身份证号查询，近12个月申请汽车金融的次数
	private String m12IdAfAllnum;

	// 按身份证号查询，近12个月申请汽车金融的机构数
	private String m12IdAfOrgnum;

	// 按身份证号查询，近12个月申请线上消费分期的次数
	private String m12IdCoonAllnum;

	// 按身份证号查询，近12个月申请线上消费分期的机构数
	private String m12IdCoonOrgnum;

	// 按身份证号查询，近12个月申请其他的次数
	private String m12IdOthAllnum;

	// 按身份证号查询，近12个月申请其他的机构数
	private String m12IdOthOrgnum;

	// 按身份证号查询，近12个月在本机构(本机构为银行)的申请次数
	private String m12IdBankSelfnum;

	// 按身份证号查询，近12个月在银行机构申请次数
	private String m12IdBankAllnum;

	// 按身份证号查询，近12个月在银行机构-传统银行申请次数
	private String m12IdBankTraAllnum;

	// 按身份证号查询，近12个月在银行机构-网络零售银行申请次数
	private String m12IdBankRetAllnum;

	// 按身份证号查询，近12个月在银行机构申请机构数
	private String m12IdBankOrgnum;

	// 按身份证号查询，近12个月在银行机构-传统银行申请机构数
	private String m12IdBankTraOrgnum;

	// 按身份证号查询，近12个月在银行机构-网络零售银行申请机构数
	private String m12IdBankRetOrgnum;

	// 按身份证号查询，近12个月在银行机构有申请记录月份数
	private String m12IdBankTotMons;

	// 按身份证号查询，近12个月在银行机构平均每月申请次数(有申请月份平均)
	private String m12IdBankAvgMonnum;

	// 按身份证号查询，近12个月在银行机构最大月申请次数
	private String m12IdBankMaxMonnum;

	// 按身份证号查询，近12个月在银行机构最小月申请次数
	private String m12IdBankMinMonnum;

	// 按身份证号查询，近12个月在银行机构申请最大间隔天数
	private String m12IdBankMaxInteday;

	// 按身份证号查询，近12个月在银行机构申请最小间隔天数
	private String m12IdBankMinInteday;

	// 按身份证号查询，近12个月在银行机构周末申请次数
	private String m12IdBankWeekAllnum;

	// 按身份证号查询，近12个月在银行机构周末申请机构数
	private String m12IdBankWeekOrgnum;

	// 按身份证号查询，近12个月在银行机构夜间申请次数
	private String m12IdBankNightAllnum;

	// 按身份证号查询，近12个月在银行机构夜间申请机构数
	private String m12IdBankNightOrgnum;

	// 按身份证号查询，近12个月在本机构(本机构为非银)申请次数
	private String m12IdNbankSelfnum;

	// 按身份证号查询，近12个月在非银机构申请次数
	private String m12IdNbankAllnum;

	// 按身份证号查询，近12个月在非银机构-p2p机构申请次数
	private String m12IdNbankP2pAllnum;

	// 按身份证号查询，近12个月在非银机构-小贷机构申请次数
	private String m12IdNbankMcAllnum;

	// 按身份证号查询，近12个月在非银机构-现金类分期机构申请次数
	private String m12IdNbankCaAllnum;

	// 按身份证号查询，近12个月在非银机构-消费类分期机构申请次数
	private String m12IdNbankCfAllnum;

	// 按身份证号查询，近12个月在非银机构-代偿类分期机构申请次数
	private String m12IdNbankComAllnum;

	// 按身份证号查询，近12个月在非银机构-其他申请次数
	private String m12IdNbankOthAllnum;

	// 按身份证号查询，近12个月在非银机构-持牌网络小贷机构申请次数
	private String m12IdNbankNsloanAllnum;

	// 按身份证号查询，近12个月在非银机构-持牌汽车金融机构申请次数
	private String m12IdNbankAutofinAllnum;

	// 按身份证号查询，近12个月在非银机构-持牌小贷机构申请次数
	private String m12IdNbankSloanAllnum;

	// 按身份证号查询，近12个月在非银机构-持牌消费金融机构申请次数
	private String m12IdNbankConsAllnum;

	// 按身份证号查询，近12个月在非银机构-持牌融资租赁机构申请次数
	private String m12IdNbankFinleaAllnum;

	// 按身份证号查询，近12个月在非银机构-其他申请次数
	private String m12IdNbankElseAllnum;

	// 按身份证号查询，近12个月在非银机构申请机构数
	private String m12IdNbankOrgnum;

	// 按身份证号查询，近12个月在非银机构-p2p申请机构数
	private String m12IdNbankP2pOrgnum;

	// 按身份证号查询，近12个月在非银机构-小贷申请机构数
	private String m12IdNbankMcOrgnum;

	// 按身份证号查询，近12个月在非银机构-现金类分期申请机构数
	private String m12IdNbankCaOrgnum;

	// 按身份证号查询，近12个月在非银机构-消费类分期申请机构数
	private String m12IdNbankCfOrgnum;

	// 按身份证号查询，近12个月在非银机构-代偿类分期申请机构数
	private String m12IdNbankComOrgnum;

	// 按身份证号查询，近12个月在非银机构-其他申请机构数
	private String m12IdNbankOthOrgnum;

	// 按身份证号查询，近12个月在非银机构-持牌网络小贷机构申请机构数
	private String m12IdNbankNsloanOrgnum;

	// 按身份证号查询，近12个月在非银机构-持牌汽车金融机构申请机构数
	private String m12IdNbankAutofinOrgnum;

	// 按身份证号查询，近12个月在非银机构-持牌小贷机构申请机构数
	private String m12IdNbankSloanOrgnum;

	// 按身份证号查询，近12个月在非银机构-持牌消费金融机构申请机构数
	private String m12IdNbankConsOrgnum;

	// 按身份证号查询，近12个月在非银机构-持牌融资租赁机构申请机构数
	private String m12IdNbankFinleaOrgnum;

	// 按身份证号查询，近12个月在非银机构-其他申请机构数
	private String m12IdNbankElseOrgnum;

	// 按身份证号查询，近12个月在非银机构有申请记录月份数
	private String m12IdNbankTotMons;

	// 按身份证号查询，近12个月在非银机构平均每月申请次数(有申请月份平均)
	private String m12IdNbankAvgMonnum;

	// 按身份证号查询，近12个月在非银机构最大月申请次数
	private String m12IdNbankMaxMonnum;

	// 按身份证号查询，近12个月在非银机构最小月申请次数
	private String m12IdNbankMinMonnum;

	// 按身份证号查询，近12个月在非银机构申请最大间隔天数
	private String m12IdNbankMaxInteday;

	// 按身份证号查询，近12个月在非银机构申请最小间隔天数
	private String m12IdNbankMinInteday;

	// 按身份证号查询，近12个月在非银机构周末申请次数
	private String m12IdNbankWeekAllnum;

	// 按身份证号查询，近12个月在非银机构周末申请机构数
	private String m12IdNbankWeekOrgnum;

	// 按身份证号查询，近12个月在非银机构夜间申请次数
	private String m12IdNbankNightAllnum;

	// 按身份证号查询，近12个月在非银机构夜间申请机构数
	private String m12IdNbankNightOrgnum;

	// 按手机号查询，近12个月申请最大间隔天数
	private String m12CellMaxInteday;

	// 按手机号查询，近12个月申请最小间隔天数
	private String m12CellMinInteday;

	// 按手机号查询，近12个月有申请记录月份数
	private String m12CellTotMons;

	// 按手机号查询，近12个月平均每月申请次数(有申请月份平均)
	private String m12CellAvgMonnum;

	// 按手机号查询，近12个月最大月申请次数
	private String m12CellMaxMonnum;

	// 按手机号查询，近12个月最小月申请次数
	private String m12CellMinMonnum;

	// 按手机号查询，近12个月申请线上小额现金贷的次数
	private String m12CellPdlAllnum;

	// 按手机号查询，近12个月申请线上小额现金贷的机构数
	private String m12CellPdlOrgnum;

	// 按手机号查询，近12个月申请线上现金分期的次数
	private String m12CellCaonAllnum;

	// 按手机号查询，近12个月申请线上现金分期的机构数
	private String m12CellCaonOrgnum;

	// 按手机号查询，近12个月申请信用卡（类信用卡）的次数
	private String m12CellRelAllnum;

	// 按手机号查询，近12个月申请信用卡（类信用卡）的机构数
	private String m12CellRelOrgnum;

	// 按手机号查询，近12个月申请线下现金分期的次数
	private String m12CellCaoffAllnum;

	// 按手机号查询，近12个月申请线下现金分期的机构数
	private String m12CellCaoffOrgnum;

	// 按手机号查询，近12个月申请线下消费分期的次数
	private String m12CellCooffAllnum;

	// 按手机号查询，近12个月申请线下消费分期的机构数
	private String m12CellCooffOrgnum;

	// 按手机号查询，近12个月申请汽车金融的次数
	private String m12CellAfAllnum;

	// 按手机号查询，近12个月申请汽车金融的机构数
	private String m12CellAfOrgnum;

	// 按手机号查询，近12个月申请线上消费分期的次数
	private String m12CellCoonAllnum;

	// 按手机号查询，近12个月申请线上消费分期的机构数
	private String m12CellCoonOrgnum;

	// 按手机号查询，近12个月申请其他的次数
	private String m12CellOthAllnum;

	// 按手机号查询，近12个月申请其他的机构数
	private String m12CellOthOrgnum;

	// 按手机号查询，近12个月在本机构(本机构为银行)的申请次数
	private String m12CellBankSelfnum;

	// 按手机号查询，近12个月在银行机构申请次数
	private String m12CellBankAllnum;

	// 按手机号查询，近12个月在银行机构-传统银行申请次数
	private String m12CellBankTraAllnum;

	// 按手机号查询，近12个月在银行机构-网络零售银行申请次数
	private String m12CellBankRetAllnum;

	// 按手机号查询，近12个月在银行机构申请机构数
	private String m12CellBankOrgnum;

	// 按手机号查询，近12个月在银行机构-传统银行申请机构数
	private String m12CellBankTraOrgnum;

	// 按手机号查询，近12个月在银行机构-网络零售银行申请机构数
	private String m12CellBankRetOrgnum;

	// 按手机号查询，近12个月在银行机构有申请记录月份数
	private String m12CellBankTotMons;

	// 按手机号查询，近12个月在银行机构平均每月申请次数(有申请月份平均)
	private String m12CellBankAvgMonnum;

	// 按手机号查询，近12个月在银行机构最大月申请次数
	private String m12CellBankMaxMonnum;

	// 按手机号查询，近12个月在银行机构最小月申请次数
	private String m12CellBankMinMonnum;

	// 按手机号查询，近12个月在银行机构申请最大间隔天数
	private String m12CellBankMaxInteday;

	// 按手机号查询，近12个月在银行机构申请最小间隔天数
	private String m12CellBankMinInteday;

	// 按手机号查询，近12个月在银行机构周末申请次数
	private String m12CellBankWeekAllnum;

	// 按手机号查询，近12个月在银行机构周末申请机构数
	private String m12CellBankWeekOrgnum;

	// 按手机号查询，近12个月在银行机构夜间申请次数
	private String m12CellBankNightAllnum;

	// 按手机号查询，近12个月在银行机构夜间申请机构数
	private String m12CellBankNightOrgnum;

	// 按手机号查询，近12个月在本机构(本机构为非银)申请次数
	private String m12CellNbankSelfnum;

	// 按手机号查询，近12个月在非银机构申请次数
	private String m12CellNbankAllnum;

	// 按手机号查询，近12个月在非银机构-p2p机构申请次数
	private String m12CellNbankP2pAllnum;

	// 按手机号查询，近12个月在非银机构-小贷机构申请次数
	private String m12CellNbankMcAllnum;

	// 按手机号查询，近12个月在非银机构-现金类分期机构申请次数
	private String m12CellNbankCaAllnum;

	// 按手机号查询，近12个月在非银机构-消费类分期机构申请次数
	private String m12CellNbankCfAllnum;

	// 按手机号查询，近12个月在非银机构-代偿类分期机构申请次数
	private String m12CellNbankComAllnum;

	// 按手机号查询，近12个月在非银机构-其他申请次数
	private String m12CellNbankOthAllnum;

	// 按手机号查询，近12个月在非银机构-持牌网络小贷机构申请次数
	private String m12CellNbankNsloanAllnum;

	// 按手机号查询，近12个月在非银机构-持牌汽车金融机构申请次数
	private String m12CellNbankAutofinAllnum;

	// 按手机号查询，近12个月在非银机构-持牌小贷机构申请次数
	private String m12CellNbankSloanAllnum;

	// 按手机号查询，近12个月在非银机构-持牌消费金融机构申请次数
	private String m12CellNbankConsAllnum;

	// 按手机号查询，近12个月在非银机构-持牌融资租赁机构申请次数
	private String m12CellNbankFinleaAllnum;

	// 按手机号查询，近12个月在非银机构-其他申请次数
	private String m12CellNbankElseAllnum;

	// 按手机号查询，近12个月在非银机构申请机构数
	private String m12CellNbankOrgnum;

	// 按手机号查询，近12个月在非银机构-p2p申请机构数
	private String m12CellNbankP2pOrgnum;

	// 按手机号查询，近12个月在非银机构-小贷申请机构数
	private String m12CellNbankMcOrgnum;

	// 按手机号查询，近12个月在非银机构-现金类分期申请机构数
	private String m12CellNbankCaOrgnum;

	// 按手机号查询，近12个月在非银机构-消费类分期申请机构数
	private String m12CellNbankCfOrgnum;

	// 按手机号查询，近12个月在非银机构-代偿类分期申请机构数
	private String m12CellNbankComOrgnum;

	// 按手机号查询，近12个月在非银机构-其他申请机构数
	private String m12CellNbankOthOrgnum;

	// 按手机号查询，近12个月在非银机构-持牌网络小贷机构申请机构数
	private String m12CellNbankNsloanOrgnum;

	// 按手机号查询，近12个月在非银机构-持牌汽车金融机构申请机构数
	private String m12CellNbankAutofinOrgnum;

	// 按手机号查询，近12个月在非银机构-持牌小贷机构申请机构数
	private String m12CellNbankSloanOrgnum;

	// 按手机号查询，近12个月在非银机构-持牌消费金融机构申请机构数
	private String m12CellNbankConsOrgnum;

	// 按手机号查询，近12个月在非银机构-持牌融资租赁机构申请机构数
	private String m12CellNbankFinleaOrgnum;

	// 按手机号查询，近12个月在非银机构-其他申请机构数
	private String m12CellNbankElseOrgnum;

	// 按手机号查询，近12个月在非银机构有申请记录月份数
	private String m12CellNbankTotMons;

	// 按手机号查询，近12个月在非银机构平均每月申请次数(有申请月份平均)
	private String m12CellNbankAvgMonnum;

	// 按手机号查询，近12个月在非银机构最大月申请次数
	private String m12CellNbankMaxMonnum;

	// 按手机号查询，近12个月在非银机构最小月申请次数
	private String m12CellNbankMinMonnum;

	// 按手机号查询，近12个月在非银机构申请最大间隔天数
	private String m12CellNbankMaxInteday;

	// 按手机号查询，近12个月在非银机构申请最小间隔天数
	private String m12CellNbankMinInteday;

	// 按手机号查询，近12个月在非银机构周末申请次数
	private String m12CellNbankWeekAllnum;

	// 按手机号查询，近12个月在非银机构周末申请机构数
	private String m12CellNbankWeekOrgnum;

	// 按手机号查询，近12个月在非银机构夜间申请次数
	private String m12CellNbankNightAllnum;

	// 按手机号查询，近12个月在非银机构夜间申请机构数
	private String m12CellNbankNightOrgnum;

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

	public String getM12IdMaxInteday() {
		return m12IdMaxInteday;
	}

	public String getM12IdMinInteday() {
		return m12IdMinInteday;
	}

	public String getM12IdTotMons() {
		return m12IdTotMons;
	}

	public String getM12IdAvgMonnum() {
		return m12IdAvgMonnum;
	}

	public String getM12IdMaxMonnum() {
		return m12IdMaxMonnum;
	}

	public String getM12IdMinMonnum() {
		return m12IdMinMonnum;
	}

	public String getM12IdPdlAllnum() {
		return m12IdPdlAllnum;
	}

	public String getM12IdPdlOrgnum() {
		return m12IdPdlOrgnum;
	}

	public String getM12IdCaonAllnum() {
		return m12IdCaonAllnum;
	}

	public String getM12IdCaonOrgnum() {
		return m12IdCaonOrgnum;
	}

	public String getM12IdRelAllnum() {
		return m12IdRelAllnum;
	}

	public String getM12IdRelOrgnum() {
		return m12IdRelOrgnum;
	}

	public String getM12IdCaoffAllnum() {
		return m12IdCaoffAllnum;
	}

	public String getM12IdCaoffOrgnum() {
		return m12IdCaoffOrgnum;
	}

	public String getM12IdCooffAllnum() {
		return m12IdCooffAllnum;
	}

	public String getM12IdCooffOrgnum() {
		return m12IdCooffOrgnum;
	}

	public String getM12IdAfAllnum() {
		return m12IdAfAllnum;
	}

	public String getM12IdAfOrgnum() {
		return m12IdAfOrgnum;
	}

	public String getM12IdCoonAllnum() {
		return m12IdCoonAllnum;
	}

	public String getM12IdCoonOrgnum() {
		return m12IdCoonOrgnum;
	}

	public String getM12IdOthAllnum() {
		return m12IdOthAllnum;
	}

	public String getM12IdOthOrgnum() {
		return m12IdOthOrgnum;
	}

	public String getM12IdBankSelfnum() {
		return m12IdBankSelfnum;
	}

	public String getM12IdBankAllnum() {
		return m12IdBankAllnum;
	}

	public String getM12IdBankTraAllnum() {
		return m12IdBankTraAllnum;
	}

	public String getM12IdBankRetAllnum() {
		return m12IdBankRetAllnum;
	}

	public String getM12IdBankOrgnum() {
		return m12IdBankOrgnum;
	}

	public String getM12IdBankTraOrgnum() {
		return m12IdBankTraOrgnum;
	}

	public String getM12IdBankRetOrgnum() {
		return m12IdBankRetOrgnum;
	}

	public String getM12IdBankTotMons() {
		return m12IdBankTotMons;
	}

	public String getM12IdBankAvgMonnum() {
		return m12IdBankAvgMonnum;
	}

	public String getM12IdBankMaxMonnum() {
		return m12IdBankMaxMonnum;
	}

	public String getM12IdBankMinMonnum() {
		return m12IdBankMinMonnum;
	}

	public String getM12IdBankMaxInteday() {
		return m12IdBankMaxInteday;
	}

	public String getM12IdBankMinInteday() {
		return m12IdBankMinInteday;
	}

	public String getM12IdBankWeekAllnum() {
		return m12IdBankWeekAllnum;
	}

	public String getM12IdBankWeekOrgnum() {
		return m12IdBankWeekOrgnum;
	}

	public String getM12IdBankNightAllnum() {
		return m12IdBankNightAllnum;
	}

	public String getM12IdBankNightOrgnum() {
		return m12IdBankNightOrgnum;
	}

	public String getM12IdNbankSelfnum() {
		return m12IdNbankSelfnum;
	}

	public String getM12IdNbankAllnum() {
		return m12IdNbankAllnum;
	}

	public String getM12IdNbankP2pAllnum() {
		return m12IdNbankP2pAllnum;
	}

	public String getM12IdNbankMcAllnum() {
		return m12IdNbankMcAllnum;
	}

	public String getM12IdNbankCaAllnum() {
		return m12IdNbankCaAllnum;
	}

	public String getM12IdNbankCfAllnum() {
		return m12IdNbankCfAllnum;
	}

	public String getM12IdNbankComAllnum() {
		return m12IdNbankComAllnum;
	}

	public String getM12IdNbankOthAllnum() {
		return m12IdNbankOthAllnum;
	}

	public String getM12IdNbankNsloanAllnum() {
		return m12IdNbankNsloanAllnum;
	}

	public String getM12IdNbankAutofinAllnum() {
		return m12IdNbankAutofinAllnum;
	}

	public String getM12IdNbankSloanAllnum() {
		return m12IdNbankSloanAllnum;
	}

	public String getM12IdNbankConsAllnum() {
		return m12IdNbankConsAllnum;
	}

	public String getM12IdNbankFinleaAllnum() {
		return m12IdNbankFinleaAllnum;
	}

	public String getM12IdNbankElseAllnum() {
		return m12IdNbankElseAllnum;
	}

	public String getM12IdNbankOrgnum() {
		return m12IdNbankOrgnum;
	}

	public String getM12IdNbankP2pOrgnum() {
		return m12IdNbankP2pOrgnum;
	}

	public String getM12IdNbankMcOrgnum() {
		return m12IdNbankMcOrgnum;
	}

	public String getM12IdNbankCaOrgnum() {
		return m12IdNbankCaOrgnum;
	}

	public String getM12IdNbankCfOrgnum() {
		return m12IdNbankCfOrgnum;
	}

	public String getM12IdNbankComOrgnum() {
		return m12IdNbankComOrgnum;
	}

	public String getM12IdNbankOthOrgnum() {
		return m12IdNbankOthOrgnum;
	}

	public String getM12IdNbankNsloanOrgnum() {
		return m12IdNbankNsloanOrgnum;
	}

	public String getM12IdNbankAutofinOrgnum() {
		return m12IdNbankAutofinOrgnum;
	}

	public String getM12IdNbankSloanOrgnum() {
		return m12IdNbankSloanOrgnum;
	}

	public String getM12IdNbankConsOrgnum() {
		return m12IdNbankConsOrgnum;
	}

	public String getM12IdNbankFinleaOrgnum() {
		return m12IdNbankFinleaOrgnum;
	}

	public String getM12IdNbankElseOrgnum() {
		return m12IdNbankElseOrgnum;
	}

	public String getM12IdNbankTotMons() {
		return m12IdNbankTotMons;
	}

	public String getM12IdNbankAvgMonnum() {
		return m12IdNbankAvgMonnum;
	}

	public String getM12IdNbankMaxMonnum() {
		return m12IdNbankMaxMonnum;
	}

	public String getM12IdNbankMinMonnum() {
		return m12IdNbankMinMonnum;
	}

	public String getM12IdNbankMaxInteday() {
		return m12IdNbankMaxInteday;
	}

	public String getM12IdNbankMinInteday() {
		return m12IdNbankMinInteday;
	}

	public String getM12IdNbankWeekAllnum() {
		return m12IdNbankWeekAllnum;
	}

	public String getM12IdNbankWeekOrgnum() {
		return m12IdNbankWeekOrgnum;
	}

	public String getM12IdNbankNightAllnum() {
		return m12IdNbankNightAllnum;
	}

	public String getM12IdNbankNightOrgnum() {
		return m12IdNbankNightOrgnum;
	}

	public String getM12CellMaxInteday() {
		return m12CellMaxInteday;
	}

	public String getM12CellMinInteday() {
		return m12CellMinInteday;
	}

	public String getM12CellTotMons() {
		return m12CellTotMons;
	}

	public String getM12CellAvgMonnum() {
		return m12CellAvgMonnum;
	}

	public String getM12CellMaxMonnum() {
		return m12CellMaxMonnum;
	}

	public String getM12CellMinMonnum() {
		return m12CellMinMonnum;
	}

	public String getM12CellPdlAllnum() {
		return m12CellPdlAllnum;
	}

	public String getM12CellPdlOrgnum() {
		return m12CellPdlOrgnum;
	}

	public String getM12CellCaonAllnum() {
		return m12CellCaonAllnum;
	}

	public String getM12CellCaonOrgnum() {
		return m12CellCaonOrgnum;
	}

	public String getM12CellRelAllnum() {
		return m12CellRelAllnum;
	}

	public String getM12CellRelOrgnum() {
		return m12CellRelOrgnum;
	}

	public String getM12CellCaoffAllnum() {
		return m12CellCaoffAllnum;
	}

	public String getM12CellCaoffOrgnum() {
		return m12CellCaoffOrgnum;
	}

	public String getM12CellCooffAllnum() {
		return m12CellCooffAllnum;
	}

	public String getM12CellCooffOrgnum() {
		return m12CellCooffOrgnum;
	}

	public String getM12CellAfAllnum() {
		return m12CellAfAllnum;
	}

	public String getM12CellAfOrgnum() {
		return m12CellAfOrgnum;
	}

	public String getM12CellCoonAllnum() {
		return m12CellCoonAllnum;
	}

	public String getM12CellCoonOrgnum() {
		return m12CellCoonOrgnum;
	}

	public String getM12CellOthAllnum() {
		return m12CellOthAllnum;
	}

	public String getM12CellOthOrgnum() {
		return m12CellOthOrgnum;
	}

	public String getM12CellBankSelfnum() {
		return m12CellBankSelfnum;
	}

	public String getM12CellBankAllnum() {
		return m12CellBankAllnum;
	}

	public String getM12CellBankTraAllnum() {
		return m12CellBankTraAllnum;
	}

	public String getM12CellBankRetAllnum() {
		return m12CellBankRetAllnum;
	}

	public String getM12CellBankOrgnum() {
		return m12CellBankOrgnum;
	}

	public String getM12CellBankTraOrgnum() {
		return m12CellBankTraOrgnum;
	}

	public String getM12CellBankRetOrgnum() {
		return m12CellBankRetOrgnum;
	}

	public String getM12CellBankTotMons() {
		return m12CellBankTotMons;
	}

	public String getM12CellBankAvgMonnum() {
		return m12CellBankAvgMonnum;
	}

	public String getM12CellBankMaxMonnum() {
		return m12CellBankMaxMonnum;
	}

	public String getM12CellBankMinMonnum() {
		return m12CellBankMinMonnum;
	}

	public String getM12CellBankMaxInteday() {
		return m12CellBankMaxInteday;
	}

	public String getM12CellBankMinInteday() {
		return m12CellBankMinInteday;
	}

	public String getM12CellBankWeekAllnum() {
		return m12CellBankWeekAllnum;
	}

	public String getM12CellBankWeekOrgnum() {
		return m12CellBankWeekOrgnum;
	}

	public String getM12CellBankNightAllnum() {
		return m12CellBankNightAllnum;
	}

	public String getM12CellBankNightOrgnum() {
		return m12CellBankNightOrgnum;
	}

	public String getM12CellNbankSelfnum() {
		return m12CellNbankSelfnum;
	}

	public String getM12CellNbankAllnum() {
		return m12CellNbankAllnum;
	}

	public String getM12CellNbankP2pAllnum() {
		return m12CellNbankP2pAllnum;
	}

	public String getM12CellNbankMcAllnum() {
		return m12CellNbankMcAllnum;
	}

	public String getM12CellNbankCaAllnum() {
		return m12CellNbankCaAllnum;
	}

	public String getM12CellNbankCfAllnum() {
		return m12CellNbankCfAllnum;
	}

	public String getM12CellNbankComAllnum() {
		return m12CellNbankComAllnum;
	}

	public String getM12CellNbankOthAllnum() {
		return m12CellNbankOthAllnum;
	}

	public String getM12CellNbankNsloanAllnum() {
		return m12CellNbankNsloanAllnum;
	}

	public String getM12CellNbankAutofinAllnum() {
		return m12CellNbankAutofinAllnum;
	}

	public String getM12CellNbankSloanAllnum() {
		return m12CellNbankSloanAllnum;
	}

	public String getM12CellNbankConsAllnum() {
		return m12CellNbankConsAllnum;
	}

	public String getM12CellNbankFinleaAllnum() {
		return m12CellNbankFinleaAllnum;
	}

	public String getM12CellNbankElseAllnum() {
		return m12CellNbankElseAllnum;
	}

	public String getM12CellNbankOrgnum() {
		return m12CellNbankOrgnum;
	}

	public String getM12CellNbankP2pOrgnum() {
		return m12CellNbankP2pOrgnum;
	}

	public String getM12CellNbankMcOrgnum() {
		return m12CellNbankMcOrgnum;
	}

	public String getM12CellNbankCaOrgnum() {
		return m12CellNbankCaOrgnum;
	}

	public String getM12CellNbankCfOrgnum() {
		return m12CellNbankCfOrgnum;
	}

	public String getM12CellNbankComOrgnum() {
		return m12CellNbankComOrgnum;
	}

	public String getM12CellNbankOthOrgnum() {
		return m12CellNbankOthOrgnum;
	}

	public String getM12CellNbankNsloanOrgnum() {
		return m12CellNbankNsloanOrgnum;
	}

	public String getM12CellNbankAutofinOrgnum() {
		return m12CellNbankAutofinOrgnum;
	}

	public String getM12CellNbankSloanOrgnum() {
		return m12CellNbankSloanOrgnum;
	}

	public String getM12CellNbankConsOrgnum() {
		return m12CellNbankConsOrgnum;
	}

	public String getM12CellNbankFinleaOrgnum() {
		return m12CellNbankFinleaOrgnum;
	}

	public String getM12CellNbankElseOrgnum() {
		return m12CellNbankElseOrgnum;
	}

	public String getM12CellNbankTotMons() {
		return m12CellNbankTotMons;
	}

	public String getM12CellNbankAvgMonnum() {
		return m12CellNbankAvgMonnum;
	}

	public String getM12CellNbankMaxMonnum() {
		return m12CellNbankMaxMonnum;
	}

	public String getM12CellNbankMinMonnum() {
		return m12CellNbankMinMonnum;
	}

	public String getM12CellNbankMaxInteday() {
		return m12CellNbankMaxInteday;
	}

	public String getM12CellNbankMinInteday() {
		return m12CellNbankMinInteday;
	}

	public String getM12CellNbankWeekAllnum() {
		return m12CellNbankWeekAllnum;
	}

	public String getM12CellNbankWeekOrgnum() {
		return m12CellNbankWeekOrgnum;
	}

	public String getM12CellNbankNightAllnum() {
		return m12CellNbankNightAllnum;
	}

	public String getM12CellNbankNightOrgnum() {
		return m12CellNbankNightOrgnum;
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

	public void setM12IdMaxInteday(String m12IdMaxInteday) {
		this.m12IdMaxInteday = m12IdMaxInteday;
	}

	public void setM12IdMinInteday(String m12IdMinInteday) {
		this.m12IdMinInteday = m12IdMinInteday;
	}

	public void setM12IdTotMons(String m12IdTotMons) {
		this.m12IdTotMons = m12IdTotMons;
	}

	public void setM12IdAvgMonnum(String m12IdAvgMonnum) {
		this.m12IdAvgMonnum = m12IdAvgMonnum;
	}

	public void setM12IdMaxMonnum(String m12IdMaxMonnum) {
		this.m12IdMaxMonnum = m12IdMaxMonnum;
	}

	public void setM12IdMinMonnum(String m12IdMinMonnum) {
		this.m12IdMinMonnum = m12IdMinMonnum;
	}

	public void setM12IdPdlAllnum(String m12IdPdlAllnum) {
		this.m12IdPdlAllnum = m12IdPdlAllnum;
	}

	public void setM12IdPdlOrgnum(String m12IdPdlOrgnum) {
		this.m12IdPdlOrgnum = m12IdPdlOrgnum;
	}

	public void setM12IdCaonAllnum(String m12IdCaonAllnum) {
		this.m12IdCaonAllnum = m12IdCaonAllnum;
	}

	public void setM12IdCaonOrgnum(String m12IdCaonOrgnum) {
		this.m12IdCaonOrgnum = m12IdCaonOrgnum;
	}

	public void setM12IdRelAllnum(String m12IdRelAllnum) {
		this.m12IdRelAllnum = m12IdRelAllnum;
	}

	public void setM12IdRelOrgnum(String m12IdRelOrgnum) {
		this.m12IdRelOrgnum = m12IdRelOrgnum;
	}

	public void setM12IdCaoffAllnum(String m12IdCaoffAllnum) {
		this.m12IdCaoffAllnum = m12IdCaoffAllnum;
	}

	public void setM12IdCaoffOrgnum(String m12IdCaoffOrgnum) {
		this.m12IdCaoffOrgnum = m12IdCaoffOrgnum;
	}

	public void setM12IdCooffAllnum(String m12IdCooffAllnum) {
		this.m12IdCooffAllnum = m12IdCooffAllnum;
	}

	public void setM12IdCooffOrgnum(String m12IdCooffOrgnum) {
		this.m12IdCooffOrgnum = m12IdCooffOrgnum;
	}

	public void setM12IdAfAllnum(String m12IdAfAllnum) {
		this.m12IdAfAllnum = m12IdAfAllnum;
	}

	public void setM12IdAfOrgnum(String m12IdAfOrgnum) {
		this.m12IdAfOrgnum = m12IdAfOrgnum;
	}

	public void setM12IdCoonAllnum(String m12IdCoonAllnum) {
		this.m12IdCoonAllnum = m12IdCoonAllnum;
	}

	public void setM12IdCoonOrgnum(String m12IdCoonOrgnum) {
		this.m12IdCoonOrgnum = m12IdCoonOrgnum;
	}

	public void setM12IdOthAllnum(String m12IdOthAllnum) {
		this.m12IdOthAllnum = m12IdOthAllnum;
	}

	public void setM12IdOthOrgnum(String m12IdOthOrgnum) {
		this.m12IdOthOrgnum = m12IdOthOrgnum;
	}

	public void setM12IdBankSelfnum(String m12IdBankSelfnum) {
		this.m12IdBankSelfnum = m12IdBankSelfnum;
	}

	public void setM12IdBankAllnum(String m12IdBankAllnum) {
		this.m12IdBankAllnum = m12IdBankAllnum;
	}

	public void setM12IdBankTraAllnum(String m12IdBankTraAllnum) {
		this.m12IdBankTraAllnum = m12IdBankTraAllnum;
	}

	public void setM12IdBankRetAllnum(String m12IdBankRetAllnum) {
		this.m12IdBankRetAllnum = m12IdBankRetAllnum;
	}

	public void setM12IdBankOrgnum(String m12IdBankOrgnum) {
		this.m12IdBankOrgnum = m12IdBankOrgnum;
	}

	public void setM12IdBankTraOrgnum(String m12IdBankTraOrgnum) {
		this.m12IdBankTraOrgnum = m12IdBankTraOrgnum;
	}

	public void setM12IdBankRetOrgnum(String m12IdBankRetOrgnum) {
		this.m12IdBankRetOrgnum = m12IdBankRetOrgnum;
	}

	public void setM12IdBankTotMons(String m12IdBankTotMons) {
		this.m12IdBankTotMons = m12IdBankTotMons;
	}

	public void setM12IdBankAvgMonnum(String m12IdBankAvgMonnum) {
		this.m12IdBankAvgMonnum = m12IdBankAvgMonnum;
	}

	public void setM12IdBankMaxMonnum(String m12IdBankMaxMonnum) {
		this.m12IdBankMaxMonnum = m12IdBankMaxMonnum;
	}

	public void setM12IdBankMinMonnum(String m12IdBankMinMonnum) {
		this.m12IdBankMinMonnum = m12IdBankMinMonnum;
	}

	public void setM12IdBankMaxInteday(String m12IdBankMaxInteday) {
		this.m12IdBankMaxInteday = m12IdBankMaxInteday;
	}

	public void setM12IdBankMinInteday(String m12IdBankMinInteday) {
		this.m12IdBankMinInteday = m12IdBankMinInteday;
	}

	public void setM12IdBankWeekAllnum(String m12IdBankWeekAllnum) {
		this.m12IdBankWeekAllnum = m12IdBankWeekAllnum;
	}

	public void setM12IdBankWeekOrgnum(String m12IdBankWeekOrgnum) {
		this.m12IdBankWeekOrgnum = m12IdBankWeekOrgnum;
	}

	public void setM12IdBankNightAllnum(String m12IdBankNightAllnum) {
		this.m12IdBankNightAllnum = m12IdBankNightAllnum;
	}

	public void setM12IdBankNightOrgnum(String m12IdBankNightOrgnum) {
		this.m12IdBankNightOrgnum = m12IdBankNightOrgnum;
	}

	public void setM12IdNbankSelfnum(String m12IdNbankSelfnum) {
		this.m12IdNbankSelfnum = m12IdNbankSelfnum;
	}

	public void setM12IdNbankAllnum(String m12IdNbankAllnum) {
		this.m12IdNbankAllnum = m12IdNbankAllnum;
	}

	public void setM12IdNbankP2pAllnum(String m12IdNbankP2pAllnum) {
		this.m12IdNbankP2pAllnum = m12IdNbankP2pAllnum;
	}

	public void setM12IdNbankMcAllnum(String m12IdNbankMcAllnum) {
		this.m12IdNbankMcAllnum = m12IdNbankMcAllnum;
	}

	public void setM12IdNbankCaAllnum(String m12IdNbankCaAllnum) {
		this.m12IdNbankCaAllnum = m12IdNbankCaAllnum;
	}

	public void setM12IdNbankCfAllnum(String m12IdNbankCfAllnum) {
		this.m12IdNbankCfAllnum = m12IdNbankCfAllnum;
	}

	public void setM12IdNbankComAllnum(String m12IdNbankComAllnum) {
		this.m12IdNbankComAllnum = m12IdNbankComAllnum;
	}

	public void setM12IdNbankOthAllnum(String m12IdNbankOthAllnum) {
		this.m12IdNbankOthAllnum = m12IdNbankOthAllnum;
	}

	public void setM12IdNbankNsloanAllnum(String m12IdNbankNsloanAllnum) {
		this.m12IdNbankNsloanAllnum = m12IdNbankNsloanAllnum;
	}

	public void setM12IdNbankAutofinAllnum(String m12IdNbankAutofinAllnum) {
		this.m12IdNbankAutofinAllnum = m12IdNbankAutofinAllnum;
	}

	public void setM12IdNbankSloanAllnum(String m12IdNbankSloanAllnum) {
		this.m12IdNbankSloanAllnum = m12IdNbankSloanAllnum;
	}

	public void setM12IdNbankConsAllnum(String m12IdNbankConsAllnum) {
		this.m12IdNbankConsAllnum = m12IdNbankConsAllnum;
	}

	public void setM12IdNbankFinleaAllnum(String m12IdNbankFinleaAllnum) {
		this.m12IdNbankFinleaAllnum = m12IdNbankFinleaAllnum;
	}

	public void setM12IdNbankElseAllnum(String m12IdNbankElseAllnum) {
		this.m12IdNbankElseAllnum = m12IdNbankElseAllnum;
	}

	public void setM12IdNbankOrgnum(String m12IdNbankOrgnum) {
		this.m12IdNbankOrgnum = m12IdNbankOrgnum;
	}

	public void setM12IdNbankP2pOrgnum(String m12IdNbankP2pOrgnum) {
		this.m12IdNbankP2pOrgnum = m12IdNbankP2pOrgnum;
	}

	public void setM12IdNbankMcOrgnum(String m12IdNbankMcOrgnum) {
		this.m12IdNbankMcOrgnum = m12IdNbankMcOrgnum;
	}

	public void setM12IdNbankCaOrgnum(String m12IdNbankCaOrgnum) {
		this.m12IdNbankCaOrgnum = m12IdNbankCaOrgnum;
	}

	public void setM12IdNbankCfOrgnum(String m12IdNbankCfOrgnum) {
		this.m12IdNbankCfOrgnum = m12IdNbankCfOrgnum;
	}

	public void setM12IdNbankComOrgnum(String m12IdNbankComOrgnum) {
		this.m12IdNbankComOrgnum = m12IdNbankComOrgnum;
	}

	public void setM12IdNbankOthOrgnum(String m12IdNbankOthOrgnum) {
		this.m12IdNbankOthOrgnum = m12IdNbankOthOrgnum;
	}

	public void setM12IdNbankNsloanOrgnum(String m12IdNbankNsloanOrgnum) {
		this.m12IdNbankNsloanOrgnum = m12IdNbankNsloanOrgnum;
	}

	public void setM12IdNbankAutofinOrgnum(String m12IdNbankAutofinOrgnum) {
		this.m12IdNbankAutofinOrgnum = m12IdNbankAutofinOrgnum;
	}

	public void setM12IdNbankSloanOrgnum(String m12IdNbankSloanOrgnum) {
		this.m12IdNbankSloanOrgnum = m12IdNbankSloanOrgnum;
	}

	public void setM12IdNbankConsOrgnum(String m12IdNbankConsOrgnum) {
		this.m12IdNbankConsOrgnum = m12IdNbankConsOrgnum;
	}

	public void setM12IdNbankFinleaOrgnum(String m12IdNbankFinleaOrgnum) {
		this.m12IdNbankFinleaOrgnum = m12IdNbankFinleaOrgnum;
	}

	public void setM12IdNbankElseOrgnum(String m12IdNbankElseOrgnum) {
		this.m12IdNbankElseOrgnum = m12IdNbankElseOrgnum;
	}

	public void setM12IdNbankTotMons(String m12IdNbankTotMons) {
		this.m12IdNbankTotMons = m12IdNbankTotMons;
	}

	public void setM12IdNbankAvgMonnum(String m12IdNbankAvgMonnum) {
		this.m12IdNbankAvgMonnum = m12IdNbankAvgMonnum;
	}

	public void setM12IdNbankMaxMonnum(String m12IdNbankMaxMonnum) {
		this.m12IdNbankMaxMonnum = m12IdNbankMaxMonnum;
	}

	public void setM12IdNbankMinMonnum(String m12IdNbankMinMonnum) {
		this.m12IdNbankMinMonnum = m12IdNbankMinMonnum;
	}

	public void setM12IdNbankMaxInteday(String m12IdNbankMaxInteday) {
		this.m12IdNbankMaxInteday = m12IdNbankMaxInteday;
	}

	public void setM12IdNbankMinInteday(String m12IdNbankMinInteday) {
		this.m12IdNbankMinInteday = m12IdNbankMinInteday;
	}

	public void setM12IdNbankWeekAllnum(String m12IdNbankWeekAllnum) {
		this.m12IdNbankWeekAllnum = m12IdNbankWeekAllnum;
	}

	public void setM12IdNbankWeekOrgnum(String m12IdNbankWeekOrgnum) {
		this.m12IdNbankWeekOrgnum = m12IdNbankWeekOrgnum;
	}

	public void setM12IdNbankNightAllnum(String m12IdNbankNightAllnum) {
		this.m12IdNbankNightAllnum = m12IdNbankNightAllnum;
	}

	public void setM12IdNbankNightOrgnum(String m12IdNbankNightOrgnum) {
		this.m12IdNbankNightOrgnum = m12IdNbankNightOrgnum;
	}

	public void setM12CellMaxInteday(String m12CellMaxInteday) {
		this.m12CellMaxInteday = m12CellMaxInteday;
	}

	public void setM12CellMinInteday(String m12CellMinInteday) {
		this.m12CellMinInteday = m12CellMinInteday;
	}

	public void setM12CellTotMons(String m12CellTotMons) {
		this.m12CellTotMons = m12CellTotMons;
	}

	public void setM12CellAvgMonnum(String m12CellAvgMonnum) {
		this.m12CellAvgMonnum = m12CellAvgMonnum;
	}

	public void setM12CellMaxMonnum(String m12CellMaxMonnum) {
		this.m12CellMaxMonnum = m12CellMaxMonnum;
	}

	public void setM12CellMinMonnum(String m12CellMinMonnum) {
		this.m12CellMinMonnum = m12CellMinMonnum;
	}

	public void setM12CellPdlAllnum(String m12CellPdlAllnum) {
		this.m12CellPdlAllnum = m12CellPdlAllnum;
	}

	public void setM12CellPdlOrgnum(String m12CellPdlOrgnum) {
		this.m12CellPdlOrgnum = m12CellPdlOrgnum;
	}

	public void setM12CellCaonAllnum(String m12CellCaonAllnum) {
		this.m12CellCaonAllnum = m12CellCaonAllnum;
	}

	public void setM12CellCaonOrgnum(String m12CellCaonOrgnum) {
		this.m12CellCaonOrgnum = m12CellCaonOrgnum;
	}

	public void setM12CellRelAllnum(String m12CellRelAllnum) {
		this.m12CellRelAllnum = m12CellRelAllnum;
	}

	public void setM12CellRelOrgnum(String m12CellRelOrgnum) {
		this.m12CellRelOrgnum = m12CellRelOrgnum;
	}

	public void setM12CellCaoffAllnum(String m12CellCaoffAllnum) {
		this.m12CellCaoffAllnum = m12CellCaoffAllnum;
	}

	public void setM12CellCaoffOrgnum(String m12CellCaoffOrgnum) {
		this.m12CellCaoffOrgnum = m12CellCaoffOrgnum;
	}

	public void setM12CellCooffAllnum(String m12CellCooffAllnum) {
		this.m12CellCooffAllnum = m12CellCooffAllnum;
	}

	public void setM12CellCooffOrgnum(String m12CellCooffOrgnum) {
		this.m12CellCooffOrgnum = m12CellCooffOrgnum;
	}

	public void setM12CellAfAllnum(String m12CellAfAllnum) {
		this.m12CellAfAllnum = m12CellAfAllnum;
	}

	public void setM12CellAfOrgnum(String m12CellAfOrgnum) {
		this.m12CellAfOrgnum = m12CellAfOrgnum;
	}

	public void setM12CellCoonAllnum(String m12CellCoonAllnum) {
		this.m12CellCoonAllnum = m12CellCoonAllnum;
	}

	public void setM12CellCoonOrgnum(String m12CellCoonOrgnum) {
		this.m12CellCoonOrgnum = m12CellCoonOrgnum;
	}

	public void setM12CellOthAllnum(String m12CellOthAllnum) {
		this.m12CellOthAllnum = m12CellOthAllnum;
	}

	public void setM12CellOthOrgnum(String m12CellOthOrgnum) {
		this.m12CellOthOrgnum = m12CellOthOrgnum;
	}

	public void setM12CellBankSelfnum(String m12CellBankSelfnum) {
		this.m12CellBankSelfnum = m12CellBankSelfnum;
	}

	public void setM12CellBankAllnum(String m12CellBankAllnum) {
		this.m12CellBankAllnum = m12CellBankAllnum;
	}

	public void setM12CellBankTraAllnum(String m12CellBankTraAllnum) {
		this.m12CellBankTraAllnum = m12CellBankTraAllnum;
	}

	public void setM12CellBankRetAllnum(String m12CellBankRetAllnum) {
		this.m12CellBankRetAllnum = m12CellBankRetAllnum;
	}

	public void setM12CellBankOrgnum(String m12CellBankOrgnum) {
		this.m12CellBankOrgnum = m12CellBankOrgnum;
	}

	public void setM12CellBankTraOrgnum(String m12CellBankTraOrgnum) {
		this.m12CellBankTraOrgnum = m12CellBankTraOrgnum;
	}

	public void setM12CellBankRetOrgnum(String m12CellBankRetOrgnum) {
		this.m12CellBankRetOrgnum = m12CellBankRetOrgnum;
	}

	public void setM12CellBankTotMons(String m12CellBankTotMons) {
		this.m12CellBankTotMons = m12CellBankTotMons;
	}

	public void setM12CellBankAvgMonnum(String m12CellBankAvgMonnum) {
		this.m12CellBankAvgMonnum = m12CellBankAvgMonnum;
	}

	public void setM12CellBankMaxMonnum(String m12CellBankMaxMonnum) {
		this.m12CellBankMaxMonnum = m12CellBankMaxMonnum;
	}

	public void setM12CellBankMinMonnum(String m12CellBankMinMonnum) {
		this.m12CellBankMinMonnum = m12CellBankMinMonnum;
	}

	public void setM12CellBankMaxInteday(String m12CellBankMaxInteday) {
		this.m12CellBankMaxInteday = m12CellBankMaxInteday;
	}

	public void setM12CellBankMinInteday(String m12CellBankMinInteday) {
		this.m12CellBankMinInteday = m12CellBankMinInteday;
	}

	public void setM12CellBankWeekAllnum(String m12CellBankWeekAllnum) {
		this.m12CellBankWeekAllnum = m12CellBankWeekAllnum;
	}

	public void setM12CellBankWeekOrgnum(String m12CellBankWeekOrgnum) {
		this.m12CellBankWeekOrgnum = m12CellBankWeekOrgnum;
	}

	public void setM12CellBankNightAllnum(String m12CellBankNightAllnum) {
		this.m12CellBankNightAllnum = m12CellBankNightAllnum;
	}

	public void setM12CellBankNightOrgnum(String m12CellBankNightOrgnum) {
		this.m12CellBankNightOrgnum = m12CellBankNightOrgnum;
	}

	public void setM12CellNbankSelfnum(String m12CellNbankSelfnum) {
		this.m12CellNbankSelfnum = m12CellNbankSelfnum;
	}

	public void setM12CellNbankAllnum(String m12CellNbankAllnum) {
		this.m12CellNbankAllnum = m12CellNbankAllnum;
	}

	public void setM12CellNbankP2pAllnum(String m12CellNbankP2pAllnum) {
		this.m12CellNbankP2pAllnum = m12CellNbankP2pAllnum;
	}

	public void setM12CellNbankMcAllnum(String m12CellNbankMcAllnum) {
		this.m12CellNbankMcAllnum = m12CellNbankMcAllnum;
	}

	public void setM12CellNbankCaAllnum(String m12CellNbankCaAllnum) {
		this.m12CellNbankCaAllnum = m12CellNbankCaAllnum;
	}

	public void setM12CellNbankCfAllnum(String m12CellNbankCfAllnum) {
		this.m12CellNbankCfAllnum = m12CellNbankCfAllnum;
	}

	public void setM12CellNbankComAllnum(String m12CellNbankComAllnum) {
		this.m12CellNbankComAllnum = m12CellNbankComAllnum;
	}

	public void setM12CellNbankOthAllnum(String m12CellNbankOthAllnum) {
		this.m12CellNbankOthAllnum = m12CellNbankOthAllnum;
	}

	public void setM12CellNbankNsloanAllnum(String m12CellNbankNsloanAllnum) {
		this.m12CellNbankNsloanAllnum = m12CellNbankNsloanAllnum;
	}

	public void setM12CellNbankAutofinAllnum(String m12CellNbankAutofinAllnum) {
		this.m12CellNbankAutofinAllnum = m12CellNbankAutofinAllnum;
	}

	public void setM12CellNbankSloanAllnum(String m12CellNbankSloanAllnum) {
		this.m12CellNbankSloanAllnum = m12CellNbankSloanAllnum;
	}

	public void setM12CellNbankConsAllnum(String m12CellNbankConsAllnum) {
		this.m12CellNbankConsAllnum = m12CellNbankConsAllnum;
	}

	public void setM12CellNbankFinleaAllnum(String m12CellNbankFinleaAllnum) {
		this.m12CellNbankFinleaAllnum = m12CellNbankFinleaAllnum;
	}

	public void setM12CellNbankElseAllnum(String m12CellNbankElseAllnum) {
		this.m12CellNbankElseAllnum = m12CellNbankElseAllnum;
	}

	public void setM12CellNbankOrgnum(String m12CellNbankOrgnum) {
		this.m12CellNbankOrgnum = m12CellNbankOrgnum;
	}

	public void setM12CellNbankP2pOrgnum(String m12CellNbankP2pOrgnum) {
		this.m12CellNbankP2pOrgnum = m12CellNbankP2pOrgnum;
	}

	public void setM12CellNbankMcOrgnum(String m12CellNbankMcOrgnum) {
		this.m12CellNbankMcOrgnum = m12CellNbankMcOrgnum;
	}

	public void setM12CellNbankCaOrgnum(String m12CellNbankCaOrgnum) {
		this.m12CellNbankCaOrgnum = m12CellNbankCaOrgnum;
	}

	public void setM12CellNbankCfOrgnum(String m12CellNbankCfOrgnum) {
		this.m12CellNbankCfOrgnum = m12CellNbankCfOrgnum;
	}

	public void setM12CellNbankComOrgnum(String m12CellNbankComOrgnum) {
		this.m12CellNbankComOrgnum = m12CellNbankComOrgnum;
	}

	public void setM12CellNbankOthOrgnum(String m12CellNbankOthOrgnum) {
		this.m12CellNbankOthOrgnum = m12CellNbankOthOrgnum;
	}

	public void setM12CellNbankNsloanOrgnum(String m12CellNbankNsloanOrgnum) {
		this.m12CellNbankNsloanOrgnum = m12CellNbankNsloanOrgnum;
	}

	public void setM12CellNbankAutofinOrgnum(String m12CellNbankAutofinOrgnum) {
		this.m12CellNbankAutofinOrgnum = m12CellNbankAutofinOrgnum;
	}

	public void setM12CellNbankSloanOrgnum(String m12CellNbankSloanOrgnum) {
		this.m12CellNbankSloanOrgnum = m12CellNbankSloanOrgnum;
	}

	public void setM12CellNbankConsOrgnum(String m12CellNbankConsOrgnum) {
		this.m12CellNbankConsOrgnum = m12CellNbankConsOrgnum;
	}

	public void setM12CellNbankFinleaOrgnum(String m12CellNbankFinleaOrgnum) {
		this.m12CellNbankFinleaOrgnum = m12CellNbankFinleaOrgnum;
	}

	public void setM12CellNbankElseOrgnum(String m12CellNbankElseOrgnum) {
		this.m12CellNbankElseOrgnum = m12CellNbankElseOrgnum;
	}

	public void setM12CellNbankTotMons(String m12CellNbankTotMons) {
		this.m12CellNbankTotMons = m12CellNbankTotMons;
	}

	public void setM12CellNbankAvgMonnum(String m12CellNbankAvgMonnum) {
		this.m12CellNbankAvgMonnum = m12CellNbankAvgMonnum;
	}

	public void setM12CellNbankMaxMonnum(String m12CellNbankMaxMonnum) {
		this.m12CellNbankMaxMonnum = m12CellNbankMaxMonnum;
	}

	public void setM12CellNbankMinMonnum(String m12CellNbankMinMonnum) {
		this.m12CellNbankMinMonnum = m12CellNbankMinMonnum;
	}

	public void setM12CellNbankMaxInteday(String m12CellNbankMaxInteday) {
		this.m12CellNbankMaxInteday = m12CellNbankMaxInteday;
	}

	public void setM12CellNbankMinInteday(String m12CellNbankMinInteday) {
		this.m12CellNbankMinInteday = m12CellNbankMinInteday;
	}

	public void setM12CellNbankWeekAllnum(String m12CellNbankWeekAllnum) {
		this.m12CellNbankWeekAllnum = m12CellNbankWeekAllnum;
	}

	public void setM12CellNbankWeekOrgnum(String m12CellNbankWeekOrgnum) {
		this.m12CellNbankWeekOrgnum = m12CellNbankWeekOrgnum;
	}

	public void setM12CellNbankNightAllnum(String m12CellNbankNightAllnum) {
		this.m12CellNbankNightAllnum = m12CellNbankNightAllnum;
	}

	public void setM12CellNbankNightOrgnum(String m12CellNbankNightOrgnum) {
		this.m12CellNbankNightOrgnum = m12CellNbankNightOrgnum;
	}

	public String getTrnKey() {
		return trnKey;
	}

	public void setTrnKey(String trnKey) {
		this.trnKey = trnKey;
	}

}
