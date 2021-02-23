package com.test.learn.user.h2jpa;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;

@ApiModel(description="all details about the user posts ")
@Entity
public class Post 
{
	@Id
	@GeneratedValue
	private Integer id;
	
	@Size(min = 5, message="description should be minimum 5 characters")
	private String description;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JsonIgnore
	private UserJPA user;
	
	public Post() {
		// TODO Auto-generated constructor stub
	}
	
	public Post(Integer id, String description, UserJPA user) {
		super();
		this.id = id;
		this.description = description;
		this.user = user;
	}




	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public UserJPA getUser() {
		return user;
	}
	public void setUser(UserJPA user) {
		this.user = user;
	}
	
	
	
}
