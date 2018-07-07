package com.ctgu.springmvc.util;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

public class ResponseUtil {

	public static void writeToJSON(HttpServletResponse response, Object o)throws Exception{
//      response.setCharacterEncoding("text/html;charset=utf-8");
      PrintWriter pw = response.getWriter();

      //ֻ��net.sf.json�е�JSONObject�������fromObject()�������
     JSONArray jsonObject = JSONArray.fromObject(o);

      //System.out.println(o.toString());
      pw.print(jsonObject);
      pw.flush();
      pw.close();
  }
}
