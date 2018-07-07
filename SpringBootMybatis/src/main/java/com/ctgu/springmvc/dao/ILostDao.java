package com.ctgu.springmvc.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ctgu.springmvc.commons.IBaseDao;
import com.ctgu.springmvc.entity.Lost;

@Mapper
public interface ILostDao extends IBaseDao<Integer, Lost> {
	public List findLostListByUserId(Integer userID);
	
	public List findLostsByName(String name);
}
