package com.huaxia.plaze.modules.bairong.domain;

import java.util.Date;

/**
 * 百融多头借贷的相关的6个月的数据
 * 
 * @author Liuwei
 */
public class ApplyLoanStrMonth6 {
	
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

	// 按身份证号查询，近6个月申请最大间隔天数
	private String m6IdMaxInteday;

	// 按身份证号查询，近6个月申请最小间隔天数
	private String m6IdMinInteday;

	// 按身份证号查询，近6个月有申请记录月份数
	private String m6IdTotMons;

	// 按身份证号查询，近6个月平均每月申请次数(有申请月份平均)
	private String m6IdAvgMonnum;

	// 按身份证号查询，近6个月最大月申请次数
	private String m6IdMaxMonnum;

	// 按身份证号查询，近6个月最小月申请次数
	private String m6IdMinMonnum;

	// 按身份证号查询，近6个月申请线上小额现金贷的次数
	private String m6IdPdlAllnum;

	// 按身份证号查询，近6个月申请线上小额现金贷的机构数
	private String m6IdPdlOrgnum;

	// 按身份证号查询，近6个月申请线上现金分期的次数
	private String m6IdCaonAllnum;

	// 按身份证号查询，近6个月申请线上现金分期的机构数
	private String m6IdCaonOrgnum;

	// 按身份证号查询，近6个月申请信用卡（类信用卡）的次数
	private String m6IdRelAllnum;

	// 按身份证号查询，近6个月申请信用卡（类信用卡）的机构数
	private String m6IdRelOrgnum;

	// 按身份证号查询，近6个月申请线下现金分期的次数
	private String m6IdCaoffAllnum;

	// 按身份证号查询，近6个月申请线下现金分期的机构数
	private String m6IdCaoffOrgnum;

	// 按身份证号查询，近6个月申请线下消费分期的次数
	private String m6IdCooffAllnum;

	// 按身份证号查询，近6个月申请线下消费分期的机构数
	private String m6IdCooffOrgnum;

	// 按身份证号查询，近6个月申请汽车金融的次数
	private String m6IdAfAllnum;

	// 按身份证号查询，近6个月申请汽车金融的机构数
	private String m6IdAfOrgnum;

	// 按身份证号查询，近6个月申请线上消费分期的次数
	private String m6IdCoonAllnum;

	// 按身份证号查询，近6个月申请线上消费分期的机构数
	private String m6IdCoonOrgnum;

	// 按身份证号查询，近6个月申请其他的次数
	private String m6IdOthAllnum;

	// 按身份证号查询，近6个月申请其他的机构数
	private String m6IdOthOrgnum;

	// 按身份证号查询，近6个月在本机构(本机构为银行)的申请次数
	private String m6IdBankSelfnum;

	// 按身份证号查询，近6个月在银行机构申请次数
	private String m6IdBankAllnum;

	// 按身份证号查询，近6个月在银行机构-传统银行申请次数
	private String m6IdBankTraAllnum;

	// 按身份证号查询，近6个月在银行机构-网络零售银行申请次数
	private String m6IdBankRetAllnum;

	// 按身份证号查询，近6个月在银行机构申请机构数
	private String m6IdBankOrgnum;

	// 按身份证号查询，近6个月在银行机构-传统银行申请机构数
	private String m6IdBankTraOrgnum;

	// 按身份证号查询，近6个月在银行机构-网络零售银行申请机构数
	private String m6IdBankRetOrgnum;

	// 按身份证号查询，近6个月在银行机构有申请记录月份数
	private String m6IdBankTotMons;

	// 按身份证号查询，近6个月在银行机构平均每月申请次数(有申请月份平均)
	private String m6IdBankAvgMonnum;

	// 按身份证号查询，近6个月在银行机构最大月申请次数
	private String m6IdBankMaxMonnum;

	// 按身份证号查询，近6个月在银行机构最小月申请次数
	private String m6IdBankMinMonnum;

	// 按身份证号查询，近6个月在银行机构申请最大间隔天数
	private String m6IdBankMaxInteday;

	// 按身份证号查询，近6个月在银行机构申请最小间隔天数
	private String m6IdBankMinInteday;

	// 按身份证号查询，近6个月在银行机构周末申请次数
	private String m6IdBankWeekAllnum;

	// 按身份证号查询，近6个月在银行机构周末申请机构数
	private String m6IdBankWeekOrgnum;

	// 按身份证号查询，近6个月在银行机构夜间申请次数
	private String m6IdBankNightAllnum;

	// 按身份证号查询，近6个月在银行机构夜间申请机构数
	private String m6IdBankNightOrgnum;

	// 按身份证号查询，近6个月在本机构(本机构为非银)申请次数
	private String m6IdNbankSelfnum;

	// 按身份证号查询，近6个月在非银机构申请次数
	private String m6IdNbankAllnum;

	// 按身份证号查询，近6个月在非银机构-p2p机构申请次数
	private String m6IdNbankP2pAllnum;

	// 按身份证号查询，近6个月在非银机构-小贷机构申请次数
	private String m6IdNbankMcAllnum;

	// 按身份证号查询，近6个月在非银机构-现金类分期机构申请次数
	private String m6IdNbankCaAllnum;

	// 按身份证号查询，近6个月在非银机构-消费类分期机构申请次数
	private String m6IdNbankCfAllnum;

	// 按身份证号查询，近6个月在非银机构-代偿类分期机构申请次数
	private String m6IdNbankComAllnum;

	// 按身份证号查询，近6个月在非银机构-其他申请次数
	private String m6IdNbankOthAllnum;

	// 按身份证号查询，近6个月在非银机构-持牌网络小贷机构申请次数
	private String m6IdNbankNsloanAllnum;

	// 按身份证号查询，近6个月在非银机构-持牌汽车金融机构申请次数
	private String m6IdNbankAutofinAllnum;

	// 按身份证号查询，近6个月在非银机构-持牌小贷机构申请次数
	private String m6IdNbankSloanAllnum;

	// 按身份证号查询，近6个月在非银机构-持牌消费金融机构申请次数
	private String m6IdNbankConsAllnum;

	// 按身份证号查询，近6个月在非银机构-持牌融资租赁机构申请次数
	private String m6IdNbankFinleaAllnum;

	// 按身份证号查询，近6个月在非银机构-其他申请次数
	private String m6IdNbankElseAllnum;

	// 按身份证号查询，近6个月在非银机构申请机构数
	private String m6IdNbankOrgnum;

	// 按身份证号查询，近6个月在非银机构-p2p申请机构数
	private String m6IdNbankP2pOrgnum;

	// 按身份证号查询，近6个月在非银机构-小贷申请机构数
	private String m6IdNbankMcOrgnum;

	// 按身份证号查询，近6个月在非银机构-现金类分期申请机构数
	private String m6IdNbankCaOrgnum;

	// 按身份证号查询，近6个月在非银机构-消费类分期申请机构数
	private String m6IdNbankCfOrgnum;

	// 按身份证号查询，近6个月在非银机构-代偿类分期申请机构数
	private String m6IdNbankComOrgnum;

	// 按身份证号查询，近6个月在非银机构-其他申请机构数
	private String m6IdNbankOthOrgnum;

	// 按身份证号查询，近6个月在非银机构-持牌网络小贷机构申请机构数
	private String m6IdNbankNsloanOrgnum;

