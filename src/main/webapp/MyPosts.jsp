<%--
  Created by IntelliJ IDEA.
  User: ChiMi
  Date: 2023/12/24
  Time: 22:04
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${requestScope.username}的帖子</title>
    <link rel="stylesheet" href="css/customer_menu.css"/>
</head>
<body>
<c:forEach items="${requestScope.posts}" var="post">
    <div class="post">
        <span class="post-author">发表人：${requestScope.username}</span>
        <br>
        <span class="post-title">标题：${post.title}</span>
        <br>
        <span class="post-time">发表时间：${post.createDate}</span>
        <br>
        <span class="post-details">帖子内容：${post.content}</span>
        <br>
        <img src="res/${post.picture}" alt="${post.title}"/>
        <br>
        <span class="comment-list">
            <c:forEach items="${post.comments}" var="comment" varStatus="status">
                <span class="comment-item">
                    <span class="comment-count">回复：${status.count}</span>
                    <span class="comment-author">发表人：${comment.author.userName}</span>
                    <span class="comment-content">评论内容：${comment.content}</span>
                    <span class="comment-time">回复时间：${comment.createDate}</span>
                    <br>
                </span>
            </c:forEach>
        </span>
    </div>
</c:forEach>
<a href="GetPostServlet">返回</a>
</body>
</html>