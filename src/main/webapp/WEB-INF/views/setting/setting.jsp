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
	</head>
	<body>
		<div class="setting-main">
		<header> 填写标题描述</header>
		<div style="margin-bottom: 15px;"> 提交关键字流程：<span style="color: red; ">填写标题描述</span><span class="glyphicon glyphicon-arrow-right"></span>
			<span>设置价格</span><span class="glyphicon glyphicon-arrow-right"></span>
			<span>确认和提交</span><span class="glyphicon glyphicon-arrow-right"></span><span>成功</span>
		</div>
		<div style="margin-bottom: 15px;">你一次最多提交3个关键字，若您希望继续添加，请分次提交</div>
		<div style="margin-bottom: 15px;"><button>下一步</button></div>
		<div>
			<table class="setting-table">
			<tr>
				<td>关键字</td>
				<td class="text-left"><input id="keword1"> 最多32字</td>
			</tr>
			<tr>
				<td>网页标题</td>
				<td class="text-left"><input id="title1"> 最多20字</td>
			</tr>
			<tr>
				<td>URL地址</td>
				<td class="text-left">http://<input id="url1"> 最多248字节</td>
			</tr>
			<tr>
				<td>网页描述</td>
				<td class="text-left"><textarea cols="100" id="description1"></textarea> 最多100字</td>
			</tr>
		</table>
		
		</div>
		<div>
			<div class="setting-copy"><button onclick="copy(2)">复制</button><span>点击按钮可以将上个添加框填写的内容复制到下个添加框内</span></div>
			<table class="setting-table">
			<tr>
				<td>关键字</td>
				<td class="text-left"><input id="keword2"> 最多32字</td>
			</tr>
			<tr>
				<td>网页标题</td>
				<td class="text-left"><input id="title2"> 最多20字</td>
			</tr>
			<tr>
				<td>URL地址</td>
				<td class="text-left">http://<input id="url2"> 最多248字节</td>
			</tr>
			<tr>
				<td>网页描述</td>
				<td class="text-left"><textarea cols="100" id="description2"></textarea> 最多100字</td>
			</tr>
		</table>
		
		</div>
		<div>
			<div class="setting-copy"><button onclick="copy(3)">复制</button><span>点击按钮可以将上个添加框填写的内容复制到下个添加框内</span></div>
			<table class="setting-table">
			<tr>
				<td>关键字</td>
				<td class="text-left"><input id="keword3"> 最多32字</td>
			</tr>
			<tr>
				<td>网页标题</td>
				<td class="text-left"><input id="title3"> 最多20字</td>
			</tr>
			<tr>
				<td>URL地址</td>
				<td class="text-left">http://<input id="url3"> 最多248字节</td>
			</tr>
			<tr>
				<td>网页描述</td>
				<td class="text-left"><textarea cols="100" id="description3"></textarea> 最多100字</td>
			</tr>
		</table>
		</div>
</div>
	</body>
	<script>
		function copy(num) {
			var idNum = num - 1;
			  document.getElementById("keword" + num).value = document.getElementById("keword" + idNum).value;
			  document.getElementById("title" + num).value = document.getElementById("title" + idNum).value;
			  document.getElementById("url" + num).value = document.getElementById("url" + idNum).value;
			   document.getElementById("description" + num).value = document.getElementById("description" + idNum).value;
			
		}
	</script>
	<style>
	.setting-main {
		width: 1024px;
		margin: 0 auto;
		text-align: center;
	}
		header {
			width: 1024px;
			height: 20px;
			font: 20px;
			text-align: center;
			margin-bottom: 30px;
			margin-top: 10px;
		}
		.setting-table{
			width: 1024px;
			margin: 0 auto;
			border: solid 1px gray;
		}
		.setting-table td{
			
			border: solid 2px gray;
		}
		.setting-copy{
			margin-top: 10px;
			text-align: left;
		}
	</style>
</html>
