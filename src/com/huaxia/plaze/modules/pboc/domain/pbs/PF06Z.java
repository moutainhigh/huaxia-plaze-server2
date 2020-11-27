package com.huaxia.plaze.modules.pboc.domain.pbs;

import java.io.Serializable;
import java.util.List;

import org.apache.ibatis.type.Alias;

/**
 * 标注及声明信息段
 * 
 * @author gaoh
 *
 */
@Alias("PF06Z")
public class PF06Z implements Serializable {

	private static final long serialVersionUID = -5775625059038165019L;
	private PF06Zdata PF06Zdata;// 标注及声明信息段数据
	private List<PF06ZH> PF06ZHList;// 标注及声明信息 [1..5]

	public PF06Zdata getPF06Zdata() {
		return PF06Zdata;
	}

	public void setPF06Zdata(PF06Zdata pF06Zdata) {
		PF06Zdata = pF06Zdata;
	}

	public List<PF06ZH> getPF06ZHList() {
		return PF06ZHList;
	}

	public void setPF06ZHList(List<PF06ZH> pF06ZHList) {
		PF06ZHList = pF06ZHList;
	}

}
