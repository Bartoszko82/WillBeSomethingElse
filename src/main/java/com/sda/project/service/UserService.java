package com.sda.project.service;

import java.util.List;

import com.sda.project.model.User;


public interface UserService {

	User findUserById(int id);
	
	//create user?
	
	void saveUser(User user);
	
	void updateUser(User user);
	
	void deleteUserById (int id);

	List<User> findAllUsers(); 
	
	boolean isUserIdUnique(int id);
}