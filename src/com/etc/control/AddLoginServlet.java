package com.etc.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.etc.dao.impl.UserDaoImpl;
import com.etc.entity.Login;
import com.etc.entity.User;
import com.etc.service.LoginService;
import com.etc.service.impl.LoginServiceImpl;


@WebServlet("/AddLoginServlet")
public class AddLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 //添加注册用户 
		 PrintWriter out=response.getWriter();
		 //取值
		 int userId =Integer.parseInt(request.getParameter("userId"));
		 String loginId =request.getParameter("loginId");
		 String loginPwd = request.getParameter("loginPwd");
		 //存入对象
		 Login login=new Login();
		 login.setUserId(userId);
		 login.setLoginId(loginId);
		 login.setLoginPwd(loginPwd);
		 
		 LoginService ls=new LoginServiceImpl();
		 int result = ls.AddLogin(login);
		 if(result>=0) {
		 response.sendRedirect("/attendance/Login_Home/login.jsp");
		 }else {
			 response.sendRedirect("/attendance/Login_Home/register.jsp");
		 }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
