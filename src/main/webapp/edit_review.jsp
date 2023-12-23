<%--
  Created by IntelliJ IDEA.
  User: 韶光善良君
  Date: 2023/12/22
  Time: 21:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div id="main-content">
    <h2>编辑评论信息</h2>
    <!-- 假设已经获取了用户对象 user -->
    <form action="EditReview" method="post">
        <input type="hidden" name="reviewID" value="${requestScope.review.reviewID}">
        <label>
            评分:
            <c:forEach var="i" begin="1" end="5">
            <input type="radio" name="rating" id="${i}" value="${i}" <c:if test="${i == requestScope.review.rating}">checked</c:if> >
            <label for="${i}分">${i}分</label>
            </c:forEach>
        </label>
        <br>
        <label>
            评价者:
            <input type="text" name="sendername" value="${requestScope.sender.userName}">
        </label>
        <br>
        <label>
            评价菜品:
            <input type="text" name="dishname" value="${requestScope.dish.name}">
        </label>
        <br>
        <label>
            评价内容:
            <input type="text" name="comment" value="${requestScope.review.comment}">
        </label>
        <br>
        <label>
            回复:
            <input type="text" name="reply" value="${requestScope.review.reply}">
        </label>
        <br>
        <label>
            创建时间:(修改格式需如：2023-02-02 01:00:00)
            <input type="text" name="createDate" value="${requestScope.review.createDate}" placeholder="修改格式需如：2023-02-02 01:00:00">
        </label>
        <br>
        <input type="submit" value="更新">
    </form>
    <a href="admin_reviews_management.jsp">返回</a>
</div>
</body>
</html>
