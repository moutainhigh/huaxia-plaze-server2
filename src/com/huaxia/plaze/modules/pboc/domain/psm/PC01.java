package com.huaxia.plaze.modules.pboc.domain.psm;

import java.io.Serializable;
import java.util.List;

import org.apache.ibatis.type.Alias;

/**
 * 评分信息单元
 * 
 * @author gaoh
 *
 */
@Alias("PC01")
public class PC01 implements Serializable {

	private static final long serialVersionUID = -6026223157503588163L;

	private PC01data PC01data;// 评分信息数据

	private List<PC01scoreEle> PC01scoreEleList;// 评分信息分数说明

	public PC01data getPC01data() {
		return PC01data;
	}

	public void setPC01data(PC01data pC01data) {
		PC01data = pC01data;
	}

	public List<PC01scoreEle> getPC01scoreEleList() {
		return PC01scoreEleList;
	}

	public void setPC01scoreEleList(List<PC01scoreEle> pC01scoreEleList) {
		PC01scoreEleList = pC01scoreEleList;
	}

}