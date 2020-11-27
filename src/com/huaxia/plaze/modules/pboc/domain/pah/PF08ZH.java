package com.huaxia.plaze.modules.pboc.domain.pah;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

/**
 * 标注及声明信息
 * 
 * @author gaoh
 *
 */
@Alias("PF08ZH")
public class PF08ZH implements Serializable {

	private static final long serialVersionUID = 3686155269808827413L;
	private String PF08ZD01;// 标注及声明类型 -- [1..1]
	private String PF08ZQ01;// 标注或声明内容 -- [1..1]
	private String PF08ZR01;// 添加日期 -- [1..1]
	private String identityCardNo;// 身份证号
	private String uniqueRelid;// 每个身份证号码关联的唯一uuid值
	private String relateId;// 每个行政奖励记录的关联id

	public String getPF08ZD01() {
		return PF08ZD01;
	}

	public void setPF08ZD01(String pF08ZD01) {
		PF08ZD01 = pF08ZD01;
	}

	public String getPF08ZQ01() {
		return PF08ZQ01;
	}

	public void setPF08ZQ01(String pF08ZQ01) {
		PF08ZQ01 = pF08ZQ01;
	}

	public String getPF08ZR01() {
		return PF08ZR01;
	}

	public void setPF08ZR01(String pF08ZR01) {
		PF08ZR01 = pF08ZR01;
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
