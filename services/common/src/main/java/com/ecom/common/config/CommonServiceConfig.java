package com.ecom.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ecom.common.service.StreamService;

@Configuration
public class CommonServiceConfig {
	
	@Bean
	public StreamService streamService() {
		return new StreamService();
	}
}
