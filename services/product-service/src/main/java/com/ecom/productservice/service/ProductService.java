package com.ecom.productservice.service;

import java.math.BigDecimal;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import com.ecom.common.model.EventType;
import com.ecom.common.service.StreamService;
import com.ecom.productervice.model.Product;
import com.ecom.productervice.model.ProductEvent;

public class ProductService {
		
	
	@Value("${stream.key}")
    private String streamKey;
	
	@Autowired
	private StreamService streamService;
	
	public String createProduct() throws Exception {
		ZonedDateTime now = ZonedDateTime.now(ZoneOffset.UTC);
		Product product = Product.builder().id(UUID.randomUUID().toString()).ts(now).name("Producto prueba").price(new BigDecimal("50.00")).build();
		ProductEvent productEvent = ProductEvent.builder().newImage(product).type(EventType.CREATE).build();
		streamService.addObjectToStream(productEvent, streamKey);
		return product.getId();
	}
	
}