package com.huaxia.plaze.modules.pboc.domain.phf;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

/**
 * 标注及声明信息段数据
 * 
 * @author gaoh
 *
 */
@Alias("PF05Zdata")
public class PF05Zdata implements Serializable {

	private static final long serialVersionUID = -7776084030895409624L;
	private String PF05ZS01;// 标注及声明个数 --
	private String identityCardNo;// 身份证号
	private String uniqueRelid;// 每个身份证号码关联的唯一uuid值
	private String relateId;// 每个住房公积金参缴记录的关联id

	public String getPF05ZS01() {
		return PF05ZS01;
	}

	public void setPF05ZS01(String pF05ZS01) {
		PF05ZS01 = pF05ZS01;
	}

	public String getIdentityCardNo() {
		return identityCardNo;
	}

	public void setIdentityCardNo(String identityCardNo) {
		this.identityCardNo = identityCardNo;
	}

	public String getUniqueRelid() {
		return uniqueRelid;
	}

	public void setUniqueRelid(String uniqueRelid) {
		this.uniqueRelid = uniqueRelid;
	}

	public String getRelateId() {
		return relateId;
	}

	public void setRelateId(String relateId) {
		this.relateId = relateId;
	}

}
