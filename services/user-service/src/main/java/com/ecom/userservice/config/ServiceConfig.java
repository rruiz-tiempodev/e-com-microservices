package com.ecom.userservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ecom.userservice.service.UserService;

@Configuration
public class ServiceConfig {

	@Bean
	public UserService userService() {
		return new UserService();
	}
	
}
