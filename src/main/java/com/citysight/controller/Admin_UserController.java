package com.citysight.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.citysight.dto.LoginRequestDto;
import com.citysight.dto.ResponseDto;
import com.citysight.entities.Account;
import com.citysight.services.ManageUserService;

@RestController
public class Admin_UserController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private ManageUserService userService;
	
	@GetMapping("/disp_user")
	public ResponseEntity<Object> disp_user () {
		userService.display_user();
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
}
