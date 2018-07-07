package com.ctgu.springmvc.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ctgu.springmvc.commons.IBaseDao;
import com.ctgu.springmvc.entity.Found;

@Mapper
public interface IFoundDao extends IBaseDao<Integer, Found>{
	public List findFoundListByUserId(Integer userID);
	
	public List findFoundsByName(String name);
}
