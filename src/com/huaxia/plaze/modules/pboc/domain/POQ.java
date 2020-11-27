package com.huaxia.plaze.modules.pboc.domain;

import java.io.Serializable;
import java.util.List;

import com.huaxia.plaze.modules.pboc.domain.poq.PH01;
/**
 * 查询记录
 * @author gaoh
 *
 */
public class POQ implements Serializable {
 
	private static final long serialVersionUID = 5150757928910549784L;
	private List<PH01> PH01List;//查询记录信息单元   [0..*] 

	public List<PH01> getPH01List() {
		return PH01List;
	}

	public void setPH01List(List<PH01> pH01List) {
		PH01List = pH01List;
	}
	
}
