package com.citysight.serviceImpl;

import java.util.List;
import java.util.Optional;

import com.citysight.repository.UserdetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.citysight.dto.AccountDto;
import com.citysight.dto.UpdateDto;
import com.citysight.entities.Account;
import com.citysight.repository.AccountRepository;
import com.citysight.services.AccountService;

@Service
public class AccountServiceImpl implements AccountService{

	@Autowired
	private AccountRepository accountRepository;
	@Autowired
	private UserdetailRepository userdetailRepository;

	//@Autowired Account account;
	
	@Override
	public Optional<Account> getAccountByEmail(String email){
		return accountRepository.findByEmail(email);
	}
	
	@Override
	public List<AccountDto> fetchAllUsers() {
		return accountRepository.fetchAllAccountDtos();
	}

	@Override
	public List<AccountDto> fetchUserDetails(String email) { return userdetailRepository.fetchUserDetailsDto(email); }



	@Override
	public void updateUser(UpdateDto updateDto)
	{
		Account account = new Account();

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if(authentication == null || !authentication.isAuthenticated()) {
			System.out.println("null");
		}
		String email = authentication.getName();


		List<AccountDto> accounts = userdetailRepository.fetchUserDetailsDto(email);
		int id = accounts.get(0).getAccountId();



		String s1 = updateDto.getEmail();
		String s2 = updateDto.getFname();
		String s3 = updateDto.getLname();
		String s4 = updateDto.getAddress();

		userdetailRepository.updatedUser(s1,s2,s3,s4,id);






	}





}
