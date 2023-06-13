package com.guruexception;

public class BlogAlreadyExistsException  extends RuntimeException{

	private String message;

	public BlogAlreadyExistsException(String message) {
		super();
		this.message = message;
	}

	public BlogAlreadyExistsException() {
		
	}
	
	
	
}
