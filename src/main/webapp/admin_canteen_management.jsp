<!--
  Created by IntelliJ IDEA.
  User: 韶光善良君
  Date: 2023/12/13
  Time: 0:34
  To change this template use File | Settings | File Templates.
需要传入的变量：
canteens: 所有食堂信息
需要完成的业务逻辑：
食堂删除逻辑
食堂修改逻辑
-->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <title>食堂信息管理</title>
  <!-- 在这里添加CSS和JavaScript引用 -->
  <link rel="stylesheet" href="css/admin_menu.css">
  <link rel="stylesheet" href="css/table.css">
</head>
<body>
<div id="sidebar">
  <img src="res/logo.png" alt="USST Logo"> <!-- 修改src为实际Logo图片路径 -->
  <a href="admin_dashboard.jsp">首页</a>
  <a href="admin_canteen_management.jsp">食堂信息管理</a>
  <a href="admin_account_management.jsp">账号管理</a>
  <a href="admin_reviews_management.jsp">评价信息管理</a>
  <a href="admin_community_management.jsp">交流社区管理</a>
</div>
<div id="content">
  <h1>食堂信息管理</h1>
  <label for="searchBox"></label>
  <input type="text" id="searchBox" placeholder="搜索食堂..." />
  <button onclick="location.href='add_canteen.jsp'">新增食堂</button>
  <form>
    <table border="1">
      <tr>
        <th>ID</th>
        <th>名称</th>
        <th>地址</th>
        <th>营业时间</th>
        <th>管理者</th>
        <th>操作</th>
      </tr>
      <c:forEach var="canteen" items="${sessionScope.canteens}">
        <tr>
          <td>${canteen.canteenID}</td>
          <td>${canteen.name}</td>
          <td>${canteen.location}</td>
          <td>${canteen.openTime}</td>
          <td>${canteen.managerID}</td>
          <td>
            <button onclick="location.href='EditCanteen?id=${canteen.canteenID}'">编辑</button>
            <button onclick="deleteCanteen(${canteen.canteenID})">删除</button>
          </td>
        </tr>
      </c:forEach>
      <tr>
        <td>New</td>
        <td><label for="name"></label><input id="name" type="text" name="name" placeholder="输入新的食堂名称"> </td>
        <td><label for="address"></label><input id="address" name="address" type="text" placeholder="输入新的地址"></td>
        <td><label for="time"></label><input id="time" name="time" type="text" placeholder="输入新的营业时间"></td>
        <td><label for="manager"></label><input id="manager" name="managerID" type="number" placeholder="输入新的管理员ID"></td>
        <td><input type="submit" formaction="AddCanteen" formmethod="post"></td>
      </tr>
    </table>
  </form>
  <!-- 在这里添加分页器 -->
</div>
<iframe id="iframe">

</iframe>
<script>
  // JavaScript 函数用于处理删除食堂的操作
  function deleteCanteen(id) {
    // 确认删除逻辑
  }
  // JavaScript 用于处理搜索逻辑
  function searchCanteens() {
    // 搜索逻辑
  }
</script>
</body>
</html>