	// 按身份证号查询，近6个月在非银机构-持牌汽车金融机构申请机构数
	private String m6IdNbankAutofinOrgnum;

	// 按身份证号查询，近6个月在非银机构-持牌小贷机构申请机构数
	private String m6IdNbankSloanOrgnum;

	// 按身份证号查询，近6个月在非银机构-持牌消费金融机构申请机构数
	private String m6IdNbankConsOrgnum;

	// 按身份证号查询，近6个月在非银机构-持牌融资租赁机构申请机构数
	private String m6IdNbankFinleaOrgnum;

	// 按身份证号查询，近6个月在非银机构-其他申请机构数
	private String m6IdNbankElseOrgnum;

	// 按身份证号查询，近6个月在非银机构有申请记录月份数
	private String m6IdNbankTotMons;

	// 按身份证号查询，近6个月在非银机构平均每月申请次数(有申请月份平均)
	private String m6IdNbankAvgMonnum;

	// 按身份证号查询，近6个月在非银机构最大月申请次数
	private String m6IdNbankMaxMonnum;

	// 按身份证号查询，近6个月在非银机构最小月申请次数
	private String m6IdNbankMinMonnum;

	// 按身份证号查询，近6个月在非银机构申请最大间隔天数
	private String m6IdNbankMaxInteday;

	// 按身份证号查询，近6个月在非银机构申请最小间隔天数
	private String m6IdNbankMinInteday;

	// 按身份证号查询，近6个月在非银机构周末申请次数
	private String m6IdNbankWeekAllnum;

	// 按身份证号查询，近6个月在非银机构周末申请机构数
	private String m6IdNbankWeekOrgnum;

	// 按身份证号查询，近6个月在非银机构夜间申请次数
	private String m6IdNbankNightAllnum;

	// 按身份证号查询，近6个月在非银机构夜间申请机构数
	private String m6IdNbankNightOrgnum;

	// 按手机号查询，近6个月申请最大间隔天数
	private String m6CellMaxInteday;

	// 按手机号查询，近6个月申请最小间隔天数
	private String m6CellMinInteday;

	// 按手机号查询，近6个月有申请记录月份数
	private String m6CellTotMons;

	// 按手机号查询，近6个月平均每月申请次数(有申请月份平均)
	private String m6CellAvgMonnum;

	// 按手机号查询，近6个月最大月申请次数
	private String m6CellMaxMonnum;

	// 按手机号查询，近6个月最小月申请次数
	private String m6CellMinMonnum;

	// 按手机号查询，近6个月申请线上小额现金贷的次数
	private String m6CellPdlAllnum;

	// 按手机号查询，近6个月申请线上小额现金贷的机构数
	private String m6CellPdlOrgnum;

	// 按手机号查询，近6个月申请线上现金分期的次数
	private String m6CellCaonAllnum;

	// 按手机号查询，近6个月申请线上现金分期的机构数
	private String m6CellCaonOrgnum;

	// 按手机号查询，近6个月申请信用卡（类信用卡）的次数
	private String m6CellRelAllnum;

	// 按手机号查询，近6个月申请信用卡（类信用卡）的机构数
	private String m6CellRelOrgnum;

	// 按手机号查询，近6个月申请线下现金分期的次数
	private String m6CellCaoffAllnum;

	// 按手机号查询，近6个月申请线下现金分期的机构数
	private String m6CellCaoffOrgnum;

	// 按手机号查询，近6个月申请线下消费分期的次数
	private String m6CellCooffAllnum;

	// 按手机号查询，近6个月申请线下消费分期的机构数
	private String m6CellCooffOrgnum;

	// 按手机号查询，近6个月申请汽车金融的次数
	private String m6CellAfAllnum;

	// 按手机号查询，近6个月申请汽车金融的机构数
	private String m6CellAfOrgnum;

	// 按手机号查询，近6个月申请线上消费分期的次数
	private String m6CellCoonAllnum;

	// 按手机号查询，近6个月申请线上消费分期的机构数
	private String m6CellCoonOrgnum;

	// 按手机号查询，近6个月申请其他的次数
	private String m6CellOthAllnum;

	// 按手机号查询，近6个月申请其他的机构数
	private String m6CellOthOrgnum;

	// 按手机号查询，近6个月在本机构(本机构为银行)的申请次数
	private String m6CellBankSelfnum;

	// 按手机号查询，近6个月在银行机构申请次数
	private String m6CellBankAllnum;

	// 按手机号查询，近6个月在银行机构-传统银行申请次数
	private String m6CellBankTraAllnum;

	// 按手机号查询，近6个月在银行机构-网络零售银行申请次数
	private String m6CellBankRetAllnum;

	// 按手机号查询，近6个月在银行机构申请机构数
	private String m6CellBankOrgnum;

	// 按手机号查询，近6个月在银行机构-传统银行申请机构数
	private String m6CellBankTraOrgnum;

	// 按手机号查询，近6个月在银行机构-网络零售银行申请机构数
	private String m6CellBankRetOrgnum;

	// 按手机号查询，近6个月在银行机构有申请记录月份数
	private String m6CellBankTotMons;

	// 按手机号查询，近6个月在银行机构平均每月申请次数(有申请月份平均)
	private String m6CellBankAvgMonnum;

	// 按手机号查询，近6个月在银行机构最大月申请次数
	private String m6CellBankMaxMonnum;

	// 按手机号查询，近6个月在银行机构最小月申请次数
	private String m6CellBankMinMonnum;

	// 按手机号查询，近6个月在银行机构申请最大间隔天数
	private String m6CellBankMaxInteday;

	// 按手机号查询，近6个月在银行机构申请最小间隔天数
	private String m6CellBankMinInteday;

	// 按手机号查询，近6个月在银行机构周末申请次数
	private String m6CellBankWeekAllnum;

	// 按手机号查询，近6个月在银行机构周末申请机构数
	private String m6CellBankWeekOrgnum;

	// 按手机号查询，近6个月在银行机构夜间申请次数
	private String m6CellBankNightAllnum;

	// 按手机号查询，近6个月在银行机构夜间申请机构数
	private String m6CellBankNightOrgnum;

	// 按手机号查询，近6个月在本机构(本机构为非银)申请次数
	private String m6CellNbankSelfnum;

	// 按手机号查询，近6个月在非银机构申请次数
	private String m6CellNbankAllnum;

	// 按手机号查询，近6个月在非银机构-p2p机构申请次数
	private String m6CellNbankP2pAllnum;

	// 按手机号查询，近6个月在非银机构-小贷机构申请次数
	private String m6CellNbankMcAllnum;

	// 按手机号查询，近6个月在非银机构-现金类分期机构申请次数
	private String m6CellNbankCaAllnum;

	// 按手机号查询，近6个月在非银机构-消费类分期机构申请次数
	private String m6CellNbankCfAllnum;

	// 按手机号查询，近6个月在非银机构-代偿类分期机构申请次数
	private String m6CellNbankComAllnum;

	// 按手机号查询，近6个月在非银机构-其他申请次数
	private String m6CellNbankOthAllnum;

	// 按手机号查询，近6个月在非银机构-持牌网络小贷机构申请次数
	private String m6CellNbankNsloanAllnum;

	// 按手机号查询，近6个月在非银机构-持牌汽车金融机构申请次数
	private String m6CellNbankAutofinAllnum;

