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
<link rel="icon" type="image/png" href="res/logo_icon.png">
    <title>编辑用户信息</title>
    <link rel="stylesheet" href="css/edit_account.css">
</head>
<body>

<div id="main-content">
    <h2>编辑用户信息</h2>
    <!-- 假设已经获取了用户对象 user -->
    <form action="EditAccount" method="post">
        <label>
            用户名:
            <input type="text" name="username" value="${requestScope.user.userName}">
        </label>
        <br>
        <label>
            邮箱:
            <input type="text" name="email" value="${requestScope.user.email}">
        </label>
        <br>
        <label>
            角色:
            <select id="role" name="role" onchange="show()">
                <option value="sys_admin" ${requestScope.user.role == 'sys_admin' ? 'selected' : ''}>系统管理员</option>
                <option value="res_admin" ${requestScope.user.role == 'res_admin' ? 'selected' : ''}>食堂管理员</option>
                <option value="normal_user" ${requestScope.user.role == 'normal_user' ? 'selected' : ''}>普通用户</option>
                <!-- 其他角色选项 -->
            </select>
        </label>
        <label id="display" class="hide">
            食堂id:
            <input type="number" name="res">
        </label>
        <br>
        <input type="submit" value="更新">
    </form>

    <a href="javascript:history.back()">返回</a>
</div>
</body>
<script>
    function show(){
        const role = document.getElementById("role").value;
        const res = document.getElementById("display");
        if(role==="res_admin"){
            res.classList.remove("hide");
        }else {
            res.classList.add("hide")
        }
    }
</script>
<style>
    .hide{
        display: none;
    }
</style>
</html>
