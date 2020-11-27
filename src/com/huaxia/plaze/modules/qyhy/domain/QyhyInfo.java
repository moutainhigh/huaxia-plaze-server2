package com.huaxia.plaze.modules.qyhy.domain;

import java.io.Serializable;
import java.util.List;

/**
 * 企业行业信息总对象
 * @author gaoh
 */
public class QyhyInfo implements Serializable{
	private static final long serialVersionUID = -5515874060256784769L;
   
	private QyhyInfoData qyhyInfoData;//企业行业信息 成功失败 参数存储表
	
	private QyhyInfoBasic qyhyInfoBasic;//BASIC 照面信息		
	
	private List<QyhyInfoOrgBasic> qyhyInfoOrgBasicList;//ORGBASIC 组织机构列表		
	
	private QyhyInfoOrgDetail qyhyInfoOrgDetail;//ORGDETAIL 组织机构详情		
	
	private List<QyhyInfoPerson> qyhyInfoPersonList;//PERSON 主要管理人员		
	
	private List<QyhyInfoPunishBreak> qyhyInfoPunishBreakList;//PUNISHBREAK 失信被执行人信息		
	
	private List<QyhyInfoShareHolder> qyhyInfoShareHolderList;//SHAREHOLDER 股东及出资信息 	
	
    private QyhyInfoMetaData  qyhyInfoMetaData;//METADATA 元数据来源		
    
   // private QyhyStore qyhyStore;//企业信息库 
    
	public QyhyInfoData getQyhyInfoData() {
		return qyhyInfoData;
	}

	public void setQyhyInfoData(QyhyInfoData qyhyInfoData) {
		this.qyhyInfoData = qyhyInfoData;
	}

	public QyhyInfoBasic getQyhyInfoBasic() {
		return qyhyInfoBasic;
	}

	public void setQyhyInfoBasic(QyhyInfoBasic qyhyInfoBasic) {
		this.qyhyInfoBasic = qyhyInfoBasic;
	}

	public List<QyhyInfoOrgBasic> getQyhyInfoOrgBasicList() {
		return qyhyInfoOrgBasicList;
	}

	public void setQyhyInfoOrgBasicList(List<QyhyInfoOrgBasic> qyhyInfoOrgBasicList) {
		this.qyhyInfoOrgBasicList = qyhyInfoOrgBasicList;
	}

	public QyhyInfoOrgDetail getQyhyInfoOrgDetail() {
		return qyhyInfoOrgDetail;
	}

	public void setQyhyInfoOrgDetail(QyhyInfoOrgDetail qyhyInfoOrgDetail) {
		this.qyhyInfoOrgDetail = qyhyInfoOrgDetail;
	}

	public List<QyhyInfoPerson> getQyhyInfoPersonList() {
		return qyhyInfoPersonList;
	}

	public void setQyhyInfoPersonList(List<QyhyInfoPerson> qyhyInfoPersonList) {
		this.qyhyInfoPersonList = qyhyInfoPersonList;
	}

	public List<QyhyInfoPunishBreak> getQyhyInfoPunishBreakList() {
		return qyhyInfoPunishBreakList;
	}

	public void setQyhyInfoPunishBreakList(List<QyhyInfoPunishBreak> qyhyInfoPunishBreakList) {
		this.qyhyInfoPunishBreakList = qyhyInfoPunishBreakList;
	}

	public List<QyhyInfoShareHolder> getQyhyInfoShareHolderList() {
		return qyhyInfoShareHolderList;
	}

	public void setQyhyInfoShareHolderList(List<QyhyInfoShareHolder> qyhyInfoShareHolderList) {
		this.qyhyInfoShareHolderList = qyhyInfoShareHolderList;
	}

	public QyhyInfoMetaData getQyhyInfoMetaData() {
		return qyhyInfoMetaData;
	}

	public void setQyhyInfoMetaData(QyhyInfoMetaData qyhyInfoMetaData) {
		this.qyhyInfoMetaData = qyhyInfoMetaData;
	}

	/*public QyhyStore getQyhyStore() {
		return qyhyStore;
	}

	public void setQyhyStore(QyhyStore qyhyStore) {
		this.qyhyStore = qyhyStore;
	}*/
	
}