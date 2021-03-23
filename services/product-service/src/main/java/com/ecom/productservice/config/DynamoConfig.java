package com.ecom.productservice.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.client.builder.AwsClientBuilder.EndpointConfiguration;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;

@Configuration
public class DynamoConfig {
	
	@Value("${aws.dynamo.endpoint}")
	private String endpoint;
	
	@Value("${aws.region}")
	private String region;
	
	@Bean
	public DynamoDB dynamoDB() {
		EndpointConfiguration config = new EndpointConfiguration(endpoint, region); 
		AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard().withEndpointConfiguration(config).build();
	    DynamoDB dynamoDB = new DynamoDB(client);
	    return dynamoDB;
	}
	
}
