package com.guruexception;

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
public class BlogController {

	@Autowired
	 private BlogService blogService;
	
	@PostMapping("/insert")
	public ResponseEntity insertBlog(@RequestBody Blog blog) throws BlogAlreadyExistsException{
		Blog insertblog = this.blogService.insertblog(blog);
		return new ResponseEntity<>(insertblog,HttpStatus.CREATED);
	}
	
	@GetMapping("/getALL")
	public ResponseEntity<List<Blog>> getALlBlog() throws BlogNotFoundException{
		List<Blog> allBlog = this.blogService.getAllBlog();
		
		return new ResponseEntity<List<Blog>>(allBlog,HttpStatus.OK);
	}
	
	@GetMapping("/getById/{id}")
	public ResponseEntity<Blog> getById(@PathVariable("id") int id) throws BlogNotFoundException{
		Blog byId = this.blogService.getById(id);
		return new ResponseEntity<Blog>(byId,HttpStatus.OK);
	}

}
