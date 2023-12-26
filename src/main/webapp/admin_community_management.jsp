<%--
  Created by IntelliJ IDEA.
  User: 韶光善良君
  Date: 2023/12/17
  Time: 14:29
  To change this template use File | Settings | File Templates.
  需要传入的变量：
  communityPosts: 所有社区帖子信息
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
    <a href="GetCanteens">食堂信息管理</a>
    <a href="GetAccounts">账号管理</a>
    <a href="GetReviews">评价信息管理</a>
    <a href="GetPosts">交流社区管理</a>
</div>
<div id="content">
    <h1>交流社区管理</h1>
    <label for="searchBox">搜索帖子</label>
    <input type="text" id="searchBox" placeholder="搜索帖子..." />
    <input type="button" id="searchBtn" onclick="search()" value="搜索"/>
    <!-- Add button if necessary -->
    <table border="1" id="table">
        <tr>
            <th>ID</th>
            <th>发布者</th>
            <th>标题</th>
            <th>内容</th>
            <th>发布时间</th>
            <th>操作</th>
        </tr>
        <c:forEach var="post" items="${sessionScope.posts}">
            <tr>
                <td>${post.postID}</td>
                <td>${post.author.userName}</td>
                <td>${post.title}</td>
                <td>${post.content}</td>
                <td>${post.createDate}</td>
                <td>
                    <button onclick="location.href='EditPost?id=${post.postID}'">编辑</button>
                    <button onclick="location.href='DeletePost?id=${post.postID}'">删除</button>
                </td>
            </tr>
        </c:forEach>
    </table>
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
            const td1 = tr[i].getElementsByTagName("td")[2];//搜索第3,4列即标题和内容
            const td2 = tr[i].getElementsByTagName("td")[3];
            if (td1||td2) {
                if (td1.innerHTML.indexOf(filter) > -1||td2.innerHTML.indexOf(filter) > -1) {
                    tr[i].style.display = "";
                } else {
                    tr[i].style.display = "none";
                }
            }
        }
    }
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

