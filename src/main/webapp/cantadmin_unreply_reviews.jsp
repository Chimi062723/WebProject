<%--
  Created by IntelliJ IDEA.
  User: 韶光善良君
  Date: 2023/12/26
  Time: 0:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>待回复评论</title>
    <link rel="stylesheet" href="css/table.css">
</head>
<body>
<div id="content">

    <h1>待回复评论</h1>
    <a href="DashboardRefresh">返回</a>
    <form>
        <table border="1" id="table">
            <tr>
                <th>ID</th>
                <th>评价方</th>
                <th>菜品</th>
                <th>评分</th>
                <th>评论</th>
                <th>发布时间</th>
                <th>回复</th>
                <th>操作</th>
            </tr>
            <c:forEach var="unreview" items="${sessionScope.unreviews}">
                <tr>
                    <td>${unreview.reviewID}</td>
                    <td>${unreview.sender.userName}</td>
                    <td>${unreview.dish.name}</td>
                    <td>${unreview.rating}</td>
                    <td>${unreview.comment}</td>
                    <td>${unreview.createDate}</td>
                    <td><label for="reply"></label><input id="reply" name="reply${unreview.reviewID}" type="text" placeholder="输入回复"></td>
                    <td>
                        <input type="submit" formaction="ReplyReview?id=${unreview.reviewID}" formmethod="post" value="回复">
                    </td>
                </tr>
            </c:forEach>
        </table>
    </form>
</div>
</body>
</html>
