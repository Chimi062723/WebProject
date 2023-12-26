<%--
  Created by IntelliJ IDEA.
  User: 韶光善良君
  Date: 2023/12/18
  Time: 16:45
  To change this template use File | Settings | File Templates.
  需要传入的变量：
  - _username: 用户名_
- _unreviews: 未审核的评价信息_
- _uncomplaints: 未处理的投诉信息_
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>食堂管理员首页</title>
    <link rel="stylesheet" href="css/cantadmin_menu.css">
    <style>

    </style>
</head>
<body>
<jsp:include page="cantadmin_sidebar.jsp" />
<div id="main-content">
    <h1>欢迎, 食堂管理员 ${sessionScope.username}</h1>
    <!-- Content blocks for dynamic data -->
    <div>
        <form action="ManagemenGetUnReviews" method="post">
            <p>未处理评价: ${sessionScope.unreviews.size()}条</p>
            <button type="submit" value="处理评价">处理评价</button>
        </form>
    </div>
    <div>
        <form action="ManagemenGetUnComplaints" method="post">
            <p>待处理的投诉: ${sessionScope.uncomplaints.size()}条</p>
            <button type="submit" value="处理投诉">处理投诉</button>
        </form>
    </div>
    <img src="res/1.png" alt="Dish Illustration" style="float:right; width:300px; margin-top:50px;">
</div>
</body>
</html>

