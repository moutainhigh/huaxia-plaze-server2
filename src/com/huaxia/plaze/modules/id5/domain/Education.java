package com.huaxia.plaze.modules.id5.domain;

import java.io.Serializable;

/**
 * 第三方 & 学历
 * 
 * @author zhiguo.li
 *
 */
public class Education implements Serializable {

	private static final long serialVersionUID = -8285790562562255225L;

	//处理标示 0-处理成功 2-处理失败
	private String flag;
	
	// 申请件编号
	private String trnId;
	
	// 查询状态
	private String queryStatus;
	
	// 查询结果
	private String queryResult;

	// 创建日期
	private String crtTime;

	// 创建人
	private String crtUser;

	// 最后操作日期
	private String lstUpdTime;

	// 最后更新人
	private String lstUpdUser;
	
	//唯一标识 
	private String wybs;

	// 姓名
	private String xm;

	// 身份证号
	private String zjhm;


	// 毕业院校
	private String yxmc;

	// 学历
	private String cc;

	//学习形式
	private String xxxs;
	
	//毕业时间
	private String byrq;
	
	//毕结业结论
	private String bjyjl;
	
	//照片
	private String photo;
	
	//毕业院校类型
	private String schoolType;
	
	//毕业年限
	private String bynx;
	
	//学习形式(_交行)
	private String xxxsJH;
	
	//学历层次(交行)
	private String ccJH;
	
	//是否全日制
	private String fulltime;
	
	//照片类型
	private String photostyle;
	
	//学历类别
	private String xllb;
	
	//学校名称
	private String schoolName;
	
	//学校曾用名
	private  String hisname;
	
	//学校所在城市
	private String schoolCity;
	
	//学校性质(公办/民办)
	private String schoolTrade;
	
	//学校所属主管单位
	private String organization;
	
	//学校类型(理工/医药/综合)
	private String schoolNature;
	
	//学校类别(211工程院校)
	private String schoolCategory;
	
	//办学层次
	private String level;
	
	//办学形式(全日制/函授)
	private String educationApproach;
	
	//是否为985
	private String is985;
	
	//是否为211
	private String is211;
	
	//学校创建日期
	private String createDate;
	
	//创建年限
	private String createYear;
	
	//学校院士人数
	private String academicianNum;
	
	//博士后流动站数目
	private String bshldzNum;
	
	//博士点数目
	private String bsdNum;
	
	//硕士点数目
	private String ssdNum;
	
	//国家重点学科数目
	private String zdxkNum;
	
	//理科录取数目
	private String lklqpc;
	
	//文科录取批次
	private String wklqpc;
	
	//学校详细地址
	private String xxdz;

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getTrnId() {
		return trnId;
	}

	public void setTrnId(String trnId) {
		this.trnId = trnId;
	}

	public String getXm() {
		return xm;
	}

	public void setXm(String xm) {
		this.xm = xm;
	}

	public String getZjhm() {
		return zjhm;
	}

	public void setZjhm(String zjhm) {
		this.zjhm = zjhm;
	}


	public String getYxmc() {
		return yxmc;
	}

	public void setYxmc(String yxmc) {
		this.yxmc = yxmc;
	}

	public String getCc() {
		return cc;
	}

	public void setCc(String cc) {
		this.cc = cc;
	}


	public String getByrq() {
		return byrq;
	}

	public void setByrq(String byrq) {
		this.byrq = byrq;
	}

	public String getBjyjl() {
		return bjyjl;
	}

