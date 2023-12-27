<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<head>
<link rel="icon" type="image/png" href="res/logo_icon.png">
    <meta charset="UTF-8">
</head>
<body>
<div id="sidebar">
    <img src="res/logo.png" alt="USST Canteen Management System Logo">
    <a href="DashboardRefresh">首页</a>
    <a href="DishMaintenance">菜品维护</a>
    <a href="CanteenInfoRefresh?action=cantInfo">食堂信息维护</a>
    <a href="CanteenInfoRefresh?action=notice">公告管理</a>
    <a href="VoteInfoRefresh">投票与收集</a>
    <a href="ReviewInfoRefresh">评价管理</a>
    <a href="ComplaintInfoRefresh">投诉处理</a>
    <div class="bottom" id="logoutbt">
        <form id="logout" action="logout" method="post">
            <input type="submit"   class="button"value="退出" />
        </form>
    </div>
</div>
</body>