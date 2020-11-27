package com.huaxia.plaze.modules.pboc.domain;

import java.io.Serializable;
import java.util.List;

import com.huaxia.plaze.modules.pboc.domain.pnd.PE01;
/**
 * 后付费业务信息
 * @author gaoh
 *
 */
public class PND implements Serializable {
	
	private static final long serialVersionUID = 893497822418806412L;
	private List<PE01> PE01List;// 后付费业务信息单元   [0..*] 

	public List<PE01> getPE01List() {
		return PE01List;
	}

	public void setPE01List(List<PE01> pE01List) {
		PE01List = pE01List;
	}
	
}
