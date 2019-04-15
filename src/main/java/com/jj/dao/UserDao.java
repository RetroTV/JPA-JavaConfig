package com.jj.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jj.vo.User;

@Repository
@Transactional
public class UserDao implements GenericDao<User, Integer> {
	
	
	@Autowired
	private SessionFactory sessionFactory;

	private Session session;
	private Transaction transaction;
	
	Logger log = Logger.getLogger(this.getClass());
	
	@Override
	public void add(User user) {
		getSession().save(user);
	}

	@Override
	public void update(User user) {
		getSession().update(user);
	}

	@Override
	public void delete(User user) {
		
	}

	@Override
	public void deleteAll() {
		
	}
	
	@Override
	public User findById(Integer id) {
		User user = session.get(User.class, id);
		return user;
	}
	
	@Override
	public List<User> findAll() {
		return null;
	}
	
	//<!-- 하이버네이트 세션 관리 메소드들 -->//
	
	@Override
	public Session openSession() {
		session = sessionFactory.openSession();
		return session;
	}
	
	@Override
	public Session openSessionWithTransaction() {
		session = sessionFactory.openSession();
		transaction = session.beginTransaction();
		
		return session;
	}
	
	@Override
	public void closeSession() {
		session.close();
	}
	
	@Override
	public void closeSessionWithTransaction() {
		session.getTransaction().commit();
		session.close();
	}
	
    public Transaction getTransaction() {
        return transaction;
    }
 
    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }
	
    public Session getSession() {
        return session;
    }
 
    public void setSession(Session session) {
        this.session = session;
    }
    
	@Override
	public void transactionRollback(Exception e) {
		e.printStackTrace();
		session.getTransaction().rollback();
		session.close();
	}
}
