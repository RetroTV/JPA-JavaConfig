package com.jj.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;

import com.jj.vo.User;

public interface GenericDao<T, Id extends Serializable> {
	
	public void insert(T entity);
	public void update(T entity);
	public void delete(T entity);
	public void deleteAll();
	public User selectById(Id id);
	public List<T> selectAll();
	public List<User> selectByColumn(String columnName, String word);
	
	public Session getSession();
}
