package com.rating;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RatingServiceImpl implements RatingService{

	@Autowired
	private RatingRepository ratingRepository;
	
	
	@Override
	public Rating insert(Rating rating) {

		String string = UUID.randomUUID().toString();
		rating.setRid(string);
		return ratingRepository.save(rating);
	}

	@Override
	public List<Rating> getAllRating() {

		return ratingRepository.findAll();
	}

	@Override
	public List<Rating> getAllbyUid(String uid) {
		// TODO Auto-generated method stub
		return ratingRepository.findByUid(uid);
	}

	@Override
	public List<Rating> getAllbyHid(String hid) {

		return ratingRepository.findByHid(hid);
	}

	
}
