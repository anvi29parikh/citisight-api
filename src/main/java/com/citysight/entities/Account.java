package com.citysight.entities;

import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.Email;

import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import com.sun.istack.NotNull;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name="account")
public class Account {

	@Id
	@Column(name="account_id")
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
	
	@ManyToOne(cascade = CascadeType.ALL, optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id", referencedColumnName = "role_id")
    private Role role;
	
	@NotNull
	@Length(max=200)
	@Column(name="address")
	private String address;
	
	@NotNull
    @Column(name = "active_flag", columnDefinition = "boolean default true")
    private boolean activeFlag;
	
	@CreatedBy
    @ManyToOne(cascade = CascadeType.ALL, optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "create_by_account_id", referencedColumnName = "account_id")
    private Account createByAccountId;

    @LastModifiedBy
    @ManyToOne(cascade = CascadeType.ALL, optional = false, fetch = FetchType.LAZY)
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
}
