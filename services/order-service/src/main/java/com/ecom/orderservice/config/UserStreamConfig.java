package com.ecom.orderservice.config;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.Duration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.stream.Consumer;
import org.springframework.data.redis.connection.stream.ObjectRecord;
import org.springframework.data.redis.connection.stream.ReadOffset;
import org.springframework.data.redis.connection.stream.StreamOffset;
import org.springframework.data.redis.stream.StreamListener;
import org.springframework.data.redis.stream.StreamMessageListenerContainer;
import org.springframework.data.redis.stream.Subscription;

import com.ecom.orderservice.consumer.UserConsumer;

import lombok.var;

@Configuration
public class UserStreamConfig {
	@Value("${stream.user.key}")
	private String streamKey;
	
	@Value("${stream.user.group.name}")
	private String streamGroupName;

	@Autowired
	private StreamListener<String, ObjectRecord<String, String>> streamListener;

	@Bean
	public Subscription subscription(RedisConnectionFactory redisConnectionFactory) throws UnknownHostException {
		var options = StreamMessageListenerContainer.StreamMessageListenerContainerOptions.builder()
				.pollTimeout(Duration.ofSeconds(1)).targetType(String.class).build();
		var listenerContainer = StreamMessageListenerContainer.create(redisConnectionFactory, options);
		var subscription = listenerContainer.receiveAutoAck(
				Consumer.from(streamGroupName, InetAddress.getLocalHost().getHostName()),
				StreamOffset.create(streamKey, ReadOffset.lastConsumed()), streamListener);
		listenerContainer.start();
		return subscription;
	}
	
	@Bean
	public UserConsumer userConsumer() {
		return new UserConsumer();
	}
}
