package com.huaxia.plaze.aspect;

import java.util.Map;

import javax.annotation.Resource;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import com.huaxia.plaze.datasource.interfaces.DataSourceInvoker;
import com.huaxia.plaze.modules.nciic.service.PoliceXPService;

/**
 * 简项公安人像查询数量限制切面处理类
 * 
 * @author zhiguo.li
 * @version 1.0.0
 * @see com.huaxia.plaze.datasource.interfaces.DataSourceInvoker
 *
 */
@Aspect
@Component
public class WST000201Aspect implements DataSourceInvoker {

	@Resource
	private PoliceXPService policeXPService;

	@Around("execution(* com.huaxia.plaze.modules.nciic.webservice.PoliceService.invoke(..))")
	public Object execute(ProceedingJoinPoint point) {
		return DataSourceAspectSupport.execute(point, "000201", this);
	}

	@Override
	public Object validate(Map<String, Object> args) {
		policeXPService.callDataSource(args);
		return args.get(DataSourceInvoker.VALIDATE_RESULT);
	}

}
