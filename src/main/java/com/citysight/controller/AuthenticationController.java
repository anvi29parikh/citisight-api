package com.citysight.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.citysight.dto.ResponseDto;
import com.citysight.entities.Account;
import com.citysight.services.AuthenticationService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/auth")
public class AuthenticationController {

	@Autowired
	private AuthenticationService authenticationService;
	@GetMapping("/publicAPI")
	public String publicAPI () {
		return "public api";
	}
	
	@GetMapping("/privateAPI")
	public String privateAPI () {
		return "private api";
	}
	
	@PostMapping("/register")
	public ResponseEntity<ResponseDto> register (@Valid @RequestBody Account account) {
		log.info("Attemtng to create a account with email : {}", account.getEmail());
			authenticationService.register(account);
			return new ResponseEntity<>(new ResponseDto("Status: " + HttpStatus.CREATED, "USER_REGISTERED"), HttpStatus.CREATED);
	}
}
