package com.jj.dao;

import java.io.Serializable;
import java.util.List;

import com.jj.vo.User;

public interface GenericDao<T, Id extends Serializable> {
	
	public void add(T entity);
	public void update(T entity);
	public void delete(T entity);
	public void deleteAll();
	public User findById(Id id);
	public List<T> findAll();
}
