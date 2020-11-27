package com.huaxia.plaze.modules.pboc.domain;

import java.io.Serializable;
import java.util.List;

import com.huaxia.plaze.modules.pboc.domain.prm.PB03;
/**
 * 居住信息
 * @author gaoh
 *
 */
public class PRM  implements Serializable {
	private static final long serialVersionUID = -2916957556842505287L;
	private List<PB03> PB03List;//居住信息单元

	public List<PB03> getPB03List() {
		return PB03List;
	}

	public void setPB03List(List<PB03> pB03List) {
		PB03List = pB03List;
	}
	
}