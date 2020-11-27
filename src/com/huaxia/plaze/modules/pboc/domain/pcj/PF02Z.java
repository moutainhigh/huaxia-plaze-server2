package com.huaxia.plaze.modules.pboc.domain.pcj;

import java.io.Serializable;
import java.util.List;

import org.apache.ibatis.type.Alias;

/**
 * 标注及声明信息段
 * 
 * @author gaoh
 *
 */
@Alias("PF02Z")
public class PF02Z implements Serializable {

	private static final long serialVersionUID = -6104820596853731046L;
	private PF02Zdata PF02Zdata;// 标注及声明信息段数据
	private List<PF02ZH> PF02ZHList;// 标注及声明信息 [1..5]

	public PF02Zdata getPF02Zdata() {
		return PF02Zdata;
	}

	public void setPF02Zdata(PF02Zdata pF02Zdata) {
		PF02Zdata = pF02Zdata;
	}

	public List<PF02ZH> getPF02ZHList() {
		return PF02ZHList;
	}

	public void setPF02ZHList(List<PF02ZH> pF02ZHList) {
		PF02ZHList = pF02ZHList;
	}

}
