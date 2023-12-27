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
<link rel="icon" type="image/png" href="res/logo_icon.png">
    <title>Title</title>
    <link rel="stylesheet" href="css/customer_menu.css"/>
    <link rel="stylesheet" href="css/canteen_table.css"/>
    <link rel="stylesheet" href="https://cdn.staticfile.org/foundation/5.5.3/css/foundation.min.css">
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/5.1.1/css/bootstrap.min.css" >
</head>
<body>
<jsp:include page="custom_sidebar.jsp" />

<div class="container mt-3">
    <h1 class="text-center mt-4 mb-4">食堂信息表</h1>
    <div class="row">
        <div class="col-md-6">
            <form action="customer_canteens">
                <div class="input-group mb-3">
                    <input type="text" name="canteenName" class="form-control" placeholder="请输入食堂名称">
                    <button class="btn btn-outline-secondary" type="submit">搜索</button>
                </div>
            </form>
        </div>
    </div>

    <div class="row">
        <div class="col-md-12">
            <table class="table table-hover">
                <thead>
                <tr>
                    <th>编号</th>
                    <th>名称</th>
                    <th>位置</th>
                    <th>开放时间</th>
                    <th>公告</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="canteen" items="${requestScope.canteens}">
                    <tr>
                        <td>${canteen.canteenID}</td>
                        <td>${canteen.name}</td>
                        <td>${canteen.location}</td>
                        <td>${canteen.openTime}</td>
                        <td>${canteen.notice}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>

</body>
</html>
