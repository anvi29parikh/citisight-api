package com.citysight.serviceImpl;

import java.util.Optional;

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
import com.citysight.services.AuthenticationService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AuthenticationServiceImpl implements AuthenticationService{
	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
    private PasswordEncoder passwordEncoder;
	
	@Autowired
	private JwtUtil jwtUtil;

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
	
	@Override
    public ResponseDto login(LoginRequestDto loginRequest) {
        Optional<Account> account = accountRepository.findByEmail(loginRequest.getEmail());
        log.error(".....{}..{}",account,loginRequest.getEmail());
        if (account.isPresent() && validateAuth(account.get(), loginRequest)) {
            String token = jwtUtil.generateToken(account.get().getEmail(), account.get().getRole().getRoleName());
            String tokenExpiry = jwtUtil.extractExpiration(token).toString();
            return new ResponseDto("email: " + loginRequest.getEmail(), new AuthResponseDto(token, tokenExpiry));
        } else {
            throw new CustomException(ErrorEnum.ACCESS_DENIED, HttpStatus.UNAUTHORIZED);
        }
    }

    private Boolean validateAuth(Account account, LoginRequestDto loginRequest) {
        return account != null && passwordEncoder.matches(loginRequest.getPassword(), account.getPassword());
    }
}
