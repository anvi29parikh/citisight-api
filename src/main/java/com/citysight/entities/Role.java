package com.citysight.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name="role")
@EntityListeners(AuditingEntityListener.class)
public class Role extends Common{

	@Id
	@Column(name="role_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int roleId;
	
	@NotNull
	@Length(max=20)
	@Column(name="role_name")
	private String roleName;
	
	@NotNull
    @Column(name = "active_flag", columnDefinition = "boolean default true")
    private boolean activeFlag;
}
