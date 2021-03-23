package com.ecom.productservice.repository.dynamo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.ecom.productervice.model.Product;

public class ProductDynamoDaoImpl implements ProductDao {
	
	@Autowired
	private DynamoDB dynamoDB;
	
	@Value("${aws.dynamo.tableName}")
	private String tableName;
	
	
	@Override
	public Product save(Product product) {
		Table productTable = dynamoDB.getTable(tableName);
		Item productItem = new Item();		
		productItem.withPrimaryKey("id", product.getId());
		productItem.withNumber("price", product.getPrice());
		productItem.withString("name", product.getName());
		productItem.withString("ts", product.getTs().toString());
		productTable.putItem(productItem);
		return product;
	}		
}
