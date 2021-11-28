package com.citysight.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.citysight.entities.Location;
import com.citysight.entities.Review;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer> {

	@Query("from Review r where r.location.id=?1 and r.activeFlag=true")
	List<Review> fetchByLocationId(int id);
	
	Optional<Review> findByReviewIdAndLocationAndActiveFlag(int reviewId, Location location, Boolean activeFlag);
}
