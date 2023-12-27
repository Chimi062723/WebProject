<%--
  Created by IntelliJ IDEA.
  User: 韶光善良君
  Date: 2023/12/18
  Time: 18:20
  To change this template use File | Settings | File Templates.
  需要传入的变量：
  canteen: 管理员管理的食堂信息
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<link rel="icon" type="image/png" href="res/logo_icon.png">
    <title>Title</title>
    <link rel="stylesheet" href="css/cantadmin_menu.css">
    <link rel="stylesheet" href="css/edit_canteen.css">
<body>
<jsp:include page="backToTopComponent.jsp" />
<jsp:include page="cantadmin_sidebar.jsp" />
<div id="main-content">
    <h2>食堂信息维护</h2>
    <form action="EditCanteen" method="post">
        <input type="hidden" name="canteenID" value="${sessionScope.canteen.canteenID}">
        <input type="hidden" name="role" value="res_admin">
        <label>
            食堂名称:
            <input type="text" name="canteenName" value="${sessionScope.canteen.name}">
        </label>
        <br>
        <label>
            食堂地址:
            <input type="text" name="location" value="${sessionScope.canteen.location}">
        </label>
        <br>
        <label>
            营业时间:
            <input type="text" name="opentime" value="${sessionScope.canteen.openTime}">
        </label>
        <br>
        <input type="hidden" name="managerName" value="${sessionScope.username}">
        <input type="hidden" name="notice" value="${sessionScope.canteen.notice}">
        <input type="submit" value="修改">
    </form>
</div>
</body>
</html>
