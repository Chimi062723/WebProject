<!--
  Created by IntelliJ IDEA.
  User: 韶光善良君
  Date: 2023/12/13
  Time: 0:33
  To change this template use File | Settings | File Templates.
需要传入的变量：
canteens: 所有食堂信息
users: 所有用户信息
reviews: 所有评价信息
communityPosts: 所有社区帖子信息
-->
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <link rel="icon" type="image/png" href="res/logo_icon.png">
    <title>系统管理员控制台</title>
    <link rel="stylesheet" href="css/admin_menu.css">
</head>
<body>
<jsp:include page="admin_sidebar.jsp"/>
<div id="content">
    <!-- 这里根据选择的导航栏显示不同的内容 -->
    <!-- 首页内容 -->
    <h2>英雄不问出处，干饭不问斤数！</h2>
    <div class="data-box">食堂数量: <span>${sessionScope.canteens.size()}</span></div>
    <div class="data-box">用户数量: <span>${sessionScope.users.size()}</span></div>
    <div class="data-box">评价数量: <span>${sessionScope.reviews.size()}</span></div>
    <div class="data-box">帖子数量: <span>${sessionScope.posts.size()}</span></div>
    <!-- 其他页面的内容将根据导航选择动态加载 -->
</div>
</body>
</html>
