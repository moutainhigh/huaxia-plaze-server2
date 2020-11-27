package com.huaxia.plaze.modules.pboc.domain.pot;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

/**
 * 标注及声明信息
 * 
 * @author gaoh
 *
 */
@Alias("PF01ZH")
public class PF01ZH implements Serializable {

	private static final long serialVersionUID = 6740613822352463398L;
	private String PF01ZD01;// 标注及声明类型 -- [1..1]
	private String PF01ZQ01;// 标注或声明内容 -- [1..1]
	private String PF01ZR01;// 添加日期 -- [1..1]
	private String identityCardNo;// 身份证号
	private String uniqueRelid;// 每个身份证号码关联的唯一uuid值
	private String relateId;// 每个欠税记录信息单元的关联id

	public String getPF01ZD01() {
		return PF01ZD01;
	}

	public void setPF01ZD01(String pF01ZD01) {
		PF01ZD01 = pF01ZD01;
	}

	public String getPF01ZQ01() {
		return PF01ZQ01;
	}

	public void setPF01ZQ01(String pF01ZQ01) {
		PF01ZQ01 = pF01ZQ01;
	}

	public String getPF01ZR01() {
		return PF01ZR01;
	}

	public void setPF01ZR01(String pF01ZR01) {
		PF01ZR01 = pF01ZR01;
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
