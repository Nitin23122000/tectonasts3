package com.rating;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ratings")
public class RatingController {

	@Autowired
	private RatingService ratingservice;
	
	@PostMapping
	public ResponseEntity<Rating> insert(@RequestBody Rating rating){
		Rating insert = this.ratingservice.insert(rating);
		return ResponseEntity.status(HttpStatus.CREATED).body(insert);
	}
	
	@GetMapping
	public ResponseEntity<List<Rating>> getAllRating(){
		List<Rating> allRating = this.ratingservice.getAllRating();
		return ResponseEntity.status(HttpStatus.OK).body(allRating);
	}
	
	@GetMapping("/user/{uid}")
	public ResponseEntity<List<Rating>> getbyUid(@PathVariable String uid){
		List<Rating> allbyUid = this.ratingservice.getAllbyUid(uid);
		return ResponseEntity.status(HttpStatus.OK).body(allbyUid);
	}
	
	@GetMapping("/hotel/{hid}")
	public ResponseEntity<List<Rating>> getbyHid( @PathVariable String hid){
		List<Rating> allbyHid = this.ratingservice.getAllbyHid(hid);
		return ResponseEntity.status(HttpStatus.OK).body(allbyHid);
	}
}
