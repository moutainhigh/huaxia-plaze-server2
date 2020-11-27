package com.huaxia.plaze.modules.pengyuan.domain;

import java.util.List;

public class PyCisReportCollection {

	// 鹏元个人信用报告报告表
	private static PyPcrCrsCrt pyPcrCrsCrt;
	// 鹏元个人信用报告查询条件表
	private List<PyPcrCrsCrtQcs> pyPcrCrsCrtQcsList;
	// 鹏元个人信用报告个人基本信息表
	private PyPcrCrsCrtPbi pyPcrCrsCrtPbi;
	// 鹏元个人信用报告摘要信息表
	private PyPcrCrsCrtPbiSi pyPcrCrsCrtPbiSi;
	// 鹏元个人信用报告最新基本信息表
	private PyPcrCrsCrtPbiLbi pyPcrCrsCrtPbiLbi;
	// 鹏元个人信用报告证件信息表
	private List<PyPcrCrsCrtPbiDis> pyPcrCrsCrtPbiDisList;
	// 鹏元个人信用报告地址信息表
	private List<PyPcrCrsCrtPbiAis> pyPcrCrsCrtPbiAisList;
	// 鹏元个人信用报告历次任职信息表
	private List<PyPcrCrsCrtPbiJis> pyPcrCrsCrtPbiJisList;
	// 鹏元个人信用报告曾用名信息表
	private List<PyPcrCrsCrtPbiHnis> pyPcrCrsCrtPbiHnisList;
	// 鹏元个人信用报告身份警示信息表
	private List<PyPcrCrsCrtPbiDa> pyPcrCrsCrtPbiDaList;
	// 鹏元个人信用报告银行信用信息表
	private PyPcrCrsCrtBdi pyPcrCrsCrtBdi;
	// 鹏元个人信用报告贷款信息账户基本信息表
	private List<PyCrsCrtBdiCisAbi> pyCrsCrtBdiCisAbiList;
	// 鹏元个人信用报告银行信用信息信用卡账户动态信息表
	private List<PyPcrCrsCrtBdiCisAci> pyPcrCrsCrtBdiCisAciList;
	// 鹏元个人信用报告银行信用信息信用卡状态变动记录表
	private List<PyPcrCrsCrtBdiCisHs> pyPcrCrsCrtBdiCisHsList;
	// 鹏元个人信用报告银行信用信息信用卡最近12个月的月透支余额表
	private List<PyPcrCrsCrtBdiCisO12m> pyPcrCrsCrtBdiCisO12mList;
	// 鹏元个人信用报告银行信用信息信用卡最近12个月的月消费金额表
	private List<PyPcrCrsCrtBdiCisPp12m> pyPcrCrsCrtBdiCisPp12mList;
	// 鹏元个人信用报告银行信用信息信用卡最近12个月的月消费次数表
	private List<PyPcrCrsCrtBdiCisPt12m> pyPcrCrsCrtBdiCisPt12mList;
	// 鹏元个人信用报告银行信用信息信用卡最近12个月的月取现金额表
	private List<PyPcrCrsCrtBdiCisWa12m> pyPcrCrsCrtBdiCisWa12mList;
	// 鹏元个人信用报告银行信用信息信用卡最近12个月的月取现次数表
	private List<PyPcrCrsCrtBdiCisWt12m> pyPcrCrsCrtBdiCisWt12mList;
	// 鹏元个人信用报告贷款信息共同贷款人信息表
	private List<PyPcrCrsCrtBdiLisBs> pyPcrCrsCrtBdiLisBsList;
	// 鹏元个人信用报告贷款信息账户基本信息表
	private List<PyPcrCrsCrtBdiLisAbi> pyPcrCrsCrtBdiLisAbiList;
	// 鹏元个人信用报告贷款信息账户动态信息表
	private List<PyPcrCrsCrtBdiLisAci> pyPcrCrsCrtBdiLisAciList;
	// 鹏元个人信用报告贷款信息最近24月还款情况表
	private List<PyPcrCrsCrtBdiLisPl24m> pyPcrCrsCrtBdiLisPl24mList;
	// 鹏元个人信用报告贷款信息贷款账户状态变动记录表
	private List<PyPcrCrsCrtBdiLisHs> pyPcrCrsCrtBdiLisHsList;
	// 鹏元个人信用报告银行概要信息表
	private PyCrsCrtBsi pyCrsCrtBsi;
	// 鹏元个人信用报告个人社会保险信息表
	private PyPcrCrsCrtSisz2 pyPcrCrsCrtSisz2;
	// 鹏元个人信用报告个人社会保险个人基本信息表
	private PyPcrCrsCrtSisz2Bi pyPcrCrsCrtSisz2Bi;
	// 鹏元个人信用报告个人社会保险兼职单位信息
	private List<PyPcrCrsCrtSisz2Pui> pyPcrCrsCrtSisz2PuiList;
	// 鹏元个人信用报告个人社会保险近5年内参保历史信息表
	private List<PyPcrCrsCrtSisz2Hi5y> pyPcrCrsCrtSisz2Hi5yList;
	// 鹏元个人信用报告个人社会保险近5年内参保信息汇总表
	private PyPcrCrsCrtSisz2Si5y pyPcrCrsCrtSisz2Si5y;
	// 鹏元个人信用报告特别信息表
	private PyPcrCrsCrtSi pyPcrCrsCrtSi;
	// 鹏元个人信用报告特别信息内容表
	private List<PyPcrCrsCrtSiItm> PyPcrCrsCrtSiItmList;
	// 鹏元个人信用报告身份证号码校验信息表
	private PyPcrCrsCrtIvi pyPcrCrsCrtIvi;
	// 鹏元个人信用报告身份证号码校验信息内容表
	private PyPcrCrsCrtIviItm pyPcrCrsCrtIviItm;
	// 鹏元个人信用报告深圳基本摘要信息表
	private PyPcrCrsCrtSzbsi pyPcrCrsCrtSzbsi;
	// 鹏元个人信用报告深圳基本摘要信息表
	private PyPcrCrsCrtSzbsiBss pyPcrCrsCrtSzbsiBss;
	// 鹏元个人信用报告深圳基本摘要信息银行信息表
	private PyPcrCrsCrtSzbsiBks pyPcrCrsCrtSzbsiBks;
	// 鹏元个人信用报告深圳基本摘要信息社保信息表
	private PyPcrCrsCrtSzbsiIs pyPcrCrsCrtSzbsiIs;
	// 鹏元个人信用报告深圳基本摘要信息评分信息表
	private PyPcrCrsCrtSzbsiSs pyPcrCrsCrtSzbsiSs;
	// 鹏元个人信用报告深圳基本摘要信息电话欠费信息表
	private PyPcrCrsCrtSzbsiTs pyPcrCrsCrtSzbsiTs;
	// 鹏元个人信用报告近两年历史查询明细表
	private PyPcrCrsCrtHqi pyPcrCrsCrtHqi;
	// 鹏元个人信用报告近两年历史查询明细内容表
	private List<PyPcrCrsCrtHqiItm> pyPcrCrsCrtHqiItmList;
	public static PyPcrCrsCrt getPyPcrCrsCrt() {
		return pyPcrCrsCrt;
	}
	public static void setPyPcrCrsCrt(PyPcrCrsCrt pyPcrCrsCrt) {
		PyCisReportCollection.pyPcrCrsCrt = pyPcrCrsCrt;
	}
	public List<PyPcrCrsCrtQcs> getPyPcrCrsCrtQcsList() {
		return pyPcrCrsCrtQcsList;
	}
	public void setPyPcrCrsCrtQcsList(List<PyPcrCrsCrtQcs> pyPcrCrsCrtQcsList) {
		this.pyPcrCrsCrtQcsList = pyPcrCrsCrtQcsList;
	}
	public PyPcrCrsCrtPbi getPyPcrCrsCrtPbi() {
		return pyPcrCrsCrtPbi;
	}
	public void setPyPcrCrsCrtPbi(PyPcrCrsCrtPbi pyPcrCrsCrtPbi) {
		this.pyPcrCrsCrtPbi = pyPcrCrsCrtPbi;
	}
	public PyPcrCrsCrtPbiSi getPyPcrCrsCrtPbiSi() {
		return pyPcrCrsCrtPbiSi;
	}
	public void setPyPcrCrsCrtPbiSi(PyPcrCrsCrtPbiSi pyPcrCrsCrtPbiSi) {
		this.pyPcrCrsCrtPbiSi = pyPcrCrsCrtPbiSi;
	}
	public PyPcrCrsCrtPbiLbi getPyPcrCrsCrtPbiLbi() {
		return pyPcrCrsCrtPbiLbi;
	}
	public void setPyPcrCrsCrtPbiLbi(PyPcrCrsCrtPbiLbi pyPcrCrsCrtPbiLbi) {
		this.pyPcrCrsCrtPbiLbi = pyPcrCrsCrtPbiLbi;
	}
	public List<PyPcrCrsCrtPbiDis> getPyPcrCrsCrtPbiDisList() {
		return pyPcrCrsCrtPbiDisList;
	}
	public void setPyPcrCrsCrtPbiDisList(List<PyPcrCrsCrtPbiDis> pyPcrCrsCrtPbiDisList) {
		this.pyPcrCrsCrtPbiDisList = pyPcrCrsCrtPbiDisList;
	}
	public List<PyPcrCrsCrtPbiAis> getPyPcrCrsCrtPbiAisList() {
		return pyPcrCrsCrtPbiAisList;
	}
	public void setPyPcrCrsCrtPbiAisList(List<PyPcrCrsCrtPbiAis> pyPcrCrsCrtPbiAisList) {
		this.pyPcrCrsCrtPbiAisList = pyPcrCrsCrtPbiAisList;
	}
	public List<PyPcrCrsCrtPbiJis> getPyPcrCrsCrtPbiJisList() {
		return pyPcrCrsCrtPbiJisList;
	}
	public void setPyPcrCrsCrtPbiJisList(List<PyPcrCrsCrtPbiJis> pyPcrCrsCrtPbiJisList) {
		this.pyPcrCrsCrtPbiJisList = pyPcrCrsCrtPbiJisList;
	}
	public List<PyPcrCrsCrtPbiHnis> getPyPcrCrsCrtPbiHnisList() {
		return pyPcrCrsCrtPbiHnisList;
	}
	public void setPyPcrCrsCrtPbiHnisList(List<PyPcrCrsCrtPbiHnis> pyPcrCrsCrtPbiHnisList) {
		this.pyPcrCrsCrtPbiHnisList = pyPcrCrsCrtPbiHnisList;
	}
	public List<PyPcrCrsCrtPbiDa> getPyPcrCrsCrtPbiDaList() {
		return pyPcrCrsCrtPbiDaList;
	}
	public void setPyPcrCrsCrtPbiDaList(List<PyPcrCrsCrtPbiDa> pyPcrCrsCrtPbiDaList) {
		this.pyPcrCrsCrtPbiDaList = pyPcrCrsCrtPbiDaList;
	}
	public PyPcrCrsCrtBdi getPyPcrCrsCrtBdi() {
		return pyPcrCrsCrtBdi;
	}
	public void setPyPcrCrsCrtBdi(PyPcrCrsCrtBdi pyPcrCrsCrtBdi) {
		this.pyPcrCrsCrtBdi = pyPcrCrsCrtBdi;
	}
	public List<PyCrsCrtBdiCisAbi> getPyCrsCrtBdiCisAbiList() {
		return pyCrsCrtBdiCisAbiList;
	}
	public void setPyCrsCrtBdiCisAbiList(List<PyCrsCrtBdiCisAbi> pyCrsCrtBdiCisAbiList) {
		this.pyCrsCrtBdiCisAbiList = pyCrsCrtBdiCisAbiList;
	}
	public List<PyPcrCrsCrtBdiCisAci> getPyPcrCrsCrtBdiCisAciList() {
		return pyPcrCrsCrtBdiCisAciList;
	}
	public void setPyPcrCrsCrtBdiCisAciList(List<PyPcrCrsCrtBdiCisAci> pyPcrCrsCrtBdiCisAciList) {
		this.pyPcrCrsCrtBdiCisAciList = pyPcrCrsCrtBdiCisAciList;
	}
	public List<PyPcrCrsCrtBdiCisHs> getPyPcrCrsCrtBdiCisHsList() {
		return pyPcrCrsCrtBdiCisHsList;
	}
	public void setPyPcrCrsCrtBdiCisHsList(List<PyPcrCrsCrtBdiCisHs> pyPcrCrsCrtBdiCisHsList) {
		this.pyPcrCrsCrtBdiCisHsList = pyPcrCrsCrtBdiCisHsList;
	}
	public List<PyPcrCrsCrtBdiCisO12m> getPyPcrCrsCrtBdiCisO12mList() {
		return pyPcrCrsCrtBdiCisO12mList;
	}
	public void setPyPcrCrsCrtBdiCisO12mList(List<PyPcrCrsCrtBdiCisO12m> pyPcrCrsCrtBdiCisO12mList) {
		this.pyPcrCrsCrtBdiCisO12mList = pyPcrCrsCrtBdiCisO12mList;
	}
	public List<PyPcrCrsCrtBdiCisPp12m> getPyPcrCrsCrtBdiCisPp12mList() {
		return pyPcrCrsCrtBdiCisPp12mList;
	}
	public void setPyPcrCrsCrtBdiCisPp12mList(List<PyPcrCrsCrtBdiCisPp12m> pyPcrCrsCrtBdiCisPp12mList) {
		this.pyPcrCrsCrtBdiCisPp12mList = pyPcrCrsCrtBdiCisPp12mList;
	}
	
