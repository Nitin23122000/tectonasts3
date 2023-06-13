
package com.guruexception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(BlogNotFoundException.class)
	public ResponseEntity blogNotFoundException(BlogNotFoundException ex) {
		return new ResponseEntity(" blog not present in database", HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(BlogAlreadyExistsException.class)
	public ResponseEntity blogAlreadyExists(BlogAlreadyExistsException ex) {
		return new ResponseEntity("blog is already exists in database", HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
