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
 * 联通地址类信息,居住地址查询数量限制切面处理类
 * @author lipengfei
 *
 */
@Aspect
@Component
public class WST001103Aspect implements DataSourceInvoker {

	@Resource
	private UnicomDataSourceService unicomDataSourceService;
	
	@Around("execution(* com.huaxia.plaze.modules.unicom.webservice.UnicomAddressLiveWebservice.invoke(..))")
	public Object execute(ProceedingJoinPoint point) {
		return DataSourceAspectSupport.execute(point, UnicomDataSourceService.DATASOURCE_001103, this);
	}
	
	@Override
	public Object validate(Map<String, Object> args) {
		unicomDataSourceService.callUnicomLiveDataSource(args);
		return args.get(DataSourceInvoker.VALIDATE_RESULT);
	}

}
