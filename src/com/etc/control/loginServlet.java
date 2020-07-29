package com.etc.control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.etc.entity.Login;
import com.etc.service.LoginService;
import com.etc.service.impl.LoginServiceImpl;



@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		  //取值
		  String loginId =request.getParameter("loginId");
		  String loginPwd = request.getParameter("loginPwd");
		  //调用方法
		  LoginService ls = new LoginServiceImpl();
		  Login login = ls.loginUser(loginId,loginPwd);
		  //判断
		  if(login != null) {
			  //判断是否是BOSS，是的话跳转到BOSS页面
		   if((login.getLoginPwd().equals("admin"))&&(login.getLoginId().equals("admin"))) {
			    response.sendRedirect("Boos_Login/index.jsp");
			   }else {
				//获取userId，存入session中
				session.setAttribute("LoginUser", login.getUserId());
			    response.sendRedirect("Emp_Login/index.jsp");
			   }
		  }else {
			  response.sendRedirect("Login_Home/login.jsp");
		  }
		 }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
