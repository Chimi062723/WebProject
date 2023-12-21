<%--
  Created by IntelliJ IDEA.
  User: 韶光善良君
  Date: 2023/12/13
  Time: 0:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>登录 - USST食堂管理系统</title>
    <link rel="stylesheet" href="css/login_register_forgetpassword.css">

</head>
<body>
<div id="loginContainer">
    <img src="res/logo.png" alt="USST食堂管理系统" /> <!-- 修改src为实际Logo图片路径 -->
    <form action="login" method="post"> <!-- 修改action为后端处理登录的URL -->
        <input type="text" name="username" placeholder="用户名" required />
        <input type="password" name="password" placeholder="密码" required />
        <input type="submit" value="登录" />
    </form>
    <a href="forgot_password.jsp">忘记密码？</a>
    <a href="register.jsp">注册新账户</a>
    <%
        if (request.getParameter("error") != null && request.getParameter("error").equals("Account_is_not_Exists")) {
    %>

    <p style="color: #ce1f1f;">账号不存在，请先注册！</p>
    <%
        } else if (request.getParameter("error") != null && request.getParameter("error").equals("password_error")) {
    %>
    <p style="color: #ce1f1f;">密码错误，请重新输入！</p>
    <%
        }
    %>
</div>
</body>
</html>

