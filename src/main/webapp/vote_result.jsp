<%--
  Created by IntelliJ IDEA.
  User: 韶光善良君
  Date: 2023/12/27
  Time: 1:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>投票统计</title>
    <link rel="stylesheet" href="css/table.css">
</head>
<body>
<div id="content">
    <a href="VoteInfoRefresh" class="back-button">返回</a>
    <h1>投票结果统计</h1>
    <h2>投票标题: ${requestScope.title}</h2>
    <h2>投票问题: ${requestScope.question}</h2>
    <h2>创建时间: ${requestScope.createDate}</h2>
    <table border="1" id="table">
        <tr>
            <th>投票用户</th>
            <th>选项</th>
        </tr>
        <c:forEach var="voteResult" items="${requestScope.voteResults}">
            <tr>
                <td>${voteResult.userName}</td>
                <td>${voteResult.answer}</td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
