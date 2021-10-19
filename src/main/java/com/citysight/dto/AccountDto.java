package com.citysight.dto;

import com.citysight.entities.Role;


public class AccountDto {

	private int accountId;
	private String email;
	private String fname;
	private String lname;
	private Role role;
	private String address;
	
	//Setters and Getters
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * @param accountId
	 * @param email
	 * @param fname
	 * @param lname
	 * @param role
	 * @param address
	 */
	public AccountDto(int accountId, String email, String fname, String lname, Role role, String address) {
		super();
		this.accountId = accountId;
		this.email = email;
		this.fname = fname;
		this.lname = lname;
		this.role = role;
		this.address = address;
	}
	/**
	 * 
	 */
	public AccountDto() {
		super();
	}
	
	
}
