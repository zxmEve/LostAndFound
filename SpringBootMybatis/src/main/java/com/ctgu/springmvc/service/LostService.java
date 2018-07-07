package com.ctgu.springmvc.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ctgu.springmvc.dao.ILostDao;
import com.ctgu.springmvc.entity.Lost;
import com.ctgu.springmvc.entity.Page;
import com.github.pagehelper.PageHelper;

@Service
public class LostService {

	@Resource
	public ILostDao lostDao;
	
	public boolean insertLost(Lost vo) throws Exception
	{
		boolean flag = lostDao.insert(vo);
		return flag;
	}
	
	public boolean deleteLost(Integer id) throws Exception
	{
		boolean flag = false;
		if(lostDao.findByKey(id)!=null)
		{
			flag = lostDao.delete(id);
		}
		return flag;
	}
	
	public boolean updateLost(Lost lost) throws Exception
	{
		boolean flag = lostDao.update(lost);
		return flag;
	}
	
	public Lost findLostById(Integer id) throws Exception
	{
		Lost lost = null;
		lost = lostDao.findByKey(id);
		return lost;
	}
	public List<Lost> findAllLost() throws Exception
	{
		List<Lost> list = lostDao.findAll();
		return list;
	}
	
	/*
	 * 根据用户id得到lostList
	 */
	public List findLostListByUserId(Integer userID) {
		return lostDao.findLostListByUserId(userID);
	}
	
	public List findLostByName(String name) {
		name = "%" + name + "%";
		//System.out.println(lostDao.findLostsByName(name).size());
		return lostDao.findLostsByName(name);
	}
	
}
