package com.huaxia.plaze.modules.pboc.domain.prm;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

@Alias("PB03")
public class PB03 implements Serializable {
	private static final long serialVersionUID = 5502658631784708497L;
	private String PB030D01;// 居住状况 [1..1]
	private String PB030Q01;// 居住地址 [1..1]
	private String PB030Q02;// 住宅电话 [1..1]
	private String PB030R01;// 信息更新日期 [1..1]
	private String identityCardNo;// 身份证号
	private String uniqueRelid;// 每个身份证号码关联的唯一uuid值

	public String getPB030D01() {
		return PB030D01;
	}

	public void setPB030D01(String pB030D01) {
		PB030D01 = pB030D01;
	}

	public String getPB030Q01() {
		return PB030Q01;
	}

	public void setPB030Q01(String pB030Q01) {
		PB030Q01 = pB030Q01;
	}

	public String getPB030Q02() {
		return PB030Q02;
	}

	public void setPB030Q02(String pB030Q02) {
		PB030Q02 = pB030Q02;
	}

	public String getPB030R01() {
		return PB030R01;
	}

	public void setPB030R01(String pB030R01) {
		PB030R01 = pB030R01;
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