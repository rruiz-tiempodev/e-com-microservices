package com.ecom.algoliaservice;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import com.ecom.common.config.JsonConfig;
import com.ecom.common.config.StreamConfig;

@SpringBootApplication
@Import(value = {
		StreamConfig.class,
		JsonConfig.class
})
public class AlgoliaServiceApplication {
	
}
