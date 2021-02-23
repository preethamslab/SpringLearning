package com.test.learn.user.h2jpa;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.annotation.Resource;
import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

// hypermedia as engine for the application state
// hateoas
@RestController
public class UserJPAController 
{
	
	@Autowired 
	private UserRepository userRespository;
	
	@Autowired
	private PostRepository postRepository;
	
	@GetMapping("/jpa/users")
	public List<UserJPA> getAllUsers()
	{
		System.out.println("inside JPA");
		return userRespository.findAll();
	}
	
	@GetMapping("/jpa/users/{userId}")
	public Optional<UserJPA> getUser(@PathVariable int userId)
	{
		Optional<UserJPA> user= userRespository.findById(userId);
		if(!user.isPresent())
		{
			throw new UserJPANotFoundException(" id "+userId);
		}
		
		return user;
		
		
		/*
		 * //HATEOAS //"all-users", server_path+"/users" EntityModel<UserJPA> resource =
		 * EntityModel.of(user);
		 * 
		 * WebMvcLinkBuilder linkTo = linkTo(methodOn(this.getClass()).getAllUsers());
		 * 
		 * resource.add(linkTo.withRel("all-users")); return resource;
		 */
	}
	
	@PostMapping("jpa/users")
	public ResponseEntity<Object> createUser(@Valid @RequestBody UserJPA user)
	{
		UserJPA savedUser = userRespository.save(user);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
		.path("/{id}").buildAndExpand(savedUser.getId()).toUri();
		
		return ResponseEntity.created(location).build();
		
		//return savedUser;
	}
	
	@DeleteMapping("jpa/users/{id}")
	public void deleteUser(@PathVariable int id)
	{
		userRespository.deleteById(id);
	}
	
	@GetMapping("/jpa/users/{id}/posts")
	public List<Post> getAllUsers(@PathVariable int id)
	{
		System.out.println("inside JPA");
		Optional<UserJPA> user = userRespository.findById(id);
		if(!user.isPresent())
		{
			throw new UserJPANotFoundException("ID - "+id);
		}
		if(user.get().getPosts().size() == 0)
		{
			throw new UserJPANotFoundException("ID - "+id);
		}
		
		return user.get().getPosts();
	} 
	
	@PostMapping("/jpa/users/{id}/posts")
	public ResponseEntity<Object> createPost(@PathVariable int id,@Valid @RequestBody Post post)
	{
		Optional<UserJPA> userOptional = userRespository.findById(id);
		
		if(!userOptional.isPresent())
		{
			throw new UserJPANotFoundException("ID    "+id );
		}
		
		UserJPA user = userOptional.get();
		
		post.setUser(user);
		postRepository.save(post);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/jpa/users/{id}/posts").buildAndExpand(post.getId()).toUri();
				
				return ResponseEntity.created(location).build();
	
	} 
	
	
}
