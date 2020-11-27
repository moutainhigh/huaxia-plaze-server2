package com.huaxia.plaze.modules.pboc.domain.pda;

import java.io.Serializable;
import java.util.List;

import org.apache.ibatis.type.Alias;

/**
 * 特殊事件说明信息段
 * 
 * @author gaoh
 *
 */
@Alias("PD01G")
public class PD01G implements Serializable {
	private static final long serialVersionUID = -3521501006968908156L;
	private PD01Gdata PD01Gdata;// 特殊事件说明信息段数据
	private List<PD01GH> PD01GHList;// 特殊事件说明信息 [1..99]

	public PD01Gdata getPD01Gdata() {
		return PD01Gdata;
	}

	public void setPD01Gdata(PD01Gdata pD01Gdata) {
		PD01Gdata = pD01Gdata;
	}

	public List<PD01GH> getPD01GHList() {
		return PD01GHList;
	}

	public void setPD01GHList(List<PD01GH> pD01GHList) {
		PD01GHList = pD01GHList;
	}

}
