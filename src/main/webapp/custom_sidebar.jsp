<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<head>
    <meta charset="UTF-8">
</head>
<body>
<div id="sidebar">
    <img src="res/logo.png" alt="USST Canteen Management System Logo">
    <a href="customer_dashboard.jsp">首页</a>
    <a href="customer_dish.jsp">菜品一览</a>
    <a href="customer_community.jsp">交流社区</a>
    <a href="customer_canteen.jsp">食堂搜索</a>
    <div class="bottom" id="logoutbt">
        <form id="logout" action="logout" method="post">
            <input type="submit" class="button" value="退出"/>
        </form>
    </div>
</div>
</body>