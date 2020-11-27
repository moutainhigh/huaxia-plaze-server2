package com.huaxia.plaze.modules.pboc.domain;

import java.io.Serializable;
import java.util.List;

import com.huaxia.plaze.modules.pboc.domain.pap.PF04;
/**
 * 行政处罚记录
 * @author gaoh
 *
 */
public class PAP implements Serializable {
	
	private static final long serialVersionUID = -6912228050463399139L;
	private List<PF04> PF04List;//行政处罚记录信息单元    [0..*] 

	public List<PF04> getPF04List() {
		return PF04List;
	}

	public void setPF04List(List<PF04> pF04List) {
		PF04List = pF04List;
	}
	
}
