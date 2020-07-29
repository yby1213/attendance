package com.etc.control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.etc.service.UserService;
import com.etc.service.impl.UserServiceImpl;
/**
 * 删除员工
 * @author yby
 *
 */
@WebServlet("/DelUserServlet")
public class DelUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		int userId = Integer.valueOf(request.getParameter("userId"));
		int a=0;
		UserService us = new UserServiceImpl();
		int result = us.DelUser(userId);
		response.sendRedirect("/attendance/Boos_Login/AllEmpQuery.jsp");
		
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
