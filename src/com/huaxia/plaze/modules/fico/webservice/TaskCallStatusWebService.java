package com.huaxia.plaze.modules.fico.webservice;

import javax.jws.WebMethod;
import javax.jws.WebService;
/**
 * 任务调用状态服务接口(针对于 fico的数据调用接口)
 * 
 * @author liuwei
 *
 */
@WebService
public interface TaskCallStatusWebService {
	
	/**
	 *@Title:saveTaskCallStatusOuter
	 *@Description:插入任务表
	 *@author: liuwei
	 *@Date:2019年3月12日上午
	 */
	@WebMethod
	public String invoke(String jsonRequest);
	
}
