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

import com.etc.dao.ClockMessDao;
import com.etc.dao.impl.ClockMessDaoImpl;
import com.etc.entity.ClockMess;
@WebServlet("/GetAllClockMessServlet")
public class GetAllClockMessServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		ClockMessDao cmd = new ClockMessDaoImpl();
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		//调用方法
		List<ClockMess> clockList = cmd.getAllClockMess();
		//存入session
		session.setAttribute("clockList", clockList);
		//判断后进行跳转
		//如果list为空,说明没有需要处理的数据
		if(clockList == null) {
			out.print("没有需要处理的数据");
			return;
		}
		
		//获取method进行判断
		String method = request.getParameter("method");
		if("query".equals(method)) {
			response.sendRedirect("/attendance/Boos_Login/QueryPunch.jsp");
		}else if("update".equals(method)) {
			response.sendRedirect("/attendance/Boos_Login/UpdatePunch.jsp");
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
