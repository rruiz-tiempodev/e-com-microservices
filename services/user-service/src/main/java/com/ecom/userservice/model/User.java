package com.ecom.userservice.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class User {
	private final String firstName;
	private final String id;
}
