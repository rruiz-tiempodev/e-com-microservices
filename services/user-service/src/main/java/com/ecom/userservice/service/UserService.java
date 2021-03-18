package com.ecom.userservice.service;

import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.connection.stream.ObjectRecord;
import org.springframework.data.redis.connection.stream.StreamRecords;
import org.springframework.data.redis.core.ReactiveRedisTemplate;

import com.ecom.common.model.EventType;
import com.ecom.userservice.model.User;
import com.ecom.userservice.model.UserEvent;
import com.fasterxml.jackson.databind.ObjectMapper;

public class UserService {

	@Autowired
    private ReactiveRedisTemplate<String, Object> redisTemplate;
	
	@Value("${stream.user.group.name}")
	private String streamGroupName;
	
	@Value("${stream.key}")
    private String streamKey;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	
	public void createUser() throws Exception {
		ZonedDateTime now = ZonedDateTime.now(ZoneOffset.UTC);
		User user = User.builder().firstName("Rodrigo").id(UUID.randomUUID().toString()).ts(now).build();
		UserEvent userEvent = UserEvent.builder().newImage(user).type(EventType.CREATE).build();
						
		ObjectRecord<String, String> record = StreamRecords.newRecord()
                .ofObject(objectMapper.writeValueAsString(userEvent))
                .withStreamKey(streamKey);
        		
		redisTemplate
                .opsForStream()
                .add(record).subscribe();
	}
}