	// 按手机号查询，近6个月在非银机构-持牌小贷机构申请次数
	private String m6CellNbankSloanAllnum;

	// 按手机号查询，近6个月在非银机构-持牌消费金融机构申请次数
	private String m6CellNbankConsAllnum;

	// 按手机号查询，近6个月在非银机构-持牌融资租赁机构申请次数
	private String m6CellNbankFinleaAllnum;

	// 按手机号查询，近6个月在非银机构-其他申请次数
	private String m6CellNbankElseAllnum;

	// 按手机号查询，近6个月在非银机构申请机构数
	private String m6CellNbankOrgnum;

	// 按手机号查询，近6个月在非银机构-p2p申请机构数
	private String m6CellNbankP2pOrgnum;

	// 按手机号查询，近6个月在非银机构-小贷申请机构数
	private String m6CellNbankMcOrgnum;

	// 按手机号查询，近6个月在非银机构-现金类分期申请机构数
	private String m6CellNbankCaOrgnum;

	// 按手机号查询，近6个月在非银机构-消费类分期申请机构数
	private String m6CellNbankCfOrgnum;

	// 按手机号查询，近6个月在非银机构-代偿类分期申请机构数
	private String m6CellNbankComOrgnum;

	// 按手机号查询，近6个月在非银机构-其他申请机构数
	private String m6CellNbankOthOrgnum;

	// 按手机号查询，近6个月在非银机构-持牌网络小贷机构申请机构数
	private String m6CellNbankNsloanOrgnum;

	// 按手机号查询，近6个月在非银机构-持牌汽车金融机构申请机构数
	private String m6CellNbankAutofinOrgnum;

	// 按手机号查询，近6个月在非银机构-持牌小贷机构申请机构数
	private String m6CellNbankSloanOrgnum;

	// 按手机号查询，近6个月在非银机构-持牌消费金融机构申请机构数
	private String m6CellNbankConsOrgnum;

	// 按手机号查询，近6个月在非银机构-持牌融资租赁机构申请机构数
	private String m6CellNbankFinleaOrgnum;

	// 按手机号查询，近6个月在非银机构-其他申请机构数
	private String m6CellNbankElseOrgnum;

	// 按手机号查询，近6个月在非银机构有申请记录月份数
	private String m6CellNbankTotMons;

	// 按手机号查询，近6个月在非银机构平均每月申请次数(有申请月份平均)
	private String m6CellNbankAvgMonnum;

	// 按手机号查询，近6个月在非银机构最大月申请次数
	private String m6CellNbankMaxMonnum;

	// 按手机号查询，近6个月在非银机构最小月申请次数
	private String m6CellNbankMinMonnum;

	// 按手机号查询，近6个月在非银机构申请最大间隔天数
	private String m6CellNbankMaxInteday;

	// 按手机号查询，近6个月在非银机构申请最小间隔天数
	private String m6CellNbankMinInteday;

	// 按手机号查询，近6个月在非银机构周末申请次数
	private String m6CellNbankWeekAllnum;

	// 按手机号查询，近6个月在非银机构周末申请机构数
	private String m6CellNbankWeekOrgnum;

	// 按手机号查询，近6个月在非银机构夜间申请次数
	private String m6CellNbankNightAllnum;

	// 按手机号查询，近6个月在非银机构夜间申请机构数
	private String m6CellNbankNightOrgnum;

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

	public String getM6IdMaxInteday() {
		return m6IdMaxInteday;
	}

	public String getM6IdMinInteday() {
		return m6IdMinInteday;
	}

	public String getM6IdTotMons() {
		return m6IdTotMons;
	}

	public String getM6IdAvgMonnum() {
		return m6IdAvgMonnum;
	}

	public String getM6IdMaxMonnum() {
		return m6IdMaxMonnum;
	}

	public String getM6IdMinMonnum() {
		return m6IdMinMonnum;
	}

	public String getM6IdPdlAllnum() {
		return m6IdPdlAllnum;
	}

	public String getM6IdPdlOrgnum() {
		return m6IdPdlOrgnum;
	}

	public String getM6IdCaonAllnum() {
		return m6IdCaonAllnum;
	}

	public String getM6IdCaonOrgnum() {
		return m6IdCaonOrgnum;
	}

	public String getM6IdRelAllnum() {
		return m6IdRelAllnum;
	}

	public String getM6IdRelOrgnum() {
		return m6IdRelOrgnum;
	}

	public String getM6IdCaoffAllnum() {
		return m6IdCaoffAllnum;
	}

	public String getM6IdCaoffOrgnum() {
		return m6IdCaoffOrgnum;
	}

	public String getM6IdCooffAllnum() {
		return m6IdCooffAllnum;
	}

	public String getM6IdCooffOrgnum() {
		return m6IdCooffOrgnum;
	}

	public String getM6IdAfAllnum() {
		return m6IdAfAllnum;
	}

	public String getM6IdAfOrgnum() {
		return m6IdAfOrgnum;
	}

	public String getM6IdCoonAllnum() {
		return m6IdCoonAllnum;
	}

	public String getM6IdCoonOrgnum() {
		return m6IdCoonOrgnum;
	}

	public String getM6IdOthAllnum() {
		return m6IdOthAllnum;
	}

	public String getM6IdOthOrgnum() {
		return m6IdOthOrgnum;
	}

	public String getM6IdBankSelfnum() {
		return m6IdBankSelfnum;
	}

	public String getM6IdBankAllnum() {
		return m6IdBankAllnum;
	}

	public String getM6IdBankTraAllnum() {
		return m6IdBankTraAllnum;
	}

	public String getM6IdBankRetAllnum() {
		return m6IdBankRetAllnum;
	}

	public String getM6IdBankOrgnum() {
		return m6IdBankOrgnum;
	}

	public String getM6IdBankTraOrgnum() {
		return m6IdBankTraOrgnum;
	}

	public String getM6IdBankRetOrgnum() {
		return m6IdBankRetOrgnum;
	}

	public String getM6IdBankTotMons() {
		return m6IdBankTotMons;
	}

	public String getM6IdBankAvgMonnum() {
		return m6IdBankAvgMonnum;
	}

	public String getM6IdBankMaxMonnum() {
		return m6IdBankMaxMonnum;
	}

	public String getM6IdBankMinMonnum() {
		return m6IdBankMinMonnum;
	}

	public String getM6IdBankMaxInteday() {
		return m6IdBankMaxInteday;
	}

	public String getM6IdBankMinInteday() {
		return m6IdBankMinInteday;
	}

	public String getM6IdBankWeekAllnum() {
		return m6IdBankWeekAllnum;
	}

	public String getM6IdBankWeekOrgnum() {
		return m6IdBankWeekOrgnum;
	}

	public String getM6IdBankNightAllnum() {
		return m6IdBankNightAllnum;
	}

	public String getM6IdBankNightOrgnum() {
		return m6IdBankNightOrgnum;
	}

	public String getM6IdNbankSelfnum() {
		return m6IdNbankSelfnum;
	}

	public String getM6IdNbankAllnum() {
		return m6IdNbankAllnum;
	}

	public String getM6IdNbankP2pAllnum() {
		return m6IdNbankP2pAllnum;
	}

	public String getM6IdNbankMcAllnum() {
		return m6IdNbankMcAllnum;
	}

