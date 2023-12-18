<%--
  Created by IntelliJ IDEA.
  User: 韶光善良君
  Date: 2023/12/18
  Time: 16:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>食堂管理员首页</title>
    <link rel="stylesheet" href="css/cantadmin_menu.css">
    <style>

    </style>
</head>
<body>
<div id="sidebar">
    <img src="res/logo.png" alt="USST Canteen Management System Logo">
    <h1>首页</h1>
    <p>食堂信息维护</p>
    <p>菜品维护</p>
    <p>评价管理</p>
    <p>公告管理</p>
    <p>投票与收集</p>
    <p>投诉处理</p>
</div>
<div id="main-content">
    <h1>欢迎, 食堂管理员 ${username}</h1>
    <!-- Content blocks for dynamic data -->
    <div>
        <p>未处理评价: ${unreviews.size()}条</p>
        <button>处理评价</button>
    </div>
    <div>
        <p>待处理的投诉: ${uncomplaints.size()}条</p>
        <button>查看投诉</button>
    </div>
    <img src="res/1.png" alt="Dish Illustration" style="float:right; width:300px; margin-top:50px;">
</div>
</body>
</html>

