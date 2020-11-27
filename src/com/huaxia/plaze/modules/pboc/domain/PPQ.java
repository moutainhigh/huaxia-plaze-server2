package com.huaxia.plaze.modules.pboc.domain;

import java.io.Serializable;
import java.util.List;

import com.huaxia.plaze.modules.pboc.domain.ppq.PF07;
/**
 * 执业资格记录
 * @author gaoh
 *
 */
public class PPQ implements Serializable {
	 
	private static final long serialVersionUID = -5024158252297007636L;
	private List<PF07> PF07List;//执业资格记录信息单元    [0..*] 

	public List<PF07> getPF07List() {
		return PF07List;
	}

	public void setPF07List(List<PF07> pF07List) {
		PF07List = pF07List;
	}
	
}
