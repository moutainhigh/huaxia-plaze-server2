package com.huaxia.plaze.modules.pboc.domain.phf;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

/**
 * 标注及声明信息
 * 
 * @author gaoh
 *
 */
@Alias("PF05ZH")
public class PF05ZH implements Serializable {

	private static final long serialVersionUID = -4221896320387164145L;
	private String PF05ZD01;// 标注及声明类型 -- [1..1]
	private String PF05ZQ01;// 标注或声明内容 -- [1..1]
	private String PF05ZR01;// 添加日期 -- [1..1]
	private String identityCardNo;// 身份证号
	private String uniqueRelid;// 每个身份证号码关联的唯一uuid值
	private String relateId;// 每个住房公积金参缴记录的关联id

	public String getPF05ZD01() {
		return PF05ZD01;
	}

	public void setPF05ZD01(String pF05ZD01) {
		PF05ZD01 = pF05ZD01;
	}

	public String getPF05ZQ01() {
		return PF05ZQ01;
	}

	public void setPF05ZQ01(String pF05ZQ01) {
		PF05ZQ01 = pF05ZQ01;
	}

	public String getPF05ZR01() {
		return PF05ZR01;
	}

	public void setPF05ZR01(String pF05ZR01) {
		PF05ZR01 = pF05ZR01;
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
