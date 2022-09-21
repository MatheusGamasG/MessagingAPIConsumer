package com.consumer.first.consumer.amqp.implementation;

import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.consumer.first.consumer.amqp.AmqpConsumer;
import com.consumer.first.consumer.dto.Message;
import com.consumer.first.consumer.service.ConsumerService;

@Component
public class RabbitMQConsumer implements AmqpConsumer<Message> {

	@Autowired
	private ConsumerService consumerService;
	
	@Override
	@RabbitListener(queues="$(spring.rabbitmq.request.routing-key.producer)")
	public void consumer(Message message) {
		try {
			consumerService.action(message);
		} catch (Exception ex) {
			throw new AmqpRejectAndDontRequeueException(ex);
		}
		
	}
	
}
