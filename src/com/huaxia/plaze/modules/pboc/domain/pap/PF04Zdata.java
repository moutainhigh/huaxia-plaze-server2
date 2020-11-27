package com.huaxia.plaze.modules.pboc.domain.pap;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;
/**
 * 标注及声明信息段数据
 * @author gaoh
 *
 */
@Alias("PF04Zdata")
public class PF04Zdata implements Serializable {
	
	private static final long serialVersionUID = -279359005206994372L;
	private String PF04ZS01;//标注及声明个数  --  [1..1] 
    private String   identityCardNo;//身份证号
	private String   uniqueRelid;//每个身份证号码关联的唯一uuid值
	private String relateId;//每个行政处罚记录信息单元的关联id
	public String getPF04ZS01() {
		return PF04ZS01;
	}

	public void setPF04ZS01(String pF04ZS01) {
		PF04ZS01 = pF04ZS01;
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
