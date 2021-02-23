package com.test.learn.user.posts;

public class UserPost 
{
	private int id;
	private String postName;
	private String postDescription;
	
	protected UserPost() {
		
	}
	
	public UserPost(int id, String postName, String postDescription) {
		super();
		this.id = id;
		this.postName = postName;
		this.postDescription = postDescription;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPostName() {
		return postName;
	}
	public void setPostName(String postName) {
		this.postName = postName;
	}
	public String getPostDescription() {
		return postDescription;
	}
	public void setPostDescription(String postDescription) {
		this.postDescription = postDescription;
	}
	
	
	
}
