package com.ecom.userservice.config;

import java.util.function.Function;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ecom.userservice.model.User;

@Configuration
public class StreamConfig {
	
	@Bean
	public Function<User, User> sendUpdateUser() {
		return s -> s;
	}
}
