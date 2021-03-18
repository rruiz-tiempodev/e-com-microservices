package com.ecom.common.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.experimental.SuperBuilder;


@Data
@SuperBuilder
public class Event<T> {
	@JsonProperty
	protected final EventType type;
	@JsonProperty
	protected final T newImage;
}
