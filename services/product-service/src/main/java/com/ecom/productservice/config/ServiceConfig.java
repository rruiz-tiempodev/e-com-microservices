package com.ecom.productservice.config;

import org.springframework.context.annotation.Bean;

import com.ecom.productservice.service.ProductService;

public class ServiceConfig {
	
	@Bean
	public ProductService productService() {
		return new ProductService();
	}
}
