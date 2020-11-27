package com.huaxia.plaze.modules.pboc.domain.pap;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

/**
 * 行政处罚记录信息段
 * 
 * @author gaoh
 *
 */
@Alias("PF04A")
public class PF04A implements Serializable {

	private static final long serialVersionUID = -1467837863939266697L;
	private String PF04AQ01;// 处罚机构 -- [1..1]
	private String PF04AQ02;// 处罚内容 -- [1..1]
	private String PF04AJ01;// 处罚金额 -- [1..1]
	private String PF04AR01;// 处罚生效日期 -- [1..1]
	private String PF04AR02;// 处罚截止日期 -- [1..1]
	private String PF04AQ03;// 行政复议结果 -- [1..1]
	private String identityCardNo;// 身份证号
	private String uniqueRelid;// 每个身份证号码关联的唯一uuid值
	private String relateId;// 每个行政处罚记录信息单元的关联id

	public String getPF04AQ01() {
		return PF04AQ01;
	}

	public void setPF04AQ01(String pF04AQ01) {
		PF04AQ01 = pF04AQ01;
	}

	public String getPF04AQ02() {
		return PF04AQ02;
	}

	public void setPF04AQ02(String pF04AQ02) {
		PF04AQ02 = pF04AQ02;
	}

	public String getPF04AJ01() {
		return PF04AJ01;
	}

	public void setPF04AJ01(String pF04AJ01) {
		PF04AJ01 = pF04AJ01;
	}

	public String getPF04AR01() {
		return PF04AR01;
	}

	public void setPF04AR01(String pF04AR01) {
		PF04AR01 = pF04AR01;
	}

	public String getPF04AR02() {
		return PF04AR02;
	}

	public void setPF04AR02(String pF04AR02) {
		PF04AR02 = pF04AR02;
	}

	public String getPF04AQ03() {
		return PF04AQ03;
	}

	public void setPF04AQ03(String pF04AQ03) {
		PF04AQ03 = pF04AQ03;
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
