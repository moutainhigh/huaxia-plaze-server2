package com.huaxia.plaze.modules.pboc.domain;

import java.io.Serializable;
import java.util.List;

import com.huaxia.plaze.modules.pboc.domain.phf.PF05;
/**
 * 住房公积金参缴记录
 * @author gaoh
 *
 */
public class PHF implements Serializable {
	 
	private static final long serialVersionUID = -1185579122505559852L;
	private List<PF05> PF05List;//住房公积金参缴记录信息单元   [0..*] 

	public List<PF05> getPF05List() {
		return PF05List;
	}

	public void setPF05List(List<PF05> pF05List) {
		PF05List = pF05List;
	}
	
}
