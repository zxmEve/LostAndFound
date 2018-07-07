package com.ctgu.springmvc.commons;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.context.request.WebRequest;

public class BaseController {

	@InitBinder  
	public void initBinder(WebDataBinder binder) {  
		    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");  
		    dateFormat.setLenient(false);  
		    binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));  
	}

	@InitBinder
	public void initBinder(ServletRequestDataBinder binder,WebRequest request) {
		//转换日期格式
	    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	    //注册自定义的编辑器
	    binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));        
	}
}
