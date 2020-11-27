package com.huaxia.plaze.modules.pboc.domain.pco;

import java.io.Serializable;
import java.util.List;

import org.apache.ibatis.type.Alias;

/**
 * 相关还款责任汇总信息段
 * 
 * @author gaoh
 *
 */
@Alias("PC02K")
public class PC02K implements Serializable {

	private static final long serialVersionUID = 7469663634237791237L;

	private PC02Kdata PC02Kdata;// 相关还款责任汇总信息段数据

	private List<PC02KH> PC02KHList;// 相关还款责任汇总信息

	public PC02Kdata getPC02Kdata() {
		return PC02Kdata;
	}

	public void setPC02Kdata(PC02Kdata pC02Kdata) {
		PC02Kdata = pC02Kdata;
	}

	public List<PC02KH> getPC02KHList() {
		return PC02KHList;
	}

	public void setPC02KHList(List<PC02KH> pC02KHList) {
		PC02KHList = pC02KHList;
	}

}