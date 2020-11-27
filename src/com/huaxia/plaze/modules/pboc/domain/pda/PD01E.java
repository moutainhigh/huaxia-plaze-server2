package com.huaxia.plaze.modules.pboc.domain.pda;

import java.io.Serializable;
import java.util.List;

import org.apache.ibatis.type.Alias;

/**
 * 最近5年内历史表现信息段
 * 
 * @author gaoh
 *
 */
@Alias("PD01E")
public class PD01E implements Serializable {

	private static final long serialVersionUID = -2141760872463974543L;
	private PD01Edata PD01Edata;// 最近5年内历史表现信息段数据
	private List<PD01EH> PD01EHList;// 历史表现信息 [1..60]

	public PD01Edata getPD01Edata() {
		return PD01Edata;
	}

	public void setPD01Edata(PD01Edata pD01Edata) {
		PD01Edata = pD01Edata;
	}

	public List<PD01EH> getPD01EHList() {
		return PD01EHList;
	}

	public void setPD01EHList(List<PD01EH> pD01EHList) {
		PD01EHList = pD01EHList;
	}

}