package com.ecom.algoliaservice.model;

import java.math.BigDecimal;

import lombok.Data;
@Data
public class AlgoliaProduct {
	private String objectID;
	private String name;	
	private BigDecimal price;
}
