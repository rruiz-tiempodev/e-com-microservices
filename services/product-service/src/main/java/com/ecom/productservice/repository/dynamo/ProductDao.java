package com.ecom.productservice.repository.dynamo;

import com.ecom.productervice.model.Product;

public interface ProductDao {
	public Product save(Product product);
}
