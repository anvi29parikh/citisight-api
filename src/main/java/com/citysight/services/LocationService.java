package com.citysight.services;

import com.citysight.dto.AccountDto;
import com.citysight.dto.LocationDto;
import com.citysight.dto.LoginRequestDto;
import com.citysight.dto.ResponseDto;
import com.citysight.dto.UpdateDto;
import com.citysight.entities.Location;

import java.util.List;

import org.springframework.http.ResponseEntity;

public interface LocationService {

     void addLocation(LocationDto locationDto);

     void updateLocation(int id, LocationDto locationDto);

     void deleteLocation(int id);
     
     ResponseDto fetchLocations();
     
     ResponseDto fetchActiveLocations();
     
     ResponseDto fetchLocationById(int id);
}
