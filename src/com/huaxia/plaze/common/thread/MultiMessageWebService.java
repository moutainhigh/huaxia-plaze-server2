package com.huaxia.plaze.common.thread;

import java.util.List;
import java.util.concurrent.ExecutionException;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * 公共WebService接口（批次报文）
 * 
 * @author zhiguo.li
 *
 */
@WebService
public interface MultiMessageWebService {

	@WebMethod
	List<String> invoke(List<String> jsonRequestList) throws InterruptedException, ExecutionException;

}
