package com.citysight.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.citysight.dto.AccountDto;
import com.citysight.entities.Account;


public interface AccountService {

	Optional<Account> getAccountByEmail(String email);
	
	List<AccountDto> fetchAllUsers();
}
