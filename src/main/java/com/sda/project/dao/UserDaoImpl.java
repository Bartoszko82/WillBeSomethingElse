package com.sda.project.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.sda.project.dao.AbstractDao;
import com.sda.project.model.User;

@Repository("UserDao")
public class UserDaoImpl extends AbstractDao<Integer, User> implements UserDao {

	public User findUserById(int id) {
		return getByKey(id);
	}

	public void saveUser(User user) {
		persist(user);
	}

	public void deleteUserById(int id) {
		Query query = getSession().createSQLQuery("delete from User where id = :id");
		query.setInteger("id", id);
		query.executeUpdate();
	}

	@SuppressWarnings("unchecked")
	public List<User> findAllUsers() {
		Criteria criteria = createEntityCriteria();
		return (List<User>) criteria.list();
	}

	public User findUsersById(int id) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("id", id));
		return (User) criteria.uniqueResult();
	}
}
