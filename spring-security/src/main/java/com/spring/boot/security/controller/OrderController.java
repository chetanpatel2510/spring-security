package com.spring.boot.security.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OrderController {


	@RequestMapping(value="/order/placeOrder")
	public String placeOrder(@AuthenticationPrincipal final UserDetails userDetails) {
		System.out.println("User Name: "+userDetails.getUsername());
		return "placeOrder";
	}
}
