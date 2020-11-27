package com.huaxia.plaze.modules.tongdun.domain;

import java.util.Date;
/**
 * 多头借贷基本输出参数表
 * @author liuwei
 *
 */
public class MulBorBase {
		
		//主键唯一
		private String uuid;
			
		//创建时间
		private Date crtTime;
			
		//创建用户
		private String crtUser;
		
		//逻辑外键
	    private String pkUuid;
				
	    //业务的主键，实现不同系统之间的同步
	    private String trnId;
	    
		//申请件编号
		private String appId;
				
		//身份证号码
		private String certNo;
				
		//手机号码
		private String mobile;
		
		//是否电泳成功
		private String success;
		
		//进件ID
		private String ID;

		//当工作流或者模块调用失败时返回错误码，详见错误代码表
		private String reasonCode;

		//返回错误调用的字段
		private String nextService;

		//错误详情描述
		private String reasonDesc;
		
		//调用失败返回结果
		private String errorInfo;
		
		//风险分数
		private Integer finalScore;
		
		//值为PASS或 REVIEW 或 REJECT
		private String finalDecision;
		
		//身份证_信贷逾期名单
		private String  courtCloseRisk1;
		
		//身份证_信贷逾期名单
		private String  overdueRisk2;
		
		//身份证_法院失信
		private String  courtRisk3;

		//身份证_信贷逾期后还款
		private String  overdueRepayRisk4;

		//身份证_欠税公司法人代表
		private String  companyTaxowingRisk5;
		
		//身份证_法院执行
		private String  courtZhixingRisk6;
		
		//身份证_车贷风险名单
		private String  carLoanRisk7;
		
		//身份证_欠税
		private String  taxOwingRisk8;
		
		//身份证_犯罪通缉
		private String  crimeRisk9;
		
		//身份证_助学贷款欠费
		private String  studentLoanRisk10;
		
		//身份证_车辆租赁违约
		private String  vehicleLeaseDefaultRisk11;
		
		//身份证_欠款公司法人代表
		private String  companyPayingRisk12;
		
		//身份证_故意违章乘车
		private String  deliberateViolationRisk13;
		
		//手机号_虚假号码
		private String  falseMobileRisk14;
		
		//手机号_通信小号
		private String  alimobileRisk15;
		
		//手机号_信贷逾期
		private String overdueRisk16;
		
		//手机号_车辆租赁违约
		private String  vehicleLeaseDefaultRisk17;

		//手机号_欠款公司法人代表
		private String  companyPayingRisk18;
		
		//手机号_信贷逾期后还款
		private String  overdueRepayRisk19;
		
		//身份证_高风险关注名单
		private String  followHigh20;
		
		//身份证_中风险关注名单
		private String  followMedium21;
		
		//身份证_低风险关注名单
		private String  followLow22;
		
		//手机号_高风险关注名单
		private String  followHigh23;
		
		//手机号_中风险关注名单
		private String  followMedium24;
		
		//手机号_低风险关注名单
		private String  followLow25;
		
		//第三方数据库是否有这个记录
		private String extSearchResult;

	
		public String getSuccess() {
			return success;
		}

		public void setSuccess(String success) {
			this.success = success;
		}

		public String getID() {
			return ID;
		}

		public void setID(String iD) {
			ID = iD;
		}

		public String getReasonCode() {
			return reasonCode;
		}

		public void setReasonCode(String reasonCode) {
			this.reasonCode = reasonCode;
		}

		public String getNextService() {
			return nextService;
		}

		public void setNextService(String nextService) {
			this.nextService = nextService;
		}

		public String getReasonDesc() {
			return reasonDesc;
		}

		public void setReasonDesc(String reasonDesc) {
			this.reasonDesc = reasonDesc;
		}

		public String getErrorInfo() {
			return errorInfo;
		}

		public void setErrorInfo(String errorInfo) {
			this.errorInfo = errorInfo;
		}

		public Integer getFinalScore() {
			return finalScore;
		}

		public void setFinalScore(Integer finalScore) {
			this.finalScore = finalScore;
		}

		public String getFinalDecision() {
			return finalDecision;
		}

		public void setFinalDecision(String finalDecision) {
			this.finalDecision = finalDecision;
		}

		public String getCourtCloseRisk1() {
			return courtCloseRisk1;
		}

