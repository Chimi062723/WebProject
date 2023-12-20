<%--
  Created by IntelliJ IDEA.
  User: 韶光善良君
  Date: 2023/12/19
  Time: 0:45
  To change this template use File | Settings | File Templates.
  需要的变量：
  _reviews: 评价信息_
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="css/cantadmin_menu.css">
    <link rel="stylesheet" href="css/reviews.css">
    <link rel="stylesheet" href="css/table1.css">
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
    <table>
        <thead>
        <tr>
            <th>发送者</th>
            <th>评价菜品</th>
            <th>评分</th>
            <th>内容</th>
            <th>发送时间</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <!-- Dynamic rows will be loaded here -->
            <c:forEach var="review" items="${reviews}">
                <tr>
                    <td>${review.sender}</td>
                    <td>${review.dishName}</td>
                    <td>${review.rating}</td>
                    <td>${review.content}</td>
                    <td>${review.creationTime}</td>
                    <td><a href="review_detail.jsp?reviewId=${review.id}">查看</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>
<script>
</script>
</body>
</html>