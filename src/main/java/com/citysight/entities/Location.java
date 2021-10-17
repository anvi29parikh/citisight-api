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
@Table(name="Location")
public class Location {

	@Id
	@Column(name="Location_id")
	private int locationId;
	
	@NotNull
	@Length(max=100)
	@Column(name="name", unique = true)
	private String name;
	
	@NotNull
	@Length(max=200)
	@Column(name="address")
	private String laddress;
	
	@NotNull
	@Length(max=500)
	@Column(name="description")
	private String desc;
	
	@NotNull
    @Length(max = 500)
    @Column(name = "Directions")
    private String dir;
	
	@ManyToOne(cascade = CascadeType.ALL, optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "review_id", referencedColumnName = "Review_id")
    private Review review;
	
	@Column(name="Longitude")
	private long long_dir;
	
	@Column(name="Latitude")
	private long lati_dir;
		
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

	public int getLocationId() {
		return locationId;
	}

	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLaddress() {
		return laddress;
	}

	public void setLaddress(String laddress) {
		this.laddress = laddress;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getDir() {
		return dir;
	}

	public void setDir(String dir) {
		this.dir = dir;
	}

	public Review getReview() {
		return review;
	}

	public void setReview(Review review) {
		this.review = review;
	}

	public long getLong_dir() {
		return long_dir;
	}

	public void setLong_dir(long long_dir) {
		this.long_dir = long_dir;
	}

	public long getLati_dir() {
		return lati_dir;
	}

	public void setLati_dir(long lati_dir) {
		this.lati_dir = lati_dir;
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
