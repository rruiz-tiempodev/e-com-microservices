package com.ecom.userservice.model;

import java.time.ZonedDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonDeserialize(builder = User.UserBuilder.class)
public class User {
	@JsonProperty
	private final String firstName;
	@JsonProperty
	private final String id;
	@JsonProperty
	private final ZonedDateTime ts;
}
