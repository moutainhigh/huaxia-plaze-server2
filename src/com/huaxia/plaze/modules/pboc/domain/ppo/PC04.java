package com.huaxia.plaze.modules.pboc.domain.ppo;

import java.io.Serializable;
import java.util.List;

import org.apache.ibatis.type.Alias;

/**
 * 公共信息概要信息单元
 * 
 * @author gaoh
 *
 */
@Alias("PC04")
public class PC04 implements Serializable {

	private static final long serialVersionUID = 8008407246619637481L;
	private PC04data PC04data;// 公共信息概要信息单元数据
	private List<PC040H> PC040HList;// 公共信息概要信息

	public PC04data getPC04data() {
		return PC04data;
	}

	public void setPC04data(PC04data pC04data) {
		PC04data = pC04data;
	}

	public List<PC040H> getPC040HList() {
		return PC040HList;
	}

	public void setPC040HList(List<PC040H> pC040HList) {
		PC040HList = pC040HList;
	}

}