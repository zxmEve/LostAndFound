package com.ctgu.springmvc.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ctgu.springmvc.dao.IUserDao;
import com.ctgu.springmvc.entity.User;

@Service
public class UserService {

	@Resource
	public IUserDao uDao;
	
	public boolean insertUser(User vo) throws Exception
	{
		boolean flag = uDao.insert(vo);
		return flag;
	}
	
	public boolean deleteUser(Integer id) throws Exception
	{
		boolean flag = false;
		if(uDao.findByKey(id)!=null)
		{
			flag = uDao.delete(id);
		}
		return flag;
	}
	
	public User findUserById(Integer id) throws Exception
	{
		User user = null;   
		user = uDao.findByKey(id);
		return user;
	}
	
	public List<User> findAllUsers() throws Exception
	{
		List<User> userList = null;
		userList = uDao.findAll();
		
		return userList;
	}
	public User findUserByEmail(String email) throws Exception
	{
		User user = null;   
		user = uDao.findByEmail(email);
		return user;
	}
	public User findUserByName(String username) throws Exception
	{
		User user = null;   
		user = uDao.findUserByName(username);
		return user;
	}

	
	public User checkLogin(String username, String password) throws Exception
	{
		User user = uDao.findUserByName(username);
		if(user!= null && user.getPassword().equals(password))
			return user;
		return null;
	}
	/*
	 * 修改用户信息
	 */
	public void updateUser(User user) throws Exception {
		uDao.update(user);
	}
}
