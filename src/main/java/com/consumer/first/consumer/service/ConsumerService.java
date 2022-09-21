package com.consumer.first.consumer.service;

import com.consumer.first.consumer.dto.Message;

public interface ConsumerService {
	void action(Message message) throws Exception;
}
