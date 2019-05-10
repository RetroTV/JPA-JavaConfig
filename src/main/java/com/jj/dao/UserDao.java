package com.jj.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jj.vo.User;

//밑에 주석처리된 selectByColumn()메소드의 createCriteria()를 이용한 예제에서 쓰는 패키지
//import org.hibernate.Criteria;
//import org.hibernate.criterion.MatchMode;
//import org.hibernate.criterion.Restrictions;

@Repository
@Transactional
public class UserDao implements GenericDao<User, Integer> {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	Session session = null;
	
	Logger log = Logger.getLogger(this.getClass());
	
	@Override
	public void insert(User user) {
		getSession().save(user);
	}

	@Override
	public void update(User user) {
		getSession().update(user);
	}

	@Override
	public void delete(User user) {
		getSession().delete(user);
	}

	@Override
	public void deleteAll() {
		getSession().createQuery("DELETE FROM users");
	}
	
	@Override
	public User selectById(Integer id) {
		User user = getSession().get(User.class, id);
		return user;
	}
	
	@Override
	public List<User> selectAll() {
		List<User> users = getSession().createQuery("SELECT * FROM users", User.class)
									   .getResultList();
		return users;
	}
	
	@Override
	public List<User> selectByColumn(String columnName, String word) {
		/*
		현재 createCriteria() 메소드는 작동은 하지만 하이버네이트가 공식적으로 지원 중단한 상태임.
		List<User> users = sessionFactory.getCurrentSession()
										 .createCriteria(User.class)
										 .add(Restrictions.like("name", "Dummy", MatchMode.ANYWHERE)) // 앞이든 뒤든 name 프로퍼티에서 Dummy라는 단어가 있으면 찾아옴
										 .list();
		*/
		
		CriteriaBuilder cb 			 = getSession().getCriteriaBuilder();
		CriteriaQuery<User> criteria = cb.createQuery(User.class);
		Root<User> root 			 = criteria.from(User.class);
		
		criteria.select(root)
				.where(cb.like(root.get(columnName), word));
		
		List<User> users = getSession().createQuery(criteria).getResultList();
		
		return users;
	}
	
	@Override
	public Session getSession() {
		session = sessionFactory.getCurrentSession();
		return session;
	}
}
