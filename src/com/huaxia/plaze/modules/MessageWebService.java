package com.huaxia.plaze.modules;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * 公共WebService接口
 * 
 * @author zhiguo.li
 *
 */
@WebService
public interface MessageWebService {

	@WebMethod
	String invoke(String jsonRequest);

}
