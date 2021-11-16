package com.citysight.entities;

import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name="account")
public class Account {

	@Id
	@Column(name="account_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int accountId;
	
	@NotNull
	@Email
	@Length(max=100)
	@Column(name="email", unique = true)
	private String email;

	@NotNull
	@Length(max=100)
	@Column(name="fname")
	private String fname;
	
	@NotNull
	@Length(max=100)
	@Column(name="lname")
	private String lname;
	
	@NotNull
    @Length(max = 64)
    @Column(name = "Password")
    private String password;
	
	@ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "role_id", referencedColumnName = "role_id")
    private Role role;
	
	@NotNull
	@Length(max=200)
	@Column(name="address")
	private String address;
	
	@NotNull
    @Column(name = "active_flag", columnDefinition = "tinyint default 1")
    private boolean activeFlag = true;
	
	@CreatedBy
    @ManyToOne(cascade = CascadeType.ALL, optional = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "create_by_account_id", referencedColumnName = "account_id")
    private Account createByAccountId;

    @LastModifiedBy
    @ManyToOne(cascade = CascadeType.ALL, optional = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "modify_by_account_id", referencedColumnName = "account_id")
    private Account modifyByAccountId;

    @CreatedDate
    @Column(name = "create_date")
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date createDate;

    @LastModifiedDate
    @Column(name = "modify_date")
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date modifyDate;

    
    // Getters and Setters
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public boolean isActiveFlag() {
		return activeFlag;
	}

	public void setActiveFlag(boolean activeFlag) {
		this.activeFlag = activeFlag;
	}

	public Account getCreateByAccountId() {
		return createByAccountId;
	}

	public void setCreateByAccountId(Account createByAccountId) {
		this.createByAccountId = createByAccountId;
	}

	public Account getModifyByAccountId() {
		return modifyByAccountId;
	}

	public void setModifyByAccountId(Account modifyByAccountId) {
		this.modifyByAccountId = modifyByAccountId;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}



}
