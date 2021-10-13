package com.citysight.entities;

import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.*;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public class Common {
	
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
