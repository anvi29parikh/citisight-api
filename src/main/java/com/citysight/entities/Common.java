package com.citysight.entities;

import java.util.Date;

import javax.persistence.*;

import org.springframework.data.annotation.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
