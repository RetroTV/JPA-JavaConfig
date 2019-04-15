package com.jj.service;

import java.util.ArrayList;
import java.util.List;

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
		userDao.openSession();
		User user = userDao.findById(id);
		userDao.closeSession();
		
		return user;
	}
	
	@Override
	public void createDummyUser() {
				
		User user = new User("dummy", "password", "dummy@gmail.com", "Dummy");

		userDao.openSessionWithTransaction();
		userDao.add(user);
		userDao.closeSessionWithTransaction();
	}

	@Override
	public List<User> insertUserList(List<User> users, String example) {
		
		List<User> savedAfterGetUsers = new ArrayList<>();
		
		userDao.openSessionWithTransaction();
		
		if("example2".equals(example)) {			
			for(User user : users) {
				if("dummy4".equals(user.getId())) {
					log.error("Dummy4일때 고의로 Exception을 발생시킵니다");
					user = null;
					userDao.add(user);
				} else {
					log.error(user.getId() + "유저를 추가합니다");
					userDao.add(user);
					savedAfterGetUsers.add(userDao.findById(user.getNo()));
				}
			}
		}
		
		if("example3".equals(example)) {			
			for(User user : users) {
				// 실제로는 에러가 아니니 신경쓰지 말것, info로 설정하면 hibernate 자체 로그 기능 때문에 로그 정보가 뜨지 않는다
				log.error(user.getId() + "유저를 추가합니다 (실제로는 에러가 아님 *주석 참고)");
				userDao.add(user);
				savedAfterGetUsers.add(userDao.findById(user.getNo()));
			}
		}
		userDao.closeSessionWithTransaction();
		
		return savedAfterGetUsers;
	}
}
