package com.huaxia.plaze.modules.pboc.domain.prh;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

/**
 * 其他身份标识信息段数据
 * 
 * @author gaoh
 *
 */
@Alias("PA01Cdata")
public class PA01Cdata implements Serializable {

	private static final long serialVersionUID = -7034957481711339014L;
	private String PA01CS01; // 身份标识个数
	private String identityCardNo;// 身份证号
	private String uniqueRelid;// 每个身份证号码关联的唯一uuid值

	public String getPA01CS01() {
		return PA01CS01;
	}

	public void setPA01CS01(String pA01CS01) {
		PA01CS01 = pA01CS01;
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
