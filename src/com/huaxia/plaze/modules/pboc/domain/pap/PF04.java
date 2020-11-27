package com.huaxia.plaze.modules.pboc.domain.pap;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

/**
 * 行政处罚记录信息单元
 * 
 * @author gaoh
 *
 */
@Alias("PF04")
public class PF04 implements Serializable {

	private static final long serialVersionUID = 2658092387521342205L;
	private PF04A PF04A;// 行政处罚记录信息段 [1..1]
	private PF04Z PF04Z;// 标注及声明信息段 [0..1]

	public PF04A getPF04A() {
		return PF04A;
	}

	public void setPF04A(PF04A pF04A) {
		PF04A = pF04A;
	}

	public PF04Z getPF04Z() {
		return PF04Z;
	}

	public void setPF04Z(PF04Z pF04Z) {
		PF04Z = pF04Z;
	}

}
