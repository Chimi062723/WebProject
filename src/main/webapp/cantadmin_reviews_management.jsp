<%--
  Created by IntelliJ IDEA.
  User: 韶光善良君
  Date: 2023/12/19
  Time: 0:45
  To change this template use File | Settings | File Templates.
  需要的变量：
  _reviews: 评价信息_
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<link rel="icon" type="image/png" href="res/logo_icon.png">
    <title>Title</title>
    <link rel="stylesheet" href="css/cantadmin_menu.css">
    <link rel="stylesheet" href="css/table.css">
</head>
<body>
<jsp:include page="backToTopComponent.jsp" />
<jsp:include page="cantadmin_sidebar.jsp" />
<div id="main-content" class="clearfix">

    <div id="content">

        <h1>全部评论</h1>
        <form>
            <input type="hidden" name="action" value="all">
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
                <c:forEach var="review" items="${requestScope.reviews}">
                    <tr>
                        <td>${review.reviewID}</td>
                        <td>${review.sender.userName}</td>
                        <td>${review.dish.name}</td>
                        <td>${review.rating}</td>
                        <td>${review.comment}</td>
                        <td>${review.createDate}</td>
                        <td><label for="reply"></label>
                            <input id="reply" name="reply${review.reviewID}" type="text" value="${review.reply}" placeholder="输入回复">
                        </td>
                        <td>
                            <input type="submit" formaction="ReplyReview?id=${review.reviewID}" formmethod="post" value="回复">
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </form>
    </div>
</div>
<script>
</script>
</body>
</html>