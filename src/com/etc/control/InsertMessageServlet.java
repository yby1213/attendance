package com.etc.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.etc.dao.MessageDao;
import com.etc.dao.impl.MessageDaoImpl;
import com.etc.entity.Message;

@WebServlet("/InsertMessageServlet")
public class InsertMessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		MessageDao md = new MessageDaoImpl();
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		
		//取值
		int userId = (int) session.getAttribute("LoginUser");
		String userMessage = request.getParameter("getMessage");
		String select = request.getParameter("select");

		//调用方法
		int result = md.insertMessage(new Message(0,userId,userMessage,null,null,select));
		if(result > 0) {
			System.out.println("1");
		}else {
			System.out.println("2");
		}
		//跳转
		response.sendRedirect("/attendance/GetEmpMessageServlet");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
