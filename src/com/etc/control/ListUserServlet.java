package com.etc.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.etc.entity.User;
import com.etc.service.UserService;
import com.etc.service.impl.UserServiceImpl;
/**
 * 列出部分员工
 * @author yby
 *
 */
@WebServlet("/ListUserServlet")
public class ListUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		int flag = Integer.parseInt(request.getParameter("flag"));
		int userId = 0;
		
		if(flag == 2 || flag == 0) {
			userId = Integer.parseInt(request.getParameter("userId"));
		}else {
			userId = (int)session.getAttribute("LoginUser");
		}
		
		
		flag = Integer.valueOf(request.getParameter("flag"));//转向时判断是往哪个页面
		
		UserService us = new UserServiceImpl();
		List<User> list = us.ListUser(userId);
		
		session.setAttribute("ListUser", list);
		
		if(flag==1) {
			response.sendRedirect("/attendance/Emp_Login/AllEmpQuery.jsp");
		}else if(flag==0) {
			response.sendRedirect("/attendance/Boos_Login/DelEmp.jsp?flag=1");
		}else if(flag==2) {
			response.sendRedirect("/attendance/Boos_Login/UpateEmp.jsp");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
