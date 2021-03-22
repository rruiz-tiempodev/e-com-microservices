package com.ecom.common.config;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.Duration;

import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.stream.Consumer;
import org.springframework.data.redis.connection.stream.ObjectRecord;
import org.springframework.data.redis.connection.stream.ReadOffset;
import org.springframework.data.redis.connection.stream.StreamOffset;
import org.springframework.data.redis.stream.StreamListener;
import org.springframework.data.redis.stream.StreamMessageListenerContainer;
import org.springframework.data.redis.stream.Subscription;

import lombok.var;

public class DefaultConsumer {
	
	public static Subscription getConsumer(RedisConnectionFactory redisConnectionFactory, StreamListener<String, ObjectRecord<String, String>> streamListener, String group, String stream) throws UnknownHostException {
		var options = StreamMessageListenerContainer.StreamMessageListenerContainerOptions.builder()
				.pollTimeout(Duration.ofSeconds(1)).targetType(String.class).build();
		var listenerContainer = StreamMessageListenerContainer.create(redisConnectionFactory, options);
		var subscription = listenerContainer.receiveAutoAck(
				Consumer.from(group, InetAddress.getLocalHost().getHostName()),
				StreamOffset.create(stream, ReadOffset.lastConsumed()), streamListener);
		listenerContainer.start();
		return subscription;
	}
}
