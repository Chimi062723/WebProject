<%--
  Created by IntelliJ IDEA.
  User: 韶光善良君
  Date: 2023/12/26
  Time: 0:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>待处理投诉</title>
    <link rel="stylesheet" href="css/table.css">
</head>
<body>
<div id="content">
    <h1>待处理投诉</h1>
    <a href="DashboardRefresh">返回</a>

    <table border="1" id="table">
        <tr>
            <th>ID</th>
            <th>投诉方</th>
            <th>投诉食堂</th>
            <th>内容</th>
            <th>创建时间</th>
            <th>状态</th>
            <th>操作</th>
        </tr>
        <c:forEach var="uncomplaint" items="${sessionScope.uncomplaints}">
            <tr>
                <td>${uncomplaint.complaintID}</td>
                <td>${uncomplaint.user.userName}</td>
                <td>${uncomplaint.canteen.name}</td>
                <td>${uncomplaint.content}</td>
                <td>${uncomplaint.createDate}</td>
                <td>未处理</td>
                <td>
                    <form action="ComplaintHandle?" method="post">
                        <input type="hidden" name="complaintID" value="${uncomplaint.complaintID}">
                        <input type="submit" value="处理">
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>

</div>
</body>
</html>
