package com.ctgu.ssm.dao;

import java.util.List;

import com.ctgu.ssm.entity.User;

/**
 * @Title: UserDao.java
 *
 * @Package com.ctgu.bookstore.dao
 *
 * @Description: TODO
 *
 * @author Fantasy
 *
 * @date 2018年6月7日
 *
 * @version V1.0
 */
public interface UserDao {
	int insertUser(User user);
	
	List<User> findUserBySome(User user);
	
	List<User> findAllUser();
	
	User findUserByUsername(String username);
	
	User findUserByStudentid(String studentid);
	
	int updateUser(User user);
	
}
