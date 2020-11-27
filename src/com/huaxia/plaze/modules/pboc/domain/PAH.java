package com.huaxia.plaze.modules.pboc.domain;

import java.io.Serializable;
import java.util.List;

import com.huaxia.plaze.modules.pboc.domain.pah.PF08;
/**
 * 行政奖励记录
 * @author gaoh
 *
 */
public class PAH implements Serializable {
	 
	private static final long serialVersionUID = -7920649550534252079L;
	private List<PF08> PF08List;//行政奖励记录信息单元   [0..*] 

	public List<PF08> getPF08List() {
		return PF08List;
	}

	public void setPF08List(List<PF08> pF08List) {
		PF08List = pF08List;
	}
	
}
