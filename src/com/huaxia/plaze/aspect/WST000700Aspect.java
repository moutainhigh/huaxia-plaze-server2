package com.huaxia.plaze.aspect;

import java.util.Map;

import javax.annotation.Resource;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import com.huaxia.plaze.datasource.interfaces.DataSourceInvoker;
import com.huaxia.plaze.modules.bairong.service.ApplyLoanStrService;

/**
 * 百融多头借贷查询数量限制切面处理类
 * 
 * @author zhiguo.li
 * @version 1.0.0
 * @see com.huaxia.plaze.datasource.interfaces.DataSourceInvoker
 *
 */
@Aspect
@Component
public class WST000700Aspect implements DataSourceInvoker {

	@Resource
	private ApplyLoanStrService applyLoanStrService;

	@Around("execution(* com.huaxia.plaze.modules.bairong.webservice.ApplyLoanStrWebService.invoke(..))")
	public Object execute(ProceedingJoinPoint point) {
		return DataSourceAspectSupport.execute(point, "000700", this);
	}

	@Override
	public Object validate(Map<String, Object> args) {
		applyLoanStrService.callDataSource(args);
		return args.get(DataSourceInvoker.VALIDATE_RESULT);
	}

}
