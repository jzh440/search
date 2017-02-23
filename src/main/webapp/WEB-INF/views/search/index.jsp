<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		<!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- 可选的 Bootstrap 主题文件（一般不用引入） -->
<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
<script>
$(document).ready(function(){
  $("#search").click(function(){
	  var data={};
	  data["keywords"]=$("#search_val").val();
	  data["current"]=$("li span:sr-only").html();
	  data["limit"]=10;
    $.get("search/query",function(data,status){
    	if(status=='success'){
    		$("#mount").html("搜索到相关网页"+data["count"]+"篇，用时"+data["time"]);
    		$.each(data["waps"],function(n,value){
	    		var html='<div class="mylist" id="news'+n+'"><div class="search-result-title"><span id="title">'+value["title"]+'</span></div><div>'+value["desc"]+'</div><div ><span class="search-result-url">'+value["url"]+'</span><span class="search-result-tu">';
	    		if(value["is_pop"]==1){
	    			html=html+'推广</span></div></div>';
	    		}else{
	    			html=html+'</span></div></div>';
	    		}
	    		$("mylist:last").append(html);
	    	});
    	}
    });
  });
});
</script>
	</head>
	<body>
		<div class="container search-main">
    <div class="input-group search-search">
        <input type="text" class="form-control" placeholder="Search for..." id="search_val">
      <span class="input-group-btn">
        <button class="btn btn-default" type="button" id="search">搜索</button>
      </span>
    </div><!-- /input-group -->
    <div class="search-time"><span id="mount">搜索到相关网页5040篇，用时0.027s</span></div>
    <div id="news" class="mylist">
        <div class="search-result-title"><span id="title">美国硅谷svse软件教育</span></div>
        <div>育美国硅谷svse育美国硅谷svse育美硅谷svse育美国硅谷svse育美硅谷svse育美国硅谷svse育美硅谷svse育美国硅谷svse育美硅谷svse育美国硅谷svse育美硅谷svse育美国硅谷svse育美硅谷svse育美国硅谷svse育美硅谷svse育美国硅谷svse育美硅谷svse育美国硅谷svse育美硅谷svse育美国硅谷svse育美硅谷svse育美国硅谷svse育美硅谷svse育美国硅谷svse育美国硅谷svse育美国硅谷svse育美国硅谷svse育美国硅谷svse育美国硅谷svse育美国硅谷svse育美国硅谷svse育美国硅谷svse育美国硅谷svse育美国硅谷svse育美国硅谷svse育美国硅谷svse育美国硅谷svse育美国硅谷svse</div>
        <div ><span class="search-result-url">http://svse.com.cn2008-8</span><span class="search-result-tu">推广</span></div>
    </div>
    <%@ include file="../page.jsp"%>
 </div>
	</body>
	<style>
	.search-main{
		width: 1024px;
	}
		.search-time {
		width: 900px;
		text-align: right;
			
		}
		.search-search{
			margin-top: 20px;
			margin-bottom: 20px;
		}
		.search-result-title{
			color: blue;
			margin-bottom: 5px;;
			
		}
		.search-result-title span {
			border-bottom: solid 1px blue;
		}
		.search-result-url {
			color: green;
		}
		.search-result-tu {
			margin-left: 5px;
			color: gray;
			border-bottom: solid 1px gray;
		}
	</style>
</html>
