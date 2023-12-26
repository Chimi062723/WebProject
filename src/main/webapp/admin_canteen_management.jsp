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
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
<jsp:include page="admin_sidebar.jsp"/>
<div id="content">
  <h1>食堂信息管理</h1>
  <label for="searchBox">搜索食堂</label>
  <input type="text" id="searchBox" placeholder="搜索食堂..." />
  <input type="button" id="searchBtn" onclick="search()" value="搜索"/>
  <form>
    <table border="1" id="table">
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
          <td>姓名:${canteen.manager.userName} ID:${canteen.managerID}</td>
          <td>
            <form>
              <input type="hidden" name="id" value="${canteen.canteenID}">
              <input type="submit" value="编辑" formaction="EditCanteen" formmethod="get">
              <input type="submit" value="删除" formaction="DeleteCanteen" formmethod="get">
            </form>
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
<script>
  function search() {
    let input, filter, table, tr, i;
    input = document.getElementById("searchBox");
    filter = input.value;
    table = document.getElementById("table");
    tr = table.getElementsByTagName("tr");
    // 循环表格每一行，查找匹配项
    for (i = 0; i < tr.length; i++) {
      const td1 = tr[i].getElementsByTagName("td")[1];
      if (td1) {
        if (td1.innerHTML.indexOf(filter) > -1) {
          tr[i].style.display = "";
        } else {
          tr[i].style.display = "none";
        }
      }
    }
  }

</script>
</body>
</html>
