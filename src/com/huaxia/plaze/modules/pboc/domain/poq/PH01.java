package com.huaxia.plaze.modules.pboc.domain.poq;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

/**
 * 查询记录信息单元
 * 
 * @author gaoh
 *
 */
@Alias("PH01")
public class PH01 implements Serializable {

	private static final long serialVersionUID = 3697116544528178209L;
	private String PH010R01;// 查询日期 -- [1..1]
	private String PH010D01;// 查询机构类型 -- [1..1]
	private String PH010Q02;// 查询机构 -- [1..1]
	private String PH010Q03;// 查询原因 -- [1..1]
	private String identityCardNo;// 身份证号
	private String uniqueRelid;// 每个身份证号码关联的唯一uuid值

	public String getPH010R01() {
		return PH010R01;
	}

	public void setPH010R01(String pH010R01) {
		PH010R01 = pH010R01;
	}

	public String getPH010D01() {
		return PH010D01;
	}

	public void setPH010D01(String pH010D01) {
		PH010D01 = pH010D01;
	}

	public String getPH010Q02() {
		return PH010Q02;
	}

	public void setPH010Q02(String pH010Q02) {
		PH010Q02 = pH010Q02;
	}

	public String getPH010Q03() {
		return PH010Q03;
	}

	public void setPH010Q03(String pH010Q03) {
		PH010Q03 = pH010Q03;
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
