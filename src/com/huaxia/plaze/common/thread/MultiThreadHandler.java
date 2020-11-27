package com.huaxia.plaze.common.thread;

import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * 多线程任务处理接口
 * 
 * @author zhiguo.li
 *
 * @param <T>
 *            线程返回类型
 * @version 1.0.0
 */
public interface MultiThreadHandler<T> {

	/**
	 * 任务线程执行方法
	 * 
	 * @param taskList
	 *            批次任务数据列表（数据类型为JSON格式）
	 * @return 批次任务处理结果
	 * @throws InterruptedException
	 * @throws ExecutionException
	 */
	List<T> execute(List<String> taskList) throws InterruptedException, ExecutionException;
	
}
