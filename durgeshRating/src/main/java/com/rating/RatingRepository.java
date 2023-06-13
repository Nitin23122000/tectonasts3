package com.rating;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RatingRepository extends JpaRepository<Rating, String> {
	

	List<Rating> findByUid(String uid);
	
	List<Rating> findByHid(String hid);
}
