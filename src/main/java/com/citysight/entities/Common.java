package com.citysight.entities;

import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
public class Common {
	
    @CreatedBy
    @ManyToOne(cascade = CascadeType.ALL, optional = true)
    @JoinColumn(name = "create_by_account_id", referencedColumnName = "account_id")
    @JsonIgnore
    private Account createByAccountId;

    @LastModifiedBy
    @ManyToOne(cascade = CascadeType.ALL, optional = true)
    @JoinColumn(name = "modify_by_account_id", referencedColumnName = "account_id")
    @JsonIgnore
    private Account modifyByAccountId;

    @CreatedDate
    @Column(name = "create_date")
    @Temporal(value = TemporalType.TIMESTAMP)
    @JsonIgnore
    private Date createDate;

    @LastModifiedDate
    @Column(name = "modify_date")
    @Temporal(value = TemporalType.TIMESTAMP)
    @JsonIgnore
    private Date modifyDate;
}
