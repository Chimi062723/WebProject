<%--
  Created by IntelliJ IDEA.
  User: 韶光善良君
  Date: 2023/12/19
  Time: 0:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="css/cantadmin_menu.css">
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
<div id="main-content">
    <h2>投诉处理</h2>
    <!-- A table to display the complaints -->
    <table>
        <thead>
        <tr>
            <th>投诉ID</th>
            <th>用户名称</th>
            <th>投诉内容</th>
            <th>投诉时间</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <!-- Dynamically generate rows here from the complaints data -->
        </tbody>
    </table>
    <!-- You might include a form or buttons to address each complaint -->
</div>
</body>
</html>
