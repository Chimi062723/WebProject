<%--
  Created by IntelliJ IDEA.
  User: 韶光善良君
  Date: 2023/12/24
  Time: 20:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>我的投诉</title>
    <link rel="stylesheet" href="css/my_complaint.css">
</head>
<body>
<div class="container">
    <a href="GetPostServlet" class="back-button">返回</a>
    <h1>我的投诉</h1>
    <table>
        <thead>
        <tr>
            <th>投诉ID</th>
            <th>食堂名称</th>
            <th>投诉内容</th>
            <th>状态</th>
            <th>投诉时间</th>
            <!-- 可以根据需要添加更多列 -->
        </tr>
        </thead>
        <tbody>
        <%-- 假设你的投诉信息存储在一个名为 complaints 的列表中 --%>
        <c:forEach items="${requestScope.complaints}" var="complaint">
            <tr>
                <td>${complaint.complaintID}</td>
                <td>${complaint.canteen.name}</td>
                <td>${complaint.content}</td>
                <c:if test="${complaint.status == 0}">
                    <td>未处理</td>
                </c:if>
                <c:if test="${complaint.status == 1}">
                    <td>已处理</td>
                </c:if>
                <td>${complaint.createDate}</td>
                <!-- 根据需要添加更多列 -->
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>

