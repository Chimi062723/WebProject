<%--
  Created by IntelliJ IDEA.
  User: 韶光善良君
  Date: 2023/12/20
  Time: 22:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="css/customer_menu.css"/>
    <link rel="stylesheet" href="css/canteen_table.css"/>
</head>
<body>
<div id="sidebar">
    <img src="res/logo.png" alt="USST Canteen Management System Logo">
    <a href="customer_dashboard.jsp">首页</a>
    <a href="customer_dish.jsp">菜品一览</a>
    <a href="customer_community.jsp">交流社区</a>
    <a href="customer_canteen.jsp">食堂搜索</a>
</div>
<table>    <!-- 表格标题 -->
    <caption>食堂信息表</caption>    <!-- 表格第一行：表格表头 -->
    <tr>
        <th>编号</th>
        <th>名称</th>
        <th>位置</th>
        <th>开放时间</th>
        <th>操作</th>
    </tr>
    <c:forEach var="canteen" items="${sessionScope.canteens}">
        <tr>
            <td>${canteen.id}</td>
            <td>${canteen.name}</td>
            <td>${canteen.location}</td>
            <td>${canteen.openTime}</td>
            <!-- 在该单元格中创建一个链接标签，void运算符来阻止href返回值，通过onclick事件(鼠标点击)属性来删除信息行-->
            <td><a href="CanteenDetailServlet?canteenID='${canteen.id}'">查看</a></td>
        </tr>
        <!-- 表格第三行：学生信息2 -->
    </c:forEach>
</table>
</body>
</html>
