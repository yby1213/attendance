package com.etc.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.etc.dao.MessageDao;
import com.etc.dao.impl.MessageDaoImpl;
import com.etc.entity.Message;

@WebServlet("/GetEmpMessageServlet")
public class GetEmpMessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		MessageDao md = new MessageDaoImpl();
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		
		//取值
		int userId = 0;
		if(request.getParameter("flag") == null) {
			userId = (int)session.getAttribute("LoginUser");
		}else {
			userId = Integer.parseInt(request.getParameter("userId"));
		}
		
		//调用方法
		List<Message> empMessage = md.getAllMessage(userId);
		//存入session
		session.setAttribute("empMessage", empMessage);
		//判断后进行跳转
		//如果list为空,说明没有需要处理的数据
		if(empMessage == null) {
			out.print("没有需要处理的数据");
			return;
		}
		
		response.sendRedirect("/attendance/Emp_Login/Mes.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
