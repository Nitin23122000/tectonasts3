package com.guruexception;

public class BlogNotFoundException  extends RuntimeException{

	private String message;

	public BlogNotFoundException(String message) {
		super();
		this.message = message;
	}

	public BlogNotFoundException() {
		
	}
	
	
}
