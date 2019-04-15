package com.jj.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jj.vo.User;

@Repository
@Transactional
public class UserDao implements GenericDao<User, Integer> {
	
	
	@Autowired
	private SessionFactory sessionFactory;
	
	Logger log = Logger.getLogger(this.getClass());
	
	@Override
	public void add(User user) {
		sessionFactory.getCurrentSession().save(user);
	}

	@Override
	public void update(User user) {
		sessionFactory.getCurrentSession().update(user);
	}

	@Override
	public void delete(User user) {
		sessionFactory.getCurrentSession().delete(user);
	}

	@Override
	public void deleteAll() {
		sessionFactory.getCurrentSession().createQuery("DELETE FROM users");
	}
	
	@Override
	public User findById(Integer id) {
		User user = sessionFactory.getCurrentSession().get(User.class, id);
		return user;
	}
	
	@Override
	public List<User> findAll() {
		List<User> users = sessionFactory.getCurrentSession().createQuery("SELECT * FROM users", User.class).getResultList();
		return users;
	}
}
