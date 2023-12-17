<%--
  Created by IntelliJ IDEA.
  User: 韶光善良君
  Date: 2023/12/17
  Time: 14:26
  To change this template use File | Settings | File Templates.
  需要传入的变量：
  reviews: 所有评价信息
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>评价信息管理</title>
    <link rel="stylesheet" href="css/admin_menu.css">
    <style>
        /* Add your CSS styles here */
        /* ... */
    </style>
</head>
<body>
<div id="sidebar">
    <img src="res/logo.png" alt="USST Logo"> <!-- Replace with actual logo path -->
    <a href="admin_dashboard.jsp">首页</a>
    <a href="canteen_info.jsp">食堂信息管理</a>
    <a href="account_management.jsp">账号管理</a>
    <a href="reviews_management.jsp">评价信息管理</a>
    <a href="community_management.jsp">交流社区管理</a>
</div>
<div id="content">
    <h1>评价信息管理</h1>
    <input type="text" id="searchBox" placeholder="搜索评价..." />
    <!-- Add button if necessary -->
    <table border="1">
        <tr>
            <th>ID</th>
            <th>评价方</th>
            <th>菜品</th>
            <th>评分</th>
            <th>评论</th>
            <th>发布时间</th>
            <th>操作</th>
        </tr>
        <c:forEach var="review" items="${reviews}">
            <tr>
                <td>${review.id}</td>
                <td>${review.reviewer}</td>
                <td>${review.dish}</td>
                <td>${review.score}</td>
                <td>${review.comment}</td>
                <td>${review.timestamp}</td>
                <td>
                    <button onclick="location.href='edit_review.jsp?id=${review.id}'">编辑</button>
                    <button onclick="deleteReview(${review.id})">删除</button>
                </td>
            </tr>
        </c:forEach>
    </table>
    <!-- Add paginator here -->
</div>
<script>
    function deleteReview(id) {
        // Confirm deletion logic
    }
    function searchReviews() {
        // Search logic
    }
</script>
</body>
</html>

