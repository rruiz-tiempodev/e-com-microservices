package com.ecom.productervice.model;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import lombok.Builder;
import lombok.Data;
@Data
@Builder
@JsonDeserialize(builder = Product.ProductBuilder.class)
public class Product {
	@JsonProperty
	private String id;
	@JsonProperty
	private String name;
	@JsonProperty
	private BigDecimal price;
	@JsonProperty
	private final ZonedDateTime ts;
	
	
}
