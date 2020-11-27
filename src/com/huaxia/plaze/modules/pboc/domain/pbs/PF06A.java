package com.huaxia.plaze.modules.pboc.domain.pbs;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

/**
 * 低保救助记录信息段
 * 
 * @author gaoh
 *
 */
@Alias("PF06A")
public class PF06A implements Serializable {

	private static final long serialVersionUID = -1705346803935009850L;
	private String PF06AD01;// 人员类别 -- [1..1]
	private String PF06AQ01;// 所在地 -- [1..1]
	private String PF06AQ02;// 工作单位 -- [1..1]
	private String PF06AQ03;// 家庭月收入 -- [1..1]
	private String PF06AR01;// 申请日期 -- [1..1]
	private String PF06AR02;// 批准日期 -- [1..1]
	private String PF06AR03;// 信息更新日期 -- [1..1]
	private String identityCardNo;// 身份证号
	private String uniqueRelid;// 每个身份证号码关联的唯一uuid值
	private String relateId;// 每个低保救助记录的关联id

	public String getPF06AD01() {
		return PF06AD01;
	}

	public void setPF06AD01(String pF06AD01) {
		PF06AD01 = pF06AD01;
	}

	public String getPF06AQ01() {
		return PF06AQ01;
	}

	public void setPF06AQ01(String pF06AQ01) {
		PF06AQ01 = pF06AQ01;
	}

	public String getPF06AQ02() {
		return PF06AQ02;
	}

	public void setPF06AQ02(String pF06AQ02) {
		PF06AQ02 = pF06AQ02;
	}

	public String getPF06AQ03() {
		return PF06AQ03;
	}

	public void setPF06AQ03(String pF06AQ03) {
		PF06AQ03 = pF06AQ03;
	}

	public String getPF06AR01() {
		return PF06AR01;
	}

	public void setPF06AR01(String pF06AR01) {
		PF06AR01 = pF06AR01;
	}

	public String getPF06AR02() {
		return PF06AR02;
	}

	public void setPF06AR02(String pF06AR02) {
		PF06AR02 = pF06AR02;
	}

	public String getPF06AR03() {
		return PF06AR03;
	}

	public void setPF06AR03(String pF06AR03) {
		PF06AR03 = pF06AR03;
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
