<%--
  Created by IntelliJ IDEA.
  User: 韶光善良君
  Date: 2023/12/19
  Time: 0:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>菜品维护</title>
    <link rel="stylesheet" href="css/cantadmin_menu.css">
    <link rel="stylesheet" href="css/dish.css">
    <style>
    </style>
</head>
<body>
<div id="sidebar">
    <img src="res/logo.png" alt="USST Canteen Management System Logo">
    <a href="cantadmin_dashboard.jsp">首页</a>
    <a href="cantadmin_canteen_management.jsp">食堂信息维护</a>
    <a href="cantadmin_dish_management.jsp">菜品维护</a>
    <a href="cantadmin_reviews_management.jsp">评价管理</a>
    <a href="cantadmin_notice_management.jsp">公告管理</a>
    <a href="cantadmin_vote_management.jsp">投票与收集</a>
    <a href="cantadmin_complaint_management.jsp">投诉处理</a>
</div>
<div id="main-content" class="clearfix">
    <!-- Dynamic generation of dish cards -->
    <div class="dish-card">
        <img src="res/1.png" alt="Dish Name">
        <div class="dish-info">
            <h3>菜品名称</h3>
            <p>定价: 12元/份</p>
            <p>库存: 18份</p>
            <p>分类: 热菜</p>
            <button class="button">修改</button>
        </div>
    </div>
    <!-- Repeat for other dishes -->
</div>
</body>
</html>

