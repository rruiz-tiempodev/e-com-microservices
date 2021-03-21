package com.ecom.algoliaservice.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.stream.ObjectRecord;
import org.springframework.data.redis.stream.StreamListener;

import com.algolia.search.SearchIndex;
import com.ecom.algoliaservice.model.AlgoliaProduct;
import com.ecom.productervice.model.ProductEvent;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ProductConsumer implements StreamListener<String, ObjectRecord<String, String>> {
	@Autowired
	private ObjectMapper objectMapper;
	
	@Autowired
	private  SearchIndex<AlgoliaProduct> productIndex;

	@Override
	public void onMessage(ObjectRecord<String, String> message) {
		try {
			ProductEvent event = objectMapper.readValue(message.getValue(), ProductEvent.class);		
			AlgoliaProduct product = new AlgoliaProduct();
			product.setName(event.getNewImage().getName());
			product.setPrice(event.getNewImage().getPrice());
			product.setObjectID(event.getNewImage().getId());
			productIndex.saveObjectAsync(product);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
	}
}
