<%--
  Created by IntelliJ IDEA.
  User: 韶光善良君
  Date: 2023/12/13
  Time: 0:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>忘记密码 - USST食堂管理系统</title>
    <link rel="stylesheet" href="css/login_register_forgetpassword.css">
</head>
<body>
<div id="forgotPasswordContainer">
    <img src="res/logo.png" alt="USST食堂管理系统" /> <!-- 修改src为实际Logo图片路径 -->
    <form action="forgotPassword" method="post"> <!-- 修改action为后端处理忘记密码的URL -->
        <input type="text" name="username" placeholder="username" required />
        <input type="email" name="email" placeholder="email" required />
        <input type="password" name="newPassword" placeholder="新密码" required />
        <input type="submit" value="重置密码" />
    </form>
    <%
        if (request.getParameter("error") != null && request.getParameter("error").equals("email_error")) {
    %>

    <p style="color: #ce1f1f;">邮箱错误，请重新输入！</p>
    <%
    } else if (request.getParameter("error") != null && request.getParameter("error").equals("Account_is_not_Exists")) {
    %>
    <p style="color: #ce1f1f;">账号不存在，请重新输入！</p>
    <%
        }
    %>
    <a href="login.jsp">返回登录</a>
</div>
</body>
</html>

