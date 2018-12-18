package com.ctgu.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ctgu.ssm.dao.UserDao;
import com.ctgu.ssm.entity.User;
import com.ctgu.ssm.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userDao;
	@Override
	public int addUser(User user) {
		return userDao.insertUser(user);
	}
	@Override
	public List<User> findUserBySome(User user) {
		return userDao.findUserBySome(user);
	}
	@Override
	public User findUserByUsername(String username) {
		return userDao.findUserByUsername(username);
	}
	@Override
	public User findUserByStudentid(String studentid) {
		return userDao.findUserByStudentid(studentid);
	}
	@Override
	public List<User> findAllUser() {
		return userDao.findAllUser();
	}
	@Override
	public int updateUser(User user) {
		return userDao.updateUser(user);
	}
	
}
