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
<title>打卡信息查询界面</title>
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
<!--日历-->
<script src="js/calendar.js" type="text/javascript" charset="utf-8"></script>
<link rel="stylesheet" type="text/css" href="css/timedate.css"/>
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
		 <h3>打卡信息</h3>
		 <div id="calendar"></div>
		<!-- <div class="col-md-12 span_3">
			  <div class="bs-example1" data-example-id="contextual-table">
			    <table class="table table-hover">
			      <thead>
			        <tr>
			          <th>#</th>
			          <th>打卡编号</th>
			          <th>员工编号</th>
			          <th>上午签到</th>
			          <th>下午签到</th>
			        </tr>
			      </thead>
			      <tbody>
			        <tr>
			          <th>1</th>
			          <td></td>
			          <td></td>
			          <td></td>
			          <td></td>
			        </tr>
			      </tbody>
			    </table>
			   </div>
		   </div> -->
		   
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
<script>
$(function(){
	//一串数字转换成正常时间 
	function transferTime(cTime){
	       var jsonDate = new Date(parseInt(cTime));
	       Date.prototype.format = function (format){
	             var  o = {
	                  "y+": this.getFullYear(),
	                  "M+": this.getMonth()+1,
	                  "d+": this.getDate(),
	                  "h+": this.getHours(),
	                  "m+": this.getMinutes(),
	                  "s+": this.getSeconds()
	             };
	             if(/(y+)/.test(format)){
	                  format = format.replace(RegExp.$1, (this.getFullYear()+"").substr(4 - RegExp.$1.length));
	             }

	             for(var k in o){
	                  if(new RegExp("("+k+")").test(format)){
	                      format = format.replace(RegExp.$1, RegExp.$1.length == 1?o[k] : ("" + o[k]).substr("" + o[k].length));
	                  }
	             }
	             return format;
	       };
	       var newDate = jsonDate.format("yyyy-MM-dd");
	       return newDate
	}

	
	$.ajax({
    url:"/attendance/DateServlet",
    type:"get",
    dataType:"json",
    success:function(data1){
    	
    	var da=data1[0].time;
		var kind=data1[0].kind;
		var time=transferTime(da);
		
		var data = [{ startDate:time, name:kind }];
    	
    	for(var i=1;i<data1.length;i++){
    		
    		var da=data1[i].time;
    		var kind=data1[i].kind;
    		var time=transferTime(da);
    		
    		var data2 = { startDate:time, name:kind };
    		
    		data.push(data2);
    	}
    	 
    	
    	
		 $("#calendar").calendar({
			data: data,
			mode: "month",
			//  maxEvent: 3,
			//showModeBtn: false
		  //  newDate: "2018-04-1",
			cellClick: function (events) {
				//viewCell的事件列表
			},
		})
		
		
		
    },
	error:function(){
		
		var myDate = new Date();            
    	var year=myDate.getFullYear();        //获取当前年
    	var month=myDate.getMonth()+1;   //获取当前月
    	var date=myDate.getDate();            //获取当前日
    	var now=year+"-"+month+"-"+date;
    	
		var data = [{ startDate:now, name:"无事件" }];
		
		$("#calendar").calendar({
			data: data,
			mode: "month",
			//  maxEvent: 3,
			//showModeBtn: false
		  //  newDate: "2018-04-1",
			cellClick: function (events) {
				//viewCell的事件列表
			},
		})
	}
	
   })
//	var data = [{ startDate: "2020-6-19", name: "事件1" }];

})

</script>
</body>
</html>
