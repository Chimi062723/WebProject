<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<head>
<link rel="icon" type="image/png" href="res/logo_icon.png">
    <meta charset="UTF-8">
</head>
<body>
<div id="sidebar">
    <img src="res/logo.png" alt="USST Logo"> <!-- Replace with actual logo path-->
    <a href="admin_dashboard.jsp">首页</a>
    <a href="GetCanteens">食堂信息管理</a>
    <a href="GetAccounts">账号管理</a>
    <a href="GetReviews">评价信息管理</a>
    <a href="GetPosts">交流社区管理</a>
    <div class="bottom" id="logoutbt">
        <form id="logout" action="logout" method="post">
            <input type="submit"   class="button"value="退出" />
        </form>
    </div>
</div>
</body>