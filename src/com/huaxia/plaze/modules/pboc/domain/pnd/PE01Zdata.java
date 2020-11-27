package com.huaxia.plaze.modules.pboc.domain.pnd;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

/**
 * 
 * @author gaoh
 *
 */
@Alias("PE01Zdata")
public class PE01Zdata implements Serializable {

	private static final long serialVersionUID = 3378032701698551790L;
	private String PE01ZS01;// 标注及声明个数 -- [1..1]
	private String identityCardNo;// 身份证号
	private String uniqueRelid;// 每个身份证号码关联的唯一uuid值
	private String relateId;// 每个后付费业务信息单元的关联id

	public String getPE01ZS01() {
		return PE01ZS01;
	}

	public void setPE01ZS01(String pE01ZS01) {
		PE01ZS01 = pE01ZS01;
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
