package com.citysight.entities;

import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import com.citysight.dto.LocationDto;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


@Entity

@Table(name="locations")

public class Location{

    @Id
    @Column(name="location_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int locationId;


    @Length(max=100)
    @Column(name="name")
    private String name;


    @Length(max=200)
    @Column(name="address")
    private String address;


    @Length(max=5000)
    @Column(name="description")
    private String description;


    @Length(max=200)
    @Column(name="directions")
    private String directions;



    @Length(max=200)
    @Column(name="latitude")
    private String latitude;


    @Length(max=200)
    @Column(name="longitude")
    private String longitude;


    @Column(name = "active_flag", columnDefinition = "tinyint default 1")
    private boolean activeFlag = true;

    public Location() {

    }


    // Getters and Setters


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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDirections() {
        return directions;
    }

    public void setDirections(String directions) {
        this.directions = directions;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public boolean isActiveFlag() {
        return activeFlag;
    }

    public void setActiveFlag(boolean activeFlag) {
        this.activeFlag = activeFlag;
    }

    public Location(int locationId, String name, String address, String description, String directions, String latitude, String longitude, boolean activeFlag) {
        this.locationId = locationId;
        this.name = name;
        this.address = address;
        this.description = description;
        this.directions = directions;
        this.latitude = latitude;
        this.longitude = longitude;
        this.activeFlag = activeFlag;
    }



}
