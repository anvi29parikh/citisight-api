package com.citysight.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginRequestDto {

	@NotNull
	@Email
	private String email;
	
	@NotNull
	private String password;
}
