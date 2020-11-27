package com.huaxia.plaze.modules.pboc.domain.prh;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

/**
 * 异议提示信息段
 * 
 * @author gaoh
 *
 */

@Alias("PA01E")
public class PA01E implements Serializable {

	private static final long serialVersionUID = 2277987448297747386L;
	private String PA01ES01;// 异议标注数目[1..1] --
	private String identityCardNo;// 身份证号
	private String uniqueRelid;// 每个身份证号码关联的唯一uuid值

	public String getPA01ES01() {
		return PA01ES01;
	}

	public void setPA01ES01(String pA01ES01) {
		PA01ES01 = pA01ES01;
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