	public void setBjyjl(String bjyjl) {
		this.bjyjl = bjyjl;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getSchoolType() {
		return schoolType;
	}

	public void setSchoolType(String schoolType) {
		this.schoolType = schoolType;
	}

	public String getBynx() {
		return bynx;
	}

	public void setBynx(String bynx) {
		this.bynx = bynx;
	}

	public String getXxxsJH() {
		return xxxsJH;
	}

	public void setXxxsJH(String xxxsJH) {
		this.xxxsJH = xxxsJH;
	}

	public String getCcJH() {
		return ccJH;
	}

	public void setCcJH(String ccJH) {
		this.ccJH = ccJH;
	}

	public String getFulltime() {
		return fulltime;
	}

	public void setFulltime(String fulltime) {
		this.fulltime = fulltime;
	}

	public String getPhotostyle() {
		return photostyle;
	}

	public void setPhotostyle(String photostyle) {
		this.photostyle = photostyle;
	}

	public String getXllb() {
		return xllb;
	}

	public void setXllb(String xllb) {
		this.xllb = xllb;
	}

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public String getHisname() {
		return hisname;
	}

	public void setHisname(String hisname) {
		this.hisname = hisname;
	}

	public String getSchoolCity() {
		return schoolCity;
	}

	public void setSchoolCity(String schoolCity) {
		this.schoolCity = schoolCity;
	}

	public String getSchoolTrade() {
		return schoolTrade;
	}

	public void setSchoolTrade(String schoolTrade) {
		this.schoolTrade = schoolTrade;
	}

	public String getOrganization() {
		return organization;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
	}

	public String getSchoolCategory() {
		return schoolCategory;
	}

	public void setSchoolCategory(String schoolCategory) {
		this.schoolCategory = schoolCategory;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getEducationApproach() {
		return educationApproach;
	}

	public void setEducationApproach(String educationApproach) {
		this.educationApproach = educationApproach;
	}

	public String getIs985() {
		return is985;
	}

	public void setIs985(String is985) {
		this.is985 = is985;
	}

	public String getIs211() {
		return is211;
	}

	public void setIs211(String is211) {
		this.is211 = is211;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getCreateYear() {
		return createYear;
	}

	public void setCreateYear(String createYear) {
		this.createYear = createYear;
	}

	public String getAcademicianNum() {
		return academicianNum;
	}

	public void setAcademicianNum(String academicianNum) {
		this.academicianNum = academicianNum;
	}

	public String getBshldzNum() {
		return bshldzNum;
	}

	public void setBshldzNum(String bshldzNum) {
		this.bshldzNum = bshldzNum;
	}

	public String getBsdNum() {
		return bsdNum;
	}

	public void setBsdNum(String bsdNum) {
		this.bsdNum = bsdNum;
	}

	public String getSsdNum() {
		return ssdNum;
	}

	public void setSsdNum(String ssdNum) {
		this.ssdNum = ssdNum;
	}

	public String getZdxkNum() {
		return zdxkNum;
	}

	public void setZdxkNum(String zdxkNum) {
		this.zdxkNum = zdxkNum;
	}

	public String getLklqpc() {
		return lklqpc;
	}

	public void setLklqpc(String lklqpc) {
		this.lklqpc = lklqpc;
	}

	public String getWklqpc() {
		return wklqpc;
	}

	public void setWklqpc(String wklqpc) {
		this.wklqpc = wklqpc;
	}

	public String getXxdz() {
		return xxdz;
	}

	public void setXxdz(String xxdz) {
		this.xxdz = xxdz;
	}

	public String getQueryStatus() {
		return queryStatus;
	}

	public void setQueryStatus(String queryStatus) {
		this.queryStatus = queryStatus;
	}

	public String getQueryResult() {
		return queryResult;
	}

	public void setQueryResult(String queryResult) {
		this.queryResult = queryResult;
	}

	public String getCrtTime() {
		return crtTime;
	}

	public void setCrtTime(String crtTime) {
		this.crtTime = crtTime;
	}

	public String getCrtUser() {
		return crtUser;
	}

	public void setCrtUser(String crtUser) {
		this.crtUser = crtUser;
	}

	public String getLstUpdTime() {
		return lstUpdTime;
	}

	public void setLstUpdTime(String lstUpdTime) {
		this.lstUpdTime = lstUpdTime;
	}

	public String getLstUpdUser() {
		return lstUpdUser;
	}

	public void setLstUpdUser(String lstUpdUser) {
		this.lstUpdUser = lstUpdUser;
	}

	public String getWybs() {
		return wybs;
	}

	public void setWybs(String wybs) {
		this.wybs = wybs;
	}

	public String getSchoolNature() {
		return schoolNature;
	}

	public void setSchoolNature(String schoolNature) {
		this.schoolNature = schoolNature;
	}

	public String getXxxs() {
		return xxxs;
	}

	public void setXxxs(String xxxs) {
		this.xxxs = xxxs;
	}
	
	
	
	
}
