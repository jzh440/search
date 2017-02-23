
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<script>
    // 防止页面回退
    window.history.forward()
</script>
<!DOCTYPE html>
<html>
<head>
    <title>登录</title>
    <%@ include file="../common.html"%>
    <base href="<%=basePath%>">
</head>
<body>
<div class="container">

    <div class="panel panel-default login-index">
        <form:form modelAttribute="loginFrom" action="login/ogin" method="POST">
        <div class="panel-heading">
            管理员登录
        </div>
        <div class="panel-body">
            <div>${msg}</div>
            <form:errors path="*" cssClass=""></form:errors>
            <div class="input-group">
                <span class="input-group-addon">账号</span>
                <input type="text" class="form-control" name="userName">
            </div>
            <div class="input-group login-input-bottom">
                <span class="input-group-addon">密码</span>
                <input type="password" class="form-control" name="password">
            </div>
        </div>
        <div class="panel-footer login-panel-footer">
            <button type="submit">登录</button>
        </div>
        </form:form>
    </div>

</div>
</body>
</html>
