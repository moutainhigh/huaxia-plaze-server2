package com.huaxia.plaze.aspect;

import java.util.Map;

import javax.annotation.Resource;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import com.huaxia.plaze.datasource.interfaces.DataSourceInvoker;
import com.huaxia.plaze.modules.unicom.service.UnicomDataSourceService;

/**
 * 在网网时长查询数量限制切面处理类
 * 
 * @author zhiguo.li
 * @version 1.0.0
 * @see com.huaxia.plaze.datasource.interfaces.DataSourceInvoker
 *
 */
@Aspect
@Component
public class WST001101Aspect implements DataSourceInvoker {

	@Resource
	private UnicomDataSourceService unicomDataSourceService;

	@Around("execution(* com.huaxia.plaze.modules.unicom.webservice.UnicomOnlineWebservice.invoke(..))")
	public Object execute(ProceedingJoinPoint point) {
		return DataSourceAspectSupport.execute(point, UnicomDataSourceService.DATASOURCE_001101, this);
	}

	@Override
	public Object validate(Map<String, Object> args) {
		unicomDataSourceService.callOnlineDataSource(args);
		return args.get(DataSourceInvoker.VALIDATE_RESULT);
	}

}
