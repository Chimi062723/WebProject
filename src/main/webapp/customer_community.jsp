<%--
  Created by IntelliJ IDEA.
  User: 韶光善良君
  Date: 2023/12/20
  Time: 22:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="css/customer_menu.css" />
</head>
<body>
<div id="sidebar">
    <img src="res/logo.png" alt="USST Canteen Management System Logo">
    <a href="customer_dashboard.jsp">首页</a>
    <a href="customer_dish.jsp">菜品一览</a>
    <a href="customer_community.jsp">交流社区</a>
    <a href="customer_canteen.jsp">食堂搜索</a>
</div>
<div id="main-content">
    <h2>社区论坛</h2>

    <!-- 发布消息表单 -->
    <form action="PostMessageServlet" method="post">
        标题: <input type="text" name="title">
        内容: <textarea name="content"></textarea>
        <input type="submit" value="发表">
    </form>

    <!-- 搜索功能 -->
    <form action="SearchForumServlet" method="get">
        <input type="text" name="searchQuery" placeholder="搜索标题或用户名">
        <input type="submit" value="搜索">
    </form>

    <!-- 排序选项 -->
    <div>
        <button onclick="sort('time')">按时间排序</button>
        <button onclick="sort('popularity')">按热度排序</button>
    </div>

    <!-- 用户消息显示区 -->
    <div id="messages">
        <!-- 动态加载用户消息 -->
    </div>

    <script>
        function sort(type) {
            // 根据排序类型调整消息显示顺序
        }
        // 更多JavaScript逻辑
    </script>
</div>
</body>
</html>
