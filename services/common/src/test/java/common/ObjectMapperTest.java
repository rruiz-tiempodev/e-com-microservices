package common;

import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.UUID;

import org.junit.Assert;
import org.junit.Test;

import com.ecom.common.config.DefaultMappers;
import com.ecom.common.model.EventType;
import com.ecom.userservice.model.User;
import com.ecom.userservice.model.UserEvent;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ObjectMapperTest {
	
	@Test
	public void testEvent() throws Exception {
		ZonedDateTime now = ZonedDateTime.now(ZoneOffset.UTC);
		ObjectMapper objectMapper = DefaultMappers.getDefaultObjectMapper();
		User user = User.builder().firstName("Rodrigo").id(UUID.randomUUID().toString()).ts(now).build();
		UserEvent userEvent = UserEvent.builder().newImage(user).type(EventType.CREATE).build();
		String valueAsString = objectMapper.writeValueAsString(userEvent);		
		UserEvent result = objectMapper.readValue(valueAsString, UserEvent.class);
		Assert.assertEquals(userEvent.getNewImage().getId(), result.getNewImage().getId());
	}
	
	@Test
	public void testUser() throws Exception {
		ZonedDateTime now = ZonedDateTime.now(ZoneOffset.UTC);
		ObjectMapper objectMapper = DefaultMappers.getDefaultObjectMapper();
		User user = User.builder().firstName("Rodrigo").id(UUID.randomUUID().toString()).ts(now).build();		
		String valueAsString = objectMapper.writeValueAsString(user);		
		User result = objectMapper.readValue(valueAsString, User.class);
		Assert.assertEquals(user.getId(), result.getId());
	}
}
