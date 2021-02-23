package com.test.learn.user.posts;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.test.learn.user.User;


@Component
public class UserPostDao 
{
	private static Map<Integer,UserPost> userPosts = new HashMap<Integer,UserPost>();
	
	
	static {
		userPosts.put(1,new UserPost(1,"preetham","awesome post"));
		userPosts.put(2,new UserPost(2,"Uttu","awesome post Uttu"));
		userPosts.put(3,new UserPost(3,"Kuttu","awesome post Kuttu"));
	}
	
	//getPost
	//createPost
	//ReadALlPosts
	
	public UserPost getPost(int userid,int postId)
	{
		if(userPosts.get(userid) != null)
			{
				UserPost post = userPosts.get(userid);
				return post;
			}
		return null;
	}
	
}
