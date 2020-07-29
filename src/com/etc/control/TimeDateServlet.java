package com.etc.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.etc.entity.Message;
import com.etc.service.MessageService;
import com.etc.service.impl.MessageServiceImpl;

/**
 * Servlet implementation class TimeDateServlet
 */
@WebServlet("/TimeDateServlet")
public class TimeDateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TimeDateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		
		MessageService ms=new MessageServiceImpl();
		List<Message> list=ms.getAllMessage(6);//根据id查询登录员工的全部特殊信息
/*		for(int i=0;i<list.size();i++) {
			//循环遍历获得数据
			Timestamp time=list.get(i).getTime();
			String kind=list.get(i).getKind();
			json.put("time", time);
			json.put("kind", kind);
			out.print(json);
		}*/
//		String jsonString = JSON.toJSONString(list);
/*		for(int i=0;i<list.size();i++) {
			Message arr=list.get(i).getTime();
		}*/
		out.print(JSON.toJSONString(list));
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
