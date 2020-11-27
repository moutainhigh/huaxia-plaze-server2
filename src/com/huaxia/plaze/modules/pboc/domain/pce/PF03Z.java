package com.huaxia.plaze.modules.pboc.domain.pce;

import java.io.Serializable;
import java.util.List;

import org.apache.ibatis.type.Alias;

/**
 * 标注及声明信息段
 * 
 * @author gaoh
 *
 */
@Alias("PF03Z")
public class PF03Z implements Serializable {

	private static final long serialVersionUID = 2907197451113295919L;
	private PF03Zdata PF03Zdata;// 标注及声明信息段数据
	private List<PF03ZH> PF03ZHList;// 标注及声明信息 [1..5]

	public PF03Zdata getPF03Zdata() {
		return PF03Zdata;
	}

	public void setPF03Zdata(PF03Zdata pF03Zdata) {
		PF03Zdata = pF03Zdata;
	}

	public List<PF03ZH> getPF03ZHList() {
		return PF03ZHList;
	}

	public void setPF03ZHList(List<PF03ZH> pF03ZHList) {
		PF03ZHList = pF03ZHList;
	}

}
