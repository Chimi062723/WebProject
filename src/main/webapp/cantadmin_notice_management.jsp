<%--
  Created by IntelliJ IDEA.
  User: 韶光善良君
  Date: 2023/12/19
  Time: 0:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="css/cantadmin_menu.css">
    <link rel="stylesheet" href="css/notice.css">
    <link rel="stylesheet" href="css/edit_canteen.css">
</head>
<body>
<jsp:include page="cantadmin_sidebar.jsp" />
<div id="main-content" class="clearfix">
    <h2>食堂公告管理</h2>
    <form action="EditCanteen" method="post">
        <input type="hidden" name="canteenID" value="${sessionScope.canteen.canteenID}">
        <input type="hidden" name="role" value="notice">
        <input type="hidden" name="canteenName" value="${sessionScope.canteen.name}">
        <input type="hidden" name="location" value="${sessionScope.canteen.location}">
        <input type="hidden" name="opentime" value="${sessionScope.canteen.openTime}">
        <input type="hidden" name="managerName" value="${sessionScope.username}">
        <label>
            食堂公告：
            <input type="text" name="notice" value="${sessionScope.canteen.notice}" required>
        </label>
        <br>
        <input type="submit" value="修改">
    </form>
</div>
</body>
</html>
