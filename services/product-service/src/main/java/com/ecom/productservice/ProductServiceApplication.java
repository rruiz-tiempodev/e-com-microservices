package com.ecom.productservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import com.ecom.common.config.CommonServiceConfig;
import com.ecom.common.config.JsonConfig;
import com.ecom.common.config.StreamConfig;
import com.ecom.productservice.config.ServiceConfig;

@SpringBootApplication
@Import(value = {
		StreamConfig.class,
		JsonConfig.class,
		CommonServiceConfig.class,
		ServiceConfig.class
})
public class ProductServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(ProductServiceApplication.class, args);
	}
}
