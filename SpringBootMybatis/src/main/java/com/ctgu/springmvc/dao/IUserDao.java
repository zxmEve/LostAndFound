package com.ctgu.springmvc.dao;

import org.apache.ibatis.annotations.Mapper;

import com.ctgu.springmvc.commons.IBaseDao;
import com.ctgu.springmvc.entity.User;

@Mapper
public interface IUserDao extends IBaseDao<Integer, User> {

	public User findUserByName(String username);
	public User findByEmail(String email);
}
