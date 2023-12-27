<%--
  Created by IntelliJ IDEA.
  User: ChiMi
  Date: 2023/12/26
  Time: 15:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
<link rel="icon" type="image/png" href="res/logo_icon.png">
    <title>选择饭店管理员需要管理的餐厅</title>
</head>
<body>
    <div>
        <label>
            <input type="text" name="resadmin" readonly value="${requestScope.name}">
        </label>
    </div>
</body>
</html>
