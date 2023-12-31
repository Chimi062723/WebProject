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
<link rel="icon" type="image/png" href="res/logo_icon.png">
    <title>评价信息管理</title>
    <link rel="stylesheet" href="css/admin_menu.css">
    <link rel="stylesheet" href="css/table.css">
    <style>
        /* Add your CSS styles here */
        /* ... */
    </style>
</head>
<body>
<jsp:include page="backToTopComponent.jsp" />
<jsp:include page="admin_sidebar.jsp"/>
<div id="content">
    <h1>评价信息管理</h1>
    <label for="searchBox">搜索评价</label>
    <input type="text" id="searchBox" placeholder="搜索评价..." />
    <input type="button" id="searchBtn" onclick="search()" value="搜索"/>
    <!-- Add button if necessary -->
    <table border="1" id="table">
        <tr>
            <th>ID</th>
            <th>评价方</th>
            <th>菜品</th>
            <th>评分</th>
            <th>评论</th>
            <th>发布时间</th>
            <th>回复</th>
            <th>操作</th>
        </tr>
        <c:forEach var="review" items="${sessionScope.reviews}">
            <tr>
                <td>${review.reviewID}</td>
                <td>${review.sender.userName}</td>
                <td>${review.dish.name}</td>
                <td>${review.rating}</td>
                <td>${review.comment}</td>
                <td>${review.createDate}</td>
                <td>${review.reply}</td>
                <td>
                    <button onclick="location.href='EditReview?id=${review.reviewID}'">编辑</button>
                    <button onclick="location.href='DeleteReview?id=${review.reviewID}'">删除</button>
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
            const td1 = tr[i].getElementsByTagName("td")[4];
            if (td1) {
                if (td1.innerHTML.indexOf(filter) > -1) {
                    tr[i].style.display = "";
                } else {
                    tr[i].style.display = "none";
                }
            }
        }
    }
</script>
</body>
</html>

