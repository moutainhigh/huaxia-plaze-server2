package com.huaxia.plaze.modules.pboc.domain.pcj;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

/**
 * 标注及声明信息段数据
 * 
 * @author gaoh
 *
 */
@Alias("PF02Zdata")
public class PF02Zdata implements Serializable {

	private static final long serialVersionUID = -4678656416844459731L;
	private String PF02ZS01;// 标注及声明个数 -- [1..1]
	private String identityCardNo;// 身份证号
	private String uniqueRelid;// 每个身份证号码关联的唯一uuid值
	private String relateId;// 每个民事判决记录信息单元的关联id

	public String getPF02ZS01() {
		return PF02ZS01;
	}

	public void setPF02ZS01(String pF02ZS01) {
		PF02ZS01 = pF02ZS01;
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
