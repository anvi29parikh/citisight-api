package com.citysight.serviceImpl;

import java.util.ArrayList;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.citysight.dto.AuthResponseDto;
import com.citysight.dto.LoginRequestDto;
import com.citysight.dto.ResponseDto;
import com.citysight.entities.Account;
import com.citysight.entities.Role;
import com.citysight.enums.ErrorEnum;
import com.citysight.exception.CustomException;
import com.citysight.repository.AccountRepository;
import com.citysight.repository.RoleRepository;
import com.citysight.security.util.JwtUtil;
import com.citysight.services.ManageUserService;

@Service
public class user_displayserviceimpl implements ManageUserService{

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
    private PasswordEncoder passwordEncoder;
	
	@Autowired
	private JwtUtil jwtUtil;

	

    
    @Override
    public void display_user()
    {

		accountRepository.listuser();
    }
    

}
