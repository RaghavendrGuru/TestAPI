package com.api.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.dto.UserDto;
import com.api.dto.UserResponseDto;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/webhook")
@CrossOrigin(allowedHeaders = { "*", "*/" }, origins = { "*", "*/" })
public class TestAPIController {
	
private static final Logger logger = LoggerFactory.getLogger(TestAPIController.class);
	
	//http://localhost:8085/testapi/user/
	//https://testapi-production-ef5f.up.railway.app/testapi/webhook/user
	@GetMapping("/user")
	public ResponseEntity<UserResponseDto> getAge() {
		logger.info("Entered into OptionList method in controller");
		List<UserDto> userDtoList = new ArrayList<>();
		UserResponseDto userResponseDto = new UserResponseDto();
		
		UserDto userDtoManoj = new UserDto();
		userDtoManoj.setName("Manoj");
		userDtoManoj.setAge(28);
		
		UserDto userDtoLokre = new UserDto();
		userDtoLokre.setName("Lokre");
		userDtoLokre.setAge(35);
		
		userDtoList.add(userDtoManoj);
		userDtoList.add(userDtoLokre);
		
		userResponseDto.setStatusCode(HttpStatus.OK.value());
		userResponseDto.setUserDtoList(userDtoList);
		return new ResponseEntity<>(userResponseDto, HttpStatus.OK);
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
