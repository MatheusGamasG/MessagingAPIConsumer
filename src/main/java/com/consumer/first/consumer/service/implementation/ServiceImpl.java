package com.consumer.first.consumer.service.implementation;

import org.springframework.stereotype.Service;

import com.consumer.first.consumer.dto.Message;
import com.consumer.first.consumer.service.ConsumerService;

@Service
public class ServiceImpl implements ConsumerService {

	@Override
	public void action(Message message) throws Exception {
		System.out.println(message.getText());		
	}
	
	
	
}
