package com.huaxia.plaze.modules.pboc.domain.pcj;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

/**
 * 标注及声明信息
 * 
 * @author gaoh
 *
 */
@Alias("PF02ZH")
public class PF02ZH implements Serializable {

	private static final long serialVersionUID = 6485362119204861710L;
	private String PF02ZD01;// 标注及声明类型 -- [1..1]
	private String PF02ZQ01;// 标注或声明内容 -- [1..1]
	private String PF02ZR01;// 添加日期 -- [1..1]
	private String identityCardNo;// 身份证号
	private String uniqueRelid;// 每个身份证号码关联的唯一uuid值
	private String relateId;// 每个民事判决记录信息单元的关联id

	public String getPF02ZD01() {
		return PF02ZD01;
	}

	public void setPF02ZD01(String pF02ZD01) {
		PF02ZD01 = pF02ZD01;
	}

	public String getPF02ZQ01() {
		return PF02ZQ01;
	}

	public void setPF02ZQ01(String pF02ZQ01) {
		PF02ZQ01 = pF02ZQ01;
	}

	public String getPF02ZR01() {
		return PF02ZR01;
	}

	public void setPF02ZR01(String pF02ZR01) {
		PF02ZR01 = pF02ZR01;
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
