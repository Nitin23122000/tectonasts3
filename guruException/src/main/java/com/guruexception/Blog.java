package com.guruexception;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Blog {

	@Id
	private int blogid;
	private String blogTitle;
	private String blogCreator;
	private int yearOfPost;
	public int getBlogid() {
		return blogid;
	}
	public void setBlogid(int blogid) {
		this.blogid = blogid;
	}
	public String getBlogTitle() {
		return blogTitle;
	}
	public void setBlogTitle(String blogTitle) {
		this.blogTitle = blogTitle;
	}
	public String getBlogCreator() {
		return blogCreator;
	}
	public void setBlogCreator(String blogCreator) {
		this.blogCreator = blogCreator;
	}
	public int getYearOfPost() {
		return yearOfPost;
	}
	public void setYearOfPost(int yearOfPost) {
		this.yearOfPost = yearOfPost;
	}
	public Blog(int blogid, String blogTitle, String blogCreator, int yearOfPost) {
		super();
		this.blogid = blogid;
		this.blogTitle = blogTitle;
		this.blogCreator = blogCreator;
		this.yearOfPost = yearOfPost;
	}
	public Blog() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
