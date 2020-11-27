package com.huaxia.plaze.modules.pboc.domain.pda;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

/**
 * 标注及声明信息
 * 
 * @author gaoh
 *
 */
@Alias("PD01ZH")
public class PD01ZH implements Serializable {

	private static final long serialVersionUID = 5141641760194250118L;
	private String PD01ZD01;// 标注及声明类型 -- [1..1]
	private String PD01ZQ01;// 标注或声明内容 -- [1..1]
	private String PD01ZR01;// 添加日期 -- [1..1]
	private String identityCardNo;// 身份证号
	private String uniqueRelid;// 每个身份证号码关联的唯一uuid值
	private String relateId;// 每个 借贷账户信息单元 的关联id

	public String getPD01ZD01() {
		return PD01ZD01;
	}

	public void setPD01ZD01(String pD01ZD01) {
		PD01ZD01 = pD01ZD01;
	}

	public String getPD01ZQ01() {
		return PD01ZQ01;
	}

	public void setPD01ZQ01(String pD01ZQ01) {
		PD01ZQ01 = pD01ZQ01;
	}

	public String getPD01ZR01() {
		return PD01ZR01;
	}

	public void setPD01ZR01(String pD01ZR01) {
		PD01ZR01 = pD01ZR01;
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
