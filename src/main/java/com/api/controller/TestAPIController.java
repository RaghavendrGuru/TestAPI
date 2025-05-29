package com.api.controller;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/webhook")
@CrossOrigin(origins = "*", allowedHeaders = "*") 
public class TestAPIController {
	
	//http://localhost:8085/testapi/user/
	//https://testapi-production-ef5f.up.railway.app/testapi/webhook/user
	@PostMapping("/user")
	public ResponseEntity<String> receiveUser(@RequestBody Map<String, Object> data) {
	    System.out.println("Received webhook: " + data);
	    return ResponseEntity.ok("Received");
	}
	
	@GetMapping("/user")
	public String testUserGet() {
	    return "Webhook GET working!";
	}
	
	//http://localhost:8085/testapi/webhook
	@PostMapping("/telegram")
	public ResponseEntity<String> receiveSignal(@RequestBody String payload) {

		try {
			ObjectMapper mapper = new ObjectMapper();
			JsonNode root = mapper.readTree(payload);
			System.out.println("root.toPrettyString() : "+root.toPrettyString());
			System.out.println("root.toString() : "+root.toString());
		} 
		catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(500).body("Error parsing signal or placing order.");
		}

		return ResponseEntity.ok("receive Signal successfully.");
	}

}
