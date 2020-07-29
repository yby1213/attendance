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

import com.alibaba.fastjson.JSON;
import com.etc.dao.ClockMessDao;
import com.etc.dao.impl.ClockMessDaoImpl;
import com.etc.entity.ClockMess;
import com.etc.until.PageData;


@WebServlet("/PageServlet")
public class PageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
				PrintWriter out = response.getWriter();
				
				//获取当前页码
				int pageIndex = -1;
				
				if(request.getParameter("pageIndex") == null || request.getParameter("pageIndex").equals("")) {
					pageIndex = 1;
				}else {
					pageIndex = Integer.parseInt(request.getParameter("pageIndex"));
				}
				
				//页面容量
				int pageSize = 10;
				
				
				//开始存入PageData类中
				PageData<ClockMess> page = new PageData<ClockMess>();
				page.setPageSize(pageSize);	//存每页的行数
				page.setPage(pageIndex);	//存页码
				
				ClockMessDao nsi = new ClockMessDaoImpl();
				//总记录数
				int count = nsi.countAll();
				page.setTotal(count);		//存总数
				List<ClockMess> list = nsi.page(pageIndex, pageSize);
				page.setData(list);			//存数据
				//将类存入session中
				HttpSession session = request.getSession();
				session.setAttribute("pageListNews", page);
				
				out.print(JSON.toJSONString(page));
				
				
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
