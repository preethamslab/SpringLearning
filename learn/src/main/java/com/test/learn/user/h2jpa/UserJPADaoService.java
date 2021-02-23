package com.test.learn.user.h2jpa;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.ManagedBean;

import org.springframework.stereotype.Component;

@Component
public class UserJPADaoService 
{
	private static List<UserJPA> userList = new ArrayList<UserJPA>();
	private static int usersCount = 3;
	static {
		userList.add(new UserJPA(1,"preetham",new Date()));
		userList.add(new UserJPA(2,"uttu",new Date()));
		userList.add(new UserJPA(3,"kuttu",new Date()));
	}
	
	public List<UserJPA> findAll()
	{
		return userList;
	}
	
	public UserJPA saveUser(UserJPA user)
	{
		if(user.getId() == null)
		{
			user.setId(usersCount++);
		}
		userList.add(user);
		return user; 
	}
	
	public UserJPA findById(int id)
	{
		for(UserJPA user:userList)
		{
			if(user.getId() == id)
			{
				return user;
			}
		}
		return null;
	}
	
}
