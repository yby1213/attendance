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
<title>注册界面</title>
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
<script type="text/javascript" >
/* 使用Ajax验证用户编号是否存在 */
$(function(){
	$("#userId").blur(function(){
		var userId = $("#userId").val();
		if(userId==""){
		$("#userIdcom").html("不能为空").css("color","red");
		$("#buten").attr("disabled", true);
		}else{
				$.ajax({
					url : "../LoginAjaxServlet",
					type : "get",
					data:{"userId":userId},
					dataType : "text",
					success : function(data) {
					 if(data=="true"){
						 $("#userIdcom").html("可以注册").css("color","green");
						 $("#buten").removeAttr("disabled");
					 }else if(data == "false"){
						 $("#userIdcom").html("该编号已被注册").css("color","red");
						 $("#buten").attr("disabled", true);
					 }else{
						 $("#userIdcom").html("没有该员工").css("color","red");
					 }
					},
					error : function() {
					alert("用户名验证拾出现错误，请联系管理员！");
					}
					});
			}
	})
	$("#loginId").blur(function(){
		var loginId=$("#loginId").val();
		if(loginId==""){
			$("#loginIdcom").html("不能为空").css("color","red");
			$("#buten").attr("disabled", true);
			}else{
					$.ajax({
						url : "../ComLoginIdServlet",
						type : "get",
						data:{"loginId":loginId},
						dataType : "text",
						success : function(data) {
						 if(data=="true"){
							 $("#loginIdcom").html("可以注册").css("color","green");
							 $("#buten").removeAttr("disabled");
						 }else{
							 $("#loginIdcom").html("该账号已被注册").css("color","red");
							 $("#buten").attr("disabled", true);
						 }
						},
						error : function() {
						alert("用户名验证拾出现错误，请联系管理员！");
						}
						})
			}
	})
	$("#loginPwd").blur(function(){
		var loginPwd=$("#loginPwd").val();
		if(loginPwd==""){
			$("#loginPwdcom").html("不能为空").css("color","red");
			$("#buten").attr("disabled", true);
			}else{
				$("#loginPwdcom").html("可以注册").css("color","green");
				$("#buten").removeAttr("disabled");
			}
	})
	$("#loginRe").blur(function(){
		var loginPwd=$("#loginPwd").val();
		var loginRe=$("#loginRe").val();
		if(loginRe==""){
			$("#loginRecom").html("不能为空").css("color","red");
			$("#buten").attr("disabled", true);
			}else{
				if(loginRe!=loginPwd){
					$("#loginRecom").html("两次密码输入不一致").css("color","red");
					$("#buten").attr("disabled", true);
				}else{
				$("#loginRecom").html("可以注册").css("color","green");
				$("#buten").removeAttr("disabled");
			}
			}
	})
})
	    
    </script>
  
</head>
<body>
	<!--两层为背景样式-->
	<div id="particles">
		<div class="intro">
			
			
		  <div class="login-logo">
		    <a href="index.jsp"><img src="images/logo.png" alt="/attendance/AddLoginServlet"/></a>
		  </div>
		  <h2 class="form-heading">注册</h2>
		  <form class="form-signin app-cam" action="/attendance/AddLoginServlet" >
		      <p>注册一个新账号用于登录</p>
		      <input type="text" class="form-control1" placeholder="员工编号" id="userId" name="userId" ><span id="userIdcom"></span><br>
		      <input type="text" class="form-control1" placeholder="账号" id="loginId" name="loginId"><span id="loginIdcom"></span><br>
		      <input type="password" class="form-control1" placeholder="密码" id="loginPwd" name="loginPwd"><span id="loginPwdcom"></span><br>
		      <input type="password" class="form-control1" placeholder="确认密码" id="loginRe"><span id="loginRecom"></span>
		      
		      
		      <button class="btn btn-lg btn-success1 btn-block" type="submit"  >注册</button>
		      
		      <div class="registration">
		          	若已有账号<br /><br />
		          <a class="" href="login.jsp">
		                        登录
		          </a>
		      </div>
		      
		  </form>
		  
		   <div class="copy_layout login register">
		      <p>Copyright © 2015 Modern. All Rights Reserved | Design by  </p>
		   </div>
		</div>   
	</div>
</body>
</html>
