package com.ecom.userservice.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.connection.stream.ObjectRecord;
import org.springframework.data.redis.connection.stream.StreamRecords;
import org.springframework.data.redis.core.ReactiveRedisTemplate;

import com.ecom.userservice.model.User;

public class UserService {

	@Autowired
    private ReactiveRedisTemplate<String, User> redisTemplate;
	
	@Value("${stream.key}")
    private String streamKey;
	
	public void createUser() {
		User user = User.builder().firstName("Rodrigo").id(UUID.randomUUID().toString()).build();
		ObjectRecord<String, User> record = StreamRecords.newRecord()
                .ofObject(user)
                .withStreamKey(streamKey);
        this.redisTemplate
                .opsForStream()
                .add(record).subscribe();
	}
}
