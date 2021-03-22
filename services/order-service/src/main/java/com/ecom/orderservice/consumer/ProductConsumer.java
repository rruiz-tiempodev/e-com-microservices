package com.ecom.orderservice.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.stream.ObjectRecord;
import org.springframework.data.redis.stream.StreamListener;

import com.ecom.productervice.model.ProductEvent;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ProductConsumer implements StreamListener<String, ObjectRecord<String, String>> {
	@Autowired
	private ObjectMapper objectMapper;

	@Override
	public void onMessage(ObjectRecord<String, String> message) {
		try {
			ProductEvent productEvent = objectMapper.readValue(message.getValue(), ProductEvent.class);
			System.out.println(productEvent.getNewImage());
		} catch (JsonProcessingException e) {			
			e.printStackTrace();
		}	
	}
}
