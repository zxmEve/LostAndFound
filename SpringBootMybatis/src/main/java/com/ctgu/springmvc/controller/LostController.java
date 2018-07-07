package com.ctgu.springmvc.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.ctgu.springmvc.commons.BaseController;
import com.ctgu.springmvc.entity.Lost;
import com.ctgu.springmvc.entity.Page;
import com.ctgu.springmvc.entity.User;
import com.ctgu.springmvc.service.LostService;
import com.github.pagehelper.PageHelper;

@Controller
public class LostController extends BaseController{
	
	@Resource 
	private LostService lservice;
	
	/**
	 * 跳转添加物品页面
	 * @return
	 */
	@RequestMapping("/tolostPub")
	public String toAddLost(HttpServletRequest request)
	{		
		//没有登录先登录
		if(request.getSession().getAttribute("loginUser") == null) {
			return "login";
		}
		return "lostPub";
	}
	
	/*
	 * 添加lost信息
	 */
	@RequestMapping("/addLost")
	public String addLostInfo(Lost lost, HttpServletRequest request)
	{
		User u = (User)(request.getSession().getAttribute("loginUser"));
		lost.setLostType(request.getParameter("lostType"));
		lost.setUserId(u.getUserID());
		
		String file = (String) request.getSession().getAttribute("fileName");
		lost.setImage(file);
		request.getSession().removeAttribute("fileName");
		
		try {
			lservice.insertLost(lost);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/index";
	}
	
	@RequestMapping("/toLostDetail")
	public String toLost(ModelMap map, @RequestParam("id") Integer lostId, HttpServletRequest request)
	{	
		Lost lost = null;
		try {
			lost = lservice.findLostById(lostId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.addAttribute("lost", lost);
		return "lostDetail";
	}
	
	@RequestMapping("/getLostInfo")
	public String getLostInfo(Lost lost, ModelMap map)
	{
		map.addAttribute("lostInfo", lost);
		return "lostInfo";
	}
	
	/**
	 * 跳转更新物品页面
	 * @return
	 */
	@RequestMapping("/tolostUpdate")
	public String toUpdateLost(ModelMap map,@RequestParam("id")Integer id)
	{	
		Lost lost = null;
		try {
			lost = lservice.findLostById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.addAttribute("lost", lost);
		return "lostUpdate";
		
	}
	
	/**
	 * 修改失物信息，或者更改状态
	 * @return 跳转xx页面
	 */
	@RequestMapping("/updateLost")
	public String updateLostInfo(Lost lost, HttpServletRequest request)
	{
		User u = (User)(request.getSession().getAttribute("loginUser"));
		lost.setUserId(u.getUserID());
		lost.setLostType(request.getParameter("lostType"));
		try {
			boolean flag = lservice.updateLost(lost);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/toLostDetail?id=" + lost.getLostId();
	}
	
	@RequestMapping("/toLostList")
	public String toLostlist(ModelMap map,@RequestParam("currentpage") Integer currentpage) throws Exception
	{	
		Page page = new Page();	
		List l =  lservice.findAllLost();
		page.setTotalRecord(l.size());
		PageHelper.startPage(currentpage,5);		
		List lost =  lservice.findAllLost();
		page.setTotalPage(page.getTotalRecord());
		page.setCurrentPage(currentpage);
		map.addAttribute("page",page);
		map.addAttribute("losts", lost);
		return "lostList";
	}

	/*
	 * 根据userID得到lostList
	 */
/*	@RequestMapping("/findLostListByUserId")
	@ResponseBody
	public String getLostListByUserId(@RequestParam Integer userID, ModelMap map, HttpServletRequest request, HttpServletResponse response) {
//		List<Lost> lostList = lservice.findLostListByUserId(userID);
//		try {
//			ResponseUtil.writeToJSON(response,(Object)lostList);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		map.addAttribute("losts", lostList);
//		System.out.println(lostList);
		return "personalManage";
	}*/
	
	/*	@RequestMapping("/deleteLost")
	public String delLostInfo(@RequestParam("id") int id)
	{
		try {
			lservice.deleteLost(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}*/
}
