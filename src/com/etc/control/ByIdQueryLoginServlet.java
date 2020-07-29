package com.etc.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.etc.entity.Login;
import com.etc.service.LoginService;
import com.etc.service.impl.LoginServiceImpl;

/**
 * Servlet implementation class DelLoginServlet
 */
@WebServlet("/ByIdQueryLoginServlet")
public class ByIdQueryLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ByIdQueryLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  request.setCharacterEncoding("utf-8");
		  response.setContentType("text/html;charset=utf-8");
		  
		  int flag=Integer.valueOf(request.getParameter("flag"));
		  LoginService ls=new LoginServiceImpl();
		  List<Login> li=ls.ListLogin();
		  HttpSession session=request.getSession();
		  session.setAttribute("ListUser", li);
		  //flag=0不进入for循环 只显示一条Id查询记录
		  if(flag==1) {
		  response.sendRedirect("/attendance/Boos_Login/UpdateUser.jsp?flag=9");
		  }else if(flag==2) {
			  response.sendRedirect("/attendance/Boos_Login/DelUser.jsp?flag=9");
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
