package com.huaxia.plaze.modules.pboc.domain;

import java.io.Serializable;
import java.util.List;

import com.huaxia.plaze.modules.pboc.domain.pot.PF01;
/**
 * 欠税记录
 * @author gaoh
 *
 */
public class POT implements Serializable {
	
	private static final long serialVersionUID = -2581995850607122599L;
	private List<PF01> PF01List;//欠税记录信息单元    [0..*] 

	public List<PF01> getPF01List() {
		return PF01List;
	}

	public void setPF01List(List<PF01> pF01List) {
		PF01List = pF01List;
	}
	
}
