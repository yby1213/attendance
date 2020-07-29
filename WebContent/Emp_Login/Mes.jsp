<%@page import="com.etc.entity.Message"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!--
Author: W3layouts
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<html>
<head>
<title>特殊信息界面</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Modern Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
 <!-- Bootstrap Core CSS -->
<link rel="stylesheet" type="text/css" href="http://www.jq22.com/jquery/bootstrap-3.3.4.css">
<!-- Custom CSS -->
<link href="css/style.css" rel='stylesheet' type='text/css' />
<link rel="stylesheet" type="text/css" href="http://www.jq22.com/jquery/font-awesome.4.6.0.css"> 
<!-- jQuery -->
<script src="http://www.jq22.com/jquery/jquery-1.10.2.js"></script>

<!---//webfonts--->  
</head>
<body>
<div id="wrapper">
     <!-- Navigation -->
        <nav class="top1 navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="index.jsp">考勤打卡系统</a>
            </div>
            <!-- /.navbar-header -->
            <ul class="nav navbar-nav navbar-right">
			    <li class="dropdown">
	        		<a href="#" class="dropdown-toggle avatar" data-toggle="dropdown"><img src="images/1.png" alt=""/></a>
	        		<ul class="dropdown-menu">
						<li class="m_2"><a href="/attendance/Login_Home/login.jsp"><i class="fa fa-lock"></i> Logout</a></li>	
	        		</ul>
	      		</li>
			</ul>
			<form class="navbar-form navbar-right">
            </form>
            <div class="navbar-default sidebar" role="navigation">
                <div class="sidebar-nav navbar-collapse">
                    <ul class="nav" id="side-menu">
                        <li>
                            <a href="index.jsp"><i class="fa fa-dashboard fa-fw nav_icon"></i>首页</a>
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-laptop nav_icon"></i>员工信息查询<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a href="AllEmpQuery.jsp">全部员工查询</a>
                                </li>
                            </ul>
                            <!-- /.nav-second-level -->
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-indent nav_icon"></i>员工管理<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a href="DelEmp.jsp">开除员工</a>
                                </li>
                                <li>
                                    <a href="IntEmp.jsp">添加员工</a>
                                </li>
                                <li>
                                    <a href="UpateEmp.jsp">更改员工信息</a>
                                </li>
                            </ul>
                            <!-- /.nav-second-level -->
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-envelope nav_icon"></i>特殊信息<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a href="Mes.jsp">信息确认及反馈</a>
                                </li>
                                <li>
                                    <a href="BossMes.jsp">特殊信息提交</a>
                                </li>
                            </ul>
                            <!-- /.nav-second-level -->
                        </li>
                         <li>
                            <a href="#"><i class="fa fa-check-square-o nav_icon"></i>打卡信息<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a href="QueryPunch.jsp">打卡信息查询</a>
                                </li>
                                <li>
                                    <a href="UpdatePunch.jsp">打卡信息更改</a>
                                </li>
                            </ul>
                            <!-- /.nav-second-level -->
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-table nav_icon"></i>用户表<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a href="QueryUser.jsp">查询用户信息</a>
                                </li>
                                <li>
                                    <a href="UpdateUser.jsp">修改用户信息</a>
                                </li>
                                <li>
                                    <a href="DelUser.jsp">删除用户信息</a>
                                </li>
                            </ul>
                            <!-- /.nav-second-level -->
                        </li>
                            </ul>
                            <!-- /.nav-second-level -->
                        </li>
                    </ul>
                </div>
                <!-- /.sidebar-collapse -->
            </div>
            <!-- /.navbar-static-side -->
        </nav>
        <div id="page-wrapper">
        <div class="graphs">
	   <div class="md">
		 <h3>特殊信息</h3>
		 
		<div class="col-md-12 span_3">
			  <div class="bs-example1" data-example-id="contextual-table">
			    <table class="table table-hover">
			      <thead>
			        <tr>
			          <th>信息编号</th>
			          <th>员工编号</th>
			          <th>审核</th>
			          <th>提交时间</th>
			          <th>请假类型</th>
			          <th>其他信息提交</th>
			        </tr>
			      </thead>
			      <tbody>
			      <%
			      		List<Message> empMessage = (List<Message>)session.getAttribute("empMessage");
			      		if(empMessage == null){
			      			response.sendRedirect("/attendance/GetEmpMessageServlet?method=emp");
			      			return;
			      		}
			      %>
			      <c:forEach items="${sessionScope.empMessage }" var="list" varStatus="vs">
				        <tr>
				          <td>${list.id }</td>
				          <td>${list.userId }</td>
				          <td>${list.feedBack }</td>
				          <td>${list.time }</td>
				          <td>${list.kind }</td>
				          <td><a href="/attendance/Emp_Login/BossMes.jsp?feedback=${list.feedBack }&message=${list.userMessage }">点击跳转</a></td>
				        </tr>
			       </c:forEach>
			      </tbody>
			    </table>
			   </div>
		   </div>
        <div class="copy_layout">
         <p>Copyright © 2015 Modern. All Rights Reserved | Design by  </p>
        </div>					
       </div>
      </div>
      <!-- /#page-wrapper -->
   </div>
    <!-- /#wrapper -->
    <!-- Nav CSS -->
<link href="css/custom.css" rel="stylesheet">
<!-- Metis Menu Plugin JavaScript -->
<script src="js/metisMenu.min.js"></script>
<script src="js/custom.js"></script>
<!-- Bootstrap Core JavaScript -->
<script src="http://www.jq22.com/jquery/bootstrap-3.3.4.js"></script>
<%
	session.removeAttribute("empMessage");
%>
</body>
</html>
