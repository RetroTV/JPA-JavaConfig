package com.jj.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jj.vo.User;
import com.jj.dao.GenericDao;
import com.jj.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private GenericDao<User, Integer> userDao;
	
	Logger log = Logger.getLogger(this.getClass());
	
	@Override
	public User findUserByNo(Integer id) {
		User user = userDao.selectById(id);
		
		return user;
	}
	
	@Override
	@Transactional
	public void createDummyUser() {
				
		User user = new User("dummy", "password", "dummy@gmail.com", "Dummy");
		
		userDao.insert(user);
	}

	@Override
	@Transactional
	public void updateUser(User user) {
		
		userDao.update(user);
	}
	
	@Override
	@Transactional
	public List<User> insertUserList(List<User> users, String example) {
		
		List<User> createdUsers = new ArrayList<>();
				
		if("example2".equals(example)) {			
			for(User user : users) {
				if("dummy4".equals(user.getId())) {
					log.error("Dummy4일때 고의로 Exception을 발생시킵니다");
					user = null;
					userDao.insert(user);
				} else {
					log.error(user.getId() + "유저를 추가합니다");
					userDao.insert(user);
					createdUsers.add(userDao.selectById(user.getNo()));
				}
			}
		}
		
		if("example3".equals(example)) {			
			for(User user : users) {
				// 실제로는 에러가 아니니 신경쓰지 말것, info로 설정하면 hibernate 자체 로그 기능 때문에 로그 정보가 뜨지 않음
				log.error(user.getId() + "유저를 추가합니다 (실제로는 에러가 아님 *주석 참고)");
				userDao.insert(user);
				createdUsers.add(userDao.selectById(user.getNo()));	
			}
		}
		
		return createdUsers;
	}
	
	@Override
	@Transactional
	public List<User> selectByUserName(String columnName, String word) {
		List<User> users = userDao.selectByColumn(columnName, word);
		return users;
	}
}
