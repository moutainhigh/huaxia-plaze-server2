package com.huaxia.plaze.util;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitAdmin;

import com.huaxia.util.SpringContextUtil;

public class MessageChannelUtil {

	private static final Logger logger = LoggerFactory.getLogger(MessageChannelUtil.class);

	private final static RabbitAdmin rabbitAdmin = (RabbitAdmin) SpringContextUtil.getBean("rabbitAdmin");

	public static String declareQueue(String destination) {
		return declareQueue(destination, true);
	}
	
	public static String declareQueue(String destination, boolean durable) {
		if (StringUtils.isNotBlank(destination)) {
			Queue queue = new Queue(destination, durable, false, false, null);
			try {
				return rabbitAdmin.declareQueue(queue);
			} catch (Exception e) {
				logger.error("创建消息通道异常:{}", e.getMessage());
			}
		}
		return null;
	}

}
