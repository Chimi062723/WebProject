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
    <link rel="stylesheet" href="css/table.css">
    <style>
    </style>
</head>
<body>
<div id="sidebar">
    <img src="res/logo.png" alt="USST Logo"> <!-- Replace with actual logo path-->
    <a href="admin_dashboard.jsp">首页</a>
    <a href="admin_canteen_management.jsp">食堂信息管理</a>
    <a href="admin_account_management.jsp">账号管理</a>
    <a href="admin_reviews_management.jsp">评价信息管理</a>
    <a href="admin_community_management.jsp">交流社区管理</a>
</div>
<div id="content">
    <h1>账号管理</h1>
    <label for="searchBox">搜索用户</label>
    <input type="text" id="searchBox" placeholder="搜索用户..." />
    <input type="button" id="searchBtn" onclick="search()" value="搜索"/>
    <form>
        <table border="1" id="table">
            <tr>
                <th>ID</th>
                <th>姓名</th>
                <th>密码</th>
                <th>邮箱</th>
                <th>角色</th>
                <th>创建时间</th>
                <th>操作</th>
            </tr>
            <c:forEach var="user" items="${sessionScope.users}">
                <tr>
                    <td>${user.userID}</td>
                    <td>${user.userName}</td>
                    <td>${user.password}</td>
                    <td>${user.email}</td>
                    <td>${user.role}</td>
                    <td>${user.createDate}</td>
                    <td>
                        <form>
                            <input type="hidden" name="id" value="${user.userID}">
                            <input type="submit" value="编辑" formaction="EditAccount" formmethod="get">
                            <input type="submit" value="删除" formaction="DeleteAccount" formmethod="get">
                        </form>
                    </td>
                </tr>
            </c:forEach>
            <tr>
                <td>New</td>
                <td><label for="name"></label><input id="name" type="text" name="name" placeholder="输入新的用户名称"> </td>
                <td><label for="password"></label><input id="password" type="text" name="password" placeholder="输入新的密码"></td>
                <td><label for="address"></label><input id="address" name="email" type="text" placeholder="输入新用户邮箱地址"></td>
                <td><label>
                    <select name="role" id="role">
                        <option value="res_admin">食堂管理员</option>
                        <option value="normal_user">普通用户</option>
                    </select>
                </label></td>
                <td>系统自动生成</td>
                <td><input type="submit" formaction="AddAcount" formmethod="post" value="提交"></td>
            </tr>
        </table>
    </form>
    <!-- Add paginator here -->
</div>
<script>
    function search() {
        let input, filter, table, tr, i;
        input = document.getElementById("searchBox");
        filter = input.value;
        table = document.getElementById("table");
        tr = table.getElementsByTagName("tr");
        // 循环表格每一行，查找匹配项
        for (i = 0; i < tr.length; i++) {
            const td1 = tr[i].getElementsByTagName("td")[1];
            if (td1) {
                if (td1.innerHTML.indexOf(filter) > -1) {
                    tr[i].style.display = "";
                } else {
                    tr[i].style.display = "none";
                }
            }
        }
    }
    // JavaScript function for deleting accounts
    function deleteAccount(id) {
        location.href='DeleteAccount?id='+id;

        // Confirm deletion logic
    }
    // JavaScript for search functionality
    function searchAccounts() {
        // Search logic
    }
</script>
</body>
</html>

