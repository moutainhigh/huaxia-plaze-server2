package com.huaxia.plaze.modules.pboc.webservice;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * 二代人行调用三方平台接口
 * 
 * @author gaoh
 * @version 1.0.1
 *         <dl>
 *         <dt>历史修改：</dt>
 *         <dd>2019-05-08, zhiguo.li, 采用注解方式实现</dd>
 *         </dl>
 */
@WebService
public interface ReceiveSingleBank {

	@WebMethod
	String getResult(String json);

}
