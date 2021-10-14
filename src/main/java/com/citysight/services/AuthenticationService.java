package com.citysight.services;

import com.citysight.dto.LoginRequestDto;
import com.citysight.dto.ResponseDto;
import com.citysight.entities.Account;

public interface AuthenticationService {
	void register(Account account);
	
	ResponseDto login(LoginRequestDto loginRequestDto);
}
