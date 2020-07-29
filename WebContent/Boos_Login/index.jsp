<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<title>老板登录界面</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Modern Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
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
			background: url('images/boss1.jpg') no-repeat center/cover;
			width:970px;
		}
		#wrap > ul > li:nth-child(2){
			background: url('images/boss2.jpg') no-repeat center/cover;
		}
		#wrap > ul > li:nth-child(3){
			background: url('images/boss3.jpg') no-repeat center/cover;
		}
		#wrap > ul > li:nth-child(4){
			background: url('images/boss4.jpg') no-repeat center/cover;
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

</style>
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
                                    <a href="AllEmpQuery.jsp">全部员工信息</a>
                                </li>
                            </ul>
                            <!-- /.nav-second-level -->
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-indent nav_icon"></i>员工管理<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a href="DelEmp.jsp?flag=2">开除员工</a>
                                </li>
                                <li>
                                    <a href="IntEmp.jsp">添加员工</a>
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
                                    <a href="BossMes.jsp">信息详情</a>
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
                                    <a href="UpdateUser.jsp?flag=1">修改用户信息</a>
                                </li>
                                <li>
                                    <a href="DelUser.jsp?flag=1">删除用户信息</a>
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
					<p>王总</p>
				</div>
			</li>
			<li>
				<div class="text">
					<p>杨老板</p>
				</div>
			</li>
			<li>
				<div class="text">
					<p>林总</p>
				</div>
			</li>
			<li class="curr">
				<div class="text">
					<p>史老板</p>
				</div>
			</li>
		</ul>
	</div>
			
	</div>
</div>
    <script src="http://www.jq22.com/jquery/bootstrap-3.3.4.js"></script>
    <script>
    $(function(){
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
    })
	
	</script>
</body>
</html>
