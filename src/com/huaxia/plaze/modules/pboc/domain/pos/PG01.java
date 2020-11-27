package com.huaxia.plaze.modules.pboc.domain.pos;

import java.io.Serializable;
import java.util.List;

import org.apache.ibatis.type.Alias;

/**
 * 标注及声明信息单元 [0..*]
 * 
 * @author gaoh
 *
 */
@Alias("PG01")
public class PG01 implements Serializable {

	private static final long serialVersionUID = -5118261629331527252L;
	private PG01data PG01data;// 标注及声明信息单元数据
	private List<PG010H> PG010HList;// 标注及声明信息 [1..5]

	public PG01data getPG01data() {
		return PG01data;
	}

	public void setPG01data(PG01data pG01data) {
		PG01data = pG01data;
	}

	public List<PG010H> getPG010HList() {
		return PG010HList;
	}

	public void setPG010HList(List<PG010H> pG010HList) {
		PG010HList = pG010HList;
	}

}
