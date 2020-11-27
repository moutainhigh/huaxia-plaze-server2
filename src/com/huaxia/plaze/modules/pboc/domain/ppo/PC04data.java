package com.huaxia.plaze.modules.pboc.domain.ppo;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

/**
 * 公共信息概要信息单元数据
 * 
 * @author gash
 *
 */
@Alias("PC04data")
public class PC04data implements Serializable {

	private static final long serialVersionUID = -783185820231103090L;
	private String PC040S01;// 公共信息类型数量 -- [1..1]
	private String identityCardNo;// 身份证号
	private String uniqueRelid;// 每个身份证号码关联的唯一uuid值

	public String getPC040S01() {
		return PC040S01;
	}

	public void setPC040S01(String pC040S01) {
		PC040S01 = pC040S01;
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