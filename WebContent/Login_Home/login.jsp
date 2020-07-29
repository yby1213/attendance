<%@ page import="com.etc.entity.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!--
Author: W3layouts
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<html>
<head>
<title>登录界面</title>
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
<!-- Bootstrap Core JavaScript -->
<script src="http://www.jq22.com/jquery/bootstrap-3.3.4.js"></script>



<!--background-->
<meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="css/style2.css" />
  <script type='text/javascript' src='js/jquery-1.11.1.min.js'></script>
  <script type='text/javascript' src='js/jquery.particleground.min.js'></script>
  <script type='text/javascript' src='js/demo.js'></script>
  
</head>
<%
		if(session.getAttribute("LoginUser") == null){
			Login login=(Login) session.getAttribute("LoginUser");
		}
		
%>
<body>
	<!--两层为背景样式-->
	<div id="particles">
		<div class="intro">

	
		  <div class="login-logo">
		    <img src="images/logo.png" alt=""/>
		  </div>
		  <h2 class="form-heading">登录界面</h2>
		  <div class="app-cam">
			  <form action="/attendance/loginServlet">
				<input type="text" class="text" id="loginId" name="loginId" placeholder="请输入账号"  >
				<input type="password" id="loginPwd" name="loginPwd" placeholder="请输入密码" >
				<div class="submit"><input type="submit"  value="登录" ></div>
				<ul class="new">
					<li class="new_left"><p><a href="#">忘记密码?</a></p></li>
					<li class="new_right"><p class="sign">首次登录?<a href="register.jsp"> 注册</a></p></li>
					<div class="clearfix"></div>
				</ul>
			</form>
		  </div>
		   <div class="copy_layout login">
		      <p>Copyright © 2015 Modern. All Rights Reserved | Design by  </p>
		   </div>
		   
		   
		</div>
	</div>
</body>

<%
 session.removeAttribute("LoginUser");
%>
</html>
