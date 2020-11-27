package com.huaxia.plaze.modules.pboc.domain.pap;

import java.io.Serializable;
import java.util.List;

import org.apache.ibatis.type.Alias;

/**
 * 标注及声明信息段
 * 
 * @author gaoh
 *
 */
@Alias("PF04Z")
public class PF04Z implements Serializable {

	private static final long serialVersionUID = -7192014799805813275L;
	private PF04Zdata PF04Zdata;// 标注及声明信息段数据
	private List<PF04ZH> PF04ZHList;// 标注及声明信息 [1..5]

	public PF04Zdata getPF04Zdata() {
		return PF04Zdata;
	}

	public void setPF04Zdata(PF04Zdata pF04Zdata) {
		PF04Zdata = pF04Zdata;
	}

	public List<PF04ZH> getPF04ZHList() {
		return PF04ZHList;
	}

	public void setPF04ZHList(List<PF04ZH> pF04ZHList) {
		PF04ZHList = pF04ZHList;
	}

}