	public String getM6IdNbankCaAllnum() {
		return m6IdNbankCaAllnum;
	}

	public String getM6IdNbankCfAllnum() {
		return m6IdNbankCfAllnum;
	}

	public String getM6IdNbankComAllnum() {
		return m6IdNbankComAllnum;
	}

	public String getM6IdNbankOthAllnum() {
		return m6IdNbankOthAllnum;
	}

	public String getM6IdNbankNsloanAllnum() {
		return m6IdNbankNsloanAllnum;
	}

	public String getM6IdNbankAutofinAllnum() {
		return m6IdNbankAutofinAllnum;
	}

	public String getM6IdNbankSloanAllnum() {
		return m6IdNbankSloanAllnum;
	}

	public String getM6IdNbankConsAllnum() {
		return m6IdNbankConsAllnum;
	}

	public String getM6IdNbankFinleaAllnum() {
		return m6IdNbankFinleaAllnum;
	}

	public String getM6IdNbankElseAllnum() {
		return m6IdNbankElseAllnum;
	}

	public String getM6IdNbankOrgnum() {
		return m6IdNbankOrgnum;
	}

	public String getM6IdNbankP2pOrgnum() {
		return m6IdNbankP2pOrgnum;
	}

	public String getM6IdNbankMcOrgnum() {
		return m6IdNbankMcOrgnum;
	}

	public String getM6IdNbankCaOrgnum() {
		return m6IdNbankCaOrgnum;
	}

	public String getM6IdNbankCfOrgnum() {
		return m6IdNbankCfOrgnum;
	}

	public String getM6IdNbankComOrgnum() {
		return m6IdNbankComOrgnum;
	}

	public String getM6IdNbankOthOrgnum() {
		return m6IdNbankOthOrgnum;
	}

	public String getM6IdNbankNsloanOrgnum() {
		return m6IdNbankNsloanOrgnum;
	}

	public String getM6IdNbankAutofinOrgnum() {
		return m6IdNbankAutofinOrgnum;
	}

	public String getM6IdNbankSloanOrgnum() {
		return m6IdNbankSloanOrgnum;
	}

	public String getM6IdNbankConsOrgnum() {
		return m6IdNbankConsOrgnum;
	}

	public String getM6IdNbankFinleaOrgnum() {
		return m6IdNbankFinleaOrgnum;
	}

	public String getM6IdNbankElseOrgnum() {
		return m6IdNbankElseOrgnum;
	}

	public String getM6IdNbankTotMons() {
		return m6IdNbankTotMons;
	}

	public String getM6IdNbankAvgMonnum() {
		return m6IdNbankAvgMonnum;
	}

	public String getM6IdNbankMaxMonnum() {
		return m6IdNbankMaxMonnum;
	}

	public String getM6IdNbankMinMonnum() {
		return m6IdNbankMinMonnum;
	}

	public String getM6IdNbankMaxInteday() {
		return m6IdNbankMaxInteday;
	}

	public String getM6IdNbankMinInteday() {
		return m6IdNbankMinInteday;
	}

	public String getM6IdNbankWeekAllnum() {
		return m6IdNbankWeekAllnum;
	}

	public String getM6IdNbankWeekOrgnum() {
		return m6IdNbankWeekOrgnum;
	}

	public String getM6IdNbankNightAllnum() {
		return m6IdNbankNightAllnum;
	}

	public String getM6IdNbankNightOrgnum() {
		return m6IdNbankNightOrgnum;
	}

	public String getM6CellMaxInteday() {
		return m6CellMaxInteday;
	}

	public String getM6CellMinInteday() {
		return m6CellMinInteday;
	}

	public String getM6CellTotMons() {
		return m6CellTotMons;
	}

	public String getM6CellAvgMonnum() {
		return m6CellAvgMonnum;
	}

	public String getM6CellMaxMonnum() {
		return m6CellMaxMonnum;
	}

	public String getM6CellMinMonnum() {
		return m6CellMinMonnum;
	}

	public String getM6CellPdlAllnum() {
		return m6CellPdlAllnum;
	}

	public String getM6CellPdlOrgnum() {
		return m6CellPdlOrgnum;
	}

	public String getM6CellCaonAllnum() {
		return m6CellCaonAllnum;
	}

	public String getM6CellCaonOrgnum() {
		return m6CellCaonOrgnum;
	}

	public String getM6CellRelAllnum() {
		return m6CellRelAllnum;
	}

	public String getM6CellRelOrgnum() {
		return m6CellRelOrgnum;
	}

	public String getM6CellCaoffAllnum() {
		return m6CellCaoffAllnum;
	}

	public String getM6CellCaoffOrgnum() {
		return m6CellCaoffOrgnum;
	}

	public String getM6CellCooffAllnum() {
		return m6CellCooffAllnum;
	}

	public String getM6CellCooffOrgnum() {
		return m6CellCooffOrgnum;
	}

	public String getM6CellAfAllnum() {
		return m6CellAfAllnum;
	}

	public String getM6CellAfOrgnum() {
		return m6CellAfOrgnum;
	}

	public String getM6CellCoonAllnum() {
		return m6CellCoonAllnum;
	}

	public String getM6CellCoonOrgnum() {
		return m6CellCoonOrgnum;
	}

	public String getM6CellOthAllnum() {
		return m6CellOthAllnum;
	}

	public String getM6CellOthOrgnum() {
		return m6CellOthOrgnum;
	}

	public String getM6CellBankSelfnum() {
		return m6CellBankSelfnum;
	}

	public String getM6CellBankAllnum() {
		return m6CellBankAllnum;
	}

	public String getM6CellBankTraAllnum() {
		return m6CellBankTraAllnum;
	}

	public String getM6CellBankRetAllnum() {
		return m6CellBankRetAllnum;
	}

	public String getM6CellBankOrgnum() {
		return m6CellBankOrgnum;
	}

	public String getM6CellBankTraOrgnum() {
		return m6CellBankTraOrgnum;
	}

	public String getM6CellBankRetOrgnum() {
		return m6CellBankRetOrgnum;
	}

	public String getM6CellBankTotMons() {
		return m6CellBankTotMons;
	}

	public String getM6CellBankAvgMonnum() {
		return m6CellBankAvgMonnum;
	}

	public String getM6CellBankMaxMonnum() {
		return m6CellBankMaxMonnum;
	}

	public String getM6CellBankMinMonnum() {
		return m6CellBankMinMonnum;
	}

	public String getM6CellBankMaxInteday() {
		return m6CellBankMaxInteday;
	}

	public String getM6CellBankMinInteday() {
		return m6CellBankMinInteday;
	}

	public String getM6CellBankWeekAllnum() {
		return m6CellBankWeekAllnum;
	}

	public String getM6CellBankWeekOrgnum() {
		return m6CellBankWeekOrgnum;
	}

	public String getM6CellBankNightAllnum() {
		return m6CellBankNightAllnum;
	}

	public String getM6CellBankNightOrgnum() {
		return m6CellBankNightOrgnum;
	}

	public String getM6CellNbankSelfnum() {
		return m6CellNbankSelfnum;
	}

	public String getM6CellNbankAllnum() {
		return m6CellNbankAllnum;
	}

	public String getM6CellNbankP2pAllnum() {
		return m6CellNbankP2pAllnum;
	}

	public String getM6CellNbankMcAllnum() {
		return m6CellNbankMcAllnum;
	}

