package com.citysight.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.citysight.dto.LocationDto;
import com.citysight.dto.ResponseDto;
import com.citysight.services.LocationService;

@RestController
@RequestMapping("/user")
public class UserLocationController {

    @Autowired
    private LocationService locationService;
    
    @GetMapping("/location/{id}")
    public ResponseEntity<ResponseDto> fetchLocationById (@PathVariable int id) {
    	return new ResponseEntity<>(locationService.fetchLocationById(id), HttpStatus.OK);
    }
    
    @GetMapping("/locations")
    public ResponseEntity<ResponseDto> fetchActiveLocations () {
    	return new ResponseEntity<>(locationService.fetchActiveLocations(), HttpStatus.OK);
    }
}
