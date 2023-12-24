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
    <link href="https://cdn.staticfile.org/twitter-bootstrap/5.1.1/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.staticfile.org/twitter-bootstrap/5.1.1/js/bootstrap.bundle.min.js"></script>

</head>
<body>
<jsp:include page="custom_sidebar.jsp" />
<div class="container">
    <h1 class="text-center mt-4 mb-4">社区论坛</h1>

    <form action="PostMessageServlet" method="post" enctype="multipart/form-data">
        <div class="mb-3">
            <label for="title" class="form-label">标题:</label>
            <input type="text" class="form-control" id="title" name="title" required>
        </div>
        <div class="mb-3">
            <label for="content" class="form-label">内容:</label>
            <textarea class="form-control" id="content" name="content" rows="4" required></textarea>
        </div>
        <div class="mb-3">
            <label for="image" class="form-label">上传图片:</label>
            <input type="file" class="form-control" id="image" name="image">
        </div>
        <button type="submit" class="btn btn-primary">发表</button>
    </form>

    <form action="SearchForumServlet" method="get" class="mt-4">
        <div class="input-group mb-3">
            <input type="text" class="form-control" name="searchQuery" placeholder="搜索标题或用户名">
            <button class="btn btn-outline-secondary" type="submit">搜索</button>
        </div>
    </form>

    <div class="mb-3">
        <button onclick="sort('time')" class="btn btn-secondary me-2">按时间排序</button>
        <button onclick="sort('popularity')" class="btn btn-secondary">按热度排序</button>
    </div>

    <div class="message-list">
        <c:forEach var="post" items="${requestScope.postList}">
            <div class="card mb-3">
                <div class="card-header d-flex justify-content-between align-items-center">
                    <h5 class="card-title">${post.title}</h5>
                    <span>发表人: ${post.author}</span>
                    <span>ID: ${post.userID}</span>
                    <span>${post.createDate}</span>
                </div>
                <div class="card-body">
                    <p class="card-text">${post.content}</p>
                </div>
                <div class="card-footer text-muted">
                    <span class="fw-bold">点赞数: ${post.like}</span>
                </div>
            </div>
        </c:forEach>
    </div>

    <form action="PostMessageServlet" method="Get">
        <input type="submit" class="btn btn-primary" value="点击查看历史帖子">
    </form>
</div>

    <script>
        function sort(type) {
            // 根据排序类型调整消息显示顺序
        }
        // 更多JavaScript逻辑
    </script>
</div>
</body>
</html>