	public String getM6CellNbankCaAllnum() {
		return m6CellNbankCaAllnum;
	}

	public String getM6CellNbankCfAllnum() {
		return m6CellNbankCfAllnum;
	}

	public String getM6CellNbankComAllnum() {
		return m6CellNbankComAllnum;
	}

	public String getM6CellNbankOthAllnum() {
		return m6CellNbankOthAllnum;
	}

	public String getM6CellNbankNsloanAllnum() {
		return m6CellNbankNsloanAllnum;
	}

	public String getM6CellNbankAutofinAllnum() {
		return m6CellNbankAutofinAllnum;
	}

	public String getM6CellNbankSloanAllnum() {
		return m6CellNbankSloanAllnum;
	}

	public String getM6CellNbankConsAllnum() {
		return m6CellNbankConsAllnum;
	}

	public String getM6CellNbankFinleaAllnum() {
		return m6CellNbankFinleaAllnum;
	}

	public String getM6CellNbankElseAllnum() {
		return m6CellNbankElseAllnum;
	}

	public String getM6CellNbankOrgnum() {
		return m6CellNbankOrgnum;
	}

	public String getM6CellNbankP2pOrgnum() {
		return m6CellNbankP2pOrgnum;
	}

	public String getM6CellNbankMcOrgnum() {
		return m6CellNbankMcOrgnum;
	}

	public String getM6CellNbankCaOrgnum() {
		return m6CellNbankCaOrgnum;
	}

	public String getM6CellNbankCfOrgnum() {
		return m6CellNbankCfOrgnum;
	}

	public String getM6CellNbankComOrgnum() {
		return m6CellNbankComOrgnum;
	}

	public String getM6CellNbankOthOrgnum() {
		return m6CellNbankOthOrgnum;
	}

	public String getM6CellNbankNsloanOrgnum() {
		return m6CellNbankNsloanOrgnum;
	}

	public String getM6CellNbankAutofinOrgnum() {
		return m6CellNbankAutofinOrgnum;
	}

	public String getM6CellNbankSloanOrgnum() {
		return m6CellNbankSloanOrgnum;
	}

	public String getM6CellNbankConsOrgnum() {
		return m6CellNbankConsOrgnum;
	}

	public String getM6CellNbankFinleaOrgnum() {
		return m6CellNbankFinleaOrgnum;
	}

	public String getM6CellNbankElseOrgnum() {
		return m6CellNbankElseOrgnum;
	}

	public String getM6CellNbankTotMons() {
		return m6CellNbankTotMons;
	}

	public String getM6CellNbankAvgMonnum() {
		return m6CellNbankAvgMonnum;
	}

	public String getM6CellNbankMaxMonnum() {
		return m6CellNbankMaxMonnum;
	}

	public String getM6CellNbankMinMonnum() {
		return m6CellNbankMinMonnum;
	}

	public String getM6CellNbankMaxInteday() {
		return m6CellNbankMaxInteday;
	}

	public String getM6CellNbankMinInteday() {
		return m6CellNbankMinInteday;
	}

	public String getM6CellNbankWeekAllnum() {
		return m6CellNbankWeekAllnum;
	}

	public String getM6CellNbankWeekOrgnum() {
		return m6CellNbankWeekOrgnum;
	}

	public String getM6CellNbankNightAllnum() {
		return m6CellNbankNightAllnum;
	}

