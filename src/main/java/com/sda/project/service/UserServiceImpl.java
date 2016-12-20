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
	UserDao dao;
	
	public User findUserById(int id) {
		return dao.findUserById(id);
	}

	public void saveUser(User user) {
		dao.saveUser(user);
	}

	public void updateUser(User user) {
		User entity = dao.findUserById(user.getId());
		if(entity!=null){
			entity.setLogin(user.getLogin());
		}
	}

	public void deleteUserById(int id) {
		dao.deleteUserById(id);
	}
	
	public List<User> findAllUsers() {
		return dao.findAllUsers();
	}
	
	public boolean isUserIdUnique(int id) {
		User user = findUserById(id);
		return ( user == null);
	}
	
}
