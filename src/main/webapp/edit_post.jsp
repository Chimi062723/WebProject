<%--
  Created by IntelliJ IDEA.
  User: 韶光善良君
  Date: 2023/12/22
  Time: 16:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>编辑帖子信息</title>
    <link rel="stylesheet" href="css/edit_post.css">
</head>
<body>

<div id="main-content">
    <h2>编辑帖子信息</h2>
    <!-- 假设已经获取了用户对象 user -->
    <form action="EditPost" method="post">
        <input type="hidden" name="postID" value="${requestScope.post.userID}">
        <label>
            帖子标题:
            <input type="text" name="title" value="${requestScope.post.title}">
        </label>
        <br>
        <label>
            帖子内容:
            <input type="text" name="content" value="${requestScope.post.content}">
        </label>
        <label>
            发送者:
            <input type="text" name="username" value="${requestScope.user.userName}">
        </label>
        <br>
        <label>
            发送时间:
            <input type="text" name="createdate" value="${requestScope.post.createDate}">
        </label>
        <br>
        <input type="submit" value="更新">
    </form>
    <a href="javascript:history.back()">返回</a>
</div>
</body>
</html>
