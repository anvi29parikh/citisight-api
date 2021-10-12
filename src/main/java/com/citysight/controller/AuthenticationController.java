package com.citysight.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class AuthenticationController {

	@GetMapping("/publicAPI")
	public String publicAPI () {
		return "public api";
	}
	
	@GetMapping("/privateAPI")
	public String privateAPI () {
		return "private api";
	}
}
