package com.citysight.dto;

import com.citysight.entities.Review;


public class LocationDto {

    private int locationId;
    private String name;
    private String address;
    private String description;
    private String direction;
    private String latitude;
    private String longitude;

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

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
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

    public LocationDto(int locationId, String name, String address, String description, String direction, Review review, String latitude, String longitude) {
        this.locationId = locationId;
        this.name = name;
        this.address = address;
        this.description = description;
        this.direction = direction;

        this.latitude = latitude;
        this.longitude = longitude;
    }

    public LocationDto() {
        super();
    }
}
