<%--
  Created by IntelliJ IDEA.
  User: 韶光善良君
  Date: 2023/12/17
  Time: 14:29
  To change this template use File | Settings | File Templates.
  需要传入的变量：
  communityPosts: 所有社区帖子信息
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>交流社区管理</title>
    <link rel="stylesheet" href="css/admin_menu.css">
    <link rel="stylesheet" href="css/table.css">
    <style>
        /* Add your CSS styles here */
        /* ... */
    </style>
</head>
<body>
<div id="sidebar">
    <img src="res/logo.png" alt="USST Logo"> <!-- Replace with actual logo path -->
    <a href="admin_dashboard.jsp">首页</a>
    <a href="admin_canteen_management.jsp">食堂信息管理</a>
    <a href="admin_account_management.jsp">账号管理</a>
    <a href="admin_reviews_management.jsp">评价信息管理</a>
    <a href="admin_community_management.jsp">交流社区管理</a>
</div>
<div id="content">
    <h1>交流社区管理</h1>
    <input type="text" id="searchBox" placeholder="搜索帖子..." />
    <!-- Add button if necessary -->
    <table border="1">
        <tr>
            <th>ID</th>
            <th>发布者</th>
            <th>标题</th>
            <th>内容</th>
            <th>发布时间</th>
            <th>操作</th>
        </tr>
        <c:forEach var="post" items="${posts}">
            <tr>
                <td>${post.id}</td>
                <td>${post.author}</td>
                <td>${post.title}</td>
                <td>${post.content}</td>
                <td>${post.timestamp}</td>
                <td>
                    <button onclick="location.href='edit_post.jsp?id=${post.id}'">编辑</button>
                    <button onclick="deletePost(${post.id})">删除</button>
                </td>
            </tr>
        </c:forEach>
    </table>
    <!-- Add paginator here -->
</div>
<script>
    // JavaScript function for deleting posts
    function deletePost(id) {
        // Confirm deletion logic
    }
    // JavaScript for search functionality
    function searchPosts() {
        // Search logic
    }
</script>
</body>
</html>

