package com.huaxia.plaze.modules.pboc.domain;

import java.io.Serializable;
import java.util.List;

import com.huaxia.plaze.modules.pboc.domain.pcj.PF02;
/**
 * 民事判决记录 
 * @author gaoh
 *
 */
public class PCJ implements Serializable {
	
	private static final long serialVersionUID = 3311891806608389657L;
	private List<PF02> PF02List;//民事判决记录信息单元   [0..*]  

	public List<PF02> getPF02List() {
		return PF02List;
	}

	public void setPF02List(List<PF02> pF02List) {
		PF02List = pF02List;
	}
	
}
