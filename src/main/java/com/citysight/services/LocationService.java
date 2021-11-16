package com.citysight.services;

import com.citysight.dto.AccountDto;
import com.citysight.dto.LocationDto;
import com.citysight.dto.LoginRequestDto;
import com.citysight.dto.UpdateDto;
import com.citysight.entities.Location;

import java.util.List;

public interface LocationService {

     void addLocation(LocationDto locationDto);

     void updateLocation(int id, LocationDto locationDto);



}
