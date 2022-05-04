package com.citysight.utils;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.citysight.entities.Account;
import com.citysight.services.AccountService;

@Component
public class CommonMethods {

	@Autowired
	private AccountService accountService;
	
	public Optional<Account> getLoggedInAccount () {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if(authentication == null || !authentication.isAuthenticated()) {
			return null;
		}
		String userEmail = authentication.getName();
        Optional<Account> account = accountService.getAccountByEmail(userEmail);
        return account;
		
	}
}
