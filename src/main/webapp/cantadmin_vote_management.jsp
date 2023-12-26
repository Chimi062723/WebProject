<%--
  Created by IntelliJ IDEA.
  User: 韶光善良君
  Date: 2023/12/19
  Time: 0:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="css/cantadmin_menu.css">
    <link rel="stylesheet" href="css/table.css">
</head>
<body>
<jsp:include page="cantadmin_sidebar.jsp"/>
<div id="main-content" class="clearfix">
    <form action="AddVote" method="post">
        <table border="1" id="table">
            <tr>
                <th>ID</th>
                <th>标题</th>
                <th>问题</th>
                <th>创建时间</th>
                <th>查看结果</th>
            </tr>
            <c:forEach var="vote" items="${requestScope.votes}">
                <tr>
                    <td>${vote.pollId}</td>
                    <td>${vote.title}</td>
                    <td>${vote.question}</td>
                    <td>${vote.createDate}</td>
                    <td>
                        <form>
                            <input type="hidden" name="pollID" value="${vote.pollId}">
                            <input type="hidden" name="title" value="${vote.title}">
                            <input type="hidden" name="question" value="${vote.question}">
                            <input type="hidden" name="createDate" value="${vote.createDate}">
                            <input type="submit" value="查看投票结果" formaction="GetVoteResult" formmethod="get">
                        </form>
                    </td>
                </tr>
            </c:forEach>
            <tr>
                <td>New</td>
                <td><label for="title"></label><input id="title" type="text" name="newtitle" placeholder="输入新的投票标题"></td>
                <td><label for="question"></label><input id="question" type="text" name="newquestion" placeholder="输入新的投票问题"></td>
                <td>系统自动生成</td>
                <td><input type="submit" value="提交"></td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
