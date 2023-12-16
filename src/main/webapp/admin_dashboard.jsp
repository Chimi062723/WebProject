<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>系统管理员控制台</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            display: flex;
            margin: 0;
            height: 100vh;
        }
        #sidebar {
            background-color: #003366;
            color: white;
            padding: 15px;
            width: 200px;
            height: 100%;
            display: flex;
            flex-direction: column;
        }
        #sidebar img {
            max-width: 100%;
            margin-bottom: 20px;
        }
        #sidebar a {
            color: white;
            text-decoration: none;
            padding: 10px;
            border-radius: 5px;
            margin: 5px 0;
            transition: background-color 0.3s;
        }
        #sidebar a:hover {
            background-color: #0056b3;
        }
        #content {
            flex-grow: 1;
            padding: 20px;
        }
        .data-box {
            border: 1px solid #ddd;
            border-radius: 4px;
            padding: 20px;
            margin-bottom: 20px;
            text-align: center;
        }
    </style>
</head>
<body>
<div id="sidebar">
    <img src="res/logo.png" alt="USST Logo"> <!-- 修改src为实际Logo图片路径 -->
    <a href="admin_dashboard.jsp">首页</a>
    <a href="canteen_info.jsp">食堂信息管理</a>
    <a href="account_management.jsp">账号管理</a>
    <a href="reviews_management.jsp">评价信息管理</a>
    <a href="community_management.jsp">交流社区管理</a>
</div>
<div id="content">
    <!-- 这里根据选择的导航栏显示不同的内容 -->
    <!-- 首页内容 -->
<%--    /**--%>
<%--     * 需要传入的变量：--%>
<%--     * canteens: 所有食堂信息--%>
<%--     * users: 所有用户信息--%>
<%--     * reviews: 所有评价信息--%>
<%--     * communityPosts: 所有社区帖子信息--%>
<%--     */--%>
    <h2>英雄不问出处，干饭不问斤数！</h2>
    <div class="data-box">食堂数量: <span>${canteens.size()}</span></div>
    <div class="data-box">用户数量: <span>${users.size()}</span></div>
    <div class="data-box">评价数量: <span>${reviews.size()}</span></div>
    <div class="data-box">帖子数量: <span>${communityPosts.size()}</span></div>
    <!-- 其他页面的内容将根据导航选择动态加载 -->
</div>
</body>
</html>
