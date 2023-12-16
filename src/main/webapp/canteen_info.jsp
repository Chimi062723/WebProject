<!--
  Created by IntelliJ IDEA.
  User: 韶光善良君
  Date: 2023/12/13
  Time: 0:34
  To change this template use File | Settings | File Templates.
需要传入的变量：
canteens: 所有食堂信息
-->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  <title>食堂信息管理</title>
  <!-- 在这里添加CSS和JavaScript引用 -->
</head>
<body>
<h1>食堂信息管理</h1>
<input type="text" id="searchBox" placeholder="搜索食堂..." />
<button onclick="location.href='add_canteen.jsp'">新增食堂</button>
<table border="1">
  <tr>
    <th>ID</th>
    <th>名称</th>
    <th>地址</th>
    <th>营业时间</th>
    <th>管理者</th>
    <th>邮箱</th>
    <th>操作</th>
  </tr>
  <c:forEach var="canteen" items="${canteens}">
    <tr>
      <td>${canteen.id}</td>
      <td>${canteen.name}</td>
      <td>${canteen.address}</td>
      <td>${canteen.businessHours}</td>
      <td>${canteen.manager}</td>
      <td>${canteen.email}</td>
      <td>
        <button onclick="location.href='edit_canteen.jsp?id=${canteen.id}'">编辑</button>
        <button onclick="deleteCanteen(${canteen.id})">删除</button>
      </td>
    </tr>
  </c:forEach>
</table>
<!-- 在这里添加分页器 -->
<script>
  // JavaScript 函数用于处理删除食堂的操作
  function deleteCanteen(id) {
    if(confirm('确定要删除这个食堂吗？')) {
      // 实现删除食堂的逻辑，可能需要发送请求到后端
    }
  }
</script>
</body>
</html>
