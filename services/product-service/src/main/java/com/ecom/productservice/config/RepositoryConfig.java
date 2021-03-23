package com.ecom.productservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ecom.productservice.repository.dynamo.ProductDao;
import com.ecom.productservice.repository.dynamo.ProductDynamoDaoImpl;

@Configuration
public class RepositoryConfig {
	
	@Bean("productDynamoDao")
	public ProductDao productDao() {
		return new ProductDynamoDaoImpl();
	}
}
