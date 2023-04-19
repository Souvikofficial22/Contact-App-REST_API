package com.monocept.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.monocept.entity.User;
import com.monocept.service.IUserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private IUserService service;
	
	@PostMapping("/save-all")
	public List<User> saveAll(@RequestBody List<User> users){
		return service.saveAll(users);
	}
	
	@PostMapping("/save")
	public User saveUser(@RequestBody User user) {
		return service.save(user);
	}
	
	@GetMapping("/get-all-users")
	public List<User> getAllUsers(){
		return service.getAllUsers();
	}
}
