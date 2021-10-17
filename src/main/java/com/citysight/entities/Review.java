package com.citysight.entities;

import java.util.Date;

import javax.persistence.*;
//import javax.validation.constraints.Email;

import org.hibernate.validator.constraints.Length;
//import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
//import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import com.sun.istack.NotNull;

@Entity
@Table(name="Review")
public class Review {

	@Id
	@Column(name="Review_id")
	private int reviewId;
	
	@NotNull
	@Length(max=500)
	@Column(name="Review", unique = true)
	private String rev;
	
	@NotNull
	@Length(max=100)
	@Column(name="Ratings")
	private int rate;
	
	@ManyToOne(cascade = CascadeType.ALL, optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id", referencedColumnName = "account_id")
    private Account account;
	
	@ManyToOne(cascade = CascadeType.ALL, optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "location_id", referencedColumnName = "Location_id")
    private Location loc;
		
	@NotNull
    @Column(name = "active_flag", columnDefinition = "boolean default true")
    private boolean activeFlag;

    @CreatedDate
    @Column(name = "create_date")
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date createDate;

    @LastModifiedDate
    @Column(name = "modify_date")
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date modifyDate;

	public int getReviewId() {
		return reviewId;
	}

	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
	}

	public String getRev() {
		return rev;
	}

	public void setRev(String rev) {
		this.rev = rev;
	}

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Location getLoc() {
		return loc;
	}

	public void setLoc(Location loc) {
		this.loc = loc;
	}

	public boolean isActiveFlag() {
		return activeFlag;
	}

	public void setActiveFlag(boolean activeFlag) {
		this.activeFlag = activeFlag;
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
