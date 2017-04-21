package com.sudaotech.mq.service;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import javax.inject.Named;

import org.apache.commons.lang3.StringUtils;

import com.google.inject.Inject;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.sudaotech.core.service.BaseServiceImpl;

/**
 * MQ服务
 * 
 * @author Spector 2016-8-17下午3:13:41
 */
public class MqServiceImpl extends BaseServiceImpl implements MqService {
	
	public static final String EXCHANGE_NAME = "MQ_TOPIC_EXCHANGE";
	/** 打开自动应答模式 */
	public static final boolean ASK = false;
	private static final String TYPE_NAME = "topic";
	
	private Connection connection;
	
	@Inject
	public MqServiceImpl(@Named("mq.host")String host,
			@Named("mq.port") int port,
			@Named("mq.username")String username,
			@Named("mq.password")String password) {
		
		this.logger.info("mq: host={}, port={}, username={}, password={}", host, port, username, password);
		
		ConnectionFactory factory = new ConnectionFactory();
		try {
			factory.setHost(host);
			factory.setPort(port);
			factory.setUsername(username);
			factory.setPassword(password);
			
			connection = factory.newConnection();
		} catch (IOException e) {
			logger.error("创建mq连接异常, {}", e.getMessage());
			e.printStackTrace();
		} catch (TimeoutException e) {
			logger.error("创建mq连接超时, {}", e.getMessage());
			e.printStackTrace();
		}
		
	}
	
	@Override
	public Channel getChannel() {
		if(null != connection){
			try {
				Channel channel = connection.createChannel();
				channel.exchangeDeclare(EXCHANGE_NAME, TYPE_NAME);
				
				return channel;
			} catch (IOException e) {
				logger.error("get rabbitmq channel error: {}", e.getMessage());
				e.printStackTrace();
				return null;
			}
		}
		return null;
	}

	@Override
	public void sendMqMsg(String routingKey, String message) {
		if(StringUtils.isNotBlank(routingKey) && StringUtils.isNotBlank(message)){
			Channel channel = getChannel();
			if(null != channel){
				try {
					channel.basicPublish(EXCHANGE_NAME, routingKey, null, message.getBytes());
					logger.debug("MQ send success: routingKey = {} ,msg = {}.", routingKey, message);
				} catch (IOException e) {
					logger.error("MQ send message error：{}", e.getMessage());
					e.printStackTrace();
				} finally {
					
					/*try {
						if(null != channel){
							channel.close();
						}
						if(null != connection){
							connection.close();
						}
					} catch (IOException e) {
						logger.error("关闭mq异常：{}", e.getMessage());
						e.printStackTrace();
					} catch (TimeoutException e) {
						logger.error("关闭mq超时：{}", e.getMessage());
						e.printStackTrace();
					}*/
				}
			}else{				
				logger.error("mq channel is null");
			}
		}else{			
			logger.warn("发送队列消息信息缺失：routingKey={}, message={}", routingKey, message);
		}
	}
	
}
