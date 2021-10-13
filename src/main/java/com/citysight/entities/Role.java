package com.citysight.entities;

import javax.persistence.*;

import org.hibernate.validator.constraints.Length;

import com.sun.istack.NotNull;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name="role")
public class Role extends Common{

	@Id
	@Column(name="role_id")
	private int roleId;
	
	@NotNull
	@Length(max=20)
	@Column(name="role_name")
	private String roleName;
	
	@NotNull
    @Column(name = "active_flag", columnDefinition = "boolean default true")
    private boolean activeFlag;
}
