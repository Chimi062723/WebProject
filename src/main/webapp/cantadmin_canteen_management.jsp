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
    <title>Title</title>
    <link rel="stylesheet" href="css/cantadmin_menu.css">
<body>
<div id="sidebar">
    <img src="res/logo.png" alt="USST Canteen Management System Logo">
    <a href="cantadmin_dashboard.jsp">首页</a>
    <a href="cantadmin_canteen_management.jsp">食堂信息维护</a>
    <a href="cantadmin_dish_management.jsp">菜品维护</a>
    <a href="cantadmin_reviews_management.jsp">评价管理</a>
    <a href="admin_community_management.jsp">公告管理</a>
    <a href="admin_vote_management.jsp">投票与收集</a>
    <a href="admin_complaint_management.jsp">投诉处理</a>
</div>
<div id="main-content">
    <h2>食堂信息维护</h2>
    <!-- Form for canteen information maintenance -->
    <div class="form-group">
        <label for="canteenName">食堂名称:</label>
        <input type="text" id="canteenName" name="canteenName" value=${canteen.name}}>
    </div>
    <div class="form-group">
        <label for="canteenLocation">食堂位置:</label>
        <input type="text" id="canteenLocation" name="canteenLocation" value=${canteen.location}>
    </div>
    <div class="form-group">
        <label for="canteenHours">营业时间:</label>
        <input type="text" id="canteenHours" name="canteenHours" value=${canteen.opentime}>
    </div>
    <button type="submit">保存</button>
</div>
</body>
</html>
