package com.huaxia.plaze.common.thread;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 抽象任务线程处理类
 * 
 * @author zhiguo.li
 * @version 1.0.0
 *
 */
public abstract class TaskThread implements Callable<List<String>> {

	protected final static Logger logger = LoggerFactory.getLogger(TaskThread.class);

	// 任务名称
	protected String taskName;

	protected CountDownLatch taskLatch;

	// 任务集合
	protected List<String> taskList;

	public TaskThread() {
		super();
	}

	protected TaskThread(String taskName, CountDownLatch taskLatch, List<String> taskList) {
		this.taskName = taskName;
		this.taskLatch = taskLatch;
		this.taskList = taskList;
	}

	/** 获取任务处理线程实例（NEW） */
	public abstract TaskThread getTaskThread();

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public CountDownLatch getTaskLatch() {
		return taskLatch;
	}

	public void setTaskLatch(CountDownLatch taskLatch) {
		this.taskLatch = taskLatch;
	}

	public List<String> getTaskList() {
		return taskList;
	}

	public void setTaskList(List<String> taskList) {
		this.taskList = taskList;
	}

}
