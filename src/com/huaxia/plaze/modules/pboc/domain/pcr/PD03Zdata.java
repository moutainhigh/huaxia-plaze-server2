package com.huaxia.plaze.modules.pboc.domain.pcr;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

/**
 * 标注及声明信息段数据
 * 
 * @author gaoh
 *
 */
@Alias("PD03Zdata")
public class PD03Zdata implements Serializable {

	private static final long serialVersionUID = -5222659030277271533L;
	private String PD03ZS01;// 标注及声明个数 [1..1]
	private String identityCardNo;// 身份证号
	private String uniqueRelid;// 每个身份证号码关联的唯一uuid值
	private String relateId;// 每个相关还款责任信息单元的关联id

	public String getPD03ZS01() {
		return PD03ZS01;
	}

	public void setPD03ZS01(String pD03ZS01) {
		PD03ZS01 = pD03ZS01;
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