package com.huaxia.plaze.modules.pboc.domain.ppq;

import java.io.Serializable;
import java.util.List;
/**
 * 标注及声明信息段  
 * @author gaoh
 *
 */

import org.apache.ibatis.type.Alias;

@Alias("PF07Z")
public class PF07Z implements Serializable {

	private static final long serialVersionUID = -7103945785564206147L;
	private PF07Zdata PF07Zdata;// 标注及声明信息段数据
	private List<PF07ZH> PF07ZHList;// 标注及声明信息 [1..5]

	public PF07Zdata getPF07Zdata() {
		return PF07Zdata;
	}

	public void setPF07Zdata(PF07Zdata pF07Zdata) {
		PF07Zdata = pF07Zdata;
	}

	public List<PF07ZH> getPF07ZHList() {
		return PF07ZHList;
	}

	public void setPF07ZHList(List<PF07ZH> pF07ZHList) {
		PF07ZHList = pF07ZHList;
	}

}
