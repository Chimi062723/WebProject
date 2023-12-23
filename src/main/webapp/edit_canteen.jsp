<%--
  Created by IntelliJ IDEA.
  User: 韶光善良君
  Date: 2023/12/22
  Time: 15:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div id="main-content">
    <h2>编辑餐厅信息</h2>
    <!-- 假设已经获取了用户对象 user -->
    <form action="EditCanteen" method="post">
        <input type="hidden" name="canteenID" value="${requestScope.canteen.canteenID}">
        <label>
            食堂名称:
            <input type="text" name="canteenName" value="${requestScope.canteen.name}">
        </label>
        <br>
        <label>
            食堂地址:
            <input type="text" name="location" value="${requestScope.canteen.location}">
        </label>
        <br>
        <label>
            营业时间:
            <input type="text" name="opentime" value="${requestScope.canteen.openTime}">
        </label>
        <br>
        <label>
            食堂负责人:
            <input type="text" name="managerName" value="${requestScope.manager.userName}">
        </label>
        <br>
        <label>
            食堂公告:
            <input type="text" name="notice" value="${requestScope.canteen.notice}">
        </label>
        <br>
        <input type="submit" value="更新">
    </form>
    <a href="javascript:history.back()">返回</a>
</div>
</body>
</html>
