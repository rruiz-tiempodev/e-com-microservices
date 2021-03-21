package com.ecom.userservice.service;

import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import com.ecom.common.model.EventType;
import com.ecom.common.service.StreamService;
import com.ecom.userservice.model.User;
import com.ecom.userservice.model.UserEvent;

public class UserService {

	@Autowired
	private StreamService streamService;
	
	@Value("${stream.key}")
    private String streamKey;

	
	public void createUser() throws Exception {
		ZonedDateTime now = ZonedDateTime.now(ZoneOffset.UTC);
		User user = User.builder().firstName("Rodrigo").id(UUID.randomUUID().toString()).ts(now).build();
		UserEvent userEvent = UserEvent.builder().newImage(user).type(EventType.CREATE).build();
		streamService.addObjectToStream(userEvent, streamKey);
	}
}
