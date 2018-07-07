package com.ctgu.springmvc.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ctgu.springmvc.entity.User;
import com.ctgu.springmvc.service.FoundService;
import com.ctgu.springmvc.service.LostService;
import com.ctgu.springmvc.service.UserService;
import com.github.pagehelper.PageHelper;

@Controller
public class TestController {

	@Resource
	private UserService userService;
	@Resource
	private LostService lostService;
	@Resource
	private FoundService foundService;
	
	@RequestMapping("/index")
	public String index(ModelMap map) {
		List lostList = null;
		List foundList = null;
		try {
			PageHelper.startPage(1, 5);
			lostList = lostService.findAllLost();
			PageHelper.startPage(1, 5);
			foundList = foundService.findAllFounds();
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.addAttribute("lostList", lostList);
		map.addAttribute("foundList", foundList);
		return "index";
	}
	
	@RequestMapping("/toLogin")
	public String toLoginPage()	{
		return "login";
	}
	
	@RequestMapping("/getloginFrame")
	public String getloginFrame()	{
		return "loginFrame";
	}
	
	@RequestMapping("/toRegist")
	public String toRegistPage() {
		return "register";
	}
	
	@RequestMapping("/register")
	public String register(User user, HttpServletRequest request) {
		try {
			userService.insertUser(user);
			request.getSession().setAttribute("loginUser", null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:toLogin";
	}
	
	@RequestMapping("/toPerson")
	public String toPersonPage(ModelMap map, HttpServletRequest request,@RequestParam("currentpage") Integer currentpage) throws Exception	{
		List losts = null;
		List founds = null;
		User u = null;
		/*Page page1 = new Page();
		Page page2 = new Page();*/
		u = (User)(request.getSession().getAttribute("loginUser"));
			
		/*List l =  lostService.findLostListByUserId(u.getUserID());
		page1.setTotalRecord(l.size());
		page1.setTotalPage(page1.getTotalRecord());
		page1.setCurrentPage(currentpage);
		System.out.println(page1);
			
		List f=  foundService.findFoundListByUserId(u.getUserID());
		page2.setTotalRecord(f.size());
		page2.setTotalPage(page1.getTotalRecord());
		page2.setCurrentPage(currentpage);
		System.out.println(page2);	*/
		
		//PageHelper.startPage(currentpage,5);
		losts = lostService.findLostListByUserId(u.getUserID());
		founds = foundService.findFoundListByUserId(u.getUserID());//!!!
			System.out.println(losts);
			System.out.println(founds);

		//map.addAttribute("page2",page2);
		//map.addAttribute("page1",page1);
		map.addAttribute("losts", losts);
		map.addAttribute("founds", founds);

		return "personalManage";
	}
	
	@RequestMapping("/findByName")
	@ResponseBody
	public boolean checkName(@RequestParam("username")String username) throws Exception
	{
		User u=null;
		u=userService.findUserByName(username);
		//判定
		if(u==null) {
			return true;//不存在可以使用
		}
		else{
			return false;//被占用
		}
	}
	@RequestMapping("/findByEmail")
	@ResponseBody
	public boolean checkEmail(@RequestParam("email")String email) throws Exception
	{
		User u=null;
		u=userService.findUserByEmail(email);
		//判定
		if(u==null)
			return true;//不存在可以使用
		else
			return false;//被占用
	}
	
	@RequestMapping("/login")
	public String login(ModelMap map, HttpServletRequest request) {
		String page="login";
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		try {
			User u = userService.checkLogin(username, password);
//			System.out.println(u);
			if (u != null) {
				//登陆的用户放进session
				request.getSession().setAttribute("loginUser", u);
				page = "redirect:/index";
			}
			else {
				page = "redirect:/login";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return page;
	}
	
	
	@RequestMapping("/logout")
	public String logout(ModelMap map, HttpServletRequest request) {
		//登陆的用户放进session
		request.getSession().removeAttribute("loginUser");;
		return "redirect:/index";
	}
	
	@RequestMapping("/updateUser")
	@ResponseBody
	public boolean updateUser(HttpServletRequest request, User user) {
		try {
			userService.updateUser(user);
			request.getSession().setAttribute("loginUser", user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//更新session
		return true;
	}
	
	@RequestMapping("/findLostAndFoundByName")
	public String findLostAndFoundByName(HttpServletRequest request, ModelMap map) {
		String name = request.getParameter("name");
//		System.out.println(name);
		List lostList = lostService.findLostByName(name);
		List foundList = foundService.findFoundByName(name);
//		System.out.println(foundList);
		map.addAttribute("lostList", lostList);
		map.addAttribute("foundList", foundList);
		return "/index";
	}
	
}
