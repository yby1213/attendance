
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<title>员工登录界面</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Modern Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<link rel="stylesheet" type="text/css" href="css/normalize.css" />
<link rel="stylesheet" type="text/css" href="css/vicons-font.css" />
<link rel="stylesheet" type="text/css" href="css/base.css" />
<link rel="stylesheet" type="text/css" href="css/buttons.css" />
 <!-- Bootstrap Core CSS -->
<link rel="stylesheet" type="text/css" href="http://www.jq22.com/jquery/bootstrap-3.3.4.css">
<!-- Custom CSS -->
<link href="css/style.css" rel='stylesheet' type='text/css' />
<!-- Graph CSS -->
<link href="css/lines.css" rel='stylesheet' type='text/css' />
<link rel="stylesheet" type="text/css" href="http://www.jq22.com/jquery/font-awesome.4.6.0.css"> 
<!-- jQuery -->
<script src="http://www.jq22.com/jquery/jquery-1.10.2.js"></script>

<!---//webfonts--->  
<!-- Nav CSS -->
<link href="css/custom.css" rel="stylesheet">
<!-- Metis Menu Plugin JavaScript -->
<script src="js/metisMenu.min.js"></script>
<script src="js/custom.js"></script>
<!-- Graph JavaScript -->
<script src="js/d3.v3.js"></script>
<script src="js/rickshaw.js"></script>



<!-- class="button button--nuka button--round-s button--text-thick" id="clockNum2" -->

<!--轮播图-->
<style type="text/css">
	
		*{margin:0; padding:0;}
		body,html{width:100%; height:100%;}
		.bg {
			position: absolute;
			top: 0;
			left: 0;
			width: 100%;
			height: 100%;
		}
		#wrap{
			width: 1240px;
			height: 600px;
		}
		#wrap > ul{
			width: 120%;
			list-style: none;
		}
		#wrap > ul > li{
			float: left;
			width: 100px;
			height: 600px;
			cursor: pointer;
		}
		#wrap > ul > li:nth-child(1){
			background: url(../Login_Home/images/123.png) no-repeat center/cover;
			width:970px;
		}
		#wrap > ul > li:nth-child(2){
			background: url(../Boos_Login/images/pic4.jpg) no-repeat center/cover;
		}
		#wrap > ul > li:nth-child(3){
			background: url(../Boos_Login/images/pic3.jpg) no-repeat center/cover;
		}
		#wrap > ul > li:nth-child(4){
			background: url(images/2.jpg) no-repeat center/cover;
		}	
		#wrap > ul > li > .text{
			width: 100px;
			height: 100%;
			background: #000;
			opacity: .5;
		}
		#wrap > ul > li > .text p{
			padding: 20px 40px;
			font-family: 'Microsoft yahei';
			color: #fff;
		}
		.abcd{
		width: 200px;
		height: 50px;
		margin: 20px 0 0 500px;
		background-color: orange;
		}
</style>
<script type="text/javascript">
	function Btn_Click(){
		
			$.ajax({
				url:"/attendance/ClockNumServlet",
				type:"get",
				data:{
					flag:1},
				success:function(data){
					if(data!="flase"){
						$("#clockNum2").attr("disabled",true);
						alert("打卡成功");
					}
					
				},
				error:function(){
					alert("此时间点不是打卡时间");
					$("#clockNum2").attr("disabled",true);
				}
			})
		}

	
</script>
</head>
<body>
<div id="wrapper">
     <!-- Navigation -->
     	<%
  
		 String  name = (String)session.getAttribute("UserName");
		  if(name==null){
			  response.sendRedirect("/attendance/ListUserByUserId");
		  }
		%>
    <nav class="top1 navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="index.jsp">考勤打卡系统</a>
                <label ><h3>欢迎<%=name %>登录</h3></label>
            </div>
            <!-- /.navbar-header -->
            <ul class="nav navbar-nav navbar-right">
			    <li class="dropdown">
	        		<a href="#" class="dropdown-toggle avatar" data-toggle="dropdown"><img src="images/1.png"><span class="badge"></span></a>
	        		
	        		
	        		
	        		<ul class="dropdown-menu">
						<li class="m_2"><a href="/attendance/Login_Home/login.jsp"><i class="fa fa-lock"></i> Logout</a></li>	
	        		</ul>
	      		</li>
			</ul>
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
                                    <a href="AllEmpQuery.jsp">全部员工信息</a>
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
		
	<div id="wrap">
		<ul>
			<li>
				<div class="text">
					<p>背景墙</p>
				</div>
			</li>
			<li>
				<div class="text">
					<p>员工1</p>
				</div>
			</li>
			<li>
				<div class="text">
					<p>员工2</p>
				</div>
			</li>
			<li class="curr">
				<div class="text">
					<p>员工3</p>
				</div>
			</li>
		</ul>
	</div>
	<%
	Date myDate = new Date();
	SimpleDateFormat sdf = new SimpleDateFormat("HH");
	int hour = Integer.parseInt(sdf.format(myDate));
	if(hour>=5&&hour<=9){
	%>
 	<input type="button" onclick="Btn_Click()" id="clockNum2" value="打卡" class="button button--pipaluk button--inverted button--round-l button--text-thick button--text-upper">
	<%}else if(hour>=17 && hour<=23){ %>
 	<input type="button" onclick="Btn_Click()" id="clockNum2" value="打卡" class="button button--pipaluk button--inverted button--round-l button--text-thick button--text-upper">
	<%}else{ %>
	<input type="button"  value="打卡" disabled="disabled" class="button button--pipaluk button--inverted button--round-l button--text-thick button--text-upper">
	<%} %>
</div>
    <script src="http://www.jq22.com/jquery/bootstrap-3.3.4.js"></script>
    <script>
	(function(){
		$('#wrap li').mouseover(function(){
			if(!$(this).hasClass('curr')){
				$('#wrap li').removeClass('curr');
				$(this).addClass('curr');

				// 切换背景
				$('#wrap li').each(function(index){
					if($(this).hasClass('curr')){
						$('.bg').fadeOut(300);
						$('.bg:eq(' + index + ')').fadeIn(500);
					}
				});

				$('.curr').stop().animate({
					width: 970
				}, 500, 'linear');
				$('#wrap li').not('.curr').stop().animate({
					width: 100
				}, 500, 'linear');
			}
		});
	})()
	</script>
</body>

<%
 session.removeAttribute("UserName");
%>
</html>
