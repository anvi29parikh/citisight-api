package com.citysight.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.citysight.dto.AccountDto;
import com.citysight.dto.ResponseDto;
import com.citysight.services.AccountService;


@RestController
@RequestMapping("/admin")
public class ManageUsersController {

	@Autowired
	private AccountService accountService;

	@GetMapping("/users")
	public ResponseEntity<ResponseDto> fetchUsers(){
		ResponseDto responseDto = new ResponseDto();
		List<AccountDto> accounts = accountService.fetchAllUsers();
		responseDto.setData(accounts);
		responseDto.setMetadata(null);
		return new ResponseEntity<>(responseDto,HttpStatus.OK);
	}
}
