package com.huaxia.plaze.modules.pboc.domain.pno;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

/**
 * 非信贷交易信息概要数据
 * 
 * @author gaoh
 *
 */
@Alias("PC03data")
public class PC03data implements Serializable {

	private static final long serialVersionUID = 4088206200217800669L;
	private String PC030S01;// 后付费业务类型数量 --
	private String identityCardNo;// 身份证号
	private String uniqueRelid;// 每个身份证号码关联的唯一uuid值

	public String getPC030S01() {
		return PC030S01;
	}

	public void setPC030S01(String pC030S01) {
		PC030S01 = pC030S01;
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