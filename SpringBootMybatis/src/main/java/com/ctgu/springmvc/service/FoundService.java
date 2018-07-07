package com.ctgu.springmvc.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ctgu.springmvc.dao.IFoundDao;
import com.ctgu.springmvc.entity.Found;

@Service
public class FoundService {
	
	@Resource
	public IFoundDao foundDao;
	
	public boolean insertFound(Found vo) throws Exception
	{
		boolean flag = foundDao.insert(vo);
		return flag;
	}
	
	public boolean deleteFound(Integer id) throws Exception
	{
		boolean flag = false;
		if(foundDao.findByKey(id)!=null)
		{
			flag = foundDao.delete(id);
		}
		return flag;
	}
	
	public boolean updateFound(Found found) throws Exception
	{
		boolean flag = foundDao.update(found);
		return flag;
	}
	
	public Found findFoundById(Integer id) throws Exception
	{
		Found found = null;
		found = foundDao.findByKey(id);
		return found;
	}
	
	public List<Found> findAllFounds() throws Exception
	{
		List<Found> list = null;
		list = foundDao.findAll();
		
		return list;
	}

	public void add(Found found) {
		
	}
	public boolean updatePic(Found found) throws Exception
	{
		boolean flag = foundDao.update(found);
		return flag;
	}
	
	public List findFoundListByUserId(Integer userID) {
		//!!!
		return foundDao.findFoundListByUserId(userID);
	}
	
	public List findFoundByName(String name) {
		name = "%" + name + "%";
		return foundDao.findFoundsByName(name);
	}
}
