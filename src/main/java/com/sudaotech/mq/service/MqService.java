package com.sudaotech.mq.service;

import com.rabbitmq.client.Channel;
import com.sudaotech.core.service.BaseService;

/**
 * 创建mq服务
 * 
 * @author Spector 2016-8-17下午3:13:50
 */
public interface MqService extends BaseService {

	/**
	 * 获取MQ连接通道
	 * 
	 * @return
	 */
	public Channel getChannel();
	
	/**
	 * 发送消息
	 * 
	 * @param routingKey
	 * 		路由关键字
	 * @param message
	 * 		消息内容
	 */
	public void sendMqMsg(String routingKey, String message);
}
