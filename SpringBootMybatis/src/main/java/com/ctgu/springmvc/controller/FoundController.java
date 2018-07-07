package com.ctgu.springmvc.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ctgu.springmvc.commons.BaseController;
import com.ctgu.springmvc.entity.Found;
import com.ctgu.springmvc.entity.Page;
import com.ctgu.springmvc.entity.User;
import com.ctgu.springmvc.service.FoundService;
import com.github.pagehelper.PageHelper;

@Controller
public class FoundController extends BaseController{
	@Resource 
	private FoundService fservice;
	
	/**
	 * ��ת�����Ʒҳ��
	 * @return
	 */
	@RequestMapping("/tofoundPub")
	public String toAddFound(HttpServletRequest request)
	{		
		//û�е�¼�ȵ�¼
		if(request.getSession().getAttribute("loginUser") == null) {
			return "login";
		}
		return "foundPub";
	}
	
	@RequestMapping("/toFoundDetail")
	public String toFound(ModelMap map,@RequestParam("id")Integer foundId,HttpServletRequest request)
	{	
		Found found = null;
		try {
			found = fservice.findFoundById(foundId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.addAttribute("found", found);
		return "foundDetail";
	}
	/**
	 * ���ʧ��������Ϣ�����ݿ�
	 * @return ��ת��XXҳ��
	 */
	
	@RequestMapping("/addFound")
	public String addFoundInfo(Found found, HttpServletRequest request)
	{
		User u = (User)(request.getSession().getAttribute("loginUser"));
		found.setFoundType(request.getParameter("foundType"));
		found.setUserId(u.getUserID());
		
		String file = (String) request.getSession().getAttribute("fileName");
		found.setImage(file);
		request.getSession().removeAttribute("fileName");
		
		try {
			fservice.insertFound(found);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/index";
	}
	
	@RequestMapping("/getFoundInfo")
	@ResponseBody
	public String getFoundInfo(Found found, ModelMap map)
	{
		map.addAttribute("foundInfo", found);
		return "foundInfo";
	}
	
	/**
	 * ��ת������Ʒҳ��
	 * @return
	 */
	@RequestMapping("/tofoundUpdate")
	public String toUpdateFound(ModelMap map,@RequestParam("id")Integer id)
	{	
		Found found = null;
		try {
			found = fservice.findFoundById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.addAttribute("found",found);
		return "foundUpdate";
	}
	
	/**
	 * �޸�������Ϣ�����߸���״̬
	 * @return ��תxxҳ��
	 */
	@RequestMapping("/updateFound")
	public String updateFound(Found found, HttpServletRequest request)
	{
		User u = (User)(request.getSession().getAttribute("loginUser"));
		found.setUserId(u.getUserID());
		found.setFoundType(request.getParameter("foundType"));
		try {
			fservice.updateFound(found);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/toFoundDetail?id=" + found.getFoundId();
	}
	
	@RequestMapping("/toFoundList")
	public String toFoundlist(ModelMap map,@RequestParam("currentpage") Integer currentpage) throws Exception
	{	
		Page page = new Page();	
		List l =  fservice.findAllFounds();
		page.setTotalRecord(l.size());
		PageHelper.startPage(currentpage,5);		
		List found =  fservice.findAllFounds();
		page.setTotalPage(page.getTotalRecord());
		page.setCurrentPage(currentpage);
		map.addAttribute("page",page);
		map.addAttribute("founds", found);
		System.out.println(found);
		return "foundList";
	}

	/*	@RequestMapping("/deleteFound")
	public String delFoundInfo(@RequestParam("id") int id)
	{
		try {
			fservice.deleteFound(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}*/
	
/*	@RequestMapping("/findFoundListByUserId")
	@ResponseBody
	public String getFoundListByUserId(@RequestParam Integer userID, ModelMap map, HttpServletRequest request, HttpServletResponse response) {
		System.out.println("getFoundListByUserId");
		List<Found> foundList = fservice.findFoundListByUserId(userID);
//		try {
//			ResponseUtil.writeToJSON(response,(Object)lostList);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		map.addAttribute("founds", foundList);
		System.out.println(foundList);
		return "personalManage";
	}*/
}
