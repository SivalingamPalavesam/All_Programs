package com.redis.controller;


import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.redis.entity.User;
import com.redis.userserviceimpl.UserServiceImpl;

@RestController
@RequestMapping("/api/users")
public class UserController 
{	
	@Autowired
	private  UserServiceImpl userService;

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@PostMapping
	public User saveUser(@Valid @RequestBody User user)
	{
		log.info("Rest API To Save User {} ", user);
		return userService.saveUser(user);
	}

	@PutMapping
	@CachePut(value = "users", key = "#result.id")
	//@CacheEvict(value = "users", key = "#user.id" ,condition = "#user.followers < 1000")
	public User updateUser(@Valid @RequestBody User user)
	{
		log.info("Rest API To Update User {} ", user);
		
		return userService.updateUser(user);
	}

	@GetMapping("/{id}")
	@Cacheable(value = "users", key = "#id" )
	public User findUserById(@PathVariable Long id)
	{
		log.info("Rest Api To Get User By Id {} ", id);
		return userService.getUserById(id);
	}

	@GetMapping
	public List<User> getAllUsers()
	{
		log.info("Rest Api To Get All Users");
		//https://resp.app/
		//https://www.electronjs.org/apps/anotherredisdesktopmanager
		return userService.getAllUsers();
	}

	@DeleteMapping("/{id}")
	@CacheEvict(value = "users", key = "#id")
	public ResponseEntity<String> deleteUserById(@PathVariable Long id) 
	{
		log.info("Rest Api To Delete User By Id {} ", id);
		userService.deleteUserById(id);
		return ResponseEntity.ok("User Deleted Successfully");
	}
}
