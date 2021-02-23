package com.test.learn.user.posts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserPostController 
{
	@Autowired
	private UserPostDao userPostDao;
	
	@GetMapping("users/{userid}/{postid}")
	public UserPost getPost(@PathVariable int userid, @PathVariable int postid)
	{
		UserPost userPost = userPostDao.getPost(userid, postid);
		if(userPost == null)
		{
			throw new UserPostNotExistsException(userid+postid+"  doesn't exist");
		}
		return userPost;
		
	}
}
