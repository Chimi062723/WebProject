<%--
  Created by IntelliJ IDEA.
  User: 韶光善良君
  Date: 2023/12/19
  Time: 0:46
  To change this template use File | Settings | File Templates.
  需要传入的变量：
  compliant: 管理员处理的投诉信息
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<link rel="icon" type="image/png" href="res/logo_icon.png">
    <title>Title</title>
    <link rel="stylesheet" href="css/cantadmin_menu.css">
    <link rel="stylesheet" href="css/table.css">
</head>
<body>
<jsp:include page="backToTopComponent.jsp" />
<jsp:include page="cantadmin_sidebar.jsp" />
<div id="main-content">
    <div id="content">
        <h1>投诉处理</h1>
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
            <c:forEach var="complaint" items="${requestScope.complaints}">
                <tr>
                    <td>${complaint.complaintID}</td>
                    <td>${complaint.user.userName}</td>
                    <td>${complaint.canteen.name}</td>
                    <td>${complaint.content}</td>
                    <td>${complaint.createDate}</td>
                    <td>
                        <c:if test="${complaint.status == 0}">未处理</c:if>
                        <c:if test="${complaint.status == 1}">已处理</c:if>
                    </td>
                    <td>
                        <form action="ComplaintHandle?" method="post">
                            <input type="hidden" name="action" value="all">
                            <input type="hidden" name="complaintID" value="${complaint.complaintID}">
                            <c:if test="${complaint.status == 0}">
                                <input type="submit" value="处理">
                            </c:if>
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
</body>
</html>