	public String getM6CellNbankNightOrgnum() {
		return m6CellNbankNightOrgnum;
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

	public void setM6IdMaxInteday(String m6IdMaxInteday) {
		this.m6IdMaxInteday = m6IdMaxInteday;
	}

	public void setM6IdMinInteday(String m6IdMinInteday) {
		this.m6IdMinInteday = m6IdMinInteday;
	}

	public void setM6IdTotMons(String m6IdTotMons) {
		this.m6IdTotMons = m6IdTotMons;
	}

	public void setM6IdAvgMonnum(String m6IdAvgMonnum) {
		this.m6IdAvgMonnum = m6IdAvgMonnum;
	}

	public void setM6IdMaxMonnum(String m6IdMaxMonnum) {
		this.m6IdMaxMonnum = m6IdMaxMonnum;
	}

	public void setM6IdMinMonnum(String m6IdMinMonnum) {
		this.m6IdMinMonnum = m6IdMinMonnum;
	}

	public void setM6IdPdlAllnum(String m6IdPdlAllnum) {
		this.m6IdPdlAllnum = m6IdPdlAllnum;
	}

	public void setM6IdPdlOrgnum(String m6IdPdlOrgnum) {
		this.m6IdPdlOrgnum = m6IdPdlOrgnum;
	}

	public void setM6IdCaonAllnum(String m6IdCaonAllnum) {
		this.m6IdCaonAllnum = m6IdCaonAllnum;
	}

	public void setM6IdCaonOrgnum(String m6IdCaonOrgnum) {
		this.m6IdCaonOrgnum = m6IdCaonOrgnum;
	}

	public void setM6IdRelAllnum(String m6IdRelAllnum) {
		this.m6IdRelAllnum = m6IdRelAllnum;
	}

	public void setM6IdRelOrgnum(String m6IdRelOrgnum) {
		this.m6IdRelOrgnum = m6IdRelOrgnum;
	}

	public void setM6IdCaoffAllnum(String m6IdCaoffAllnum) {
		this.m6IdCaoffAllnum = m6IdCaoffAllnum;
	}

	public void setM6IdCaoffOrgnum(String m6IdCaoffOrgnum) {
		this.m6IdCaoffOrgnum = m6IdCaoffOrgnum;
	}

	public void setM6IdCooffAllnum(String m6IdCooffAllnum) {
		this.m6IdCooffAllnum = m6IdCooffAllnum;
	}

	public void setM6IdCooffOrgnum(String m6IdCooffOrgnum) {
		this.m6IdCooffOrgnum = m6IdCooffOrgnum;
	}

	public void setM6IdAfAllnum(String m6IdAfAllnum) {
		this.m6IdAfAllnum = m6IdAfAllnum;
	}

	public void setM6IdAfOrgnum(String m6IdAfOrgnum) {
		this.m6IdAfOrgnum = m6IdAfOrgnum;
	}

	public void setM6IdCoonAllnum(String m6IdCoonAllnum) {
		this.m6IdCoonAllnum = m6IdCoonAllnum;
	}

	public void setM6IdCoonOrgnum(String m6IdCoonOrgnum) {
		this.m6IdCoonOrgnum = m6IdCoonOrgnum;
	}

	public void setM6IdOthAllnum(String m6IdOthAllnum) {
		this.m6IdOthAllnum = m6IdOthAllnum;
	}

	public void setM6IdOthOrgnum(String m6IdOthOrgnum) {
		this.m6IdOthOrgnum = m6IdOthOrgnum;
	}

	public void setM6IdBankSelfnum(String m6IdBankSelfnum) {
		this.m6IdBankSelfnum = m6IdBankSelfnum;
	}

	public void setM6IdBankAllnum(String m6IdBankAllnum) {
		this.m6IdBankAllnum = m6IdBankAllnum;
	}

	public void setM6IdBankTraAllnum(String m6IdBankTraAllnum) {
		this.m6IdBankTraAllnum = m6IdBankTraAllnum;
	}

	public void setM6IdBankRetAllnum(String m6IdBankRetAllnum) {
		this.m6IdBankRetAllnum = m6IdBankRetAllnum;
	}

	public void setM6IdBankOrgnum(String m6IdBankOrgnum) {
		this.m6IdBankOrgnum = m6IdBankOrgnum;
	}

	public void setM6IdBankTraOrgnum(String m6IdBankTraOrgnum) {
		this.m6IdBankTraOrgnum = m6IdBankTraOrgnum;
	}

	public void setM6IdBankRetOrgnum(String m6IdBankRetOrgnum) {
		this.m6IdBankRetOrgnum = m6IdBankRetOrgnum;
	}

	public void setM6IdBankTotMons(String m6IdBankTotMons) {
		this.m6IdBankTotMons = m6IdBankTotMons;
	}

	public void setM6IdBankAvgMonnum(String m6IdBankAvgMonnum) {
		this.m6IdBankAvgMonnum = m6IdBankAvgMonnum;
	}

	public void setM6IdBankMaxMonnum(String m6IdBankMaxMonnum) {
		this.m6IdBankMaxMonnum = m6IdBankMaxMonnum;
	}

	public void setM6IdBankMinMonnum(String m6IdBankMinMonnum) {
		this.m6IdBankMinMonnum = m6IdBankMinMonnum;
	}

	public void setM6IdBankMaxInteday(String m6IdBankMaxInteday) {
		this.m6IdBankMaxInteday = m6IdBankMaxInteday;
	}

	public void setM6IdBankMinInteday(String m6IdBankMinInteday) {
		this.m6IdBankMinInteday = m6IdBankMinInteday;
	}

	public void setM6IdBankWeekAllnum(String m6IdBankWeekAllnum) {
		this.m6IdBankWeekAllnum = m6IdBankWeekAllnum;
	}

	public void setM6IdBankWeekOrgnum(String m6IdBankWeekOrgnum) {
		this.m6IdBankWeekOrgnum = m6IdBankWeekOrgnum;
	}

	public void setM6IdBankNightAllnum(String m6IdBankNightAllnum) {
		this.m6IdBankNightAllnum = m6IdBankNightAllnum;
	}

	public void setM6IdBankNightOrgnum(String m6IdBankNightOrgnum) {
		this.m6IdBankNightOrgnum = m6IdBankNightOrgnum;
	}

	public void setM6IdNbankSelfnum(String m6IdNbankSelfnum) {
		this.m6IdNbankSelfnum = m6IdNbankSelfnum;
	}

	public void setM6IdNbankAllnum(String m6IdNbankAllnum) {
		this.m6IdNbankAllnum = m6IdNbankAllnum;
	}

	public void setM6IdNbankP2pAllnum(String m6IdNbankP2pAllnum) {
		this.m6IdNbankP2pAllnum = m6IdNbankP2pAllnum;
	}

	public void setM6IdNbankMcAllnum(String m6IdNbankMcAllnum) {
		this.m6IdNbankMcAllnum = m6IdNbankMcAllnum;
	}

	public void setM6IdNbankCaAllnum(String m6IdNbankCaAllnum) {
		this.m6IdNbankCaAllnum = m6IdNbankCaAllnum;
	}

	public void setM6IdNbankCfAllnum(String m6IdNbankCfAllnum) {
		this.m6IdNbankCfAllnum = m6IdNbankCfAllnum;
	}

	public void setM6IdNbankComAllnum(String m6IdNbankComAllnum) {
		this.m6IdNbankComAllnum = m6IdNbankComAllnum;
	}

	public void setM6IdNbankOthAllnum(String m6IdNbankOthAllnum) {
		this.m6IdNbankOthAllnum = m6IdNbankOthAllnum;
	}

	public void setM6IdNbankNsloanAllnum(String m6IdNbankNsloanAllnum) {
		this.m6IdNbankNsloanAllnum = m6IdNbankNsloanAllnum;
	}

	public void setM6IdNbankAutofinAllnum(String m6IdNbankAutofinAllnum) {
		this.m6IdNbankAutofinAllnum = m6IdNbankAutofinAllnum;
	}

	public void setM6IdNbankSloanAllnum(String m6IdNbankSloanAllnum) {
		this.m6IdNbankSloanAllnum = m6IdNbankSloanAllnum;
	}

	public void setM6IdNbankConsAllnum(String m6IdNbankConsAllnum) {
		this.m6IdNbankConsAllnum = m6IdNbankConsAllnum;
	}

	public void setM6IdNbankFinleaAllnum(String m6IdNbankFinleaAllnum) {
		this.m6IdNbankFinleaAllnum = m6IdNbankFinleaAllnum;
	}

	public void setM6IdNbankElseAllnum(String m6IdNbankElseAllnum) {
		this.m6IdNbankElseAllnum = m6IdNbankElseAllnum;
	}

	public void setM6IdNbankOrgnum(String m6IdNbankOrgnum) {
		this.m6IdNbankOrgnum = m6IdNbankOrgnum;
	}

	public void setM6IdNbankP2pOrgnum(String m6IdNbankP2pOrgnum) {
		this.m6IdNbankP2pOrgnum = m6IdNbankP2pOrgnum;
	}

	public void setM6IdNbankMcOrgnum(String m6IdNbankMcOrgnum) {
		this.m6IdNbankMcOrgnum = m6IdNbankMcOrgnum;
	}

	public void setM6IdNbankCaOrgnum(String m6IdNbankCaOrgnum) {
		this.m6IdNbankCaOrgnum = m6IdNbankCaOrgnum;
	}

	public void setM6IdNbankCfOrgnum(String m6IdNbankCfOrgnum) {
		this.m6IdNbankCfOrgnum = m6IdNbankCfOrgnum;
	}

	public void setM6IdNbankComOrgnum(String m6IdNbankComOrgnum) {
		this.m6IdNbankComOrgnum = m6IdNbankComOrgnum;
	}

	public void setM6IdNbankOthOrgnum(String m6IdNbankOthOrgnum) {
		this.m6IdNbankOthOrgnum = m6IdNbankOthOrgnum;
	}

	public void setM6IdNbankNsloanOrgnum(String m6IdNbankNsloanOrgnum) {
		this.m6IdNbankNsloanOrgnum = m6IdNbankNsloanOrgnum;
	}

	public void setM6IdNbankAutofinOrgnum(String m6IdNbankAutofinOrgnum) {
		this.m6IdNbankAutofinOrgnum = m6IdNbankAutofinOrgnum;
	}

	public void setM6IdNbankSloanOrgnum(String m6IdNbankSloanOrgnum) {
		this.m6IdNbankSloanOrgnum = m6IdNbankSloanOrgnum;
	}

	public void setM6IdNbankConsOrgnum(String m6IdNbankConsOrgnum) {
		this.m6IdNbankConsOrgnum = m6IdNbankConsOrgnum;
	}

	public void setM6IdNbankFinleaOrgnum(String m6IdNbankFinleaOrgnum) {
		this.m6IdNbankFinleaOrgnum = m6IdNbankFinleaOrgnum;
	}

	public void setM6IdNbankElseOrgnum(String m6IdNbankElseOrgnum) {
		this.m6IdNbankElseOrgnum = m6IdNbankElseOrgnum;
	}

	public void setM6IdNbankTotMons(String m6IdNbankTotMons) {
		this.m6IdNbankTotMons = m6IdNbankTotMons;
	}

	public void setM6IdNbankAvgMonnum(String m6IdNbankAvgMonnum) {
		this.m6IdNbankAvgMonnum = m6IdNbankAvgMonnum;
	}

	public void setM6IdNbankMaxMonnum(String m6IdNbankMaxMonnum) {
		this.m6IdNbankMaxMonnum = m6IdNbankMaxMonnum;
	}

	public void setM6IdNbankMinMonnum(String m6IdNbankMinMonnum) {
		this.m6IdNbankMinMonnum = m6IdNbankMinMonnum;
	}

	public void setM6IdNbankMaxInteday(String m6IdNbankMaxInteday) {
		this.m6IdNbankMaxInteday = m6IdNbankMaxInteday;
	}

	public void setM6IdNbankMinInteday(String m6IdNbankMinInteday) {
		this.m6IdNbankMinInteday = m6IdNbankMinInteday;
	}

	public void setM6IdNbankWeekAllnum(String m6IdNbankWeekAllnum) {
		this.m6IdNbankWeekAllnum = m6IdNbankWeekAllnum;
	}

	public void setM6IdNbankWeekOrgnum(String m6IdNbankWeekOrgnum) {
		this.m6IdNbankWeekOrgnum = m6IdNbankWeekOrgnum;
	}

	public void setM6IdNbankNightAllnum(String m6IdNbankNightAllnum) {
		this.m6IdNbankNightAllnum = m6IdNbankNightAllnum;
	}

	public void setM6IdNbankNightOrgnum(String m6IdNbankNightOrgnum) {
		this.m6IdNbankNightOrgnum = m6IdNbankNightOrgnum;
	}

	public void setM6CellMaxInteday(String m6CellMaxInteday) {
		this.m6CellMaxInteday = m6CellMaxInteday;
	}

	public void setM6CellMinInteday(String m6CellMinInteday) {
		this.m6CellMinInteday = m6CellMinInteday;
	}

	public void setM6CellTotMons(String m6CellTotMons) {
		this.m6CellTotMons = m6CellTotMons;
	}

	public void setM6CellAvgMonnum(String m6CellAvgMonnum) {
		this.m6CellAvgMonnum = m6CellAvgMonnum;
	}

	public void setM6CellMaxMonnum(String m6CellMaxMonnum) {
		this.m6CellMaxMonnum = m6CellMaxMonnum;
	}

	public void setM6CellMinMonnum(String m6CellMinMonnum) {
		this.m6CellMinMonnum = m6CellMinMonnum;
	}

	public void setM6CellPdlAllnum(String m6CellPdlAllnum) {
		this.m6CellPdlAllnum = m6CellPdlAllnum;
	}

	public void setM6CellPdlOrgnum(String m6CellPdlOrgnum) {
		this.m6CellPdlOrgnum = m6CellPdlOrgnum;
	}

	public void setM6CellCaonAllnum(String m6CellCaonAllnum) {
		this.m6CellCaonAllnum = m6CellCaonAllnum;
	}

	public void setM6CellCaonOrgnum(String m6CellCaonOrgnum) {
		this.m6CellCaonOrgnum = m6CellCaonOrgnum;
	}

	public void setM6CellRelAllnum(String m6CellRelAllnum) {
		this.m6CellRelAllnum = m6CellRelAllnum;
	}

	public void setM6CellRelOrgnum(String m6CellRelOrgnum) {
		this.m6CellRelOrgnum = m6CellRelOrgnum;
	}

	public void setM6CellCaoffAllnum(String m6CellCaoffAllnum) {
		this.m6CellCaoffAllnum = m6CellCaoffAllnum;
	}

	public void setM6CellCaoffOrgnum(String m6CellCaoffOrgnum) {
		this.m6CellCaoffOrgnum = m6CellCaoffOrgnum;
	}

	public void setM6CellCooffAllnum(String m6CellCooffAllnum) {
		this.m6CellCooffAllnum = m6CellCooffAllnum;
	}

	public void setM6CellCooffOrgnum(String m6CellCooffOrgnum) {
		this.m6CellCooffOrgnum = m6CellCooffOrgnum;
	}

	public void setM6CellAfAllnum(String m6CellAfAllnum) {
		this.m6CellAfAllnum = m6CellAfAllnum;
	}

	public void setM6CellAfOrgnum(String m6CellAfOrgnum) {
		this.m6CellAfOrgnum = m6CellAfOrgnum;
	}

	public void setM6CellCoonAllnum(String m6CellCoonAllnum) {
		this.m6CellCoonAllnum = m6CellCoonAllnum;
	}

	public void setM6CellCoonOrgnum(String m6CellCoonOrgnum) {
		this.m6CellCoonOrgnum = m6CellCoonOrgnum;
	}

	public void setM6CellOthAllnum(String m6CellOthAllnum) {
		this.m6CellOthAllnum = m6CellOthAllnum;
	}

	public void setM6CellOthOrgnum(String m6CellOthOrgnum) {
		this.m6CellOthOrgnum = m6CellOthOrgnum;
	}

	public void setM6CellBankSelfnum(String m6CellBankSelfnum) {
		this.m6CellBankSelfnum = m6CellBankSelfnum;
	}

	public void setM6CellBankAllnum(String m6CellBankAllnum) {
		this.m6CellBankAllnum = m6CellBankAllnum;
	}

	public void setM6CellBankTraAllnum(String m6CellBankTraAllnum) {
		this.m6CellBankTraAllnum = m6CellBankTraAllnum;
	}

	public void setM6CellBankRetAllnum(String m6CellBankRetAllnum) {
		this.m6CellBankRetAllnum = m6CellBankRetAllnum;
	}

	public void setM6CellBankOrgnum(String m6CellBankOrgnum) {
		this.m6CellBankOrgnum = m6CellBankOrgnum;
	}

	public void setM6CellBankTraOrgnum(String m6CellBankTraOrgnum) {
		this.m6CellBankTraOrgnum = m6CellBankTraOrgnum;
	}

	public void setM6CellBankRetOrgnum(String m6CellBankRetOrgnum) {
		this.m6CellBankRetOrgnum = m6CellBankRetOrgnum;
	}

	public void setM6CellBankTotMons(String m6CellBankTotMons) {
		this.m6CellBankTotMons = m6CellBankTotMons;
	}

	public void setM6CellBankAvgMonnum(String m6CellBankAvgMonnum) {
		this.m6CellBankAvgMonnum = m6CellBankAvgMonnum;
	}

	public void setM6CellBankMaxMonnum(String m6CellBankMaxMonnum) {
		this.m6CellBankMaxMonnum = m6CellBankMaxMonnum;
	}

	public void setM6CellBankMinMonnum(String m6CellBankMinMonnum) {
		this.m6CellBankMinMonnum = m6CellBankMinMonnum;
	}

	public void setM6CellBankMaxInteday(String m6CellBankMaxInteday) {
		this.m6CellBankMaxInteday = m6CellBankMaxInteday;
	}

	public void setM6CellBankMinInteday(String m6CellBankMinInteday) {
		this.m6CellBankMinInteday = m6CellBankMinInteday;
	}

	public void setM6CellBankWeekAllnum(String m6CellBankWeekAllnum) {
		this.m6CellBankWeekAllnum = m6CellBankWeekAllnum;
	}

	public void setM6CellBankWeekOrgnum(String m6CellBankWeekOrgnum) {
		this.m6CellBankWeekOrgnum = m6CellBankWeekOrgnum;
	}

	public void setM6CellBankNightAllnum(String m6CellBankNightAllnum) {
		this.m6CellBankNightAllnum = m6CellBankNightAllnum;
	}

	public void setM6CellBankNightOrgnum(String m6CellBankNightOrgnum) {
		this.m6CellBankNightOrgnum = m6CellBankNightOrgnum;
	}

	public void setM6CellNbankSelfnum(String m6CellNbankSelfnum) {
		this.m6CellNbankSelfnum = m6CellNbankSelfnum;
	}

	public void setM6CellNbankAllnum(String m6CellNbankAllnum) {
		this.m6CellNbankAllnum = m6CellNbankAllnum;
	}

	public void setM6CellNbankP2pAllnum(String m6CellNbankP2pAllnum) {
		this.m6CellNbankP2pAllnum = m6CellNbankP2pAllnum;
	}

	public void setM6CellNbankMcAllnum(String m6CellNbankMcAllnum) {
		this.m6CellNbankMcAllnum = m6CellNbankMcAllnum;
	}

	public void setM6CellNbankCaAllnum(String m6CellNbankCaAllnum) {
		this.m6CellNbankCaAllnum = m6CellNbankCaAllnum;
	}

	public void setM6CellNbankCfAllnum(String m6CellNbankCfAllnum) {
		this.m6CellNbankCfAllnum = m6CellNbankCfAllnum;
	}

	public void setM6CellNbankComAllnum(String m6CellNbankComAllnum) {
		this.m6CellNbankComAllnum = m6CellNbankComAllnum;
	}

	public void setM6CellNbankOthAllnum(String m6CellNbankOthAllnum) {
		this.m6CellNbankOthAllnum = m6CellNbankOthAllnum;
	}

	public void setM6CellNbankNsloanAllnum(String m6CellNbankNsloanAllnum) {
		this.m6CellNbankNsloanAllnum = m6CellNbankNsloanAllnum;
	}

	public void setM6CellNbankAutofinAllnum(String m6CellNbankAutofinAllnum) {
		this.m6CellNbankAutofinAllnum = m6CellNbankAutofinAllnum;
	}

	public void setM6CellNbankSloanAllnum(String m6CellNbankSloanAllnum) {
		this.m6CellNbankSloanAllnum = m6CellNbankSloanAllnum;
	}

	public void setM6CellNbankConsAllnum(String m6CellNbankConsAllnum) {
		this.m6CellNbankConsAllnum = m6CellNbankConsAllnum;
	}

	public void setM6CellNbankFinleaAllnum(String m6CellNbankFinleaAllnum) {
		this.m6CellNbankFinleaAllnum = m6CellNbankFinleaAllnum;
	}

	public void setM6CellNbankElseAllnum(String m6CellNbankElseAllnum) {
		this.m6CellNbankElseAllnum = m6CellNbankElseAllnum;
	}

	public void setM6CellNbankOrgnum(String m6CellNbankOrgnum) {
		this.m6CellNbankOrgnum = m6CellNbankOrgnum;
	}

	public void setM6CellNbankP2pOrgnum(String m6CellNbankP2pOrgnum) {
		this.m6CellNbankP2pOrgnum = m6CellNbankP2pOrgnum;
	}

	public void setM6CellNbankMcOrgnum(String m6CellNbankMcOrgnum) {
		this.m6CellNbankMcOrgnum = m6CellNbankMcOrgnum;
	}

	public void setM6CellNbankCaOrgnum(String m6CellNbankCaOrgnum) {
		this.m6CellNbankCaOrgnum = m6CellNbankCaOrgnum;
	}

	public void setM6CellNbankCfOrgnum(String m6CellNbankCfOrgnum) {
		this.m6CellNbankCfOrgnum = m6CellNbankCfOrgnum;
	}

	public void setM6CellNbankComOrgnum(String m6CellNbankComOrgnum) {
		this.m6CellNbankComOrgnum = m6CellNbankComOrgnum;
	}

	public void setM6CellNbankOthOrgnum(String m6CellNbankOthOrgnum) {
		this.m6CellNbankOthOrgnum = m6CellNbankOthOrgnum;
	}

	public void setM6CellNbankNsloanOrgnum(String m6CellNbankNsloanOrgnum) {
		this.m6CellNbankNsloanOrgnum = m6CellNbankNsloanOrgnum;
	}

	public void setM6CellNbankAutofinOrgnum(String m6CellNbankAutofinOrgnum) {
		this.m6CellNbankAutofinOrgnum = m6CellNbankAutofinOrgnum;
	}

	public void setM6CellNbankSloanOrgnum(String m6CellNbankSloanOrgnum) {
		this.m6CellNbankSloanOrgnum = m6CellNbankSloanOrgnum;
	}

	public void setM6CellNbankConsOrgnum(String m6CellNbankConsOrgnum) {
		this.m6CellNbankConsOrgnum = m6CellNbankConsOrgnum;
	}

	public void setM6CellNbankFinleaOrgnum(String m6CellNbankFinleaOrgnum) {
		this.m6CellNbankFinleaOrgnum = m6CellNbankFinleaOrgnum;
	}

	public void setM6CellNbankElseOrgnum(String m6CellNbankElseOrgnum) {
		this.m6CellNbankElseOrgnum = m6CellNbankElseOrgnum;
	}

	public void setM6CellNbankTotMons(String m6CellNbankTotMons) {
		this.m6CellNbankTotMons = m6CellNbankTotMons;
	}

	public void setM6CellNbankAvgMonnum(String m6CellNbankAvgMonnum) {
		this.m6CellNbankAvgMonnum = m6CellNbankAvgMonnum;
	}

	public void setM6CellNbankMaxMonnum(String m6CellNbankMaxMonnum) {
		this.m6CellNbankMaxMonnum = m6CellNbankMaxMonnum;
	}

	public void setM6CellNbankMinMonnum(String m6CellNbankMinMonnum) {
		this.m6CellNbankMinMonnum = m6CellNbankMinMonnum;
	}

	public void setM6CellNbankMaxInteday(String m6CellNbankMaxInteday) {
		this.m6CellNbankMaxInteday = m6CellNbankMaxInteday;
	}

	public void setM6CellNbankMinInteday(String m6CellNbankMinInteday) {
		this.m6CellNbankMinInteday = m6CellNbankMinInteday;
	}

	public void setM6CellNbankWeekAllnum(String m6CellNbankWeekAllnum) {
		this.m6CellNbankWeekAllnum = m6CellNbankWeekAllnum;
	}

	public void setM6CellNbankWeekOrgnum(String m6CellNbankWeekOrgnum) {
		this.m6CellNbankWeekOrgnum = m6CellNbankWeekOrgnum;
	}

	public void setM6CellNbankNightAllnum(String m6CellNbankNightAllnum) {
		this.m6CellNbankNightAllnum = m6CellNbankNightAllnum;
	}

	public void setM6CellNbankNightOrgnum(String m6CellNbankNightOrgnum) {
		this.m6CellNbankNightOrgnum = m6CellNbankNightOrgnum;
	}

	public String getTrnKey() {
		return trnKey;
	}

	public void setTrnKey(String trnKey) {
		this.trnKey = trnKey;
	}

}
