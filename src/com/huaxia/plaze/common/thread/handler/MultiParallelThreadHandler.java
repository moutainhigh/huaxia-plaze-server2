package com.huaxia.plaze.common.thread.handler;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.huaxia.plaze.common.thread.MultiThreadHandler;
import com.huaxia.plaze.common.thread.TaskThread;
import com.huaxia.plaze.modules.bairong.thread.ApplyLoanStrTaskThread;

/**
 * 多线程并行任务处理器
 * 
 * @author zhiguo.li
 * @version 1.0.0
 *
 */
public class MultiParallelThreadHandler implements MultiThreadHandler<String> {

	private static final Logger logger = LoggerFactory.getLogger(MultiParallelThreadHandler.class);

	/** 默认每条线程处理数据条数 */
	private static final int TASKS_PER_THREAD = 400;

	@Override
	public List<String> execute(List<String> taskList) throws InterruptedException, ExecutionException {
		if (taskList == null || taskList.size() == 0) {
			return new ArrayList<String>();
		}
		
		logger.info("待处理任务数 [ {} ]", taskList.size());

		// 默认任务处理线程数量
		int threads = 1;

		int totalTaskCount = taskList.size();
		if (totalTaskCount % TASKS_PER_THREAD == 0) {
			threads = totalTaskCount / TASKS_PER_THREAD;
		} else {
			threads = totalTaskCount / TASKS_PER_THREAD + 1;
		}

		logger.info("任务处理线程数 [ {} ]", threads);

		// 初始化线程计数锁
		final CountDownLatch taskLatch = new CountDownLatch(threads);

		// 初始化固定数量线程池
		final ExecutorService executor = Executors.newFixedThreadPool(threads);
		
		List<Future<List<String>>> futureList = new ArrayList<Future<List<String>>>();
		for (int i = 0; i < threads; i++) {
			List<String> taskThreadList = null;
			if (i == threads - 1) {
				taskThreadList = taskList.subList(i * TASKS_PER_THREAD, taskList.size());
			} else {
				taskThreadList = taskList.subList(i * TASKS_PER_THREAD, (i + 1) * TASKS_PER_THREAD);
			}
			
			// 任务处理线程
			TaskThread taskThread = getTaskThread();
			taskThread.setTaskName("TASK" + i);
			taskThread.setTaskLatch(taskLatch);
			taskThread.setTaskList(taskThreadList);
			
			Future<List<String>> future = executor.submit(taskThread);
			futureList.add(future);
		}
		taskLatch.await();
		taskList.clear();
		executor.shutdown();
		
		// 构造并组装响应报文
		List<String> messages = new ArrayList<String>();
		if (futureList.size() > 0) {
			for (int i = 0; i < futureList.size(); i++) {
				Future<List<String>> future = futureList.get(i);
				List<String> messageList = future.get();
				for (String message : messageList) {
					messages.add(message);
				}
			}
		}
		
		return messages;
	}

	private TaskThread getTaskThread() {
		return new ApplyLoanStrTaskThread();
	}
	
}
