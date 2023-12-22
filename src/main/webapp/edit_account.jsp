<%--
  Created by IntelliJ IDEA.
  User: 韶光善良君
  Date: 2023/12/22
  Time: 13:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div id="main-content">
    <h2>编辑用户信息</h2>
    <!-- 假设已经获取了用户对象 user -->
    <form action="UpdateAccountServlet" method="post">
        用户名: <input type="text" name="username" value="${user.username}"><br>
        邮箱: <input type="text" name="email" value="${user.email}"><br>
        角色:
        <select name="role">
            <option value="student" ${user.role == 'student' ? 'selected' : ''}>学生</option>
            <option value="teacher" ${user.role == 'teacher' ? 'selected' : ''}>教师</option>
            <!-- 其他角色选项 -->
        </select><br>
        <input type="submit" value="更新">
    </form>
</div>
</body>
</html>
