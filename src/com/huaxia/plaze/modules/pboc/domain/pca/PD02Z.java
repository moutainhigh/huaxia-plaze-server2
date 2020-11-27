package com.huaxia.plaze.modules.pboc.domain.pca;

import java.io.Serializable;
import java.util.List;

import org.apache.ibatis.type.Alias;

/**
 * 标注及声明信息段
 * 
 * @author gaoh
 *
 */
@Alias("PD02Z")
public class PD02Z implements Serializable {

	private static final long serialVersionUID = -3274461041484826659L;

	private PD02Zdata PD02Zdata;// 标注及声明信息段数据

	private List<PD02ZH> PD02ZHList;// 标注及声明信息 [1..5]

	public PD02Zdata getPD02Zdata() {
		return PD02Zdata;
	}

	public void setPD02Zdata(PD02Zdata pD02Zdata) {
		PD02Zdata = pD02Zdata;
	}

	public List<PD02ZH> getPD02ZHList() {
		return PD02ZHList;
	}

	public void setPD02ZHList(List<PD02ZH> pD02ZHList) {
		PD02ZHList = pD02ZHList;
	}

}
