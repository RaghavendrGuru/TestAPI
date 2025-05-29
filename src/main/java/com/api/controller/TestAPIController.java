package com.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestAPIController {

	@GetMapping({ "/", "/home", "/status" })
	public String getStatus() {
		return "Webhook GET working!";
	}

}
