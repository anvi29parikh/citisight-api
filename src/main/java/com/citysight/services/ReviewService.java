package com.citysight.services;

import com.citysight.dto.ResponseDto;
import com.citysight.dto.ReviewDto;

public interface ReviewService {
	ResponseDto findReviewByLocationId(int id);
	
	ResponseDto findReviewByLocationIdAndReviewId(int id, int reviewId);
	
	void insertReviewByLocationId(int id, ReviewDto reviewDto);
	
	void updatetReviewByLocationId(int id, int reviewId, ReviewDto reviewDto);
	
	void deleteReviewByLocationIdAndReviewId(int id,int reviewId);
}
