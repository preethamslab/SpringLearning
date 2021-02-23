package com.test.learn.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.ManagedBean;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService 
{
	private static List<User> userList = new ArrayList<User>();
	private static int usersCount = 3;
	static {
		userList.add(new User(1,"preetham",new Date()));
		userList.add(new User(2,"uttu",new Date()));
		userList.add(new User(3,"jammy",new Date()));
	}
	
	public List<User> findAll()
	{
		return userList;
	}
	
	public User saveUser(User user)
	{
		if(user.getId() == null)
		{
			user.setId(usersCount++);
		}
		userList.add(user);
		return user; 
	}
	
	public User findById(int id)
	{
		for(User user:userList)
		{
			if(user.getId() == id)
			{
				return user;
			}
		}
		return null;
	}
	
}
