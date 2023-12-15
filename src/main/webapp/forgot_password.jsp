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
    <form action="forgotPasswordAction" method="post"> <!-- 修改action为后端处理忘记密码的URL -->
        <input type="email" name="email" placeholder="email" required />
        <input type="submit" value="重置密码" />
    </form>
    <a href="login.jsp">返回登录</a>
</div>
</body>
</html>

