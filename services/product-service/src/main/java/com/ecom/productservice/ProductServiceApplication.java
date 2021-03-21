package com.ecom.productservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import com.ecom.common.config.CommonServiceConfig;
import com.ecom.common.config.JsonConfig;
import com.ecom.common.config.StreamConfig;

@SpringBootApplication
@Import(value = {
		StreamConfig.class,
		JsonConfig.class,
		CommonServiceConfig.class
})
public class ProductServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(ProductServiceApplication.class, args);
	}
}
