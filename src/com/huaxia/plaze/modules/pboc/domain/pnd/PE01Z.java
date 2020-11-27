package com.huaxia.plaze.modules.pboc.domain.pnd;

import java.io.Serializable;
import java.util.List;

import org.apache.ibatis.type.Alias;

/**
 * 标注及声明信息段
 * 
 * @author gaoh
 *
 */
@Alias("PE01Z")
public class PE01Z implements Serializable {

	private static final long serialVersionUID = -3183688468647555475L;
	private PE01Zdata PE01Zdata;// 标注及声明信息段数据
	private List<PE01ZH> PE01ZHList;// 标注及声明信息 [1..5]

	public PE01Zdata getPE01Zdata() {
		return PE01Zdata;
	}

	public void setPE01Zdata(PE01Zdata pE01Zdata) {
		PE01Zdata = pE01Zdata;
	}

	public List<PE01ZH> getPE01ZHList() {
		return PE01ZHList;
	}

	public void setPE01ZHList(List<PE01ZH> pE01ZHList) {
		PE01ZHList = pE01ZHList;
	}

}
