package com.sudaotech.mq.service;

import java.io.IOException;
import java.util.UUID;
import org.apache.logging.log4j.ThreadContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.QueueingConsumer;
import com.rabbitmq.client.QueueingConsumer.Delivery;

public class MqReceiverService {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public void receiveMqMsgForWhile(String receiveKey, MqReceiver receiver) {
 		Channel channel = null;
		QueueingConsumer consumer = null;
		long tag = 0L;
		String msg = null;
		
		try {
			channel = receiver.getMqService().getChannel();
			
			String queueName = channel.queueDeclare().getQueue();
			logger.debug("{} start listening, queue：{} ",receiveKey, queueName);
			
			channel.queueBind(queueName, MqServiceImpl.EXCHANGE_NAME, receiveKey);
			
			consumer = new QueueingConsumer(channel);
			channel.basicConsume(queueName, MqServiceImpl.ASK, consumer);
			while(true){
				Delivery delivery = consumer.nextDelivery();
				ThreadContext.put("X-UUID", UUID.randomUUID().toString());
				
				msg = new String(delivery.getBody());
				logger.debug("{} 接收到队列数据：{}",receiveKey, msg);
				
				receiver.doExecute(msg);
				
				tag = delivery.getEnvelope().getDeliveryTag();
				channel.basicAck(tag, MqServiceImpl.ASK);
			}
		} catch (Exception e) {
			try {
				channel.basicCancel(consumer.getConsumerTag());
				channel.basicNack(tag, false, false);
				
				//异常处理
		/*		ExceptionLog exceptionLog = new ExceptionLog();
				exceptionLog.setExceptionKey(ThreadContext.get("X-UUID"));
				exceptionLog.setExceptionType(RoutingKey.getCode(receiveKey));
				exceptionLog.setExceptionValue(e.getMessage());
				exceptionLog.setSourceData(msg);
				String exceptionLogString = JsonUtil.toJson(exceptionLog);
				receiver.getMqService().sendMqMsg(RoutingKey.HJTAG_MQ_EXCEPTION_LOG.sendKey(), exceptionLogString);
				*/
				receiver.runAnotherConsumer();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
	}
	
	public interface MqReceiver {
		MqService getMqService();
		void doExecute(String msg) throws Exception;
		void runAnotherConsumer();
	}
}

