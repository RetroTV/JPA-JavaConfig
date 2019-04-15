package com.jj.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;

import com.jj.vo.User;

public interface GenericDao<T, Id extends Serializable> {
		
	public void add(T entity);
	public void update(T entity);
	public void delete(T entity);
	public void deleteAll();
	public User findById(Id id);
	public List<T> findAll();
	
	public Session openSession();
	public Session openSessionWithTransaction();
	public void closeSession();
	public void closeSessionWithTransaction();
	public void transactionRollback(Exception e);
}
