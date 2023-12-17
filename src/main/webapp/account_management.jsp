<%--
  Created by IntelliJ IDEA.
  User: 韶光善良君
  Date: 2023/12/17
  Time: 13:42
  To change this template use File | Settings | File Templates.
  需要传入的变量：
  users: 所有用户信息
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>账号管理</title>
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
    <h1>账号管理</h1>
    <input type="text" id="searchBox" placeholder="搜索账号..." />
    <button onclick="location.href='add_account.jsp'">新增账号</button>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>姓名</th>
            <th>邮箱</th>
            <th>角色</th>
            <th>创建时间</th>
            <th>操作</th>
        </tr>
        <c:forEach var="user" items="${users}">
            <tr>
                <td>${user.id}</td>
                <td>${user.name}</td>
                <td>${user.email}</td>
                <td>${user.role}</td>
                <td>${user.creationTime}</td>
                <td>
                    <button onclick="location.href='edit_account.jsp?id=${user.id}'">编辑</button>
                    <button onclick="deleteAccount(${user.id})">删除</button>
                </td>
            </tr>
        </c:forEach>
    </table>
    <!-- Add paginator here -->
</div>
<script>
    // JavaScript function for deleting accounts
    function deleteAccount(id) {
        // Confirm deletion logic
    }
    // JavaScript for search functionality
    function searchAccounts() {
        // Search logic
    }
</script>
</body>
</html>

