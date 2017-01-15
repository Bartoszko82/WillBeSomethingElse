package com.sda.project.dao;

import java.util.List;

import com.sda.project.model.User;

public interface UserDao {


	void saveUser(User user);
	
	void deleteUserById(int id);

	User findUserById(int id);
	
	List<User> findAllUsers();
}
