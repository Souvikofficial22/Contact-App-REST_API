package com.monocept.service;

import java.util.List;

import com.monocept.entity.User;

public interface IUserService {
	
	public List<User> saveAll(List<User> users);
	public User save(User user);
	public List<User> getAllUsers();

}
