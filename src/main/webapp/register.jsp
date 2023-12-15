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
  <title>注册 - USST食堂管理系统</title>
  <link rel="stylesheet" href="css/login_register_forgetpassword.css">
</head>
<body>
<div id="registerContainer">
  <img src="res/logo.png" alt="USST食堂管理系" /> <!-- 修改src为实际Logo图片路径 -->
  <form action="registerAction" method="post"> <!-- 修改action为后端处理注册的URL -->
    <input type="email" name="email" placeholder="电子邮箱" required />
    <input type="text" name="username" placeholder="用户名" required />
    <input type="password" name="password" placeholder="密码" required />
    <input type="submit" value="注册" />
  </form>
  <a href="login.jsp">已有账户？登录</a>
</div>
</body>
</html>
