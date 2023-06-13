package com.rating;

import java.util.List;

public interface RatingService {

	
	//create
	
	Rating insert(Rating rating);
	
	//getall
	
	List<Rating> getAllRating();
	
	//get all by uid
	
	List<Rating> getAllbyUid(String uid);
	
	//get all by hid
	
	List<Rating> getAllbyHid(String hid);
}
