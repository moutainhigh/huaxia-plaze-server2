package com.huaxia.plaze.modules.pboc.domain.pcr;

import java.io.Serializable;
import java.util.List;

import org.apache.ibatis.type.Alias;

/**
 * 标注及声明信息段
 * 
 * @author gaoh
 *
 */
@Alias("PD03Z")
public class PD03Z implements Serializable {

	private static final long serialVersionUID = -2736733830412343380L;
	private PD03Zdata PD03Zdata;// 标注及声明信息段数据
	private List<PD03ZH> PD03ZHList;// 标注及声明信息 [1.. 5]

	public PD03Zdata getPD03Zdata() {
		return PD03Zdata;
	}

	public void setPD03Zdata(PD03Zdata pD03Zdata) {
		PD03Zdata = pD03Zdata;
	}

	public List<PD03ZH> getPD03ZHList() {
		return PD03ZHList;
	}

	public void setPD03ZHList(List<PD03ZH> pD03ZHList) {
		PD03ZHList = pD03ZHList;
	}

}
