package com.ecom.productservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.productervice.model.Product;
import com.ecom.productservice.service.ProductService;

import lombok.var;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@PostMapping(consumes = {"application/json"})
	@ResponseBody
	public ResponseEntity<Void> createPoduct(@RequestBody Product product) throws Exception {
		var productId = productService.createProduct(product);
		return ResponseEntity.status(HttpStatus.CREATED).header("Id", productId).build();
	}
}
