package com.ecom.algoliaservice.config;

import java.net.UnknownHostException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.stream.ObjectRecord;
import org.springframework.data.redis.stream.StreamListener;
import org.springframework.data.redis.stream.Subscription;

import com.ecom.algoliaservice.consumer.ProductConsumer;
import com.ecom.common.config.DefaultConsumer;
@Configuration
public class ProductStreamConfig {
	@Value("${stream.product.key}")
	private String streamKey;
	
	@Value("${stream.product.group.name}")
	private String streamGroupName;


	@Bean("productSubscription")
	public Subscription subscription(RedisConnectionFactory redisConnectionFactory, StreamListener<String, ObjectRecord<String, String>> streamListener) throws UnknownHostException {
		return DefaultConsumer.getConsumer(redisConnectionFactory, streamListener, streamGroupName, streamKey);
	}
	
	@Bean
	public ProductConsumer productConsumer() {
		return new ProductConsumer();
	}
}
