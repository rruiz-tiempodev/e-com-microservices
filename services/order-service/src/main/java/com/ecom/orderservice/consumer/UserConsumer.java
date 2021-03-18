package com.ecom.orderservice.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.stream.ObjectRecord;
import org.springframework.data.redis.stream.StreamListener;

import com.ecom.userservice.model.UserEvent;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class UserConsumer implements StreamListener<String, ObjectRecord<String, String>> {

	@Autowired
	private ObjectMapper objectMapper;
	
	@Override
	public void onMessage(ObjectRecord<String, String> message) {
		try {
			UserEvent userEvent = objectMapper.readValue(message.getValue(), UserEvent.class);
			System.out.println(userEvent.getNewImage());
		} catch (JsonProcessingException e) {			
			e.printStackTrace();
		}		
	}
	
}