	public List<PyPcrCrsCrtBdiCisPt12m> getPyPcrCrsCrtBdiCisPt12mList() {
		return pyPcrCrsCrtBdiCisPt12mList;
	}
	public void setPyPcrCrsCrtBdiCisPt12mList(List<PyPcrCrsCrtBdiCisPt12m> pyPcrCrsCrtBdiCisPt12mList) {
		this.pyPcrCrsCrtBdiCisPt12mList = pyPcrCrsCrtBdiCisPt12mList;
	}
	public List<PyPcrCrsCrtBdiCisWa12m> getPyPcrCrsCrtBdiCisWa12mList() {
		return pyPcrCrsCrtBdiCisWa12mList;
	}
	public void setPyPcrCrsCrtBdiCisWa12mList(List<PyPcrCrsCrtBdiCisWa12m> pyPcrCrsCrtBdiCisWa12mList) {
		this.pyPcrCrsCrtBdiCisWa12mList = pyPcrCrsCrtBdiCisWa12mList;
	}
	public List<PyPcrCrsCrtBdiCisWt12m> getPyPcrCrsCrtBdiCisWt12mList() {
		return pyPcrCrsCrtBdiCisWt12mList;
	}
	public void setPyPcrCrsCrtBdiCisWt12mList(List<PyPcrCrsCrtBdiCisWt12m> pyPcrCrsCrtBdiCisWt12mList) {
		this.pyPcrCrsCrtBdiCisWt12mList = pyPcrCrsCrtBdiCisWt12mList;
	}
	public List<PyPcrCrsCrtBdiLisBs> getPyPcrCrsCrtBdiLisBsList() {
		return pyPcrCrsCrtBdiLisBsList;
	}
	public void setPyPcrCrsCrtBdiLisBsList(List<PyPcrCrsCrtBdiLisBs> pyPcrCrsCrtBdiLisBsList) {
		this.pyPcrCrsCrtBdiLisBsList = pyPcrCrsCrtBdiLisBsList;
	}
	public List<PyPcrCrsCrtBdiLisAbi> getPyPcrCrsCrtBdiLisAbiList() {
		return pyPcrCrsCrtBdiLisAbiList;
	}
	public void setPyPcrCrsCrtBdiLisAbiList(List<PyPcrCrsCrtBdiLisAbi> pyPcrCrsCrtBdiLisAbiList) {
		this.pyPcrCrsCrtBdiLisAbiList = pyPcrCrsCrtBdiLisAbiList;
	}
	public List<PyPcrCrsCrtBdiLisAci> getPyPcrCrsCrtBdiLisAciList() {
		return pyPcrCrsCrtBdiLisAciList;
	}
	public void setPyPcrCrsCrtBdiLisAciList(List<PyPcrCrsCrtBdiLisAci> pyPcrCrsCrtBdiLisAciList) {
		this.pyPcrCrsCrtBdiLisAciList = pyPcrCrsCrtBdiLisAciList;
	}
	public List<PyPcrCrsCrtBdiLisPl24m> getPyPcrCrsCrtBdiLisPl24mList() {
		return pyPcrCrsCrtBdiLisPl24mList;
	}
	public void setPyPcrCrsCrtBdiLisPl24mList(List<PyPcrCrsCrtBdiLisPl24m> pyPcrCrsCrtBdiLisPl24mList) {
		this.pyPcrCrsCrtBdiLisPl24mList = pyPcrCrsCrtBdiLisPl24mList;
	}
	public List<PyPcrCrsCrtBdiLisHs> getPyPcrCrsCrtBdiLisHsList() {
		return pyPcrCrsCrtBdiLisHsList;
	}
	public void setPyPcrCrsCrtBdiLisHsList(List<PyPcrCrsCrtBdiLisHs> pyPcrCrsCrtBdiLisHsList) {
		this.pyPcrCrsCrtBdiLisHsList = pyPcrCrsCrtBdiLisHsList;
	}
	public PyCrsCrtBsi getPyCrsCrtBsi() {
		return pyCrsCrtBsi;
	}
	public void setPyCrsCrtBsi(PyCrsCrtBsi pyCrsCrtBsi) {
		this.pyCrsCrtBsi = pyCrsCrtBsi;
	}
	public PyPcrCrsCrtSisz2 getPyPcrCrsCrtSisz2() {
		return pyPcrCrsCrtSisz2;
	}
	public void setPyPcrCrsCrtSisz2(PyPcrCrsCrtSisz2 pyPcrCrsCrtSisz2) {
		this.pyPcrCrsCrtSisz2 = pyPcrCrsCrtSisz2;
	}
	public PyPcrCrsCrtSisz2Bi getPyPcrCrsCrtSisz2Bi() {
		return pyPcrCrsCrtSisz2Bi;
	}
	public void setPyPcrCrsCrtSisz2Bi(PyPcrCrsCrtSisz2Bi pyPcrCrsCrtSisz2Bi) {
		this.pyPcrCrsCrtSisz2Bi = pyPcrCrsCrtSisz2Bi;
	}
	public List<PyPcrCrsCrtSisz2Pui> getPyPcrCrsCrtSisz2PuiList() {
		return pyPcrCrsCrtSisz2PuiList;
	}
	public void setPyPcrCrsCrtSisz2PuiList(List<PyPcrCrsCrtSisz2Pui> pyPcrCrsCrtSisz2PuiList) {
		this.pyPcrCrsCrtSisz2PuiList = pyPcrCrsCrtSisz2PuiList;
	}
	public List<PyPcrCrsCrtSisz2Hi5y> getPyPcrCrsCrtSisz2Hi5yList() {
		return pyPcrCrsCrtSisz2Hi5yList;
	}
	public void setPyPcrCrsCrtSisz2Hi5yList(List<PyPcrCrsCrtSisz2Hi5y> pyPcrCrsCrtSisz2Hi5yList) {
		this.pyPcrCrsCrtSisz2Hi5yList = pyPcrCrsCrtSisz2Hi5yList;
	}
	public PyPcrCrsCrtSisz2Si5y getPyPcrCrsCrtSisz2Si5y() {
		return pyPcrCrsCrtSisz2Si5y;
	}
	public void setPyPcrCrsCrtSisz2Si5y(PyPcrCrsCrtSisz2Si5y pyPcrCrsCrtSisz2Si5y) {
		this.pyPcrCrsCrtSisz2Si5y = pyPcrCrsCrtSisz2Si5y;
	}
	public PyPcrCrsCrtSi getPyPcrCrsCrtSi() {
		return pyPcrCrsCrtSi;
	}
	public void setPyPcrCrsCrtSi(PyPcrCrsCrtSi pyPcrCrsCrtSi) {
		this.pyPcrCrsCrtSi = pyPcrCrsCrtSi;
	}
	public List<PyPcrCrsCrtSiItm> getPyPcrCrsCrtSiItmList() {
		return PyPcrCrsCrtSiItmList;
	}
	public void setPyPcrCrsCrtSiItmList(List<PyPcrCrsCrtSiItm> pyPcrCrsCrtSiItmList) {
		PyPcrCrsCrtSiItmList = pyPcrCrsCrtSiItmList;
	}
	public PyPcrCrsCrtIvi getPyPcrCrsCrtIvi() {
		return pyPcrCrsCrtIvi;
	}
	public void setPyPcrCrsCrtIvi(PyPcrCrsCrtIvi pyPcrCrsCrtIvi) {
		this.pyPcrCrsCrtIvi = pyPcrCrsCrtIvi;
	}
	public PyPcrCrsCrtIviItm getPyPcrCrsCrtIviItm() {
		return pyPcrCrsCrtIviItm;
	}
	public void setPyPcrCrsCrtIviItm(PyPcrCrsCrtIviItm pyPcrCrsCrtIviItm) {
		this.pyPcrCrsCrtIviItm = pyPcrCrsCrtIviItm;
	}
	public PyPcrCrsCrtSzbsi getPyPcrCrsCrtSzbsi() {
		return pyPcrCrsCrtSzbsi;
	}
	public void setPyPcrCrsCrtSzbsi(PyPcrCrsCrtSzbsi pyPcrCrsCrtSzbsi) {
		this.pyPcrCrsCrtSzbsi = pyPcrCrsCrtSzbsi;
	}
	public PyPcrCrsCrtSzbsiBss getPyPcrCrsCrtSzbsiBss() {
		return pyPcrCrsCrtSzbsiBss;
	}
	public void setPyPcrCrsCrtSzbsiBss(PyPcrCrsCrtSzbsiBss pyPcrCrsCrtSzbsiBss) {
		this.pyPcrCrsCrtSzbsiBss = pyPcrCrsCrtSzbsiBss;
	}
	public PyPcrCrsCrtSzbsiBks getPyPcrCrsCrtSzbsiBks() {
		return pyPcrCrsCrtSzbsiBks;
	}
	public void setPyPcrCrsCrtSzbsiBks(PyPcrCrsCrtSzbsiBks pyPcrCrsCrtSzbsiBks) {
		this.pyPcrCrsCrtSzbsiBks = pyPcrCrsCrtSzbsiBks;
	}
	public PyPcrCrsCrtSzbsiIs getPyPcrCrsCrtSzbsiIs() {
		return pyPcrCrsCrtSzbsiIs;
	}
	public void setPyPcrCrsCrtSzbsiIs(PyPcrCrsCrtSzbsiIs pyPcrCrsCrtSzbsiIs) {
		this.pyPcrCrsCrtSzbsiIs = pyPcrCrsCrtSzbsiIs;
	}
	public PyPcrCrsCrtSzbsiSs getPyPcrCrsCrtSzbsiSs() {
		return pyPcrCrsCrtSzbsiSs;
	}
	public void setPyPcrCrsCrtSzbsiSs(PyPcrCrsCrtSzbsiSs pyPcrCrsCrtSzbsiSs) {
		this.pyPcrCrsCrtSzbsiSs = pyPcrCrsCrtSzbsiSs;
	}
	public PyPcrCrsCrtSzbsiTs getPyPcrCrsCrtSzbsiTs() {
		return pyPcrCrsCrtSzbsiTs;
	}
	public void setPyPcrCrsCrtSzbsiTs(PyPcrCrsCrtSzbsiTs pyPcrCrsCrtSzbsiTs) {
		this.pyPcrCrsCrtSzbsiTs = pyPcrCrsCrtSzbsiTs;
	}
	public PyPcrCrsCrtHqi getPyPcrCrsCrtHqi() {
		return pyPcrCrsCrtHqi;
	}
	public void setPyPcrCrsCrtHqi(PyPcrCrsCrtHqi pyPcrCrsCrtHqi) {
		this.pyPcrCrsCrtHqi = pyPcrCrsCrtHqi;
	}
	public List<PyPcrCrsCrtHqiItm> getPyPcrCrsCrtHqiItmList() {
		return pyPcrCrsCrtHqiItmList;
	}
	public void setPyPcrCrsCrtHqiItmList(List<PyPcrCrsCrtHqiItm> pyPcrCrsCrtHqiItmList) {
		this.pyPcrCrsCrtHqiItmList = pyPcrCrsCrtHqiItmList;
	}

	
}
