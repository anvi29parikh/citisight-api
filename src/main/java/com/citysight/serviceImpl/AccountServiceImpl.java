package com.citysight.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.citysight.dto.AccountDto;
import com.citysight.entities.Account;
import com.citysight.repository.AccountRepository;
import com.citysight.services.AccountService;

@Service
public class AccountServiceImpl implements AccountService{

	@Autowired
	private AccountRepository accountRepository;
	
	@Override
	public Optional<Account> getAccountByEmail(String email){
		return accountRepository.findByEmail(email);
	}
	
	@Override
	public List<AccountDto> fetchAllUsers() {
		return accountRepository.fetchAllAccountDtos();
	}
}
