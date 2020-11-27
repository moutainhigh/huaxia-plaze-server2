package com.huaxia.plaze.aspect;

import java.util.Map;

import javax.annotation.Resource;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import com.huaxia.plaze.datasource.interfaces.DataSourceInvoker;
import com.huaxia.plaze.modules.id5.service.EducationService;

/**
 * 学历信息查询数量限制切面处理类
 * 
 * @author zhiguo.li
 * @version 1.0.0
 * @see com.huaxia.plaze.datasource.interfaces.DataSourceInvoker
 *
 */
@Aspect
@Component
public class WST000300Aspect implements DataSourceInvoker {

	@Resource
	private EducationService educationService;

	@Around("execution(* com.huaxia.plaze.modules.id5.webservice.Id5Service.invoke(..))")
	public Object execute(ProceedingJoinPoint point) {
		return DataSourceAspectSupport.execute(point, "000300", this);
	}

	@Override
	public Object validate(Map<String, Object> args) {
		educationService.callDataSource(args);
		return args.get(DataSourceInvoker.VALIDATE_RESULT);
	}

}
