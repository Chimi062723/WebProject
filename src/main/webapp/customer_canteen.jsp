<%--
  Created by IntelliJ IDEA.
  User: 韶光善良君
  Date: 2023/12/20
  Time: 22:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://cdn.staticfile.org/twitter-bootstrap/5.1.1/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.staticfile.org/twitter-bootstrap/5.1.1/js/bootstrap.bundle.min.js"></script>

<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="css/customer_menu.css"/>
    <link rel="stylesheet" href="css/canteen_table.css"/>
</head>
<body>
<jsp:include page="custom_sidebar.jsp" />
<div>
<form action="customer_canteens">
    <input type="text" name="canteenName" placeholder="请输入食堂名称">
    <input type="submit" value="搜索">
</form>
</div>
<%--<form action="customer_canteens">--%>
<div class="container mt-3">
    <h4>食堂信息表</h4>
    <table class="table table-hover">    <!-- 表格标题 -->
        <!-- 表格第一行：表格表头 -->
        <tr>
            <th>编号</th>
            <th>名称</th>
            <th>位置</th>
            <th>开放时间</th>
<%--            <th>操作</th>--%>
        </tr>
        <c:forEach var="canteen" items="${requestScope.canteens}">
            <tr>
                <td>${canteen.canteenID}</td>
                <td>${canteen.name}</td>
                <td>${canteen.location}</td>
                <td>${canteen.openTime}</td>
                <!-- 在该单元格中创建一个链接标签，void运算符来阻止href返回值，通过onclick事件(鼠标点击)属性来删除信息行-->
<%--                <td><a href="CanteenDetailServlet?canteenID='${canteen.id}'">查看</a></td>--%>
            </tr>
            <!-- 表格第三行：学生信息2 -->
        </c:forEach>

    </table>
</div>
<%--</form>--%>

</body>
</html>
