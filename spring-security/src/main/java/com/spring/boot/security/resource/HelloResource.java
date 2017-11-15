package com.spring.boot.security.resource;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloResource {

	@GetMapping("/rest/helloForAdmin")
	public String hello(@AuthenticationPrincipal final UserDetails userDetails) {
		return "This is hello resource. User requesting is " +userDetails.getUsername();
	}
	
	@GetMapping("/rest/helloForUser")
	public String helloForUser() {
		return "This is hello for user";
	}
}
