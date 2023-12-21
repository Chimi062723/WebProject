<%--
  Created by IntelliJ IDEA.
  User: 韶光善良君
  Date: 2023/12/19
  Time: 0:41
  To change this template use File | Settings | File Templates.
    需要传入的变量：
    dishes: 所有菜品信息

--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <div class="content-header">
        <input type="text" placeholder="搜索菜品..." class="search-box">
        <button class="button add-new">新增菜品</button>
    </div>
    <!-- Dynamic generation of dish cards -->
    <c:forEach var="dish" items="${dishes}">
        <div class="dish-card">
            <img src="res/${dish.ImageURL}.png" alt="Dish Name">
            <div class="dish-info">
                <h3>${dish.name}</h3>
                <p>定价: ${dish.price}元/份</p>
                <p>促销价: ${dish.promotionPrice}元/份</p>
                <p>菜系: ${dish.cuisineType}</p>
                <button class="button">修改</button>
            </div>
        </div>
    </c:forEach>
    <!-- Repeat for other dishes -->
</div>
</body>
</html>

