package com.huaxia.plaze.modules.pboc.domain;

import java.io.Serializable;
import java.util.List;

import com.huaxia.plaze.modules.pboc.domain.pcr.PD03;
/**
 * 相关还款责任信息
 * @author gaoh
 *
 */
public class PCR  implements Serializable {
	
	private static final long serialVersionUID = -408540835703147633L;
	private List<PD03> PD03List;//相关还款责任信息单元   [0..*]

	public List<PD03> getPD03List() {
		return PD03List;
	}

	public void setPD03List(List<PD03> pD03List) {
		PD03List = pD03List;
	}
	
}
