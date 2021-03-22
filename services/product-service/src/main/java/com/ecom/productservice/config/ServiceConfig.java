package com.ecom.productservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ecom.productservice.service.ProductService;
@Configuration
public class ServiceConfig {
	
	@Bean
	public ProductService productService() {
		return new ProductService();
	}
}
