package com.etc.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.etc.dao.ClockMessDao;
import com.etc.dao.impl.ClockMessDaoImpl;
import com.etc.entity.ClockMess;

@WebServlet("/UpdateClockMessServlet")
public class UpdateClockMessServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		ClockMessDao cmd = new ClockMessDaoImpl();
		
		//取值
		int id = Integer.parseInt(request.getParameter("id"));
		String sOut = request.getParameter("signOut");
		//时间格式转化
		Timestamp signOut = Timestamp.valueOf(sOut);
		//调用方法
		int result = cmd.updateClockMess(new ClockMess(id,0,signOut));
		
		if(result > 0) {
			System.out.print("成功!");
		}else {
			System.out.print("失败!");
		}
		//跳转
		response.sendRedirect("/attendance/Boos_Login/UpdatePunch.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
