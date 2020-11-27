package com.huaxia.plaze.aspect;

import java.util.Map;

import javax.annotation.Resource;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import com.huaxia.plaze.datasource.interfaces.DataSourceInvoker;
import com.huaxia.plaze.modules.baoxin.service.BaoXinService;
/**
 * 保信汽车查询数量限制切面
 * @author hxb
 *
 */
@Aspect
@Component
public class WST001900Aspect implements DataSourceInvoker{
	
	@Resource
	private BaoXinService baoXinServiceImpl;
	
	@Around("execution(* com.huaxia.plaze.modules.baoxin.webservice.BaoXinWebService.invoke(..))")
	public Object execute(ProceedingJoinPoint point){
		return DataSourceAspectSupport.execute(point, "001900", this);
	}
	@Override
	public Object validate(Map<String, Object> args) {
		baoXinServiceImpl.callDataSource(args);
		return args.get(DataSourceInvoker.VALIDATE_RESULT);
	}

}
