package com.sda.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sda.project.dao.UserDao;
import com.sda.project.model.User;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;

	public void saveUser(User user) {
		userDao.saveUser(user);
	}

	public void updateUser(User user) {
		User entity = userDao.findUserById(user.getUserId());
		if(entity!=null){
			entity.setLogin(user.getLogin());
		}
	}

	public void deleteUserById(int id) {
		userDao.deleteUserById(id);
	}
	
	public User findUserById(int id) {
		return userDao.findUserById(id);
	}
	
	public List<User> findAllUsers() {
		return userDao.findAllUsers();
	}
	
	public boolean isUserIdUnique(int id) {
		User user = findUserById(id);
		return ( user == null);
	}
	
}
