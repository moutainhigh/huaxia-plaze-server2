package com.huaxia.plaze.modules.fico.handler;

public abstract class MessageOperator<T> {
	
	public abstract T operate(String message) throws Exception;
	
}
