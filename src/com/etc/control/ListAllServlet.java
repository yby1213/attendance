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
 * 列出所有的员工
 * @author yby
 *
 */
@WebServlet("/ListAllServlet")
public class ListAllServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		//取值
		int flag = 0;
		String sFlag = request.getParameter("flag");
		//如果取值为空，则默认flag为1，接下来就跳转至查询全部页面
		if("".equals(sFlag)) {
			flag = 1;
		}else {
			flag = Integer.valueOf(sFlag);
		}
		 
		//调用函数
		UserService us = new UserServiceImpl();
		List<User> list = us.AllUser();
		//存入域中
		session.setAttribute("ListAll", list);
		//判断flag进行跳转
		if(flag==1) {
			//跳至查询全部
			response.sendRedirect("/attendance/Boos_Login/AllEmpQuery.jsp");
		}else if(flag==2) {
			//跳至删除页面
			response.sendRedirect("/attendance/Boos_Login/DelEmp.jsp?flag=4");
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
