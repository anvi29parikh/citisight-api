package com.citysight.services;

import java.util.List;
import java.util.Optional;


import com.citysight.dto.AccountDto;
import com.citysight.dto.UpdateDto;
import com.citysight.entities.Account;


public interface AccountService {

	Optional<Account> getAccountByEmail(String email);
	
	List<AccountDto> fetchAllUsers();
	List<AccountDto> fetchUserDetails(String email);


	public void updateUser(UpdateDto updateDto);


}
