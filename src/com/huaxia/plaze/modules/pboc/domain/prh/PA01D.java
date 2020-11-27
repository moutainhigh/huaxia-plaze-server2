package com.huaxia.plaze.modules.pboc.domain.prh;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

/**
 * 防欺诈警示信息段
 * 
 * @author gaoh
 *
 */
@Alias("PA01D")
public class PA01D implements Serializable {

	private static final long serialVersionUID = -1783822744428972283L;
	private String PA01DQ01;// 防欺诈警示标志 [1..1] --
	private String PA01DQ02;// 防欺诈警示联系电话 [1..1] --
	private String PA01DR01; // 防欺诈警示生效日期 [1..1] --
	private String PA01DR02;// 防欺诈警示截止日期 [1..1] --
	private String identityCardNo;// 身份证号
	private String uniqueRelid;// 每个身份证号码关联的唯一uuid值

	public String getPA01DQ01() {
		return PA01DQ01;
	}

	public void setPA01DQ01(String pA01DQ01) {
		PA01DQ01 = pA01DQ01;
	}

	public String getPA01DQ02() {
		return PA01DQ02;
	}

	public void setPA01DQ02(String pA01DQ02) {
		PA01DQ02 = pA01DQ02;
	}

	public String getPA01DR01() {
		return PA01DR01;
	}

	public void setPA01DR01(String pA01DR01) {
		PA01DR01 = pA01DR01;
	}

	public String getPA01DR02() {
		return PA01DR02;
	}

	public void setPA01DR02(String pA01DR02) {
		PA01DR02 = pA01DR02;
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