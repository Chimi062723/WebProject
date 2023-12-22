<%--
  Created by IntelliJ IDEA.
  User: 韶光善良君
  Date: 2023/12/20
  Time: 22:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="css/customer_menu.css" />
</head>
<body>
<jsp:include page="custom_sidebar.jspf" />
<div id="main-content">
    <h2>社区论坛</h2>

    <!-- 发布消息表单 -->
    <form action="PostMessageServlet" method="post" enctype="multipart/form-data">
        标题: <input type="text" name="title">
        内容: <textarea name="content"></textarea>
        上传图片: <input type="file" name="image">
        <input type="submit" value="发表">
    </form>

    <!-- 搜索功能 -->
    <form action="SearchForumServlet" method="get">
        <input type="text" name="searchQuery" placeholder="搜索标题或用户名">
        <input type="submit" value="搜索">
    </form>

    <!-- 排序选项 -->
    <div>
        <button onclick="sort('time')">按时间排序</button>
        <button onclick="sort('popularity')">按热度排序</button>
    </div>

<%--TODO 后续改为使用fragment动态刷新帖子的页面--%>
    <form action="PostMessageServlet" method="Get">
        <input type="submit"   class="button" value="点击查看历史帖子">

    </form>
    <!-- 用户帖子显示区 -->
    <c:forEach var="post" items="${requestScope.postList}">
    <div id="messages">
        <!-- 动态加载帖子 -->
        <div class="message">
            <div class="message-header">
<%--                <span class="message-id">${post.postID}</span>--%>
                <span class="message-title"><h4>${post.title}</h4></span>
                <span class="message-author">发表人:${post.author}</span>
                <span class="message-author">ID:${post.userID}</span>
                <span class="message-time">${post.createDate}</span>
            </div>
            <div class="message-content">
                ${post.content}
            </div>
            <div>
                <span class="message-popularity">点赞数: ${post.like}</span>
            </div>
            <br>

    </div>
    </c:forEach>
    <script>
        function sort(type) {
            // 根据排序类型调整消息显示顺序
        }
        // 更多JavaScript逻辑
    </script>
</div>
</body>
</html>
