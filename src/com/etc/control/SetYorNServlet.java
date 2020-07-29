package com.etc.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.etc.dao.MessageDao;
import com.etc.dao.impl.MessageDaoImpl;

@WebServlet("/SetYorNServlet")
public class SetYorNServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		//取值
		int id = Integer.parseInt(request.getParameter("id"));
		String fb= request.getParameter("feedBack");
		//判断feedBack转为同意/不同意(String没学好)
		String feedBack = "";
		if("true".equals(fb)) {
			feedBack = "成功";
		}else {
			feedBack = "失败";
		}
		
		//调用方法
		MessageDao md = new MessageDaoImpl();
		int result = md.setYorN(id, feedBack);
		//内部判断
		if(result > 0) {
			System.out.println("1");
		}else {
			System.out.println("2");
		}
		//跳转
		response.sendRedirect("/attendance/GetMessageServlet?method=boss");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
