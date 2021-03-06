package com.jj.service;

import java.util.List;

import com.jj.vo.User;

public interface UserService {

	public User findUserByNo(Integer id);
	public void createDummyUser();
	public void updateUser(User user);
	public List<User> insertUserList(List<User> users, String example);
	public List<User> selectByUserName(String columnName, String word);
}
