
var pageIndex = 1;


$(function(){
	
/*	if(pageIndex == undefined || pageIndex == 1){
		page();//第一次进页面|第一页
	}else{
		page(pageIndex);
	}*/
	
	$(".c").on("click","a",function(){
		var w = $(this).html();
		switch(w){
		case "首页":
			pageIndex = 1;break;
		case "上一页":
			pageIndex = pageIndex-1;break;
		case "下一页":
			pageIndex = pageIndex+1;break;
		case "末页":
			pageIndex = 1;break;
		}
		
		Page();
	});
	
});

	
	




//显示第几页
function Page(){
	$.ajax({
		url:"/attendance/PageServlet",
		type:"get",
		dataType:"json",
		data:{
			"pageIndex": pageIndex
		},
		success:function(pageListNews){
			$("#insert").empty();
			for(var i=1; i < pageListNews.pageSize; i++){
				$("#insert").append("<tr>" +
						"<td>"+pageListNews.data[i].id +"</td>" +
						"<td>"+pageListNews.data[i].userId +"</td>" +
						"<td>"+pageListNews.data[i].signOut +"</td>" +
						"</tr>");
			}
		},
		error:function(){
			alert("失败");
		}
	});
}



//显示第一页
/*function Login(){
	$.ajax({
		url:"/attendance/PageServlet",
		type:"post",
		dataType:"json",
		data:{
			pageIndex: "1"
		},
		success:function(pageListNews){
			for(var i=1; i < pageListNews.pageSize; i++){
				$("#insert").append("<tr>" +
						"<td>"+pageListNews.data[i].id +"</td>" +
						"<td>"+pageListNews.data[i].userId +"</td>" +
						"<td>"+pageListNews.data[i].signOut +"</td>" +
						"</tr>");
			}
			
		},
		error:function(){
			alert("失败");
		}
	})
}*/
