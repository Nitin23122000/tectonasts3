package com.hotel;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class HotelServiceImpl implements HotelService {

	@Autowired
	private HotelRepository hotelRepository;
	
	@Override
	public Hotel insert(Hotel hotel) {
		
		 String random = UUID.randomUUID().toString();
		 hotel.setHid(random);
	    
		return hotelRepository.save(hotel);
	}

	@Override
	public List<Hotel> getAll() {
		List<Hotel> list = hotelRepository.findAll();
		return list;
	}

	@Override
	public Hotel getById(String hid) {
		return hotelRepository.findById(hid).orElseThrow(() -> new ConfigDataResourceNotFoundException(null));
		
	}

}
