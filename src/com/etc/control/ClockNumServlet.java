package com.etc.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.etc.entity.Clock;
import com.etc.service.ClockService;
import com.etc.service.impl.ClockServiceImpl;

/**
 * Servlet implementation class ClockNumServlet
 */
@WebServlet("/ClockNumServlet")
public class ClockNumServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int userId = (int)session.getAttribute("LoginUser");
		ClockService sc = new ClockServiceImpl();
		Clock clock = new Clock();
		clock.setUserId(userId);
		int result = sc.AddClock(clock);
		PrintWriter out = response.getWriter();
		if(result==0) {
			out.print("flase");
		}else {
			out.print("true");
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
