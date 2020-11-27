package com.huaxia.plaze.modules.pboc.domain.pos;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

/**
 * 标注及声明信息单元数据
 * 
 * @author gaoh
 *
 */
@Alias("PG01data")
public class PG01data implements Serializable {

	private static final long serialVersionUID = -3743808706316830522L;
	private String PG010D01;// 对象类型 -- [1..1]
	private String PG010D02;// 对象标识 -- [1..1]
	private String PG010S01;// 标注及声明类型个数 -- [1..1]
	private String identityCardNo;// 身份证号
	private String uniqueRelid;// 每个身份证号码关联的唯一uuid值
	private String relateId;// 每个其他标注及声明的 关联id

	public String getPG010D01() {
		return PG010D01;
	}

	public void setPG010D01(String pG010D01) {
		PG010D01 = pG010D01;
	}

	public String getPG010D02() {
		return PG010D02;
	}

	public void setPG010D02(String pG010D02) {
		PG010D02 = pG010D02;
	}

	public String getPG010S01() {
		return PG010S01;
	}

	public void setPG010S01(String pG010S01) {
		PG010S01 = pG010S01;
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
