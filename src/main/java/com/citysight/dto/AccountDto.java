package com.citysight.dto;

import com.citysight.entities.Role;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AccountDto {

	private int accountId;
	private String email;
	private String fname;
	private String lname;
	private Role role;
	private String address;
}
