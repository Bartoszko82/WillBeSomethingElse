package com.sda.project.service;

import java.util.List;

import com.sda.project.model.User;


public interface UserService {


	
	void saveUser(User user);
	
//	void updateUser(User user);
//	
//	void deleteUserById(int id);
	
	User findUserById(int id);

	List<User> findAllUsers(); 
	
	boolean isUserIdUnique(int id);
}