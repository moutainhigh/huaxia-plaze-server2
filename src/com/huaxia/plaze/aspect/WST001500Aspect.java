package com.huaxia.plaze.aspect;

import java.util.Map;

import javax.annotation.Resource;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import com.huaxia.plaze.datasource.interfaces.DataSourceInvoker;
import com.huaxia.plaze.modules.tongdun.service.MultipleBorrowService;

/**
 * 同盾多头借贷查询数量限制切面处理类
 * 
 * @author zhiguo.li
 * @version 1.0.0
 * @see com.huaxia.plaze.datasource.interfaces.DataSourceInvoker
 *
 */
@Aspect
@Component
public class WST001500Aspect implements DataSourceInvoker {

	@Resource
	private MultipleBorrowService multipleBorrowService;

	@Around("execution(* com.huaxia.plaze.modules.tongdun.webservice.DtjdWebService.invoke(..))")
	public Object execute(ProceedingJoinPoint point) {
		return DataSourceAspectSupport.execute(point, "001500", this);
	}

	@Override
	public Object validate(Map<String, Object> args) {
		multipleBorrowService.callDataSource(args);
		return args.get(DataSourceInvoker.VALIDATE_RESULT);
	}

}
