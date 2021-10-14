package com.citysight.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.citysight.entities.Account;
import com.citysight.entities.Role;
import com.citysight.repository.AccountRepository;
import com.citysight.repository.RoleRepository;
import com.citysight.services.AuthenticationService;

@Service
public class AuthenticationServiceImpl implements AuthenticationService{
	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
    private PasswordEncoder passwordEncoder;

	@Override
    public void register(Account account) {
        String encodedPassword = passwordEncoder.encode(account.getPassword());
        account.setPassword(encodedPassword);
        Optional<Role> role = roleRepository.findByRoleName("USER");
        if(role.isPresent()) {
        	account.setRole(role.get());	
        }
        accountRepository.save(account);
    }
}
