package com.huaxia.plaze.modules.tongdun.domain;

import java.util.List;

public class MulBorInfo {
	
	private MulBorBase mulBorBase;//多头借贷的子表
	
	private List<MulBorRiskItem> mulBorRiskItemList; //风险项目的共同属性表

	private List<MulBorBlackList> mulBorBlackListList;
		
	private List<MulBorDescreditCount> mulBorDescreditCountList;
	
	private List<MulBorGreyList> mulBorGreyListList;
	
	private MulBorAntifraudIndex mulBorAntifraudIndex;
	
	//业务的主键，实现不同系统之间的同步
    private String trnId;
    
	//申请件编号
	private String appId;
	
	public String getTrnId() {
		return trnId;
	}
	public void setTrnId(String trnId) {
		this.trnId = trnId;
	}
	public String getAppId() {
		return appId;
	}
	public void setAppId(String appId) {
		this.appId = appId;
	}
	
	public MulBorBase getMulBorBase() {
		return mulBorBase;
	}

	public void setMulBorBase(MulBorBase mulBorBase) {
		this.mulBorBase = mulBorBase;
	}

	public List<MulBorRiskItem> getMulBorRiskItemList() {
		return mulBorRiskItemList;
	}

	public void setMulBorRiskItemList(List<MulBorRiskItem> mulBorRiskItemList) {
		this.mulBorRiskItemList = mulBorRiskItemList;
	}

	public List<MulBorBlackList> getMulBorBlackListList() {
		return mulBorBlackListList;
	}

	public void setMulBorBlackListList(List<MulBorBlackList> mulBorBlackListList) {
		this.mulBorBlackListList = mulBorBlackListList;
	}

	public List<MulBorDescreditCount> getMulBorDescreditCountList() {
		return mulBorDescreditCountList;
	}

	public void setMulBorDescreditCountList(List<MulBorDescreditCount> mulBorDescreditCountList) {
		this.mulBorDescreditCountList = mulBorDescreditCountList;
	}

	public List<MulBorGreyList> getMulBorGreyListList() {
		return mulBorGreyListList;
	}

	public void setMulBorGreyListList(List<MulBorGreyList> mulBorGreyListList) {
		this.mulBorGreyListList = mulBorGreyListList;
	}

	public MulBorAntifraudIndex getMulBorAntifraudIndex() {
		return mulBorAntifraudIndex;
	}

	public void setMulBorAntifraudIndex(MulBorAntifraudIndex mulBorAntifraudIndex) {
		this.mulBorAntifraudIndex = mulBorAntifraudIndex;
	}
	@Override
	public String toString() {
		return "MulBorInfo [mulBorBase=" + mulBorBase + ", mulBorRiskItemList=" + mulBorRiskItemList
				+ ", mulBorBlackListList=" + mulBorBlackListList + ", mulBorDescreditCountList="
				+ mulBorDescreditCountList + ", mulBorGreyListList=" + mulBorGreyListList + ", mulBorAntifraudIndex="
				+ mulBorAntifraudIndex + ", trnId=" + trnId + ", appId=" + appId + "]";
	}
}
