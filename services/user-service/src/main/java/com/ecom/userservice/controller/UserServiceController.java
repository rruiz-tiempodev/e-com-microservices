package com.ecom.userservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.userservice.service.UserService;

@RestController
@RequestMapping("/users")
public class UserServiceController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping(consumes = {"application/json"})
	@ResponseBody
	public ResponseEntity<Void> createUser() {
		userService.createUser();
		return ResponseEntity.ok().build();
	}
	
}
