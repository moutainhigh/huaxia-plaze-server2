package com.huaxia.plaze.modules.pboc.domain.pot;

import java.io.Serializable;
import java.util.List;

import org.apache.ibatis.type.Alias;

/**
 * 标注及声明信息段
 * 
 * @author gaoh
 *
 */
@Alias("PF01Z")
public class PF01Z implements Serializable {

	private static final long serialVersionUID = -1996627557721991397L;
	private PF01Zdata PF01Zdata;// 标注及声明信息段数据
	private List<PF01ZH> PF01ZHList;// 标注及声明信息 [1..5]

	public PF01Zdata getPF01Zdata() {
		return PF01Zdata;
	}

	public void setPF01Zdata(PF01Zdata pF01Zdata) {
		PF01Zdata = pF01Zdata;
	}

	public List<PF01ZH> getPF01ZHList() {
		return PF01ZHList;
	}

	public void setPF01ZHList(List<PF01ZH> pF01ZHList) {
		PF01ZHList = pF01ZHList;
	}

}
