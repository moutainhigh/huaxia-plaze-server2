package com.huaxia.plaze.modules.pboc.domain;

import java.io.Serializable;
import java.util.List;

import com.huaxia.plaze.modules.pboc.domain.pce.PF03;
/**
 * 强制执行记录
 * @author gaoh
 *
 */
public class PCE implements Serializable {
	
	private static final long serialVersionUID = 2063095379139619205L;
	private List<PF03> PF03List;//强制执行记录信息单元   [0..*]  

	public List<PF03> getPF03List() {
		return PF03List;
	}

	public void setPF03List(List<PF03> pF03List) {
		PF03List = pF03List;
	}
	
}
