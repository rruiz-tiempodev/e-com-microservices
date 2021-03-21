package com.ecom.algoliaservice.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.algolia.search.DefaultSearchClient;
import com.algolia.search.SearchClient;
import com.algolia.search.SearchIndex;
import com.ecom.algoliaservice.model.AlgoliaProduct;

@Configuration
public class AlgoliaConfig {
	
	@Value("${algolia.appId}")
	private String appId;
	@Value("${algolia.appKey}")
	private String appKey;
	@Value("${algolia.productIndexName}")
	private String productIndexName;
	
	@Bean
	public SearchClient searchClient() {
		return DefaultSearchClient.create(appId, appKey);
	}
	
	@Bean
	public SearchIndex<AlgoliaProduct> productIndex(SearchClient searchClient) {
		return searchClient.initIndex(productIndexName, AlgoliaProduct.class);
	}
	
}
