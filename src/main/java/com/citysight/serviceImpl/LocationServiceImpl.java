package com.citysight.serviceImpl;

import com.citysight.dto.*;
import com.citysight.entities.Account;
import com.citysight.entities.Location;
import com.citysight.enums.ErrorEnum;
import com.citysight.exception.CustomException;
import com.citysight.repository.LocationRepository;

import com.citysight.services.AccountService;
import com.citysight.services.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocationServiceImpl implements LocationService {

    @Autowired
    private LocationRepository locationRepository;

    @Override
    public void addLocation(LocationDto locationDto)
    {

        Location location = new Location();

        location.setName(locationDto.getName());
        location.setAddress(locationDto.getAddress());
        location.setDescription(locationDto.getDescription());
        location.setDirections(locationDto.getDirection());
        location.setLongitude(locationDto.getLongitude());
        location.setLatitude(locationDto.getLatitude());

        locationRepository.save(location);



    }

    @Override
    public void updateLocation(int id, LocationDto locationDto)
    {

        Location location = new Location();



        String name= locationDto.getName();
        String address = locationDto.getAddress();
        String description = locationDto.getDescription();
        String direction = locationDto.getDirection();
        String longitude = locationDto.getLongitude();
        String latitude = locationDto.getLatitude();

        System.out.println("description:"+description);
        locationRepository.updatedLocation(name,address,description,direction,latitude, longitude, id);




    }

    @Override
    public void deleteLocation(int id) {
    	Optional<Location> locationObj = locationRepository.findByLocationId(id);
    	if(locationObj.isPresent()) {
    		Location location = locationObj.get();
    		location.setActiveFlag(false);
    		locationRepository.save(location);
    	}
    }
    
    @Override
    public ResponseDto fetchLocations () {
    	ResponseDto responseDto = new ResponseDto();
    	List<Location> locationList = locationRepository.findAll();
    	responseDto.setData(locationList);
		responseDto.setMetadata(null);
		return responseDto;
    }

    @Override
    public ResponseDto fetchLocationById(int id) {
    	ResponseDto responseDto = new ResponseDto();
    	Optional<Location> location = locationRepository.findByLocationId(id);
    	if(location.isPresent()) {
    		responseDto.setData(location.get());
    		responseDto.setMetadata(null);
    		return responseDto;
    	}else {
    		throw new CustomException(ErrorEnum.NOT_FOUND,HttpStatus.NOT_FOUND);
    	}
    	
    }

    @Override
    public ResponseDto fetchActiveLocations() {
    	ResponseDto responseDto = new ResponseDto();
    	List<Location> locationList = locationRepository.findAllByActiveFlag(true);
    	responseDto.setData(locationList);
		responseDto.setMetadata(null);
		return responseDto;
    	
    }
}
