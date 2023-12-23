<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>评价详情</title>
    <!-- 在这里添加CSS和JavaScript的链接 -->
</head>
<body>
<!-- 在这里添加后端逻辑来获取和展示评论详情 -->
<%-- 假设已经从request获取到了review对象 --%>
<div>
    <h1>评论详情</h1>
    发送者: ${review.sender}<br>
    菜品: ${review.dish}<br>
    评分: ${review.score}<br>
    内容: ${review.content}<br>
    发送时间: ${review.sendTime}<br>
    <!-- 这里添加回复表单 -->
    <form action="replyToReview" method="post">
        <input type="hidden" name="reviewID" value="${review.id}" />
        <textarea name="reply" rows="4" required></textarea>
        <input type="submit" value="回复">
    </form>
</div>
</body>
</html>
