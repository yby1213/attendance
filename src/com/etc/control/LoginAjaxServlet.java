package com.etc.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.etc.entity.Login;
import com.etc.entity.User;
import com.etc.service.LoginService;
import com.etc.service.UserService;
import com.etc.service.impl.LoginServiceImpl;
import com.etc.service.impl.UserServiceImpl;

/**
 * Servlet implementation class LoginAjaxServlet
 */
@WebServlet("/LoginAjaxServlet")
public class LoginAjaxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginAjaxServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		 response.setContentType("text/html;charset=utf-8");
		 response.setCharacterEncoding("UTF-8");
		 PrintWriter out=response.getWriter();
		 int userId =Integer.parseInt( request.getParameter("userId"));
		 LoginService ls=new LoginServiceImpl();
		 UserService us=new UserServiceImpl();
		 List<Login> lt=ls.GetLoginById(userId);
		 List<User> list=us.ListUser(userId);
		 
		 //查找user表
		 if(list==null) {
			 out.print("noExist");
		 }else {
			 if(lt==null) {
				 out.print("true");
			 }else {
				 out.print("false");
			 }
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
