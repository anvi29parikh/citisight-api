package com.citysight.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.citysight.dto.ResponseDto;
import com.citysight.dto.ReviewDto;
import com.citysight.services.ReviewService;

@RestController("/admin")
public class ManageLocationReviewController {

	@Autowired
	private ReviewService reviewService;
	
	@GetMapping("/location/{id}/reviews")
	public ResponseEntity<ResponseDto> fetchReviewsByLocationId(@PathVariable int id){
		return new ResponseEntity<>(reviewService.findReviewByLocationId(id), HttpStatus.OK);
	}
	
	@GetMapping("/location/{id}/reviews/{reviewId}")
	public ResponseEntity<ResponseDto> fetchReviewsByLocationIdAndReviewId(@PathVariable int id, @PathVariable int reviewId){
		return new ResponseEntity<>(reviewService.findReviewByLocationIdAndReviewId(id, reviewId), HttpStatus.OK);
	}
	
	@PostMapping("/location/{id}/review")
	public ResponseEntity<ResponseDto> insertReviewByLocationId(@PathVariable int id, @RequestBody ReviewDto reviewDto){
		reviewService.insertReviewByLocationId(id, reviewDto);
		return new ResponseEntity<>(new ResponseDto("Status: " + HttpStatus.CREATED, "REVIEW_CREATED"), HttpStatus.CREATED);
	}
	
	@PutMapping("/location/{id}/review/{reviewId}")
	public ResponseEntity<ResponseDto> updateReviewByLocationIdAndReviewId(@PathVariable int id, @PathVariable int reviewId, @RequestBody ReviewDto reviewDto){
		reviewService.updatetReviewByLocationId(id, reviewId, reviewDto);
		return new ResponseEntity<>(new ResponseDto("Status: " + HttpStatus.CREATED, "REVIEW_UPDATED"), HttpStatus.OK);
	}
	
	@DeleteMapping("/location/{id}/review/{reviewId}")
	public ResponseEntity<ResponseDto> deleteReviewById(@PathVariable int id, @PathVariable int reviewId){
		reviewService.deleteReviewByLocationIdAndReviewId(id,reviewId);
		return new ResponseEntity<>(new ResponseDto("Status: " + HttpStatus.OK, "REVIEW_DELETED"), HttpStatus.OK);
	}

}
