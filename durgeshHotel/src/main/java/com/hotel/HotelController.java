package com.hotel;

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
@RequestMapping("/hotels")
public class HotelController {

	@Autowired
	private HotelService hotelService;
	
	@PostMapping
	public ResponseEntity<Hotel> insert(@RequestBody Hotel h){
		Hotel insert = this.hotelService.insert(h);
		return ResponseEntity.status(HttpStatus.CREATED).body(insert);
		
	}
	
	@GetMapping
	public ResponseEntity<List<Hotel>> getAllHotel(){
		List<Hotel> all = this.hotelService.getAll();
		return ResponseEntity.ok(all);
	}
	
	@GetMapping("/{hid}")
	public ResponseEntity<Hotel> getById(@PathVariable String hid){
		Hotel byId = this.hotelService.getById(hid);
		return ResponseEntity.status(HttpStatus.OK).body(byId);
	}
}
