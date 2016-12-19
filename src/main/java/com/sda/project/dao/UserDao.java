package com.sda.project.dao;

import java.util.List;

import com.sda.project.model.User;

public interface UserDao {

	User findUserById(int id);

	void saveUser(User user);
	
	void deleteUserById(int id);
	
	List<User> findAllUsers();
}
