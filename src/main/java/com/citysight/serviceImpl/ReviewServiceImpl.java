package com.citysight.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.citysight.dto.ResponseDto;
import com.citysight.dto.ReviewDto;
import com.citysight.entities.Location;
import com.citysight.entities.Review;
import com.citysight.enums.ErrorEnum;
import com.citysight.exception.CustomException;
import com.citysight.repository.LocationRepository;
import com.citysight.repository.ReviewRepository;
import com.citysight.services.ReviewService;

@Service
public class ReviewServiceImpl implements ReviewService{
	
	@Autowired
	private ReviewRepository reviewRepository;
	
	@Autowired
	private LocationRepository locationRepository;
	
	@Override
	public ResponseDto findReviewByLocationId(int id) {
		List<Review> reviews =  reviewRepository.fetchByLocationId(id);	
		ResponseDto responseDto = new ResponseDto();
		responseDto.setData(reviews);
		responseDto.setMetadata(null);
		return responseDto;
	}
	
	@Override
	public void insertReviewByLocationId(int id, ReviewDto reviewDto) {
		Optional<Location> optionalLocation = locationRepository.findByLocationIdAndActiveFlag(id, true);
		if(optionalLocation.isPresent()) {
			Location location = optionalLocation.get();
			Review review = new Review();
			review.setActiveFlag(true);
			review.setRatings(reviewDto.getRatings());
			review.setReview(reviewDto.getReview());
			review.setLocation(location);
			reviewRepository.save(review);
		}else {
			throw new CustomException(ErrorEnum.NOT_FOUND, HttpStatus.NOT_FOUND);
		}
	}
	
	@Override
	public void updatetReviewByLocationId(int id, int reviewId, ReviewDto reviewDto) {
		Optional<Location> optionalLocation = locationRepository.findByLocationIdAndActiveFlag(id, true);
		if(optionalLocation.isPresent()) {
			Optional<Review> optionalReview = reviewRepository.findByReviewIdAndLocationAndActiveFlag(reviewId, optionalLocation.get(), true);
			if(optionalReview.isPresent()) {
				Review review = optionalReview.get();
				review.setRatings(reviewDto.getRatings());
				review.setReview(reviewDto.getReview());
				reviewRepository.save(review);
			}else {
				throw new CustomException(ErrorEnum.NOT_FOUND, HttpStatus.NOT_FOUND);
			}
		}else {
			throw new CustomException(ErrorEnum.NOT_FOUND, HttpStatus.NOT_FOUND);
		}
		
	}
	
	@Override
	public void deleteReviewByLocationIdAndReviewId(int id, int reviewId) {
		Optional<Location> optionalLocation = locationRepository.findByLocationIdAndActiveFlag(id, true);
		if(optionalLocation.isPresent()) {
			Optional<Review> optionalReview = reviewRepository.findByReviewIdAndLocationAndActiveFlag(reviewId, optionalLocation.get(), true);
			if(optionalReview.isPresent()) {
				Review review = optionalReview.get();
				review.setActiveFlag(false);
				reviewRepository.save(review);
			}else {
				throw new CustomException(ErrorEnum.NOT_FOUND, HttpStatus.NOT_FOUND);
			}
		}else {
			throw new CustomException(ErrorEnum.NOT_FOUND, HttpStatus.NOT_FOUND);
		}
	}
	
	@Override
	public ResponseDto findReviewByLocationIdAndReviewId(int id, int reviewId) {
		Optional<Location> optionalLocation = locationRepository.findByLocationIdAndActiveFlag(id, true);
		if(optionalLocation.isPresent()) {
			Optional<Review> optionalReview = reviewRepository.findByReviewIdAndLocationAndActiveFlag(reviewId, optionalLocation.get(), true);
			if(optionalReview.isPresent()) {
				ResponseDto responseDto = new ResponseDto();
				Review review = optionalReview.get();
				responseDto.setData(review);
				responseDto.setMetadata(null);
				return responseDto;
			}else {
				throw new CustomException(ErrorEnum.NOT_FOUND, HttpStatus.NOT_FOUND);
			}
		}else {
			throw new CustomException(ErrorEnum.NOT_FOUND, HttpStatus.NOT_FOUND);
		}
	}
}
