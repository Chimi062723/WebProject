<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<head>
<link rel="icon" type="image/png" href="res/logo_icon.png">
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/5.1.1/css/bootstrap.min.css" >
    <meta charset="UTF-8">
    <title></title>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/5.1.1/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<div id="sidebar">
    <img src="res/logo.png" alt="USST Canteen Management System Logo">
    <a href="GetPostServlet">首页</a>
    <a href="${pageContext.request.contextPath}/getAllDishes">菜品一览</a>
    <a href="PostMessageServlet">交流社区</a>
    <a href="customer_canteen.jsp">食堂搜索</a>
    <div class="bottom" id="logoutbt">
        <form id="logout" action="logout" method="post">
            <input type="submit" class="btn btn-primary" value="退出"/>
        </form>
    </div>
</div>
</body>

