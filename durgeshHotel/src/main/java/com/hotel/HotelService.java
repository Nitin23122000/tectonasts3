package com.hotel;

import java.util.List;

public interface HotelService {

	//create 
	
	Hotel insert(Hotel hotel);
	
	//getall
	
	List<Hotel> getAll();
	
	//getById
	
	Hotel getById(String hid);
}
