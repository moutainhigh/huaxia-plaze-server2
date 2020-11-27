package com.huaxia.plaze.modules.pboc.domain;

import java.io.Serializable;
import java.util.List;

import com.huaxia.plaze.modules.pboc.domain.pbs.PF06;
/**
 * 低保救助记录
 * @author gaoh
 *
 */
public class PBS implements Serializable {
 
	private static final long serialVersionUID = -1897411288240098084L;
	private List<PF06> PF06List;//低保救助记录信息单元   [0..*] 

	public List<PF06> getPF06List() {
		return PF06List;
	}

	public void setPF06List(List<PF06> pF06List) {
		PF06List = pF06List;
	}
	
}
