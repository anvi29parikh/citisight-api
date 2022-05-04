package com.citysight.dto;

public class ReviewDto {
	private String review;
	private int ratings;
	public String getReview() {
		return review;
	}
	public void setReview(String review) {
		this.review = review;
	}
	public int getRatings() {
		return ratings;
	}
	public void setRatings(int ratings) {
		this.ratings = ratings;
	}
	/**
	 * @param review
	 * @param ratings
	 */
	public ReviewDto(String review, int ratings) {
		super();
		this.review = review;
		this.ratings = ratings;
	}
	/**
	 * 
	 */
	public ReviewDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
