package com.ecom.orderservice.config;

import java.net.UnknownHostException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.stream.ObjectRecord;
import org.springframework.data.redis.stream.StreamListener;
import org.springframework.data.redis.stream.Subscription;

import com.ecom.common.config.DefaultConsumer;
import com.ecom.orderservice.consumer.ProductConsumer;
import com.ecom.orderservice.consumer.UserConsumer;

@Configuration
public class SubscriptionConfig {
	@Value("${stream.product.key}")
	private String productStreamKey;
	
	@Value("${stream.product.group.name}")
	private String productStreamGroupName;
	
	@Value("${stream.user.key}")
	private String userStreamKey;
	
	@Value("${stream.user.group.name}")
	private String userStreamGroupName;
	
	@Autowired 
	private RedisConnectionFactory redisConnectionFactory; 
	
	@Autowired 
	private StreamListener<String, ObjectRecord<String, String>> streamListener;
	
	@Bean("productSubscription")
	public Subscription userSubscription() throws UnknownHostException {
		return DefaultConsumer.getConsumer(redisConnectionFactory, streamListener, productStreamGroupName, productStreamKey);
	}
	
	@Bean("userSubscription")
	public Subscription productSubscription() throws UnknownHostException {
		return DefaultConsumer.getConsumer(redisConnectionFactory, streamListener, userStreamGroupName, userStreamKey);
	}
	
	@Primary
	@Bean("productConsumer")
	public ProductConsumer productConsumer() {
		return new ProductConsumer();
	}
	
	@Bean("userConsumer")
	public UserConsumer userConsumer() {
		return new UserConsumer();
	}
	
	
}
