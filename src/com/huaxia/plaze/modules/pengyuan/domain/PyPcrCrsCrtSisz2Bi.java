package com.huaxia.plaze.modules.pengyuan.domain;

/**
 * 鹏元个人信用报告个人社会保险个人基本信息表
 * 
 * @author User
 *
 */
public class PyPcrCrsCrtSisz2Bi {

	// 记录编号
	private String uuid;
	// 创建时间
	private String crtTime;
	// 创建用户
	private String crtUser;
	// 交易编号
	private String trnId;
	// 姓名
	private String name;
	// 身份证号码
	private String documentNo;
	// 性别ID
	private String gender;
	// 户籍状况ID
	private String registeredStatus;
	// 电脑号
	private String insuranceNo;
	// 当前状态
	private String currentStatus;
	// 开始参保日期
	private String startDate;
	// 最近申报缴费基数
	private Double insurePay;
	// 最近实际缴费基数
	private Double factInsurePay;
	// 最近一次缴保的单位名称
	private String lastUnitName;
	// 参保单位类型
	private String unitType;
	// 单位参保人数
	private Integer unitPersonCount;
	// 兼职单位数
	private Integer pluralityCount;
	// 养老保险参保情况ID
	private String endowmentState;
	// 医疗保险参保情况ID
	private String hospitalState;
	// 医疗缴费类别
	private String hospitalCategory;
	// 生育保险参保情况ID
	private String bearingState;
	// 工伤保险参保情况ID
	private String injureState;
	// 失业保险参保情况ID
	private String idlenessState;
	// 养老保险专户余额
	private Double endowmentAmount;
	// 医疗保险专户余额
	private Double hospitalAmount;
	// 信息获取日期
	private String infoDate;

	private String appId;

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
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

	public String getTrnId() {
		return trnId;
	}

	public void setTrnId(String trnId) {
		this.trnId = trnId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDocumentNo() {
		return documentNo;
	}

	public void setDocumentNo(String documentNo) {
		this.documentNo = documentNo;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getRegisteredStatus() {
		return registeredStatus;
	}

	public void setRegisteredStatus(String registeredStatus) {
		this.registeredStatus = registeredStatus;
	}

	public String getInsuranceNo() {
		return insuranceNo;
	}

	public void setInsuranceNo(String insuranceNo) {
		this.insuranceNo = insuranceNo;
	}

	public String getCurrentStatus() {
		return currentStatus;
	}

	public void setCurrentStatus(String currentStatus) {
		this.currentStatus = currentStatus;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public Double getInsurePay() {
		return insurePay;
	}

	public void setInsurePay(Double insurePay) {
		this.insurePay = insurePay;
	}

	public Double getFactInsurePay() {
		return factInsurePay;
	}

	public void setFactInsurePay(Double factInsurePay) {
		this.factInsurePay = factInsurePay;
	}

	public String getLastUnitName() {
		return lastUnitName;
	}

	public void setLastUnitName(String lastUnitName) {
		this.lastUnitName = lastUnitName;
	}

	public String getUnitType() {
		return unitType;
	}

	public void setUnitType(String unitType) {
		this.unitType = unitType;
	}

	public Integer getUnitPersonCount() {
		return unitPersonCount;
	}

	public void setUnitPersonCount(Integer unitPersonCount) {
		this.unitPersonCount = unitPersonCount;
	}

	public Integer getPluralityCount() {
		return pluralityCount;
	}

	public void setPluralityCount(Integer pluralityCount) {
		this.pluralityCount = pluralityCount;
	}

	public String getEndowmentState() {
		return endowmentState;
	}

	public void setEndowmentState(String endowmentState) {
		this.endowmentState = endowmentState;
	}

	public String getHospitalState() {
		return hospitalState;
	}

	public void setHospitalState(String hospitalState) {
		this.hospitalState = hospitalState;
	}

	public String getHospitalCategory() {
		return hospitalCategory;
	}

	public void setHospitalCategory(String hospitalCategory) {
		this.hospitalCategory = hospitalCategory;
	}

	public String getBearingState() {
		return bearingState;
	}

	public void setBearingState(String bearingState) {
		this.bearingState = bearingState;
	}

	public String getInjureState() {
		return injureState;
	}

	public void setInjureState(String injureState) {
		this.injureState = injureState;
	}

	public String getIdlenessState() {
		return idlenessState;
	}

	public void setIdlenessState(String idlenessState) {
		this.idlenessState = idlenessState;
	}

	public Double getEndowmentAmount() {
		return endowmentAmount;
	}

	public void setEndowmentAmount(Double endowmentAmount) {
		this.endowmentAmount = endowmentAmount;
	}

	public Double getHospitalAmount() {
		return hospitalAmount;
	}

	public void setHospitalAmount(Double hospitalAmount) {
		this.hospitalAmount = hospitalAmount;
	}

	public String getInfoDate() {
		return infoDate;
	}

	public void setInfoDate(String infoDate) {
		this.infoDate = infoDate;
	}

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	@Override
	public String toString() {
		return "PyPcrCrsCrtSisz2Bi [uuid=" + uuid + ", crtTime=" + crtTime + ", crtUser=" + crtUser + ", trnId=" + trnId
				+ ", name=" + name + ", documentNo=" + documentNo + ", gender=" + gender + ", registeredStatus="
				+ registeredStatus + ", insuranceNo=" + insuranceNo + ", currentStatus=" + currentStatus
				+ ", startDate=" + startDate + ", insurePay=" + insurePay + ", factInsurePay=" + factInsurePay
				+ ", lastUnitName=" + lastUnitName + ", unitType=" + unitType + ", unitPersonCount=" + unitPersonCount
				+ ", pluralityCount=" + pluralityCount + ", endowmentState=" + endowmentState + ", hospitalState="
				+ hospitalState + ", hospitalCategory=" + hospitalCategory + ", bearingState=" + bearingState
				+ ", injureState=" + injureState + ", idlenessState=" + idlenessState + ", endowmentAmount="
				+ endowmentAmount + ", hospitalAmount=" + hospitalAmount + ", infoDate=" + infoDate + ", appId=" + appId
				+ "]";
	}

	

}
