package com.huaxia.plaze.modules.pboc.domain.pda;

import java.io.Serializable;
import java.util.List;

import org.apache.ibatis.type.Alias;

/**
 * 大额专项分期信息段
 * 
 * @author gaoh
 *
 */
@Alias("PD01H")
public class PD01H implements Serializable {
	private static final long serialVersionUID = 8362135414777494754L;
	private PD01Hdata PD01Hdata;// 大额专项分期信息段
	private List<PD01HH> PD01HHList;// 大额专项分期信息

	public PD01Hdata getPD01Hdata() {
		return PD01Hdata;
	}

	public void setPD01Hdata(PD01Hdata pD01Hdata) {
		PD01Hdata = pD01Hdata;
	}

	public List<PD01HH> getPD01HHList() {
		return PD01HHList;
	}

	public void setPD01HHList(List<PD01HH> pD01HHList) {
		PD01HHList = pD01HHList;
	}

}
