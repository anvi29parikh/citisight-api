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
@Table(name="Photos")
public class Photos {

	@Id
	@Column(name="Photos_id")
	private int photosId;
	
	@NotNull
	@Length(max=500)
	@Column(name="Images", unique = true)
	private String img;
	
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

	public int getPhotosId() {
		return photosId;
	}

	public void setPhotosId(int photosId) {
		this.photosId = photosId;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
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
