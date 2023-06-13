package com.guruexception;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BlogServiceImpl implements BlogService{

	@Autowired
	 private BlogRepository blogRepository;
	
	
	@Override
	public Blog insertblog(Blog blog) throws BlogAlreadyExistsException {
		if(blogRepository.existsById(blog.getBlogid())) {
			throw new BlogAlreadyExistsException();
		}
		Blog save = blogRepository.save(blog);
		return save;
	}

	@Override
	public List<Blog> getAllBlog() throws BlogNotFoundException {
		List<Blog> findAll = this.blogRepository.findAll();
		return findAll;
	}

	@Override
	public Blog getById(int id) throws BlogNotFoundException {
	Blog blog;
	if(blogRepository.findById(id).isEmpty()) {
		throw new BlogNotFoundException();
	}
	else {
		 blog = this.blogRepository.findById(id).get();
	}
		return blog;
	}

}
