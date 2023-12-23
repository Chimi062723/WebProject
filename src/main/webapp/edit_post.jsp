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
    <title>Title</title>
</head>
<body>

<div id="main-content">
    <h2>编辑帖子信息</h2>
    <!-- 假设已经获取了用户对象 user -->
    <form action="EditPost" method="post">
        <label>
            帖子标题:
            <input type="text" name="title" value="${requestScope.post.title}">
        </label>
        <br>
        <label>
            帖子内容:
            <input type="text" name="content" value="${requestScope.post.content}">
        </label>
        <br>
        <label>
            营业时间:
            <input type="text" name="opentime" value="${requestScope.canteen.opentime}">
        </label>
        <br>
        <label>
            发送者:
            <input type="text" name="username" value="${requestScope.user.name}">
        </label>
        <br>
        <label>
            创建时间:
            <input type="text" name="createdate" value="${requestScope.canteen.createdate}">
        </label>
        <br>

        <input type="submit" value="更新">
    </form>
    <a href="admin_community_management.jsp">返回</a>
</div>
</body>
</html>