		public void setCourtCloseRisk1(String courtCloseRisk1) {
			this.courtCloseRisk1 = courtCloseRisk1;
		}

		public String getOverdueRisk2() {
			return overdueRisk2;
		}

		public void setOverdueRisk2(String overdueRisk2) {
			this.overdueRisk2 = overdueRisk2;
		}

		public String getCourtRisk3() {
			return courtRisk3;
		}

		public void setCourtRisk3(String courtRisk3) {
			this.courtRisk3 = courtRisk3;
		}

		public String getOverdueRepayRisk4() {
			return overdueRepayRisk4;
		}

		public void setOverdueRepayRisk4(String overdueRepayRisk4) {
			this.overdueRepayRisk4 = overdueRepayRisk4;
		}

		public String getCompanyTaxowingRisk5() {
			return companyTaxowingRisk5;
		}

		public void setCompanyTaxowingRisk5(String companyTaxowingRisk5) {
			this.companyTaxowingRisk5 = companyTaxowingRisk5;
		}

		public String getCourtZhixingRisk6() {
			return courtZhixingRisk6;
		}

		public void setCourtZhixingRisk6(String courtZhixingRisk6) {
			this.courtZhixingRisk6 = courtZhixingRisk6;
		}

		public String getCarLoanRisk7() {
			return carLoanRisk7;
		}

		public void setCarLoanRisk7(String carLoanRisk7) {
			this.carLoanRisk7 = carLoanRisk7;
		}

		public String getTaxOwingRisk8() {
			return taxOwingRisk8;
		}

		public void setTaxOwingRisk8(String taxOwingRisk8) {
			this.taxOwingRisk8 = taxOwingRisk8;
		}

		public String getCrimeRisk9() {
			return crimeRisk9;
		}

		public void setCrimeRisk9(String crimeRisk9) {
			this.crimeRisk9 = crimeRisk9;
		}

		public String getStudentLoanRisk10() {
			return studentLoanRisk10;
		}

		public void setStudentLoanRisk10(String studentLoanRisk10) {
			this.studentLoanRisk10 = studentLoanRisk10;
		}

		public String getVehicleLeaseDefaultRisk11() {
			return vehicleLeaseDefaultRisk11;
		}

		public void setVehicleLeaseDefaultRisk11(String vehicleLeaseDefaultRisk11) {
			this.vehicleLeaseDefaultRisk11 = vehicleLeaseDefaultRisk11;
		}

		public String getCompanyPayingRisk12() {
			return companyPayingRisk12;
		}

		public void setCompanyPayingRisk12(String companyPayingRisk12) {
			this.companyPayingRisk12 = companyPayingRisk12;
		}

		public String getDeliberateViolationRisk13() {
			return deliberateViolationRisk13;
		}

		public void setDeliberateViolationRisk13(String deliberateViolationRisk13) {
			this.deliberateViolationRisk13 = deliberateViolationRisk13;
		}

		public String getFalseMobileRisk14() {
			return falseMobileRisk14;
		}

		public void setFalseMobileRisk14(String falseMobileRisk14) {
			this.falseMobileRisk14 = falseMobileRisk14;
		}

		public String getAlimobileRisk15() {
			return alimobileRisk15;
		}

		public void setAlimobileRisk15(String alimobileRisk15) {
			this.alimobileRisk15 = alimobileRisk15;
		}

		public String getOverdueRisk16() {
			return overdueRisk16;
		}

		public void setOverdueRisk16(String overdueRisk16) {
			this.overdueRisk16 = overdueRisk16;
		}

		public String getVehicleLeaseDefaultRisk17() {
			return vehicleLeaseDefaultRisk17;
		}

		public void setVehicleLeaseDefaultRisk17(String vehicleLeaseDefaultRisk17) {
			this.vehicleLeaseDefaultRisk17 = vehicleLeaseDefaultRisk17;
		}

		public String getCompanyPayingRisk18() {
			return companyPayingRisk18;
		}

		public void setCompanyPayingRisk18(String companyPayingRisk18) {
			this.companyPayingRisk18 = companyPayingRisk18;
		}

		public String getOverdueRepayRisk19() {
			return overdueRepayRisk19;
		}

		public void setOverdueRepayRisk19(String overdueRepayRisk19) {
			this.overdueRepayRisk19 = overdueRepayRisk19;
		}

		public String getFollowHigh20() {
			return followHigh20;
		}

