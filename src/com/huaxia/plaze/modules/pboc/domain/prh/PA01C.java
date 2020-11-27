package com.huaxia.plaze.modules.pboc.domain.prh;

import java.io.Serializable;
import java.util.List;

import org.apache.ibatis.type.Alias;

/**
 * 其他身份标识信息段
 * 
 * @author gaoh
 *
 */
@Alias("PA01C")
public class PA01C implements Serializable {
	private static final long serialVersionUID = 280005128197342403L;
	private PA01Cdata PA01Cdata;// 其他身份标识信息段数据
	private List<PA01CH> PA01CHList;// 身份信息

	public PA01Cdata getPA01Cdata() {
		return PA01Cdata;
	}

	public void setPA01Cdata(PA01Cdata pA01Cdata) {
		PA01Cdata = pA01Cdata;
	}

	public List<PA01CH> getPA01CHList() {
		return PA01CHList;
	}

	public void setPA01CHList(List<PA01CH> pA01CHList) {
		PA01CHList = pA01CHList;
	}

}
