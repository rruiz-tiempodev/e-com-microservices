package com.ecom.productervice.model;

import com.ecom.common.model.Event;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonDeserialize(builder = ProductEvent.ProductEventBuilderImpl.class)
@Data()
@EqualsAndHashCode(callSuper=false)
public class ProductEvent extends Event<Product> {

}
