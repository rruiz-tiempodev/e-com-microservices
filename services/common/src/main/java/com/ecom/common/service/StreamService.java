package com.ecom.common.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.stream.ObjectRecord;
import org.springframework.data.redis.connection.stream.StreamRecords;
import org.springframework.data.redis.core.ReactiveRedisTemplate;

import com.ecom.common.model.Event;
import com.fasterxml.jackson.databind.ObjectMapper;

public class StreamService {
	@Autowired
    private ReactiveRedisTemplate<String, Object> redisTemplate;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	public void addObjectToStream(Event<?> event, String streamName) throws Exception {
		ObjectRecord<String, String> record = StreamRecords.newRecord()
                .ofObject(objectMapper.writeValueAsString(event))
                .withStreamKey(streamName);        		
		redisTemplate
                .opsForStream()
                .add(record).subscribe();
	}
}
