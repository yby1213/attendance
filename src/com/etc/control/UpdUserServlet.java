package com.etc.control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.etc.entity.User;
import com.etc.service.UserService;
import com.etc.service.impl.UserServiceImpl;
/**
 * 更新数值
 * @author yby
 *
 */
@WebServlet("/UpdUserServlet")
public class UpdUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		int userId = Integer.parseInt(request.getParameter("userId"));
		int a=0;
		String userPost = request.getParameter("userpost");
		String userClock2 = request.getParameter("userClock2");
		
		if(userPost.equals("")) {
			userPost = request.getParameter("userPost2");
		}
		int userSal = 0;
		String uc = request.getParameter("userclock");
		if(uc.equals("")) {
			userSal = Integer.parseInt(userClock2);
		}else {
			userSal = Integer.parseInt(uc);//获取更改的工资
		}
		
		int flag = 0;
		UserService us = new UserServiceImpl();
		User user = new User();
		user.setUserId(userId);
		user.setUserPost(userPost);
		user.setUserSal(userSal);
		int result = us.UpdNum(user);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
