package com.huaxia.plaze.modules.pboc.domain.prh;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

/**
 * 身份信息
 * 
 * @author gaoh
 *
 */
@Alias("PA01CH")
public class PA01CH implements Serializable {

	private static final long serialVersionUID = -3992815064188130296L;
	private String PA01CD01;// 证件类型
	private String PA01CI01;// 证件号码
	private String identityCardNo;// 身份证号
	private String uniqueRelid;// 每个身份证号码关联的唯一uuid值

	public String getPA01CD01() {
		return PA01CD01;
	}

	public void setPA01CD01(String pA01CD01) {
		PA01CD01 = pA01CD01;
	}

	public String getPA01CI01() {
		return PA01CI01;
	}

	public void setPA01CI01(String pA01CI01) {
		PA01CI01 = pA01CI01;
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

}
