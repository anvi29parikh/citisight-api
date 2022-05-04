package com.citysight.controller;

import com.citysight.dto.LocationDto;
import com.citysight.dto.ResponseDto;
import com.citysight.services.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/admin")
public class ManageLocationController {

    @Autowired
    private LocationService locationService;



    @PostMapping("/addLocation")
    public ResponseEntity<ResponseDto> addLocation (@Valid @RequestBody LocationDto locationDto) {
        //log.info("Attemtng to create a account with email : {}", account.getEmail());
        locationService.addLocation(locationDto);
        return new ResponseEntity<>(new ResponseDto("Status: " + HttpStatus.CREATED, "LOCATION_ADDED"), HttpStatus.CREATED);
    }

    @PostMapping("/updateLocation/{id}")
    public ResponseEntity<ResponseDto> updateLocation (@PathVariable int id, @Valid @RequestBody LocationDto locationDto) {
        //log.info("Attemtng to create a account with email : {}", account.getEmail())
        System.out.println("desc:"+locationDto.getDescription());
        locationService.updateLocation(id, locationDto);
        return new ResponseEntity<>(new ResponseDto("Status: " + HttpStatus.CREATED, "LOCATION_Updated"), HttpStatus.CREATED);
    }
    
    @DeleteMapping("/location/{id}")
    public ResponseEntity<ResponseDto> deleteLocation (@PathVariable int id){
    	locationService.deleteLocation(id);
    	return new ResponseEntity<>(new ResponseDto("Status: " + HttpStatus.OK, "Locaton Deleted"), HttpStatus.OK);
    }
    
    @GetMapping("/locations")
    public ResponseEntity<ResponseDto> fetchLocations (){
    	
    	return new ResponseEntity<>(locationService.fetchLocations(), HttpStatus.OK);
    }


}
