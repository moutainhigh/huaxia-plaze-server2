package com.huaxia.plaze.modules.pboc.domain.pbs;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

/**
 * 标注及声明信息段数据
 * 
 * @author gaoh
 *
 */
@Alias("PF06Zdata")
public class PF06Zdata implements Serializable {

	private static final long serialVersionUID = -2852504702202451868L;
	private String PF06ZS01;// 标注及声明个数 -- [1..1]
	private String identityCardNo;// 身份证号
	private String uniqueRelid;// 每个身份证号码关联的唯一uuid值
	private String relateId;// 每个低保救助记录的关联id

	public String getPF06ZS01() {
		return PF06ZS01;
	}

	public void setPF06ZS01(String pF06ZS01) {
		PF06ZS01 = pF06ZS01;
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
