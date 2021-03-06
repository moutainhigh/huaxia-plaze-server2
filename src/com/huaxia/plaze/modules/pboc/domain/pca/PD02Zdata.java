package com.huaxia.plaze.modules.pboc.domain.pca;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

/**
 * 标注及声明信息段数据
 * 
 * @author gaoh
 *
 */
@Alias("PD02Zdata")
public class PD02Zdata implements Serializable {

	private static final long serialVersionUID = -9222981603059494529L;
	private String PD02ZS01;// 标注及声明个数 -- [1..1]
	private String identityCardNo;// 身份证号
	private String uniqueRelid;// 每个身份证号码关联的唯一uuid值
	private String relateId;// 每个 授信协议信息单元 的关联id

	public String getPD02ZS01() {
		return PD02ZS01;
	}

	public void setPD02ZS01(String pD02ZS01) {
		PD02ZS01 = pD02ZS01;
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
