package com.guruexception;

import java.util.List;

import org.springframework.stereotype.Service;


public interface BlogService {

	Blog insertblog(Blog blog) throws BlogAlreadyExistsException;
	
	List<Blog> getAllBlog() throws BlogNotFoundException;
	
	Blog getById(int id) throws BlogNotFoundException;
}
