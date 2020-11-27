package com.huaxia.plaze.modules.pboc.domain.pce;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

/**
 * 标注及声明信息段数据
 * 
 * @author gaoh
 *
 */
@Alias("PF03Zdata")
public class PF03Zdata implements Serializable {

	private static final long serialVersionUID = -8940252568032157656L;
	private String PF03ZS01;// 标注及声明个数 -- [1..1]
	private String identityCardNo;// 身份证号
	private String uniqueRelid;// 每个身份证号码关联的唯一uuid值
	private String relateId;// 每个强制执行记录信息单元的关联id

	public String getPF03ZS01() {
		return PF03ZS01;
	}

	public void setPF03ZS01(String pF03ZS01) {
		PF03ZS01 = pF03ZS01;
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
