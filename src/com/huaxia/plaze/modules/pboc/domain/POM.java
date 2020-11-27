package com.huaxia.plaze.modules.pboc.domain;

import java.io.Serializable;
import java.util.List;

import com.huaxia.plaze.modules.pboc.domain.pom.PB04;
/**
 * 职业信息
 * @author gaoh
 *
 */
public class POM implements Serializable {

	private static final long serialVersionUID = -844741424210850992L;
	private List<PB04> PB04List;//职业信息单元

	public List<PB04> getPB04List() {
		return PB04List;
	}

	public void setPB04List(List<PB04> pB04List) {
		PB04List = pB04List;
	}
	
}