		public void setFollowHigh20(String followHigh20) {
			this.followHigh20 = followHigh20;
		}

		public String getFollowMedium21() {
			return followMedium21;
		}

		public void setFollowMedium21(String followMedium21) {
			this.followMedium21 = followMedium21;
		}

		public String getFollowLow22() {
			return followLow22;
		}

		public void setFollowLow22(String followLow22) {
			this.followLow22 = followLow22;
		}

		public String getFollowHigh23() {
			return followHigh23;
		}

		public void setFollowHigh23(String followHigh23) {
			this.followHigh23 = followHigh23;
		}

		public String getFollowMedium24() {
			return followMedium24;
		}

		public void setFollowMedium24(String followMedium24) {
			this.followMedium24 = followMedium24;
		}

		public String getFollowLow25() {
			return followLow25;
		}

		public void setFollowLow25(String followLow25) {
			this.followLow25 = followLow25;
		}

		public String getUuid() {
			return uuid;
		}

		public void setUuid(String uuid) {
			this.uuid = uuid;
		}

		public Date getCrtTime() {
			return crtTime;
		}

		public void setCrtTime(Date crtTime) {
			this.crtTime = crtTime;
		}

		public String getCrtUser() {
			return crtUser;
		}

		public void setCrtUser(String crtUser) {
			this.crtUser = crtUser;
		}

		public String getPkUuid() {
			return pkUuid;
		}

		public void setPkUuid(String pkUuid) {
			this.pkUuid = pkUuid;
		}

		public String getAppId() {
			return appId;
		}

		public void setAppId(String appId) {
			this.appId = appId;
		}

		public String getCertNo() {
			return certNo;
		}

		public void setCertNo(String certNo) {
			this.certNo = certNo;
		}

		public String getMobile() {
			return mobile;
		}

		public void setMobile(String mobile) {
			this.mobile = mobile;
		}

		public String getTrnId() {
			return trnId;
		}

		public void setTrnId(String trnId) {
			this.trnId = trnId;
		}

		public String getExtSearchResult() {
			return extSearchResult;
		}

		public void setExtSearchResult(String extSearchResult) {
			this.extSearchResult = extSearchResult;
		}

		@Override
		public String toString() {
			return "MulBorBase [uuid=" + uuid + ", crtTime=" + crtTime + ", crtUser=" + crtUser + ", pkUuid=" + pkUuid
					+ ", trnId=" + trnId + ", appId=" + appId + ", certNo=" + certNo + ", mobile=" + mobile
					+ ", success=" + success + ", ID=" + ID + ", reasonCode=" + reasonCode + ", nextService="
					+ nextService + ", reasonDesc=" + reasonDesc + ", errorInfo=" + errorInfo + ", finalScore="
					+ finalScore + ", finalDecision=" + finalDecision + ", courtCloseRisk1=" + courtCloseRisk1
					+ ", overdueRisk2=" + overdueRisk2 + ", courtRisk3=" + courtRisk3 + ", overdueRepayRisk4="
					+ overdueRepayRisk4 + ", companyTaxowingRisk5=" + companyTaxowingRisk5 + ", courtZhixingRisk6="
					+ courtZhixingRisk6 + ", carLoanRisk7=" + carLoanRisk7 + ", taxOwingRisk8=" + taxOwingRisk8
					+ ", crimeRisk9=" + crimeRisk9 + ", studentLoanRisk10=" + studentLoanRisk10
					+ ", vehicleLeaseDefaultRisk11=" + vehicleLeaseDefaultRisk11 + ", companyPayingRisk12="
					+ companyPayingRisk12 + ", deliberateViolationRisk13=" + deliberateViolationRisk13
					+ ", falseMobileRisk14=" + falseMobileRisk14 + ", alimobileRisk15=" + alimobileRisk15
					+ ", overdueRisk16=" + overdueRisk16 + ", vehicleLeaseDefaultRisk17=" + vehicleLeaseDefaultRisk17
					+ ", companyPayingRisk18=" + companyPayingRisk18 + ", overdueRepayRisk19=" + overdueRepayRisk19
					+ ", followHigh20=" + followHigh20 + ", followMedium21=" + followMedium21 + ", followLow22="
					+ followLow22 + ", followHigh23=" + followHigh23 + ", followMedium24=" + followMedium24
					+ ", followLow25=" + followLow25 + ", extSearchResult=" + extSearchResult + "]";
		}
		
}
